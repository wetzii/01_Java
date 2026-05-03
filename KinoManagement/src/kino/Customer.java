package kino;

import java.util.Objects;

public class Customer extends Person {

	private int costumerNr;
	private Ticket ticket;

	public Customer(String name, int age, int costumerNr, Ticket ticket) {
		super(name, age);
		this.costumerNr = costumerNr;
		this.ticket = ticket;
	}

	public int getCustomerNr() {
		return costumerNr;
	}
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	public boolean hasTicket(Hall hall) {
		if (ticket == null) return false;
		return ticket.getValid() && ticket.getHall().equals(hall);
	}
	@Override
	public String toString() {
		return super.toString() + String.format("Kundennummer: %d\n", costumerNr);
	}
	@Override
	public int hashCode() {
		return Objects.hash(costumerNr, ticket);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		Customer other = (Customer) obj;
		return costumerNr == other.costumerNr && Objects.equals(ticket, other.ticket);
	}
}