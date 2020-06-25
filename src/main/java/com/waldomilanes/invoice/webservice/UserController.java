package com.waldomilanes.invoicewebservice;

import com.waldomilanes.invoicepojos.User;
import com.waldomilanes.invoiceservices.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {

    @Autowired
    private UserService userService = new UserService();
     
    RestTemplate template = new RestTemplate();
    @RequestMapping("/")
    public String prueba() {
        return "<h1>Este URI es la pagina de entrada de la aplicacion de facturas deseñada como proyecto en el ITLA<h1/>";
    }

    @RequestMapping("/findbyname/{nombre}")
    public User getUserByName(@PathVariable String nombre) {
        return userService.getUserByName(nombre);
    }

    @RequestMapping("/allusers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping("/user/{id}")
    public User getUser(@PathVariable int id) {
        return userService.getUser(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/adduser")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }
    
   @RequestMapping(value = "/updateuser/{id}", method = RequestMethod.PUT)
   public ResponseEntity<String> updateUser(@PathVariable("id") String id, @RequestBody User user) {

      userService.updateUser(user);
      return new ResponseEntity(HttpStatus.OK);
   }
    @RequestMapping(value = "/deleteuser/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> updateUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
