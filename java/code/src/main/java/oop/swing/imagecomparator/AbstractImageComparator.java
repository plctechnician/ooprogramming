package oop.swing.imagecomparator;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public abstract class AbstractImageComparator implements ImageComparator {
    PropertyChangeSupport changes;
    BufferedImage source;
    BufferedImage target;
    double similarity;
    double coverage;

    public AbstractImageComparator() {
        this.changes = new PropertyChangeSupport(this);
    }

    void computeCoverage() {
        coverage = (source.getWidth() * source.getHeight()) / (float) (target.getWidth() * target.getHeight());
        coverage = coverage < 1 ? coverage : 1 / coverage;
    }

    abstract void computeSimilarity();

    Dimension getOverlap() {
        return new Dimension(Math.min(source.getWidth(), target.getWidth()),
                Math.min(source.getHeight(), target.getHeight()));
    }

    public void setImages(BufferedImage source, BufferedImage target) {
        this.source = source;
        this.target = target;
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        changes.addPropertyChangeListener(l);
    }

    public void removeAllPropertyChangeListener() {
        for (PropertyChangeListener listener : changes.getPropertyChangeListeners()) {
            changes.removePropertyChangeListener(listener);
        }
    }

    public double getCoverage() {
        return coverage;
    }

    public double getSimilarity() {
        return similarity;
    }

    public void run() {
        computeCoverage();
        computeSimilarity();
    }
}