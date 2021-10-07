/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab6_java;

import static com.mycompany.lab6_java.DrawingPanel.H;
import static com.mycompany.lab6_java.DrawingPanel.W;
import static java.awt.BorderLayout.EAST;
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;
import static java.awt.BorderLayout.WEST;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.MenuComponent;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author Bogdan
 */
public class ControlPanel extends JPanel {

    final MainFrame frame;
    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");
    JButton resetBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");
    JButton deleteBtn = new JButton("Delete");
    JButton regularBtn = new JButton("Regular Polygon");
    JButton nodeBtn = new JButton("Node Shape");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        setLayout(new GridLayout(1, 4));
        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
        resetBtn.addActionListener(this::reset);
        deleteBtn.addActionListener(this::delete);
        exitBtn.addActionListener(this::exit);
        regularBtn.addActionListener(this::regularPoligon);
        nodeBtn.addActionListener(this::ellipse);
        add(regularBtn, SOUTH);
        add(nodeBtn, SOUTH);
        add(saveBtn, SOUTH);
        add(loadBtn, SOUTH);
        add(resetBtn, SOUTH);
        add(deleteBtn, SOUTH);
        add(exitBtn, SOUTH);
    }

    private void save(ActionEvent e) {
        final JFileChooser j = new JFileChooser();
        int returnVal = j.showSaveDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION)
            try {
                ImageIO.write(frame.canvas.image, "PNG", new File(j.getSelectedFile().getAbsolutePath())); //salvez unde a ales el
            } catch (IOException ex) { System.err.println(ex); }
    }
    
    private void load(ActionEvent e){
        final JFileChooser j = new JFileChooser();
        int returnVal = j.showSaveDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION)
        try {
            frame.canvas.image = ImageIO.read(new File(j.getSelectedFile().getAbsolutePath())); //repun imaginea de la adresa aleasa de el
            frame.canvas.repaint();
        } catch (IOException ex) { System.err.println(ex); }
    }
    
    private void reset(ActionEvent e){
        frame.canvas.image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        frame.canvas.graphics = frame.canvas.image.createGraphics();
        frame.canvas.graphics.setColor(Color.WHITE);
        frame.canvas.graphics.fillRect(0, 0, W, H);
        frame.canvas.repaint();
    }
    
    public void delete(ActionEvent e){ //sterg ultimul element desenat
        frame.canvas.image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        frame.canvas.graphics = frame.canvas.image.createGraphics();
        frame.canvas.graphics.setColor(Color.WHITE);
        frame.canvas.graphics.fillRect(0, 0, W, H);
        if(!frame.shapes.isEmpty()){
            frame.shapes.remove(frame.shapes.size()-1);
            frame.canvas.draw(frame.shapes);
        }
        frame.canvas.repaint();
    }
    
    private void regularPoligon(ActionEvent e){ //setez ca doreste sa creeze un poligon
        frame.canvas.setRegularPoligon();
    }
    
    private void ellipse(ActionEvent e){ //setez ca vrea sa creeze un cerc
        frame.canvas.setEllipse();
    }
    
    private void exit(ActionEvent e){
        System.exit(1);
    }
    
}
