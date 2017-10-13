
public class AisleTester {

	public static void main(String[] args) {
		Aisle myAisle = new Aisle("1", "testaisle", listofProducts());
			System.out.println(myAisle.aisleNumber() == "1");
			System.out.println(myAisle.Products().length == listofProducts().length);
		}

		private static Product[] listofProducts() {
			Product car1 = new Product("SKU", "description", 45.00f, 0);
			return new Product[] {car1, car1, car1};
	
		}
}