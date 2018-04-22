/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Center;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author TLiem
 */
public abstract class GameObject {
    
    protected int x,y;
    protected ID id;
    protected int velx,vely;//van toc di chuyen cua x va y
    protected Handler handler;
    
    public GameObject(int x,int y,ID id){
        this.x=x;
        this.y=y;
        this.id=id;
    }
    
    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract Rectangle getbounds();
    public void setHandler(Handler h){
        this.handler=h;
    }
    public void setx(int x){
        this.x=x;
    }
    
    public void sety(int y){
        this.y=y;
    }
    
    public void setid(ID id){
        this.id=id;
    }
    
    public int getx(){
        return x;
    }
    
    public int gety(){
        return y;
    }
    
    public ID getid(){
        return id;
    }
    
    public void setvelx(int velx){
        this.velx=velx;
    }
    
    public void setvely(int vely){
        this.vely=vely;
    }
    
    public int getvelx(){
        return velx;
    }
    
    public int getvely(){
        return vely;
    }
}
