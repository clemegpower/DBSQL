

import java.io.IOException;
import java.sql.*;
import java.util.*;
import java.util.Date;

/*
 * This file is where most of your code changes will occur You will write the code to retrieve
 * information from the database, or save information to the database
 *
 * The class has several hard coded static variables used for the connection, you will need to
 * change those to your connection information
 *
 * This class also has static string variables for pickup, delivery and dine-in. If your database
 * stores the strings differently (i.e "pick-up" vs "pickup") changing these static variables will
 * ensure that the comparison is checking for the right string in other places in the program. You
 * will also need to use these strings if you store this as boolean fields or an integer.
 *
 *
 */

/**
 * A utility class to help add and retrieve information from the database
 */

public final class DBNinja {
	private static Connection conn;

	// Change these variables to however you record dine-in, pick-up and delivery,
	// and sizes and crusts
	public final static String pickup = "pickup";
	public final static String delivery = "delivery";
	public final static String dine_in = "dinein";

	public final static String size_s = "Small";
	public final static String size_m = "Medium";
	public final static String size_l = "Large";
	public final static String size_xl = "XLarge";

	public final static String crust_thin = "Thin";
	public final static String crust_orig = "Original";
	public final static String crust_pan = "Pan";
	public final static String crust_gf = "Gluten-Free";

	private static boolean connect_to_db() throws SQLException, IOException {

		try {
			conn = DBConnector.make_connection();
			return true;
		} catch (SQLException e) {
			return false;
		} catch (IOException e) {
			return false;
		}

	}

	public static void addOrder(Order o) throws SQLException, IOException {
		connect_to_db();
		/*
		 * add code to add the order to the DB. Remember that we're not just
		 * adding the order to the order DB table, but we're also recording
		 * the necessary data for the delivery, dinein, and pickup tables
		 *
		 */

		if (o instanceof DineinOrder) {

		} else if (o instanceof DeliveryOrder) {

		} else if (o instanceof PickupOrder) {

		} else {
			System.err.println("Error in 'addOrder': variable 'o' has invalid order type");
			return;
		}

		// DO NOT FORGET TO CLOSE YOUR CONNECTION
		conn.close();
	}

	public static void addPizza(Pizza p) throws SQLException, IOException {
		connect_to_db();
		/*
		 * Add the code needed to insert the pizza into into the database.
		 * Keep in mind adding pizza discounts and toppings associated with the pizza,
		 * there are other methods below that may help with that process.
		 *
		 */

		// DO NOT FORGET TO CLOSE YOUR CONNECTION
		conn.close();
	}

	public static void useTopping(Pizza p, Topping t, boolean isDoubled) throws SQLException, IOException // this method
	// will
	// update
	// toppings
	// inventory
	// in SQL
	// and add
	// entities
	// to the
	// Pizzatops
	// table.
	// Pass in
	// the p
	// pizza
	// that is
	// using t
	// topping
	{
		connect_to_db();
		/*
		 * This method should do 2 two things.
		 * - update the topping inventory every time we use t topping (accounting for
		 * extra toppings as well)
		 * - connect the topping to the pizza
		 * What that means will be specific to your yimplementatinon.
		 *
		 * Ideally, you should't let toppings go negative....but this should be dealt
		 * with BEFORE calling this method.
		 *
		 */

		// DO NOT FORGET TO CLOSE YOUR CONNECTION
		conn.close();
	}

	public static void usePizzaDiscount(Pizza p, Discount d) throws SQLException, IOException {
		connect_to_db();
		/*
		 * This method connects a discount with a Pizza in the database.
		 *
		 * What that means will be specific to your implementatinon.
		 */

		// DO NOT FORGET TO CLOSE YOUR CONNECTION
		conn.close();
	}

