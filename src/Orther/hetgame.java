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
public class hetgame extends GameObject{
    ImageIcon nen = new ImageIcon("data/an/nen5.png");
    int t=120;
    int k;
    String s;
    public hetgame(Handler h, int i) {
        super(0, 0, ID.nonobject);
        this.handler=h;
        if(i==1){
            s="Baïn ñaõ chieán thaéng!";
        }else s="Baïn ñaõ thua roài!";
        k=i;
    }

    @Override
    public void tick() {
        t=t-1;
        if(t<=0){
            if(k==1) {
                this.handler.addobject(new bangxephang(this.handler));
                this.handler.removeobject(this);
            }
            if(k==0){
                this.handler.addobject(new mainmenu(this.handler));
                this.handler.removeobject(this);
            }
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(nen.getImage(), 0, 0,960, 720, null);
        g.setColor(Color.white);
        g.setFont(new Font("VNI-Ariston", 0, 50));
        g.drawString(s, 400, 350);
    }

    @Override
    public Rectangle getbounds() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
