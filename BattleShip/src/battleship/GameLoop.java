package battleship;


import battleship.Window;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Asus
 */
public class GameLoop implements Runnable {
    private MouseInput input;
    private Thread thread;
    private BufferStrategy bs;
    private Graphics g;
    private boolean started =false;
    public static boolean pause =false;
    private static GameLoop game;
    private BattleShip maingame;
    GameLoop engine;
    private GameLoop(){
        input = new MouseInput();
    }
    public void update(){
        maingame.update();
    }
    public void draw(){
        bs = Window.getWindow().getCanvas().getBufferStrategy();
        if(bs == null){
            Window.getWindow().getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        g.clearRect(0, 0, Window.getWindow().getFrame().getWidth(), Window.getWindow().getFrame().getHeight());
        maingame.draw(g);
        bs.show();
        g.dispose();
            
    }
     public void run() {
        init();
        int fps = 60;
        double timePerTick = 1000000000/fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;
        while(started){
          
            now = System.nanoTime();
            delta+= (now-lastTime)/timePerTick;
            timer+= now - lastTime;
            lastTime = now;
            if(delta >=1){
                update();
                draw();
                ticks++;
                delta--;
            }
            if(timer >=1000000000){
                System.out.println("Ticks and Frames: "+ticks);
                ticks = 0;
                timer = 0;
            }
            
           
        }
    }

    public BattleShip getMaingame() {
        return maingame;
    }
    public MouseInput getMouseInput(){
        return input;
    }
    public synchronized void start(){
        if (started) return;
        else started = true;
        thread = new Thread(this);
        thread.start();
    }
    public synchronized void stop() throws InterruptedException{
        if(!started) return;
        else started = false;
        thread.join();
    }
    public void init(){
        engine = new GameLoop();
        maingame = new BattleShip();
       Window.getWindow().getFrame().addMouseMotionListener(input);
       Window.getWindow().getFrame().addMouseListener(input);
       Window.getWindow().getCanvas().addMouseMotionListener(input);
       Window.getWindow().getCanvas().addMouseListener(input);
    }
    public static GameLoop getGame(){
        if(game== null)
            game = new GameLoop();
        return game;
    }
    public static void main(String[] args) {
        GameLoop.getGame().start();
    }
}
