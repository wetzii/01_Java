package kino;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class Hall {

	private int HallNr;
	private String name;
	private int capacity;
	private ArrayList<Film> films = new ArrayList<Film>();
	private ArrayList<Customer> costumers = new ArrayList<Customer>();

	public Hall(int hallNr, String name, int capacity, Cinema cinema) {
		this.HallNr = hallNr;
		this.name = name;
		this.capacity = capacity;
		cinema.getAvailableHalls().add(this);
	}

	public int getHallNr() {
		return HallNr;
	}
	public void setHallNr(int hallNr) {
		HallNr = hallNr;
	}
	public String getName() {
		return name;
	}
	public int getCapacity() {
		return capacity;
	}
	public ArrayList<Film> getFilms() {
		return films;
	}
	public ArrayList<Customer> getCostumers() {
		return costumers;
	}
	public void addCustomer(Customer c) {
		if (c.hasTicket(this) && costumers.size() < capacity)
			costumers.add(c);
	}
	public void addFilm(Film f) {
		films.add(f);
	}
	public void removeFilm(String title) {
		Iterator<Film> it = films.iterator();
		while (it.hasNext()) {
			Film element = it.next();
			if (element.getTitle().equals(title))
				it.remove();
		}
	}
	public void showFilms() {
		for (Film f : films) {
			System.out.println(f);
		}
	}
	public void sortFilms() {
		films.sort(Comparator.comparingInt(Film::getFsk));
	}
	public void clearHall() {
		for (Customer c : costumers) {
			c.getTicket().setTicket(false);
		}
		costumers.clear();
	}
}