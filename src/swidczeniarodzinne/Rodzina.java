/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package swidczeniarodzinne;

import java.util.List;

/**
 *
 * @author Jerzy
 */
public class Rodzina extends Osoba{ 
    List<Osoba> rodzina;
    
    public Rodzina() {
       initComponents();
    }
     private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }
    void dodaj(){
        
    }
}
