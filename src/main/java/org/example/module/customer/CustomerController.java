package org.example.module.customer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cliente")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @RequestMapping(
            method = RequestMethod.POST,
            value = "",
            consumes = "application/json",
            produces = "application/json"
    )
    public ResponseEntity criar(@RequestBody CustomerEntity entity) {
        try {
            CustomerEntity c = this.customerService.criar(entity);
            return ResponseEntity.ok(c);
        }
        catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }


    @RequestMapping(
            method = RequestMethod.PUT,
            value = "",
            consumes = "application/json",
            produces = "application/json"
    )
    public ResponseEntity atualizar(@RequestBody CustomerEntity entity) {
        try {
            CustomerEntity c = this.customerService.atualizar(entity);
            return ResponseEntity.ok(c);
        }
        catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "",
            produces = "application/json"
    )
    public ResponseEntity listar() {
        try {

            List<CustomerEntity> c = this.customerService.listar();
            return ResponseEntity.ok(c);
        }
        catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "{id}",
            produces = "application/json"
    )
    public ResponseEntity excluir(@PathVariable long id) {
        try {

            this.customerService.excluir(id);
            return ResponseEntity.ok().build();
        }
        catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
