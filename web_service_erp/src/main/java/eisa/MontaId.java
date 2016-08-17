package eisa;

public class MontaId {

	
	public static String montaId(String b36){
		b36 = b36.trim();
		String id = "00A";
		if(b36.length()<=7){
			int tamanhosobra = 7 - b36.length();
			for(int i=0;i<tamanhosobra;i++){
				b36 = "0"+b36;
			}
		}
		return id+b36;
		
	}
}
