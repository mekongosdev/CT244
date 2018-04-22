/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Orther;

import Center.Game;
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
public class Huongdan extends GameObject{
    ImageIcon nen, quatrai, quaphai;
    ImageIcon[] trang = new ImageIcon[5];
    public button dong;
    int i, t, s;
    int[] xtrang = new int[5];
    boolean L,R;
    String hien1, hien2, hien3, s1, s2, s3;
    public Huongdan(Handler h) {
        super(0,0, ID.huongdan);
        L=false;
        R=false;
        i=0;
        t=1;
        hien1="";
        hien2="";
        hien3="";
        s1="Phaàn meàm ñöôïc thöïc hieän bôûi: Phan Thanh Lieâm";
        s2="Email: ptliem007@yahoo.com  ";
        s3="hoaëc liemb1400701@student.ctu.edu.vn";
        this.handler=h;
        nen = new ImageIcon("data/an/nen4.png");
        for(int l=0; l<5; l++){
            trang[l] = new ImageIcon("data/an/hd"+(l+1)+".png");
            xtrang[l] = l*960;
        }
        quatrai = new ImageIcon("data/an/quatrai.png");
        quaphai = new ImageIcon("data/an/quaphai.png");
        dong = new button(840, 630, 100, 50, new ImageIcon("data/an/vemenu.png"));
        s=0;
    }

    @Override
    public void tick() {
        if(R && i<960){
            for(int l=0; l<5; l++){
                xtrang[l]= xtrang[l]+10;
            }
            i=i+10;
        }
        if(L && i>-960){
            for(int l=0; l<5; l++){
                xtrang[l]= xtrang[l]-10;
            }
            i=i-10;
        }
        if(i>=960 || i<=-960 || (i==0 && (R || L))){
            i=0;
            R=false;
            L=false;
        }
        if(t==6 && i==0){
            if(hien1.length()<s1.length()) hien1=hien1+s1.charAt(s);
            if(hien2.length()<s2.length()) hien2=hien2+s2.charAt(s);
            if(hien3.length()<s3.length()) hien3=hien3+s3.charAt(s);
            s=s+1;
        }
        if(t!=6){
            hien1="";  hien2=""; hien3="";
            s=0;
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(nen.getImage(), 0, 0, Game.width-6, Game.height-28, null);
        g.drawImage(trang[0].getImage(), xtrang[0]+80, 60, 800, 600, null);
        g.drawImage(trang[1].getImage(), xtrang[1]+80, 60, 800, 600, null);
        g.drawImage(trang[2].getImage(), xtrang[2]+10, 40, 900, 675, null);
        g.drawImage(trang[3].getImage(), xtrang[3]-100, 0, 960, 720, null);
        g.drawImage(trang[4].getImage(), xtrang[4]+80, 60, 800, 600, null);
        g.drawImage(quaphai.getImage(), 850, 310, 100, 100, null);
        g.drawImage(quatrai.getImage(), 5, 310, 100, 100, null);
        dong.render(g);
        g.setFont(new Font("VNI-Vivi", 3, 40));
        g.setColor(Color.WHITE);
        g.drawString(hien1, 50, 250);
        g.drawString(hien2, 150, 350);
        g.drawString(hien3, 250, 450);
    }

    @Override
    public Rectangle getbounds() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void ondong(){
        this.handler.addobject(new mainmenu(this.handler));
        this.handler.removeobject(this);
    }
    public void tieptheo(){
        if(t<6 && i==0){
            L=true;
            R=false;
            t=t+1;
        }
    }
    public void quaylai(){
        if(t>1 && i==0){
            L=false;
            R=true;
            t=t-1;
        }
    }
}
