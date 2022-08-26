package co.com.neoris.prueba.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.neoris.prueba.model.entity.Cliente;
import co.com.neoris.prueba.model.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Cliente> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Cliente> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	@Transactional
	public Cliente save(Cliente cliente) {
		return repository.save(cliente);
	}

	@Override
	@Transactional(readOnly = true)
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

}
