package cpsc4620;

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
		// enter into database
		String query1 = "insert into orderinfo (OrderInfoId, OrderInfoType, OrderInfoPrice, OrderInfoCost, OrderInfoTime, OrderInfoStatus) "
				+
				"values (?,?,?,?,?,?);";
		PreparedStatement order_conn = conn.prepareStatement(query1);
		order_conn.setInt(1, o.getOrderID());
		order_conn.setString(2, o.getOrderType());
		order_conn.setDouble(3, o.getCustPrice());
		order_conn.setDouble(4, o.getBusPrice());
		Date orderDate = new Date();
		o.setDate(orderDate.toString());
		java.sql.Timestamp timestamp = new java.sql.Timestamp(orderDate.getTime());
		order_conn.setTimestamp(5, timestamp);
		order_conn.setInt(6, o.getIsComplete());

		order_conn.executeUpdate();

		if (o instanceof DineinOrder) {
			System.out.println("Inserting into dine in...");
			String query = "insert into dinein (DineInOrderId, DineInTableNum) " +
					"values (?,?);";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1, o.getOrderID());
			stmt.setInt(2, ((DineinOrder) o).getTableNum());
			// NEED TO SET ORDER_ID LATER WHEN ORDER IS DONE???

			stmt.executeUpdate();
		} else if (o instanceof DeliveryOrder) {
			System.out.println("Inserting into delivery...");
			String query = "insert into delivery (DeliveryOrderId, DeliveryCustomerId) " +
					"values (?,?);";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1, o.getOrderID());
			stmt.setInt(2, o.getCustID());
			// NEED TO SET ORDER_ID LATER WHEN ORDER IS DONE???
			stmt.executeUpdate();

		} else if (o instanceof PickupOrder) {
			System.out.println("Inserting into pickup...");
			String query = "insert into pickup (PickupOrderId, PickupCustomerId, PickupIsPickedUp) " +
					"values (?,?,?);";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1, o.getOrderID());
			stmt.setInt(2, o.getCustID());
			stmt.setInt(3, ((PickupOrder) o).getIsPickedUp());
			// NEED TO SET ORDER_ID LATER WHEN ORDER IS DONE???
			stmt.executeUpdate();
		} else {
			System.err.println("Error in 'addOrder': variable 'o' has invalid order type");
			return;
		}

		// DO NOT FORGET TO CLOSE YOUR CONNECTION
		conn.close();
	}

	public static int get_next_Orderid() throws SQLException, IOException {
		connect_to_db();
		String query4 = "select max(OrderInfoId) from orderinfo;";
		PreparedStatement stmt = conn.prepareStatement(query4);
		ResultSet rset = stmt.executeQuery(query4);
		int id = 0;
		while (rset.next()) {
			id = rset.getInt("max(OrderInfoId)");
		}
		conn.close();
		return id + 1;
	}

	public static void addPizza(Pizza p) throws SQLException, IOException {
		connect_to_db();
		/*
		 * Add the code needed to insert the pizza into into the database.
		 * Keep in mind adding pizza discounts and toppings associated with the pizza,
		 * there are other methods below that may help with that process.
		 *
		 */

		// insert into pizza
		String query3 = "insert into pizza (PizzaCrustType, PizzaSize, PizzaState, PizzaBaseCost, PizzaBasePrice, PizzaOrderId) "
				+
				"values (?,?,?,?,?,?);";
		PreparedStatement stmt = conn.prepareStatement(query3);
		stmt.setString(1, p.getCrustType());
		stmt.setString(2, p.getSize());
		stmt.setString(3, p.getPizzaState());
		stmt.setDouble(4, p.getBusPrice());
		stmt.setDouble(5, p.getCustPrice());
		stmt.setInt(6, p.getOrderID());

		stmt.executeUpdate();

		// update ID of pizza
		String query4 = "select max(PizzaId) from pizza;";
		ResultSet rset = stmt.executeQuery(query4);
		while (rset.next()) {
			p.setPizzaID(rset.getInt("max(PizzaId)"));
		}

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
		String query1 = "insert into pizzatopping (PizzaToppingPizzaId, PizzaToppingToppingId, PizzaToppingQuantity) "
				+ "values (?,?,?);";
		PreparedStatement topconn = conn.prepareStatement(query1);
		if (isDoubled) {
			topconn.setInt(3, 2);
		} else {
			topconn.setInt(3, 1);
		}
		topconn.setInt(1, p.getPizzaID());
		topconn.setInt(2, t.getTopID());
		topconn.executeUpdate();

		String query2 = "update topping set ToppingCurrentInventory = ToppingCurrentInventory - ? where ToppingId = ?;";
		PreparedStatement updatetop = conn.prepareStatement(query2);
		double amountToUse = 0;
		switch (p.getSize()) {
			case DBNinja.size_s:
				amountToUse = t.getPerAMT();
				break;
			case DBNinja.size_m:
				amountToUse = t.getMedAMT();
				break;
			case DBNinja.size_l:
				amountToUse = t.getLgAMT();
				break;
			case DBNinja.size_xl:
				amountToUse = t.getXLAMT();
				break;
		}
		if (isDoubled) {
			amountToUse *= 2;
		}
		updatetop.setDouble(1, amountToUse);
		updatetop.setInt(2, t.getTopID());
		updatetop.executeUpdate();

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

		String query = "insert into pizzadiscount (PizzaDiscountPizzaId, PizzaDiscountDiscountId) values (?,?);";
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setInt(1, p.getPizzaID());
		stmt.setInt(2, d.getDiscountID());
		stmt.executeUpdate();

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

		String query = "insert into orderdiscount (OrderDiscountOrderId, OrderDiscountDiscountId) values (?,?);";
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setInt(1, o.getOrderID());
		stmt.setInt(2, d.getDiscountID());
		stmt.executeUpdate();

		// DO NOT FORGET TO CLOSE YOUR CONNECTION
		conn.close();
	}

	public static void addCustomer(Customer c) throws SQLException, IOException {
		connect_to_db();
		/*
		 * This method adds a new customer to the database.
		 *
		 */

		// String[] address = c.getAddress().split("/n");
		//
		// String street = address[0];
		// String city = address[1];
		// String state = address[2];
		// String zipCode = address[3];

		String query = "insert into customer (CustomerFName, CustomerLName, CustomerPhone) values (?, ?, ?);";
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setString(1, c.getFName());
		stmt.setString(2, c.getLName());
		stmt.setString(3, c.getPhone());
		stmt.executeUpdate();

		// DO NOT FORGET TO CLOSE YOUR CONNECTION
		conn.close();
	}

	public static void updateAddress(Customer c) throws SQLException, IOException {
		connect_to_db();
		/*
		 * This method adds a new customer to the database.
		 *
		 */

		String[] address = c.getAddress().split("/n");

		String street = address[0];
		String city = address[1];
		String state = address[2];
		String zipCode = address[3];

		String query = "update customer set CustomerStreet= ?, CustomerCity = ?, CustomerState = ?, CustomerZipCode= ? where CustomerId=?";
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setString(1, street);
		stmt.setString(2, city);
		stmt.setString(3, state);
		stmt.setString(4, zipCode);
		stmt.setInt(5, c.getCustID());
		stmt.executeUpdate();

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
		String query = "update orderinfo set OrderInfoStatus = true where OrderInfoId = ?;";
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setInt(1, id_num);
		stmt.executeUpdate();

		// DO NOT FORGET TO CLOSE YOUR CONNECTION
		conn.close();
	}

	public static ArrayList<Order> getClosedOrders() throws SQLException, IOException {
		ArrayList<Order> allOrder = getOrders(false);
		ArrayList<Order> orderList = new ArrayList<Order>();
		for (int i = 0; i < allOrder.size(); i++) {
			Order currOrder = allOrder.get(i);
			if (currOrder.getIsComplete() == 1) {
				orderList.add(currOrder);
			}
		}
		return orderList;
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

		// here's my first attempt of the code
		ArrayList<Order> orderList = new ArrayList<Order>();
		String query = "";
		if (openOnly == false) {
			query = "SELECT * FROM orderinfo " +
					"left join dinein on OrderInfoId=DineInOrderId " +
					"left join pickup on OrderInfoId=PickupOrderId " +
					"left join delivery on OrderInfoId=DeliveryOrderId " +
					"left join customer on DeliveryCustomerId=CustomerId;";
		} else {
			query = "SELECT * FROM orderinfo " +
					"left join dinein on OrderInfoId=DineInOrderId " +
					"left join pickup on OrderInfoId=PickupOrderId " +
					"left join delivery on OrderInfoId=DeliveryOrderId " +
					"left join customer on DeliveryCustomerId=CustomerId where OrderInfoStatus=0;";
		}
		Statement stmt = conn.createStatement();
		ResultSet rset = stmt.executeQuery(query);

		while (rset.next()) {
			// get basic order info
			Order newOrder = null;
			int orderId = rset.getInt("OrderInfoId");
			String orderType = rset.getString("OrderInfoType");
			double price = rset.getDouble("OrderInfoPrice");
			double cost = rset.getDouble("OrderInfoCost");
			String orderTime = rset.getString("OrderInfoTime");
			int isComplete = rset.getBoolean("OrderInfoStatus") ? 1 : 0;

			if (orderType.equals(pickup)) {
				int custId = rset.getInt("PickupCustomerId");
				int isPickedUp = rset.getBoolean("PickupIsPickedUp") ? 1 : 0;
				newOrder = new PickupOrder(orderId, custId, orderTime, price, cost, isPickedUp, isComplete);
			} else if (orderType.equals(delivery)) {
				int custId = rset.getInt("DeliveryCustomerId");
				String street = rset.getString("CustomerStreet");
				String city = rset.getString("CustomerCity");
				String state = rset.getString("CustomerState");
				String zipcode = rset.getString("CustomerZipcode");

				String address = street + " " + city + " " + state + " " + zipcode;

				newOrder = new DeliveryOrder(orderId, custId, orderTime, price, cost, isComplete, address);
			} else if (orderType.equals(dine_in)) {
				int tableNum = rset.getInt("DineinTableNum");
				newOrder = new DineinOrder(orderId, -1, orderTime, price, cost, isComplete, tableNum);
			}

			// Get pizzas for order
			PreparedStatement stmt2 = conn.prepareStatement("SELECT * FROM pizza WHERE PizzaOrderId = ?;");
			stmt2.setInt(1, orderId);
			ResultSet rset2 = stmt2.executeQuery();

			while (rset2.next()) {
				int pizzaId = rset2.getInt("PizzaId");
				String pizzaSize = rset2.getString("PizzaSize");
				String pizzaCrust = rset2.getString("PizzaCrustType");
				String pizzaState = rset2.getString("PizzaState");
				String pizzaDate = orderTime;
				double custPrice = rset2.getDouble("PizzaBasePrice");
				double busPrice = rset2.getDouble("PizzaBaseCost");
				Pizza newPizza = new Pizza(pizzaId, pizzaSize, pizzaCrust, orderId, pizzaState, pizzaDate, custPrice,
						busPrice);

				// get pizza disocunts
				PreparedStatement discountStmt = conn.prepareStatement(
						"SELECT * FROM pizzadiscount join discount on PizzaDiscountDiscountId=DiscountId having PizzaDiscountPizzaId = ?;");
				discountStmt.setInt(1, pizzaId);
				ResultSet discountRset = discountStmt.executeQuery();

				while (discountRset.next()) {
					int discountId = discountRset.getInt("DiscountId");
					String discountName = discountRset.getString("DiscountName");
					String discountType = discountRset.getString("DiscountType");
					double discountAmount = 0.0;
					boolean isPercent = false;
					if (discountType.equals("percent")) {
						isPercent = true;
						discountAmount = discountRset.getDouble("DiscountPercent");
					} else {
						discountAmount = discountRset.getDouble("DiscountDollarAmt");
					}

					Discount newDiscount = new Discount(discountId, discountName, discountAmount, isPercent);
					newPizza.addDiscounts(newDiscount);
				}

				newOrder.addPizza(newPizza);
			}

			// Get discounts
			PreparedStatement stmt3 = conn.prepareStatement("select * from orderdiscount " +
					"join discount on OrderDiscountDiscountId=DiscountId " +
					"having OrderDiscountOrderId=?;");
			stmt3.setInt(1, orderId);
			ResultSet rset3 = stmt3.executeQuery();

			while (rset3.next()) {
				int discountId = rset3.getInt("DiscountId");
				String discountName = rset3.getString("DiscountName");
				String discountType = rset3.getString("DiscountType");
				double discountAmount = 0.0;
				boolean isPercent = false;
				if (discountType.equals("percent")) {
					isPercent = true;
					discountAmount = rset3.getDouble("DiscountPercent");
				} else {
					discountAmount = rset3.getDouble("DiscountDollarAmt");
				}

				Discount newDiscount = new Discount(discountId, discountName, discountAmount, isPercent);
				newOrder.addDiscount(newDiscount);
			}

			// Add order to list of orders
			orderList.add(newOrder);
		}

		// DO NOT FORGET TO CLOSE YOUR CONNECTION
		conn.close();
		return orderList;
	}

	public static Order getLastOrder() throws SQLException, IOException {
		/*
		 * Query the database for the LAST order added
		 * then return an Order object for that order.
		 * NOTE...there should ALWAYS be a "last order"!
		 */

		ArrayList<Order> allOrders = getOrders(false);
		int lastId = 0;
		Order lastOrder = null;
		for (int i = 0; i < allOrders.size(); i++) {
			Order currOrder = allOrders.get(i);
			if (currOrder.getOrderID() > lastId) {
				lastId = currOrder.getOrderID();
				lastOrder = currOrder;
			}
		}

		return lastOrder;
	}

	public static ArrayList<Order> getOrdersByDate(String date) throws SQLException, IOException {
		/*
		 * Query the database for ALL the orders placed on a specific date
		 * and return a list of those orders.
		 *
		 */

		ArrayList<Order> allOrders = getOrders(false);
		ArrayList<Order> orderList = new ArrayList<Order>();

		for (int i = 0; i < allOrders.size(); i++) {
			Order currOrder = allOrders.get(i);
			String orderDate = currOrder.getDate().substring(0, 10);
			if (checkDate(getYear(date), getMonth(date), getDay(date), orderDate)) {
				orderList.add(currOrder);
			}
		}

		return orderList;
	}

	public static ArrayList<Discount> getDiscountList() throws SQLException, IOException {
		connect_to_db();
		/*
		 * Query the database for all the available discounts and
		 * return them in an arrayList of discounts.
		 *
		 */
		ArrayList<Discount> discountList = new ArrayList<Discount>();
		String query = "SELECT * FROM discount ORDER BY DiscountId;";
		Statement stmt = conn.createStatement();
		ResultSet rset = stmt.executeQuery(query);

		while (rset.next()) {
			Double amount = rset.getDouble("DiscountPercent");

			if (amount == 0.0) {
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

	public static Discount findDiscountByName(String name) throws SQLException, IOException {
		/*
		 * Query the database for a discount using it's name.
		 * If found, then return an OrderDiscount object for the discount.
		 * If it's not found....then return null
		 *
		 */
		connect_to_db();

		Discount newDiscount = null;

		String query = "select * from discount where DiscountName=?";
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setString(1, name);
		ResultSet rset = stmt.executeQuery();

		while (rset.next()) {
			int discountId = rset.getInt("DiscountId");
			String discountName = rset.getString("DiscountName");
			String discountType = rset.getString("DiscountType");
			double discountAmount = 0.0;
			boolean isPercent = false;
			if (discountType.equals("percent")) {
				isPercent = true;
				discountAmount = rset.getDouble("DiscountPercent");
			} else {
				discountAmount = rset.getDouble("DiscountDollarAmt");
			}

			newDiscount = new Discount(discountId, discountName, discountAmount, isPercent);
		}

		// DO NOT FORGET TO CLOSE YOUR CONNECTION
		conn.close();

		return newDiscount;
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

		String query = "SELECT * FROM customer ORDER BY CustomerLName, CustomerFName, CustomerPhone;";
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

	public static Customer findCustomerByPhone(String phoneNumber) throws SQLException, IOException {
		/*
		 * Query the database for a customer using a phone number.
		 * If found, then return a Customer object for the customer.
		 * If it's not found....then return null
		 *
		 */
		connect_to_db();

		Customer customer = null;

		String query = "SELECT * FROM customer where CustomerPhone = ?;";
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setString(1, phoneNumber);
		ResultSet rset = stmt.executeQuery();

		while (rset.next()) {
			customer = new Customer(rset.getInt("CustomerId"),
					rset.getString("CustomerFName"),
					rset.getString("CustomerLName"),
					rset.getString("CustomerPhone"));
		}

		// DO NOT FORGET TO CLOSE YOUR CONNECTION
		conn.close();

		return customer;
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

		String query = "SELECT * FROM topping;";
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
		stmt.setDouble(1, quantity);
		stmt.setInt(2, id_num);
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

		String query = "SELECT * FROM ToppingPopularity;";
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
		String query = "SELECT * FROM ProfitByPizza;";
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
		String query = "SELECT * FROM ProfitByOrderType;";
		Statement stmt = conn.createStatement();
		ResultSet rset = stmt.executeQuery(query);
		String formatString = "%-18s%-18s%-18s%-18s%-10s";
		System.out.println(String.format(formatString, "Order Type", "Order Month", "TotalOrderPrice", "TotalOrderCost",
				"Profit"));
		while (rset.next()) {
			String type = rset.getString("customerType");
			String date = rset.getString("OrderMonth");
			Double price = rset.getDouble("TotalOrderPrice");
			Double cost = rset.getDouble("TotalOrderCost");
			Double profit = rset.getDouble("TotalProfit");
			if (type == null) {
				System.out.println(String.format(formatString, " ", date, price, cost, profit));
			} else {
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
		// String cname1 = "";
		// String query = "Select FName, LName From customer WHERE CustID=" + CustID +
		// ";";
		// Statement stmt = conn.createStatement();
		// ResultSet rset = stmt.executeQuery(query);
		//
		// while (rset.next()) {
		// cname1 = rset.getString(1) + " " + rset.getString(2);
		// }

		/*
		 * an example of the same query using a prepared statement...
		 *
		 */
		String cname2 = "";
		PreparedStatement os;
		ResultSet rset2;
		String query2;
		query2 = "Select CustomerFName, CustomerLName From customer WHERE CustomerId=?;";
		os = conn.prepareStatement(query2);
		os.setInt(1, CustID);
		rset2 = os.executeQuery();
		while (rset2.next()) {
			cname2 = rset2.getString("CustomerFName") + " " + rset2.getString("CustomerLName"); // note the use of field
			// names in the
			// getSting methods
		}

		conn.close();
		return cname2; // OR cname2
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
