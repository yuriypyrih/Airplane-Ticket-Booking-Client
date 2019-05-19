
public class Flight {

	private TYPE type;
	
	private String date;
	private String time;
	private String departureFrom;
	private String arrivalAt;
	private String id;
	private String number_of_seat;
	private int ticket_price;
	
	public Flight( TYPE type, String date, String time, String departureFrom, String arrivalAt, String id, String number_of_seat, int ticket_price) {
		
		this.type = type;
		this.date = date;
		this.time = time;
		this.departureFrom = departureFrom;
		this.arrivalAt = arrivalAt;
		this.id = id;
		this.number_of_seat = number_of_seat;
		this.ticket_price = ticket_price;
	}
	
	public Object[] getObjectDataTable() {
		return new Object[] {
				type, id, departureFrom , arrivalAt, date, time, number_of_seat, ticket_price, "Book"
		};
	}

	public TYPE getType() {
		return type;
	}

	public void setType(TYPE type) {
		this.type = type;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDepartureFrom() {
		return departureFrom;
	}

	public void setDepartureFrom(String departureFrom) {
		this.departureFrom = departureFrom;
	}

	public String getArrivalAt() {
		return arrivalAt;
	}

	public void setArrivalAt(String arrivalAt) {
		this.arrivalAt = arrivalAt;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNumber_of_seat() {
		return number_of_seat;
	}

	public void setNumber_of_seat(String number_of_seat) {
		this.number_of_seat = number_of_seat;
	}

	public int getTicket_price() {
		return ticket_price;
	}

	public void setTicket_price(int ticket_price) {
		this.ticket_price = ticket_price;
	}
	
}