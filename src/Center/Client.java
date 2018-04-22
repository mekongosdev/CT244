package Center;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client extends Thread{
	String server="";
	Socket cs;
	boolean running=false;
	String send, recive;
	InputStream is;
	OutputStream os;
	PrintWriter pw;
	Scanner scan;
	boolean setSend=false;
	public Client(String sv){
		this.server=sv;
		
		send=null;
		recive=null;
	}
	public void setRunning(Boolean b){
		this.running=b;
	}
	public void setSend(String s){
		this.send=s;
		this.setSend=true;
	}
	public String getRecive(){
		return this.recive;
	}
	public void sendData(){
		pw.println(send);
	}
	public void getData(){
		this.recive=scan.nextLine();
	}
	@Override
	public void run() {
		try {
			cs = new Socket(server, 8113);
			is = cs.getInputStream();
			os = cs.getOutputStream();
			scan= new Scanner(is);
			pw = new PrintWriter(os);
			long Sruntime=System.nanoTime();
			long Nruntime, Wail;
			while(running){
				if(setSend){
					this.sendData();
					this.setSend=false;
				}
				if(scan.hasNext()){
					this.getData();
				}
				Nruntime=System.nanoTime();
				Wail=(Nruntime-Sruntime)/1000000;
				if(Wail<100){
					try {
						this.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				Sruntime= System.nanoTime();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.run();
	}
}
