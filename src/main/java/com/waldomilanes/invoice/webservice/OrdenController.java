package com.waldomilanes.invoicewebservice;

import com.waldomilanes.invoicepojos.Orden;
import com.waldomilanes.invoiceservices.OrdenService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrdenController {

    @Autowired
    private OrdenService ordenService = new OrdenService();

    @RequestMapping("/lastorder/{nombre}")
    public Orden getLastOrden(@PathVariable String nombre) {
        return ordenService.getLastOrden(nombre);
    }
    
    @RequestMapping("/orden/usuario/{nombre}")
    public Orden getOrdenByUser(@PathVariable String nombre) {
        return ordenService.getOrdenByUser(nombre);
    }

    @RequestMapping("/orden/producto/{producto}")
    public Orden getOrdenByProducto(@PathVariable String producto) {
        return ordenService.getOrdenByProducto(producto);
    }

    @RequestMapping("/allordens")
    public List<Orden> getAllOrdens() {
        return ordenService.getAllOrdens();
    }

    @RequestMapping("/orden/{id}")
    public Orden getOrden(@PathVariable String id) {
        return ordenService.getOrden(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addorden")
    public void addOrden(@RequestBody Orden orden) {
        ordenService.addOrden(orden);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/updateorden/{id}")
    public void updateOrden(@RequestBody Orden orden, @PathVariable String id) {
        ordenService.updateOrden(id, orden);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteorden/{id}")
    public void deleteOrden(@PathVariable String id) {
        ordenService.deleteOrden(id);
    }
}
