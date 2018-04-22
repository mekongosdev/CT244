/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CardObject;

import CacLoaiThe.*;
import Center.Client;
import Center.Game;
import Center.GameObject;
import Center.Handler;
import Center.ID;
import Center.Server;
import Orther.bangxephang;
import Orther.button;
import Orther.dondep;
import Orther.hetgame;
import Orther.thongbao2;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.time.chrono.JapaneseChronology;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author TLiem
 */
public class bancoLAN extends GameObject{
   //1 slot: 100x170
	Server server = null;
	Client client = null;
    KieuTheBai[] BaiA = new KieuTheBai[7];
    KieuTheBai[] BaiB = new KieuTheBai[7];
    KieuTheBai[] trentay = new KieuTheBai[5];
    mauthe[] reCardB = new mauthe[7]; //dung de giau di cac bai da len
    ImageIcon anh = new ImageIcon("data/card/banco.png");
    public BoBai bbA;
    InfoThe info;
    public button button1, buttonthoat;
    int time=0;
    int m=5;
    int l=0;
    int xu=2;
    int Rxu=2;
    int sta=0;
    int soturn, sobai;
    int wi = Game.width-345;
    public String player=null;
    public boolean chonguoichoi=true;
    public boolean nguoichoi1SS=false;
    public boolean nguoichoi2SS=false;
    public int temA, temB, maxA, maxB;
    thongbao2 infotran;
    public bancoLAN(int x, int y, ID id, Handler h, boolean isServer, String ConServer) {
        super(x, y, ID.bancoLAN);
        Game.onplay=true;
        if(isServer == true){
        	this.server = new Server();
        }else this.client = new Client(ConServer);
        this.handler=h;
        bbA= new BoBai("Random", "", ID.card);
        soturn=0;
        sobai=0;
        temA=0; temB=0;
        //bbA.printBB();
        BaiA[0] = new KieuTheBai(x+60, y+175, ID.card, handler, null, 0);
        BaiA[1] = new KieuTheBai(x+10, y+5, ID.card, handler, null, 1);
        BaiA[2] = new KieuTheBai(x+115, y+5, ID.card, handler, null, 2);
        BaiA[3] = new KieuTheBai(x+220, y+90, ID.card, handler, null, 3);
        BaiA[4] = new KieuTheBai(x+220, y+265, ID.card, handler, null, 4);
        BaiA[5] = new KieuTheBai(x+115, y+345, ID.card, handler, null, 5);
        BaiA[6] = new KieuTheBai(x+10, y+345, ID.card, handler, null, 6);
        BaiB[0] = new KieuTheBai(wi-60, y+175, ID.ecard, handler, null, 0);
        BaiB[1] = new KieuTheBai(wi-10, y+5, ID.ecard, handler, null, 1);
        BaiB[2] = new KieuTheBai(wi-115, y+5, ID.ecard, handler, null, 2);
        BaiB[3] = new KieuTheBai(wi-220, y+90, ID.ecard, handler, null, 3);
        BaiB[4] = new KieuTheBai(wi-220, y+265, ID.ecard, handler, null, 4);
        BaiB[5] = new KieuTheBai(wi-115, y+345, ID.ecard, handler, null, 5);
        BaiB[6] = new KieuTheBai(wi-10, y+345, ID.ecard, handler, null, 6);
        info = new InfoThe(x+735, y+25, this.handler, null);
        this.handler.addobject(info);
        for(int i=0; i<5; i++){
            trentay[i] = new KieuTheBai(x+90 + i*110, y+525, ID.recard, handler, null, i+1);
            reCardB[i]=null;
            this.handler.addobject(trentay[i]);
        }
        this.themrecard();
        for(int i=0; i<7; i++){
            this.handler.addobject(BaiA[i]);
            this.handler.addobject(BaiB[i]);
        }
        button1 = new button(x+650, y+525, 120, 60, new ImageIcon("data/an/nutss.png"));
        buttonthoat= new button(x+800, y+600, 120, 60, new ImageIcon("data/an/nutthoat.png"));
        if(BaiA[0].Char!=null) maxA=BaiA[0].Char.getsao();
        if(BaiA[0].Char!=null) maxB=BaiB[0].Char.getsao();
    }

