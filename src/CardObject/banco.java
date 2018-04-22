/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CardObject;

import CacLoaiThe.*;
import Center.Game;
import Center.GameObject;
import Center.Handler;
import Center.ID;
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
public class banco extends GameObject{
   //1 slot: 100x170
    KieuTheBai[] BaiA = new KieuTheBai[7];
    KieuTheBai[] BaiB = new KieuTheBai[7];
    KieuTheBai[] trentay = new KieuTheBai[5];
    mauthe[] reCardB = new mauthe[5];
    public BoBai bbA, bbB;
    //ImageIcon anh = new ImageIcon("data/card/banco.png");
    //ImageIcon anh2 = new ImageIcon("data/card/Night.png");
    InfoThe info;
    public button button1, buttonthoat, buttonluu;
    int time=0;
    int m=5;
    int l=0;
    int xu=2;
    int sta=0;
    int soturn, sobai;
    int wi = Game.width-345;
    public String player=null;
    public boolean chonguoichoi=true;
    public int temA, temB, maxA, maxB;
    thongbao2 infotran;
    public banco(int x, int y, ID id, Handler h) {
        super(x, y, ID.banco);
        this.handler=h;
        Game.onplay=true;
        Game.onload=true;
        Game.LS.n=21;
        Game.LS.loadn=0;
        bbA= new BoBai("Random", "", ID.card);
        bbB= new BoBai("Random", "", ID.ecard);
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
        buttonluu = new button(x+800, y+525, 120, 60, new ImageIcon("data/an/nutluu.png"));
        if(BaiA[0].Char!=null) maxA=BaiA[0].Char.getsao();
        if(BaiA[0].Char!=null) maxB=BaiB[0].Char.getsao();
    }

