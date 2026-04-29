package bib;

import java.util.ArrayList;

public class RunCode {
	public static void main(String[] args) {
		
		ArrayList<Book> books = new ArrayList<Book>();
		books.add(new Book("Die Verwandlung", "Frank Kafka", 1890));
		books.add(new Book("Die Therapie", "Sebastian Fitzek", 2007));
		books.add(new Book("Der Inssase", "Sebastien Fitzek", 2015));
		books.add(new Book("Der Prozess", "Franz Kafka", 1898));
		books.add(new Book("Der Seelenbrecher", "Sebastian Fitzek", 2018));
		
		
		for(int i = 0;  i <  books.size(); i++ ) {
			System.out.println(books.get(i));	
		}
		
		
		
		//Überprüfen Ob es in der Liste ist
		System.out.println("Ist in der Liste vorhanden: " + books.contains(new Book("Die Verwandlung", "Frank Kafka", 1890)));
		
		//Löschen Wenn vorhanden 
		if(books.contains(new Book("Die Verwandlung", "Frank Kafka", 1890))) {
			books.remove(0);
		}
		//Liste wieder ausgeben
		System.out.println("---------------");
		for(Book b: books) {
			System.out.println(b);
		}
		int year = 2007;
		System.out.println("Bücher die nach "+ year+ "Veröffentlicht wurden");
		for(Book b: books) {
			System.out.println(b);
			
			if(b.getReleaseYear() > year) {
				System.out.println(b);
			}
		}
		//Titel Ändern 
		books.get(2).setTitle(books.get(2).getTitle() + " Sonderausgabe");
		
		// Weitere ArrayList Methoden ausprobieren
        System.out.println("\n--- ArrayList ---");
        System.out.println("Größe der Liste: " + books.size());
        System.out.println("Ist Index 2 leer? " + (books.get(2) == null));
        
        books.clear(); // alles löschen
        
        //LÖschen eines Elemntes mit FOR - SChleife
        
	}
	// Bei Array ist der Vorteil das der SPeicher besser verfügbar wird da die speicher addresen direkt hinterinander sind bei der Liste hat man den vorteil das man Felxibel ist das  

}
