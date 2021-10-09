package org.nbicocchi.swing.imagecomparator;

import java.awt.*;

public class ImageComparatorBinary extends AbstractImageComparator {
    public ImageComparatorBinary() {
        super();
    }

    public void computeSimilarity() {
        Dimension overlap = getOverlap();

        double d = 0.0;
        for (int x = 0; x < overlap.width; x++) {
            for (int y = 0; y < overlap.height; y++) {
                if ((source.getRGB(x, y) - target.getRGB(x, y)) != 0) {
                    similarity = 0.0;
                    break;
                }
            }
            changes.firePropertyChange("completed", 0, 100 * x / (overlap.width-1));
        }
        similarity = 1.0;
    }
}