	public static void useOrderDiscount(Order o, Discount d) throws SQLException, IOException {
		connect_to_db();
		/*
		 * This method connects a discount with an order in the database
		 *
		 * You might use this, you might not depending on where / how to want to update
		 * this information in the dabast
		 */

		// DO NOT FORGET TO CLOSE YOUR CONNECTION
		conn.close();
	}

	public static void addCustomer(Customer c) throws SQLException, IOException {
		connect_to_db();
		/*
		 * This method adds a new customer to the database.
		 *
		 */

		// DO NOT FORGET TO CLOSE YOUR CONNECTION
		conn.close();
	}

	public static void completeOrder(Order o) throws SQLException, IOException {
		connect_to_db();
		/*
		 * Find the specifed order in the database and mark that order as complete in
		 * the database.
		 *
		 */
		int id_num = o.getOrderID();
		String query = "update orderinfo set isCompleted = true where OrderInfoId = ?;";
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setInt(1, id_num);
		ResultSet rset = stmt.executeQuery(query);

		// DO NOT FORGET TO CLOSE YOUR CONNECTION
		conn.close();
	}

	public static ArrayList<Order> getOrders(boolean openOnly) throws SQLException, IOException {
		connect_to_db();
		/*
		 * Return an arraylist of all of the orders.
		 * openOnly == true => only return a list of open (ie orders that have not been
		 * marked as completed)
		 * == false => return a list of all the orders in the database
		 * Remember that in Java, we account for supertypes and subtypes
		 * which means that when we create an arrayList of orders, that really
		 * means we have an arrayList of dineinOrders, deliveryOrders, and pickupOrders.
		 *
		 * Don't forget to order the data coming from the database appropriately.
		 *
		 */

		//here's my first attempt of the code
//		ArrayList<Order> orderList = new ArrayList<Order>();
//		Statement stmt = conn.createStatement();
//		if (openOnly) {
//			String query = "SELECT * FROM orderinfo WHERE isCompleted == 1";
//			ResultSet rset = stmt.executeQuery(query);
//
//			while (rset.next()) {
//
//				Order newOrder = new Order(
//						rset.getInt("OrderInfoId"),
//
//			}
//		}
//		else {
//			String query = "Select * from orderinfo";
//		}
		//orderList.add(newOrder);

		// DO NOT FORGET TO CLOSE YOUR CONNECTION
		conn.close();
		return null;
	}

	public static Order getLastOrder() {
		/*
		 * Query the database for the LAST order added
		 * then return an Order object for that order.
		 * NOTE...there should ALWAYS be a "last order"!
		 */



		return null;
	}

	public static ArrayList<Order> getOrdersByDate(String date) {
		/*
		 * Query the database for ALL the orders placed on a specific date
		 * and return a list of those orders.
		 *
		 */

		return null;
	}

	public static ArrayList<Discount> getDiscountList() throws SQLException, IOException {
		connect_to_db();
		/*
		 * Query the database for all the available discounts and
		 * return them in an arrayList of discounts.
		 *
		 */
		ArrayList<Discount> discountList = new ArrayList<Discount>();
		String query = "SELECT * FROM discount";
		Statement stmt = conn.createStatement();
		ResultSet rset = stmt.executeQuery(query);

		while (rset.next()) {
			Double amount = rset.getDouble("DiscountPercent");

			if (amount == 0.0){
				amount = rset.getDouble("DiscountDollarAmt");
			}

			Discount newDiscount = new Discount(
					rset.getInt("DiscountId"),
					rset.getString("DiscountName"),
					amount,
					(rset.getDouble("DiscountPercent") != 0.0));

			discountList.add(newDiscount);
		}

		// DO NOT FORGET TO CLOSE YOUR CONNECTION
		conn.close();
		return discountList;
	}

	public static Discount findDiscountByName(String name) {
		/*
		 * Query the database for a discount using it's name.
		 * If found, then return an OrderDiscount object for the discount.
		 * If it's not found....then return null
		 *
		 */

		return null;
	}

