package grades;
public class Grades {

	private int a;
	private int b; 
	private int c; 
	private int d; 
	private int f; 
	
	public int getGrade(char grade) {
		switch (grade) {
			case 'a': return this.a;
			case 'b': return this.b;
			case 'c': return this.c;
			case 'd': return this.d;
			case 'f': return this.f;
			default: return 0;
		}
	}

	public void setGrade(char grade, int count) {
		switch (grade) {
			case 'a': this.a = count; 
						break;
			case 'b': this.b = count; 
						break;
			case 'c': this.c = count; 
						break;
			case 'd': this.d = count; 
						break;
			case 'f': this.f = count; 
						break;
			default: break;
		}
	}

	public int sumGrades() {
		int sum = a + b + c + d + f;
		return sum;
	}
	
	public double percent(char grade) {
		double count = 0;
		switch (grade) {
			case 'a': count = a;
						break;
			case 'b': count = b;
						break;
			case 'c': count = c;
						break;
			case 'd': count = d;
						break;
			case 'f': count = f;
						break;
			default: break;
		}
		double sum = a + b + c + d + f;
		double percent = count / sum;
		return percent;
	}
	
	public void graph() {
		System.out.println("0    10   20   30   40   50   60   70   80   90   100%");
		System.out.println("|    |    |    |    |    |    |    |    |    |    |");
		System.out.println("***************************************************");
		
		double ap = percent('a');
		double bp = percent('b');
		double cp = percent('c');
		double dp = percent('d');
		double fp = percent('f');
		
		for (int i = 0; i < ap * 100; i += 2) {
			System.out.print("*");
		}
		System.out.print(" A");
		System.out.println();

		for (int i = 0; i < bp * 100; i += 2) {
			System.out.print("*");
		}
		System.out.print(" B");
		System.out.println();

		for (int i = 0; i < cp * 100; i += 2) {
			System.out.print("*");
		}
		System.out.print(" C");
		System.out.println();

		for (int i = 0; i < dp * 100; i += 2) {
			System.out.print("*");
		}
		System.out.print(" D");
		System.out.println();

		for (int i = 0; i < fp * 100; i += 2) {
			System.out.print("*");
		}
		System.out.print(" F");
		System.out.println();
	}
}
