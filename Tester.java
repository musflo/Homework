
public class Tester {
	public static void main(String[] args) {
		Product myCar = new Product("Honda", "Pilot", 2350.54f, 5);
		System.out.println(myCar.SKU() == "Honda");
		System.out.println(myCar.description() == "Pilot");
		System.out.println(myCar.price() == 2350.54f);
		System.out.println(myCar.quantity() == 5);
		
		Product myCar2;
		myCar2 = myCar.clone(2);
		System.out.println(myCar2.SKU() == myCar.SKU());
		System.out.println(myCar2.description() == myCar.description());
		System.out.println(myCar2.price() == myCar.price());
		System.out.println(myCar2.quantity() == 2);
	}
}