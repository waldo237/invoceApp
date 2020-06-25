/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.waldomilanes.invoice.services;

import com.waldomilanes.invoice.jpacontrollers.Decision;
import com.waldomilanes.invoice.jpacontrollers.ModeloJpaController;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Instructor
 */
public class ModeloService {
    public DefaultTableModel getDefaultTableModelFree(Decision sql, String nombre) {
        DefaultTableModel d= null;
        try {
            d = ModeloJpaController.modelFree(sql,nombre);
        } catch (SQLException ex) {
            Logger.getLogger(ModeloService.class.getName()).log(Level.SEVERE, null, ex);
        }
                    return d;
    }

    public DefaultTableModel getDefaultTableModelInt(Decision decision, int id) {
        DefaultTableModel d= null;
        try {
            //                                               necesitas una Decision
            d = ModeloJpaController.modelGenerator(decision, id);
        } catch (SQLException ex) {
            Logger.getLogger(ModeloService.class.getName()).log(Level.SEVERE, null, ex);
        }
                    return d;
    }
    public DefaultTableModel getDefaultTableModelString(Decision decision, String id) {
        DefaultTableModel d= null;
        try {
            //                                               necesitas una Decision
            d = ModeloJpaController.modelGenerator(decision, id);
        } catch (SQLException ex) {
            Logger.getLogger(ModeloService.class.getName()).log(Level.SEVERE, null, ex);
        }
                    return d;
    }



    
}
