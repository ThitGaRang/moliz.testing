--Scenarios---------------------------------------------------------------------

activity scenario1 : int { // login successful
	setupCustomers;
	ApplicationController ctrl = setupServices;
	int sessionId = ctrl.login("liz", "liz")
	return sessionId;
}

activity scenario2 : int { // login unsuccessful
	setupCustomers;
	ApplicationController ctrl = setupServices;
	int sessionId = ctrl.login("liz", "123")
	return sessionId;
}

activity scenario3 : Item[*] { // retrieves 1 item
	setupItems;
	ApplicationController ctrl = setupServices;
	Item[*] items = ctrl.findItem("Poodle");
	return items;
}

activity scenario4 : Item[*] { // retrieves 2 items
	setupItems;
	ApplicationController ctrl = setupServices;
	Item[*] items = ctrl.findItem("Bulldog");
	return items;
}

activity scenario5 : Item[*] { // retrieves 0 items
	setupItems;
	ApplicationController ctrl = setupServices;
	Item[*] items = ctrl.findItem("Dalmation");
	return items;
}

activity scenario6 : ApplicationController, sessionId { // login, find item, add 3 items to cart
	setupCustomers;
	setupItems2;
	ApplicationController ctrl = setupServices;
	int sessionId = ctrl.login("liz", "liz");
	addItemToCart(ctrl, sessionId, "Bulldog");
	addItemToCart(ctrl, sessionId, "Bulldog");
	addItemToCart(ctrl, sessionId, "Poodle");
	return ctrl, sessionId;
}

activity addItemToCart (ApplicationContoller ctrl, int sessionId, String itemName) {
	Item item = ctrl.findItem(itemName);
	ctrl.addItemToCart(sessionId, item);
}

activity scenario7 { // login, find item, add 3 items to cart, confirm order
	int sessionId, ApplicationController ctrl = scenario6;
	Order order = ctrl.confirmOrder(sessionId);
	return order;
}

activity buyScenario { // login, find item, add item to cart, confirm order
	setupCustomers;
	setupItems;
	ApplicationContoller ctrl = setupServices;
	int sessionId = ctrl.login("liz","liz");
	Item item = ctrl.findItem("Poodle");
	ctrl.addItemToCart(sessionId, item);
	ctrl.confirmOrder(sessionId)
}

activity errorLoginScenario { // login unsuccessful
	setupCustomers;
	ApplicationContoller ctrl = setupServices;
	ctrl.login("wrong","password");
}

activity loginScenario : int {
	setupCustomers;
	setupItems;
	ApplicationContoller ctrl = setupServices;
	int sessionId = ctrl.login("liz","liz");
	return sessionId;
}

activity findItemScenario : Item[*] {
	setupCustomer;
	setupItems;
	ApplicationContoller ctrl = setupServices;
	Item item = ctrl.findItem("Poodle");
	return item;
}

--Setup---------------------------------------------------------------------

activity setupCustomers { // sets up 2 customers
	createCustomer(bill, bill);
	createCustomer(liz,liz);
}

activity createCustomer(String login, String password) : Customer {
	Customer customer = new Customer();
	customer.login = login;
	customer.password = password
	return Customer
}

activity setupServices : ApplicationContoller { // sets up services
	ApplicationController applicationController = new ApplicationContoller();
	CustomerService customerService = new CustomerService();
	CatalogService catalogService = new CatalogService();
	OrderService orderService = new OrderService();
	EntityManager entityManager = new EntityManager();
	
	applicationController.customerService = customerService;
	...
	return applicationController;
}

activity setupItems {
	Item item1 = createItem("Bulldog");
	Item item2 = createItem("Bulldog");
	Item item3 = createItem("Poodle");
}

activity setupItems2 {
	Item item1 = createItem("Bulldog");
	Item item2 = createItem("Poodle");
	Item item3 = createItem("Dalmatian");
}

activity createItem(String name) : Item {
	Item item  = new Item();
	item.name = name;
	return item;
}

--Services---------------------------------------------------------------------

class ApplicationContoller {
	private CustomerService customerService;
	private CatalogService catalogService;
	private OrderService orderService;
	
	private List<Session> sessions;
	
	private Integer lastSessionId;
	private Customer foundCustomer;

