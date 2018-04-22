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
public class maxuong extends mauthe{
    public maxuong() {
        this.hieuung = new hienvukhi(null, 1);
        this.hieuung2 = new hieuungchem(null);
        this.hp=17;
        this.at=4;
        this.df=1;
        this.sosao=2;
        this.numcard=2;
        this.tenthe = "Maxuong";
        this.anh= new ImageIcon("data/card/maxuong.png");
        this.note[0] = "Một con ma xương";
        this.note[1] = "yếu ớt.";
        this.note[2] = "";
        this.note[3] = "";
        this.note[4] = "";
        this.note[5] = "";
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
