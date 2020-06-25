
package com.waldomilanes.invoiceviewers;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import com.waldomilanes.invoicepojos.Orden;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

/**
 *
 * @author Instructor
 */
public class Impresora extends javax.swing.JDialog {
    private Orden ordenInterna;
 
    public Impresora(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/META-INF/cash1.png")).getImage());
        setLocationRelativeTo(null);
    }
    public Impresora(java.awt.Frame parent, boolean modal, Orden ordenInterna) {
        super(parent, modal);
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/META-INF/cash1.png")).getImage());
        setLocationRelativeTo(null);
        this.ordenInterna = ordenInterna;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        botonImprimir = new javax.swing.JButton();
        botonImprimir1 = new javax.swing.JButton();
        botonImprimir2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtPath = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(463, 296));

        botonImprimir.setBackground(new java.awt.Color(255, 255, 255));
        botonImprimir.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        botonImprimir.setForeground(new java.awt.Color(179, 0, 47));
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

        botonImprimir1.setBackground(new java.awt.Color(255, 255, 255));
        botonImprimir1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        botonImprimir1.setForeground(new java.awt.Color(179, 0, 47));
        botonImprimir1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/pdf.png"))); // NOI18N
        botonImprimir1.setText("Descargar");
        botonImprimir1.setIconTextGap(2);
        botonImprimir1.setMaximumSize(new java.awt.Dimension(87, 28));
        botonImprimir1.setMinimumSize(new java.awt.Dimension(87, 28));
        botonImprimir1.setPreferredSize(new java.awt.Dimension(87, 28));
        botonImprimir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonImprimir1ActionPerformed(evt);
            }
        });

        botonImprimir2.setBackground(new java.awt.Color(255, 255, 255));
        botonImprimir2.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        botonImprimir2.setForeground(new java.awt.Color(179, 0, 47));
        botonImprimir2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/return.png"))); // NOI18N
        botonImprimir2.setText("Cerrar");
        botonImprimir2.setIconTextGap(2);
        botonImprimir2.setMaximumSize(new java.awt.Dimension(87, 28));
        botonImprimir2.setMinimumSize(new java.awt.Dimension(87, 28));
        botonImprimir2.setPreferredSize(new java.awt.Dimension(87, 28));
        botonImprimir2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonImprimir2ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/cash1.png"))); // NOI18N
        jLabel4.setText("CASH1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(botonImprimir2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(botonImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonImprimir1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(46, 46, 46))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(139, 139, 139))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonImprimir1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(botonImprimir2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(txtPath, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtPath)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
       
    private void botonImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonImprimirActionPerformed
      
    }//GEN-LAST:event_botonImprimirActionPerformed

    private void botonImprimir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonImprimir1ActionPerformed
        JFileChooser dlg = new JFileChooser();
        String fileName = "";
        int option = dlg.showSaveDialog(this);
        if(option == JFileChooser.APPROVE_OPTION){
            File f = dlg.getSelectedFile();
            fileName = f.toString();
            txtPath.setText(f.toString());
        }
        
            fileName = fileName + ".pdf";
           new GenerateInvoice().createPDF(fileName);
