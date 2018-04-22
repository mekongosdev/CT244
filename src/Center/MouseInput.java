/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Center;
import CacLoaiThe.mauthe;
import CardObject.BoBai;
import CardObject.InfoThe;
import CardObject.KieuTheBai;
import CardObject.banco;
import Orther.Huongdan;
import Orther.bangxephang;
import Orther.button;
import Orther.chosemenu;
import Orther.dondep;
import Orther.mainmenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 *
 * @author TLiem
 */
public class MouseInput extends MouseAdapter{
    private Handler handler;
    public MouseInput(Handler h){
    this.handler=h;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int xm, ym;
        xm=e.getX();
        ym=e.getY();
        //KieuTheBai[] BaiA = new KieuTheBai[7];
        //KieuTheBai[] trentay = new KieuTheBai[5];
        //KieuTheBai recard = null;
        //KieuTheBai Outcard = null;
        boolean xuonbai=false;
        for(int i=0;i<handler.object.size();i++){
            GameObject tempobject=handler.object.get(i);
            if(tempobject.getid()==ID.banco){
                banco A= (banco) tempobject;
                if(onbutton(A.button1, xm, ym)&& A.chonguoichoi==true){
                    A.button1.onchose();
                }
                if(onbutton(A.buttonthoat, xm, ym)){
                    A.buttonthoat.onchose();
                }
                if(onbutton(A.buttonluu, xm, ym) && A.chonguoichoi==true){
                    A.buttonluu.onchose();
                }
            }
            if(tempobject.getid()==ID.menu){
                mainmenu a = (mainmenu) tempobject;
                if(onbutton(a.batdau, xm, ym)){
                    a.batdau.onchose();
                }
                if(onbutton(a.thanhtich, xm, ym)){
                    a.thanhtich.onchose();
                }
                if(onbutton(a.huongdan, xm, ym)){
                    a.huongdan.onchose();
                }
                if(onbutton(a.thoat, xm, ym)){
                    a.thoat.onchose();
                }
                if(onbutton(a.tiep, xm, ym)){
                    a.tiep.onchose();
                }
            }
            if(tempobject.getid()==ID.bangxephang){
                bangxephang bxh =(bangxephang) tempobject;
                if(onbutton(bxh.vmenu, xm, ym)){
                    bxh.vmenu.onchose();
                }
            }
            if(tempobject.getid()==ID.menuchonlua){
                chosemenu cm = (chosemenu) tempobject;
                if(onbutton(cm.chon, xm, ym)){
                    cm.chon.onchose();
                }
                if(onbutton(cm.trolai, xm, ym)){
                    cm.trolai.onchose();
                }
            }
            if(tempobject.getid()==ID.huongdan){
                Huongdan hd= (Huongdan) tempobject;
                if(onbutton(hd.dong, xm, ym)){
                    hd.dong.onchose();
                }
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int xm, ym;
        xm=e.getX();
        ym=e.getY();
        KieuTheBai[] BaiA = new KieuTheBai[7];
        KieuTheBai[] Trentay = new KieuTheBai[5];
        KieuTheBai outcard=null;
        KieuTheBai recard = null;
        boolean xuonbai=false;
        int tem=0;
        int max=0;
        for(int i=0;i<handler.object.size();i++){
            GameObject tempobject=handler.object.get(i);
            if(tempobject.getid()==ID.card){
                KieuTheBai bai = (KieuTheBai) tempobject;
                BaiA[bai.getvitri()] = bai;
            }
            if(tempobject.getid()==ID.card && xm>tempobject.getx() && xm<tempobject.getx()+100 && ym>tempobject.gety()&& ym<tempobject.gety()+170){
                KieuTheBai k = (KieuTheBai) tempobject;
                if(k.getvitri()!=0) outcard = (KieuTheBai) tempobject;
            }
            if(tempobject.getid()==ID.recard){
                KieuTheBai k = (KieuTheBai) tempobject;
                Trentay[k.getvitri()-1] = k;
            }
            if(tempobject.getid()==ID.recard && xm>tempobject.getx() && xm<tempobject.getx()+100 && ym>tempobject.gety()&& ym<tempobject.gety()+170){
                recard = (KieuTheBai) tempobject;
            }
            if(tempobject.getid()==ID.banco){
                banco bc = (banco) tempobject;
                xuonbai = bc.chonguoichoi;
                tem=bc.temA;
                max=bc.maxA;
                if(onbutton(bc.button1, xm, ym) && bc.chonguoichoi==true){    
                    bc.button1.ondischose();
                    bc.sansang();
                }
                if(onbutton(bc.buttonthoat, xm, ym)){
                    bc.buttonthoat.ondischose();
                    this.handler.addobject(new dondep(handler));
                    Game.onplay=false;
                }
                if(onbutton(bc.buttonluu, xm, ym)&& bc.chonguoichoi){
                    bc.buttonluu.ondischose();
                    bc.save();
                }
            }
            if(tempobject.getid()==ID.menu){
                mainmenu a = (mainmenu) tempobject;
                if(onbutton(a.batdau, xm, ym)){
                    a.batdau.ondischose();
                    a.inplay();
                    a.handler.removeobject(a);
                }
                if(onbutton(a.thanhtich, xm, ym)){
                    a.thanhtich.ondischose();
                    a.inthanhtich();
                    a.handler.removeobject(a);
                }
                if(onbutton(a.huongdan, xm, ym)){
                    a.huongdan.ondischose();
                    a.inhuongdan();
                    a.handler.removeobject(a);
                }
                if(onbutton(a.thoat, xm, ym)){
                    a.thoat.ondischose();
                    a.thoat();
                }
                if(onbutton(a.tiep, xm, ym)){
                    a.tiep.ondischose();
                    a.inload();
                }
            }
            if(tempobject.getid()==ID.bangxephang){
                bangxephang bxh =(bangxephang) tempobject;
                if(onbutton(bxh.vmenu, xm, ym)){
                    bxh.vmenu.ondischose();
                    bxh.trovemenu();
                }
            }
            if(tempobject.getid()==ID.menuchonlua){
                chosemenu cm = (chosemenu) tempobject;
                if(onbutton(cm.chon, xm, ym)){
                    cm.chon.ondischose();
                    cm.onchon();
                }
                if(onbutton(cm.trolai, xm, ym)){
                    cm.trolai.onchose();
                    cm.ontrolai();
                }
                for(int j=0; j<4; j++){
                    if(xm>cm.the[j].x && xm<cm.the[j].x+100 && ym>cm.the[j].y && ym<cm.the[j].y+170){
                        cm.setchon(j+1);
                    }
                }
                for(int j=4; j<8; j++){
                    if(xm>cm.the[j].x && xm<cm.the[j].x+100 && ym>cm.the[j].y && ym<cm.the[j].y+170){
                        cm.sevantchon=j-3;
                    }
                }
            }
            if(tempobject.getid()==ID.huongdan){
                Huongdan hd = (Huongdan) tempobject;
                if(xm>850 && xm<950 && ym>310 && ym<410){
                    hd.tieptheo();
                }
                if(xm>5 && xm<105 && ym>310 && ym<410){
                    hd.quaylai();
                }
                if(onbutton(hd.dong, xm, ym)){
                    hd.dong.ondischose();
                    hd.ondong();
                }
            }
        }
        if(recard!= null && recard.getCard()!=null && xuonbai && tem+recard.getCard().numcard<=max){
            for(int i=1; i<7; i++){
                if(BaiA[i].getCard()==null){
                    BaiA[i].setCard(recard.getCard());
                    recard.setCard(null);
                    break;
                }
            }
        }
        if(outcard!= null && outcard.getCard()!=null && xuonbai){
            for(int i=0; i<5; i++){
                if(Trentay[i].getCard()==null){
                	Trentay[i].setCard(outcard.getCard());
                    outcard.setCard(null);
                    break;
                }
            }
        }
    }
    public boolean onbutton(button b, int xl, int yl){
        if(xl>b.x && xl<b.x+b.width && yl>b.y && yl<b.y+b.height) return true;
        else return false;
    }
}
