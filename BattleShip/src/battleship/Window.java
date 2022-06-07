/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author Asus
 */
public class Window {
    private JFrame frame;
    private Canvas canvas;
    private int width = 640;
    private int height = 360;
    
    private static Window window;
    private Window(){
        createwindow();
    }
    public static Window getWindow(){
        if(window == null) window = new Window();
        return window;
    }
    public Canvas getCanvas(){
        return canvas;
    }

    private void createwindow(){
        frame = new JFrame("Battle Ship");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        canvas =  new Canvas();
        canvas.setFocusable(false);
        canvas.setMinimumSize(new Dimension(frame.getWidth(),frame.getHeight()));
        canvas.setMaximumSize(new Dimension(frame.getWidth(),frame.getHeight()));
        canvas.setPreferredSize(new Dimension(frame.getWidth(),frame.getHeight()));
        frame.add(canvas);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public JFrame getFrame(){
        return frame;
    }
}
