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
public class Kiemsibacthay extends mauthe{
    public Kiemsibacthay() {
        this.hieuung = new hienvukhi(null, 1);
        this.hieuung2 = new hieuungchem(null);
        this.hp=15;
        this.at=8;
        this.df=2;
        this.sosao=3;
        this.numcard=1;
        this.tenthe = "Kiemsibacthay";
        this.anh= new ImageIcon("data/card/kiemsi3.png");
        this.note[0] = "Bặc thầy trong kiếm";
        this.note[1] = "thuật, có khả năng ";
        this.note[2] = "thích nghi với trận";
        this.note[3] = "đấu!";
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
        if(dame.getsao()>this.sosao){
            this.df=this.df+2;
        }
        if(dame.getsao()<this.sosao){
            this.hp=this.hp+2;
        }
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
