package co.com.neoris.prueba.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.neoris.prueba.model.entity.CuentaBancaria;
import co.com.neoris.prueba.model.repository.CuentaBancariaRepository;

@Service
public class CuentaBancariaServiceImpl implements CuentaBancariaService {

	@Autowired
	private CuentaBancariaRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<CuentaBancaria> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<CuentaBancaria> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	@Transactional
	public CuentaBancaria save(CuentaBancaria cuentaBancaria) {
		return repository.save(cuentaBancaria);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

}
