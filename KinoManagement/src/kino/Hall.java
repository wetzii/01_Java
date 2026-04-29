package kino;

import java.util.ArrayList;
import java.util.Iterator;

public class Hall {
	
	private int HallNr;
	private String name;
	private int capacity;
	private ArrayList<Film> films = new ArrayList<Film>();
	private ArrayList<Costumer> costumers = new ArrayList<Costumer>();
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
	public ArrayList<Costumer> getCostumers() {
		return costumers;
	}
	public void addCostumer(Costumer c) {
		if(c.hasTicket(this) && this.capacity >= costumers.size())
		costumers.add(c);
	}
	public void addFilm(Film f) {
		films.add(f);
	}
	public void removeFilm(String title) {
		Iterator<Film> it = films.iterator();
		int count = 0;
		while(it.hasNext()) {
			Film element = it.next();
			
			if(element.getTitle().equals(title));
			it.remove();
		}
	}
	public void showFilms() {
		for(Film f: films) {
			System.out.println(f);
		}
	}
	public void clearHall()
	{
		for(Costumer c: costumers) {
			costumers.getT
		}
	}
}
