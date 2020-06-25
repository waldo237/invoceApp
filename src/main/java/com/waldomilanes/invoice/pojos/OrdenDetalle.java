/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.waldomilanes.invoice.pojos;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MESCyT
 */
@Entity
@Table(name = "orden_detalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenDetalle.findAll", query = "SELECT o FROM OrdenDetalle o")
    , @NamedQuery(name = "OrdenDetalle.findByNoOrden", query = "SELECT o FROM OrdenDetalle o WHERE o.noOrden = :noOrden")
    , @NamedQuery(name = "OrdenDetalle.findByIdproducto", query = "SELECT o FROM OrdenDetalle o WHERE o.idproducto = :idproducto")
    , @NamedQuery(name = "OrdenDetalle.findByCantidad", query = "SELECT o FROM OrdenDetalle o WHERE o.cantidad = :cantidad")
    , @NamedQuery(name = "OrdenDetalle.findByPrecio", query = "SELECT o FROM OrdenDetalle o WHERE o.precio = :precio")
    , @NamedQuery(name = "OrdenDetalle.findByCosto", query = "SELECT o FROM OrdenDetalle o WHERE o.costo = :costo")
    , @NamedQuery(name = "OrdenDetalle.findByTax", query = "SELECT o FROM OrdenDetalle o WHERE o.tax = :tax")})
public class OrdenDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "no_orden")
    private Integer noOrden;
    @Basic(optional = false)
    @Column(name = "idproducto")
    private String idproducto;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private int cantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "precio")
    private BigDecimal precio;
    @Basic(optional = false)
    @Column(name = "costo")
    private BigDecimal costo;
    @Basic(optional = false)
    @Column(name = "tax")
    private BigDecimal tax;

    public OrdenDetalle() {
    }

    public OrdenDetalle(Integer noOrden) {
        this.noOrden = noOrden;
    }

    public OrdenDetalle(Integer noOrden, String idproducto, int cantidad, BigDecimal precio, BigDecimal costo, BigDecimal tax) {
        this.noOrden = noOrden;
        this.idproducto = idproducto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.costo = costo;
        this.tax = tax;
    }

    public Integer getNoOrden() {
        return noOrden;
    }

    public void setNoOrden(Integer noOrden) {
        this.noOrden = noOrden;
    }

    public String getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(String idproducto) {
        this.idproducto = idproducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (noOrden != null ? noOrden.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenDetalle)) {
            return false;
        }
        OrdenDetalle other = (OrdenDetalle) object;
        if ((this.noOrden == null && other.noOrden != null) || (this.noOrden != null && !this.noOrden.equals(other.noOrden))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.proyectoproductos.OrdenDetalle[ noOrden=" + noOrden + " ]";
    }
    
}
