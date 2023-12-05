package br.com.projeto.hellocontatos.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import br.com.projeto.hellocontatos.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long>{
    

      
      void deleteByNome(String nome);
   
      void deleteByEmail(String email);

    List<Contact> findByNome(String nome);

}
