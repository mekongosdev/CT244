/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CacLoaiThe;

import Interface.Card;
import Orther.hienvukhi;
import Orther.hieuungchem;
import javax.swing.ImageIcon;

/**
 *
 * @author TLiem
 */
public class solria extends mauthe{
    public solria() {
        //tongxhiso= 10+25+2=37;
        this.hieuung = new hienvukhi(null, 1);
        this.hieuung2 = new hieuungchem(null);
        this.hp=18;
        this.at=15;
        this.df=4;
        this.sosao=5;
        this.numcard=2;
        this.tenthe = "Solria";
        this.anh= new ImageIcon("data/card/solria.png");
        this.note[0] = "Sevant lớp Saber!";
        this.note[1] = "Gươm thần Gian: ";
        this.note[2] = "40% tỉ lệ x2 at";
        this.note[3] = "khi tấn công, tự";
        this.note[4] = "phản đòn, + 1hp";
        this.note[5] = "1df sau mỗi lượt";
    }

    @Override
    public int tancong(){
        int k=this.at;
        int r= (int) (Math.random()*100);
        if(r>=60){
            k=this.at*2;
            this.hieuung = new hienvukhi(null, 2);
            this.hieuung2 = new hieuungchem(null);
        }
        else {
            this.hieuung = new hienvukhi(null, 1);
            this.hieuung2 = new hieuungchem(null);
        }
        return k;
    }

    @Override
    public void phongthu(Card dame) {
        int s= dame.tancong()-df;
        if(s>0) this.hp=this.hp-s;
        if(this.hp>0){
            dame.sethp(dame.gethp()-(this.at-dame.getdf()));
        }
    }

    @Override
    public void HieuUngTruocTran() {
    }

    @Override
    public void HieuUngGiuaTran() {
    }

    @Override
    public void HieuUngSauTran() {
        this.hp=this.hp+1;
        this.df=this.df+1;
    }

    @Override
    public int getsao() {
        return this.sosao;
    }
}
