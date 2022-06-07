package battleship;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Asus
 */
public class Ship {
    private int coorX,coorY;
    private ShipSize size;
    private Cell[] ship;
    public boolean isDamaged = false;
    public boolean vertical ;
    public void isDamaged(int x){
       Cell[] temp = new Cell[ship.length];
       
       if (x>=0){
          for(int i=0;i<temp.length;i++){
              if(i==x) continue;
              temp[i] = ship[i];
          }
         
       }
       else return;
      /* boolean empty = true;
        for (int i=0; i<temp.length; i++) {
          if (temp[i] != null) {
            empty = false;
            break;
          }
        }
        if(empty) System.out.println("he he");*/
       setShip(temp);
    }
    
    public void setShip(Cell[] ship) {
        this.ship = ship;
    }
    public int indexAt(int x, int y){
        for(int j = 0; j < this.ship.length;j++){
            if(ship[j]==null) continue;
                    if(x==this.ship[j].getCoorX() && y==ship[j].getCoorY()){
                        return j;
                    }
                }
        return -1;
    }
    public ShipSize getSize() {
        return size;
    }

    public Cell[] getShipSize() {
        return ship;
    }

    public void setCoorX(int coorX) {
        this.coorX = coorX;
    }

    public void setCoorY(int coorY) {
        this.coorY = coorY;
    }
    public Ship(int x,int y){
        coorX = x;
        coorY = y;
        
        
    }

    public void setSize(ShipSize size){
        if(size == ShipSize.LARGE){
            ship = new Cell[5];
        }
        else if(size == ShipSize.QUITELARGE){
            ship = new Cell[4];
        }
        else if(size == ShipSize.MEDIUM){
            ship = new Cell[3];
        }
        else{
            ship = new Cell[2];
        }
        for(int i=0;i<ship.length;i++){
            if(!vertical)
            ship[i] = new Cell(coorX+i,coorY);
            else ship[i] = new Cell(coorX,coorY+i);
        }
    }
    public void update(){

    }
    public void draw(Graphics g){
        if(!vertical){
             for(int i=0;i<ship.length;i++){
                 if(ship[i]!=null){
                      g.setColor(Color.gray);
                       g.fillRect((coorX+i)*Board.cellSize, coorY*Board.cellSize, Board.cellSize, Board.cellSize);
                       
                 }
            
        }
             
        }
        else{
             for(int i=0;i<ship.length;i++){
             g.setColor(Color.gray);
             g.fillRect(coorX*Board.cellSize,(coorY+i)*Board.cellSize, Board.cellSize, Board.cellSize);
             }
        }
        
       
    }

    public int getCoorX() {
        return coorX;
    }

    public int getCoorY() {
        return coorY;
    }
}
