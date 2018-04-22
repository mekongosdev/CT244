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
public class thongbao extends GameObject{
    public String[] s = new String[6];
    int t=180;
    ImageIcon nen = new ImageIcon("data/an/thongbao.png");
    public thongbao(int x, int y, Handler h) {
        super(x, y, ID.nonobject);
        this.handler=h;
        for(int i=0; i<6; i++){
            s[i]="";
        }
    }

    @Override
    public void tick() {
        t=t-1;
        if(t<=0) this.handler.removeobject(this);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(nen.getImage(), x, y, 400, 300, null);
        g.setFont(new Font("VNI-Vivi", 0, 25));
        g.setColor(Color.YELLOW);
        for(int i=0; i<6; i++){
            g.drawString(s[i], x+20, y+30+i*40);
        }
    }

    @Override
    public Rectangle getbounds() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
