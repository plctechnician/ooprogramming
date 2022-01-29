package oop.swing.imagecomparator;

import java.awt.*;

public class ImageComparatorStandard extends AbstractImageComparator {
    public ImageComparatorStandard() {
        super();
    }

    public void computeSimilarity() {
        Dimension overlap = getOverlap();

        double d = 0.0;
        for (int x = 0; x < overlap.width; x++) {
            for (int y = 0; y < overlap.height; y++) {
                Color c1 = new Color(source.getRGB(x, y));
                Color c2 = new Color(target.getRGB(x, y));
                d += Math.abs(c1.getGreen() - c2.getGreen()) +
                        Math.abs(c1.getRed() - c2.getRed()) +
                        Math.abs(c1.getBlue() - c2.getBlue());
            }
            changes.firePropertyChange("completed", 0, 100 * x / (overlap.width-1));
            similarity = 1 - (d / (double) (overlap.width * overlap.height * 255 * 3));
        }
    }
}
