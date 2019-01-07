/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javakb.kebunbinatang;
import javakb.gui.FrmKarnivora;
import javakb.gui.FrmOmnivora;


/**
 *
 * @author LITTLEnstein
 */
public class JavaKebunBinatang {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run(){ 
                new FrmOmnivora().setVisible(true);  
                //new FrmKarnivora().setVisible(true);     
                
            }
        });
    }
    
}
