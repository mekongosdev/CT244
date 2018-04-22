/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Center;

import CacLoaiThe.Kiem;
import CardObject.KieuTheBai;
import CardObject.banco;
import Orther.mainmenu;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;
import javax.swing.ImageIcon;
/**
 *
 * @author TLiem
 */
public class Game extends Canvas implements Runnable {
    
    public static final int width=960,height=(width*9)/12;
    public static boolean onload = true;
    public static boolean onplay = false;
    public static LoadScr LS = new LoadScr(width, height, 1);
    private Thread thread;
    private boolean running=false;
    ImageIcon anh = new ImageIcon("data/card/banco.png");
    ImageIcon anh2 = new ImageIcon("data/card/Night.png");
    mainmenu test;
    private Random r;
    private Handler handler;
    window Win;
    public Game(){
        r=new Random();
        handler=new Handler();
        this.addKeyListener(new KeyInput(handler));
        this.addMouseListener(new MouseInput(handler));
        this.addMouseMotionListener(new MouseMove(handler));
        Win=new window(width,height,"Summoner",this);
        LS.n=1;
        System.out.println(LS.n);
    }

    public synchronized void start(){
        thread=new Thread(this);
        thread.start();
        running=true;
        test = new mainmenu(this.handler);
        handler.addobject(test);
    }
    
    public synchronized void stop(){
        try{
            thread.join();
            running=false;
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void run(){
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running)
        {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >=1)
            {
                tick();
                delta--;
                if(onload){
                	LS.tick();
                }
            }
            if(running)
                render();
            frames++;
                            
            if(System.currentTimeMillis() - timer > 1000)
            {
                timer += 1000;
                frames = 0;
            }
        }
        stop();
    }
        
    private void tick(){
        handler.tick();
    }
    
    private void render(){
        BufferStrategy bs=this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }
        Graphics g=bs.getDrawGraphics();
        if(onplay){
        	g.drawImage(anh2.getImage(), 0, 0, width, height, null);
            g.drawImage(anh.getImage(), 0, 0, null);
        }
        handler.render(g);
        if(onload){
        	LS.render(g);
        }
        g.dispose();
        bs.show();
    }
    
    public static int clam(int var,int min,int max){
        if(var>=max) return var=max;
        else if(var<=min) return var=min;
        else return var;
    }
    
    public static void main(String[] args) {
        new Game();
    }
    
}
