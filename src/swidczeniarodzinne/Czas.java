/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swidczeniarodzinne;

import java.awt.Color;
import java.awt.Font;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author Jerzy
 */
public class Czas extends JLabel implements Runnable{

    private Thread watek;
    private int pauza = 1000;
    public Czas(){
        super("",SwingConstants.CENTER);
        setFont(new Font("Consolas", Font.BOLD, 12));
        setBackground(Color.blue);
        setForeground(Color.WHITE);
        setOpaque(true);        
    }
    
    public void start(){
        if (watek == null){
            watek = new Thread(this);
            watek.start();
        }
    }
    @Override
    public void run() {
        while (watek == Thread.currentThread()){
            Date czas = new Date();
            DateFormat df = DateFormat.getTimeInstance(DateFormat.MEDIUM);
            setText(df.format(czas));
            try{
                watek.sleep(pauza);
            } catch (InterruptedException e){}
        }
    }
    
    public void stop(){
        watek = null;
    }
}
