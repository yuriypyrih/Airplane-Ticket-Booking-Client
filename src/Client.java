
import java.rmi.*;
import java.net.MalformedURLException;

public class Client {
	
	public static final int WIDTH = 900, HEIGHT = WIDTH / 12 * 9; 
	
	public static void main(String[] args) {
		
		
		System.out.println("Client ready and running..");
		
		try {
			String name = "//localhost/FlightBooking";
			FlightProcess look_op = (FlightProcess)Naming.lookup(name);
			
			Manager manager = new Manager(look_op);
			new Window(WIDTH, HEIGHT,"Flight Booking Application", manager);
			
		
		}
		catch (NotBoundException ex) {
			ex.printStackTrace();
		} catch (MalformedURLException ex) {
			ex.printStackTrace();
		} catch (RemoteException ex) {
			ex.printStackTrace();
		}
		
		
	}
}
