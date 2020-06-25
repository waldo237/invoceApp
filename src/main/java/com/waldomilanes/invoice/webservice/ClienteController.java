package com.waldomilanes.invoicewebservice;

import com.waldomilanes.invoicepojos.Cliente;
import com.waldomilanes.invoiceservices.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {

    @Autowired
    private ClienteService clienteService = new ClienteService();

    @RequestMapping("/cliente/nombre/{nombre}")
    public Cliente getClienteByName(@PathVariable String nombre) {
        return clienteService.getClienteByName(nombre);
    }

    @RequestMapping("/allclientes")
    public List<Cliente> getAllClientes() {
        return clienteService.getAllClientes();
    }

    @RequestMapping("/cliente/{id}")
    public Cliente getCliente(@PathVariable String id) {
        return clienteService.getCliente(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addcliente")
    public void addCliente(@RequestBody Cliente cliente) {
        clienteService.addCliente(cliente);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/updatecliente/{id}")
    public void updateCliente(@RequestBody Cliente cliente, @PathVariable String id) {
        clienteService.updateCliente(id, cliente);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deletecliente/{id}")
    public void deleteCliente( @PathVariable String id) {
        clienteService.deleteCliente(id);
    }
}
