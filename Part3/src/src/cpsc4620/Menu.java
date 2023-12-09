package cpsc4620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
CURRENT ISSUES:
- I'm not sure how to store the date such that it creates the right format in code and submits it to sql Date format
- Making sure the order_id shows up in the pizza table - issues with foreign key stuff
- I'm not sure if the math of everything is right...I assume so. Things are updating/adding/subtracting from topping inventory and prices
and such but I don't know if we need to check that more thoroughly
- for some reason is not adding pizza to order's pizza list when I try to print it. But I checked it when I was adding it and it's working
fine. Maybe there's something wrong in my print function? I don't know...I've stared at it for too long...

Definitely will need to reset db so it gets rid of all the testing data and we can test one last final time with a clean db to simulate
what the TA and Prof. Taylor are going to see and play with.

 */

/*
 * This file is where the front end magic happens.
 *
 * You will have to write the methods for each of the menu options.
 *
 * This file should not need to access your DB at all, it should make calls to the DBNinja that will do all the connections.
 *
 * You can add and remove methods as you see necessary. But you MUST have all of the menu methods (including exit!)
 *
 * Simply removing menu methods because you don't know how to implement it will result in a major error penalty (akin to your program crashing)
 *
 * Speaking of crashing. Your program shouldn't do it. Use exceptions, or if statements, or whatever it is you need to do to keep your program from breaking.
 *
 */

public class Menu {

	public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws SQLException, IOException {

		System.out.println("Welcome to Pizzas-R-Us!");

		int menu_option = 0;

		// present a menu of options and take their selection

		PrintMenu();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String option = reader.readLine();
		menu_option = Integer.parseInt(option);

		while (menu_option != 9) {
			switch (menu_option) {
				case 1:// enter order
					EnterOrder();
					break;
				case 2:// view customers
					viewCustomers();
					break;
				case 3:// enter customer
					EnterCustomer();
					break;
				case 4:// view order
						// open/closed/date
					ViewOrders();
					break;
				case 5:// mark order as complete
					MarkOrderAsComplete();
					break;
				case 6:// view inventory levels
					ViewInventoryLevels();
					break;
				case 7:// add to inventory
					AddInventory();
					break;
				case 8:// view reports
					PrintReports();
					break;
			}
			PrintMenu();
			option = reader.readLine();
			menu_option = Integer.parseInt(option);
		}

	}

