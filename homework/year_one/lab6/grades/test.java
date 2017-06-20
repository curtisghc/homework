public class test {

	int a = 4;
	int b = 4;
	int c = 4;
	int d = 4;
	int f = 4;

	public int sumGrades(){
		return a+b+c+d+f;
	}

	public int percent(char grade) {
		double count = grade;
		double sum = sumGrades();
		double precentage = count / sum;
		return percentage;
	}
	public static void main(String[] args) {




		System.out.println("0    10   20   30   40   50   60   70   80   90   100%");
		System.out.println("|    |    |    |    |    |    |    |    |    |    |");
		System.out.println("***************************************************");
		
		for (int i = 0; i < percent('a'); i += 2) {
			System.out.print("*");
		}
		System.out.println("A");
		System.out.println();

		for (int i = 0; i < b; i += 2) {
			System.out.print("*");
		}
		System.out.println("B");
		System.out.println();

		for (int i = 0; i < c; i += 2) {
			System.out.print("*");
		}
		System.out.println("C");
		System.out.println();

		for (int i = 0; i < d; i += 2) {
			System.out.print("*");
		}
		System.out.println("D");
		System.out.println();

		for (int i = 0; i < f; i += 2) {
			System.out.print("*");
		}
		System.out.println("F");
		System.out.println();
	}
}
