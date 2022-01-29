package oop.swing.bouncingballs;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

public class ControlPanel extends JPanel implements ChangeListener, ActionListener {
    final JCheckBox pause;
    final JSlider slider;
    Properties properties;

    public ControlPanel(Properties properties) {
        super();
        this.properties = properties;

        pause = new JCheckBox("pause");
        pause.addActionListener(this);
        add(pause);

        slider = new JSlider(10, 100);
        slider.setMajorTickSpacing(10);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.addChangeListener(this);
        add(slider);

        pause.setSelected(properties.getProperty("pause").equals("on"));
        slider.setValue(Integer.parseInt(properties.getProperty("fps")));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        properties.setProperty("pause", pause.isSelected() ? "on" : "off");
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource() == this.slider) {
            properties.setProperty("fps", Integer.toString(slider.getValue()));
        }
    }
}
