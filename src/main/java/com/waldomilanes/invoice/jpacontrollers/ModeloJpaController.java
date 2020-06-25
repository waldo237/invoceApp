/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.waldomilanes.invoice.jpacontrollers;

import com.waldomilanes.invoice.utilities.DBType;
import com.waldomilanes.invoice.utilities.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Instructor
 */
public class ModeloJpaController {

    public ModeloJpaController() {
        
    }
    public static String decide(Decision decision){
        switch (decision) {
            case PRODUCTOoDES:
                return "SELECT idproducto, descripcion, cantidad, precio, costo, tax, ultima_fecha_venta "
                        + "  FROM public.productos WHERE idproducto ilike ? or descripcion ilike ?; ";
            case CLIENTE:
                return "SELECT idcliente AS ID, nombre AS Cliente, direccion FROM public.cliente WHERE nombre ilike ? or direccion ilike ? ;";
            case PRODUCTO:
                return "SELECT idproducto AS codigo, descripcion, cantidad, precio, costo, tax AS ITBIS, ultima_fecha_venta FROM public.productos WHERE idproducto ilike ? or descripcion ilike ? ;";

            case ALLDETALLE:
                return "SELECT a.no_orden, a.idproducto, a.cantidad, a.precio, a.costo, a.tax, b.fecha\n"
                        + "  FROM public.orden_detalle a INNER JOIN public.orden b ON b.no_orden = a.no_orden;";
            case DETALLEXORDEN:
                return "SELECT a.no_orden, a.idproducto, a.cantidad, a.precio, a.costo, a.tax, b.fecha\n"
                        + "  FROM public.orden_detalle a INNER JOIN public.orden b ON b.no_orden = a.no_orden WHERE no_orden =?;";
            case FACTURA:
                return "SELECT a.no_orden AS orden, a.idproducto AS productos,\n"
                        + "d.descripcion, a.cantidad, a.precio, a.costo, a.tax AS ITBIS, b.fecha,b.comentario FROM public.orden_detalle a \n"
                        + "INNER JOIN public.orden b ON b.no_orden = a.no_orden\n"
                        + "INNER JOIN public.cliente c ON c.idcliente = b.idcliente "
                        + "INNER JOIN public.productos d ON a.idproducto = d.idproducto "
                        + "WHERE b.no_orden = ?;";
            case ORDENconCLIENTE:
                return "SELECT a.no_orden, a.fecha,a.idcliente, b.nombre AS Cliente,a.comentario "
                        + "FROM public.orden a INNER JOIN public.cliente b on b.idcliente =a.idcliente WHERE no_orden = ?;";

            case ALLFACTURA:
                return "SELECT a.no_orden AS orden,c.nombre AS cliente, a.idproducto AS productos,\n"
                        + " a.cantidad, a.precio, a.costo, a.tax AS ITBIS, b.fecha,b.comentario FROM public.orden_detalle a \n"
                        + "INNER JOIN public.orden b ON b.no_orden = a.no_orden\n"
                        + "INNER JOIN public.cliente c ON c.idcliente = b.idcliente;";
            case ORDENcCLIENTE:
                return "SELECT a.no_orden,a.idcliente AS Codigo_Cliente, b.nombre, a.comentario, fecha "
                + "FROM public.orden a INNER JOIN public.cliente b ON b.idcliente = a.idcliente;";
            case ORDENBUS:
                return "SELECT a.no_orden,a.idcliente AS Codigo_Cliente, b.nombre, a.comentario, fecha "
            + "FROM public.orden a INNER JOIN public.cliente b ON b.idcliente = a.idcliente;";
            case ORDENPARAM:
                return "SELECT a.no_orden,a.idcliente AS Codigo_Cliente, b.nombre, a.comentario, fecha "
            + "FROM public.orden a INNER JOIN public.cliente b ON b.idcliente = a.idcliente WHERE no_orden =?;";
            case DETALLES:
                return "SELECT a.no_orden, a.idproducto, a.cantidad, a.precio, a.costo, a.tax, b.fecha\n"
                + " FROM public.orden_detalle a INNER JOIN public.orden b ON b.no_orden = a.no_orden;";

            default:
                return null;
    }}
     
    
    
