package Center;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class LoadScr extends GameObject{
	static public int n=1; //so thanh phan can load;
	static public int loadn; //so thanh phan da load;
	int drawload, iimg, t;
	int width, height;
	String URL = "data/hieuung/load";
	ImageIcon nen, loadimg;
	public LoadScr(int W, int H, int n) {
		super(0, 0, ID.loadscr);
		width=W;
		height=H;
		loadn=0;
		drawload=0;
		iimg=1;
		t=10;
		nen = new ImageIcon("data/an/nen3.png");
		loadimg = new ImageIcon(URL+iimg+".png");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void tick() {
		drawload=(loadn/n)*width;
		t=t-1;
		if(t==0){
			iimg=iimg+1;
			if(iimg==5) iimg=1;
			loadimg = new ImageIcon(URL+iimg+".png");
			t=10;
		}
		if(loadn==n) Game.onload=false;
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(nen.getImage(), 0, 0, Game.width, Game.height, null);
		g.drawImage(loadimg.getImage(), 0,555, null);
		g.setColor(Color.BLUE);
		g.fillRect(0, 620, drawload, 50);
	}

	@Override
	public Rectangle getbounds() {
		// TODO Auto-generated method stub
		return null;
	}

}
