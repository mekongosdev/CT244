/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Center;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
    
    LinkedList<GameObject> object=new LinkedList<GameObject>();
    
    public void tick(){
        for(int i=0;i<object.size();i++){
            GameObject tempobject=object.get(i);
            
            tempobject.tick();
        }
    }
    
    public void render(Graphics g){
        for(int i=0;i<object.size();i++){
            GameObject tempobject=object.get(i);
            
            tempobject.render(g);
        }
    }
    
    public void addobject(GameObject object){
        this.object.add(object);
        int k = Game.LS.loadn;
        Game.LS.loadn=k+1;
    }
    
    public void removeobject(GameObject object){
        this.object.remove(object);
    }
    public LinkedList<GameObject> getobject(){
		return object;
    }
}
