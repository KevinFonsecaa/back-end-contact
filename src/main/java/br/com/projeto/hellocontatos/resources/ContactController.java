package br.com.projeto.hellocontatos.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.projeto.hellocontatos.Services.ContactService;
import br.com.projeto.hellocontatos.entities.Contact;
import br.com.projeto.hellocontatos.repositories.ContactRepository;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/contacts")
@CrossOrigin(origins = "http://localhost:4200")
public class ContactController {

     @Autowired
    private ContactService contactService;

    @PostMapping
    public ResponseEntity<Contact> saveContact(@RequestBody Contact contact) {
        Contact savedContact = contactService.saveContact(contact);
        return new ResponseEntity<>(savedContact, HttpStatus.CREATED);
    }

    @DeleteMapping("/{nome}/{email}")
    public ResponseEntity<Void> deleteContact(
            @PathVariable(required = false) String nome,
            @PathVariable(required = false) String email) {
        
        contactService.deleteContact(nome, email);
        
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/api/contacts/{nome}")
    public ResponseEntity<List<Contact>> getContactsByName(@PathVariable String nome) {
        List<Contact> contacts = contactService.findContactsByName(nome);
        return ResponseEntity.ok(contacts);
    }

}