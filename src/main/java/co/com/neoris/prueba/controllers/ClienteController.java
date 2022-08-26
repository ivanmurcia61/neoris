package co.com.neoris.prueba.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.neoris.prueba.model.entity.Cliente;
import co.com.neoris.prueba.services.ClienteService;

@RestController
@RequestMapping("/clientService")
public class ClienteController {

	@Autowired
	private ClienteService service;
	
	@GetMapping
	public ResponseEntity<?> listar(){
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> ver(@PathVariable Long id){
		
		Optional<Cliente> optional = service.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(optional.get());
	}
	
	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Cliente cliente){
		Cliente clienteBd = service.save(cliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteBd);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Cliente cliente, @PathVariable Long id){
		Optional<Cliente> optional = service.findById(id);
		
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		Cliente clienteDb = optional.get();
		
		clienteDb.setCedula(cliente.getCedula());
		clienteDb.setEmail(cliente.getEmail());
		clienteDb.setNames(cliente.getNames());
		clienteDb.setLastnames(cliente.getLastnames());
		clienteDb.setPhoneContact(cliente.getPhoneContact());
		clienteDb.setTypeDocument(cliente.getTypeDocument());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(clienteDb));
		
	}
	
		
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id){
		service.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
}
