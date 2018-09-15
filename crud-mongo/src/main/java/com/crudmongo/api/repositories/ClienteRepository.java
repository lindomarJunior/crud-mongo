package com.crudmongo.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.crudmongo.api.documents.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, String> {

}
