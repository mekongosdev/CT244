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
public class thur extends mauthe{
    public thur() {
        //tongchiso=41;
        this.hieuung = new hienvukhi(null, 1);
        this.hieuung2 = new hieuungchem(null);
        this.hp=20;
        this.at=18;
        this.df=3;
        this.sosao=5;
        this.numcard=4;
        this.tenthe = "Thur";
        this.anh= new ImageIcon("data/card/thur.png");
        this.note[0] = "Sevant lớp Archer!";
        this.note[1] = "Con gái của thần sấm:";
        this.note[2] = "Có 30% tỉ lệ không bị";
        this.note[3] = "sát thương.";
        this.note[4] = "Điên cuồn: nếu hp<20";
        this.note[5] = "at=at+20-hp.";
    }

    @Override
    public int tancong(){
        int k = 20-hp;
        if(k<0) k=0;
        this.hieuung = new hienvukhi(null, 1);
        this.hieuung2 = new hieuungchem(null);
        return (this.at + k);
    }

    @Override
    public void phongthu(Card dame) {
        int r= (int) (Math.random()*100);
        if(r>30){
            int s= dame.tancong()-df;
            if(s>0) this.hp=this.hp-s;   
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
    }

    @Override
    public int getsao() {
        return this.sosao;
    }
}
