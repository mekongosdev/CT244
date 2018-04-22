/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Center;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
/**
 *
 * @author TLiem
 */
public class window extends Canvas {
    ImageIcon icon = new ImageIcon("data/an/an1.png");
    public window(int width,int height,String title,Game game){
        
        JFrame f=new JFrame(title);
        f.setBackground(Color.white);
        f.setPreferredSize(new Dimension(width,height));
        f.setMaximumSize(new Dimension(width,height));
        f.setMinimumSize(new Dimension(width,height));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setIconImage(icon.getImage());
        f.setLocationRelativeTo(null);
        f.add(game);
        f.setVisible(true);
        game.start();
    }        
}
