package mediathek;

public class Mediathek {
	public static void main(String[] args) {
		DigitalMedia[] digitalMedia =  createFilmGames();
		
	}
	public static DigitalMedia[] createFilmGames() {
		DigitalMedia[] digitalMedia = new DigitalMedia[5];
		
		digitalMedia[0] = new Film("Inception", "SciFi", 148, "Ein Dieb dringt in Traeume ein.");
        digitalMedia[1] = new Film("Interstellar", "SciFi", 169, "Astronauten reisen durch ein Wurmloch.");
        digitalMedia[2] = new Game("Zelda - Breath of the Wild", "Adventure", 3000, new String[]{"Nintendo Switch"});
        digitalMedia[3] = new Game("Elden Ring", "RPG", 3600, new String[]{"PC", "PS5"});
        digitalMedia[4] = new Film("The Dark Knight", "Action", 152, "Batman kaempft gegen den Joker.");
        return digitalMedia;
	}
	public static Newsletter[] createNews() {
		
		Newsletter[] newsletters = new Newsletter[3];
		newsletters[0] = new Newsletter("Tech Weekly", "Neue KI-Trends auf dem Vormarsch.", 1);
        newsletters[1] = new Newsletter("Gaming News", "Release des neuen Blockbusters steht bevor.", 2);
        newsletters[2] = new Newsletter("Science Journal", "Durchbruch in der Quantenphysik.", 3);
        return newsletters;
	}
}
