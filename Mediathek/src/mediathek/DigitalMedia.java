package mediathek;

public class DigitalMedia {
	
	private String title;
	private String genre;
	private int[] ratingArray;
	private float avgRating;
	private int countRating;
	
	public DigitalMedia(String title, String genre) {
		this.title = title;
		this.genre = genre;
		avgRating = 0;
		countRating = 0;
		ratingArray = new int[5];
	}
	public void Rate(int rating) {
	if(countRating >= ratingArray.length) {
		throw new IllegalArgumentException("Kein Platz für weitere Bewertungen");
	}
	else if(rating < 0 || rating > 5  ) {
		throw new IllegalArgumentException("Die Bewertung muss zwischen 0 und 5 Sterne sein");
		}
	ratingArray[countRating] = rating;
	avgRating = calcAvgRating(ratingArray);
	}
	public float calcAvgRating(int[] nums) {
		//Achtung nicht wenn leer ist usste noch machen
		int sum = 0;
		for (int n: nums ) {
			sum += n;
		}
		return sum / countRating;
	}
}
