package pessoa;

public class HugeNameException extends Exception {
	public HugeNameException(){
		super("Limite de caracteres ultrapassado");
	}
}
