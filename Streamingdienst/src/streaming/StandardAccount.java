package streaming;

public class StandardAccount extends Account {
	private String[] adMenu = new String[6];	
		
		public StandardAccount(String username) { 
			super(username,2 );
			
			adMenu[0] = "HTL-Leoben TOP WLAN";
			adMenu[1] = "DJ-Ötzi wieder auf Tour";
			adMenu[2] = "Du willst eine  Traum Reise komme zu Gabrial Pasternack travel";
			adMenu[3] = "Apple-Music besser wie dieser Player";
			adMenu[4] = "Byte-Bunker braucht dich als Mitarbeiter";
			adMenu[5] = "Interesiert an Kernspaltung? Komm zu Oakbridge Atomkraftwerk"
;			
		}


	@Override
			public void playSong(int playlistChoice, int son) {
			
			int i = (int) (Math.random()* 6);
			System.out.println(adMenu[i]);
			//Laut ChatGPT zwingt dich Java zur abfangen der Fehler bei Thread.sleep
			try {
			    Thread.sleep(30000); // 30 Sekunden Pause 
			} catch (InterruptedException e) {
			    System.out.println("Pause wurde Illegal übersprungen");
			}
			super.playSong(playlistChoice, son);
		}
	

}
