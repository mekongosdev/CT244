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

/**
 *
 * @author TLiem
 */
public class dondep extends GameObject{
    public dondep(Handler h) {
        super(-100, -50, ID.kehuydiet);
        this.handler=h;
    }

    @Override
    public void tick() {
        this.y=this.y+50;
        if(this.y>1000) killmysell();
    }

    @Override
    public void render(Graphics g) {
    }

    @Override
    public Rectangle getbounds() {
        return new Rectangle(x, y, 1200, 10);
    }
    public void killmysell(){
        this.handler.addobject(new mainmenu(handler));
        this.handler.removeobject(this);
    }
}
