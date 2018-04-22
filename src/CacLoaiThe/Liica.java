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
public class Liica extends mauthe{
    public Liica() {
        this.hieuung = new hienvukhi(null, 1);
        this.hieuung2 = new hieuungchem(null);
        this.hp=15;
        this.at=18;
        this.df=2;
        this.sosao=5;
        this.numcard=1;
        this.tenthe = "Liica";
        this.anh= new ImageIcon("data/card/Liica.png");
        this.note[0] = "Sevant lớp caster!";
        this.note[1] = "Caster của sự ngây";
        this.note[2] = "thơ: 100% phản sát";
        this.note[3] = "thương!";
        this.note[4] = "+2hp trước trận";
        this.note[5] = "+1dp,+1hp sau trận";
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
        int k=dame.getat()-dame.getdf();
        if(k<1) k=1;
        dame.sethp(dame.gethp()-k);
    }

    @Override
    public void HieuUngTruocTran() {
        this.hp=this.hp+2;
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
