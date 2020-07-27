
public class ContaBancaria {
	private String nome_do_titular;
	private long numero_da_conta;
	private double saldo;
	
	public ContaBancaria(String nome, long num, double s){
		nome_do_titular = nome;
		numero_da_conta = num;
		saldo = s;
	}
	
	public double getSaldo() {
		return saldo;
	}
	protected void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	void deposita(double qtd) {
		saldo += qtd;
	}
	void saca(double qtd) throws IllegalArgumentException {
		if(saldo > qtd) {
			saldo -= qtd;
		}
		else {
			throw new IllegalArgumentException("Saldo insuficiente");
		}
	}
}
