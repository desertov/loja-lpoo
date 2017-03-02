package pessoa;

public class PhoneException extends Exception {
	public PhoneException(String type, String format){
		super("O "+ type + " deve ser do formato " + format);
	}
}
