/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Orther;

import Center.GameObject;
import Center.Handler;
import Center.ID;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author TLiem
 */
public class hienmatran extends GameObject{
    ImageIcon anh = new ImageIcon("data/hieuung/matran1.png");
    int w;
    GameObject next=null;
    public hienmatran(int x, int y, int i, Handler h, GameObject n) {
        super(x, y, ID.nonobject);
        this.handler=h;
        this.next=n;
        w=5;
        switch(i){
            case 1: anh = new ImageIcon("data/hieuung/matran1.png"); break;
            case 2: anh = new ImageIcon("data/hieuung/matran2.png"); break;
            case 3: anh = new ImageIcon("data/hieuung/matran3.png"); break;
            case 4: anh = new ImageIcon("data/hieuung/matran4.png"); break;
            case 5: anh = new ImageIcon("data/hieuung/matran5.png"); break;
        }
    }
    public hienmatran(int i, Handler h, GameObject n) {
        super(0,0, ID.nonobject);
        this.handler=h;
        this.next=n;
        w=5;
        switch(i){
            case 1: anh = new ImageIcon("data/hieuung/matran1.png"); break;
            case 2: anh = new ImageIcon("data/hieuung/matran2.png"); break;
            case 3: anh = new ImageIcon("data/hieuung/matran3.png"); break;
            case 4: anh = new ImageIcon("data/hieuung/matran4.png"); break;
            case 5: anh = new ImageIcon("data/hieuung/matran5.png"); break;
        }
    }

    @Override
    public void tick() {
        w=w+5;
        if(w==100) {
            if(next!=null) this.handler.addobject(next);
        }
        if(w>=100){ 
            w=5;
            this.handler.removeobject(this);
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(anh.getImage(), x+((100-w)/2), y+((100-w)/2), w, w, null);
    }

    @Override
    public Rectangle getbounds() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
