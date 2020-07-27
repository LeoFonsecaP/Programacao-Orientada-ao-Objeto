//Representa uma pessoa juridica
//Subclasse de "Pessoa"
//Feita por: Leonardo Fonseca Pinheiro
public class PessoaJuridica extends Pessoa {
	String CNPJ;
	String inscricao_estadual;
	String razao_social;
	public PessoaJuridica(String n, String end, String em, String c, String ie, String rs) {
		super(n, end, em);
		CNPJ = c;
		inscricao_estadual = ie;
		razao_social = rs;
	}
	boolean compara_c(String c) {
		if(c.equalsIgnoreCase(CNPJ)) {
			return true;
		}
		else {
			return false;
		}
	}
	public String getCNPJ() {
		return CNPJ;
	}
	public String getInscricao() {
		return inscricao_estadual;
	}
	public String getRazao() {
		return razao_social;
	}
	@Override
	void imprimir_pessoa(Pessoa aux) {
		System.out.printf("Nome: %s\n", getNome());
		System.out.printf("Endereco: %s\n", getEndereco());
		System.out.printf("Email: %s\n", getEmail());
		System.out.printf("CNPJ: %s\n", CNPJ);
		System.out.printf("Inscricao Estadual: %s\n", inscricao_estadual);
		System.out.printf("Razao Social: %s\n", razao_social);
	}
}
