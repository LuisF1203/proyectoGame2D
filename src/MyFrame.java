import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class MyFrame extends JFrame implements KeyListener , ActionListener {
    JLabel character;
    JLabel label;
    ImageIcon icon;
    JLabel pipeLabel;
    ImageIcon pipe;
    Timer timer;
    boolean Jump=false;
    int SecJump=0;

    int xVelocity = 1;
    int yVelocity = 1;
    int x = 0;
    int y = 0;
    final int PANEL_WIDTH = 1000;
    final int PANEL_HEIGHT = 500;

    MyFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(PANEL_WIDTH,PANEL_HEIGHT);
        this.setLayout(null);
        this.addKeyListener(this);
        icon= new ImageIcon(getClass().getResource("enemy2.png"));
        timer= new Timer(30,this);
        timer.start();


        character = new JLabel();
        character.setBounds(0,PANEL_HEIGHT-140,100,100);
        character.setIcon(icon);
        this.add(character);

        pipe = new ImageIcon(getClass().getResource("pipe2.png"));
        label = new JLabel();
        label.setBounds(500,PANEL_HEIGHT-140,100,100);
        label.setIcon(pipe);
        //label.setBackground(Color.red);
        //label.setOpaque(true);
        this.getContentPane().setBackground(Color.black);
        this.add(label);
        this.setVisible(true);
    }
    @Override
    public void keyTyped(KeyEvent e) {
        switch (Character.toLowerCase((e.getKeyChar()))){
            case 'a':
                if(character.getX()>0){
                    character.setLocation(character.getX()-10,character.getY());
                }
                break;
            case 'w':
                if(character.getY()>0){
                    character.setLocation(character.getX(),character.getY()-10);
                }

                break;
            case 's':
                if(character.getY()< (PANEL_HEIGHT-character.getHeight())){
                    character.setLocation(character.getX(),character.getY()+10);
                }

                break;
            case 'd':
                if(character.getX()< (PANEL_WIDTH-character.getWidth())){
                    character.setLocation(character.getX()+10,character.getY());
                }
                break;
        }
    }
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case 32:
                if(character.getY()>0){
                    character.setLocation(character.getX(),character.getY()-120);
                    this.Jump=true;
                    //gravity= new Timer(100,this);
                    //gravity.start();
                }
                break;
            case 37:
                if(character.getX()>0){
                    character.setLocation(character.getX()-10,character.getY());
                }
                break;
            case 38:
                if(character.getY()>0){
                    character.setLocation(character.getX(),character.getY()-10);
                }

                break;
            case 40:
                if(character.getY()< (PANEL_HEIGHT-character.getHeight())){
                    character.setLocation(character.getX(),character.getY()+10);
                }
                break;
            case 39:
                if(character.getX()< (PANEL_WIDTH-character.getWidth())){
                    character.setLocation(character.getX()+10,character.getY());
                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("you release key character "+ e.getKeyChar());
        System.out.println("you release key code "+ e.getKeyCode());

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (label.getX() >= -100) {
            label.setLocation(label.getX() - 10, label.getY());
            System.out.println(label.getX());
            System.out.println(PANEL_WIDTH);
        } else {
            character.setLocation(character.getX() + 10, label.getY());
            System.out.println("ganaste");
        }
        if ((character.getX() + character.getWidth()) - 50 == label.getX() && character.getY() > (label.getHeight() + character.getHeight()) + 50) {
            System.out.println("chocaste");
            label.setLocation(500,PANEL_HEIGHT-140);

        }
    }
}