	// allow for a new order to be placed
	public static void EnterOrder() throws SQLException, IOException {

		/*
		 * EnterOrder should do the following:
		 *
		 * Ask if the order is delivery, pickup, or dinein
		 * if dine in....ask for table number
		 * if pickup...
		 * if delivery...
		 *
		 * Then, build the pizza(s) for the order (there's a method for this)
		 * until there are no more pizzas for the order
		 * add the pizzas to the order
		 *
		 * Apply order discounts as needed (including to the DB)
		 *
		 * return to menu
		 *
		 * make sure you use the prompts below in the correct order!
		 */

		int order_ID = DBNinja.get_next_Orderid();
		int cust_id = -1;
		int table_num = -1;
		String existing_cust = "";
		// User Input Prompts...
		System.out.println(
				"Is this order for: \n1.) Dine-in\n2.) Pick-up\n3.) Delivery\nEnter the number of your choice:");
		int order_type = Integer.parseInt(reader.readLine());
		if (order_type == 1) {
			System.out.println("What is the table number for this order?");
			table_num = Integer.parseInt(reader.readLine());
		} else if (order_type == 2 || order_type == 3) {
			while (!existing_cust.equals("y") && !existing_cust.equals("n")) {
				System.out.println("Is this order for an existing customer? Answer y/n: ");
				existing_cust = reader.readLine();
				if (existing_cust.equals("y")) {
					System.out.println("Here's a list of the current customers: ");
					viewCustomers();
					System.out.println("Which customer is this order for? Enter ID Number:");
					cust_id = Integer.parseInt(reader.readLine());
				} else if (existing_cust.equals("n")) {
					EnterCustomer();
					ArrayList<Customer> c = DBNinja.getCustomerList();
					for (int i = 0; i < c.size(); i++) {
						int currId = c.get(i).getCustID();
						if (cust_id < currId) {
							cust_id = currId;
						}
					}
				} else {
					System.out.println(
							"ERROR: I don't understand your input for: Is this order for an existing customer?");
				}

			}
		} else {
			System.out.println("I'm sorry I didn't understand your input for: " +
					"Is this order for: \n1.) Dine-in\n2.) Pick-up\n3.) Delivery\nEnter the number of your choice: Please try again.");
		}

		ArrayList<Customer> all_customers = DBNinja.getCustomerList();
		Customer customer = all_customers.get((all_customers.size() - 1));
		for (int i = 0; i < all_customers.size(); i++) {
			if (all_customers.get(i).getCustID() == cust_id) {
				customer = all_customers.get(i);
			}
		}

		if (order_type == 3 && existing_cust.equals("n")) {
			System.out.println("What is the House/Apt Number for this order? (e.g., 111)");
			String house_num = reader.readLine();
			System.out.println("What is the Street for this order? (e.g., Smile Street)");
			String street = reader.readLine();
			System.out.println("What is the City for this order? (e.g., Greenville)");
			String city = reader.readLine();
			System.out.println("What is the State for this order? (e.g., SC)");
			String state = reader.readLine();
			System.out.println("What is the Zip Code for this order? (e.g., 20605)");
			String zip = reader.readLine();
			customer.setAddress(house_num + " " + street, city, state, zip);
			DBNinja.updateAddress(customer);
		}

		double totalBusPrice = 0.0;
		double totalCustPrice = 0.0;
		ArrayList<Pizza> pizzaList = new ArrayList<Pizza>();

		String more_pizza = "";
		System.out.println("Let's build a pizza!");
		while (!more_pizza.equals("-1")) {
			Pizza newPizza = buildPizza(order_ID);
			newPizza.setOrderID(order_ID);
			pizzaList.add(newPizza);
			totalBusPrice += newPizza.getBusPrice();
			totalCustPrice += newPizza.getCustPrice();

			System.out.println(
					"Enter -1 to stop adding pizzas...Enter anything else to continue adding pizzas to the order.");
			more_pizza = reader.readLine();
		}

		ArrayList<Discount> discountList = new ArrayList<Discount>();
		ArrayList<Discount> allDiscounts = DBNinja.getDiscountList();
		System.out.println("Do you want to add discounts to this order? Enter y/n?");
		String enter_discounts = reader.readLine();
		if (enter_discounts.equals("y")) {
			int discountChoice = 1;
			while (discountChoice != -1) {
				viewDiscounts();
				System.out.println(
						"Which Order Discount do you want to add? Enter the DiscountID. Enter -1 to stop adding Discounts: ");
				discountChoice = Integer.parseInt(reader.readLine());
				if (discountChoice != -1) {
					Discount newDiscount = null;
					for (int i = 0; i < allDiscounts.size(); i++) {
						newDiscount = allDiscounts.get(i);
						if (newDiscount.getDiscountID() == discountChoice) {
							discountList.add(newDiscount);
						}
					}
				}
			}
		}
		String date = new java.util.Date().toString();
		String order_name = " ";
		order_ID = DBNinja.get_next_Orderid();
		Order newOrder = null;
		if (order_type == 1) {
			order_name = "Dine-in";
			newOrder = new DineinOrder(order_ID, cust_id, date, totalCustPrice, totalBusPrice, 0,
					table_num);
		} else if (order_type == 2) {
			order_name = "Pick-up";
			newOrder = new PickupOrder(order_ID, cust_id, date, totalCustPrice, totalBusPrice, 0, 0);
		} else if (order_type == 3) {
			order_name = "Delivery";
			newOrder = new DeliveryOrder(order_ID, cust_id, date, totalCustPrice, totalBusPrice, 0,
					customer.getAddress());
		}
		newOrder.setDiscountList(discountList);
		newOrder.setPizzaList(pizzaList);
		DBNinja.addOrder(newOrder);

		for (int i = 0; i < discountList.size(); i++) {
			DBNinja.useOrderDiscount(newOrder, discountList.get(i));
		}

		for (int i = 0; i < pizzaList.size(); i++) {
			Pizza p = pizzaList.get(i);
			DBNinja.addPizza(p);
			ArrayList<Topping> toppingList = p.getToppings();
			boolean[] isExtra = p.getIsDoubleArray();
			for (int j = 0; j < toppingList.size(); j++) {
				DBNinja.useTopping(p, toppingList.get(j), isExtra[toppingList.get(j).getTopID() - 1]);
			}
			ArrayList<Discount> pizzaDiscounts = p.getDiscounts();
			for (int k = 0; k < pizzaDiscounts.size(); k++) {
				DBNinja.usePizzaDiscount(p, pizzaDiscounts.get(k));
			}
		}

		// Finished
		System.out.println("Finished adding order...Returning to menu...");
	}

