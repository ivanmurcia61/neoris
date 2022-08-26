package co.com.neoris.prueba.services;

import java.util.Optional;

import co.com.neoris.prueba.model.entity.Transaccion;


public interface TransaccionService {

	public Iterable<Transaccion> findAll();
	
	public Optional<Transaccion> findById(Long id);
	
	public Transaccion save(Transaccion transaccion);
	
	public void deleteById(Long id);
}
