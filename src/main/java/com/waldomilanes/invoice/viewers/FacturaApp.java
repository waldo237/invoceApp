
package com.waldomilanes.invoice.viewers;

import com.waldomilanes.invoice.jpacontrollers.Decision;
import static com.waldomilanes.invoice.jpacontrollers.Decision.PRODUCTOoDES;
import com.waldomilanes.invoice.jpacontrollers.ModeloJpaController;
import com.waldomilanes.invoice.pojos.Cliente;
import com.waldomilanes.invoice.pojos.Orden;
import com.waldomilanes.invoice.pojos.OrdenDetalle;
import com.waldomilanes.invoice.pojos.Productos;
import com.waldomilanes.invoice.restcontrollers.OrdenDetalleRESTController;
import com.waldomilanes.invoice.restcontrollers.OrdenRESTController;
import com.waldomilanes.invoice.restcontrollers.ProductosRESTController;
import com.waldomilanes.invoice.utilities.GeneralMethods;
import com.waldomilanes.invoice.utilities.ValidarField;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FacturaApp extends javax.swing.JDialog {
    private ProductosRESTController productosRest  = new ProductosRESTController();
    private OrdenRESTController ordenRest  = new OrdenRESTController();
    private DefaultTableModel modelo;
    private Cliente clienteInterno;
    private Orden ordenInterna;
    private OrdenDetalle detalleInterno;
    private Productos productoInterno;
    private ArrayList<Double> costoAcumulado = new ArrayList<>();
    private boolean listoParaGuardar = false;
    private ValidarField validar = new ValidarField();;

    public FacturaApp(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        constructor();
        validarField();
    }

    public FacturaApp(java.awt.Frame parent, boolean modal, Cliente c) {
        super(parent, modal);
        constructor();
        clienteInterno = c;
        clienteATabla();
        validarField();
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelCliente = new javax.swing.JLayeredPane();
        titulo = new javax.swing.JLabel();
        botonCliente = new javax.swing.JButton();
        cash1 = new javax.swing.JLabel();
        panelOperacion = new javax.swing.JLayeredPane();
        jLabel2 = new javax.swing.JLabel();
        vcodigo = new javax.swing.JTextField();
        vdes = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        vcantidad = new javax.swing.JTextField();
        vprecio = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        botonAgregar = new javax.swing.JButton();
        botonRestar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        vcosto = new javax.swing.JTextField();
        panelCatalogo = new javax.swing.JLayeredPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tDetalle = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLayeredPane4 = new javax.swing.JLayeredPane();
        tab = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        comentario = new javax.swing.JTextArea();
        jLayeredPane6 = new javax.swing.JLayeredPane();
        jLabel7 = new javax.swing.JLabel();
        vsub = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        vitbis = new javax.swing.JTextField();
        vtotal = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLayeredPane7 = new javax.swing.JLayeredPane();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        botonMail = new javax.swing.JButton();
        Inventario = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        botonImprimir = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaCliente = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        panelCliente.setBackground(new java.awt.Color(255, 255, 255));

        titulo.setFont(new java.awt.Font("Vijaya", 1, 18)); // NOI18N
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("FACTURA DE VENTA");

        botonCliente.setBackground(new java.awt.Color(255, 255, 255));
        botonCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/customer (3).png"))); // NOI18N
        botonCliente.setText("Cliente");
        botonCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonClienteActionPerformed(evt);
            }
        });

        cash1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        cash1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        cash1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/cash2.png"))); // NOI18N
        cash1.setText("CASH1");

        panelCliente.setLayer(titulo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelCliente.setLayer(botonCliente, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelCliente.setLayer(cash1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout panelClienteLayout = new javax.swing.GroupLayout(panelCliente);
        panelCliente.setLayout(panelClienteLayout);
        panelClienteLayout.setHorizontalGroup(
            panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelClienteLayout.createSequentialGroup()
                .addComponent(cash1)
                .addGap(121, 121, 121)
                .addComponent(titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(91, 91, 91)
                .addComponent(botonCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelClienteLayout.setVerticalGroup(
            panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelClienteLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(panelClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cash1)
                    .addComponent(botonCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panelOperacion.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel2.setText("Producto:");

        vcodigo.setToolTipText("Escriba el nombre o codigo del producto que desea buscar en el inventario");
        vcodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                vcodigoKeyTyped(evt);
            }
        });

        vdes.setToolTipText("Escriba el nombre o codigo del producto que desea buscar en el inventario");
        vdes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                vdesKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel3.setText("Cantidad:");

        vcantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vcantidadActionPerformed(evt);
            }
        });

        vprecio.setEditable(false);
        vprecio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                vprecioFocusLost(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel4.setText("Precio:");

        botonAgregar.setBackground(new java.awt.Color(255, 255, 255));
        botonAgregar.setFont(new java.awt.Font("Georgia", 3, 12)); // NOI18N
        botonAgregar.setText("+");
        botonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarActionPerformed(evt);
            }
        });

        botonRestar.setBackground(new java.awt.Color(255, 255, 255));
        botonRestar.setFont(new java.awt.Font("Georgia", 3, 14)); // NOI18N
        botonRestar.setText("-");
        botonRestar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRestarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel6.setText("Descripcion:");

        jLabel10.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel10.setText("Costo:");

        vcosto.setEditable(false);
        vcosto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                vcostoFocusLost(evt);
            }
        });
        vcosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vcostoActionPerformed(evt);
            }
        });

        panelOperacion.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelOperacion.setLayer(vcodigo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelOperacion.setLayer(vdes, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelOperacion.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelOperacion.setLayer(vcantidad, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelOperacion.setLayer(vprecio, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelOperacion.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelOperacion.setLayer(botonAgregar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelOperacion.setLayer(botonRestar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelOperacion.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelOperacion.setLayer(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelOperacion.setLayer(vcosto, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout panelOperacionLayout = new javax.swing.GroupLayout(panelOperacion);
        panelOperacion.setLayout(panelOperacionLayout);
        panelOperacionLayout.setHorizontalGroup(
            panelOperacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelOperacionLayout.createSequentialGroup()
                .addGroup(panelOperacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelOperacionLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelOperacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelOperacionLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(vcodigo)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(vdes, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelOperacionLayout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(vcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelOperacionLayout.createSequentialGroup()
                        .addGap(257, 257, 257)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(vprecio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(vcosto)))
                .addGap(18, 18, 18)
                .addGroup(panelOperacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botonAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addComponent(botonRestar, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelOperacionLayout.setVerticalGroup(
            panelOperacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOperacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelOperacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(vcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(vdes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonAgregar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelOperacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel3)
                    .addComponent(vcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(vprecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(vcosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonRestar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelCatalogo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tDetalle.getTableHeader().setResizingAllowed(false);
        tDetalle.getTableHeader().setReorderingAllowed(false);
        tDetalle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tDetalleMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tDetalle);

        jLabel1.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Catalogo de productos");

        panelCatalogo.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelCatalogo.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout panelCatalogoLayout = new javax.swing.GroupLayout(panelCatalogo);
        panelCatalogo.setLayout(panelCatalogoLayout);
        panelCatalogoLayout.setHorizontalGroup(
            panelCatalogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCatalogoLayout.createSequentialGroup()
                .addGap(280, 280, 280)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(277, 277, 277))
            .addComponent(jScrollPane1)
        );
        panelCatalogoLayout.setVerticalGroup(
            panelCatalogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCatalogoLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLayeredPane4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(jTable1);

        tab.addTab("Detalles de la orden", jScrollPane2);

        comentario.setColumns(20);
        comentario.setRows(5);
        jScrollPane4.setViewportView(comentario);

        tab.addTab("Comentario", jScrollPane4);

        jLayeredPane4.setLayer(tab, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane4Layout = new javax.swing.GroupLayout(jLayeredPane4);
        jLayeredPane4.setLayout(jLayeredPane4Layout);
        jLayeredPane4Layout.setHorizontalGroup(
            jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tab)
        );
        jLayeredPane4Layout.setVerticalGroup(
            jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tab, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
        );

        jLabel7.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel7.setText("Subtotal:");

        vsub.setEditable(false);
        vsub.setText("0.00");
        vsub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vsubActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel8.setText("ITBIS:");

        vitbis.setEditable(false);
        vitbis.setText("0.00");
        vitbis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vitbisActionPerformed(evt);
            }
        });

        vtotal.setEditable(false);
        vtotal.setText("0.00");
        vtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vtotalActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel9.setText("Total:");

        jLayeredPane6.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane6.setLayer(vsub, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane6.setLayer(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane6.setLayer(vitbis, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane6.setLayer(vtotal, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane6.setLayer(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane6Layout = new javax.swing.GroupLayout(jLayeredPane6);
        jLayeredPane6.setLayout(jLayeredPane6Layout);
        jLayeredPane6Layout.setHorizontalGroup(
            jLayeredPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane6Layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(jLabel7)
                .addGap(10, 10, 10)
                .addComponent(vsub, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(10, 10, 10)
                .addComponent(vitbis, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                .addGap(26, 26, 26)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(vtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jLayeredPane6Layout.setVerticalGroup(
            jLayeredPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane6Layout.createSequentialGroup()
                .addGroup(jLayeredPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel7)
                    .addComponent(vsub, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(vitbis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jButton2.setText("Guardar");
        jButton2.setAutoscrolls(true);
        jButton2.setMaximumSize(new java.awt.Dimension(87, 28));
        jButton2.setMinimumSize(new java.awt.Dimension(87, 28));
        jButton2.setPreferredSize(new java.awt.Dimension(87, 28));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jButton1.setText("Cancelar");
        jButton1.setMaximumSize(new java.awt.Dimension(87, 28));
        jButton1.setMinimumSize(new java.awt.Dimension(87, 28));
        jButton1.setPreferredSize(new java.awt.Dimension(87, 28));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        botonMail.setBackground(new java.awt.Color(255, 255, 255));
        botonMail.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        botonMail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/mail.png"))); // NOI18N
        botonMail.setText("Mail");
        botonMail.setIconTextGap(2);
        botonMail.setMaximumSize(new java.awt.Dimension(87, 28));
        botonMail.setMinimumSize(new java.awt.Dimension(87, 28));
        botonMail.setPreferredSize(new java.awt.Dimension(87, 28));
        botonMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMailActionPerformed(evt);
            }
        });

        Inventario.setBackground(new java.awt.Color(255, 255, 255));
        Inventario.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        Inventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/producto (2).png"))); // NOI18N
        Inventario.setText("Inventario");
        Inventario.setIconTextGap(2);
        Inventario.setMaximumSize(new java.awt.Dimension(87, 28));
        Inventario.setMinimumSize(new java.awt.Dimension(87, 28));
        Inventario.setPreferredSize(new java.awt.Dimension(87, 28));
        Inventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InventarioActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/history.png"))); // NOI18N
        jButton6.setText("Anteriores");
        jButton6.setMaximumSize(new java.awt.Dimension(87, 28));
        jButton6.setMinimumSize(new java.awt.Dimension(87, 28));
        jButton6.setPreferredSize(new java.awt.Dimension(87, 28));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        botonImprimir.setBackground(new java.awt.Color(255, 255, 255));
        botonImprimir.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        botonImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/print.png"))); // NOI18N
        botonImprimir.setText("Imprimir");
        botonImprimir.setIconTextGap(2);
        botonImprimir.setMaximumSize(new java.awt.Dimension(87, 28));
        botonImprimir.setMinimumSize(new java.awt.Dimension(87, 28));
        botonImprimir.setPreferredSize(new java.awt.Dimension(87, 28));
        botonImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonImprimirActionPerformed(evt);
            }
        });

        jLayeredPane7.setLayer(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane7.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane7.setLayer(botonMail, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane7.setLayer(Inventario, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane7.setLayer(jButton6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane7.setLayer(botonImprimir, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane7Layout = new javax.swing.GroupLayout(jLayeredPane7);
        jLayeredPane7.setLayout(jLayeredPane7Layout);
        jLayeredPane7Layout.setHorizontalGroup(
            jLayeredPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane7Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonMail, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Inventario, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jLayeredPane7Layout.setVerticalGroup(
            jLayeredPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane7Layout.createSequentialGroup()
                .addGroup(jLayeredPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Inventario, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonMail, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));

        tablaCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaCliente.getTableHeader().setResizingAllowed(false);
        tablaCliente.getTableHeader().setReorderingAllowed(false);
        tablaCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tablaClienteMouseReleased(evt);
            }
        });
        jScrollPane3.setViewportView(tablaCliente);

        jPanel4.setBackground(new java.awt.Color(179, 0, 47));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLayeredPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelCliente)
                            .addComponent(panelOperacion, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelCatalogo, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLayeredPane4)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLayeredPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(9, 9, 9)))
                .addGap(34, 34, 34))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelCatalogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLayeredPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLayeredPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLayeredPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonClienteActionPerformed

        if(jTable1.getRowCount()>0){
            if(devolverProductos(false)){
                dispose();
                new ClienteScreen((Frame) this.getParent(), false).setVisible(true);
            }
        }else{
           dispose();
            new ClienteScreen((Frame) this.getParent(), false).setVisible(true);
            
        }
    }//GEN-LAST:event_botonClienteActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        if (jTable1.getRowCount() > 0) {
            if (devolverProductos(false)) {
//                dispose();
                new Pregunta((Frame) this.getParent(), true).setVisible(true);
            }
        } else {
//            dispose();
            new Pregunta((Frame) this.getParent(), true).setVisible(true);

        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void vcodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_vcodigoKeyTyped
        if (clienteInterno != null) {
           
            busquedaLibre(PRODUCTOoDES, vcodigo.getText());
        } else {
            vcodigo.setText("");
            Icon icon = (new javax.swing.ImageIcon(getClass().getResource("/META-INF/asegurese.png")));
            JOptionPane.showConfirmDialog(this, "Tiene que seleccionar el cliente antes de buscar el producto.",
                     "Notificacion", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, icon);
            botonCliente.setBackground(Color.red);
        }
    }//GEN-LAST:event_vcodigoKeyTyped

    private void vdesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_vdesKeyTyped
        if (clienteInterno != null) {

            busquedaLibre(PRODUCTOoDES, vdes.getText());
        } else {
            vcodigo.setText("");
            Icon icon = (new javax.swing.ImageIcon(getClass().getResource("/META-INF/asegurese.png")));
            JOptionPane.showConfirmDialog(this, "Tiene que seleccionar el cliente antes de buscar el producto.",
                     "Notificacion", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, icon);
            botonCliente.setBackground(Color.red);
        }
    }//GEN-LAST:event_vdesKeyTyped

    private void vprecioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_vprecioFocusLost
        try {
            float v = 0;
            v = Float.parseFloat(vcantidad.getText()) * Float.parseFloat(vprecio.getText()) * 0.18f;
            BigDecimal vCurr = new BigDecimal(v).setScale(2, BigDecimal.ROUND_HALF_UP);

        } catch (NumberFormatException numberFormatException) {

        }
    }//GEN-LAST:event_vprecioFocusLost

    private void botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarActionPerformed
        try {

            boolean save = false;
            double v, subtotal = 0, it = 0, total = 0, sum = 0, ttotal;

            if (vcodigo.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "La referencia esta en blanco");
            } else if (vdes.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "La descripcion esta en blanco");
            } else {
                save = true;
            }

            if (save && Integer.parseInt(vcantidad.getText()) > 0) {

                int cantidadDisponible = Integer.parseInt(String.valueOf(tDetalle.getValueAt(tDetalle.getSelectedRow(), 2)));
                int cantidadPedida = Integer.parseInt(vcantidad.getText());
                if (cantidadDisponible - cantidadPedida >= 0) {
                    GeneralMethods.productos.reimburnse(String.valueOf(tDetalle.getValueAt(tDetalle.getSelectedRow(), 0)), cantidadDisponible - cantidadPedida);

                    String precio = String.valueOf(tDetalle.getValueAt(tDetalle.getSelectedRow(), 3));
                    costoAcumulado.add(Double.parseDouble(String.valueOf(tDetalle.getValueAt(tDetalle.getSelectedRow(), 4))));

                    v = Integer.parseInt(vcantidad.getText()) * Float.parseFloat(precio) * 0.18f;
                    ttotal = v + (Float.parseFloat(precio) * Integer.parseInt(vcantidad.getText()));
                    BigDecimal vCurr = new BigDecimal(v).setScale(2, BigDecimal.ROUND_HALF_UP);
                    BigDecimal tCurr = new BigDecimal(ttotal).setScale(2, BigDecimal.ROUND_HALF_UP);

                    String[] ar = new String[6];
                    ar[0] = vcodigo.getText();
                    ar[1] = vdes.getText();
                    ar[2] = vcantidad.getText();
                    ar[3] = precio;
                    ar[4] = String.valueOf(vCurr);
                    ar[5] = String.valueOf(tCurr);
                    modelo.addRow(ar);

                    for (int i = 0; i < modelo.getRowCount(); i++) {
                        subtotal += Float.parseFloat((String) modelo.getValueAt(i, 2))
                                * Float.parseFloat((String) modelo.getValueAt(i, 3));
                        it += Float.parseFloat((String) modelo.getValueAt(i, 4));
                    }
                    sum = it + subtotal;
                    BigDecimal subCurr = new BigDecimal(subtotal).setScale(2, BigDecimal.ROUND_HALF_UP);
                    BigDecimal itCurr = new BigDecimal(it).setScale(2, BigDecimal.ROUND_HALF_UP);
                    BigDecimal sumCurr = new BigDecimal(sum).setScale(2, BigDecimal.ROUND_HALF_UP);
                    Locale locale = new Locale("es", "DO");
                    NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);

                    vsub.setText(String.valueOf(currencyFormatter.format(subCurr)));
                    vitbis.setText(String.valueOf(currencyFormatter.format(itCurr)));
                    vtotal.setText(String.valueOf(currencyFormatter.format(sumCurr)));

                    if (!vtotal.getText().equalsIgnoreCase("RD$0.00")) {
                        listoParaGuardar = true;
                    } else {
                        listoParaGuardar = false;
                    }
                    vcodigo.setText("");
                    vdes.setText("");
                    vcantidad.setText("");
                    vprecio.setText("");
                    vcosto.setText("");
                    tDetalle.setModel(new DefaultTableModel());

                } else {
                    JOptionPane.showMessageDialog(this, "La cantidad pedida no esta disponible en el inventario");
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Introduzca la cantidad que el cliente desea");
        } catch (Exception ex) {
            Logger.getLogger(FacturaApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botonAgregarActionPerformed

    private void botonRestarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRestarActionPerformed
        try {
            productoInterno = new ProductosRESTController().getProducto(String.valueOf(jTable1.getValueAt(jTable1.getSelectedRow(), 0)));
            int cantidadDevuelta = Integer.parseInt(String.valueOf(jTable1.getValueAt(jTable1.getSelectedRow(), 2)));
            GeneralMethods.productos.reimburnse(String.valueOf(jTable1.getValueAt(jTable1.getSelectedRow(), 0)), productoInterno.getCantidad() + cantidadDevuelta);

            double subtotal = 0, it = 0, total = 0, sum = 0, ttotal;

            costoAcumulado.remove(productoInterno.getCosto());
            modelo.removeRow(jTable1.getSelectedRow());
            for (int i = 0; i < modelo.getRowCount(); i++) {
                subtotal += Float.parseFloat((String) modelo.getValueAt(i, 2))
                        * Float.parseFloat((String) modelo.getValueAt(i, 3));
                it += Float.parseFloat((String) modelo.getValueAt(i, 4));
            }
            sum = it + subtotal;
            BigDecimal subCurr = new BigDecimal(subtotal).setScale(2, BigDecimal.ROUND_HALF_UP);
            BigDecimal itCurr = new BigDecimal(it).setScale(2, BigDecimal.ROUND_HALF_UP);
            BigDecimal sumCurr = new BigDecimal(sum).setScale(2, BigDecimal.ROUND_HALF_UP);
            Locale locale = new Locale("es", "DO");
            NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
            vsub.setText(String.valueOf(currencyFormatter.format(subCurr)));
            vitbis.setText(String.valueOf(currencyFormatter.format(itCurr)));
            vtotal.setText(String.valueOf(currencyFormatter.format(sumCurr)));

            if (vtotal.getText().equalsIgnoreCase("RD$0.00")) {
                listoParaGuardar = false;
            } else {
                listoParaGuardar = true;
            }
        } catch (Exception e) {
            vcodigo.setText("");
            vdes.setText("");
            vcantidad.setText("");
            vprecio.setText("");
            vcosto.setText("");
            JOptionPane.showMessageDialog(null, "No hay ningun articulo seleccionado para borrar. ");

        }
    }//GEN-LAST:event_botonRestarActionPerformed

    private void vcostoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_vcostoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_vcostoFocusLost

    private void vcostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vcostoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vcostoActionPerformed

    private void InventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InventarioActionPerformed

        if (jTable1.getRowCount() > 0) {
            if (devolverProductos(false)) {
                dispose();
                new InventarioScreen((Frame) this.getParent(), false).setVisible(true);
            }
        } else {
            dispose();
            new InventarioScreen((Frame) this.getParent(), false).setVisible(true);

        }
    }//GEN-LAST:event_InventarioActionPerformed

    private void vsubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vsubActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vsubActionPerformed

    private void vitbisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vitbisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vitbisActionPerformed

    private void vtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vtotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vtotalActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        devolverProductos(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(listoParaGuardar){
            llenarOrden();
            try {
                llenarDetalle();
            } catch (SQLException ex) {
                Logger.getLogger(FacturaApp.class.getName()).log(Level.SEVERE, null, ex);
            }catch(java.lang.RuntimeException e){
          Logger.getLogger(FacturaApp.class.getName()).log(Level.SEVERE, null, e);

            }
                
            updateFechaProducto();
             dispose();
            new Guardado((Frame) this.getParent(), false, ordenInterna).setVisible(true);
           
        }else{
            JOptionPane.showMessageDialog(null,"Lo sentimos, la factura no esta lista para ser guardada.");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tDetalleMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tDetalleMouseReleased
        Locale locale = new Locale("es", "DO");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
        String precio = String.valueOf(currencyFormatter.format(tDetalle.getValueAt(tDetalle.getSelectedRow(), 3)));
        String costo = String.valueOf(currencyFormatter.format(tDetalle.getValueAt(tDetalle.getSelectedRow(), 4)));

        vcodigo.setText(String.valueOf(tDetalle.getValueAt(tDetalle.getSelectedRow(), 0)));
        vdes.setText(String.valueOf(tDetalle.getValueAt(tDetalle.getSelectedRow(), 1)));
        vcantidad.setText(String.valueOf(1));
        vprecio.setText(precio);
        vcosto.setText(costo);
        ;

    }//GEN-LAST:event_tDetalleMouseReleased

    private void botonImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonImprimirActionPerformed
       new Impresora((Frame) this.getParent(),true, ordenInterna).setVisible(true);
    }//GEN-LAST:event_botonImprimirActionPerformed

    private void botonMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMailActionPerformed
      new EmailScreen((Frame) this.getParent(), true).setVisible(true);
    }//GEN-LAST:event_botonMailActionPerformed

    private void vcantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vcantidadActionPerformed
       
    }//GEN-LAST:event_vcantidadActionPerformed

    private void tablaClienteMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaClienteMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaClienteMouseReleased

    public void llenarOrden() {

        ordenInterna = ordenRest.getLastOrden("");
       
        ordenInterna.setIdcliente(clienteInterno.getIdcliente());
        ordenInterna.setComentario(comentario.getText());
       ordenRest.addOrden(ordenInterna);

    }

    public void llenarDetalle() throws SQLException {
       
    ordenInterna = new OrdenRESTController().getLastOrden("");
  
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            detalleInterno = new OrdenDetalle();
            detalleInterno.setNoOrden(ordenInterna.getNoOrden());
            detalleInterno.setIdproducto(productlist(i));
            detalleInterno.setCantidad(cantidad(i));
            detalleInterno.setPrecio(BigDecimal.valueOf(precio(i)));
            detalleInterno.setCosto(BigDecimal.valueOf(costoAcumulado.get(i)));
            detalleInterno.setTax(BigDecimal.valueOf(tax(i)));
            
            new OrdenDetalleRESTController().addOrdenDetalle(detalleInterno);
        }
    }

    public String productlist(int i) {
        String s = "";
        s = String.valueOf(jTable1.getValueAt(i, 0));
        return s.toString();
    }

    public int cantidad(int i) {
        int sum = 0;
        sum = Integer.parseInt(String.valueOf(jTable1.getValueAt(i, 2)));
        return sum;
    }

    public double precio(int i) {
        double sum = 0;
        sum = Double.parseDouble(String.valueOf(jTable1.getValueAt(i, 3)));
        return sum;
    }

    private double tax(int i) {
        double sum = 0;
        sum = Double.parseDouble(String.valueOf(jTable1.getValueAt(i, 4)));
        return sum;
    }

    private void updateFechaProducto() {
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            try {
                GeneralMethods.productos.updateFecha(String.valueOf(jTable1.getValueAt(i, 0)));
            } catch (Exception ex) {
                Logger.getLogger(FacturaApp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void busquedaLibre(Decision SQL, String busqueda) {
        DefaultTableModel m;
        try {
            
            m = ModeloJpaController.modelFree(SQL, busqueda);
            tDetalle.setModel(m);

        } catch (RuntimeException es) {
            JOptionPane.showMessageDialog(null, es);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void clienteATabla() {
        DefaultTableModel m = new DefaultTableModel();
        m.addColumn("ID");
        m.addColumn("Nombre");
        m.addColumn("Direccion");
        String[] ar = new String[3];
        ar[0] = String.valueOf(clienteInterno.getIdcliente());
        ar[1] = clienteInterno.getNombre();
        ar[2] = clienteInterno.getDireccion();
        m.addRow(ar);
        tablaCliente.setModel(m);
    }

    public void constructor() {
        initComponents();
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                devolverProductos(true);
            }
        });
        setIconImage(new ImageIcon(getClass().getResource("/META-INF/cash1.png")).getImage());
        setLocationRelativeTo(null);
        modelo = new DefaultTableModel();
        modelo.addColumn("Referencia");
        modelo.addColumn("Descripcion");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio");
        modelo.addColumn("ITBIS");
        modelo.addColumn("Total");
        jTable1.setModel(modelo);
         
    }

    public boolean devolverProductos(boolean formaDeCerrar) {
        int pregunta;
        boolean respuestaCliente;
        pregunta = JOptionPane.showConfirmDialog(null, "Estas seguro que quieres cerrar la ventana de facturas?"
                + "\nSe deshacera la orden y todos los cambios se perderan.");
        if (pregunta == 0) {
            respuestaCliente = true;
            for (int i = 0; i < jTable1.getRowCount(); i++) {
                try {
                    Productos cantidadDisponible = GeneralMethods.productos.productGenerator(String.valueOf(jTable1.getValueAt(i, 0)));
                    int cantidadDevuelta = Integer.parseInt(String.valueOf(jTable1.getValueAt(i, 2)));
                    GeneralMethods.productos.reimburnse(String.valueOf(jTable1.getValueAt(i, 0)), cantidadDisponible.getCantidad() + cantidadDevuelta);
                } catch (Exception ex) {
                    Logger.getLogger(FacturaApp.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (formaDeCerrar) {
                dispose();
            } else {
                dispose();
            }
        } else {
            respuestaCliente = false;
        }
        return respuestaCliente;
    }

    
    private void validarField() {
        validar.validarSoloNumeros(vcantidad);

    }
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
            java.util.logging.Logger.getLogger(FacturaApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FacturaApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FacturaApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FacturaApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FacturaApp dialog = new FacturaApp(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton Inventario;
    private javax.swing.JButton botonAgregar;
    private javax.swing.JButton botonCliente;
    private javax.swing.JButton botonImprimir;
    private javax.swing.JButton botonMail;
    private javax.swing.JButton botonRestar;
    private javax.swing.JLabel cash1;
    private javax.swing.JTextArea comentario;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane4;
    private javax.swing.JLayeredPane jLayeredPane6;
    private javax.swing.JLayeredPane jLayeredPane7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JLayeredPane panelCatalogo;
    private javax.swing.JLayeredPane panelCliente;
    private javax.swing.JLayeredPane panelOperacion;
    private javax.swing.JTable tDetalle;
    private javax.swing.JTabbedPane tab;
    private javax.swing.JTable tablaCliente;
    private javax.swing.JLabel titulo;
    private javax.swing.JTextField vcantidad;
    private javax.swing.JTextField vcodigo;
    private javax.swing.JTextField vcosto;
    private javax.swing.JTextField vdes;
    private javax.swing.JTextField vitbis;
    private javax.swing.JTextField vprecio;
    private javax.swing.JTextField vsub;
    private javax.swing.JTextField vtotal;
    // End of variables declaration//GEN-END:variables
}
