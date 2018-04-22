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
public class hieuungphep extends GameObject{
    int time, i;
    ImageIcon anh = new ImageIcon("data/hieuung/tt1.png");
    public hieuungphep(int x, int y, Handler h) {
        super(x, y, ID.nonobject);
        anh = new ImageIcon("data/hieuung/tt1.png");
        this.handler=h;
        time=24; i=1;
    }
    public hieuungphep( Handler h) {
        super(0, 0, ID.nonobject);
        anh = new ImageIcon("data/hieuung/tt1.png");
        this.handler=h;
        time=24; i=1;
    }

    @Override
    public void tick() {
        time=time-1;
        if(time%5==0) doianh();
        if(time<0){ 
            this.handler.removeobject(this);
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(anh.getImage(), x, y, 200, 200, null);
    }

    @Override
    public Rectangle getbounds() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    void doianh(){
        switch(i){
            case 1: anh = new ImageIcon("data/hieuung/tt2.png"); i=i+1; break;
            case 2: anh = new ImageIcon("data/hieuung/tt3.png"); i=i+1; break;
            case 3: anh = new ImageIcon("data/hieuung/tt4.png"); i=i+1; break;
            case 4: anh = new ImageIcon("data/hieuung/tt5.png"); i=i+1; break;
            default: break;
        }
    }
}
