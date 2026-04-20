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
		
		Book duplicate = new Book("Die Verwandlung", "Frank Kafka", 1890);
		
		//Überprüfen Ob es in der Liste ist
		System.out.println("Ist in der Liste vorhanden: " + books.equals(duplicate));
		
		//Löschen Wenn vorhanden 
		if(books.equals(duplicate)) {
			books.remove(books);
		}
		//Liste wieder ausgeben
		System.out.println("---------------");
		for(Book b: books) {
			System.out.println(b);
		}
		int year = 2007;
		System.out.println("Bücher die nach "+year+ "Veröffentlicht wurden");
		for(Book b: books) {
			System.out.println(b);
			if(b.getReleaseYear() > year) {
				System.out.println(b);
			}
		}
		//Titel Ändern 
		books.get(2).setTitle(books.get(2).getTitle() + " Sonderausgabe");
	}

}