	public static ArrayList<Customer> getCustomerList() throws SQLException, IOException {
		connect_to_db();
		/*
		 * Query the data for all the customers and return an arrayList of all the
		 * customers.
		 * Don't forget to order the data coming from the database appropriately.
		 *
		 */

		ArrayList<Customer> customerList = new ArrayList<Customer>();

		String query = "SELECT * FROM customer;";
		Statement stmt = conn.createStatement();
		ResultSet rset = stmt.executeQuery(query);

		while (rset.next()) {
			Customer newCustomer = new Customer(
					rset.getInt("CustomerId"),
					rset.getString("CustomerFName"),
					rset.getString("CustomerLName"),
					rset.getString("CustomerPhone"));

			customerList.add(newCustomer);
		}

		// DO NOT FORGET TO CLOSE YOUR CONNECTION
		conn.close();
		return customerList;
	}

	public static Customer findCustomerByPhone(String phoneNumber) {
		/*
		 * Query the database for a customer using a phone number.
		 * If found, then return a Customer object for the customer.
		 * If it's not found....then return null
		 *
		 */



		return null;
	}

	public static ArrayList<Topping> getToppingList() throws SQLException, IOException {
		connect_to_db();
		/*
		 * Query the database for the aviable toppings and
		 * return an arrayList of all the available toppings.
		 * Don't forget to order the data coming from the database appropriately.
		 *
		 */
		ArrayList<Topping> toppingList = new ArrayList<Topping>();

		String query = "SELECT * FROM topping";
		Statement stmt = conn.createStatement();
		ResultSet rset = stmt.executeQuery(query);

		while (rset.next()) {
			int toppingId = rset.getInt("ToppingId");
			String toppingName = rset.getString("ToppingName");
			double pricePer = rset.getDouble("ToppingPricePer");
			double costPer = rset.getDouble("ToppingCostPer");
			int currInventory = rset.getInt("ToppingCurrentInventory");
			int minInventory = rset.getInt("ToppingMinInventory");
			int unitsSmall = rset.getInt("ToppingUnitsSmall");
			int unitsMed = rset.getInt("ToppingUnitsMedium");
			int unitsLarge = rset.getInt("ToppingUnitsLarge");
			int unitsXL = rset.getInt("ToppingUnitsXLarge");

			Topping newTopping = new Topping(toppingId, toppingName, unitsSmall, unitsMed, unitsLarge, unitsXL,
					pricePer, costPer, minInventory, currInventory);
			toppingList.add(newTopping);
		}

		// DO NOT FORGET TO CLOSE YOUR CONNECTION
		conn.close();
		return toppingList;
	}

	public static Topping findToppingByName(String name) {
		/*
		 * Query the database for the topping using it's name.
		 * If found, then return a Topping object for the topping.
		 * If it's not found....then return null
		 *
		 */

		return null;
	}

	public static void addToInventory(Topping t, double quantity) throws SQLException, IOException {
		connect_to_db();
		/*
		 * Updates the quantity of the topping in the database by the amount specified.
		 *
		 */
		int id_num = t.getTopID();
		String query = "update topping set ToppingCurrentInventory = ToppingCurrentInventory + ? where ToppingId = ?;";
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setInt(2, id_num);
		stmt.setDouble(1, quantity);
		stmt.executeUpdate();

		// DO NOT FORGET TO CLOSE YOUR CONNECTION
		conn.close();
	}


	public static double getBaseCustPrice(String size, String crust) throws SQLException, IOException {
		connect_to_db();
		/*
		 * Query the database fro the base customer price for that size and crust pizza.
		 *
		 */
		double baseCustPrice = 0.0;

		PreparedStatement os;
		ResultSet rset;
		String query;
		query = "SELECT BasePrice FROM base WHERE BasePizzaSize=? AND BaseCrustType=?;";
		os = conn.prepareStatement(query);
		os.setString(1, size);
		os.setString(2, crust);
		rset = os.executeQuery();

		rset.next();
		baseCustPrice = rset.getDouble("BasePrice");

		// DO NOT FORGET TO CLOSE YOUR CONNECTION
		conn.close();
		return baseCustPrice;
	}

