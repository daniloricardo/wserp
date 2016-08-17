package eisa;

public class Teste {

	public static void main(String[] args) {
		String cep = "02541070";
		cep = cep.substring(0, 5)+"-"+cep.substring(5, 8);
		System.out.println(cep);
	}
}
