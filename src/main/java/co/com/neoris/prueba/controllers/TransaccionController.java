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

import co.com.neoris.prueba.model.entity.CuentaBancaria;
import co.com.neoris.prueba.model.entity.Transaccion;
import co.com.neoris.prueba.services.CuentaBancariaService;
import co.com.neoris.prueba.services.TransaccionService;

@RestController
@RequestMapping("/transaccionService")
public class TransaccionController {
	
	@Autowired
	private TransaccionService service;
	
	@Autowired
	private CuentaBancariaService serviceCuentaBancaria;
	
	@GetMapping
	public ResponseEntity<?> listar(){
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> ver(@PathVariable Long id){
		
		Optional<Transaccion> optional = service.findById(id);
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(optional.get());
	}
	
	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Transaccion transaccion){
		Transaccion transaccionBd = service.save(transaccion);
		return ResponseEntity.status(HttpStatus.CREATED).body(transaccionBd);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Transaccion transaccion, @PathVariable Long id){
		Optional<Transaccion> optional = service.findById(id);
		
		CuentaBancaria cuentaBancariaBd;
		
		if(!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}else {
			Optional<CuentaBancaria> optionalAccountBank = serviceCuentaBancaria.findById(optional.get().getCuentaBancaria().getIdCuentaBancaria());
			if(!optionalAccountBank.isPresent()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			} else {
				cuentaBancariaBd = optionalAccountBank.get();
			}
		}
		
		Transaccion transaccionBd = optional.get();
		
		transaccionBd.setAccountNumber(transaccion.getAccountNumber());
		transaccionBd.setAmountTransaction(transaccion.getAmountTransaction());
		transaccionBd.setCuentasBancarias(cuentaBancariaBd);
				
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(transaccionBd));
		
	}
	
		
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id){
		service.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}

}
