package com.hp.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Bundle {

	/**
	 * Possible to add Primary Product in a separate element
	 */
	// private Product primaryProduct;
	
	private List<Product> bundleProducts;
	private boolean isValid;
	private BigDecimal totalPrice;
	private BigDecimal discountPercentage;
	private BigDecimal discountedPrice;

	public List<Product> getBundleProducts() {
		if (Objects.isNull(bundleProducts)) {
			bundleProducts = new ArrayList<>();
		}
		return bundleProducts;
	}

}
