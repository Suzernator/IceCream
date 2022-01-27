package model;

/**
 * @author SSene - Suzette Senephansiri
 * CIS175 - Spring 2022
 * Jan 26, 2022
 */
public class Ingredients {
		private double price = 0;
		String holder;
		int numScoop;
		String choice;
		boolean sprinkles;
		
	public double iceCreamContainer(String holder) {
		holder = "cup";
		if (holder == "cone") {
			price = .25;
		}
		else {
			price = 0;
		}			
		return price;
	}
	
	public double numOfScoops(int numScoop) {
		numScoop = 1;
		if (numScoop == 2) {
			price = .50;
		}
		else {
			price = .25;
		}			
		return price;
	}
	
	public void iceCreamFlavor(String choice) {
		System.out.print(choice);
	}
	
	public double hasToppings(boolean sprinkles) {
		if (sprinkles == true) {
			price = .10;
		}
		else {
			price = 0;
		}
		return price;
	}
	
	public double priceCalculator() {
		double price = iceCreamContainer(holder) + numOfScoops(numScoop) + hasToppings(sprinkles);
		return price;
		
	}

	public boolean allTheFixins(IceCreamComponents customer) {
		if (hasToppings(true) == .10) {
			return true;
		}
		else {
			return false;
			}
		}
}
