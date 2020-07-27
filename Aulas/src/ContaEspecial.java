
public class ContaEspecial extends ContaBancaria {
	private double limite;
	public ContaEspecial(String nome, long num, double s, double l) {
		super(nome, num, s);
		setLimite(l);
	}
	public double getLimite() {
		return limite;
	}
	public void setLimite(double limite) {
		this.limite = limite;
	}
	@Override
	public void saca(double qtd) throws IllegalArgumentException{
		double saldo = getSaldo();
		if((saldo + limite) > qtd) {
			saldo -= qtd;
			setSaldo(saldo);
		}
		else {
			throw new IllegalArgumentException("Saldo insuficiente");
		}
	}
}