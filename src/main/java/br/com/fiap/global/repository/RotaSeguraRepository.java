package br.com.fiap.global.repository;

import br.com.fiap.global.model.RotaSegura;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RotaSeguraRepository extends MongoRepository<RotaSegura, String> {
}