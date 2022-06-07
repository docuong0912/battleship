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
public abstract class State {
    protected static int turn = 1;
    protected Player player;
    protected Player com;
    protected Board board;
    protected Board boardCom;
    private static State gameState;
    private static GameState gstate;
    public abstract Player getPlayer();
    public abstract Board getBoard();
    public static State getGameState() {
        return gameState;
    }

    public static GameState getGstate() {
        return gstate;
    }

    public Player getCom() {
        return com;
    }
    
    public static void setState(GameState state){
        try{
           switch(state){
                case PREPARATION:
                gameState = new Preparation();
                gstate = state;
                break;
                case PLAY:
                gameState = new Play((HumanPlayer) gameState.getPlayer(),gameState.getBoard(), (Com) gameState.getCom(),gameState.getBoardCom());
                gstate = state;
                break;
            }
        }catch(NullPointerException ex){
            System.out.println(ex+" at state class");
        }
        System.out.println(gstate);
    }

    public Board getBoardCom() {
        return boardCom;
    }
    public abstract void update();
    public abstract void draw(Graphics g);
    public abstract void onClick();
}
