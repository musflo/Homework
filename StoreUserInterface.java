	import java.util.Scanner;
	public class StoreUserInterface {
		public static void main(String[] args) {
			Scanner scan = new Scanner(System.in);
			Store myStore = Repository.getStore();
			ShoppingCart myCart = new ShoppingCart();
			System.out.println("Welcome to " + myStore.storeName());
			System.out.println("Below you will find a list of the aisles contained within these virtual confines.");
			System.out.println("Select one and I will show you the wares you can find in that aisle.");
			System.out.println("You also have been cursed to forever browse my wares until you type the phrase 'Leave me alone' into the console");
			boolean keepGoing = true;
			while (keepGoing) {
				displayListOfAisles(myStore.Aisles());
				System.out.println("You're balance is " + myCart.balanceDue());
				System.out.println("You are affected with a magic curse, you must select an aisle number to peruse or enter the correct phrase to break the curse");
				String choice = scan.nextLine();
				if (choice.equals("Leave me alone")) {
				keepGoing = false;
				System.out.println("You have defeated me, enjoy your freedom...");
				} else {
					int aisleNumber = Integer.parseInt(choice) - 1;
					if (aisleNumber >= 0 && aisleNumber <= myStore.Aisles().length -1) {
						Aisle chosenAisle = myStore.Aisles()[aisleNumber];
						displayListOfProducts(chosenAisle.Products());
						System.out.println("Please pick a product:");
						String productChoice = scan.nextLine();
						int productNumber = Integer.parseInt(productChoice);
						if (productNumber >= 0 && productNumber <= chosenAisle.Products().length - 1) {
							System.out.println("How many would you like to buy?");
							String quantityChoice = scan.nextLine();
							int qty = Integer.parseInt(quantityChoice);
							myCart.addProduct(chosenAisle.Products()[productNumber], qty);
						}
					}
				}
			}
			scan.close();
			System.out.println("Thank you for shopping. Your balance is " + myCart.balanceDue());
		}
		private static void displayListOfAisles(Aisle[] aisles) {
			System.out.println("");
			for (int i = 0; i < aisles.length; i++) {
				System.out.print("Aisle " + (i + 1) + " - ");
				System.out.println(aisles[i].aisleDescription());
			}
		}
		private static String ask(String prompt) {
			Scanner Scan = new Scanner(System.in);
			System.out.println(prompt);
			String choice = scan.nextLine();
			return choice;
					
			scan.close();
		
		}
		
		private static void displayListOfProducts(Product[] getListOfProducts) {
			System.out.println("SKU\tDescription\tPrice");
			System.out.println("----\t-----------\t-----");
			for (Product item : getListOfProducts) {
			System.out.print(item.SKU() + 1 + "\t");
			System.out.print(item.description() + "\t");
			System.out.print("$" + item.price() + "\t" + "\n");
		}
	}

	
}

