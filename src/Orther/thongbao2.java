/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Orther;

import Center.GameObject;
import Center.Handler;
import Center.ID;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author TLiem
 */
public class thongbao2 extends GameObject{
    public String s="";
    int t=100;
    ImageIcon nen = new ImageIcon("data/an/thongbao2.png");
    public thongbao2(int x, int y, Handler h) {
        super(x, y, ID.nonobject);
        this.handler=h;
    }

    @Override
    public void tick() {
        t=t-1;
        if(t<=0) this.handler.removeobject(this);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(nen.getImage(), x, y, 300, 200, null);
        g.setFont(new Font("VNI-Ariston", 0, 30));
        int f=15-s.length();
        g.drawString(s, x+5+f*12, y+110);
    }

    @Override
    public Rectangle getbounds() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
