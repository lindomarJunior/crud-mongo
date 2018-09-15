package com.crudmongo.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudmongo.api.dao.ClienteDao;
import com.crudmongo.api.documents.Cliente;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	ClienteDao clienteDao;
	
	@GetMapping
	public List<Cliente> listarCliente(){
		return clienteDao.listarTodos();
	}
	
	@PostMapping("/filtro")
	public List<Cliente> listarComFiltro(@RequestBody Cliente cliente){
		return clienteDao.listarComFiltro(cliente);
	}
	
	@GetMapping("/{id}")
	public Cliente consultar(@PathVariable String id) {
		return clienteDao.consultarPorId(id);
	}
	
	@PostMapping
	public ResponseEntity cadastrar(@Valid @RequestBody Cliente cliente) {
		clienteDao.criarAtualizar(cliente);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity atualizar(@RequestBody Cliente cliente) {
		clienteDao.criarAtualizar(cliente);
		return new ResponseEntity(HttpStatus.OK);
	}
}
