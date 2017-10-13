
public class CartTester {
	public static void main(String[] args) {
	ShoppingCart myCart = new ShoppingCart();
	System.out.println(myCart.Products().length == 20);
	Product myProduct = new Product("011", "Testproduct", 100f, 4);
	myCart.addProduct(myProduct,  6);
	System.out.println(myCart.Products()[0].quantity() == 6);
	myCart.addProduct(myProduct,  2);
	System.out.println(myCart.Products()[1].quantity() == 2);
	System.out.println(myCart.balanceDue() == 800f);
	}
}
