/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CacLoaiThe;

import Interface.Card;
import Orther.hienmatran;
import Orther.hieuungphep;
import javax.swing.ImageIcon;

/**
 *
 * @author TLiem
 */
public class phuthuy extends mauthe{
    public phuthuy() {
        this.hieuung = new hienmatran(2, null, null);
        this.hieuung2 = new hieuungphep(null);
        this.hp=17;
        this.at=8;
        this.df=4;
        this.sosao=3;
        this.numcard=3;
        this.tenthe = "Phuthuy";
        this.anh= new ImageIcon("data/card/phuthuy.png");
        this.note[0] = "Một phù thủy cổ điển.";
        this.note[1] = "";
        this.note[2] = "+1 tấn công trước";
        this.note[3] = "mỗi lược.";
        this.note[4] = "";
        this.note[5] = "";
    }

    @Override
    public int tancong(){
        this.hieuung = new hienmatran(2, null, null);
        this.hieuung2 = new hieuungphep(null);
        return this.at;
    }
    @Override
   public void phongthu(Card dame) {
        int s= dame.tancong()-df;
        if(s>0) this.hp=this.hp-s;
    }

    @Override
    public void HieuUngTruocTran() {
        this.at=this.at+1;
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
