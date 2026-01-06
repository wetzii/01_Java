package streaming;


public class PremiumAccount extends Account {
	private Song favSong;
	private boolean favSongDef;
	private int favSongCount;
	
	public PremiumAccount(String username) { 
		super(username, 4);
		favSong = null;
		favSongDef = false;
		favSongCount = 0;
		setPremiumFetures(true);
	}
	public boolean getFavSongDev() {
		return favSongDef;
	}
	public Song getFavSong() {
		return favSong;
	}
	public int getFavSongCount(){
		return favSongCount;
	}
	public void setfavSong(Song favSong) {
		this.favSong = favSong;
	}
	
	
	public void playFavSong() {
		if (favSong != null) {
			playSong(favSong);
		}else {
			System.out.println("!---------------------------------------------------!");
			System.out.println("Dein Lieblingsong muss noch festgeleget werden!");
		}
	}
	@Override
	public void playSong(Song song){
		super.playSong(song);
		if (favSong != null && favSong.equals(song)){ //Not Null abfrage das es Stabiler läuft --> Ohne dem kommt bei manchen Situationen NullPointerExceptions
			favSongCount++;							// Problem, dabei ist wenn du Song in 2 verschiedenen Playlists hast erkennt er halt nur wenn es aus der selben ist
		}
	}
}