package org.example.module.equipment;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("equipamento")
public class EquipmentController {

    private EquipmentService equipmentService;

    @Autowired
    public EquipmentController(EquipmentService equipmentService) {
        this.equipmentService = equipmentService;
    }

    @RequestMapping(
            method = RequestMethod.POST,
            value = "",
            consumes = "application/json",
            produces = "application/json"
    )
    public ResponseEntity criar(@RequestBody EquipmentEntity entity) {
        try {
            EquipmentEntity c = this.equipmentService.criar(entity);
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
    public ResponseEntity atualizar(@RequestBody EquipmentEntity entity) {
        try {
            EquipmentEntity c = this.equipmentService.atualizar(entity);
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

            List<EquipmentEntity> c = this.equipmentService.listar();
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

            this.equipmentService.excluir(id);
            return ResponseEntity.ok().build();
        }
        catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
