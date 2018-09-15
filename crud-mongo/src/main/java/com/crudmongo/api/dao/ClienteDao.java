package com.crudmongo.api.dao;

import java.util.List;

import com.crudmongo.api.documents.Cliente;

public interface ClienteDao {
	
	List<Cliente> listarTodos();
	
	List<Cliente> listarComFiltro(Cliente cliente);
	
	Cliente consultarPorId(String id);
	
	void criarAtualizar(Cliente cliente);
	
	void remover(String id);
}
