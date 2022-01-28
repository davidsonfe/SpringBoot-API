package org.example.module.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public OrderEntity criar(OrderEntity entity) {
        return this.orderRepository.save(entity);
    }

    public OrderEntity atualizar(OrderEntity entity) {
        return this.orderRepository.save(entity);
    }


    public List<OrderEntity> listar() {
        return this.orderRepository.findAll();
    }

    public void excluir(long id) {
        this.orderRepository.deleteById(id);
    }


}
