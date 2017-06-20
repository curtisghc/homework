import java.util.Scanner;
public class diamond {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("How big do you want your diamond?");
		int na = kb.nextInt();
		int n = na - 1;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		for (int i = n; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}		
	}
}
