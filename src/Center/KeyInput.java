/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Center;

import Orther.chosemenu;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author TLiem
 */
public class KeyInput extends KeyAdapter {
    private Handler handler;
    public KeyInput(Handler handler){
        this.handler=handler;
    }
    
    public void keyPressed(KeyEvent e){
        //char key= e.getKeyChar();
    }
    public void keyReleased(KeyEvent e){
        int key=e.getKeyCode();
        
        for(int i=0;i<handler.object.size();i++){
            GameObject tempobject=handler.object.get(i);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char key= e.getKeyChar();
        for(int i=0;i<handler.object.size();i++){
            GameObject tempobject=handler.object.get(i);
            if(tempobject.getid()==ID.menuchonlua){
                chosemenu cm = (chosemenu) tempobject;
                if(e.getKeyChar()!=KeyEvent.VK_BACK_SPACE && e.getKeyChar()!=KeyEvent.VK_ESCAPE && e.getKeyChar()!=KeyEvent.VK_ENTER && cm.nhapten.length()<10){
                    cm.xv=cm.xv+14.8;
                    cm.nhapten=cm.nhapten+key;
                }
                if(e.getKeyChar()==KeyEvent.VK_BACK_SPACE){
                    if(cm.nhapten.length()>0){
                        cm.nhapten=cm.nhapten.substring(0, cm.nhapten.length()-1);
                        cm.xv=cm.xv-14.8;
                    }
                }
            }
        }
    }
    
    
}
