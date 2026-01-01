package streaming;

public class Song {
	private String title;
	private String artist;
	private String genre;
	private int playCounter; 
	
	public Song(String title, String artist, String genre) {
		this.title = title;
		this.artist = artist;
		this.genre = genre;
		playCounter = 0;
	}
	//Getter
	public String getTitle() {
		setPlayCountUp();
		return title;
	}
	public String getArtist() {
		setPlayCountUp();
		return artist;
	}
	public String getGenre() {
		setPlayCountUp();
		return genre;
	}
	public int getPlayCount() {
		return playCounter;
	}
	//Setter
	public void setPlayCountUp() {
		playCounter++;
	}
	//to String
	@Override
	public String toString() {
		return "Songname: " + title + "\nInterpret: " + artist + "Genre: " + genre ;
	}
}
