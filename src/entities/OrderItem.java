package entities;

public class OrderItem {
	private Integer quantity;
	private Double price;
	
	private Product product;

	//private List<Product> products = new ArrayList<>();

	public OrderItem() {
	}

	public OrderItem(Integer quantity, Double price, Product product) {
		this.quantity = quantity;
		this.price = price;
		this.product = product;
	}
	
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	

	/*
	 * public void addProduct(Product product) { products.add(product); }
	 * 
	 * public void removeProduct(Product product) { products.remove(product); }
	 */

	public double subTotal() {
		/*
		 * double subTotal = 0; for(Product p : products) { subTotal = p.getPrice() *
		 * quantity; return subTotal; }
		 */
		return price * quantity;
	}

	@Override
	public String toString() {
		
		return product.getName() +
				", $" 
				+ String.format("%.2f", price)
				+ ", Quantity: "
				+ quantity +
				", Subtotal: $"
				+ String.format("%.2f", subTotal());
		/*
		 * StringBuilder sb = new StringBuilder();
		 * 
		 * for(Product p: products) { sb.append(p.getName()+", ");
		 * sb.append("$ "+price); sb.append(" Quantity: "+quantity);
		 * sb.append(", subtotal: "+subTotal()); sb.append("\n"); }
		 * 
		 * return sb.toString();
		 */
	}
	
	

}
