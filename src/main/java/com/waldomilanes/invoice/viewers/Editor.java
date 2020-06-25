/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.waldomilanes.invoice.viewers;

import com.waldomilanes.invoice.pojos.Cliente;
import com.waldomilanes.invoice.pojos.Orden;
import com.waldomilanes.invoice.pojos.OrdenDetalle;
import com.waldomilanes.invoice.pojos.Productos;
import com.waldomilanes.invoice.utilities.GeneralMethods;
import java.awt.Frame;
import java.math.BigDecimal;
import java.sql.SQLException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Instructor
 */
public class Editor extends javax.swing.JDialog {

    private boolean isCliente = false;
    private boolean isProducto = false;
    private boolean isOrden = false;
    private boolean isDetalle = false;
    private int numTabla;
    private Cliente clienteInterno;
    private Productos productoInterno;
    private Orden ordenInterna;
    private OrdenDetalle detalleInterno;
    private int Operacion;
    
    
    public Editor() {
        constructor(0,"");
    }
    public Editor(Productos p, int operacionIn) {
        this.productoInterno = p;
        isProducto = true;
        constructor(operacionIn,"producto");
    }
    public Editor(Cliente c, int operacionIn) {
        this.clienteInterno =c;
        isCliente = true;
         constructor(operacionIn,"cliente");
    }
    public Editor(Orden o, int operacionIn) {
        this.ordenInterna = o;
        isOrden = true;
         constructor(operacionIn,"orden");
    }
    public Editor(OrdenDetalle d, int operacionIn) {
        isDetalle = true;
        this.detalleInterno =d;
         constructor(operacionIn,"detalle");
    }

