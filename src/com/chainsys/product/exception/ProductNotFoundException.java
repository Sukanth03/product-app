package com.chainsys.product.exception;

public class ProductNotFoundException extends Exception {

	public ProductNotFoundException(String message) {
		System.out.println(message);
	}
}
