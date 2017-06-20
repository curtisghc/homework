package movie;
public class movieDriver {
	public static void main(String[] args) {

		Movie a = new Movie();
		a.setName("Godzilla");
		a.setRating("R");
		a.addReview(2);
		a.addReview(3);
		a.addReview(2);
		a.addReview(1);
		a.addReview(4);
		System.out.println("Name: " + a.getName());
		System.out.println("Rating: " + a.getRating());
		System.out.println("Average score: " + a.getAverage());
		

		Movie b = new Movie();
		b.setName("Ultraman");
		b.setRating("G");
		b.addReview(5);
		b.addReview(4);
		b.addReview(3);
		b.addReview(2);
		b.addReview(1);
		System.out.println("Name: " + b.getName());
		System.out.println("Rating: " + b.getRating());
		System.out.println("Average score: " + b.getAverage());
	}
}	
