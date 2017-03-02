package pessoa;

public class Vendedor extends Funcionario{

	private Cliente cliente;//Para fazer uso do método setCpf

	public Vendedor(String nome, String rg, String cpf, String telefonefixo, String celular, Integer id) 
			throws NullException, HugeNameException, PhoneException, InvalidCpfFormatException {
		super(nome, rg, cpf, telefonefixo, celular, id);
	}

	@Override
	public void setCpf(String cpf) throws NullException, InvalidCpfFormatException {	
		((Cliente) cliente).setCpf(cpf);	
	}

}
