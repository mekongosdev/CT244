/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CacLoaiThe;

import CardObject.KieuTheBai;
import Center.GameObject;
import Center.Handler;
import Center.ID;
import Interface.Card;
import Orther.hienmatran;
import Orther.hienvukhi;
import Orther.hieuungphep;
import javax.swing.ImageIcon;

/**
 *
 * @author TLiem
 */
public class Mastercard1 extends mauthe{
    public int maxnum=10;
    Handler handler;
    ID id;
    int x, y;
    public Mastercard1(Handler h, ID i, int x, int y){
        this.hieuung=new hienvukhi(h, 1);
        this.hieuung2= new hienvukhi(h, 2);
        this.hp=30;
        this.at=0;
        this.df=0;
        this.x=x; this.y=y;
        this.numcard=0;
        this.tenthe="Master1";
        this.sosao=0;
        this.handler=h;
        this.id=i;
        this.anh = new ImageIcon("data/card/summoner1.png");
        this.note[0] = "Triệu hồn sư: 'Ta ";
        this.note[1] = "chỉ là một tên nhân";
        this.note[2] = "viên quèn mà thôi!'";
        this.note[3] = "Mỗi lượt: +1 hp và";
        this.note[4] = "1 tấn công cho 1 ";
        this.note[5] = "lá bài phe ta.";
    }

    @Override
    public int tancong() {
        return 0;
    }

    @Override
    public void phongthu(Card dame) {
        this.hp=this.hp-dame.getsao();
    }
    

    @Override
    public void HieuUngGiuaTran() {
    }

    @Override
    public void HieuUngTruocTran() {
        KieuTheBai[] BaiA = new KieuTheBai[6];
        for(int i=0;i<handler.getobject().size();i++){
            GameObject tempobject=handler.getobject().get(i);
            if(tempobject.getid()==this.id){
                KieuTheBai Bai = (KieuTheBai) tempobject;
                if(Bai.getvitri()>=1){ 
                    BaiA[Bai.getvitri()-1] = Bai;
                }
            }
        }
        boolean k=false;
        boolean[] dd = new boolean[6];
        for(int i=0; i<6; i++) dd[i]=false;
        int i=0;
        while(k==false){
            i=((int)(Math.random()*59))/10;
            if(BaiA[i].getCard()!=null) k=true;
            else dd[i]=true;
            if(dd[0] && dd[1] && dd[2] && dd[3] && dd[4] && dd[5]) k=true;
        }
        if(BaiA[i].getCard()!=null){
         this.handler.addobject(new hienmatran(x, y+35, 1, handler, new hieuungphep(BaiA[i].getx()-50, BaiA[i].gety()-15, handler)));
         BaiA[i].getCard().at= BaiA[i].getCard().at+1;
         BaiA[i].getCard().hp=BaiA[i].getCard().hp+1;
        }
    }

    @Override
    public void HieuUngSauTran() {
    }

    @Override
    public int getsao() {
        return this.maxnum;
    }
    
}
