
public class ShoppingCart {
	private Product[] Products;
	private int numberOfProducts;
	public ShoppingCart() {
		this.Products = new Product[20];
		numberOfProducts = 0;

}

public Product[] Products() {
	return this.Products;
}

public void addProduct(Product product, int quantity) {
	this.Products[numberOfProducts] = product.clone(quantity);
	numberOfProducts++;
}

public float balanceDue() {
	float balanceDue = 0;
	for (int i = 0; i < numberOfProducts; i++) {
		balanceDue += this.Products[i].price() * this.Products[i].quantity();
		}
		return balanceDue;
		}
}