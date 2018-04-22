/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CacLoaiThe;

import Center.GameObject;
import Center.Handler;
import Interface.Card;
import javax.swing.ImageIcon;

/**
 *
 * @author TLiem
 */
public abstract class mauthe implements Card{
    //tong chi so = 10 + sosao*5 + (numcard-1)*2
    public int hp, at, df, numcard; //numcard chi so gioi han cua bai
    int sosao; //>3* co hieu ung, 5* co phan cong
    public String tenthe;
    public GameObject hieuung, hieuung2;
    public ImageIcon sau= new ImageIcon("data/card/sao.png");
    public ImageIcon anh;
    public Handler handler;
    public String[] note=new String[6];
    @Override
    public int tancong() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void phongthu(Card dame) {
    }

    @Override
    public void HieuUngTruocTran() {
    }

    @Override
    public void HieuUngSauTran() {
    }
   
    @Override
    public void HieuUngGiuaTran() {
    }
    
    @Override
    public int getsao(){
        return this.sosao;
    }
    @Override
    public int gethp(){
        return this.hp;
    }
    @Override
    public int getat(){
        return this.at;
    }
    @Override
    public int getdf(){
        return this.df;
    }
    @Override
    public void sethp(int heat){
        hp= heat;
    }
    @Override
    public void setat(int m){
        at=m;
    }
    @Override
    public void setdf(int m){
        df=m;
    }
    

}
