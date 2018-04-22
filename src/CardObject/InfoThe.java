/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CardObject;

import CacLoaiThe.mauthe;
import Center.GameObject;
import Center.Handler;
import Center.ID;
import Center.Setting;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author TLiem
 */
public class InfoThe extends GameObject{
    public mauthe Char = null;
    int width=200;
    int height = (width*34)/20;
    int sosao;
    ImageIcon anull = new ImageIcon("data/card/null.png");
    public InfoThe(int x, int y, Handler h, mauthe ch) {
        super(x, y, ID.infocard);
        this.handler= h;
        this.Char=ch;
    }

    @Override
    public void tick() {
        if(Char!=null) this.sosao=Char.getsao(); else this.sosao=0;
        collision();
    }

    @Override
    public void render(Graphics g) {
        if(Char!=null){
            if(Char.tenthe!="Master1" && Char.tenthe!="Master2" && Char.tenthe!="Master3" && Char.tenthe!="Master4"){
                if(Char!=null)g.drawImage(Char.anh.getImage(), x, y, width, height, null);
                for(int i=0; i<sosao; i++){
                    if(Char!=null) g.drawImage(Char.sau.getImage(), x+165-(i*28), y+60, 30, 30, null);
                }
                g.setColor(Color.WHITE);
                g.setFont(new Font("Freestyle Script", Font.BOLD, 32));
                if(Char!=null){if(Char.numcard<10) g.drawString(""+Char.numcard, x+18, y+83); else g.drawString(""+Char.numcard, x+11, y+83);}
                g.setColor(Color.BLACK);
                g.setFont(new Font("Monotype Corsiva", Font.BOLD, 22));
                if(Char!=null)g.drawString(""+Char.hp, x+24, y+327);
                if(Char!=null)g.drawString(""+Char.at, x+94, y+327);
                if(Char!=null)g.drawString(""+Char.df, x+160, y+327);
            }
            else{
                if(Char!=null)g.drawImage(Char.anh.getImage(), x, y, width, height, null);
                g.setColor(Color.WHITE);
                g.setFont(new Font("Monotype Corsiva", Font.BOLD, 60));
                if(Char!=null)g.drawString(""+Char.hp, x+113, y+300);
                g.setColor(Color.BLACK);
                if(Char!=null)g.drawString(""+Char.hp, x+110, y+297);
            }
            g.setColor(Color.BLACK);
            g.setFont(new Font("Calibri", Font.BOLD, 18));
            for(int i=0; i<6; i++) if(Char!=null) g.drawString(Char.note[i], x+30, y+360 +i*20);
        } else g.drawImage(anull.getImage(), x, y, width, height, null);
    }

    @Override
    public Rectangle getbounds() {
        return new Rectangle(x, y, this.width, this.height);
    }
    public void collision(){
        for(int i=0;i<handler.getobject().size();i++){
            GameObject tempobject=handler.getobject().get(i);
            if(tempobject.getid()==ID.kehuydiet){
                if(getbounds().intersects(tempobject.getbounds())){
                    this.handler.removeobject(this);
                }
            }
        }
    }
    
    
    
}
