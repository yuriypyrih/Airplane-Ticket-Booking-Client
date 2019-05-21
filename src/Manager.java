import java.rmi.RemoteException;
import java.util.LinkedList;

public class Manager {

	private LinkedList<Flight> flight_list = new LinkedList<Flight>();
	private FlightProcess look_op; 
	
	public Manager(FlightProcess look_op) {
		this.look_op = look_op;
	}
	
	
	
	public void sumbitFlight(String departureFrom,String arrivalAt,String departureDate,String returnlDate) {
		
		try {
			flight_list = look_op.searchFlight(departureFrom, arrivalAt, departureDate, returnlDate);
			System.out.println("Server returned " + flight_list.size() + " flights");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sumbitAllFlight() {
		try {
			flight_list = look_op.searchAll();
			System.out.println("Server returned " + flight_list.size() + " flights");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateList(int index) {
		try {
			look_op.updateList(flight_list.get(index), TYPE.BOOKED);
			
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addObject(Flight flight) {
		
		System.out.println(flight + " object has been added");
	this.flight_list.add(flight);
	
	
	}
	
	public void removeObject(Flight flight) {
		
		System.out.println(flight + " object has been removed");
	this.flight_list.remove(flight);
	
	}
	
	public LinkedList<Flight> get_all_flight_list(){
		sumbitAllFlight();
		return flight_list;
	}
	
	public LinkedList<Flight> get_flight_list(){
		return flight_list;
	}
	
	public void set_flightList( LinkedList<Flight> flight_list) {
		this.flight_list = flight_list;
	}
	
}
