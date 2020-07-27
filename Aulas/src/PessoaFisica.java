//Representa uma pessoa fisica
//Subclasse de "Pessoa"
//Feita por: Leonardo Fonseca Pinheiro
public class PessoaFisica extends Pessoa {
	private String CPF;
	private String data;
	private String estado_civil;
	
	public PessoaFisica(String n, String end, String em, String c, String d, String ec) {
		super(n, end, em);
		CPF = c;
		data = d;
		estado_civil = ec;
	}

	public String getCPF() {
		return CPF;
	}
	
	boolean compara_c(String c) {
		if(c.equalsIgnoreCase(CPF)) {
			return true;
		}
		else {
			return false;
		}
	}

	public String getData() {
		return data;
	}

	public String getEstado_civil() {
		return estado_civil;
	}
	
	@Override
	void imprimir_pessoa(Pessoa aux) {
		System.out.printf("Nome: %s\n", getNome());
		System.out.printf("Endereco: %s\n", getEndereco());
		System.out.printf("Email: %s\n", getEmail());
		System.out.printf("CPF: %s\n", CPF);
		System.out.printf("Data de nascimento: %s\n", data);
		System.out.printf("Estado Civil: %s\n", estado_civil);
	}

	

}
