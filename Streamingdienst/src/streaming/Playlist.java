package streaming;

public class Playlist {
	private String name;
	private Song[] playlist;
	private int currentPosition;


	
	public Playlist(String name, int maxSongs) {
	    this.name = name;
	    this.playlist = new Song[maxSongs]; // ← WICHTIG
	    currentPosition = 0;
	}

	//Getter
	public String getName() {
		return name;
	}
	public Song[] getPlaylist() {
		return playlist;
	}
	public Song getSongAt(int index) {
		//Überprüfung im Player eibauen einbauen
		return playlist[index];
	}
	//SETTER
	public void insertSong(Song song) {
		playlist[currentPosition] = song;
		currentPosition++; 
	}
	//Playlist wird in Zufälliger Reihenfole gespielt
	public void playPlaylistStrict() {
	
		for (int i = 0; i < currentPosition; i++) {
			if (playlist[i] != null) {
			playlist[i].toString();
			}
		}
	}
	public void playPlaylistRand(Account acc) {
		boolean[] played = new boolean[currentPosition];
		int playedCount = 0;

		while (playedCount < currentPosition) { //plsyedCount ist da um zu checken das die Anzahl der Songs auch die Anzahl der gespielten Songs ist
		int randPos = (int) (Math.random() * currentPosition);     //Einfach dazu da Um die Random Stelle zu erzeugen

		 if (!played[randPos] && playlist[randPos] != null) { //Abfrage ob bei Played der Boolean frei ist und der Platz der Playlist eh nicht leer ist
		System.out.println(playlist[randPos]);
		played[randPos] = true;			//Wenn der SOng gespielt wurde bekommt er an die Position die er in der Playlist hat den Status True
		playedCount++;
			
		 
		   }
		}
	}
	public void printPosblSongs() {
		for(int i = 0; i < currentPosition; i++) {
			if (playlist[i] != null) {
			System.out.printf("(1) --> %s von %s \n", playlist[i].getTitle(), playlist[i].getArtist());
			}
		}
	}
	public void playSong (int songPosition) {
		if(playlist[songPosition] != null) {
			
			playlist[songPosition].toString();
		}
	}
}