	public static void viewCustomers() throws SQLException, IOException {
		/*
		 * Simply print out all of the customers from the database.
		 */
		ArrayList<Customer> customerList = DBNinja.getCustomerList();
		for (int i = 0; i < customerList.size(); i++) {
			Customer c = customerList.get(i);
			System.out.println(c.toString());
		}
	}

	// Enter a new customer in the database
	public static void EnterCustomer() throws SQLException, IOException {
		/*
		 * Ask for the name of the customer:
		 * First Name <space> Last Name
		 *
		 * Ask for the phone number.
		 * (##########) (No dash/space)
		 *
		 * Once you get the name and phone number, add it to the DB
		 */

		// User Input Prompts...
		System.out.println("What is this customer's name (first <space> last)");
		String[] name = reader.readLine().split(" ");
		String first_name = name[0];
		String last_name = name[1];

		System.out.println("What is this customer's phone number (##########) (No dash/space)");
		String phone_num = reader.readLine();

		Customer cust = new Customer(6, first_name, last_name, phone_num);

		DBNinja.addCustomer(cust);
	}

	// View any orders that are not marked as completed
	public static void ViewOrders() throws SQLException, IOException {
		/*
		 * This method allows the user to select between three different views of the
		 * Order history:
		 * The program must display:
		 * a. all open orders
		 * b. all completed orders
		 * c. all the orders (open and completed) since a specific date (inclusive)
		 *
		 * After displaying the list of orders (in a condensed format) must allow the
		 * user to select a specific order for viewing its details.
		 * The details include the full order type information, the pizza information
		 * (including pizza discounts), and the order discounts.
		 *
		 */

		// User Input Prompts...
		System.out.println(
				"Would you like to:\n(a) display all orders [open or closed]\n(b) display all open orders\n(c) display all completed [closed] orders\n(d) display orders since a specific date");
		String input = reader.readLine();

		ArrayList<Order> orderList = null;
		if (input.equals("a")) {
			// display all orders
			orderList = DBNinja.getOrders(false);
		} else if (input.equals("b")) {
			// display all open orders
			orderList = DBNinja.getOrders(true);
		} else if (input.equals("c")) {
			// display all closed orders
			orderList = DBNinja.getClosedOrders();
		} else if (input.equals("d")) { // THIS IS THE ONLY ONE THAT STILL NEEDS TO BE DONE
			// display by certain date
			System.out.println("What is the date you want to restrict by? (FORMAT= YYYY-MM-DD)");
			String date = reader.readLine();
			orderList = DBNinja.getOrdersByDate(date);
		} else {
			System.out.println("Incorrect entry, returning to menu.");
			return;
		}

		if (orderList.isEmpty()) {
			System.out.println("No orders to display, returning to menu.");
		} else {
			for (int i = 0; i < orderList.size(); i++) {
				Order o = orderList.get(i);
				System.out.println("ID=" + o.getOrderID() + " Type=" + o.getOrderType());
			}
			System.out.println("Which order would you like to see in detail? Enter the number (-1 to exit): ");
			int pickedOrder = Integer.parseInt(reader.readLine());

			Order view_o = null;
			for (int i = 0; i < orderList.size(); i++) {
				view_o = orderList.get(i);
				if (view_o.getOrderID() == pickedOrder) {
					printOrderDetails(view_o);
					break;
				}
			}

		}

	}