//            try {
//             
//            FileOutputStream archivo = new FileOutputStream(fileName);
//                Document document = new Document();
//                PdfWriter.getInstance(document, archivo);
//            
    }//GEN-LAST:event_botonImprimir1ActionPerformed

    private void botonImprimir2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonImprimir2ActionPerformed
        dispose();
    }//GEN-LAST:event_botonImprimir2ActionPerformed
    public static class GenerateInvoice {

        private BaseFont bfBold;
        private BaseFont bf;
        private int pageNumber = 0;

        private void createPDF(String pdfFilename) {

            Document doc = new Document();
            PdfWriter docWriter = null;
            initializeFonts();

            try {

                docWriter = PdfWriter.getInstance(doc, new FileOutputStream(pdfFilename));
                doc.addAuthor("betterThanZero");
                doc.addCreationDate();
                doc.addProducer();
                doc.addCreator("MySampleCode.com");
                doc.addTitle("Invoice");
                doc.setPageSize(PageSize.LETTER);

                doc.open();
                PdfContentByte cb = docWriter.getDirectContent();

                boolean beginPage = true;
                int y = 0;

                for (int i = 0; i < 20; i++) {
                    if (beginPage) {
                        beginPage = false;
                        generateLayout(doc, cb);
                        generateHeader(doc, cb);
                        y = 615;
                    }
                    generateDetail(doc, cb, i, y);
                    y = y - 15;
                    if (y < 50) {
                        printPageNumber(cb);
                        doc.newPage();
                        beginPage = true;
                    }
                }
                printPageNumber(cb);

            } catch (DocumentException dex) {
                dex.printStackTrace();
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                if (doc != null) {
                    doc.close();
                }
                if (docWriter != null) {
                    docWriter.close();
                }
            }
        }

        private void generateLayout(Document doc, PdfContentByte cb) {

            try {

                cb.setLineWidth(1f);

                // Invoice Header box layout
//                cb.rectangle(520, 700, 150, 60);
//                cb.moveTo(420, 720);
//                cb.lineTo(570, 720);
//                cb.moveTo(420, 740);
//                cb.lineTo(570, 740);
//                cb.moveTo(480, 700);
//                cb.lineTo(480, 760);
//                cb.stroke();

                // Invoice Header box Text Headings 
                createHeadings(cb, 400, 720, "Cliente:");
                createHeadings(cb, 400, 705, "Numero de orden");
                createHeadings(cb, 400, 690, "Fecha de Facturación");

                // Invoice Detail box layout 
                cb.rectangle(20, 50, 550, 600);
                cb.moveTo(20, 630);
                cb.lineTo(570, 630);
                cb.moveTo(50, 50);
                cb.lineTo(50, 650);
                cb.moveTo(150, 50);
                cb.lineTo(150, 650);
                cb.moveTo(430, 50);
                cb.lineTo(430, 650);
                cb.moveTo(500, 50);
                cb.lineTo(500, 650);
                cb.stroke();

                // Invoice Detail box Text Headings 
                createHeadings(cb, 22, 633, "Cantidad");
                createHeadings(cb, 52, 633, "Codigo");
                createHeadings(cb, 152, 633, "Descripcion");
                createHeadings(cb, 432, 633, "Precio");
                createHeadings(cb, 502, 633, "ITBIS");

                //add the images
                Image companyLogo = Image.getInstance("D:/Users/Instructor/Google Drive/PROGRAMMING/JAVA INTERMEDIO/proyectoproductos/src/main/resources/META-INF/money.png");
                companyLogo.setAbsolutePosition(25, 700);
                companyLogo.scalePercent(50);
                doc.add(companyLogo);

            } catch (DocumentException dex) {
                dex.printStackTrace();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }

        private void generateHeader(Document doc, PdfContentByte cb) {

            try {

                createHeadings(cb, 80, 765, "Facturacion ITLA");
                createHeadings(cb, 80, 750, "\"AV. 27 de Febrero esq. Metropolitana,. Edificio Metropolitano #1.\"");
                createHeadings(cb, 80, 735, "Los Jardines, Santiago");
                createHeadings(cb, 80, 720, "E-mail: info@itla.edu.do");
                createHeadings(cb, 80, 705, "Tel: 809-971-4852");
                createHeadings(cb, 80, 690, "Republica Dominicana");

                createHeadings(cb, 500, 720, "ABC0001");
                createHeadings(cb, 500, 705, "123456");
                createHeadings(cb, 500, 690, "09/26/2012");

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }

        private void generateDetail(Document doc, PdfContentByte cb, int index, int y) {
            DecimalFormat df = new DecimalFormat("0.00");

            try {

                createContent(cb, 48, y, String.valueOf(index + 1), PdfContentByte.ALIGN_RIGHT);
                createContent(cb, 52, y, "ITEM" + String.valueOf(index + 1), PdfContentByte.ALIGN_LEFT);
                createContent(cb, 152, y, "Product Description - SIZE " + String.valueOf(index + 1), PdfContentByte.ALIGN_LEFT);

                double price = Double.valueOf(df.format(Math.random() * 10));
                double extPrice = price * (index + 1);
                createContent(cb, 498, y, df.format(price), PdfContentByte.ALIGN_RIGHT);
                createContent(cb, 568, y, df.format(extPrice), PdfContentByte.ALIGN_RIGHT);

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }

        private void createHeadings(PdfContentByte cb, float x, float y, String text) {

            cb.beginText();
            cb.setFontAndSize(bfBold, 8);
            cb.setTextMatrix(x, y);
            cb.showText(text.trim());
            cb.endText();

        }

        private void printPageNumber(PdfContentByte cb) {

            cb.beginText();
            cb.setFontAndSize(bfBold, 8);
            cb.showTextAligned(PdfContentByte.ALIGN_RIGHT, "Page No. " + (pageNumber + 1), 570, 25, 0);
            cb.endText();

            pageNumber++;

        }

        private void createContent(PdfContentByte cb, float x, float y, String text, int align) {

            cb.beginText();
            cb.setFontAndSize(bf, 8);
            cb.showTextAligned(align, text.trim(), x, y, 0);
            cb.endText();

        }

        private void initializeFonts() {

            try {
                bfBold = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
                bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);

            } catch (DocumentException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

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
            java.util.logging.Logger.getLogger(Impresora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Impresora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Impresora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Impresora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Impresora dialog = new Impresora(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton botonImprimir;
    private javax.swing.JButton botonImprimir1;
    private javax.swing.JButton botonImprimir2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel txtPath;
    // End of variables declaration//GEN-END:variables
}
