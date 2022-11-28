package br.com.space.store.tectall.form;

import br.com.space.store.tectall.model.ProductModel;

public class ProductForm {

	private String name;
	private String description;
	private String price;

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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public static ProductModel toProduct(ProductForm productForm) {

		return new ProductModel(productForm);
	}

}