    @Override
    public void tick() {
        donrecard();
        tinhtem();
        tinhsobaisudung();
        sansang();
        xu=Rxu;
        if(xu!=2) time=time+1;
        if(xu==0){
            if(sta==0){
                infotran=new thongbao2(200, 200, this.handler);
                infotran.s="BAÁT ÑAÀU LÖÔÏT";
                this.handler.addobject(infotran);
                this.lenbaiB();
                soturn=soturn+1;
                sta=sta+1;
            }
            switch(sta){
            case 1: this.A_Batdau(); break;
            case 2: this.B_Batdau(); break;
            case 3: this.A_Giuatran(); break;
            case 4: this.B_Giuatran(); break;
            case 5: this.A_Cuoitran(); break;
            case 6: this.B_Cuoitran(); break;
            }
            if(sta==7){
                soturn=soturn+1;
                m=5;
                xu=2;
                time=0;
                sta=0;
                chonguoichoi=true;
                this.themrecard();
                infotran=new thongbao2(200, 200, this.handler);
                infotran.s="HEÁT LÖÔÏT";
                this.handler.addobject(infotran);
                this.hetgamechua();
            }
        }
        else if(xu==1){
            if(sta==0){
            	infotran=new thongbao2(200, 200, this.handler);
                infotran.s="BAÁT ÑAÀU LÖÔÏT";
                this.handler.addobject(infotran);
                this.lenbaiB();
                soturn=soturn+1;
                sta=sta+1;
            }
            switch(sta){
            case 1: this.B_Batdau(); break;
            case 2: this.A_Batdau(); break;
            case 3: this.B_Giuatran(); break;
            case 4: this.A_Giuatran(); break;
            case 5: this.B_Cuoitran(); break;
            case 6: this.A_Cuoitran(); break;
            }
            
            if(sta==7){
                m=5;
                xu=2;
                time=0;
                sta=0;
                chonguoichoi=true;
                this.themrecard();
                infotran=new thongbao2(200, 200, this.handler);
                infotran.s="HEÁT LÖÔÏT";
                this.handler.addobject(infotran);
                this.hetgamechua();
            }
        }
        collision();
    }

    @Override
    public void render(Graphics g) {
    	g.drawImage(anh.getImage(), 0, 0, null);
        button1.render(g);
        buttonthoat.render(g);
        g.setFont(new Font("VNI-Vivi", Font.BOLD, 35));
        g.setColor(Color.GREEN);
        g.drawString(""+temA,x+5,y+245);
        g.drawString(""+temB,wi+40,y+245);
        g.setColor(Color.WHITE);
        g.drawString(""+maxA,x+25,y+270);
        g.drawString(""+maxB,wi+60,y+270);
        g.setFont(new Font("VNI-Vivi", Font.ITALIC, 40));
        g.drawString("/",x+20,y+260);
        g.drawString("/",wi+55,y+260);
        g.setFont(new Font("VNI-Centur", Font.BOLD, 20));
        g.drawString("Löôït", x+25, y+570);
        g.drawString(""+soturn, x+30, y+600);
        g.setColor(Color.BLACK);
        g.drawString("Baøi ", x+25, y+630);
        g.drawString(""+sobai, x+25, y+660);
    }

    @Override
    public Rectangle getbounds() {
        return new Rectangle(x, y, wi, wi);
    }
    
    public void A_Batdau(){
        if(time==m && l<7){
            while(BaiA[l].Char==null && l<6) l=l+1; 
            BaiA[l].setturn(1);
            m=m+5;
            if(l<7)l=l+1;
        }
        if(l==7){
            sta=sta+1;
            l=0;
        }
    }
    
