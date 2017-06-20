public class Concert {
	private String name;
	private int capacity;
	private int phoneSold = 0;
	private int venueSold = 0;
	private double phonePrice;
	private double venuePrice; 
	private boolean change = false;


	public Concert(String name, int capacity, double phone, double venue) {
		this.name = name;
		this.capacity = capacity;
		this.phonePrice = phone;
		this.venuePrice = venue;	
	}


	public void sale(int num) {
		for (int i = num; i > 0 && capacity > 0; i--) {
			if (!change) {
				phoneSold++;	
			} else {
				venueSold++;
			}
			capacity--;
		}
	}
	
	public int numSold() {
		return phoneSold + venueSold;
	}

	public int numRemaining() {
		return capacity;
	}
	
	public double revenue() {
		return (phoneSold * phonePrice) + (venueSold * venuePrice); 
	}

	// call change to switch to venue sales
	public void change(){
		this.change = true;
	}
	

	public static void main(String[] args) {
		Concert a = new Concert("Kanye", 10, 1, 2);
		System.out.println(a.numSold() + " tickets sold");
		System.out.println(a.numRemaining() + " tickets remaining");
		System.out.println("--------------------------");
		a.sale(5);	
		System.out.println(a.numSold() + " tickets sold");
		System.out.println(a.numRemaining() + " tickets remaining");
		System.out.println("--------------------------");
		a.change();
		a.sale(6);
		System.out.println(a.numSold() + " tickets sold");
		System.out.println(a.numRemaining() + " tickets remaining");
		System.out.println("--------------------------");
		System.out.println("$" + a.revenue() + " total revenue");
	}
}
