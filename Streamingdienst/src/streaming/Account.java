package streaming;

public class Account {
	private String username;
    private Playlist[] playlists;
    private int playlistCount;
    private int maxPlaylists;
    
    public Account(String username, int maxPlaylists) {
        this.playlists = new Playlist[maxPlaylists]; 
    	this.username = username;
    	playlistCount = 0;
    	this.maxPlaylists = maxPlaylists;  
    
    }
    public String getUsername() {
    	return username;
    }
    public Playlist[] getPlaylists() {
    	return playlists;	
    }
   public Playlist getPlaylitAt(int i) {
	   return playlists[i];
   }
   public int getPlaylistCount() {
	   return playlistCount;
   }
   public int getMaxPlaylists(){
	   return maxPlaylists;
   }
   public void addPlaylist(Playlist playlist, String name) {
	   if (playlistCount < maxPlaylists) {
    	   //An freier Array STelle die Playlist einfügen
           playlists[playlistCount] = playlist;
           //Anzahl der Arrays wir verändert damit ein User nicht unendlich haben kann
           playlistCount++;
           System.out.println("Playlist '" + playlist.getName() + "' wurde hinzugefügt.");
       } else {
           System.out.println("Maximale Anzahl an Playlists erreicht!");
       
       }
   }
   public void printPlaylists() {
	   System.out.println("Deine Playlists: ");
	   for (int i = 0; i < playlists.length; i++) {
		   if(playlists[i] != null) {
			   System.out.printf("%d. Playlist : %s\n", i, playlists[i].getName());
		   		}
	   }  
   }
   	public void playSong(int playlistChoice, int song) {
   		System.out.println("Song wird gespielt...");
   		if (playlists[playlistChoice] != null) {
   			playlists[playlistChoice].getSongAt(song).toString();
   		}
   		
   	}
}
