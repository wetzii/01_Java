package streaming;

public class Song {
	private String title;
	private String artist;
	private String genre;
	
	public Song(String title, String artist, String genre) {
		this.title = title;
		this.artist = artist;
		this.genre = genre;
		
	}
	//Getter
	public String getTitle() {
		return title;
	}
	public String getArtist() { 
		return artist;
	}
	public String getGenre() {
		return genre;
	}
	
	//to String
	@Override
	public String toString() {
		return "Songname: " + title + "\nInterpret: " + artist + "\nGenre: " + genre ;
	}
}
