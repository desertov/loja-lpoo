package pessoa;

public class NullException extends Exception {
	public NullException(String message){
		super("Verifique o campo" + message+ "novamente. É obrigatório preenchê-lo");
	}
}
