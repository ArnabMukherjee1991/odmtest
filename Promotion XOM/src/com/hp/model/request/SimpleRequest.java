package com.hp.model.request;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.hp.model.Product;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SimpleRequest {

	private List<Product> selectedProducts;
	private boolean isValid;

	public List<Product> getSelectedProducts() {
		if (Objects.isNull(selectedProducts)) {
			selectedProducts = new ArrayList<>();
		}
		return selectedProducts;
	}

}
