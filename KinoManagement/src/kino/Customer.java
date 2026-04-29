package kino;

import java.util.Objects;

public class Customer extends Person {

	private int costumerNr;
	private Ticket ticket; 
	public Customer(String name, int age, int costumerNr, Ticket ticket ) {
		super(name,age);
		this.costumerNr = costumerNr;
		this.ticket = ticket;
	}
	
	public Ticket getTicket() {
		return ticket;
	}
	public boolean hasTicket(Hall hall) {
		
	return ticket.getValid() == true && ticket.getHall().equals(hall) ;	                                                      
	}
	@Override
	public String toString() {
		
		return super.toString() +String.format ("Kundennummer: %d\n", costumerNr);
	}
	@Override
	public int hashCode() {
		return Objects.hash(costumerNr, ticket);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Costumer other = (Costumer) obj;
		return costumerNr == other.costumerNr && Objects.equals(ticket, other.ticket);
		
	}
}
