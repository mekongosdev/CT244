/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Orther;

import Center.GameObject;
import Center.ID;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author TLiem
 */
public class button{
    public int x, xc, y, yc, width, height, widthC, heightC, dw, dh, dx, dy;
    ImageIcon anh;
    public boolean chose=false;
    public button(int x, int y, int w, int h, ImageIcon nut) {
        this.x=x;
        this.y=y;
        this.anh=nut;
        this.width=w;
        this.height=h;
        widthC = width-10;
        heightC = height-10;
        xc=this.x+5;
        yc=this.y+5;
        dw=width;
        dh=height;
        dx=this.x;
        dy=this.y;
    }

    public void render(Graphics g) {
        g.drawImage(anh.getImage(), dx, dy, dw, dh, null);
    }
    public void onchose(){
        dw=widthC;
        dh=heightC;
        dx=xc;
        dy=yc;
    	/*this.width=this.width-10;
        this.height=this.height-10;
        this.x=this.x+5;
        this.y=this.y+5;*/
        chose=true;
    }
    public void ondischose(){
        dw=width;
        dh=height;
        dx=x;
        dy=y;
    	/*this.width=this.width+10;
        this.height=this.height+10;
        this.x=this.x-5;
        this.y=this.y-5;*/
        chose=false;
    }
}
