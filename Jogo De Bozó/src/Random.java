import java.util.Calendar;

//Classe que representa um n�mero aleat�rio
//Tem os m�todos getRand e getintRand
//Por: Leonardo Fonseca Pinheiro
public class Random {

	private long p = 2147483648l;
	private long m = 843314861;
	private long a = 453816693;
	
	private long xi;//Semente
	

	//Montador com semente escolhida pelo usu�rio
	public Random(long seed) {
		xi = seed;
	}
	//Montador com semente aleat�ria
	public Random() {
		xi = Calendar.getInstance().getTimeInMillis()%10;
	}
	//Gera um n�mero aleat�rio entre 0 e 1
	public double getRand() {
		double rand;
		xi = (a+(m*xi))%p;
		rand = xi;
		return rand/p;
	}
	//Gera um n�mero aleat�rio entre 0 e max
	public int getintRand(int max) {
		double num = getRand();
		return (int) (num * max);
	}
	//Escolhe a semente
	void setSemente(int semente) {
		xi = semente;
	}
}
