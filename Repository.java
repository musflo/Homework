	public class Repository {  
	public static Store getStore() {
		return new Store("Aldo's Bizarrely Antiquated Digital Bazaar", listOfAisles());
		
	}
	private static Aisle[] listOfAisles() {
		Aisle aisle1 = new Aisle("1", "Unused Game Accesories", getListOfProducts("1"));
		Aisle aisle2 = new Aisle("2", "Trashy Dungeon Treasure", getListOfProducts("2"));
		Aisle aisle3 = new Aisle("3", "Forgotten 90s Action Movie Stars",getListOfProducts("3"));
		Aisle aisle4 = new Aisle("4", "Water Bottles",getListOfProducts("4"));
		return new Aisle[] {aisle1, aisle2, aisle3, aisle4};
	}
	private static Product[] getListOfProducts(String aisleNumber) {
		if (aisleNumber.equals("1")) {
			Product item1 = new Product("001", "Virtual Boy", 299.49f, 7);
			Product item2 = new Product("002", "GameBoy Camera", 49.49f, 6);
			Product item3 = new Product("003", "Duck Hunt Rifle", 23.99f, 3);
			Product item4 = new Product("004", "Xbox Kinect", 400.49f, 900);
			return new Product[] {item1, item2, item3, item4};
		}
		if (aisleNumber.equals("2")) {
			Product item1 = new Product("005", "Rusty Sword", 10.49f, 9);
			Product item2 = new Product("006", "Fake Crown", 2.49f, 7);
			Product item3 = new Product("007", "Stale Bread", 3.49f, 5);
			Product item4 = new Product("008", "Finnicky Lamp", 4.49f, 3);
			return new Product[] {item1, item2, item3, item4};
		}
		if (aisleNumber.equals("3")) {
			Product item1 = new Product("005", "Jackie Chan", 989.49f, 1);
			Product item2 = new Product("006", "Steven Seagal", 1.49f, 1);
			Product item3 = new Product("007", "Dolph Lundgren", 10.49f, 0);
			Product item4 = new Product("008", "Carl Weathers", 34.49f, 1);
			return new Product[] {item1, item2, item3, item4};
		}
		if (aisleNumber.equals("4")) {
			Product item1 = new Product("005", "Small Bottle", 1.49f, 6);
			Product item2 = new Product("006", "Gallon-size", 3.49f, 6);
			Product item3 = new Product("007", "5-Gallon Hat", 50.49f, 5);
			Product item4 = new Product("008", "Waterless", 494.49f, 0);
			return new Product[] {item1, item2, item3, item4};
		}
		return new Product[0];
	}
}