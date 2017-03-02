package pessoa;

public class InvalidIdException extends RuntimeException {
	public InvalidIdException(){
		super("Voce não digitou 8 digitos para o campo ID");
	}
}
