import java.util.*;

interface BusOperations{
	void addBus(Bus bus);
	void removeBus(int busId);
	Bus getBusDetails(int busid);
}

class BusManager implements BusOperations{
	private List<Bus> buses;
	
	public BusManager() {
		this.buses = new ArrayList<>();
	}
	
	@Override
	public void addBus(Bus bus) {
		buses.add(bus);
	}
	
	@Override
	public void removeBus(int busId) {
		buses.removeIf(bus -> bus.getId() == busId);
	}
	
	@Override
	public Bus getBusDetails(int busid) {
		for (Bus bus : buses) {
			if (bus.getId() == busid) { //using the bus class it will access the getRoute and using the eqal operation it will check wheater the list the route similar to the given parameter as route
				return bus;
			}
		}
		return null; //if no bus is found
	}
}

class Vehicle{
	private int id;
	private int capacity;
	
	public Vehicle(int id, int capacity) {
		this.id = id;
		this.capacity = capacity;
	}
	
	public int getId() {
		return id;
	}
	
	public int getCapacity() {
		return capacity;
	}
}

class Bus extends Vehicle{
	private String route;
	public Bus(int id, int capacity, String Route) {
		super(id, capacity);
		this.route = Route;
	}
	
	 public String getRoute() {
	        return route;
	    }
	
	public String PrintTableOfBus() {
		return "Bus Number: " + "G"+getId() + ", Capactiy: " + getCapacity() + ", Route: " + route;
	}
}


public class managment  {
	public static void main(String[] args) {
		BusManager manager = new BusManager();
		Scanner sc = new Scanner(System.in);
		System.out.println("Initializing....");
		System.out.println("1");
		System.out.println("2");
		System.out.println("3");
		System.out.println("------------- WELCOME TO BUS MANAGMENT SYSTEM -------------");
		System.out.println("Enter the number of Bus you want to add with thier bus Data.");
		for (int i = 1; i <= sc.nextInt(); i++) {
			System.out.println("Enter the Details ->");
			int busId = sc.nextInt();
			int Capacity = sc.nextInt();
			String Route = sc.nextLine();
			manager.addBus(new Bus(busId, Capacity, Route));
			System.out.println("DONE!");
		}
		
		System.out.println("Data Entry Succesfully Submited✅");
		System.out.println("Enter the Bus Number to find the detail [G(Bus number)]            NOTE: You don't have to type G");
		
		int busno = sc.nextInt();
		Bus bus = manager.getBusDetails(busno );
		if(bus != null) {
			System.out.println(bus.PrintTableOfBus());
		}else {
			System.out.println("Bus not found.");
		}
		
	}
}