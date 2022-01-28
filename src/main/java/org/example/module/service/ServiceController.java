package org.example.module.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("servico")
public class ServiceController {

    private ServiceService serviceService;


    @Autowired
    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @RequestMapping(
            method = RequestMethod.POST,
            value = "",
            consumes = "application/json",
            produces = "application/json"
    )
    public ResponseEntity criar(@RequestBody ServiceEntity entity) {
        try {
            ServiceEntity c = this.serviceService.criar(entity);
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
    public ResponseEntity atualizar(@RequestBody ServiceEntity entity) {
        try {
            ServiceEntity c = this.serviceService.atualizar(entity);
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

            List<ServiceEntity> c = this.serviceService.listar();
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

            this.serviceService.excluir(id);
            return ResponseEntity.ok().build();
        }
        catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
