/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pong;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;
/**
 *List of bugs:
 * -The first player start with a point, the ball start in (0,0) which is an score, by later definition, to fix this the first player score start
 * in -1
 * -the position of the second player doesn't match with the hitbox so 50px were added to align the player and the hitbox
 * -the ball something will wiggle over the second player hitbox for no reason
 * -rough edges will be ignored
 * @author Soulx720
 */
public class Panel extends JPanel implements ActionListener{
    Ball b;
    Player p1;
    Player p2;
    int w;
    int h;
    Timer t;
    int glow;
    int glow_direction;
    public Panel(){    
        glow=100;
        glow_direction=1;
        b = new Ball(400,300,50,5,6);
        w=20;
        h=200;
        p1=new Player(50,0,w,h,50);

        p2=new Player(700,0,w,h,50);
        p1.score=-1;
        t=new Timer(5,this);
        this.setBackground(Color.black);
        t.start();
    }
    /**
     * Main method that manage everything in the Panel it is call everytime the timer tic and fill the screen, basically keep everything working
     * @param g paintComponent from Jpanel class, this object determine what is painted in the canvas and add everything into JPanel
     */
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        //While the
        if (b.isStopped()==true){
            g.setColor(new Color(glow,glow,glow));
            g.setFont(new Font("Consolas",Font.PLAIN,40));
            g.drawString("Presione Espacio para empezar", 100, 400);
        }
        g.setColor(Color.white);
        
        //Paint the Ball in the screen
        g.fillOval(b.getX(), b.getY(), b.getSize(), b.getSize());
        
        //Paint the players in the screen
        g.fillRect(p1.getX(), p1.getY(), p1.width, p1.height);
        g.fillRect(p2.getX()+50, p2.getY(), p2.width, p2.height);
        
        //set the font for the graphics
        g.setFont(new Font("Consolas",Font.PLAIN,100));
        
        //ScoreBoard
        g.drawString(Integer.toString(p1.score), 100, 100);
        g.drawString(Integer.toString(p2.score), 700, 100);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //the ball reach the left corner therefore the second player score one point
        if (b.getX()<0){
            p2.Scored();
            b.setPosition(400, 300);
            b.stop();
        }
        
        //the ball reach the right corner therefore the first player score one point
        if (b.getX()>this.getBounds().width ){
            p1.Scored();
            b.setPosition(350, 250);
            System.out.println("hola");
            b.stop();
        }
        
        //The ball reach the botton or the top therefore change direction
        if (b.getY()>this.getBounds().height || b.getY()<0){
            b.touchBoundY();
        }
        //The ball intersect with the first player therefore change direction
        if(b.getX()>p1.X && b.getX()<p1.X+p1.width && b.getY()>p1.Y && b.getY()<p1.Y+p1.height){
            b.touchBoundX();
            System.out.println("Touch 1!!");

        }
        //The ball intersect with the second player therefore change direction
        if(b.getX()>p2.getX() && b.getX()<p2.getX()+p2.width && b.getY()>p2.Y && b.getY()<p2.Y+p2.height){
            b.touchBoundX();
            System.out.println("Touch 2!!"+p2.getY());
        }
        //while the stopped flag is up the ball doesn't change position
        if (b.isStopped()){
           b.setPosition(b.getX(), b.getY());
        }else{
            b.setPosition(b.getX()+b.getSpdX(), b.getY()+b.getSpdY());
        }
        Glow();
        this.repaint();
    }
    private void Glow(){
        glow+=(5*glow_direction);
        if (glow>250 || glow<100) glow_direction*=-1;
    }
}
