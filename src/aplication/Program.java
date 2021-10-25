package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import enum_entities.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner scn = new Scanner(System.in);

		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String name = scn.nextLine();
		System.out.print("Email: ");
		String email = scn.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date date = sdf.parse(scn.next());

		Client client = new Client(name, email, date);

		System.out.println("Enter order data:");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(scn.next());
		
		Order order = new Order(new Date(), status, client);

		System.out.print("How many items to this order?:");
		int n = scn.nextInt();
		for (int i = 0; i < n; i++) {

			System.out.println("Enter #" + (i + 1) + " item data");
			System.out.print("Product name: ");
			scn.nextLine();
			String nameProduct = scn.nextLine();
			System.out.print("Product price: ");
			Double priceProduct = scn.nextDouble();
			System.out.print("Quantity: ");
			Integer quantity = scn.nextInt();
			
			Product product = new Product(nameProduct, priceProduct);

			OrderItem item = new OrderItem(quantity, priceProduct, product);
			
			order.addItem(item);
			
		}
		
		System.out.println();
		System.out.println("ORDER SUMARY:");
		System.out.println(order);
		scn.close();
	}
}
