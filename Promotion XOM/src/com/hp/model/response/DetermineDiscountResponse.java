package com.hp.model.response;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.hp.model.Bundle;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DetermineDiscountResponse {

	Bundle bestOffer;
	List<Bundle> bundledProducts;

	public List<Bundle> getBundledProducts() {
		if (Objects.isNull(bundledProducts)) {
			bundledProducts = new ArrayList<>();
		}
		return bundledProducts;
	}
}
