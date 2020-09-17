package com.hp.model;

import static com.hp.model.ModelConstants.PRODUCT_CAT_CODE_DOMAIN;
import static com.hp.model.ModelConstants.PRODUCT_CODE_DOMAIN;
import static com.hp.model.ModelConstants.PRODUCT_DESCRIPTION_DOMAIN;
import java.math.BigDecimal;

import ilog.rules.bom.annotations.BusinessType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Product {
	@Getter(onMethod_ = { @BusinessType(PRODUCT_CODE_DOMAIN) })
	private String code;
	@Getter(onMethod_ = { @BusinessType(PRODUCT_CAT_CODE_DOMAIN) })
	private String category;
	private BigDecimal price;
	@Getter(onMethod_ = { @BusinessType(PRODUCT_DESCRIPTION_DOMAIN) })
	private String description;

}