	public static double getBaseBusPrice(String size, String crust) throws SQLException, IOException {
		connect_to_db();
		/*
		 * Query the database fro the base business price for that size and crust pizza.
		 *
		 */

		double baseBusPrice = 0.0;

		PreparedStatement os;
		ResultSet rset;
		String query;
		query = "SELECT BaseCost FROM base WHERE BasePizzaSize=? AND BaseCrustType=?;";
		os = conn.prepareStatement(query);
		os.setString(1, size);
		os.setString(2, crust);
		rset = os.executeQuery();

		rset.next();
		baseBusPrice = rset.getDouble("BaseCost");

		// DO NOT FORGET TO CLOSE YOUR CONNECTION
		conn.close();
		return baseBusPrice;
	}

	public static void printInventory() throws SQLException, IOException {
		connect_to_db();
		/*
		 * Queries the database and prints the current topping list with quantities.
		 *
		 * The result should be readable and sorted as indicated in the prompt.
		 *
		 */

		String query = "SELECT ToppingId, ToppingName, ToppingCurrentInventory FROM topping ORDER BY ToppingName;";
		Statement stmt = conn.createStatement();
		ResultSet rset = stmt.executeQuery(query);

		String formatString = "%-5s%-18s%-5s";
		System.out.println(String.format(formatString, "ID", "Name", "CurINVT"));
		while (rset.next()) {
			String toppingOutput = String.format(formatString, rset.getString(1), rset.getString(2),
					rset.getString(3));
			System.out.println(toppingOutput);
		}

		// DO NOT FORGET TO CLOSE YOUR CONNECTION
		conn.close();
	}

	public static void printToppingPopReport() throws SQLException, IOException {
		connect_to_db();
		/*
		 * Prints the ToppingPopularity view. Remember that this view
		 * needs to exist in your DB, so be sure you've run your createViews.sql
		 * files on your testing DB if you haven't already.
		 *
		 * The result should be readable and sorted as indicated in the prompt.
		 *
		 */

		String query = "SELECT * FROM ToppingPopularity";
		Statement stmt = conn.createStatement();
		ResultSet rset = stmt.executeQuery(query);
		String formatString = "%-18s%-5s";
		System.out.println((String.format(formatString, "Topping", "Topping Count")));
		while (rset.next()) {
			String name = rset.getString("ToppingName");
			Double count = rset.getDouble("ToppingCount");
			System.out.println((String.format(formatString, name, count)));
		}

		// DO NOT FORGET TO CLOSE YOUR CONNECTION
		conn.close();
	}

	public static void printProfitByPizzaReport() throws SQLException, IOException {
		connect_to_db();
		/*
		 * Prints the ProfitByPizza view. Remember that this view
		 * needs to exist in your DB, so be sure you've run your createViews.sql
		 * files on your testing DB if you haven't already.
		 *
		 * The result should be readable and sorted as indicated in the prompt.
		 *
		 */
		String query = "SELECT * FROM ProfitByPizza";
		Statement stmt = conn.createStatement();
		ResultSet rset = stmt.executeQuery(query);
		String formatString = "%-18s%-18s%-10s%-20s";
		System.out.println((String.format(formatString, "Pizza Size", "Pizza Crust", "Profit", "LastOrderDate")));
		while (rset.next()) {
			String crust = rset.getString("Crust");
			String type = rset.getString("Type");
			Double profit = rset.getDouble("Profit");
			String date = rset.getString("OrderMonth");
			System.out.println((String.format(formatString, crust, type, profit, date)));

		}

		// DO NOT FORGET TO CLOSE YOUR CONNECTION
		conn.close();
	}

