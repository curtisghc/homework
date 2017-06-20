package grades;
public class gradesDriver {
	public static void main(String[] args) {
		Grades a = new Grades();
		a.setGrade('a', 10);
		a.setGrade('b', 15);
		a.setGrade('c', 25);
		a.setGrade('d', 15);
		a.setGrade('f', 10);
		System.out.println(a.percent('a'));
		System.out.println(a.percent('b'));
		System.out.println(a.percent('c'));
		System.out.println(a.percent('d'));
		System.out.println(a.percent('f'));
		a.graph();
	}
}
