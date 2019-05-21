
import java.rmi.*;
import java.util.LinkedList;


public interface FlightProcess extends Remote {

	public LinkedList<Flight> searchFlight(String departureFrom, String arrivalAt, String departureDate, String returnlDate ) throws RemoteException;
	
	public LinkedList<Flight> searchAll() throws RemoteException;
	
	public void updateList(Flight flight, TYPE type) throws RemoteException;
	
 }