    public void A_Giuatran(){
        if(time==m && l<7){
            while(BaiA[l].Char==null && l<6) l=l+1; 
            BaiA[l].setturn(2);
            m=m+45;
            if(l<7)l=l+1;
        }
        if(l==7){
            sta=sta+1;
            l=0;
        }
    }
    public void A_Cuoitran(){
        if(time==m && l<7){
            while(BaiA[l].Char==null && l<6) l=l+1; 
            BaiA[l].setturn(3);
            m=m+5;
            if(l<7)l=l+1;
        }
        if(l==7){
            sta=sta+1;
            l=0;
        }
    }
    public void B_Batdau(){
        if(time==m && l<7){
            while(BaiB[l].Char==null && l<6) l=l+1; 
            BaiB[l].setturn(1);
            m=m+5;
            if(l<7)l=l+1;
        }
        if(l==7){
            sta=sta+1;
            l=0;
        }
    }
    public void B_Giuatran(){
        if(time==m && l<7){
            while(BaiB[l].Char==null && l<6) l=l+1; 
            BaiB[l].setturn(2);
            m=m+45;
            if(l<7)l=l+1;
        }
        if(l==7){
            sta=sta+1;
            l=0;
        }
    }
    public void B_Cuoitran(){
        if(time==m && l<7){
            while(BaiB[l].Char==null && l<6) l=l+1; 
            BaiB[l].setturn(3);
            m=m+5;
            if(l<7)l=l+1;
        }
        if(l==7){
            sta=sta+1;
            l=0;
        }
    }
    public void sansang(){
    	if(nguoichoi1SS && nguoichoi2SS){
    		Rxu=((int)(Math.random()*99))/50;
            this.chonguoichoi=false;	
    	}
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
   
    public mauthe phanloai(String name, ID idd){
        mauthe bai =null;
        switch(name){
            case "Master1": if(idd==ID.card) bai = new Mastercard1(this.handler, idd, x+60, y+175); if(idd==ID.ecard)bai = new Mastercard1(this.handler, idd, wi+60, y+175); break;
            case "Master2": if(idd==ID.card) bai = new Mastercard2(this.handler, idd, x+60, y+175); if(idd==ID.ecard)bai = new Mastercard2(this.handler, idd, wi+60, y+175); break;
            case "Master3": if(idd==ID.card) bai = new Mastercard3(this.handler, idd, x+60, y+175); if(idd==ID.ecard)bai = new Mastercard3(this.handler, idd, wi+60, y+175); break;
            case "Kiemsi": bai= new Kiem(); break;
            case "Kiemsi2": bai= new Kiemsi2(); break;
            case "Kiemsibacthay": bai= new Kiemsibacthay(); break;
            case "Phapsu" : bai= new phapsu(); break;
            case "Phuthuy" : bai=new phuthuy(); break;
            case "Rankhonglo": bai= new Rankhonglo(); break;
            case "Malua" : bai= new malua(); break;
            case "Manuoc" : bai=new manuoc(); break;
            case "Maxuong" : bai = new maxuong(); break;
            case "Xathu" : bai = new xathu(); break;
            case "Solria": bai = new solria(); break;
            case "Thur" : bai = new thur(); break;
            case "Liica" : bai = new Liica(); break;
            case "Chimera" : bai = new Chimera(); break;
        }
        return bai;
    }
    public void themrecard(){
        for(int i=0; i<5; i++){
            if(trentay[i].Char==null){
                trentay[i].Char=bbA.laybai();
            }
        }
    }
    public void donrecard(){
        for(int i=0; i<4; i++){
            if(trentay[i].Char==null){
                for(int j=i+1; j<5; j++){
                    if(trentay[j].Char!=null){
                        trentay[i].Char=trentay[j].Char;
                        trentay[j].Char=null;
                        break;
                    }
                }
            }
        }
    }
    public void lenbaiB(){
    	for(int i=0; i<7; i++){
    		mauthe T = reCardB[i]; //tao the bai moi dua tren thong tin da co
    		BaiB[i].Char = T;
    	}
    }
    public void tinhtem(){
        temA=0; temB=0;
        for(int i=1; i<7; i++){
            if(BaiA[i].Char!=null) temA= temA+BaiA[i].Char.numcard;
            if(BaiB[i].Char!=null) temB=temB+BaiB[i].Char.numcard;
        }
    }
    public void tinhsobaisudung(){
        int c=0;
        for(int i=0; i<5; i++){
            if(trentay[i].Char!=null) c=c+1;
        }
        sobai=40-bbA.cuoi-c;
    }
    public void hetgamechua(){
        boolean k=false;
        GameObject next=null;
        if(BaiA[0].Char.hp<=0){
            k=true;
            next = new hetgame(handler, 0);
        }
        if(BaiB[0].Char.hp<=0){
            k=true;
            next = new hetgame(handler, 1);
        }
        if(k==true){
            this.handler.removeobject(infotran);
            this.handler.addobject(next);
            for(int i=0; i<7; i++){
                this.handler.removeobject(BaiA[i]);
                this.handler.removeobject(BaiB[i]);
            }
            for(int i=0; i<5; i++){
                this.handler.removeobject(trentay[i]);
            }
            this.handler.removeobject(info);
            this.handler.removeobject(this);
        }
    }
    public void setplayer(int i){
        switch(i){
            case 1 : BaiA[0].Char = new Mastercard1(this.handler, ID.card, x+60, y+175); break;
            case 2 : BaiA[0].Char = new Mastercard2(this.handler, ID.card, x+60, y+175); break;
            case 3 : BaiA[0].Char = new Mastercard3(this.handler, ID.card, x+60, y+175); break;
            default: BaiA[0].Char = new Mastercard1(this.handler, ID.card, x+60, y+175); break;
        }
        maxA=BaiA[0].Char.getsao();
    }
    public void setdoithu(int i){
        switch(i){
            case 1 : BaiB[0].Char = new Mastercard1(this.handler, ID.ecard, x+60, y+175); break;
            case 2 : BaiB[0].Char = new Mastercard2(this.handler, ID.ecard, x+60, y+175); break;
            case 3 : BaiB[0].Char = new Mastercard3(this.handler, ID.ecard, x+60, y+175); break;
            default: BaiB[0].Char = new Mastercard1(this.handler, ID.ecard, x+60, y+175); break;
        }
        maxB=BaiB[0].Char.getsao();
    }
    public void sendDataInfo(){
    	//String[] S = new String[7];
    	String SendData=""+Rxu+"&"+sta;
    	for(int i=0; i<7; i++){
    		String S;
    		mauthe T = BaiA[i].Char;
    		if(T!=null) S = T.tenthe+"|"+T.numcard+"|"+T.hp+"|"+T.at+"|"+T.df;
    		else S="NULL";
    		SendData=SendData+"#"+S;
    	}
    	for(int i=0; i<7; i++){
    		String S;
    		mauthe T = BaiB[i].Char;
    		if(T!=null) S = T.tenthe+"|"+T.numcard+"|"+T.hp+"|"+T.at+"|"+T.df;
    		else S="NULL";
    		SendData=SendData+"#"+S;
    	}
    	if(this.server!=null){
    		server.setSend(SendData);
    	}else if(this.client!=null){
    		client.setSend(SendData);
    	}
    }
    public void getDataInfo(){
    	String[] SB = new String[7]; //A cua may con lai la B cua may nay va nguoc lai
    	String[] SA = new String[7];
    	char RXU;
    	char STA;
    	String reString="";
    	if(this.server!=null){
    		reString=server.getRecive();
    	}else if(this.client!=null){
    		reString=client.getRecive();
    	}
    	//tien hanh cat chuoi
    	RXU= reString.charAt(0);
    	STA= reString.charAt(2);
    	int i, j;
    	i=4;
    	j=0;
    	while(j<13){
    		int k=i+1;
    		for(k=i+1; k<reString.length(); k++){
    			if(reString.charAt(k)=='#'){
    				break;
    			}
    		}
    		if(j<7){
    			SB[j]=reString.substring(i, k);
    		}
    		else{
    			SA[j-7]=reString.substring(i, k);
    		}
    		i=k+1;
    		j=j+1;
    	}
    	SA[6]=reString.substring(i);
    	for(i=0; i<7; i++){
    		if(this.client!=null) datlaibai(BaiA[i].Char, SA[i], ID.card);
    		if(!nguoichoi1SS) datlaibai(reCardB[i], SB[i], ID.ecard);
    		else datlaibai(BaiB[i].Char, SB[i], ID.ecard);
    	}
    	this.Rxu=Integer.valueOf(RXU);
    	this.sta=Integer.valueOf(STA);
    }
    public void datlaibai(mauthe T, String S, ID idd){
    	String TenThe;
    	int NUM, HP, AT, DF;
    	int j=0;
    	int i=1;
    	NUM=0; HP=0; AT=0; DF=0;
    	//lay ten the
    	for(; i<S.length(); i++){
    		if(S.charAt(i)=='|'){
    			break;
    		}
    	}
    	TenThe = S.substring(j,  i);
    	if(!TenThe.equalsIgnoreCase("NULL")){
    		j=i+1;
        	i=j+1;
        	//lay num card
        	for(; i<S.length(); i++){
        		if(S.charAt(i)=='|'){
        			break;
        		}
        	}
        	NUM = Integer.valueOf(S.substring(j, i));
        	j=i+1;
        	i=j+1;
        	//lay hp card
        	for(; i<S.length(); i++){
        		if(S.charAt(i)=='|'){
        			break;
        		}
        	}
        	HP = Integer.valueOf(S.substring(j, i));
        	j=i+1;
        	i=j+1;
        	//lay at card
        	for(; i<S.length(); i++){
        		if(S.charAt(i)=='|'){
        			break;
        		}
        	}
        	AT = Integer.valueOf(S.substring(j, i));
        	j=i+1;
        	//lay df card
        	DF = Integer.valueOf(S.substring(j));
    	}
    	if(!TenThe.equalsIgnoreCase(T.tenthe)){
    		if(TenThe.equalsIgnoreCase("NULL")) T=null;
    		else{
    			T = phanloai(TenThe, idd);
    			T.numcard=NUM;
    			T.hp=HP;
    			T.at=AT;
    			T.df=DF;
    		}
    	}
    	else{
    		T.numcard=NUM;
			T.hp=HP;
			T.at=AT;
			T.df=DF;
    	}
    	
    }
}
