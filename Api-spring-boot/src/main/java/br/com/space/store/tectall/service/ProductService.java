package br.com.space.store.tectall.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.space.store.tectall.form.ProductForm;
import br.com.space.store.tectall.model.ProductModel;
import br.com.space.store.tectall.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public ProductModel save(ProductForm productForm) {
		
		ProductModel product = ProductForm.toProduct(productForm);
		
		return productRepository.save(product) ;
	}

	public List<ProductModel> getAll() {
		
		return productRepository.findAll();
	}

	public ResponseEntity<Object> delete(UUID uuid) {
		
		Optional<ProductModel> productOptional = productRepository.findById(uuid);
		
		if(productOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
		}
		
		productRepository.delete(productOptional.get());
		
		return ResponseEntity.status(HttpStatus.OK).body("Product deleted");
	}

	public ResponseEntity<Object> update(UUID uuid, ProductForm productForm) {
		
		Optional<ProductModel> productOptional = productRepository.findById(uuid);
		
		if(productOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
		}
		
		ProductModel product = productOptional.get();
		
		product.setName(productForm.getName());
		product.setDescription(productForm.getDescription());
		BigDecimal price = new BigDecimal(productForm.getPrice());
		product.setPrice(price);
		
		ProductModel updatedProduct = productRepository.save(product);
		
		return ResponseEntity.status(HttpStatus.OK).body(updatedProduct);
	}
	
	

}
