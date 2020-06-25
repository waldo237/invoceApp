
package com.waldomilanes.invoice.webservice;

import com.waldomilanes.invoice.pojos.Productos;
import com.waldomilanes.invoice.services.ProductosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProductosController {
    @Autowired
    private ProductosService productosService = new ProductosService();
         @RequestMapping("productos/nombre/{nombre}")
             public Productos getProductosByName(@PathVariable String nombre){
		return productosService.getProductosByName(nombre);
	}
         @RequestMapping("productos/descripcion/{des}")
             public Productos getProductosByDescription(@PathVariable String des){
		return productosService.getProductosByDescription(des);
	}
    
        @RequestMapping("/allproductos")
        public List<Productos> getAllProductos(){
             return productosService.getAllProductoss();
         }

         @RequestMapping("/producto/{id}")
             public Productos getProducto(@PathVariable String id){
		return productosService.getProductos(id);
	}
	@RequestMapping(method=RequestMethod.POST, value ="/addproducto")
	public void addProductos(@RequestBody Productos productos) throws Exception{
		productosService.addProductos(productos);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value ="/updateproducto/{id}")
	public void updateProductos(@RequestBody Productos productos, @PathVariable String id){
		productosService.updateProductos(id, productos);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value ="/deleteproducto/{id}")
	public void deleteProductos(@RequestBody Productos productos, @PathVariable String id){
		 productosService.deleteProductos(id);
	}
}
