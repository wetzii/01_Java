package kino;

public class Film implements Comparable<Film>{

	private String title;
	private int fsk;
	private int year;
	private int minutes;
	
	public Film(String title, int fsk, int year, int minutes, Cinema cinema) {
		this.title = title;
		this.fsk = fsk;
		this.year = year;
		this.minutes = minutes;
		cinema.addFilm(this);
	}
	public String getTitle() {
		return title;
	}
	public int getFsk() {
		return fsk;
	}
	public int getYear() {
		return year;
	}
	public int getMinutes() {
		return minutes;
	}
	@Override
	public int compareTo(Film o) {
		return this.title.compareTo(o.title);
	}
	@Override
	public String toString() {
		return String.format("Titel: %s\nFsk: %d\nJahr: %d\nLänge: %d", title, fsk, year, minutes);
	}
}