	public static void printOrderDetails(Order o) throws SQLException, IOException {
		String name = DBNinja.getCustomerName(o.getCustID());
		System.out.println(o.toString());
		ArrayList<Discount> orderdiscounts = o.getDiscountList();
		if (orderdiscounts.isEmpty()) {
			System.out.println("NO ORDER DISCOUNTS");
		} else {
			System.out.println("ORDER DISCOUNTS: ");
			for (int k = 0; k < orderdiscounts.size(); k++) {
				Discount currDiscount = orderdiscounts.get(k);
				System.out.println(currDiscount.toString());
			}
		}
		ArrayList<Pizza> pizzas = o.getPizzaList();
		if (pizzas.isEmpty()) {
			System.out.println("No Pizzas");
		}
		for (int i = 0; i < pizzas.size(); i++) {
			Pizza currPizza = pizzas.get(i);
			System.out.println(currPizza.toString());
			ArrayList<Discount> pizzaDiscounts = pizzas.get(i).getDiscounts();
			if (pizzaDiscounts.isEmpty()) {
				System.out.println("NO PIZZA DISCOUNTS");
			} else {
				System.out.println("PIZZA DISCOUNTS: ");
				for (int j = 0; j < pizzaDiscounts.size(); j++) {
					Discount currPizzaDiscount = pizzaDiscounts.get(j);
					System.out.println(currPizzaDiscount.toString());
				}
			}
		}

	}

	// When an order is completed, we need to make sure it is marked as complete
	public static void MarkOrderAsComplete() throws SQLException, IOException {
		/*
		 * All orders that are created through java (part 3, not the orders from part 2)
		 * should start as incomplete
		 *
		 * When this method is called, you should print all of the "opoen" orders marked
		 * and allow the user to choose which of the incomplete orders they wish to mark
		 * as complete
		 *
		 */

		// User Input Prompts...
		ArrayList<Order> orderList = DBNinja.getOrders(true);
		if (orderList.isEmpty()) {
			System.out.println("There are no open orders currently... returning to menu...");
		} else {
			// print the orders
			for (int i = 0; i < orderList.size(); i++) {
				Order o = orderList.get(i);
				System.out.println("ID=" + o.getOrderID() + " Type=" + o.getOrderType());
			}
			System.out.println("Which order would you like mark as complete? Enter the OrderID: ");
			Integer order_Id = Integer.parseInt(reader.readLine());
			Order o = null;
			for (int i = 0; i < orderList.size(); i++) {
				if (orderList.get(i).getOrderID() == order_Id) {
					o = orderList.get(i);
				}
			}
			DBNinja.completeOrder(o);
		}
		// System.out.println("Incorrect entry, not an option");

	}

	public static void ViewInventoryLevels() throws SQLException, IOException {
		/*
		 * Print the inventory. Display the topping ID, name, and current inventory
		 */

		DBNinja.printInventory();

	}

	public static void AddInventory() throws SQLException, IOException {
		/*
		 * This should print the current inventory and then ask the user which topping
		 * (by ID) they want to add more to and how much to add
		 */

		// User Input Prompts...
		ViewInventoryLevels();
		System.out.println("Which topping do you want to add inventory to? Enter the number: ");
		int id_num = Integer.parseInt(reader.readLine());
		ArrayList<Topping> toppingList = DBNinja.getToppingList();
		Topping t = null;
		for (int i = 0; i < toppingList.size(); i++) {
			if (toppingList.get(i).getTopID() == id_num) {
				t = toppingList.get(i);
			}
		}
		System.out.println("How many units would you like to add? ");
		int quantity = Integer.parseInt(reader.readLine());
		DBNinja.addToInventory(t, quantity);
		// System.out.println("Incorrect entry, not an option");

	}