    @Override
    public void tick() {
        donrecard();
        tinhtem();
        tinhsobaisudung();
        if(xu!=2) time=time+1;
        if(xu==0){
            if(sta==0){
                infotran=new thongbao2(200, 200, this.handler);
                infotran.s="BAÁT ÑAÀU LÖÔÏT";
                this.handler.addobject(infotran);
                this.themrecardB();
                this.lenbaiB();
                soturn=soturn+1;
                sta=sta+1;
            }
            if(sta==1){
                this.A_Batdau();
            }
            if(sta==2) this.B_Batdau();
            if(sta==3) this.A_Giuatran();
            if(sta==4) this.B_Giuatran();
            if(sta==5) this.A_Cuoitran();
            if(sta==6) this.B_Cuoitran();
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
                this.themrecardB();
                this.lenbaiB();
                soturn=soturn+1;
                sta=sta+1;
            }
            if(sta==1){
                this.B_Batdau();
            }
            if(sta==2) this.A_Batdau();
            if(sta==3) this.B_Giuatran();
            if(sta==4) this.A_Giuatran();
            if(sta==5) this.B_Cuoitran();
            if(sta==6) this.A_Cuoitran();
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
    	//g.drawImage(anh2.getImage(), 0, 0, Game.width, Game.height, null);
        //g.drawImage(anh.getImage(), 0, 0, null);
        button1.render(g);
        buttonthoat.render(g);
        buttonluu.render(g);
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
        xu=((int)(Math.random()*99))/50;
        this.chonguoichoi=false;
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
    public void save(){
        mauthe bai=null;
        try {
            OutputStream os = new FileOutputStream("data/save/trochoi");
            PrintWriter pw = new PrintWriter(os);
            pw.println(player);
            for(int i=0; i<7; i++){
                bai=BaiA[i].Char;
                if(bai!=null){
                pw.println(bai.tenthe);
                pw.print(bai.hp);
                pw.println();
                pw.print(bai.at);
                pw.println();
                pw.print(bai.df);
                pw.println();
                pw.print(bai.numcard);
                pw.println();
                }else{
                pw.println("null");
                pw.print(-9999);
                pw.println();
                pw.print(-9999);
                pw.println();
                pw.print(-9999);
                pw.println();
                pw.print(-9999);
                pw.println();                
                }
                bai=BaiB[i].Char;
                if(bai!=null){
                pw.println(bai.tenthe);
                pw.print(bai.hp);
                pw.println();
                pw.print(bai.at);
                pw.println();
                pw.print(bai.df);
                pw.println();
                pw.print(bai.numcard);
                pw.println();
                }else{
                pw.println("null");
                pw.print(-9999);
                pw.println();
                pw.print(-9999);
                pw.println();
                pw.print(-9999);
                pw.println();
                pw.print(-9999);
                pw.println();                
                }
            }
            for(int i=0; i<5; i++){
                bai=trentay[i].Char;
                if(bai!=null){
                pw.println(bai.tenthe);
                pw.print(bai.hp);
                pw.println();
                pw.print(bai.at);
                pw.println();
                pw.print(bai.df);
                pw.println();
                pw.print(bai.numcard);
                pw.println();
                }else{
                pw.println("null");
                pw.print(-9999);
                pw.println();
                pw.print(-9999);
                pw.println();
                pw.print(-9999);
                pw.println();
                pw.print(-9999);
                pw.println();                
                }
            }
            pw.close();
            os.close();
            infotran=new thongbao2(200, 200, this.handler);
            infotran.s="ÑAÕ LÖU  ";
            this.handler.addobject(infotran);
        } catch (IOException ex) {
            Logger.getLogger(BoBai.class.getName()).log(Level.SEVERE, null, ex);
        }
        bbA.savebobai("baiA");
        bbB.savebobai("BaiB");
    }
    public void load(){
        InputStream is;
        String S;
        try {
            is = new FileInputStream("data/save/trochoi");
            Scanner os = new Scanner(is);
            player=os.nextLine();
            mauthe bai=null;
            for(int i=0; i<7; i++){
                S= os.nextLine();
                bai=phanloai(S, ID.card);
                if(bai!=null){
                bai.hp= os.nextInt(); os.nextLine();
                bai.at= os.nextInt(); os.nextLine();
                bai.df= os.nextInt(); os.nextLine();
                bai.numcard = os.nextInt(); os.nextLine();
                }
                else {
                    os.nextInt(); os.nextLine();
                    os.nextInt(); os.nextLine();
                    os.nextInt(); os.nextLine();
                    os.nextInt(); os.nextLine();
                }
                BaiA[i].Char= bai;
                S= os.nextLine();
                bai=phanloai(S, ID.ecard);
                if(bai!=null){
                bai.hp= os.nextInt(); os.nextLine();
                bai.at= os.nextInt(); os.nextLine();
                bai.df= os.nextInt(); os.nextLine();
                bai.numcard = os.nextInt(); os.nextLine();
                }
                else {
                    os.nextInt(); os.nextLine();
                    os.nextInt(); os.nextLine();
                    os.nextInt(); os.nextLine();
                    os.nextInt(); os.nextLine();
                }
                BaiB[i].Char=bai;
            }
            for(int i=0; i<5; i++){
                S= os.nextLine();
                bai=phanloai(S, ID.recard);
                if(bai!=null){
                bai.hp= os.nextInt(); os.nextLine();
                bai.at= os.nextInt(); os.nextLine();
                bai.df= os.nextInt(); os.nextLine();
                bai.numcard = os.nextInt(); os.nextLine();
                }
                else {
                    os.nextInt(); os.nextLine();
                    os.nextInt(); os.nextLine();
                    os.nextInt(); os.nextLine();
                    os.nextInt(); os.nextLine();
                }
                trentay[i].Char=bai;
            }
            
            os.close();
            is.close();
        } catch (IOException ex) {
            Logger.getLogger(BoBai.class.getName()).log(Level.SEVERE, null, ex);
        }
        bbA.loadbobai("baiA");
        bbB.loadbobai("baiB");
        maxA=BaiA[0].Char.getsao();
        maxB=BaiB[0].Char.getsao();
    }
    public mauthe phanloai(String name, ID idd){
        mauthe bai =null;
        switch(name){
            case "Master1": if(idd==ID.card) bai = new Mastercard1(this.handler, idd, x+60, y+175); if(idd==ID.ecard)bai = new Mastercard1(this.handler, idd, wi-60, y+175); break;
            case "Master2": if(idd==ID.card) bai = new Mastercard2(this.handler, idd, x+60, y+175); if(idd==ID.ecard)bai = new Mastercard2(this.handler, idd, wi-60, y+175); break;
            case "Master3": if(idd==ID.card) bai = new Mastercard3(this.handler, idd, x+60, y+175); if(idd==ID.ecard)bai = new Mastercard3(this.handler, idd, wi-60, y+175); break;
            case "Master4": if(idd==ID.card) bai = new Mastercard4(this.handler, idd, x+60, y+175); if(idd==ID.ecard)bai = new Mastercard4(this.handler, idd, wi-60, y+175); break;
            case "Kiemsi": bai= new Kiem(); break;
            case "Kiemsi2": bai= new Kiemsi2(); break;
            case "Kiemsibacthay": bai= new Kiemsibacthay(); break;
            case "Phapsu" : bai= new phapsu(); break;
            case "Phuthuy" : bai=new phuthuy(); break;
            case "Rankhonglo": bai= new Rankhonglo(); break;
            case "Malua" : bai= new malua(); break;
            case "Manuoc" : bai=new manuoc(); break;
            case "Maxuong" : bai = new maxuong(); break;
            case "Macay" : bai = new Macay(); break;
            case "Yeutinhcay" : bai = new Caytinh(); break;
            case "Zombie": bai= new Zombie(); break;
            case "Xathu" : bai = new xathu(); break;
            case "Solria": bai = new solria(); break;
            case "Thur" : bai = new thur(); break;
            case "Rem" : bai = new Rem(); break;
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
    public void themrecardB(){
        for(int i=0; i<5; i++){
            if(reCardB[i]==null) reCardB[i]=bbB.laybai();
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
        boolean[] re = new boolean[5];
        boolean xb = true;
        for(int i=0; i<5;i++){
            if(reCardB[i]!=null) re[i]=true;
            else re[i]=false;
        }
        while((re[0] || re[1] || re[2] || re[3] || re[4]) && temB<maxB && xb){
            int r = (int)((Math.random()*24)/5);
            if(re[r] && (temB+reCardB[r].numcard<=maxB)){
                int i;
                for(i=1; i<7; i++){
                    if(BaiB[i].Char==null){ 
                        BaiB[i].Char= reCardB[r];
                        re[r]=false;
                        temB=temB+reCardB[r].numcard;
                        reCardB[r]=null;
                        break;
                    }
                }
                if(i==7 && BaiB[6].Char!=null) xb=false;
            } else re[r]=false;
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
            xephang();
            next = new hetgame(handler, 1);
        }
      //them moi tu day
        boolean nc1thua, nc2thua;
        nc1thua=true;
        nc2thua=true;
        for(int i=1 ;i<7; i++){
        	if(BaiA[i].Char!=null){
        		nc1thua=false;
        	}
        	if(BaiB[i].Char!=null){
        		nc2thua=false;
        	}
        }
        for(int i=0; i<5; i++){
        	if(reCardB[i]!=null) nc2thua=false;
        }
        if(sobai==40 && nc1thua){
        	k=true;
            next = new hetgame(handler, 0);
        }
        if(bbB.cuoi==0 && nc2thua){
        	k=true;
            xephang();
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
        //ket thuc them moi
    }
    public void xephang(){
        String[] name= new String[11];
        int[] st = new int[11];
        int[] sb = new int[11];
        InputStream is;
        try {
            is = new FileInputStream("data/save/bxh");
            Scanner s= new Scanner(is);
            for(int i=0; i<10; i++){
                name[i]=s.nextLine();
                st[i] = s.nextInt(); s.nextLine();
                sb[i] = s.nextInt(); s.nextLine();
            }
            s.close();
            is.close();
        } catch (FileNotFoundException ex) {
            for(int i=0; i<10; i++){
                name[i]="noname";
                st[i]=9999;
                sb[i]=40;
            }
        } catch (IOException ex) {
        }
        name[10]=player;
        st[10]=soturn;
        sb[10]=sobai;
        for(int i=10; i>=1; i--){
            if(st[i]<st[i-1] || (st[i]==st[i-1] && sb[i]<sb[i-1])){
                String tname = name[i-1];
                int tst= st[i-1];
                int tsb=sb[i-1];
                name[i-1]=name[i];
                st[i-1]=st[i];
                sb[i-1]=sb[i];
                name[i]=tname;
                st[i]=tst;
                sb[i]=tsb;
            }
        }
        try {
            OutputStream os = new FileOutputStream("data/save/bxh");
            PrintWriter pw = new PrintWriter(os);
            for(int i=0; i<10; i++){
                pw.println(name[i]);
                pw.println(st[i]);
                pw.println(sb[i]);
            }
            pw.close();
            os.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(banco.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(banco.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void setplayer(int i){
        switch(i){
            case 1 : BaiA[0].Char = new Mastercard1(this.handler, ID.card, x+60, y+175); break;
            case 2 : BaiA[0].Char = new Mastercard2(this.handler, ID.card, x+60, y+175); break;
            case 3 : BaiA[0].Char = new Mastercard3(this.handler, ID.card, x+60, y+175); break;
            case 4 : BaiA[0].Char = new Mastercard4(this.handler, ID.card, x+60, y+175); break;
            default: BaiA[0].Char = new Mastercard1(this.handler, ID.card, x+60, y+175); break;
        }
        maxA=BaiA[0].Char.getsao();
    }
    public void setdoithu(int i){
        switch(i){
            case 1 : BaiB[0].Char = new Mastercard1(this.handler, ID.ecard, wi-60, y+175); break;
            case 2 : BaiB[0].Char = new Mastercard2(this.handler, ID.ecard, wi-60, y+175); break;
            case 3 : BaiB[0].Char = new Mastercard3(this.handler, ID.ecard, wi-60, y+175); break;
            case 4 : BaiB[0].Char = new Mastercard4(this.handler, ID.ecard, wi-60, y+175); break;
            default: BaiB[0].Char = new Mastercard1(this.handler, ID.ecard, wi-60, y+175); break;
        }
        maxB=BaiB[0].Char.getsao();
    }
}