	public Integer login(String login, String password) {
**		Customer customer = self.customerService.login(login, password);
**		self.setFoundCustomer(customer):
		if (self.foundCustomer != null) 
**			Integer sessionId = self.createSession(self.foundCustomer);
			self.foundCustomer = null;
			return sessionId;
		} else {
			return -1;
		}
	}
	
	public Item findItem(String name) {
**		return self.catalogService.findItem(name);
	}
	
	public void addItemToCart(Integer sessionId, Item item) {
**		Customer customer = self.getCustomer(sessionId);
**		self.orderService.addItemToCart(customer, sessionId);
	}
	
	public Order confirmOrder(Integer sessionId) {
**		Customer customer = self.getCustomer(sessionId);
**		return self.orderService.confirmOrder(customer);
	}
	
	private Integer createSession(Customer customer) {
		Session session = new Session();
		session.customer = customer;
**		session.sessionId = self.createSessionId();
		self.sessions.add(session);
		return session.sessionId;
	}
	
	private Integer createSessionId() {
		self.lastSessionId += 1;
		return self.lastSessionId;
	}
	
	private void setFoundCustomer(Customer customer) {
		self.foundCustomer = customer;
	}
	
	private Customer getCustomer(Integer sessionId) {
		for (Session session : self.sessions) {
			if (session.sessionId == sessionId) {
				return session.customer;
			}
		}
		return null;
	}
}

class CustomerService {
	private EntityManager entityManager;
	
	public Customer login(String login, String password) {
**		return self.entityManager.findCustomer(login, password);
	}
}

class CatalogService {
	private EntityManager entityManager;
	
	public Item findItem(String name) {
**		List<Item> allItems = self.entityManager.findAllItems();
		List<Item> foundItems = new List<Item>();
		for (Item item : allItems) {
			if (item.name.equals(name)) {
				foundItems.add(item);
			}
		}
	}
}

class OrderService {
	private EntityManager entityManager;
	
	private CartItem foundCartItem;
	
	public void addItemToCart(Customer customer, Item item) {
**		Cart cart = self.getCart(customer);
**		CartItem cartItem = self.getCartItem(cart, item);
		cartItem.quantity += 1;		
**		self.entityManager.persist(cart);
	}
	
	public Order confirmOrder(Customer customer) {
		Order order = new Order();
		order.customer = customer;
		for (CartItem cartItem : customer.cart.cartItems) {
**			OrderLine orderLine = self.createOrderLine(cartItem);
			order.orderLines.add(orderLine);
			cartItem.destroy;
		}
**		self.entityManager.persist(order);
**		self.entityManager.delete(cart);
		cart.destroy;
	}
	private Cart getCart(Customer customer) {
		if (customer.cart == null) {
			customer.cart = new Cart();
		}
		return customer.cart;
	}
	private CartItem getCartItem(Cart cart, Item item) {
		CartItem matchingCartItem = null;
		if (cart.cartItems.size() == 0) {
			CartItem cartItem = new CartItem();
			cartItem.item = item;
			cartItem.quantity = 0;
			cart.cartItems.add(cartItem);
			matchingCartItem = cartItem;
		} else {
			List<CartItem> foundCartItems = new List<CartItem>()
			for (CartItem cartItem : cart.cartItems ) {
				if (cartItem.item.equals(item)) {
					foundCartItems.add(cartItem);
				}
			}
**			self.setFoundCartItem(foundCartItems.get(1));
			if (self.foundCartItem != null) {
				matchingCartItem = self.foundCartItem
				self.foundCartItem = null;
			} else {
				CartItem cartItem = new CartItem();
				cartItem.item = item;
				cartItem.quantity = 0;
				cart.cartItems.add(cartItem);
				matchingCartItem = cartItem;
			}
		}
		return matchingCartItem;
	}
	
	private void setFoundCartItem(CartItem cartItem) {
		self.foundCartItem = cartItem;
	}
	
	private OrderLine createOrderLine(Item item, Integer quantity) {
		OrderLine orderLine = new OrderLine();
		orderLine.item = item;
		orderLine.quantity = quantity;
		return orderLine;
	}
	private OrderLine createOrderLine(CartItem cartItem) {
**		return self.createOrderLine(cartItem.item, cartItem.quantity);
	}
}

class EntityManager {	
	public Customer findCustomer(String login, String password) {
		List<Customer> foundCustomer = new List<Customer>();
		for (Customer customer : readExtent(Cutomer.class)) {
**			if (self.checkCredentials(customer, login, password)) {
				foundCustomer.add(customer);
			}
		}
		return foundCustomer.get(1);
	}
	public List<Item> findAllItems() {
		return readExtent(Item.class);
	}
	private Boolean checkCredentials(Customer customer, String login, String password) {
		if (customer.login.equals(login)) {
			if (customer.password.equals(password)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}

