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
public class Rankhonglo extends mauthe{
    public Rankhonglo() {
        this.hieuung = new hienvukhi(null, 1);
        this.hieuung2 = new hieuungchem(null);
        this.hp=27;
        this.at=12;
        this.df=0;
        this.sosao=4;
        this.numcard=5;
        //tongchiso:38
        this.tenthe = "Rankhonglo";
        this.anh= new ImageIcon("data/card/rankhonglo.png");
        this.note[0] = "Con rắn này thành";
        this.note[1] = "tinh rồi!";
        this.note[2] = "Siết chặt:";
        this.note[3] = "Khiến đối thủ mất";
        this.note[4] = "30% hp hiện tại";
        this.note[5] = "khi tấn công nó";
    }

    @Override
    public int tancong(){
        this.hieuung = new hienvukhi(null, 1);
        this.hieuung2 = new hieuungchem(null);
        return this.at;
    }

    @Override
    public void phongthu(Card dame) {
    	int k= (3*dame.gethp())/10;
        dame.sethp(dame.gethp()-k);
        int s=0;
        if(dame!=null) s= dame.tancong()-df;
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
