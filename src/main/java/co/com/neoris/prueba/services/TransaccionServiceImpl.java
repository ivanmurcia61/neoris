package co.com.neoris.prueba.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.neoris.prueba.model.entity.Transaccion;
import co.com.neoris.prueba.model.repository.TransaccionRepository;

@Service
public class TransaccionServiceImpl implements TransaccionService {

	@Autowired
	private TransaccionRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Transaccion> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Transaccion> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	@Transactional
	public Transaccion save(Transaccion transaccion) {
		return repository.save(transaccion);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

}
