import java.util.Scanner;
public class ball {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter your initial velocity");

		int v = kb.nextInt();
		int h = 0;
		int b = 0;
		int t = 0;
	
		while(b < 5) {
			h+= v;
			v -= 32;
			if(h < 0) {
				System.out.println("Bounce!");
				b++;	
				h *= -0.5;
				v *= -0.5;
			}	
			t++;
			System.out.println("Time: " + t + " Height: " + h);
		}
	}
}
