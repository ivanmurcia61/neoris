package co.com.neoris.prueba.model.repository;

import org.springframework.data.repository.CrudRepository;

import co.com.neoris.prueba.model.entity.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}
