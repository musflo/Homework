public class Store {

	private String storeName;
	private Aisle[] Aisles;

	public Store(String storeName, Aisle[] listOfAisles) {
		this.storeName = storeName;
		this.Aisles = listOfAisles;
	}

	public String storeName() {
		return this.storeName;
	}

	public Aisle[] Aisles() {
		return this.Aisles;
	}
}