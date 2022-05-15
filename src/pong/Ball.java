/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pong;

import java.util.Random;



/**
 *  The Ball has a position 
 * 
 * @author Soulx720
 * 
 * 
 */
public class Ball {
    private int size;
    private int x;
    private int y;
    //Ideally the speed on each axis are equals but you can play a bit with the config if you want
    
    //both spd atributes determine how many pixels does the ball move each tic of the timer
    private int spdY;
    private int spdX;
    private boolean stopped; //State Flag: Determine whether the ball is in motion or not

    /**
     * ball constructor with parameter already define; 
     * X and Y will define the position on screen of the ball
     * @param X initial position of the ball in x-axis
     * @param Y initial position of the ball in y-axis
     * @param s size of the ball
     */
    public Ball(int X,int Y,int s){
        size=s;
        x=X;
        y=Y;
        stopped=false;
    }

    public Ball(int x, int y, int size,int spdY, int spdX) {
        this.size = size;
        this.x = x;
        this.y = y;
        this.spdY = spdY;
        this.spdX = spdX;
        stopped=false;
    }


    /**
     * Once any player score the game ball will stop and raise "stopped" flag
     */
    public void stop(){
        stopped=true;
    }
    /**
     * This method resume the game
     * return the stopped flag to false and throw the ball into a random direction
     */
    public void start(){
        stopped=false;
        
        //the random function will return either 0 or 1, it will change the direction if the random number is 0
        if(new Random().nextInt(2)!=1) touchBoundX();
        if(new Random().nextInt(2)!=1) touchBoundY();
    }
    
    /**
     * Change the ball direction in the Y-axis
     */
    public void touchBoundY(){
        spdY*=-1;
    }

    /**
     * Change the ball direction in the X-axis
     */
    public void touchBoundX(){
        spdX*=-1;
    }

    /**
     * move the ball to the require position
     * @param x1 new x-axis position
     * @param y1 new y-axis position
     */
    public void setPosition(int x1,int y1){
        x=x1;
        y=y1;
    }
    
//After this comment there are only getter and setter nothing out of the ordinary
    /**
     * 
     * @return position of the ball in X-axis
     */
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSpdY() {
        return spdY;
    }

    public void setSpdY(int spdY) {
        this.spdY = spdY;
    }

    public int getSpdX() {
        return spdX;
    }

    public void setSpdX(int spdX) {
        this.spdX = spdX;
    }
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isStopped() {
        return stopped;
    }

    public void setStopped(boolean stopped) {
        this.stopped = stopped;
    }

    
}
