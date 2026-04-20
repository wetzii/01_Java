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
		
	}
}
