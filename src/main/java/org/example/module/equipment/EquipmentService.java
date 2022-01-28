package org.example.module.equipment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentService {

    private EquipmentRepository equipmentRepository;

    @Autowired
    public EquipmentService(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    public EquipmentEntity criar(EquipmentEntity entity) {
        return this.equipmentRepository.save(entity);
    }

    public EquipmentEntity atualizar(EquipmentEntity entity) {
        return  this.equipmentRepository.save(entity);
    }

    public List<EquipmentEntity> listar() {
        return this.equipmentRepository.findAll();
    }

    public void excluir(long id) {
        this.equipmentRepository.deleteById(id);
    }
}
