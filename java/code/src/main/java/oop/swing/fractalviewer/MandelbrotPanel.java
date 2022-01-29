package oop.swing.fractalviewer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.*;

/**
 * This is a fairly simple subclass of jawa.awt.JPanel that can display a part
 * of the Mandelbrot set. The interval bounds and the depth limit can be set at
 * run time to select which part you want to be shown.
 */
public class MandelbrotPanel extends JPanel implements MouseListener, MouseMotionListener {
    /**
     * Colour table for this component (actually the BufferedImage)
     */
    protected ColorModel color_table;

    /**
     * Last rendered Image for this component (cached between paint()
     * invocations), initially null
     *
     * @see #paint(Graphics)
     */
    protected BufferedImage image;

    /**
     * Current depth limit for the Mandelbrot iteration
     */
    protected int limit;

    /**
     * Current interval bounds (scaled to the panel size)
     */
    protected double re_min = -2.00, re_max = 0.50, im_min = -1.25, im_max = 1.25;

    /**
     * Mouse click location and current position
     */
    int x, y, start_x, start_y;

    /**
     * Initialize a new MandelbrotPanel: Create and fill an IndexColorModel with
     * the colour table and add a Mouse(Motion)Listener to the JPanel. The
     * initial interval is [-2, 0.5] x [-1.25, 1.25].
     *
     * @param limit depth limit for iteration
     */
    public MandelbrotPanel(int limit) {
        addMouseListener(this);
        addMouseMotionListener(this);

        if (limit < 0)
            throw new IllegalArgumentException("invalid limit");
        this.limit = limit;
        this.color_table = ColorModel.getRGBdefault();
    }

    /**
     * Reset the interval of this MandelbrotPanel to the given values.
     *
     * @throws IllegalArgumentException if the interval is empty
     */
    public void setInterval(double re_min, double re_max,
                            double im_min, double im_max) {
        if (re_min >= re_max || im_min >= im_max)
            throw new IllegalArgumentException("invalid interval");

        this.re_min = re_min;
        this.re_max = re_max;
        this.im_min = im_min;
        this.im_max = im_max;
        image = null;                // invalidate image
        repaint();                // schedule repaint
    }

    /**
     * Redraw this component. Recalculates the BufferedImage if needed (the
     * BufferedImage is cached for efficiency reasons) and draws it into the
     * component. This implementation uses a simple 8-bit IndexColorModel and a
     * PackedRaster (the type of raster really doesn't matter here).
     */
    @Override
    public void paintComponent(Graphics g) {
        System.out.println("Hello!");
        int width = getWidth();             // component width
        int height = getHeight();           // component height

        // need to recalculate the image?
        if (image == null || image.getWidth() != width || image.getHeight() != height) {
            image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            double re_size = re_max - re_min;   // interval width
            double im_size = im_max - im_min;   // interval heigth
            int x, y;

            for (x = 0; x < width; ++x) {        // fill byte array
                for (y = 0; y < height; ++y) {
                    int depth = iterate(re_size * x / width + re_min,
                            im_size * y / height + im_min, limit);
                    image.setRGB(x, y, depth * 7);
                    // * 7 is a stupid hack for getting decent colors
                }
            }
        }
        g.drawImage(image, 0, 0, this);
        g.setColor(Color.white);
        if (x > start_x && y > start_y) {
            g.drawRect(start_x, start_y, x - start_x, y - start_y);
        }
    }

    /**
     * Perform the Mandelbrot iteration for a single complex coordinate until
     * the iteration terminates or the given depth limit is reached.
     *
     * @param re_c,im_c current complex coordinate
     * @param limit     depth limit for iteration
     * @return number of iterations performed (0 ... <tt>limit</tt> + 1)
     */
    public int iterate(double re_c, double im_c, int limit) {
        int depth = 0;                // number of iterations
        double re_z = 0, im_z = 0;        // current value of z
        double re_z_sqr = 0, im_z_sqr = 0;    // squared values

        // iterate until |z| >= 2 or limit exceeded
        while (re_z_sqr + im_z_sqr < 4 && ++depth <= limit) {
            re_z_sqr = re_z * re_z;        // calculate squares
            im_z_sqr = im_z * im_z;

            im_z = 2 * re_z * im_z + im_c;    // perform iteration
            re_z = re_z_sqr - im_z_sqr + re_c;
        }
        return depth;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (SwingUtilities.isRightMouseButton(e)) {
            setInterval(-2.00, 0.50, -1.25, 1.25);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        start_x = e.getX();
        start_y = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (x > start_x && y > start_y) {
            double re_size = re_max - re_min;
            double im_size = im_max - im_min;
            int width = getWidth();    // component width
            int height = getHeight();    // component height

            // compensate for mirrored coordinate system
            start_y = height - 1 - start_y;
            y = height - 1 - y;

            setInterval(re_size * start_x / width + re_min,
                    re_size * x / width + re_min,
                    im_size * y / height + im_min,
                    im_size * start_y / height + im_min);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
