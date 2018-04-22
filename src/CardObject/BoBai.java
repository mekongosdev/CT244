/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CardObject;

import CacLoaiThe.*;
import Center.ID;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TLiem
 */
public class BoBai {
    mauthe[] Labai = new mauthe[40];
    int cuoi=0;
    ID team;
    public BoBai(String k, String M, ID t){
        team = t;
        if(k=="Random"){
            makeRandom();
        }
        if(k=="Taomoi"){
            for(int i=0; i<40; i++) Labai[i]=null;
            cuoi=0;
        }
        if(k=="load"){
            loadbobai(M);
        }
    }
    public void makeRandom(){
        for(int k=0; k<40; k++){
            int i;
            i=((int)(Math.random()*139))/10;
            switch(i){
                case 0 : thembai(new Kiem()); break;
                case 1 : thembai(new Kiemsi2()); break;
                case 2 : thembai(new Kiemsibacthay()); break;
                case 3 : thembai(new phapsu()); break;
                case 4 : thembai(new phuthuy()); break;
                case 5 : thembai(new Rankhonglo()); break;
                case 6 : thembai(new malua()); break;
                case 7 : thembai(new manuoc()); break;
                case 8 : thembai(new maxuong()); break;
                case 9 : thembai(new xathu()); break;
                case 10: thembai(new Chimera()); break;
                case 11: thembai(new Caytinh()); break;
                case 12: thembai(new Macay()); break;
                case 13: thembai(new Zombie()); break;
                default: thembai(new Kiem()); break;
            }
        }
    }
    public mauthe laybai(){
        if(cuoi>0){cuoi=cuoi-1; return Labai[cuoi];}
        else return null;
    }
    public void thembai(mauthe A){
        Labai[cuoi]=A;
        cuoi=cuoi+1;
    }
    public void printBB(){
        for(int i=0; i<cuoi; i++){
            System.out.println(Labai[i].tenthe);
        }
    }
    public void savebobai(String S){
        try {
            OutputStream os = new FileOutputStream("data/save/"+S);
            PrintWriter pw = new PrintWriter(os);
            for(int i=0; i<cuoi; i++){
                pw.println(Labai[i].tenthe);
            }
            pw.close();
            os.close();
        } catch (IOException ex) {
            Logger.getLogger(BoBai.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    public void loadbobai(String S){
        this.cuoi=0;
        InputStream is;
        int i=0;
        try {
            is = new FileInputStream("data/save/"+S);
            Scanner s = new Scanner(is);
            while(s.hasNextLine()){
                thembai(phanloai(s.nextLine()));
            }
            s.close();
            is.close();
        } catch (IOException ex) {
            Logger.getLogger(BoBai.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public mauthe phanloai(String name){
        mauthe bai =null;
        switch(name){
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
    public void themsevant(mauthe X){
        int r=0;
        for(int i=0; i<10; i++){
            r= ((int)(Math.random()*399))/10;
            if(Labai[r].tenthe!=X.tenthe){
                switch(X.tenthe){
                    case "Solria": Labai[r] = new solria(); break;
                    case "Thur" : Labai[r] = new thur(); break;
                    case "Liica" : Labai[r] = new Liica(); break;
                    case "Rem" : Labai[r] = new Rem(); break;
                }
            }
            else i=i-1;
        }
    }
}
