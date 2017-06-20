package movie;
public class Movie {
	private String name;
	private String rating;
	private int one;
	private int two;
	private int three;
	private int four;
	private int five;
		
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}
	
	public void addReview(int stars) {
		if (stars <= 5 && stars >= 1) {
			switch (stars) {
				case 1: one++;
						break;
				case 2: two++;
						break;
				case 3: three++;
						break;
				case 4: four++;
						break;
				case 5: five++;
						break;
			}
		}
	}

	public double getAverage() {
		double placeholder = one + two*2 + three*3 + four*4 + five*5;  
		double sum = one + two + three + four + five;
		double average = placeholder / sum;
		return average;
	}                       
}                           
                           
