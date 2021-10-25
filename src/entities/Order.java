package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import enum_entities.OrderStatus;

public class Order {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	private Date moment;
	private OrderStatus status;

	private Client client;
	// private List<Client> clients = new ArrayList<>();
	private List<OrderItem> orderItems = new ArrayList<>();

	public Order() {
	}

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public void addItem(OrderItem item) {
		orderItems.add(item);
	}

	public void removeItem(OrderItem item) {
		orderItems.remove(item);
	}

	/*
	 * public void addClient(Client client) { clients.add(client); }
	 */

	public double total() {
		double total = 0.0;
		for (OrderItem item : orderItems) {
			total += item.subTotal();
		}
		return total;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("Order moment: ");
		sb.append(sdf.format(moment) + "\n");
		sb.append("Order status: ");
		sb.append(status + "\n");
		sb.append("Client: ");
		sb.append(client + "\n");
		sb.append("Order items:" + "\n");
		for (OrderItem items : orderItems) {
			sb.append(items + "\n");
		}
		sb.append("Total price:  $");
		sb.append(String.format("%.2f", total()));

		return sb.toString();
	}

}
