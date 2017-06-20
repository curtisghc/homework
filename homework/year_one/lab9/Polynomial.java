public class Polynomial {
	
	public int degree;
	public double[] coefficients;
	
	public Polynomial(int max) {
		degree = max;
		coefficients = new double[max + 1];
		for(int i = 0; i < coefficients.length; i++) {
			coefficients[i] = 0;
		}
	}

	public void setConstant(int i, double value) {
		coefficients[i] = value;
	}
	
	public double evaluate(double x) {
		double sum = 0;
		int i = 0;
		for(double coefficient : coefficients) {
			sum += coefficient * Math.pow(x,i);
			i++;
		}
		return sum;
	}
		
	public static void main(String[] args) {
		Polynomial a = new Polynomial(3);
		a.setConstant(0, 3);
		a.setConstant(1, 5);
		a.setConstant(2, 0);
		a.setConstant(3, 2);
		double abc = a.evaluate(7);
		System.out.println(abc);
		
	}
}
