package org.example.module.order;


import org.example.module.customer.CustomerEntity;
import org.example.module.equipment.EquipmentEntity;
import org.example.module.service.ServiceEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "OrdemServico")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "clienteId")
    private CustomerEntity cliente;

    @ManyToOne
    @JoinColumn(name = "equipamentoId")
    private EquipmentEntity equipamento;

    @Column(name = "aprovada")
    private boolean aprovada;

    @Column(name = "concluida")
    private boolean concluida;

    @ManyToMany
    private List<ServiceEntity> servicos;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CustomerEntity getCliente() {
        return cliente;
    }

    public void setCliente(CustomerEntity cliente) {
        this.cliente = cliente;
    }

    public EquipmentEntity getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(EquipmentEntity equipamento) {
        this.equipamento = equipamento;
    }

    public boolean isAprovada() {
        return aprovada;
    }

    public void setAprovada(boolean aprovada) {
        this.aprovada = aprovada;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    public List<ServiceEntity> getServicos() {
        return servicos;
    }

    public void setServicos(List<ServiceEntity> servicos) {
        this.servicos = servicos;
    }

    public boolean isValido() {
        if (this.getCliente() == null || this.getEquipamento() == null) {
            return false;
        }
        if (!this.getCliente().isValido()) {
            return false;
        }
        if (!this.getEquipamento().isValido()) {
            return false;
        }
        if (this.getServicos() != null) {
            for (ServiceEntity service : this.getServicos()) {
                if (service != null && !service.isValido()) {
                    return false;
                }
            }
        }
        return true;
    }
}
