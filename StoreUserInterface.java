	import java.util.Scanner;
	public class StoreUserInterface {
		private static Scanner scan = new Scanner(System.in);
		public static void main(String[] args) {
			Store myStore = Repository.getStore();
			ShoppingCart myCart = new ShoppingCart();
			boolean keepGoing = true;
			String customerName = ask("What is your name?");
			System.out.println("Hello " + customerName + ". Welcome to " + myStore.storeName() + ".");
			while (keepGoing) {
				displayListOfAisles(myStore.Aisles());
				System.out.println("You're balance is $" + myCart.balanceDue());
				String choice = ask("Select an aisle or type 'checkout' to exit and view ");
				if (choice.equals("checkout")) {
				keepGoing = false;
				System.out.println("Thank you for shopping. Your final balance is $" + myCart.balanceDue());
				} else {
					int aisleNumber = Integer.parseInt(choice) - 1;
					if (aisleNumber >= 0 && aisleNumber <= myStore.Aisles().length -1) {
						Aisle chosenAisle = myStore.Aisles()[aisleNumber];
						displayListOfProducts(chosenAisle.Products());
						String productChoice = ask("Please pick a product:");
						int productNumber = Integer.parseInt(productChoice);
						if (productNumber >= 0 && productNumber <= chosenAisle.Products().length) {
							System.out.println("How many would you like to buy?");
							String quantityChoice = scan.nextLine();
							int qty = Integer.parseInt(quantityChoice);
							myCart.addProduct(chosenAisle.Products()[productNumber], qty);
						}
					}
				}
			}
			scan.close();
			
		}
		private static void displayListOfAisles(Aisle[] aisles) {
			System.out.println("");
			for (int i = 0; i < aisles.length; i++) {
				System.out.print("Aisle " + (i + 1) + " - ");
				System.out.println(aisles[i].aisleDescription());
			}
			System.out.println();
		}
		public static String ask(String prompt) {
			System.out.println(prompt);
			String choice = scan.nextLine();
			return choice;
		}
		
		private static void displayListOfProducts(Product[] getListOfProducts) {
			System.out.println("SKU\tDescription\tPrice");
			System.out.println("----\t-----------\t-----");
			int i = 1;
			for (Product item : getListOfProducts) {
			System.out.print(item.SKU() + i + "\t");
			System.out.print(item.description() + "\t");
			System.out.print("$" + item.price() + "\t" + "\n");
			i++;
		}
	}

	
}
