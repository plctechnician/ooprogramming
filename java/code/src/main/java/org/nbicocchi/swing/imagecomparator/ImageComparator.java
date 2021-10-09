package org.nbicocchi.swing.imagecomparator;

import java.awt.image.BufferedImage;
import java.beans.PropertyChangeListener;

public interface ImageComparator extends Runnable {
    void setImages(BufferedImage source, BufferedImage target);
    void addPropertyChangeListener(PropertyChangeListener l);
    void removeAllPropertyChangeListener();
    double getCoverage();
    double getSimilarity();
}
