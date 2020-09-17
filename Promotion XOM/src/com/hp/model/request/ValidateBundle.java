package com.hp.model.request;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.hp.model.Bundle;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PROTECTED)
@Data
public class ValidateBundle {
	String transactionId;
	List<Bundle> productBundles;
	
	public List<Bundle> getProductBundles(){
		if(Objects.isNull(productBundles)) {
			productBundles = new ArrayList<>();
		}
		return productBundles;
	}
	
}
