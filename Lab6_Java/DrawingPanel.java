/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab6_java;

import java.awt.Color;
import static java.awt.Color.BLACK;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author Bogdan
 */
public class DrawingPanel extends JPanel {
    
    final MainFrame frame;
    final static int W = 800, H = 600;
    BufferedImage image;
    Graphics2D graphics;
    boolean regularPolygon = true;
    boolean ellipse = false;
    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        init();
    }

    private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, W, H);
    }

    private void init() {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawShape(e.getX(), e.getY());
                repaint();
            } 
        });
    }

    private void drawShape(int x, int y) {
        Random rand = new Random();
        int radius = (int) frame.configPanel.sidesField[1].getValue();
        int sides = (int) frame.configPanel.sidesField[0].getValue();
        Color color;
        Random random = new Random();
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        Color randomColor = new Color(r, g, b);
        if (frame.configPanel.colorInfo.equals("Random")) { //setez culoarea
            color = randomColor;
        } else {
            color = BLACK;
        }
        graphics.setColor(color); 
        if(regularPolygon==true){ //daca a ales polygon 
        graphics.fill((Shape) new RegularPolygon(x, y, radius, sides));
        frame.shapes.add((Shape) new RegularPolygon(x, y, radius, sides));
        frame.colors.add(color);
        }
        if(regularPolygon==false){ //daca a ales un cerc
            graphics.fill((Shape) new NodeShape(x, y, radius));
            frame.shapes.add((Shape) new NodeShape(x, y, radius));
            frame.colors.add(color);
        }
    }
    
    public void draw (List<Shape> list){ //deseneaza toate shape-urile din lista
        for(Shape i:list){
            graphics.setColor(frame.colors.get(list.indexOf(i)));
            graphics.fill(i);
        }
    }
    
    public void setRegularPoligon(){
        regularPolygon = true;
        ellipse = false;
    }
    
    public void setEllipse(){
        ellipse = true;
        regularPolygon = false;
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }

}
