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
	public int getCurrenPos() {
		return currentPosition;
	}
	public int getPlaylistLen() {
		return playlist.length;
	}
	//SETTER
	public void insertSong(Song song) {
		playlist[currentPosition] = song;
		currentPosition++; 
	}
	//Playlist wird in Zufälliger Reihenfole gespielt
	public void playPlaylistStrict(Account acc)  {
	
		for (int i = 0; i < currentPosition;  i++) {
			if (playlist[i] != null) {
				acc.playSong(playlist[i]);
				
				}
			}
	}
		
	public void playPlaylistRand(Account acc) {
		boolean[] played = new boolean[currentPosition];
		int playedCount = 0;

		while (playedCount < currentPosition) { //plsyedCount ist da um zu checken das die Anzahl der Songs auch die Anzahl der gespielten Songs ist
		int randPos = (int) (Math.random() * currentPosition);     //Einfach dazu da Um die Random Stelle zu erzeugen

		 if (!played[randPos] && playlist[randPos] != null) { //Abfrage ob bei Played der Boolean frei ist und der Platz der Playlist eh nicht leer ist
			 acc.playSong(playlist[randPos]);
		played[randPos] = true;			//Wenn der SOng gespielt wurde bekommt er an die Position die er in der Playlist hat den Status True
		playedCount++;
		   }
		}
	}
	public void playSoloSong(Account acc, int i) {
		acc.playSong(getSongAt(i));
	}
	public void printPosblSongs() {
		for(int i = 0; i < currentPosition; i++) {
			if (playlist[i] != null) {
			System.out.printf("(i) --> %s von %s \n", playlist[i].getTitle(), playlist[i].getArtist());
			}
		}
	}
}