	// A method that builds a pizza. Used in our add new order method
	public static Pizza buildPizza(int orderID) throws SQLException, IOException {

		/*
		 * This is a helper method for first menu option.
		 *
		 * It should ask which size pizza the user wants and the crustType.
		 *
		 * Once the pizza is created, it should be added to the DB.
		 *
		 * We also need to add toppings to the pizza. (Which means we not only need to
		 * add toppings here, but also our bridge table)
		 *
		 * We then need to add pizza discounts (again, to here and to the database)
		 *
		 * Once the discounts are added, we can return the pizza
		 */
		Pizza ret = null;
		int pizza_Id = -1;
		// System.out.println(orderID);

		// User Input Prompts...
		// Choose pizza size
		System.out.println("What size is the pizza?");
		System.out.println("1." + DBNinja.size_s);
		System.out.println("2." + DBNinja.size_m);
		System.out.println("3." + DBNinja.size_l);
		System.out.println("4." + DBNinja.size_xl);
		System.out.println("Enter the corresponding number: ");
		int crust = Integer.parseInt(reader.readLine());
		String crust_size = "";
		if (crust == 1) {
			crust_size = DBNinja.size_s;
		} else if (crust == 2) {
			crust_size = DBNinja.size_m;
		} else if (crust == 3) {
			crust_size = DBNinja.size_l;
		} else {
			crust_size = DBNinja.size_xl;
		}
		// Choose pizza crust
		System.out.println("What crust for this pizza?");
		System.out.println("1." + DBNinja.crust_thin);
		System.out.println("2." + DBNinja.crust_orig);
		System.out.println("3." + DBNinja.crust_pan);
		System.out.println("4." + DBNinja.crust_gf);
		System.out.println("Enter the corresponding number: ");
		crust = Integer.parseInt(reader.readLine());
		String crust_type = "";
		if (crust == 1) {
			crust_type = DBNinja.crust_thin;
		} else if (crust == 2) {
			crust_type = DBNinja.crust_orig;
		} else if (crust == 3) {
			crust_type = DBNinja.crust_pan;
		} else {
			crust_type = DBNinja.crust_gf;
		}

		// Create the new pizza
		double busPrice = DBNinja.getBaseBusPrice(crust_size, crust_type);
		double custPrice = DBNinja.getBaseCustPrice(crust_size, crust_type);

		ret = new Pizza(pizza_Id, crust_size, crust_type, orderID, "Completed", new Date().toString(), custPrice,
				busPrice);
		ret.setOrderID(orderID);

		// Choose toppings
		ArrayList<Topping> fullToppingList = DBNinja.getToppingList();

		int topping_choice = 0;
		while (topping_choice != -1) {
			// Print available toppings
			System.out.println("Available Toppings:");
			System.out.println(String.format("%-5s%-18s%5s", "ID", "Name", "CurINVT"));
			for (int i = 0; i < fullToppingList.size(); i++) {
				Topping currTopping = fullToppingList.get(i);
				System.out.println(String.format("%-5s%-18s%5s", currTopping.getTopID(), currTopping.getTopName(),
						currTopping.getCurINVT()));
			}

			// Select topping choice
			System.out.println("Which topping do you want to add? Enter the TopID. Enter -1 to stop adding toppings: ");
			topping_choice = Integer.parseInt(reader.readLine());

			if (topping_choice != -1) {
				int indexOfChoice = 0;
				for (int i = 0; i < fullToppingList.size(); i++) {
					if (fullToppingList.get(i).getTopID() == topping_choice) {
						indexOfChoice = i;
						break;
					}
				}

				Topping toppingToAdd = fullToppingList.get(indexOfChoice);

				System.out.println("Do you want to add extra topping? Enter y/n");
				String extraInput = reader.readLine();
				boolean extra = false;
				if (extraInput.equals("y")) {
					extra = true;
					ret.modifyDoubledArray(indexOfChoice, true);
				}

				// calculate the amount of toppings to use
				double amountToUse = 0;
				switch (ret.getSize()) {
					case DBNinja.size_s:
						amountToUse = toppingToAdd.getPerAMT();
						break;
					case DBNinja.size_m:
						amountToUse = toppingToAdd.getMedAMT();
						break;
					case DBNinja.size_l:
						amountToUse = toppingToAdd.getLgAMT();
						break;
					case DBNinja.size_xl:
						amountToUse = toppingToAdd.getXLAMT();
						break;
				}
				if (extra) {
					amountToUse *= 2;
				}

				// add toppings if possible
				if (toppingToAdd.getCurINVT() - amountToUse < toppingToAdd.getMinINVT()) {
					System.out.println("We don't have enough of that topping to add it...");
				} else {
					ret.addToppings(toppingToAdd, extra);
				}
			}
		}

		System.out.println("Do you want to add discounts to this Pizza? Enter y/n?");
		String addDiscounts = reader.readLine();

		while (addDiscounts.equals("y")) {
			viewDiscounts();
			System.out.println(
					"Which Pizza Discount do you want to add? Enter the DiscountID. Enter -1 to stop adding Discounts: ");
			int discountID = Integer.parseInt(reader.readLine());
			ArrayList<Discount> discountList = DBNinja.getDiscountList();
			for (int i = 0; i < discountList.size(); i++) {
				Discount d = discountList.get(i);
				if (d.getDiscountID() == discountID) {
					ret.addDiscounts(d);
					break;
				}
			}

			System.out.println("Do you want to add more discounts to this Pizza? Enter y/n?");
			addDiscounts = reader.readLine();
		}

		return ret;
	}

