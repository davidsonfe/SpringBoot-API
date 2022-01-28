package org.example.module.contact;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    private ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }


    public ContactEntity criar(ContactEntity entity) {
        return this.contactRepository.save(entity);
    }

    public ContactEntity atualizar(ContactEntity entity) {
        return this.contactRepository.save(entity);
    }


    public List<ContactEntity> listar() {
        return this.contactRepository.findAll();
    }

    public void excluir(long id) {
        this.contactRepository.deleteById(id);
    }

}
