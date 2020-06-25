
package com.waldomilanes.invoicewebservice;

import com.waldomilanes.invoicepojos.OrdenDetalle;
import com.waldomilanes.invoiceservices.OrdenDetalleService;
import java.util.List;
import javax.swing.JOptionPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class OrdenDetalleController {
    @Autowired
    private OrdenDetalleService ordenDetalleService = new OrdenDetalleService();
         
        @RequestMapping("/ordenDetalle/usuario/{nombre}")
            public OrdenDetalle getOrdenDetalleByUser(@PathVariable String nombre){
		return ordenDetalleService.getOrdenDetalleByUser(nombre);
	}
     @RequestMapping("/ordenDetalle/orden/{numorden}")
            public OrdenDetalle getOrdenDetalleByOrden(@PathVariable String numorden){
		return ordenDetalleService.getOrdenDetalleByOrden(numorden);
	}
        @RequestMapping("/allordendetalles")
        public List<OrdenDetalle> getAllOrdenDetalles(){
             return ordenDetalleService.getAllOrdenDetalles();
         }
        

         @RequestMapping("/ordendetalle/{id}")
             public OrdenDetalle getOrdenDetalle(@PathVariable String id){
		return ordenDetalleService.getOrdenDetalle(id);
	}
	@RequestMapping(method=RequestMethod.POST, value ="/addordendetalle")
	public void addOrdenDetalle(@RequestBody OrdenDetalle ordenDetalle){
		ordenDetalleService.addOrdenDetalle(ordenDetalle);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value ="/updateordendetalle/{id}")
	public void updateOrdenDetalle(@RequestBody OrdenDetalle ordenDetalle, @PathVariable String id){
		ordenDetalleService.updateOrdenDetalle(id, ordenDetalle);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value ="/deleteordendetalle/{id}")
	public void deleteOrdenDetalle(@PathVariable String id){
		 ordenDetalleService.deleteOrdenDetalle(id);
	}
}
