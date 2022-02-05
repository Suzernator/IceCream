/**
 * @author SSene - Suzette Senephansiri
 * CIS175 - Spring 2022
 * Feb 2, 2022
 */

import java.util.List;
import java.util.Scanner;

import controller.OrderHelper;
import model.CoffeeOrder;

public class StartProgram {
	static Scanner in = new Scanner(System.in);
	static OrderHelper oh = new OrderHelper();
	static CoffeeOrder c = new CoffeeOrder();

	private static void addADrink() {
		System.out.print("Customer name: ");
		String name = in.nextLine();
		System.out.print("Enter a drink: ");
		String drink = in.nextLine();
		int number = c.getNumber();
		CoffeeOrder toAdd = new CoffeeOrder(number, name, drink);
		oh.insertDrink(toAdd);
	}

	private static void deleteADrink() {
		System.out.print("Enter the name to delete: ");
		String name = in.nextLine();
		System.out.print("Enter the drink to delete: ");
		String drink = in.nextLine();
		int number = c.getNumber();
		CoffeeOrder toDelete = new CoffeeOrder(number, name, drink);
		oh.deleteDrink(toDelete);
	}
	
	private static void editADrink() {
		System.out.println("Which number option would you like to search by? ");
		System.out.println("1: By customer name");
		System.out.println("2: By drink order");
		int searchBy = in.nextInt();
		in.nextLine();
		List<CoffeeOrder> foundDrinks;
		
		if (searchBy == 1) {
			System.out.print("Enter the customer name: ");
			String customerName = in.nextLine();
			foundDrinks = oh.searchOrderByName(customerName);
		} 
		
		else {
			System.out.print("Enter the drink: ");
			String drinkName = in.nextLine();
			foundDrinks = oh.searchOrderByDrink(drinkName);
		}

		if (!foundDrinks.isEmpty()) {
			System.out.println("Found Results.");
			
			for (CoffeeOrder c : foundDrinks) {
				System.out.println(c.getNumber() + " : " + c.toString());
			}
			
			System.out.print("Which ID to edit: ");
			int numToEdit = in.nextInt();
			CoffeeOrder toEdit = oh.searchOrderByNum(numToEdit);
			System.out.println("Drink: " + toEdit.getDrink() + " for: " + toEdit.getName());
			System.out.println("1: Update Name");
			System.out.println("2: Update Drink");
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				System.out.print("New Name: ");
				String newName = in.nextLine();
				toEdit.setName(newName);
			} 
			
			else if (update == 2) {
				System.out.print("New Drink: ");
				String newDrink = in.nextLine();
				toEdit.setDrink(newDrink);
			}

			oh.updateDrink(toEdit);
			
		} 
		
			else {
				System.out.println("Hmm, let's try again (no results found)");
			}
	}
	
	public static void main(String[] args) {
		runMenu();
	}
	
	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("Welcome to Café Suze's Customer Order App!");
		while (goAgain) {
			System.out.println("1: Add a drink order");
			System.out.println("2: Edit a drink order");
			System.out.println("3: Delete a drink order");
			System.out.println("4: View your order");
			System.out.println("5: Change your mind? Just Exit.");
			System.out.print("Choose an number option from the list provided above: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addADrink();
			} else if (selection == 2) {
				editADrink();
			} else if (selection == 3) {
				deleteADrink();
			} else if (selection == 4) {
				viewTheOrder();
			} else {
				oh.cleanUp();
				System.out.println("Have a GRANDE, we'll see you soon!");
				goAgain = false;
			}
		}
	}
	
	private static void viewTheOrder() {
		List<CoffeeOrder> allDrinks = oh.showAllDrinks();
		
		for(CoffeeOrder singleDrink : allDrinks) {
			System.out.println(singleDrink.returnOrder());
		}
	}
}