	public static void viewDiscounts() throws SQLException, IOException {
		/*
		 * Simply print out all of the customers from the database.
		 */
		ArrayList<Discount> discountList = DBNinja.getDiscountList();
		for (int i = 0; i < discountList.size(); i++) {
			Discount d = discountList.get(i);
			System.out.println(d.toString());
		}
	}

	public static void PrintReports() throws SQLException, NumberFormatException, IOException {
		/*
		 * This method asks the use which report they want to see and calls the DBNinja
		 * method to print the appropriate report.
		 *
		 */

		// User Input Prompts...
		System.out.println(
				"Which report do you wish to print? Enter\n(a) ToppingPopularity\n(b) ProfitByPizza\n(c) ProfitByOrderType:");
		String whichReport = reader.readLine();

		if (whichReport.equals("a")) {
			DBNinja.printToppingPopReport();
		} else if (whichReport.equals("b")) {
			DBNinja.printProfitByPizzaReport();
		} else if (whichReport.equals("c")) {
			DBNinja.printProfitByOrderType();
		} else {
			System.out.println("I don't understand that input... returning to menu...");
		}

	}

	// Prompt - NO CODE SHOULD TAKE PLACE BELOW THIS LINE
	// DO NOT EDIT ANYTHING BELOW HERE, THIS IS NEEDED TESTING.
	// IF YOU EDIT SOMETHING BELOW, IT BREAKS THE AUTOGRADER WHICH MEANS YOUR GRADE
	// WILL BE A 0 (zero)!!

	public static void PrintMenu() {
		System.out.println("\n\nPlease enter a menu option:");
		System.out.println("1. Enter a new order");
		System.out.println("2. View Customers ");
		System.out.println("3. Enter a new Customer ");
		System.out.println("4. View orders");
		System.out.println("5. Mark an order as completed");
		System.out.println("6. View Inventory Levels");
		System.out.println("7. Add Inventory");
		System.out.println("8. View Reports");
		System.out.println("9. Exit\n\n");
		System.out.println("Enter your option: ");
	}

	/*
	 * autograder controls....do not modiify!
	 */

	public final static String autograder_seed = "6f1b7ea9aac470402d48f7916ea6a010";

	private static void autograder_compilation_check() {

		try {
			Order o = null;
			Pizza p = null;
			Topping t = null;
			Discount d = null;
			Customer c = null;
			ArrayList<Order> alo = null;
			ArrayList<Discount> ald = null;
			ArrayList<Customer> alc = null;
			ArrayList<Topping> alt = null;
			double v = 0.0;
			String s = "";

			DBNinja.addOrder(o);
			DBNinja.addPizza(p);
			DBNinja.useTopping(p, t, false);
			DBNinja.usePizzaDiscount(p, d);
			DBNinja.useOrderDiscount(o, d);
			DBNinja.addCustomer(c);
			DBNinja.completeOrder(o);
			alo = DBNinja.getOrders(false);
			o = DBNinja.getLastOrder();
			alo = DBNinja.getOrdersByDate("01/01/1999");
			ald = DBNinja.getDiscountList();
			d = DBNinja.findDiscountByName("Discount");
			alc = DBNinja.getCustomerList();
			c = DBNinja.findCustomerByPhone("0000000000");
			alt = DBNinja.getToppingList();
			t = DBNinja.findToppingByName("Topping");
			DBNinja.addToInventory(t, 1000.0);
			v = DBNinja.getBaseCustPrice("size", "crust");
			v = DBNinja.getBaseBusPrice("size", "crust");
			DBNinja.printInventory();
			DBNinja.printToppingPopReport();
			DBNinja.printProfitByPizzaReport();
			DBNinja.printProfitByOrderType();
			s = DBNinja.getCustomerName(0);
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}

}
