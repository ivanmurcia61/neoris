package co.com.neoris.prueba.services;

import java.util.Optional;

import co.com.neoris.prueba.model.entity.CuentaBancaria;

public interface CuentaBancariaService {

	public Iterable<CuentaBancaria> findAll();
	
	public Optional<CuentaBancaria> findById(Long id);
	
	public CuentaBancaria save(CuentaBancaria cuentaBancaria);
	
	public void deleteById(Long id);
}
