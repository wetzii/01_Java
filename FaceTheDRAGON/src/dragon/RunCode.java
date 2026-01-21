package dragon;

public class RunCode {
	public static void main(String[] args) {
		greeter();
	AbstractDragon[] dragons = {new ShyDragong("Matthi"), new GreedyDragon("Massong"), new ProudDragon("Nino")}; // Andeer Drachen nacher !
	ProudDragon dragon = new ProudDragon("Test");
	dragon.reactSing();
	}
	public static void greeter() {
		System.out.println("________ __________    _____    ________ ________    _______   \n"
				+ "\\______ \\\\______   \\  /  _  \\  /  _____/ \\_____  \\   \\      \\  \n"
				+ " |    |  \\|       _/ /  /_\\  \\/   \\  ___  /   |   \\  /   |   \\ \n"
				+ " |    `   \\    |   \\/    |    \\    \\_\\  \\/    |    \\/    |    \\\n"
				+ "/_______  /____|_  /\\____|__  /\\______  /\\_______  /\\____|__  /\n"
				+ "        \\/       \\/         \\/        \\/         \\/         \\/ ");
	}
}
