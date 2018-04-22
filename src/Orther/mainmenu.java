/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Orther;

import CardObject.banco;
import Center.Game;
import Center.GameObject;
import Center.Handler;
import Center.ID;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.File;
import javax.swing.ImageIcon;

/**
 *
 * @author TLiem
 */
public class mainmenu extends GameObject{
    banco bc;
    bangxephang bxh;
    Huongdan hd;
    public button batdau, thanhtich, huongdan, thoat, tiep;
    ImageIcon nen = new ImageIcon("data/an/nen.png");
    public mainmenu(Handler h) {
        super(0, 0, ID.menu);
        this.handler=h;
        batdau = new button(50, 150, 150, 75, new ImageIcon("data/an/menubt6.png"));
        tiep = new button(50, 250, 150, 75, new ImageIcon("data/an/load.png"));
        thanhtich = new button(50, 350, 150, 75, new ImageIcon("data/an/menubt5.png"));
        huongdan = new button(50, 450, 150, 75, new ImageIcon("data/an/menubt3.png"));
        thoat = new button(50, 550, 150, 75, new ImageIcon("data/an/menubt2.png"));
    }

    @Override
    public void tick() {
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(nen.getImage(), 0, 0, Game.width-6, Game.height-28, null);
        g.setFont(new Font("VNI-Vivi", 3, 70));
        g.setColor(java.awt.Color.decode("#7b7b7b"));
        g.drawString("Summoner", 35, 100);
        g.setFont(new Font("VNI-Vivi", 3, 50));
        g.setColor(java.awt.Color.decode("#000000"));
        g.drawString("Summoner", 90, 110);
        batdau.render(g);
        tiep.render(g);
        thanhtich.render(g);
        huongdan.render(g);
        thoat.render(g);
    }

    @Override
    public Rectangle getbounds() {
        return null;
    }
    public void inplay(){
        this.handler.addobject(new chosemenu(this.handler));
        this.handler.removeobject(this);
    }
    public void thoat(){
        System.exit(0);
    }
    public void inload(){
        File f= new File("data/save/trochoi");
        if(f.exists()){
            bc= new banco(0, 0, ID.banco, this.handler);
            bc.load();
            this.handler.addobject(bc);
            this.handler.removeobject(this);
        }
        else{
            thongbao thong = new thongbao(300, 200, this.handler);
            thong.s[1] = "Khoâng tìm thaáy save!";
            thong.s[2]= "Taïi sau baïn khoâng";
            thong.s[3]="thöû chôi môùi";
            thong.s[4]= "vaø taïo save.";
            this.handler.addobject(thong);
        }
    }
    public void inthanhtich(){
        bxh = new bangxephang(this.handler);
        this.handler.addobject(bxh);
    }
    public void inhuongdan(){
        hd= new Huongdan(this.handler);
        this.handler.addobject(hd);
    }
}
