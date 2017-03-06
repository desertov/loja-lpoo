package pessoa;

public class Vendedor extends Funcionario{

	private Cliente cliente;//Para fazer uso do método setCpf

	public Vendedor(String nome, String rg, String cpf, String telefonefixo, String celular, Integer id, String senha) 
			throws NullException, HugeNameException, PhoneException, InvalidCpfFormatException {
		super(nome, rg, cpf, telefonefixo, celular, id, senha);
	}

	@Override
	public void setCpf(String cpf) throws NullException, InvalidCpfFormatException {	
		if(super.nulaOuEmBranco(cpf)||super.nulaOuVazia(cpf))
			throw new NullException("CPF");
		 if(cpf.length() != 14)
				throw new InvalidCpfFormatException("O CPF digitado não possui o tamanho correto, verifique novamente.");
			for(int i = 0; i < 3; i++){
				if(cpf.charAt(i) < 0 && cpf.charAt(i) > 9)
					throw new InvalidCpfFormatException("O CPF digitado possui caracter(es) não numérico(s), verifique novamente.");
			}
			for(int i = 4; i < 7; i++){
				if(cpf.charAt(i) < 0 && cpf.charAt(i) > 9)
					throw new InvalidCpfFormatException("O CPF digitado possui caracter(es) não numérico(s), verifique novamente.");
			}
			for(int i = 8; i < 11; i++){
				if(cpf.charAt(i) < 0 && cpf.charAt(i) > 9)
					throw new InvalidCpfFormatException("O CPF digitado possui caracter(es) não numérico(s), verifique novamente.");
			}
			for(int i = 12; i < 14; i++){
				if(cpf.charAt(i) < 0 && cpf.charAt(i) > 9)
					throw new InvalidCpfFormatException("O CPF digitado possui caracter(es) não numérico(s), verifique novamente.");
			}
			for(int i = 3; i < 8; i=i+4){
				if(cpf.charAt(i) != '.')
					throw new InvalidCpfFormatException("O CPF digitado possui o símbolo '.' em local não apropriado ou não possui este símbolo no campo digitado.");
			}
			if(cpf.charAt(11) != '-'){
				throw new InvalidCpfFormatException("O CPF digitado possui o símbolo '-' em local não apropriado ou não possui este símbolo no campo digitado.");
			}
			else
				super.cpf = cpf;
	}

}
