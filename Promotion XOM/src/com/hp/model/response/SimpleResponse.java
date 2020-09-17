package com.hp.model.response;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.hp.model.Bundle;
import com.hp.model.Product;

import lombok.Data;

@Data
public class SimpleResponse {

	private List<Bundle> productBundle;
	private List<Product> leftoverProducts;

	public List<Bundle> getProductBundle() {
		if (Objects.isNull(productBundle)) {
			productBundle = new ArrayList<>();
		}
		return productBundle;
	}

	public List<Product> getLeftoverProducts() {
		if (Objects.isNull(leftoverProducts)) {
			productBundle = new ArrayList<>();
		}
		return leftoverProducts;
	}

}
