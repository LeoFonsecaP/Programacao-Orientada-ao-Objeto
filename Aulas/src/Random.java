
public class Random {

	private long p = 2147483648l;
	private long m = 843314861;
	private long a = 453816693;
	
	private long xi = 1023;
	

	
	public Random(int seed) {
		xi = seed;
	}

	public double getRand() {
		double rand;
		xi = (a+(m*xi))%p;
		rand = xi;
		return rand/p;
	}
	
	public int getintRand(int max) {
		double num = getRand();
		return (int) (num * max);
	}

}