        public static DefaultTableModel modelFree(Decision d, String a) throws SQLException {
        String s = "%" + a + "%";
            DefaultTableModel modelo = new DefaultTableModel();
        try (Connection BaseDatos = DBUtil.getConnection(DBType.ITLA);
                PreparedStatement st = BaseDatos.prepareStatement(decide(d), ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);) {
            st.setString(1, s);
            st.setString(2, s);

            ResultSet rs = st.executeQuery();
            ResultSetMetaData col = rs.getMetaData();
            Object[] row = new Object[col.getColumnCount()];
            for (int i = 1; i <= col.getColumnCount(); i++) {
                modelo.addColumn(col.getColumnLabel(i));
            }
            while (rs.next()) {
                for (int i = 0, k = 1; i < row.length; i++) {
                    row[i] = rs.getObject(k);
                    k++;
                }
                modelo.addRow(row);
            }
            if (!rs.first()) {
                JOptionPane.showConfirmDialog(null, "Lo sentimos, los valores"
                        + "que busca no esta en la base de datos",
                        "Valor no encontrado", JOptionPane.WARNING_MESSAGE);
            }

        } catch (SQLException e) {
            throw e;

        }
        return modelo;
    }
 public static DefaultTableModel modelGenerator(Decision sql, int parameter) throws SQLException {
        DefaultTableModel modelo = new DefaultTableModel();
        try (Connection BaseDatos = DBUtil.getConnection(DBType.ITLA);
                PreparedStatement st = BaseDatos.prepareStatement(decide(sql), ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);) {
            st.setInt(1, parameter);
            ResultSet rs = st.executeQuery();
            ResultSetMetaData col = rs.getMetaData();
            for (int i = 1; i <= col.getColumnCount(); i++) {
                modelo.addColumn(col.getColumnLabel(i));
            }
            Object[] row = new Object[col.getColumnCount()];
            while (rs.next()) {
                for (int i = 0, k = 1; i < row.length; i++) {
                    row[i] = rs.getObject(k);
                    k++;
                }
                modelo.addRow(row);
            }
            if (!rs.first()) {
                JOptionPane.showConfirmDialog(null, "Lo sentimos, los valores"
                        + "que busca no esta en la base de datos",
                        "Valor no encontrado", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            throw e;
        }
        return modelo;
    }

    public static DefaultTableModel modelGenerator(Decision sql, String parameter) throws SQLException {
        String s = "%" + parameter + "%";
        DefaultTableModel modelo = new DefaultTableModel();
        try (Connection BaseDatos = DBUtil.getConnection(DBType.ITLA);
                PreparedStatement st = BaseDatos.prepareStatement(decide(sql), ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);) {
            st.setString(1, parameter);
            st.setString(2, parameter);
            ResultSet rs = st.executeQuery();
            ResultSetMetaData col = rs.getMetaData();
            Object[] row = new Object[col.getColumnCount()];
            for (int i = 1; i <= col.getColumnCount(); i++) {
                modelo.addColumn(col.getColumnLabel(i));
            }
            while (rs.next()) {
                for (int i = 0, k = 1; i < row.length; i++) {
                    row[i] = rs.getObject(k);
                    k++;
                }
                modelo.addRow(row);
            }
            if (!rs.first()) {
                JOptionPane.showConfirmDialog(null, "Lo sentimos, los valores"
                        + "que busca no esta en la base de datos",
                        "Valor no encontrado", JOptionPane.WARNING_MESSAGE);
            }

        } catch (SQLException e) {
            throw e;

        }
        return modelo;
    }


    /**
     * This methode creates tables based on the sql sent.
     *
     * @param sql This parameter takes in the SQL; Statement
     * @return this returns a DefaultTableModel with the columns and data
     * requested in the querry.
     * @throws SQLException It throws SQLException to be handled where the
     * DefaultTableModel is going to be used
     */

    public static DefaultTableModel modelAll(Decision sql) throws SQLException {
        DefaultTableModel modelo = new DefaultTableModel();
        try (Connection BaseDatos = DBUtil.getConnection(DBType.ITLA);
                Statement st = BaseDatos.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);) {
            ResultSet rs = st.executeQuery(decide(sql));
            ResultSetMetaData col = rs.getMetaData();
            for (int i = 1; i <= col.getColumnCount(); i++) {
                modelo.addColumn(col.getColumnLabel(i));
            }
            Object[] row = new Object[col.getColumnCount()];
            while (rs.next()) {
                for (int i = 0, k = 1; i < row.length; i++) {
                    row[i] = rs.getObject(k);
                    k++;
                }
                modelo.addRow(row);
            }
            if (!rs.first()) {
                JOptionPane.showConfirmDialog(null, "Lo sentimos, los valores"
                        + "que busca no esta en la base de datos",
                        "Valor no encontrado", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            throw e;

        }
        return modelo;
    }

}
