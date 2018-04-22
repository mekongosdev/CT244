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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class bangxephang extends GameObject{
    String[] name = new String[10];
    int[] soturn = new int[10];
    int[] sobai = new int [10];
    mainmenu m;
    ImageIcon nen = new ImageIcon("data/an/nen2.png");
    public button vmenu;
    public bangxephang(Handler h) {
        super(0, 0, ID.bangxephang);
        this.handler=h;
        for(int i=0; i<10; i++){
            name[i]="noname";
            soturn[i]=9999;
            sobai[i]=40;
        }
        loadbangxephang();
        vmenu= new button(810, 580, 100, 50, new ImageIcon("data/an/vemenu.png"));
    }

    @Override
    public void tick() {
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(nen.getImage(), 0, 0, Game.width-6, Game.height-28, null);
        g.setFont(new Font("VNI-Vivi", 3, 50));
        g.drawString("Baûng xeáp haïng:", 80, 75);
        g.setFont(new Font("VNI-Vivi", Font.ITALIC, 40));
        for(int i=0; i<10; i++){
            g.drawString(""+(i+1), 90, 160+i*50);
            g.drawString(name[i], 200, 160+i*50);
            g.drawString(""+soturn[i], 500, 160+i*50);
            g.drawString(""+sobai[i], 700, 160+i*50);
        }
        g.setColor(Color.red);
        g.drawString("Haïng", 50, 120);
        g.drawString("Teân", 200, 120);
        g.drawString("Soá löôït", 500, 120);
        g.drawString("Soá baøi duøng", 700, 120);
        vmenu.render(g);
    }

    @Override
    public Rectangle getbounds() {
        return new Rectangle(0, 0, 100, 100);
    }
    public void loadbangxephang(){
        InputStream is;
        try {
            is = new FileInputStream("data/save/bxh");
            Scanner s= new Scanner(is);
            for(int i=0; i<10; i++){
                name[i]=s.nextLine();
                soturn[i] = s.nextInt(); s.nextLine();
                sobai[i] = s.nextInt(); s.nextLine();
            }
            s.close();
            is.close();
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
            Logger.getLogger(bangxephang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void trovemenu(){
        m= new mainmenu(this.handler);
        this.handler.addobject(m);
        this.handler.removeobject(this);
    }
}
