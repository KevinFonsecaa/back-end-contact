package br.com.projeto.hellocontatos.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.hellocontatos.entities.Contact;
import br.com.projeto.hellocontatos.repositories.ContactRepository;

@Service
public class ContactService {
    
    @Autowired
    private ContactRepository contactRepository;

    public Contact saveContact(Contact contact) {
        return contactRepository.save(contact);
    }

    public void deleteContact(String nome, String email) {
        if (nome != null) {
            contactRepository.deleteByNome(nome);
        } else if (email != null) {
            contactRepository.deleteByEmail(email);
        } else {
            throw new IllegalArgumentException("Parâmetros de deleção inválidos.");
        }
    }

    public List<Contact> findContactsByName(String nome) {
        return contactRepository.findByNome(nome);
    }
}
