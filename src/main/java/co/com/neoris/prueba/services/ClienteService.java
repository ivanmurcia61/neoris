package co.com.neoris.prueba.services;

import java.util.Optional;

import co.com.neoris.prueba.model.entity.Cliente;

public interface ClienteService {

	public Iterable<Cliente> findAll();
	
	public Optional<Cliente> findById(Long id);
	
	public Cliente save(Cliente cliente);
	
	public void deleteById(Long id);
}
