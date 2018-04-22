/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CardObject;

import CacLoaiThe.mauthe;
import Center.GameObject;
import Center.Handler;
import Center.ID;
import Interface.Card;
import Orther.hienvukhi;
import Orther.hieuungchem;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author TLiem
 */
public class KieuTheBai extends GameObject {
    mauthe Char=null;
    KieuTheBai temp=null;
    ImageIcon anull = new ImageIcon("data/card/null.png");
    int turn, vitri, muctieu, hieuung, dm;
    int width=100;
    int height = (width*34)/20;
    final int choturn=0;
    final int dautran=1;
    final int giuatran=2;
    final int cuoitran=3;
    public KieuTheBai(int x, int y, ID id, Handler h, mauthe ch, int vt) {
        super(x, y, id);
        this.handler =h;
        this.Char = ch;
        if(ch!=null) Char.handler=h;
        turn=choturn;
        vitri=vt;
        muctieu=-1;
        hieuung=0;
        dm=0;
    }

    @Override
    public void tick() {
        if(Char!=null){
            if(turn == dautran){
                Char.HieuUngTruocTran();
                tinh();
                turn = choturn;
            }
            if(turn == giuatran){
                Char.HieuUngGiuaTran();
                tinh();
                if(this.vitri!=0 && temp.Char!=null){
                    temp.Char.phongthu(this.getCard());
                    this.Char.hieuung.setx(x); this.Char.hieuung.sety(y+35); this.Char.hieuung.setHandler(this.handler);
                    this.handler.addobject(this.Char.hieuung);
                    this.Char.hieuung2.setx(temp.getx()-50); this.Char.hieuung2.sety(temp.gety()-20); this.Char.hieuung2.setHandler(this.handler);
                    this.handler.addobject(this.Char.hieuung2);
                    temp.bitrungdon();
                }
                turn = choturn;
            }
            if(turn == cuoitran){
                Char.HieuUngSauTran();
                turn = choturn;
            }
            if(Char.gethp()<=0 && vitri!=0) Char=null;
        }
        if(hieuung>0){
            this.x=this.x+velx;
            dm=dm-1;
            if(dm==0){
                dm=10; velx=-velx; hieuung=hieuung-1;
            }
        }
        collision();
    }

    @Override
    public void render(Graphics g) {
        if(Char!=null){
            if(this.vitri!=0){
                g.drawImage(Char.anh.getImage(), x, y, width, height, null);
                int max=0;
                if(Char!=null) max=Char.getsao();
                for(int i=0; i<max; i++){
                    g.drawImage(Char.sau.getImage(), x+82-(i*13), y+28, 15, 15, null);
                }
                g.setColor(Color.WHITE);
                g.setFont(new Font("Freestyle Script", Font.BOLD, 16));
                int num=0;
                if(Char!=null) num=Char.numcard;
                if(num<10) g.drawString(""+num, x+9, y+41); else g.drawString(""+num, x+6, y+41);
                g.setColor(Color.BLACK);
                g.setFont(new Font("Tahoma", Font.BOLD, 11));
                if(Char!=null) g.drawString(""+Char.hp, x+12, y+164);
                if(Char!=null) g.drawString(""+Char.at, x+47, y+164);
                if(Char!=null) g.drawString(""+Char.df, x+81, y+164);
            }
            else{
                g.drawImage(Char.anh.getImage(), x, y, width, height, null);
                g.setColor(Color.WHITE);
                g.setFont(new Font("Monotype Corsiva", Font.BOLD, 20));
                g.drawString(""+Char.hp, x+61, y+152);
                g.setColor(Color.BLACK);
                g.setFont(new Font("Monotype Corsiva", Font.BOLD, 20));
                g.drawString(""+Char.hp, x+60, y+150);
            }
        } else g.drawImage(anull.getImage(), x, y, width, height, null);
    }

    @Override
    public Rectangle getbounds() {
        return new Rectangle(x, y, this.width, this.height);
    }
    public void tinh(){
        muctieu=vitri;
        boolean ketqua=false;
        int k=0;
        boolean[] v =new boolean[6];
        for(int i=0; i<6; i++) v[i]=false;
        if(vitri<=3) k=-1; else k=1;
        if(vitri==0) ketqua=true;
        while(ketqua==false && this.vitri!=0){
            if(this.id==ID.card){
                for(int i=0; i<handler.getobject().size(); i++){
                    GameObject tempobject=handler.getobject().get(i);
                    if(tempobject.getid()==ID.ecard){
                        temp = (KieuTheBai) tempobject;
                        if(temp.vitri==muctieu && temp.Char!=null){ ketqua=true; break;}
                    }
                }
                if(ketqua==false && muctieu!=0) {
                            v[muctieu-1]=true;
                            if(muctieu==1 || muctieu==6){ muctieu=vitri; k=-k;}
                            muctieu = muctieu + k;
                            if(v[0]==true && v[1]==true && v[2]==true && v[3]==true && v[4]==true && v[5]==true) {muctieu=0;}
                    }
            }
            if(this.id==ID.ecard){
                for(int i=0; i<handler.getobject().size(); i++){
                    GameObject tempobject=handler.getobject().get(i);
                    if(tempobject.getid()==ID.card){
                        temp = (KieuTheBai) tempobject;
                        if(temp.vitri==muctieu && temp.Char!=null){ ketqua=true; break;}
                    }
                }
                if(ketqua==false) {
                            v[muctieu-1]=true;
                            if(muctieu==1 || muctieu==6){ muctieu=vitri; k=-k;}
                            muctieu = muctieu + k;
                            if(v[0]==true && v[1]==true && v[2]==true && v[3]==true && v[4]==true && v[5]==true){ muctieu=0;}
                    }
            }
        }
    }
    public void setturn(int i){
        switch (i){
            case 1: turn = dautran; break;
            case 2: turn = giuatran; break;
            case 3: turn = cuoitran; break;
        }
    }
    public int getvitri(){
        return this.vitri;
    }
    public mauthe getCard(){
        return this.Char;
    }
    public void setCard(mauthe newCard){
        this.Char= newCard;
    }
    public void collision(){
        for(int i=0;i<handler.getobject().size();i++){
            GameObject tempobject=handler.getobject().get(i);
            if(tempobject.getid()==ID.kehuydiet){
                if(getbounds().intersects(tempobject.getbounds())){
                    this.handler.removeobject(this);
                }
            }
        }
    }
    public void bitrungdon(){
        hieuung=4;
        dm=10;
        velx=1;
    }
}
