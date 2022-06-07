/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;


import static battleship.Preparation.vertical;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author Asus
 */
public class MouseInput implements MouseListener,MouseMotionListener {
    private boolean leftPressed,rightPressed;
    private int MouseX,MouseY;
    public MouseInput(){

    }

    @Override
    public void mouseClicked(MouseEvent e) {
       }

    public boolean isLeftPressed() {
        return leftPressed;
    }

    public boolean isRightPressed() {
        return rightPressed;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1){
            leftPressed = true;
        }
        else if(e.getButton() == MouseEvent.BUTTON3){
            rightPressed = true;
        }
        
     }

    @Override
    public void mouseReleased(MouseEvent e) {
         if(e.getButton() == MouseEvent.BUTTON1){
             State.getGameState().onClick();
            leftPressed = false;
        }
        else if(e.getButton() == MouseEvent.BUTTON3){
            rightPressed = false;
            Preparation.vertical = !vertical;
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
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        MouseX = e.getX();
        MouseY = e.getY();
    }

    public int getMouseX() {
        return MouseX;
    }

    public int getMouseY() {
        return MouseY;
    }
    
}
