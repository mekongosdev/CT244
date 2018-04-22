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
public class Chimera extends mauthe{
    public Chimera() {
        //tong chi so: 10+4*5+2*2=34;
        this.hieuung = new hienvukhi(null, 1);
        this.hieuung2 = new hieuungchem(null);
        this.hp=20;
        this.at=10;
        this.df=4;
        this.sosao=4;
        this.numcard=3;
        this.tenthe = "Chimera";
        this.anh= new ImageIcon("data/card/chimera.png");
        this.note[0] = "Một con quái vật!";
        this.note[1] = "";
        this.note[2] = "Hóa đá: Khi bị";
        this.note[3] = "tấn công, sẽ khiến";
        this.note[4] = "mục tiêu mất 20%";
        this.note[5] = "hp";
    }

    @Override
    public int tancong(){
        this.hieuung = new hienvukhi(null, 1);
        this.hieuung2 = new hieuungchem(null);
        return this.at;
    }

    @Override
    public void phongthu(Card dame) {
        int s= dame.tancong()-df;
        if(s>0) this.hp=this.hp-s;
        int k= dame.gethp()/5;
        if(k<=0) k=1;
        if(this.hp>0) dame.sethp(dame.gethp()-k);
    }

    @Override
    public void HieuUngTruocTran() {
    }

    @Override
    public void HieuUngGiuaTran() {
    }

    @Override
    public void HieuUngSauTran() {
    }

    @Override
    public int getsao() {
        return this.sosao;
    }
}
