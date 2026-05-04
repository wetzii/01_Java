package kino;

import java.util.ArrayList;
import java.util.Random;

public class Cinema {

	private String name;
	private String city;
	private ArrayList<Film> allFilms = new ArrayList<Film>();
	private ArrayList<Hall> availableHalls = new ArrayList<Hall>();
	private ArrayList<Hall> renovatedHalls = new ArrayList<Hall>();
	private ArrayList<Customer> registeredCustomers = new ArrayList<Customer>();

	public Cinema(String name, String city) {
		this.name = name;
		this.city = city;
	}

	public String getName() {
		return name;
	}
	public String getCity() {
		return city;
	}
	public ArrayList<Film> getAllFilms() {
		return allFilms;
	}
	public ArrayList<Hall> getAvailableHalls() {
		return availableHalls;
	}
	public ArrayList<Hall> getRenovatedHalls() {
		return renovatedHalls;
	}
	public ArrayList<Customer> getRegisteredCustomers() {
		return registeredCustomers;
	}

	public void addFilm(Film film) {
		allFilms.add(film);
	}

	public void addFilmToHall(String title, int hallNr) {
		Film film = findFilm(title);
		Hall hall = findHall(hallNr);
		if (film == null) throw new IllegalArgumentException("Film nicht gefunden: " + title);
		if (hall == null) throw new IllegalArgumentException("Saal nicht gefunden: " + hallNr);
		hall.addFilm(film);
	}

	public ArrayList<Hall> searchAllFilms(String title) {
		ArrayList<Hall> result = new ArrayList<Hall>();
		for (Hall h : availableHalls) {
			for (Film f : h.getFilms()) {
				if (f.getTitle().equals(title)) {
					result.add(h);
					break;
				}
			}
		}
		return result;
	}

	public void registerCustomer(Customer customer) {
		registeredCustomers.add(customer);
	}

	public void sellTicket(int customerNr, int hallNr, String title) {
		Customer customer = findCustomer(customerNr);
		Hall hall = findHall(hallNr);
		Film film = findFilm(title);
		
		if (customer == null) throw new IllegalArgumentException("Kunde nicht gefunden: " + customerNr);
		if (hall == null) throw new IllegalArgumentException("Saal nicht gefunden: " + hallNr);
		if (film == null) throw new IllegalArgumentException("Film nicht gefunden: " + title);
		if (customer.getTicket() != null && customer.getTicket().getValid()) throw new IllegalStateException("Kunde hat bereits ein gültiges Ticket.");
		
		int seatNr = hall.getCostumers().size() + 1;
		
		Ticket ticket = new Ticket(hall, film, seatNr, true);
		customer.setTicket(ticket);
	}

	public void renovateHall() {
		if (availableHalls.isEmpty()) throw new IllegalStateException("Keine verfügbaren Säle.");
		
		Random rand = new Random();
		int index = rand.nextInt(availableHalls.size());
		Hall hall = availableHalls.get(index);
		hall.getFilms().clear();
		hall.clearHall();
		renovatedHalls.add(hall);
		availableHalls.remove(index);
		System.out.println("Saal '" + hall.getName() + "' wird renoviert.");
	}

	public void finishHallRenovation() {
		if (renovatedHalls.isEmpty()) throw new IllegalStateException("Keine Säle in Renovierung.");
		
		Random rand = new Random();
		int index = rand.nextInt(renovatedHalls.size());
		Hall hall = renovatedHalls.get(index);
		
		availableHalls.add(hall);
		renovatedHalls.remove(index);
		System.out.println("Saal '" + hall.getName() + "' ist wieder verfügbar.");
	}

	public void showAllHalls() {
		System.out.println("=== Verfügbare Säle ===");
		
		for (Hall h : availableHalls) {
			System.out.printf("Saal %d: %s (Kapazität: %d, Besucher: %d)%n",
					h.getHallNr(), h.getName(), h.getCapacity(), h.getCostumers().size());
		}
		System.out.println("=== Säle in Renovierung ===");
		for (Hall h : renovatedHalls) {
			System.out.printf("Saal %d: %s%n", h.getHallNr(), h.getName());
		}
	}

	public Hall findHall(int hallNr) {
		for (Hall h : availableHalls) {
			if (h.getHallNr() == hallNr) return h;
		}
		return null;
	}

	private Film findFilm(String title) {
		for (Film f : allFilms) {
			if (f.getTitle().equals(title)) return f;
		}
		return null;
	}

	private Customer findCustomer(int customerNr) {
		for (Customer c : registeredCustomers) {
			if (c.getCustomerNr() == customerNr) return c;
		}
		return null;
	}
}