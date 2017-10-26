	import java.util.Scanner;
	import java.text.NumberFormat;
	
	public class StoreUserInterface {
		private static Scanner scan = new Scanner(System.in);
		private static NumberFormat formatter = NumberFormat.getCurrencyInstance();
		
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
				} else {
					displayAndSelectProduct(myStore, choice, myCart);
				}
			}
			System.out.println("Your final balance is " + formatter.format(myCart.balanceDue()));
			System.out.println("Thank you for shopping " + customerName + ", please come back.");
			scan.close();
		}
		private static void displayAndSelectProduct(Store myStore, String aisleChoice, ShoppingCart myCart) {
					int aisleNumber = Integer.parseInt(aisleChoice) - 1;
					if (aisleNumber >= 0 && aisleNumber <= myStore.Aisles().length -1) {
						Aisle chosenAisle = myStore.Aisles()[aisleNumber];
						displayListOfProducts(chosenAisle.Products());
						int productNumber = askForInt("Please pick something already:") - 1;
						if (productNumber >= 0 && productNumber <= chosenAisle.Products().length - 1) {
							int qty = askForInt("How many do you wish to buy?");
							if (myCart.addProduct(chosenAisle.Products()[productNumber], qty)) {
								System.out.println(qty + " of '" + chosenAisle.Products()[productNumber].description() + "' added to your cart.");
							} else {
								System.out.println("Sorry... We don't have that many of '" + chosenAisle.Products()[productNumber].description() + "'");
							}
						}
					}
			
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
		private static int askForInt(String prompt) {
			return Integer.parseInt(ask(prompt));
		}
		private static void displayListOfProducts(Product[] listOfProducts) {
			System.out.print(rightPad("Option", 6) + "\t");
			System.out.print(rightPad("SKU", 12) + "\t");
			System.out.print(rightPad("Description", 15) + "\t");
			System.out.print(rightPad("Price", 12) + "\t");
			System.out.println(rightPad("Qty", 5) + "\t");

			System.out.print(rightPad("", 6, "-") + "\t");
			System.out.print(rightPad("", 12, "-") + "\t");
			System.out.print(rightPad("", 15, "-") + "\t");
			System.out.print(rightPad("", 12, "-") + "\t");
			System.out.println(rightPad("", 5, "-") + "\t");
			int i = 1;
			for (Product product : listOfProducts) {
				System.out.print(i + "\t");
				System.out.print(rightPad(product.SKU(), 12) + "\t");
				System.out.print(rightPad(product.description(), 15) + "\t");
				System.out.print(rightPad(formatter.format(product.price()),12) + "\t");
				System.out.println(rightPad(product.quantity(),5));
				i++;
			}
		}

		public static String rightPad(String phrase, int finalLength) {
			return rightPad(phrase, finalLength, " ");
		}

		public static String rightPad(int number, int finalLength) {
			return rightPad(Integer.toString(number), finalLength);
		}

		public static String rightPad(String phrase, int finalLength, String padCharacter) {
			if (phrase.length() >= finalLength) 
				return phrase.substring(0, finalLength);
			String spaces = "";
			for (int i = 0; i < finalLength - phrase.length(); i++)
				spaces += padCharacter;
			return phrase + spaces;
		}

	
}
