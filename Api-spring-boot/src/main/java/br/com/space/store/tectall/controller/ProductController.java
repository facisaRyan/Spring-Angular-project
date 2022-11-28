package br.com.space.store.tectall.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.space.store.tectall.form.ProductForm;
import br.com.space.store.tectall.model.ProductModel;
import br.com.space.store.tectall.service.ProductService;

@RestController
@RequestMapping("products")
public class ProductController {
	
	
	@Autowired
	private ProductService productService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping
	public ResponseEntity<ProductModel> saveProduct(@RequestBody @Valid ProductForm productForm){
		return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(productForm));
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping
	public ResponseEntity<List<ProductModel>> getAllProducts(){
		return ResponseEntity.status(HttpStatus.OK).body(productService.getAll());
	}
	
	@DeleteMapping("/{uuid}")
	public ResponseEntity<Object> deleteProduct(@PathVariable UUID uuid){
		return productService.delete(uuid);
	}
	
	@PutMapping("/{uuid}")
	public ResponseEntity<Object> updateProduct(@PathVariable UUID uuid, @Valid @RequestBody ProductForm productForm){
		return productService.update(uuid, productForm);
	}
}
