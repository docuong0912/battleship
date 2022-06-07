/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Asus
 */
public class BattleShip {
    private GameState gamestate;
    private State state;
    public State getState() {
        return state;
    }
    
    BattleShip game;

    public BattleShip getGame() {
        return game;
    }
    public BattleShip(){
       State.setState(gamestate.PREPARATION);
    }
    

   public void update(){
       State.getGameState().update();
   }
   public void draw(Graphics g){
       State.getGameState().draw(g);
   
     
   }
}
