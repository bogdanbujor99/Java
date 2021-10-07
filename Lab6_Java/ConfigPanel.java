/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab6_java;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author Bogdan
 */
public class ConfigPanel extends JPanel {

    final MainFrame frame;
    JLabel[] sidesLabel = new JLabel[2];
    JSpinner[] sidesField = new JSpinner[2];
    JComboBox colorCombo; // the color of the shape
    String colorInfo;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        sidesLabel [0] = new JLabel("Number of sides: ");
        sidesField [0] = new JSpinner (new SpinnerNumberModel(0, 0, 100, 1));
        sidesLabel [1] = new JLabel("Size number: ");
        sidesField [1] = new JSpinner (new SpinnerNumberModel(0, 0, 100, 1));
        String[] color = {"Random", "Black"};
        colorCombo = new JComboBox(color);

        for(int i = 0; i < 2; i++){
            add(sidesLabel[i]);
            add(sidesField[i]);
        }
        add(colorCombo);
        
        colorCombo.addActionListener((ActionEvent e) -> {
            colorInfo = (String) colorCombo.getItemAt(colorCombo.getSelectedIndex());
        });
    }
}
