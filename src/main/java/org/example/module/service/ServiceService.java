package org.example.module.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceService {

    private ServiceRepository serviceRepository;

    @Autowired
    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public ServiceEntity criar(ServiceEntity entity) {
        return this.serviceRepository.save(entity);
    }

    public ServiceEntity atualizar(ServiceEntity entity) {
        return  this.serviceRepository.save(entity);
    }

    public List<ServiceEntity> listar() {
        return this.serviceRepository.findAll();
    }

    public void excluir(long id) {
        this.serviceRepository.deleteById(id);
    }
}
