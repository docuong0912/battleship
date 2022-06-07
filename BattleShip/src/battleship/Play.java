/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

import java.awt.Graphics;

/**
 *
 * @author Asus
 */
public class Play extends State {
    
    public Play(HumanPlayer player,Board board,Com com,Board board2){
        System.out.println("play state go go go");
        this.player = player;
        this.board = board;
        this.com = com;
        boardCom = board2;
    }
    public boolean checkHit(Cell a){
        for (Ship shipList : player.getShipList()) {
            for (Cell shipSize : shipList.getShipSize()) {
                if (a.getCoorX() == shipSize.getCoorX() && a.getCoorY() == shipSize.getCoorY()) {
                    return true;
                }
            }
        }
        
       return false;

    }
    @Override
    public void update() {
        if(State.turn == 0){
            if(board.SelectedAt(com.getSelectedIndex())==null){
                   State.turn = 1;
                   return;
               }
                if(board.SelectedAt(com.getSelectedIndex()).visited)
                    com.duplicate = true;
               if(checkHit(board.SelectedAt(com.getSelectedIndex())))
               {
                   System.out.println("ha ha");
                  
                   board.SelectedAt(com.getSelectedIndex()).hit=true;
                   com.hit =true;
               }
               
               else{
                   board.SelectedAt(com.getSelectedIndex()).isChoosen=true;
                   com.hit = false;
               }
               board.SelectedAt(com.getSelectedIndex()).visited=true;
               
               
           State.turn = 1;
       }
       player.update();
       }

    @Override
    public void draw(Graphics g) {
        for(int i=0;i<player.getShipList().length;i++){
            if(player.getShipList()[i]!=null){
                  player.getShipList()[i].draw(g);
            }
        }
        board.draw(g);
        boardCom.draw(g);
        }

    @Override
    public void onClick() {
        if(State.turn == 1){
            player.huturn(boardCom);
            for(int i=0;i<com.shipList.length;i++){
                for(int j = 0;j<com.shipList[i].getShipSize().length;j++){
                    if(com.shipList[i].getShipSize()[j].bound.contains(player.getxCoor(),player.getyCoor())){
                        System.out.println("hihi");
                        boardCom.SelectedAt(player.getSelectedIndex()).hit=true;
                    }
                  
                }
            }
            
            com.turn();
            State.turn =0;
        }
        
            
          
        
       }

    @Override
    public Player getPlayer() {
        return player;
       }

    @Override
    public Board getBoard() {
        return board;
        }
    
}
