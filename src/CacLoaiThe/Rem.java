package CacLoaiThe;

import javax.swing.ImageIcon;

import Interface.Card;
import Orther.hienvukhi;
import Orther.hieuungchem;

public class Rem extends mauthe{
	public Rem() {
        //tongchiso=39;
        this.hieuung = new hienvukhi(null, 1);
        this.hieuung2 = new hieuungchem(null);
        this.hp=17;
        this.at=17;
        this.df=5;
        this.sosao=5;
        this.numcard=3;
        this.tenthe = "Rem";
        this.anh= new ImageIcon("data/card/rem.png");
        this.note[0] = "Breserker Sevant!";
        this.note[1] = "Đốn tim: phản công";
        this.note[2] = "-1df của đối thủ";
        this.note[3] = "Hăng máu:sau mỗi";
        this.note[4] = "lượt -1df, +4hp,";
        this.note[5] = "+1at, dừng khi df=0";
    }

    @Override
    public int tancong(){
        this.hieuung = new hienvukhi(null, 1);
        this.hieuung2 = new hieuungchem(null);
        return (this.at);
    }

    @Override
    public void phongthu(Card dame) {
    	int s= dame.tancong()-df;
    	if(s>0) this.hp=this.hp-s;
    	if(hp>0){
    		int k = this.at-dame.getdf();
    		if(k<0) k=1;
    		dame.sethp(dame.gethp()-k);
    		dame.setdf(dame.getdf()-1);
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
    	if(this.df>0){
    		this.df=this.df-1;
    		this.hp=this.hp+4;
    		this.at=this.at+1;
    	}
    }

    @Override
    public int getsao() {
        return this.sosao;
    }
}
