

public class Aisle {  
  // Product constructor with three parameters (aisleNumber, aisleDescription, products)
  // aisleNumber() method to return the nunber of the aisle
  // aisleDescription() method to return the name or description of the aisle
  // Products - An array of Product
	private String aisleNumber;
	private String aisleDescription;
	private Product[] getListOfProducts;
	public Aisle(String aisleNumber, String aisleDescription, Product[] getListOfProducts) {
		this.aisleNumber = aisleNumber;
		this.aisleDescription = aisleDescription;
		this.getListOfProducts = getListOfProducts;
	}
	public String aisleNumber() {
		return this.aisleNumber;
	}
	public String aisleDescription() {
		return this.aisleDescription;
	}
	public Product[] Products() {
		return this.getListOfProducts;
	}
}