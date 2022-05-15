/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pong;

/**
 * Player is just a rectangle with score and speed attribute, nothing out of extraordinary, it has respective setter and getter
 * and a method to add one to the score
 * @author Soulx720
 */
public class Player {
    int X;
    int Y;
    int height;
    int width;
    int score;
    int spd;
    public int getX() {
        return X;
    }

    public void setX(int X) {
        this.X = X;
    }

    public int getY() {
        return Y;
    }

    public void setY(int Y) {
        this.Y = Y;
    }
    public void Scored(){
        score+=1;
    }

    public Player() {
        X=100;
        Y=0;
        width=20;
        height=100;
        score=0;
        spd=10;
    }
    public Player(int x,int y,int w, int h,int s){
        X=x;
        Y=y;
        width=w;
        height=h;
        spd=s;
    }
}
