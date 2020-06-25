package com.waldomilanes.invoice.utilities;

import com.waldomilanes.invoice.jpacontrollers.Decision;
import com.waldomilanes.invoice.pojos.Cliente;
import com.waldomilanes.invoice.pojos.Orden;
import com.waldomilanes.invoice.pojos.OrdenDetalle;
import com.waldomilanes.invoice.pojos.Productos;
import com.waldomilanes.invoice.restcontrollers.ClienteRESTController;
import com.waldomilanes.invoice.restcontrollers.ModeloRESTController;
import com.waldomilanes.invoice.restcontrollers.OrdenDetalleRESTController;
import com.waldomilanes.invoice.restcontrollers.OrdenRESTController;
import com.waldomilanes.invoice.restcontrollers.ProductosRESTController;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author waldo-ana
 */
public class GeneralMethods {

    private static ProductosRESTController productosRest = new ProductosRESTController();
    private static ClienteRESTController clienteRest = new ClienteRESTController();
    private static OrdenDetalleRESTController ordenDetalleRest = new OrdenDetalleRESTController();
    private static OrdenRESTController ordenRest = new OrdenRESTController();
    private static ModeloRESTController modeloRest = new ModeloRESTController();

    public static DefaultTableModel modelFree(Decision sql, String s) {
        return modeloRest.getDefaultTableModelFree(sql, s);
    }


    public static DefaultTableModel modelAll(Decision SQL) {
        return modeloRest.getDefaultTableModelAll(SQL);
    }

    public static DefaultTableModel modelGenerator(Decision SQL, String id) {
        return modeloRest.getDefaultTableModelInt(SQL, id);
    }

   
    public static class productos {

        public static Productos productGenerator(String parameter) {
            return productosRest.getProducto(parameter);
        }

        public static void ProductInsert(Productos producto) {
            productosRest.addProducto(producto);

        }

        public static void ProductUpdate(Productos producto) {
            productosRest.updateProducto(producto);
        }

    

        public static void updateFecha(String idProducto)  {
            Productos p = productosRest.getProducto(idProducto);
            p.setUltimaFechaVenta(new Date());
           productosRest.updateProducto(p);
        }

        public static void ProductoDelete(String Id) throws Exception {
                productosRest.deleteProducto(String.valueOf(Id));
        }

        public static void reimburnse(String productid, int i) {
           Productos p = productosRest.getProducto(productid);
            p.setCantidad(i);
            productosRest.updateProducto(p);
        }
    }

    public static class Clientes {

        public static Cliente clienteGenerator(int parameter) {
            Cliente cliente = clienteRest.getCliente(String.valueOf(parameter));
            return cliente;
        }

        public static void Clienteinsert(Cliente cliente) {
            clienteRest.addCliente(cliente);
        }

        public static void ClienteUpdate(Cliente cliente) {
            clienteRest.updateCliente(cliente);
        }

        public static void ClienteDelete(int id) {
            clienteRest.deleteCliente(String.valueOf(id));
        }
    }

    public static class Ordenes {

        public static void OrdenInsert(Orden orden) {
            ordenRest.addOrden(orden);
        }

        public static void OrdenUpdate(Orden orden) {
            ordenRest.updateOrden(orden);
        }

        public static void OrdenDelete(int id) {
            ordenRest.deleteOrden(String.valueOf(id));
        }
    }

    public static class OrdenDetalles {

        public static OrdenDetalle ordenDetalleGenerator(int parameter) {
            OrdenDetalle detalle = ordenDetalleRest.getOrdenDetalle(String.valueOf(parameter));
            return detalle;
        }

        public static void OrdenDetalleInsert(OrdenDetalle detalle) {
            ordenDetalleRest.addOrdenDetalle(detalle);
        }

        public static void OrdenDetalleUpdate(OrdenDetalle detalle) {
            ordenDetalleRest.updateOrdenDetalle(detalle);
        }
        public static void DetalleDelete(int detalle) {
            ordenDetalleRest.deleteOrdenDetalle(String.valueOf(detalle));
        }
    }

    public static String comilla(String nombre) {
        String c = "'";
        c += nombre;
        c += "'";
        return c;
    }

}
