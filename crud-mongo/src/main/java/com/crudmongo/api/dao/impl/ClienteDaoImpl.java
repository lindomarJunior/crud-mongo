package com.crudmongo.api.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import com.crudmongo.api.dao.ClienteDao;
import com.crudmongo.api.documents.Cliente;
import com.crudmongo.api.repositories.ClienteRepository;

@Component
public class ClienteDaoImpl  implements ClienteDao  {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Override
	public List<Cliente> listarTodos() {
		return clienteRepository.findAll();
	}

	@Override
	public Cliente consultarPorId(String id) {
		return clienteRepository.findById(id).orElse(null);
	}

	@Override
	public void criarAtualizar(Cliente cliente) {
		clienteRepository.save(cliente);
		
	}

	@Override
	public void remover(String id) {
		clienteRepository.deleteById(id);;		
	}

	@Override
	public List<Cliente> listarComFiltro(Cliente cliente) {
		return clienteRepository.findAll(Example.of(cliente));
	}

}
