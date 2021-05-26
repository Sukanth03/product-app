package com.chainsys.product.test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Set;

import com.chainsys.product.exception.ProductNotFoundException;
import com.chainsys.product.model.Product;
import com.chainsys.product.service.ProductService;
import com.chainsys.product.service.ProductServiceImpl;

public class ProductClient {
	public static void main(String[] args) {

		Set<Product> productSet;
		ProductService service = new ProductServiceImpl();
		String date;
		DateTimeFormatter dateFormat;
		int id;
		System.out.println("Enter the choice");
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			System.out.println("Find All Products");
			productSet = service.findAll();
			System.out.println(productSet);
			break;
		case 2:
			System.out.println("Find the Product By Id");
			System.out.println("Enter the Product Id");
			id = scanner.nextInt();
			try {
				Product product = service.findById(id);
				System.out.println(product);
			} catch (ProductNotFoundException e) {
			}
			break;
		case 3:
			System.out.println("Update the Product Name Based on the Id");
			date = "06/05/2019";
			dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			Product updateProduct = new Product(4, "Parkers", LocalDate.parse(date, dateFormat));
			try {
				service.update(updateProduct);
				productSet = service.findAll();
				System.out.println(productSet);
			} catch (ProductNotFoundException e) {

			}
			break;
		case 4:
			System.out.println("Adding a Product");
			date = "06/05/2019";
			dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			Product newProduct = new Product(4, "Pencil", LocalDate.parse(date, dateFormat));
			service.save(newProduct);
			productSet = service.findAll();
			System.out.println(productSet);
			break;
		case 5:
			System.out.println("Deleting a Product");
			System.out.println("Enter the Product Id");
			id = scanner.nextInt();
			try {
				service.delete(id);
				productSet = service.findAll();
				System.out.println(productSet);
			} catch (ProductNotFoundException e) {
			}
		case 6:
			System.out.println("Find the Product By name");
			System.out.println("Enter the Product name");
			String name = scanner.next();
			try {
				Product product = service.findByName(name);
				System.out.println(product);
			} catch (ProductNotFoundException e) {
			}
			break;
			
		case 7:
			System.out.println("Update the Product Expiry Date Based on the Id  ");
			date = "01/01/2023";
			dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			Product updateProduct1 = new Product(4, "Parker", LocalDate.parse(date, dateFormat));
			try {
				service.update(updateProduct1);
				productSet = service.findAll();
				System.out.println(productSet);
			} catch (ProductNotFoundException e) {

			}
			break;
			
		default:
			break;
		}
		scanner.close();
	}

}
