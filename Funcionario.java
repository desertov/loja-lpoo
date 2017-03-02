package pessoa;

public abstract class Funcionario extends Pessoa{
	private Integer id;
	
	public Funcionario(String nome, String rg, String cpf, String telefonefixo, String celular, Integer id)
			throws NullException, HugeNameException, PhoneException, InvalidCpfFormatException {
		super(nome, rg, cpf, telefonefixo, celular);
		setId(id);
	}
	
	public Integer getId(){
		return id;
	}
	
	public void setId(Integer id)throws NullException{
		if(id == null)
			throw new NullException("ID");
		else if(tamanho(id)!= 8)
			throw new InvalidIdException();
		else
			this.id = id;
	}

	public int tamanho(Integer id) {
		int cont = 0;
		while(id != 0)
			cont++;
		return cont;
	}

}
