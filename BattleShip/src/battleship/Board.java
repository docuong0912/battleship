
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Asus
 */
public class Board {
    public static int width = 10,height = 10;
    public static int cellSize=21;
    private Cell[][] board;
    public int startX,startY;
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    public void generateBoard(){
        int index=1;
        for(int i =0;i<width;i++){
            for (int j=0;j<height;j++){
                board[i][j] = new Cell(i+startX,j+startY);
                board[i][j].index = index;
                if(i==width-1)board[i][j].setRange(0);
                else if( i == width-2 ){
                     board[i][j].setRange(1);
                }
                else if(i == width-3)
                board[i][j].setRange(3);
                 else if(i == width-4)
                board[i][j].setRange(4);
                 else board[i][j].setRange(5);
                if(j==height-1)
                    board[i][j].setRange(board[i][j].id*10);
                else if(j==height-2)board[i][j].setRange(board[i][j].id*10+1);
                else if(j==height-3)board[i][j].setRange(board[i][j].id*10+3);
                else if(j==height-4)board[i][j].setRange(board[i][j].id*10+4);
                else board[i][j].setRange(board[i][j].id*10+5);
                index++;
            }}
    }
    
    public Board(int x,int y){
        startX = x;
        startY = y;
        board = new Cell[width][height];
        generateBoard();
        
 
    }

    public Cell SelectedAt(int index){       
        for(int i = 0 ;i<width;i++){
            for(int j=0;j<height;j++){
                try{
                    if(board[i][j].index == index){
                        return board[i][j];
                    }
                }
                catch(NullPointerException ex){
                    System.out.println("null when selecting index at class board.java");
                }
            }
        }
        return null;
    }
    public Cell[][] getBoard() {
        return board;
    }
   
    public void draw(Graphics g){
        for(int i =0;i<width;i++){
            for (int j=0;j<height;j++){
                board[i][j].isHovered=board[i][j].bound.contains(GameLoop.getGame().getMouseInput().getMouseX(),GameLoop.getGame().getMouseInput().getMouseY());
                if(board[i][j].isChoosen){
                    g.drawLine((i+startX)*cellSize, (j+startY)*cellSize, (i+1+startX)*cellSize, (j+1+startY)*cellSize);
                    g.drawLine((i+1+startX)*cellSize, (j+startY)*cellSize, (i+startX)*cellSize, (j+1+startY)*cellSize);
                }
                else if(board[i][j].hit){
                    g.drawOval((i+startX)*cellSize, (j+startY)*cellSize, cellSize, cellSize);
                }
                //if( i==23 - startX ) g.fillRect((i+startX)*cellSize, (j+startY)*cellSize, cellSize, cellSize);
                if(board[i][j].isHovered)
                    g.setColor(Color.red);
                
                
                else
                g.setColor(Color.black);
                g.drawRect((i+startX)*cellSize, (j+startY)*cellSize, cellSize, cellSize);
               // g.drawString(String.valueOf(board[i][j].id),(i+startX)*cellSize, (j+startY)*cellSize);
            }
        }
        
        
    }

}
