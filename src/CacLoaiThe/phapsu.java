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
public class phapsu extends mauthe{
    public phapsu() {
        //tong chi so: 10+15+4=29
        this.hieuung = new hienmatran(5, null, null);
        this.hieuung2 = new hieuungphep(null);
        this.hp=19;
        this.at=8;
        this.df=2;
        this.sosao=3;
        this.numcard=3;
        this.tenthe = "Phapsu";
        this.anh= new ImageIcon("data/card/phapsu.png");
        this.note[0] = ".....";
        this.note[1] = "";
        this.note[2] = "Hồi phục:";
        this.note[3] = "+2 hp sau mỗi lược!";
        this.note[4] = "";
        this.note[5] = "";
    }

    @Override
    public int tancong(){
        this.hieuung = new hienmatran(5, null, null);
        this.hieuung2 = new hieuungphep(null);
        return this.at;
    }
    @Override
    public void phongthu    (Card dame) {
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
        this.hp=this.hp+2;
    }

    @Override
    public int getsao() {
        return this.sosao;
    }
}