    private Editor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        texto1 = new javax.swing.JTextField();
        texto2 = new javax.swing.JTextField();
        texto6 = new javax.swing.JTextField();
        texto3 = new javax.swing.JTextField();
        texto4 = new javax.swing.JTextField();
        botonAgregar = new javax.swing.JButton();
        label1 = new javax.swing.JLabel();
        label2 = new javax.swing.JLabel();
        label3 = new javax.swing.JLabel();
        label4 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        label6 = new javax.swing.JLabel();
        botonCancelar = new javax.swing.JButton();
        label5 = new javax.swing.JLabel();
        texto5 = new javax.swing.JTextField();
        label7 = new javax.swing.JLabel();
        texto7 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setAutoscrolls(true);
        jPanel1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPanel1FocusGained(evt);
            }
        });

        texto1.setEditable(false);
        texto1.setText(" Generada automaticamente");

        texto6.setToolTipText("Este campo ha sido generado por la base de datos y no es posible editarlos");

        botonAgregar.setBackground(new java.awt.Color(179, 0, 47));
        botonAgregar.setForeground(new java.awt.Color(255, 255, 255));
        botonAgregar.setText("Agregar");
        botonAgregar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        botonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarActionPerformed(evt);
            }
        });

        label1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label1.setText("ID:");

        label2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label2.setText("Nombre:");

        label3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label3.setText("Año:");

        label4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label4.setText("Subtitulo:");

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/cash1.png"))); // NOI18N
        jLabel4.setText("CASH1");

        label6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label6.setText("Fecha que se presto:");

        botonCancelar.setBackground(new java.awt.Color(179, 0, 47));
        botonCancelar.setForeground(new java.awt.Color(255, 255, 255));
        botonCancelar.setText("Cancelar");
        botonCancelar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        label5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label5.setText("Cliente asignado:");

        label7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label7.setText("Fecha que se presto:");

        texto7.setEditable(false);
        texto7.setToolTipText("Este campo ha sido generado por la base de datos y no es posible editarlos");

        jPanel2.setBackground(new java.awt.Color(179, 0, 47));
        jPanel2.setFocusCycleRoot(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label1)
                            .addComponent(label2)
                            .addComponent(label3)
                            .addComponent(label4)
                            .addComponent(label6)
                            .addComponent(label5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(texto5)
                            .addComponent(texto4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(texto2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(texto3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(botonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(texto1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(texto6, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(label7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(texto7)))
                .addGap(111, 111, 111))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(164, 164, 164))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texto1)
                    .addComponent(label1))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texto2)
                    .addComponent(label2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texto3)
                    .addComponent(label3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texto4)
                    .addComponent(label4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texto5)
                    .addComponent(label5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texto6)
                    .addComponent(label6))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texto7)
                    .addComponent(label7))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarActionPerformed
        try {
            if (isCliente) {
                clienteInterno.setNombre(texto2.getText());
                clienteInterno.setDireccion(texto3.getText());
                trabajar(clienteInterno, Operacion, "cliente");
                Icon icon = (new javax.swing.ImageIcon(getClass().getResource("/META-INF/check.png")));
                JOptionPane.showMessageDialog(this, "Los datos fueron procesados correctamente!", "Notificacion", JOptionPane.INFORMATION_MESSAGE,
                        icon);
                this.dispose();
                new ClienteScreen(null, true).setVisible(true);

            } else if (isProducto) {
                productoInterno.setIdproducto(texto1.getText());
                productoInterno.setDescripcion(texto2.getText());
                productoInterno.setCantidad(Integer.parseInt(texto3.getText()));
                productoInterno.setPrecio(BigDecimal.valueOf(Double.parseDouble(texto4.getText())));
                productoInterno.setCosto(BigDecimal.valueOf(Double.parseDouble(texto5.getText())));
                productoInterno.setTax(BigDecimal.valueOf(Double.parseDouble(texto6.getText())));
                trabajar(productoInterno, Operacion, "producto");
                Icon icon = (new javax.swing.ImageIcon(getClass().getResource("/META-INF/check.png")));
                JOptionPane.showMessageDialog(this, "Los datos fueron procesados correctamente!", "Notificacion", JOptionPane.INFORMATION_MESSAGE,
                        icon);
                dispose();
                new InventarioScreen(null, true).setVisible(true);
            } else if (isOrden) {

                ordenInterna.setIdcliente(Integer.parseInt(texto2.getText()));
                ordenInterna.setComentario(texto4.getText());
                trabajar(ordenInterna, Operacion, "orden");
                Icon icon = (new javax.swing.ImageIcon(getClass().getResource("/META-INF/check.png")));
                JOptionPane.showMessageDialog(this, "Los datos fueron procesados correctamente!", "Notificacion", JOptionPane.INFORMATION_MESSAGE,
                        icon);
                dispose();
                new OrdenScreen(null, false).setVisible(true);
            } else if (isDetalle) {
                /*

            YOU STILL HAVE TO FILL IN THE DETALLEINTERNO OBJECT
                 */
                detalleInterno.setNoOrden(Integer.parseInt(texto1.getText()));
                detalleInterno.setIdproducto(texto2.getText());
                detalleInterno.setCantidad(Integer.parseInt(texto3.getText()));
                detalleInterno.setPrecio(BigDecimal.valueOf(Double.parseDouble(texto4.getText())));
                detalleInterno.setCosto(BigDecimal.valueOf(Double.parseDouble(texto5.getText())));
                detalleInterno.setTax(BigDecimal.valueOf(Double.parseDouble(texto6.getText())));
                trabajar(detalleInterno, Operacion, "detalles");
                dispose();
                new DetalleScreen((Frame) this.getParent(), false).setVisible(true);
            }
        } catch (Exception e) {
                Icon icon = (new javax.swing.ImageIcon(getClass().getResource("/META-INF/asegurese.png")));
            JOptionPane.showConfirmDialog(this, "Asegurese que los valores no esten vacios e intente nuevamente.",
                     "Notificacion", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, icon);
        }
    }//GEN-LAST:event_botonAgregarActionPerformed

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        int res = JOptionPane.showConfirmDialog(this, "Estas seguro que quieres cancelar la operacion?", "Advertencia", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (res==0){
            if (isCliente) {
                this.dispose();
                new ClienteScreen((Frame) this.getParent(), false).setVisible(true);

            }else if(isProducto){
                dispose();
                new InventarioScreen((Frame) this.getParent(), false).setVisible(true);
            }else if(isOrden){
                dispose();
                new OrdenScreen((Frame) this.getParent(), false).setVisible(true);
            }else if(isDetalle){
                dispose();
                new FacturaApp((Frame) this.getParent(),false).setVisible(true);
            }
        }
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void jPanel1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel1FocusGained

    }//GEN-LAST:event_jPanel1FocusGained
  
    public void trabajar(Object objeto, int operacion, String mensaje) {
        switch (mensaje) {
            case "cliente":
                Cliente objectoCliente = (Cliente) objeto;
                if (operacion == 0) {
                    GeneralMethods.Clientes.Clienteinsert(objectoCliente);

                } else if (operacion == 1) {
                    try {                                       
                        GeneralMethods.Clientes.ClienteUpdate(objectoCliente);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this, ex);
                    }
                } else if (operacion == 2) {
                    try {
                        
                        GeneralMethods.Clientes.ClienteDelete(objectoCliente.getIdcliente());
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this, ex);
                    }
                }
                break;
            case "producto":
                Productos objetoProducto = (Productos) objeto;
                if (operacion == 0) {
                    GeneralMethods.productos.ProductInsert(objetoProducto);

                } else if (operacion == 1) {
                    try {
                        GeneralMethods.productos.ProductUpdate(objetoProducto);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this, ex);
                    }
                } else if (operacion == 2) {
                    try {
                        GeneralMethods.productos.ProductoDelete(objetoProducto.getIdproducto());
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(this, ex);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this, ex);
                    }
                }
                break;
            case "orden":
                Orden objetoOrden = (Orden) objeto;
                if (operacion == 0) {
                    GeneralMethods.Ordenes.OrdenInsert(objetoOrden);

                } else if (operacion == 1) {
                    try {
                        GeneralMethods.Ordenes.OrdenUpdate(objetoOrden);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this, ex);
                    }
                } else if (operacion == 2) {

                    int res = JOptionPane.showConfirmDialog(this, "Si borra la orden, "
                            + "tambien borrara los detalles asociados a esta. Esta seguro que quiere borrar a:" + ordenInterna.toString());
                    if (res == 1 || res == -1 || res == 2) {
                        this.dispose();
                        new OrdenScreen((Frame) this.getParent(), true).setVisible(true);
                    } else {
                        try {
                            GeneralMethods.Ordenes.OrdenDelete(objetoOrden.getNoOrden());
                            GeneralMethods.OrdenDetalles.DetalleDelete(objetoOrden.getNoOrden());
                            JOptionPane.showMessageDialog(this, "Se ha borrado satisfactoramente");

                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(this, ex);
                        }
                    }
                }
                break;
            case "detalle":
                OrdenDetalle objetoDetalle = (OrdenDetalle) objeto;
                if (operacion == 0) {
                    GeneralMethods.OrdenDetalles.OrdenDetalleInsert(objetoDetalle);

                } else if (operacion == 1) {
                    try {
                        GeneralMethods.OrdenDetalles.OrdenDetalleUpdate(objetoDetalle);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this, ex);
                    }
                } else if (operacion == 2) {
                    try {
                        GeneralMethods.OrdenDetalles.DetalleDelete(objetoDetalle.getNoOrden());
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(this, ex);
                    }
                }
                break;
        }
    }

    private void labels(String mensaje) {
        switch (mensaje) {
            case "cliente":
                label1.setText("ID");
                label2.setText("Nombre");
                label3.setText("Direccion");
                label4.setVisible(false);
                label5.setVisible(false);
                label6.setVisible(false);
                label7.setVisible(false);
                texto4.setVisible(false);
                texto5.setVisible(false);
                texto6.setVisible(false);
                texto7.setVisible(false);
                if (Operacion == 1 || Operacion == 2) {
                    texto1.setText(String.valueOf(clienteInterno.getIdcliente()));
                    texto2.setText(clienteInterno.getNombre());
                    texto3.setText(clienteInterno.getDireccion());
                }
                break;
            case "producto":
                label1.setText("ID");
                texto1.setEditable(true);
                texto1.setText("");
                label2.setText("Descripcion");
                label3.setText("Cantidad");
                label4.setText("Precio");
                label5.setText("Costo");
                label6.setText("ITBIS");
                label7.setText("UltimaFecha");
                texto7.setEditable(false);
                texto7.setToolTipText("El campo ultima fecha es generado cuando se vende el producto");
                
                if (Operacion == 1 || Operacion == 2) {
                    texto1.setEditable(false);
                texto1.setToolTipText("El ID no puede ser borrado o editado porque es un valor unico, si necesita editarlo"
                        + "mejor borre el valor y escribalo nuevamente");
                    texto1.setText(String.valueOf(productoInterno.getIdproducto()));
                    texto2.setText(String.valueOf(productoInterno.getDescripcion()));
                    texto3.setText(String.valueOf(productoInterno.getCantidad()));
                    texto4.setText(String.valueOf(productoInterno.getPrecio()));
                    texto5.setText(String.valueOf(productoInterno.getCosto()));
                    texto6.setText(String.valueOf(productoInterno.getTax()));
                    texto7.setText(String.valueOf(productoInterno.getUltimaFechaVenta()));
                }
                break;
            case "orden":
                label1.setText("Numero de Orden");
                texto1.setEditable(false);
                texto1.setText("Este numero es generado por el sistema");
                label2.setText("Id cliente");
                label3.setText("Fecha");
                texto3.setEditable(false);
                label4.setText("Comentario");
                label5.setVisible(false);
                label6.setVisible(false);
                label7.setVisible(false);
                texto5.setVisible(false);
                texto6.setVisible(false);
                texto7.setVisible(false);
                if (Operacion == 1 || Operacion == 2) {
                    texto1.setText(String.valueOf(ordenInterna.getNoOrden()));
                    texto2.setText(String.valueOf(ordenInterna.getIdcliente()));
                    texto3.setText(String.valueOf(ordenInterna.getFecha()));
                    texto4.setText(String.valueOf(ordenInterna.getComentario()));
                }
                break;
            case "detalle":
                label1.setText("Numero de Orden");
                texto1.setEditable(false);
                label2.setText("ID de Producto");
                label3.setText("Cantidad");
                label4.setText("Precio");
                label5.setText("Costo");
                label6.setText("Tax");
                label7.setVisible(false);
                texto7.setVisible(false);
                if (Operacion == 1 || Operacion == 2) {
                    texto1.setText(String.valueOf(detalleInterno.getNoOrden()));
                    texto2.setText(String.valueOf(detalleInterno.getIdproducto()));
                    texto3.setText(String.valueOf(detalleInterno.getCantidad()));
                    texto4.setText(String.valueOf(detalleInterno.getPrecio()));
                    texto5.setText(String.valueOf(detalleInterno.getCosto()));
                    texto6.setText(String.valueOf(detalleInterno.getTax()));
                }
                break;
        }
    }

    private void constructor(int operationIn, String mensaje) {
        initComponents();
        this.Operacion = operationIn;
        this.setIconImage(new ImageIcon(getClass().getResource("/META-INF/money.png")).getImage());
        setLocationRelativeTo(null);
        labels(mensaje);
        if (operationIn == 0) {
            botonAgregar.setText("Agregar");
        } else if (operationIn == 1) {
            botonAgregar.setText("Editar");
        } else if (operationIn == 2) {
            botonAgregar.setText("Borrar");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Editor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Editor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Editor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Editor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Editor dialog = new Editor(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAgregar;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label4;
    private javax.swing.JLabel label5;
    private javax.swing.JLabel label6;
    private javax.swing.JLabel label7;
    private javax.swing.JTextField texto1;
    private javax.swing.JTextField texto2;
    private javax.swing.JTextField texto3;
    private javax.swing.JTextField texto4;
    private javax.swing.JTextField texto5;
    private javax.swing.JTextField texto6;
    private javax.swing.JTextField texto7;
    // End of variables declaration//GEN-END:variables
}
