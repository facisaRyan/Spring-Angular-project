package br.com.space.store.tectall.model;

import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.space.store.tectall.form.ProductForm;

@Entity
@Table(name="TB_products")
public class ProductModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID productId;
	private String name;
	private String description;
	private BigDecimal price;
	// Category
	// Cupons
	// EspecificDescription
	
	public ProductModel () {}
	
	public ProductModel(ProductForm productForm) {
		this.name = productForm.getName();
		this.description = productForm.getDescription();
		this.price = new BigDecimal(productForm.getPrice());
	}
	
	public UUID getProductId() {
		return productId;
	}
	public void setProductId(UUID productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	
}
