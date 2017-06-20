public class digits {
	public static void main(String[] args) {
		int a;
		int b;
		int c;
		int d;
		boolean isAddress = false;

		for (int i = 1001; i < 10000; i += 2) {
			a = (i / 1000);
			b = (i % 1000) / 100;
			c = (i % 100) / 10;
			d = (i % 10); 
			if(a == (c * 3) && (a+b+c+d == 27)) {
				if(a!=b && a!=c && a!=d && b!=c && b!=d && c!=d){
					isAddress = true;
				} 
			}
			if(isAddress == true) {
				System.out.println(i);
				
			}
			isAddress = false;
		}
	}
}
