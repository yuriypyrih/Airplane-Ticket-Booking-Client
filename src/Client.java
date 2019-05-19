
import java.rmi.*;
import java.net.MalformedURLException;

public class Client {
	
	public static final int WIDTH = 900, HEIGHT = WIDTH / 12 * 9; 
	
	public static void main(String[] args) {
		
		Manager manager = new Manager();
		new Window(WIDTH, HEIGHT,"Flight Booking Application", manager);
		
		/*
		try {
			String name = "//localhost/PhoneDirectory";
			DirectoryOperations look_op = (DirectoryOperations)Naming.lookup(name);
			//Contact c = look_op.searchNumber("Pappas");
			//System.out.println(c.getName()+"->"+c.getNumber());
			look_op.insertContact("Papadopoulos", "Vathi", "2273054321");
			Contact c = look_op.searchNumber("Papadopoulos");
			System.out.println(c.getName()+"->"+c.getNumber());
		}
		catch (NotBoundException ex) {
			ex.printStackTrace();
		} catch (MalformedURLException ex) {
			ex.printStackTrace();
		} catch (RemoteException ex) {
			ex.printStackTrace();
		}
		
		*/
	}
}
