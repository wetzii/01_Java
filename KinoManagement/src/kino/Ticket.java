package kino;

public class Ticket {
	private Hall hall;
	private Film film;
	private int seatNr;
	private boolean valid;
	
	public Ticket(Hall hall, Film film, int seatNr, boolean valid) {
		this.hall = hall;
		this.film = film;
		this.seatNr = seatNr;
		this.valid = false;
	}
	public Hall getHall() {
		return hall;
	}
	public Film getFilm() {
		return film;
	}
	public int getSeatNr() {
		return seatNr;
	}
	public boolean getValid() {
		return valid;
	}
	public void setTicket(boolean b) {
		valid = b;
	}
	@Override
	public String toString() {
		return String.format("Hallennummer %d\nFilmnamme: %s\n Sitznummer: %d\nValides Ticket: %b\n", hall.getHallNr(), film.getTitle(), seatNr, valid);
	}
}
