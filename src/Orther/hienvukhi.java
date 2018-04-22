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
public class hienvukhi extends GameObject{
    ImageIcon anh = new ImageIcon("data/hieuung/kiem1.png");
    int time = 30;
    public hienvukhi(int x, int y, Handler h, int i) {
        super(x, y, ID.nonobject);
        this.handler=h;
        switch(i){
            case 1: anh = new ImageIcon("data/hieuung/kiem1.png"); break;
            case 2: anh = new ImageIcon("data/hieuung/kiem2.png"); break;
        }
    }
    public hienvukhi(Handler h, int i) {
        super(0, 0, ID.nonobject);
        this.handler=h;
        switch(i){
            case 1: anh = new ImageIcon("data/hieuung/kiem1.png"); break;
            case 2: anh = new ImageIcon("data/hieuung/kiem2.png"); break;
        }
    }
    @Override
    public void tick() {
        time=time-1;
        if(time<=0) this.handler.removeobject(this);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(anh.getImage(), x, y, 100, 100, null);
    }

    @Override
    public Rectangle getbounds() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
