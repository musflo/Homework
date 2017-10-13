public class Product {
	private String SKU;
	private String description;
	private float price;
	private int quantity;
	public Product (String SKU, String description, float price, int quantity) {
		this.SKU = "000";
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}
	public String SKU() {
		return this.SKU;
	}
	public String description() {
		return this.description;
	}
	public float price() {
		return this.price;
	}
	public int quantity() {
		return this.quantity;
	}
	public Product clone(int newQuantity) {
		Product clonedProduct = new Product(this.SKU(), this.description(), this.price(), newQuantity);
		return clonedProduct;
	}
}
