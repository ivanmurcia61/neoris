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
import co.com.neoris.prueba.model.entity.CuentaBancaria;
import co.com.neoris.prueba.services.ClienteService;
import co.com.neoris.prueba.services.CuentaBancariaService;

@RestController
@RequestMapping("/cuentaService")
public class CuentaController {

	@Autowired
	private CuentaBancariaService service;
	
	@Autowired
	private ClienteService serviceCliente;
	
	@GetMapping
	public ResponseEntity<?> listar(){
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> ver(@PathVariable Long id){
		
		Optional<CuentaBancaria> optional = service.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(optional.get());
	}
	
	@PostMapping
	public ResponseEntity<?> crear(@RequestBody CuentaBancaria cuentaBancaria){
		CuentaBancaria cuentaBancariaBd = service.save(cuentaBancaria);
		return ResponseEntity.status(HttpStatus.CREATED).body(cuentaBancariaBd);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody CuentaBancaria cuentaBancaria, @PathVariable Long id){
		Optional<CuentaBancaria> optional = service.findById(id);
		
		Cliente clienteBd;
		
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}else {
			Optional<Cliente> optionalCliente = serviceCliente.findById(optional.get().getCliente().getIdCliente());
			if(!optionalCliente.isPresent()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			} else {
				clienteBd = optionalCliente.get();
			}
		}
		
		CuentaBancaria cuentaBancariaBd = optional.get();
		
		cuentaBancariaBd.setAccountNumber(cuentaBancaria.getAccountNumber());
		cuentaBancariaBd.setCurrency(cuentaBancaria.getCurrency());
		cuentaBancariaBd.setCliente(clienteBd);				
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cuentaBancariaBd));
		
	}
	
		
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id){
		service.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
}
