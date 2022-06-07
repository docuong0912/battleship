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
public abstract class Player {
    protected static int maximumShipNum = 5;
    protected int setShip=0;
    protected boolean duplicate;
    public Ship[] getShipList() {
        return shipList;
    }
    public void addShip(Ship ship){
        
        shipList[setShip] = ship;
        setShip++;
       
    }
   
    public int selectedIndex;
    protected Ship[] shipList;
    public void hit(Ship ship){};
    public abstract void setSelectedIndex();
    public abstract int getSelectedIndex();
    public abstract void update();
    public int getxCoor(){return 0;}
    public int getyCoor(){return 0;}
    protected Ship ship;
    public boolean hit;
    public abstract void turn();
    public Ship getShip() {
        return ship;
    }
    public void huturn(Board board){}
    public void setShip(int x,int y,int size,boolean vertical){
        ship = new Ship(x,y);
        ship.vertical = vertical;
        switch(size){
            case 0:
                ship.setSize(ShipSize.SMALL);
                break;
            case 1:
                ship.setSize(ShipSize.MEDIUM);
                break;
            case 2:
                ship.setSize(ShipSize.MEDIUM);
                break;
            case 3:
                ship.setSize(ShipSize.QUITELARGE);
                break;
            case 4:
                ship.setSize(ShipSize.LARGE);
                break;
                
        }
        
    }
    // prevent ships dont overlap each other
    public boolean CheckPlacement(){

        for(int i=0;i<shipList.length;i++){
            if(shipList[i]!=null){
                // i represents number of list each player
                // j represents size of ship[i] of each player
                for(int j=0;j<shipList[i].getShipSize().length;j++){
                    //k represents size of the ship in parameters
                    for(int k = 0 ;k<ship.getShipSize().length;k++){
                        if(shipList[i].getShipSize()[j].bound.intersects(ship.getShipSize()[k].bound)){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
    
}
