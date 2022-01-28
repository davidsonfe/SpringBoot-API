package org.example.module.customer;


import org.example.module.contact.ContactEntity;

import javax.persistence.*;

@Entity
@Table(name = "Cliente")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf")
    private String cpf;

    @ManyToOne
    @JoinColumn(name = "contatoId")
    private ContactEntity contato;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public ContactEntity getContato() {
        return contato;
    }

    public void setContato(ContactEntity contato) {
        this.contato = contato;
    }

    public boolean isValido() {
        return false;
    }
}
