package br.com.space.store.tectall.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.space.store.tectall.model.ProductModel;

public interface ProductRepository extends JpaRepository<ProductModel, UUID> {

}
