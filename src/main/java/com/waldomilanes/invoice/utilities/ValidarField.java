/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.waldomilanes.invoice.utilities;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

/**
 *
 * @author Luis E Nouel
 */
public class ValidarField {
    
    public void validarSoloLetras(JTextField campo)
    {
        campo.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                
                if(Character.isDigit(c)){
                    e.consume();
                }
            }
        });  
    }
    
    public void validarSoloNumeros(JTextField campo)
    {
        campo.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                
                if(!Character.isDigit(c)){
                    e.consume();
                }
            }
        });  
    }
    
    public void limitarCaracteres(JTextField campo, int limite)
    {
        campo.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                char c = e.getKeyChar();
                int cantidad = campo.getText().length();
                if(cantidad>=limite){
                    e.consume();
                }
            }
        });  
    } 
}
