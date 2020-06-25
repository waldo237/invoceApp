package com.waldomilanes.invoice.webservice;


import com.waldomilanes.invoice.jpacontrollers.Decision;
import com.waldomilanes.invoice.services.DefaultTableModelService;
import javax.swing.table.DefaultTableModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ModeloController {

    @Autowired
    private DefaultTableModelService modeloService = new DefaultTableModelService();
     
    RestTemplate template = new RestTemplate();

    @RequestMapping("/modelostring/{peticion}")
    public DefaultTableModel getDefaultTableModelAll(@PathVariable String peticion) {
        Decision sql = Decision.valueOf(peticion);
        return modeloService.getDefaultTableModelAll(sql);
    }
    @RequestMapping("/modeloint/{peticion}/{id}")
    public DefaultTableModel getDefaultTableModelInt(@PathVariable String peticion, @PathVariable int id) {
        Decision sql = Decision.valueOf(peticion);
        return modeloService.getDefaultTableModelInt(sql, id);
    }
    @RequestMapping("/modelofree/{peticion}/{nombre}")
    public DefaultTableModel getDefaultTableModelFree(@PathVariable String peticion, @PathVariable String nombre) {
        Decision sql = Decision.valueOf(peticion);
        return modeloService.getDefaultTableModelFree(sql, nombre);
    }



}
