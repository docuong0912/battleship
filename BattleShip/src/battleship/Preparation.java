/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 *
 * @author Asus
 */
public class Preparation extends State {
    Random ran = new Random();
    public static boolean vertical;
    @Override
    public Player getPlayer() {
        return player;
    }

    private int xCoor[] ;
    private int yCoor[] ;

    public Preparation(){
        
        player = new HumanPlayer();
        com = new Com();
        board = new Board(5,5);
        boardCom = new Board(20,5);
    }
  
    @Override
    public void update(){
        if(State.turn == 0){
            int i = 0;
            while(i<Player.maximumShipNum)
            {
                boolean state=ran.nextBoolean();
                int xCoor=0,yCoor=0;
                switch(com.setShip){
                    case 0:
                        if(state){
                                xCoor = ran.nextInt(boardCom.getBoard()[Board.height-2][Board.width-1].getCoorX()-boardCom.startX)+boardCom.getBoard()[0][0].getCoorX();
                                yCoor = ran.nextInt(boardCom.getBoard()[Board.height-1][Board.width-1].getCoorY()-boardCom.startY)+boardCom.getBoard()[0][0].getCoorY();
                        }
                        
                        else{
                            xCoor = ran.nextInt(boardCom.getBoard()[Board.height-1][Board.width-1].getCoorX()-boardCom.startX)+boardCom.getBoard()[0][0].getCoorX();
                            yCoor = ran.nextInt(boardCom.getBoard()[Board.height-1][Board.width-2].getCoorY()-boardCom.startY)+boardCom.getBoard()[0][0].getCoorY();
                        }
                        break;
                    case 1:
                        if(state){
                            xCoor = ran.nextInt(boardCom.getBoard()[Board.height-3][Board.width-1].getCoorX()-boardCom.startX)+boardCom.getBoard()[0][0].getCoorX();
                            yCoor = ran.nextInt(boardCom.getBoard()[Board.height-1][Board.width-1].getCoorY()-boardCom.startY)+boardCom.getBoard()[0][0].getCoorY();
                        }
                        else {
                            xCoor = ran.nextInt(boardCom.getBoard()[Board.height-1][Board.width-1].getCoorX()-boardCom.startX)+boardCom.getBoard()[0][0].getCoorX();
                            yCoor = ran.nextInt(boardCom.getBoard()[Board.height-1][Board.width-3].getCoorY()-boardCom.startY)+boardCom.getBoard()[0][0].getCoorY();
                        }
                        break;
                    case 2:
                        if(state){
                            xCoor = ran.nextInt(boardCom.getBoard()[Board.height-3][Board.width-1].getCoorX()-boardCom.startX)+boardCom.getBoard()[0][0].getCoorX();
                            yCoor = ran.nextInt(boardCom.getBoard()[Board.height-1][Board.width-1].getCoorY()-boardCom.startY)+boardCom.getBoard()[0][0].getCoorY();
                        }
                        else {
                            yCoor = ran.nextInt(boardCom.getBoard()[Board.height-1][Board.width-3].getCoorY()-boardCom.startY)+boardCom.getBoard()[0][0].getCoorY();
                            xCoor = ran.nextInt(boardCom.getBoard()[Board.height-1][Board.width-1].getCoorX()-boardCom.startX)+boardCom.getBoard()[0][0].getCoorX();
                        }
                        break;
                    case 3:
                        if(state){
                            xCoor = ran.nextInt(boardCom.getBoard()[Board.height-4][Board.width-1].getCoorX()-boardCom.startX)+boardCom.getBoard()[0][0].getCoorX();
                            yCoor = ran.nextInt(boardCom.getBoard()[Board.height-1][Board.width-1].getCoorY()-boardCom.startY)+boardCom.getBoard()[0][0].getCoorY();
                        }
                        else{
                            yCoor = ran.nextInt(boardCom.getBoard()[Board.height-1][Board.width-4].getCoorY()-boardCom.startY)+boardCom.getBoard()[0][0].getCoorY();
                            xCoor = ran.nextInt(boardCom.getBoard()[Board.height-1][Board.width-1].getCoorX()-boardCom.startX)+boardCom.getBoard()[0][0].getCoorX();
                        }
                        break;
                    case 4:
                        if(state){
                            xCoor = ran.nextInt(boardCom.getBoard()[Board.height-5][Board.width-1].getCoorX()-boardCom.startX)+boardCom.getBoard()[0][0].getCoorX();
                            yCoor = ran.nextInt(boardCom.getBoard()[Board.height-1][Board.width-1].getCoorY()-boardCom.startY)+boardCom.getBoard()[0][0].getCoorY();
                        }
                        else{
                            yCoor = ran.nextInt(boardCom.getBoard()[Board.height-1][Board.width-5].getCoorY()-boardCom.startY)+boardCom.getBoard()[0][0].getCoorY();
                            xCoor = ran.nextInt(boardCom.getBoard()[Board.height-1][Board.width-1].getCoorX()-boardCom.startX)+boardCom.getBoard()[0][0].getCoorX();
                        }
                        break;
                        
                        
                }
                com.setShip(xCoor,yCoor, com.setShip, state);
                
                 
                if(!com.CheckPlacement()){
                    com.getShip().setCoorX(ran.nextInt(boardCom.getBoard()[Board.height-1][Board.width-1].getCoorX()-boardCom.getBoard()[0][0].getCoorX())+boardCom.getBoard()[0][0].getCoorX());
                    com.getShip().setCoorY(ran.nextInt(boardCom.getBoard()[Board.height-1][Board.width-1].getCoorY()-boardCom.getBoard()[0][0].getCoorY())+boardCom.getBoard()[0][0].getCoorY());
                    
                }
                else{
                    i++;
                    com.addShip(com.getShip());   
                }
               
                
            }
            
            State.setState(GameState.PLAY);
        }
    }

    @Override
    public void draw(Graphics g){
        board.draw(g);
        boardCom.draw(g);
        for(int i=0;i<player.getShipList().length;i++){
            if( player.getShipList()[i]!=null)
            player.getShipList()[i].draw(g);
        }
        
    }
    // prevent ship position exceeds board
    public boolean RangeCheck(){
        for(int i=0;i<board.getWidth();i++){
            for(int j=0;j<board.getHeight();j++){
                if(State.turn==1){
                    if(board.getBoard()[i][j].bound.contains(GameLoop.getGame().getMouseInput().getMouseX(),GameLoop.getGame().getMouseInput().getMouseY())
                             ){
                    if(!vertical){
                        if(board.getBoard()[i][j].id/10 < player.setShip +1)
                            return false;
                    }
                    else{
                        if(board.getBoard()[i][j].id%10 < player.setShip +1)
                            return false;
                    }
                }
                }
                
            }}
        return true;
    }


    public void onClick() {
        
        if(!RangeCheck()) return;
        for(int i=0;i<board.getWidth();i++){
            for(int j=0;j<board.getHeight();j++){
                
                
                
                
                if(board.getBoard()[i][j].bound.contains(GameLoop.getGame().getMouseInput().getMouseX(),GameLoop.getGame().getMouseInput().getMouseY())){
                    player.setShip(board.getBoard()[i][j].getCoorX(), board.getBoard()[i][j].getCoorY(),player.setShip,vertical);
                    if(player.CheckPlacement())
                    player.addShip(player.getShip());
                    else return;
                }
                
            }
        }
        
        if(player.setShip==player.maximumShipNum)
                    State.turn = 0;
    }

    @Override
    public Board getBoard() {
        return board; }
}
