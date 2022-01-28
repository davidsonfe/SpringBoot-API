package org.example.module.order;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ordemservico")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(
            method = RequestMethod.POST,
            value = "",
            consumes = "application/json",
            produces = "application/json"
    )
    public ResponseEntity criar(@RequestBody OrderEntity entity) {
        try {
            OrderEntity c = this.orderService.criar(entity);
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
    public ResponseEntity atualizar(@RequestBody OrderEntity entity) {
        try {
            OrderEntity o = this.orderService.atualizar(entity);
            return ResponseEntity.ok(o);
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

            List<OrderEntity> o = this.orderService.listar();
            return ResponseEntity.ok(o);
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

            this.orderService.excluir(id);
            return ResponseEntity.ok().build();
        }
        catch (Exception ex) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
