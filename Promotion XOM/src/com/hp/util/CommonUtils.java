package com.hp.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.hp.model.Bundle;
import com.hp.model.Product;
import com.hp.model.response.SimpleResponse;

import ilog.rules.bom.annotations.NotBusiness;

public class CommonUtils {

	// If a Bundle is already present then add to that if the Product is not already
	// added,otherwise create a new bundle and add there
	// Only one Primary product to a bundle
	public static void createBundleForPrimaryProduct(Product aProduct, SimpleResponse response) {

	}

	public static void addProductToAList(Product product, List<Product> productList) {
		if (Objects.isNull(productList)) {
			return;
		}
		productList.add(product);
	}

	// public static void addCompatibleProductToBundle(Product product, Bundle
	// bundle) {
	// if (productExistsInList(product, bundle.getCompaitbleProducts())) {
	// return;
	// }
	// bundle.getCompaitbleProducts().add(product);
	// }

	public static void removeProductFromList(Product product, List<Product> productList) {
		productList = productList.stream().filter(aprod -> !product.getCode().equalsIgnoreCase(aprod.getCode()))
				.collect(Collectors.toList());
	}

	public static boolean productExistsInList(Product product, List<Product> productList) {

		if (Objects.isNull(productList) || productList.isEmpty()) {
			return false;
		}
		return productList.stream().anyMatch(aprod -> product.getCode().equalsIgnoreCase(aprod.getCode()));
	}

	public static Bundle findBestOffer(List<Bundle> bundleList) {

		if (Objects.isNull(bundleList)) {
			return null;
		}
		Collections.sort(bundleList, (b1, b2) ->

		b1.getTotalPrice().subtract(b1.getDiscountedPrice())
				.compareTo(b2.getTotalPrice().subtract(b2.getDiscountedPrice())));
		return bundleList.get(bundleList.size() - 1);

	}

	public static void createBundleUsingPrimaryProduct(Product product, List<Bundle> bundleList) {

		if (!bundleList.stream().filter(b -> productExistsInList(product, b.getBundleProducts()))
				.collect(Collectors.toList()).isEmpty()) {
			Bundle newBundle = new Bundle();
			newBundle.getBundleProducts().add(product);
			bundleList.add(newBundle);
		}

	}

	public static List<Product> createProductList() {
		return new ArrayList<Product>();
	}

	public static void removeUnussedProductsFromOffer(Bundle bundle) {
		bundle.getBundleProducts()
				.removeAll(bundle.getBundleProducts().stream()
						.filter(unusedProd -> unusedProd.getPrice().equals(new BigDecimal("0.0")))
						.collect(Collectors.toList()));
	}

	public static boolean isListEmpty(List<?> aList) {
		return Objects.nonNull(aList) && aList.isEmpty();
	}

	@NotBusiness
	public static void main(String[] args) {
		Bundle b1 = new Bundle();
		Bundle b2 = new Bundle();
		// Bundle b3 = new Bundle();
		// Bundle b4 = new Bundle();
		// Bundle b5 = new Bundle();
		// b1.setDiscountedPrice(new BigDecimal("100.05"));
		// b2.setDiscountedPrice(new BigDecimal("50.05"));
		// b3.setDiscountedPrice(new BigDecimal("150.05"));
		// b4.setDiscountedPrice(new BigDecimal("415.05"));
		// b5.setDiscountedPrice(new BigDecimal("515.05"));
		// System.out.println(findBestOffer(Arrays.asList(b1, b2, b3, b4, b5)));

		Product p1 = new Product();
		p1.setPrice(new BigDecimal("200.0"));
		Product p2 = new Product();
		p2.setPrice(new BigDecimal("0.0"));
		Product p3 = new Product();
		p3.setPrice(new BigDecimal("100.0"));
		Product p4 = new Product();
		p4.setPrice(new BigDecimal("345.0"));
		b1.getBundleProducts().addAll(Arrays.asList(p1, p2, p3, p4));
		System.out.println(b1.getBundleProducts().size());
		removeUnussedProductsFromOffer(b1);
		System.out.println(b1.getBundleProducts().size());
		System.out.println(new BigDecimal("0.0"));

		System.out.println(isListEmpty(b1.getBundleProducts()));
		System.out.println(isListEmpty(b2.getBundleProducts()));

	}

}
