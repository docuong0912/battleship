/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;


import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
public class Com extends Player {
    Random gen = new Random();
    Stack<Integer> potentialPos = new Stack<Integer>();
    private int index = 0;
    private int check = 0;
    private boolean neighborCheckFinish =true;
    private int neighborCheckIndex =0;
    private int[] visited ;
   
    int[] ranMove = new int[100];
    Stack<Integer> ranStack = new Stack<Integer>();
    public Com(){
        shipList = new Ship[maximumShipNum];
        generateRandom();
        visited = new int[ranMove.length];
    }
    private void generateRandom(){
        for(int i=0;i<ranMove.length;i++){
            ranMove[i]=i+1;
        }
        for(int i=ranMove.length-1;i>0;i--){
            int j = gen.nextInt(i+1);
            int temp = ranMove[i];
            ranMove[i] = ranMove[j];
            ranMove[j] = temp;
        }
        for(int i=0;i<ranMove.length;i++){
            ranStack.push(ranMove[i]);
        }
    }
    public int getSelectedIndex() {
        return selectedIndex;
    }

    public void setSelectedIndex() {
        for(int i=0;i<visited.length;i++){
            if(visited[i]==ranStack.peek())
            ranStack.pop();
        }
        selectedIndex = ranStack.pop();
    }
    
    public void turn(){
        if(hit&&!duplicate){
            Target(selectedIndex); 
        }
        if(!potentialPos.empty()){
            for(int i = 0;i<visited.length;i++){
                if(visited[i] == potentialPos.peek()&&!potentialPos.empty())
                    potentialPos.pop();
            }
            selectedIndex=potentialPos.pop();
           
        }
        else Hunt();
        Visited(duplicate);
        duplicate =false;
        
    }
    private void Visited(boolean dup){
        if(!dup){
            visited[index] = selectedIndex;
            index++;
        }
    }
    private void Hunt(){
        setSelectedIndex();
        
    }
    private void Target(int index){
            potentialPos.push(index+10);
            potentialPos.push(index-10);
            potentialPos.push(index+1);
            potentialPos.push(index-1);
    }

    @Override
    public void update() {
        }

    
}
