/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

/**
 *
 * @author Asus
 */
public class HumanPlayer extends Player {
    public HumanPlayer(){
        shipList = new Ship[maximumShipNum];
    }
    private int xCoor;
    private int yCoor;
    public void setSelectedIndex(){

    }
    public void update(){
        xCoor = GameLoop.getGame().getMouseInput().getMouseX();
        yCoor = GameLoop.getGame().getMouseInput().getMouseY();
    }
    public void turn(){
         for (Cell ship : getShip().getShipSize()) {
            if(ship!=null){
                if(ship.bound.contains(GameLoop.getGame().getMouseInput().getMouseX(),GameLoop.getGame().getMouseInput().getMouseY())){
                    getShip().isDamaged(getShip().indexAt(ship.getCoorX(), ship.getCoorY()));
                    hit = true;
                }
                else hit =false;
         }
            
        }
    }

    @Override
    public int getSelectedIndex() {
        return selectedIndex;
    }

    public void hit(Ship ship) {
        ship.isDamaged(ship.indexAt(GameLoop.getGame().getMouseInput().getMouseX(), GameLoop.getGame().getMouseInput().getMouseY()));
                }

    public int getxCoor() {
        return xCoor;
    }

    public int getyCoor() {
        return yCoor;
    }
    public void huturn(Board board){
        for(int i = 0;i<board.getWidth();i++){
            for(int j=0;j<board.getHeight();j++){
                if(board.getBoard()[i][j].bound.contains(xCoor,yCoor)){
                    selectedIndex = board.getBoard()[i][j].index;
                }
            }
        }
    }
    

}
