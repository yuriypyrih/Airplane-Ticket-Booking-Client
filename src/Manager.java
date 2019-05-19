import java.util.LinkedList;

public class Manager {

	private static LinkedList<Flight> flight_list = new LinkedList<Flight>();
	
	public Manager() {
		
	}
	
	public void addObject(Flight flight) {
		
		System.out.println(flight + " object has been added");
	this.flight_list.add(flight);
	
	
	}
	
	public void removeObject(Flight flight) {
		
		System.out.println(flight + " object has been removed");
	this.flight_list.remove(flight);
	
	}
	
	public LinkedList<Flight> get_flightList(){
		return flight_list;
	}
	
	public void set_flightList( LinkedList<Flight> flight_list) {
		this.flight_list = flight_list;
	}
	
}
