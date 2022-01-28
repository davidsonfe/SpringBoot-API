package org.example.module.contact;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("contato")
public class ContactController {

    private ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {

        this.contactService = contactService;
    }

    @RequestMapping(
            method = RequestMethod.POST,
            value = "",
            consumes = "application/json",
            produces = "application/json"
    )
    public ResponseEntity criar(@RequestBody ContactEntity entity) {
        try {
            ContactEntity c = this.contactService.criar(entity);
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
    public ResponseEntity atualizar(@RequestBody ContactEntity entity) {
        try {
            ContactEntity c = this.contactService.atualizar(entity);
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

            List<ContactEntity> c = this.contactService.listar();
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

            this.contactService.excluir(id);
            return ResponseEntity.ok().build();
        }
        catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }


}
