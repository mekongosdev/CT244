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
public class Caytinh extends mauthe{
    public Caytinh() {
    	//tong chi so: 10+15+2
        this.hieuung = new hienvukhi(null, 1);
        this.hieuung2 = new hieuungchem(null);
        this.hp=17;
        this.at=6;
        this.df=4;
        this.sosao=3;
        this.numcard=3;
        this.tenthe = "Yeutinhcay";
        this.anh= new ImageIcon("data/card/macay.png");
        this.note[0] = "Cây:'Sống lâu quá";
        this.note[1] = "thành tinh ấy mà.'";
        this.note[2] = "Yêu cây: hồi 1hp";
        this.note[3] = "khi tấn công, hồi";
        this.note[4] = "1 hp sau mỗi lượt";
        this.note[5] = "";
    }

    @Override
    public int tancong(){
        this.hieuung = new hienvukhi(null, 1);
        this.hieuung2 = new hieuungchem(null);
        this.hp=this.hp+1;
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
    	this.hp=this.hp+1;
    }

    @Override
    public int getsao() {
        return this.sosao;
    }
}
