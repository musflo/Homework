
public class CartTester {
	public static void main(String[] args) {
	ShoppingCart myCart = new ShoppingCart();
	System.out.println(myCart.Products().length == 20);
	Product myProduct = new Product("011", "Testproduct", 34.21f, 4);
	myCart.addProduct(myProduct,  6);
	System.out.println());
	}
}
