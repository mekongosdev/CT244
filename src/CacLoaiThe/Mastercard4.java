package CacLoaiThe;

import javax.swing.ImageIcon;

import CardObject.KieuTheBai;
import Center.GameObject;
import Center.Handler;
import Center.ID;
import Interface.Card;
import Orther.hienmatran;
import Orther.hienvukhi;
import Orther.hieuungphep;

public class Mastercard4 extends mauthe{
	public int maxnum=12;
    Handler handler;
    ID id;
    int x, y;
    public Mastercard4(Handler h, ID i, int x, int y){
        this.hieuung=new hienvukhi(h, 1);
        this.hieuung2= new hienvukhi(h, 2);
        this.hp=25;
        this.at=0;
        this.df=0;
        this.x=x; this.y=y;
        this.numcard=0;
        this.tenthe="Master4";
        this.sosao=0;
        this.handler=h;
        this.id=i;
        this.anh = new ImageIcon("data/card/summoner4.png");
        this.note[0] = "Tôi là ai ư? ";
        this.note[1] = "Một hầu gái chăm";
        this.note[2] = "chỉ, vậy thôi.";
        this.note[3] = "Chu đáo: +1hp";
        this.note[4] = "cho toàn bộ bài";
        this.note[5] = "cùng phe.";
    }

    @Override
    public int tancong() {
        return 0;
    }

    @Override
    public void phongthu(Card dame) {
        this.hp=this.hp-dame.getsao();
    }
    

    @Override
    public void HieuUngGiuaTran() {
    }

    @Override
    public void HieuUngTruocTran() {
        KieuTheBai[] BaiA = new KieuTheBai[6];
        for(int i=0;i<handler.getobject().size();i++){
            GameObject tempobject=handler.getobject().get(i);
            if(tempobject.getid()==this.id){
                KieuTheBai Bai = (KieuTheBai) tempobject;
                if(Bai.getvitri()>=1){ 
                    BaiA[Bai.getvitri()-1] = Bai;
                }
            }
        }
        for(int i=0; i<6; i++){
        	if(BaiA[i].getCard()!=null){
        		this.handler.addobject(new hienmatran(x, y+35, 1, handler, new hieuungphep(BaiA[i].getx()-50, BaiA[i].gety()-15, handler)));
        		BaiA[i].getCard().hp=BaiA[i].getCard().hp+1;
        	}
        }
    }

    @Override
    public void HieuUngSauTran() {
    }

    @Override
    public int getsao() {
        return this.maxnum;
    }
}
