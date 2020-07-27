import java.io.IOException;

public class str {

	public static void main(java.lang.String[] args) throws IOException {
	String frase= EntradaTeclado.leString();
	int a = 0;
	int e = 0;
	int letrai = 0;
	int o = 0;
	int u = 0;
	for(int i = 0; i < frase.length(); i++) {
		if(frase.charAt(i) == 'a' || frase.charAt(i) == 'A') {
			a++;
		}
		if(frase.charAt(i) == 'e' || frase.charAt(i) == 'E') {
			e++;
		}
		if(frase.charAt(i) == 'i' || frase.charAt(i) == 'I') {
			letrai++;
		}
		if(frase.charAt(i) == 'o' || frase.charAt(i) == 'O') {
			u++;
		}
		if(frase.charAt(i) == 'u' || frase.charAt(i) == 'U') {
			u++;
		}
	}
	}
}
