package bib;


public class Book {
	private String title;
	private String writer;
	private int releaseYear;
	
	public Book(String title, String writer, int releaseYear) {
		this.title = title;
		this.writer = writer;
		this.releaseYear = releaseYear;
	}
	//GETTER
	
	public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public int getReleaseYear() { return releaseYear; }
    
    @Override
    public String toString() {
        return "Titel: " + title + ", Autor: " + writer + ", Erscheinungsjahr: " + releaseYear;
    }
	
    @Override
	    public boolean equals(Object other) {
	        if (other == this) return true;
	        if (other == null) return false;
	        if (other.getClass() != this.getClass()) return false;

	        Book otherObjCartoon = (Book) other;

	        return otherObjCartoon.title.equals(this.title) && 
	               otherObjCartoon.writer.equals(this.writer) && 
	               otherObjCartoon.releaseYear == this.releaseYear;
    }
}
