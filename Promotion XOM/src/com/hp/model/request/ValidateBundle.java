package com.hp.model.request;

import java.util.List;

import com.hp.model.Bundle;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PROTECTED)
public class ValidateBundle {
	String transactionId;
	List<Bundle> productBundles;
	
	
}
