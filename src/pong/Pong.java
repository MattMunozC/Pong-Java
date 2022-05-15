package pong;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

/**
 * This code have odd bugs that i wasn't able to fix yet but i'll do everything i could to document properly so perhaps in the future i may 
 * be able to debug it
 * @author Soulx720
 */
public class Pong extends JFrame implements KeyListener{

    Panel p1;
    public Pong(){
        p1=new Panel();
        this.setTitle("Pong");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setResizable(false);
        this.setVisible(true);
        this.add(p1);
        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Control of the game
     * Player 1
     *  -W: up
     *  -S: down
     * Player 2
     *  -up arrow: up
     *  -down arrow: down
     * Press Space to Start
     * @param e key pressed 
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar()=='s'){
            p1.p1.Y+=p1.p1.spd;
        }
        if(e.getKeyChar()=='w'){
            p1.p1.Y-=p1.p1.spd;
        }
        if(e.getKeyCode()==40){
            p1.p2.Y+=p1.p2.spd;
        }
        if(e.getKeyCode()==38){
            p1.p2.Y-=p1.p2.spd;
        }
        if(e.getKeyCode()==32 && p1.b.isStopped()==true){
            p1.b.start();
        }
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
