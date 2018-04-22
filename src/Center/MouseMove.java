/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Center;

import CacLoaiThe.mauthe;
import CardObject.InfoThe;
import CardObject.KieuTheBai;
import CardObject.banco;
import Orther.Huongdan;
import Orther.button;
import Orther.chosemenu;
import Orther.mainmenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author TLiem
 */
public class MouseMove extends MouseAdapter{
    Handler handler;
     public MouseMove(Handler h){
        this.handler=h;
    }
    @Override
    public void mouseMoved(MouseEvent e) {
        mauthe recard = null;
        InfoThe info = null;
         for(int i=0;i<handler.object.size();i++){
            GameObject tempobject=handler.object.get(i);
            if((tempobject.getid()== ID.ecard || tempobject.getid()== ID.card || tempobject.getid()== ID.recard || tempobject.getid()==ID.chonmaster || tempobject.getid()==ID.chonsevant) 
                    && (e.getX()>tempobject.getx() && e.getX()<tempobject.getx()+100 && e.getY()>tempobject.gety() && e.getY()<tempobject.gety()+170))
            {
                KieuTheBai A = (KieuTheBai) tempobject;
                recard= A.getCard();

            }
            if(tempobject.getid()==ID.infocard){
                info = (InfoThe) tempobject;
            }
         }
         if(info!=null) info.Char=recard;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int xm, ym;
        xm=e.getX();
        ym=e.getY();
        for(int i=0;i<handler.object.size();i++){
            GameObject tempobject=handler.object.get(i);
            if(tempobject.getid()==ID.banco){
                banco A= (banco) tempobject;
                if(!onbutton(A.button1, xm, ym) && A.button1.chose){
                    A.button1.ondischose();
                }
                if(onbutton(A.button1, xm, ym) && A.button1.chose==false && A.chonguoichoi==true){
                    A.button1.onchose();
                }
                if(!onbutton(A.buttonthoat, xm, ym) && A.buttonthoat.chose){
                    A.buttonthoat.ondischose();
                }
                if(onbutton(A.buttonthoat, xm, ym) && A.buttonthoat.chose==false){
                    A.buttonthoat.onchose();
                }
                if(!onbutton(A.buttonluu, xm, ym) && A.buttonluu.chose){
                    A.buttonluu.ondischose();
                }
                if(onbutton(A.buttonluu, xm, ym) && A.buttonluu.chose==false && A.chonguoichoi){
                    A.buttonluu.onchose();
                }
            }
            if(tempobject.getid()==ID.menu){
                mainmenu a = (mainmenu) tempobject;
                if(onbutton(a.batdau, xm, ym) && a.batdau.chose==false){
                    a.batdau.onchose();
                }
                if(!onbutton(a.batdau, xm, ym) && a.batdau.chose){
                    a.batdau.ondischose();
                }
                if(onbutton(a.thanhtich, xm, ym) && a.thanhtich.chose==false){
                    a.thanhtich.onchose();
                }
                if(!onbutton(a.thanhtich, xm, ym) && a.thanhtich.chose){
                    a.thanhtich.ondischose();
                }
                if(onbutton(a.huongdan, xm, ym) && a.huongdan.chose==false){
                    a.huongdan.onchose();
                }
                if(!onbutton(a.huongdan, xm, ym) && a.huongdan.chose){
                    a.huongdan.ondischose();
                }
                if(onbutton(a.thoat, xm, ym) && a.thoat.chose==false){
                    a.thoat.onchose();
                }
                if(!onbutton(a.thoat, xm, ym) && a.thoat.chose){
                    a.thoat.ondischose();
                }
                if(onbutton(a.tiep, xm, ym) && a.tiep.chose==false){
                    a.tiep.onchose();
                }
                if(!onbutton(a.tiep, xm, ym) && a.tiep.chose){
                    a.tiep.ondischose();
                }
            }
            if(tempobject.getid()==ID.menuchonlua){
                chosemenu cm = (chosemenu) tempobject;
                if(onbutton(cm.chon, xm, ym) && cm.chon.chose==false){
                    cm.chon.onchose();
                }
                if(!onbutton(cm.chon, xm, ym) && cm.chon.chose){
                    cm.chon.ondischose();
                }
                if(onbutton(cm.trolai, xm, ym) && cm.trolai.chose==false){
                    cm.trolai.onchose();
                }
                if(!onbutton(cm.trolai, xm, ym) && cm.trolai.chose){
                    cm.trolai.ondischose();
                }
            }
            if(tempobject.getid()==ID.huongdan){
                Huongdan hd= (Huongdan) tempobject;
                if(onbutton(hd.dong, xm, ym) && hd.dong.chose==false){
                    hd.dong.onchose();
                }
                if(!onbutton(hd.dong, xm, ym) && hd.dong.chose){
                    hd.dong.ondischose();
                }
            }
        }
    }
    public boolean onbutton(button b, int xl, int yl){
        if(xl>b.x && xl<b.x+b.width && yl>b.y && yl<b.y+b.height) return true;
        else return false;
    }
}
