public class primegen {
	public static void main(String[] args) {
		int max = Integer.parseInt(args[0]);
		boolean isprime;
		for(int i = 1; i <= max; i++) {
			isprime = true;
			for(int j = 2; j <= Math.sqrt(i); j++) {
				if(i % j == 0){
					isprime = false;	
				}
			}
			if(isprime == true && i != 1) {
				System.out.println(i);
			}
		}
	}
}
