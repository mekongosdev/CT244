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
public class Zombie extends mauthe{
    public Zombie() {
    	//tong chi so: 10+15=25
        this.hieuung = new hienvukhi(null, 1);
        this.hieuung2 = new hieuungchem(null);
        this.hp=35;
        this.at=10;
        this.df=0;
        this.sosao=3;
        this.numcard=1;
        this.tenthe = "Zombie";
        this.anh= new ImageIcon("data/card/zombie.png");
        this.note[0] = "Xác sống sở hữu";
        this.note[1] = "lượng hp đặc ";
        this.note[2] = "biệt cao.";
        this.note[3] = "Xác sống: +20hp";
        this.note[4] = "Thủ thực: giảm";
        this.note[5] = "1hp của kẻ thù";
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
        dame.sethp(dame.gethp()-1);
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
