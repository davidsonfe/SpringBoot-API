package org.example.module.customer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerEntity criar(CustomerEntity entity) {
        return this.customerRepository.save(entity);
    }

    public CustomerEntity atualizar(CustomerEntity entity) {
        return this.customerRepository.save(entity);
    }

    public List<CustomerEntity> listar() {
        return this.customerRepository.findAll();
    }

    public void excluir(long id) {
        this.customerRepository.deleteById(id);
    }

}
