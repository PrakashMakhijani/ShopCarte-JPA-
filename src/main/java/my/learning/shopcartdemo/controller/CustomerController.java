package my.learning.shopcartdemo.controller;

import my.learning.shopcartdemo.entities.Customer;
import my.learning.shopcartdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping("/customer")
    public List<Customer> getAllCustomer(){
        return service.findAll();
    }

    @GetMapping("/student/{id}")
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    public Customer getCustomerbyID(@PathVariable("id") Integer id){
        return service.getCustomer(id);

    }
    @PostMapping("/customer")
    public void createCustomer(@RequestBody Customer customer){
        service.createCustomer(customer);
    }

    @DeleteMapping("/customerID/{id}")
    public void deleteCustomerwithID(@PathVariable("id")Integer id){
        service.deleteCustomerByid(id);
    }

    @PutMapping("/{id}")
    public void updateCustomerName(@PathVariable("id") Integer id,
                                   @RequestParam(required = false) String name){

        service.updateCustomerbyID(id,name);

    }


}