	public static void printProfitByOrderType() throws SQLException, IOException {
		connect_to_db();
		/*
		 * Prints the ProfitByOrderType view. Remember that this view
		 * needs to exist in your DB, so be sure you've run your createViews.sql
		 * files on your testing DB if you haven't already.
		 *
		 * The result should be readable and sorted as indicated in the prompt.
		 *
		 */
		String query = "SELECT * FROM ProfitByOrderType";
		Statement stmt = conn.createStatement();
		ResultSet rset = stmt.executeQuery(query);
		String formatString = "%-18s%-18s%-18s%-18s%-10s";
		System.out.println(String.format(formatString, "Order Type", "Order Month", "TotalOrderPrice", "TotalOrderCost", "Profit"));
		while (rset.next()) {
			String type = rset.getString("customerType");
			String date = rset.getString("OrderMonth");
			Double price = rset.getDouble("TotalOrderPrice");
			Double cost = rset.getDouble("TotalOrderCost");
			Double profit = rset.getDouble("TotalProfit");
			if (type == null) {
				System.out.println(String.format(formatString, " ", date, price, cost, profit));
			}
			else {
				System.out.println(String.format(formatString, type, date, price, cost, profit));
			}
		}
		// DO NOT FORGET TO CLOSE YOUR CONNECTION
		conn.close();
	}

	public static String getCustomerName(int CustID) throws SQLException, IOException {
		/*
		 * This is a helper method to fetch and format the name of a customer
		 * based on a customer ID. This is an example of how to interact with
		 * your database from Java. It's used in the model solution for this
		 * project...so the code works!
		 *
		 * OF COURSE....this code would only work in your application if the table &
		 * field names match!
		 *
		 */

		connect_to_db();

		/*
		 * an example query using a constructed string...
		 * remember, this style of query construction could be subject to sql injection
		 * attacks!
		 *
		 */
		String cname1 = "";
		String query = "Select FName, LName From customer WHERE CustID=" + CustID + ";";
		Statement stmt = conn.createStatement();
		ResultSet rset = stmt.executeQuery(query);

		while (rset.next()) {
			cname1 = rset.getString(1) + " " + rset.getString(2);
		}

		/*
		 * an example of the same query using a prepared statement...
		 *
		 */
		String cname2 = "";
		PreparedStatement os;
		ResultSet rset2;
		String query2;
		query2 = "Select FName, LName From customer WHERE CustID=?;";
		os = conn.prepareStatement(query2);
		os.setInt(1, CustID);
		rset2 = os.executeQuery();
		while (rset2.next()) {
			cname2 = rset2.getString("FName") + " " + rset2.getString("LName"); // note the use of field names in the
			// getSting methods
		}

		conn.close();
		return cname1; // OR cname2
	}

	/*
	 * The next 3 private methods help get the individual components of a SQL
	 * datetime object.
	 * You're welcome to keep them or remove them.
	 */
	private static int getYear(String date)// assumes date format 'YYYY-MM-DD HH:mm:ss'
	{
		return Integer.parseInt(date.substring(0, 4));
	}

	private static int getMonth(String date)// assumes date format 'YYYY-MM-DD HH:mm:ss'
	{
		return Integer.parseInt(date.substring(5, 7));
	}

	private static int getDay(String date)// assumes date format 'YYYY-MM-DD HH:mm:ss'
	{
		return Integer.parseInt(date.substring(8, 10));
	}

	public static boolean checkDate(int year, int month, int day, String dateOfOrder) {
		if (getYear(dateOfOrder) > year)
			return true;
		else if (getYear(dateOfOrder) < year)
			return false;
		else {
			if (getMonth(dateOfOrder) > month)
				return true;
			else if (getMonth(dateOfOrder) < month)
				return false;
			else {
				if (getDay(dateOfOrder) >= day)
					return true;
				else
					return false;
			}
		}
	}

}