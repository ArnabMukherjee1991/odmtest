package com.hp.model;

import java.math.BigDecimal;

import ilog.rules.bom.annotations.NotBusiness;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PUBLIC, makeFinal = true)
@NotBusiness
public class ModelConstants {
	final static String PRODUCT_CODE_DOMAIN = "com.myshop.productservice.rules.domain.ProductCodeType";
	final static String PRODUCT_CAT_CODE_DOMAIN = "com.myshop.productservice.rules.domain.ProductCategoryCodeType";
	final static String PRODUCT_DESCRIPTION_DOMAIN = "com.myshop.productservice.rules.domain.ProductDescriptionType";
	final static BigDecimal ZERO = new BigDecimal("0.0") ;

}
