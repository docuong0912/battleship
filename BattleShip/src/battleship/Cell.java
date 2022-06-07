/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

import java.awt.Rectangle;

/**
 *
 * @author Asus
 */
public class Cell  {
    private int coorX,coorY;
    public Rectangle bound;
    public int id;
    public int index;
    public boolean isHovered =false;
    public boolean hit ;
    public boolean isChoosen = false;
    public boolean visited ;
    public Cell(int coorX,int coorY){
        bound = new Rectangle(coorX*Board.cellSize,coorY*Board.cellSize,Board.cellSize,Board.cellSize);
        this.coorX = coorX;
        this.coorY = coorY;
    }
    public void setCoor(int x,int y){
        coorX = x;
        coorY = y;
    }
    public void setRange(int id){
        this.id =id;
    }

    public int getRange() {
        return id;
    }
    public int getCoorX() {
        return coorX;
    }

    public int getCoorY() {
        return coorY;
    }
}
