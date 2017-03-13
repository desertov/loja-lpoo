package pessoa;

public abstract class Funcionario extends Pessoa implements Autenticavel{
	private Integer id;
	private String senha;
	
	public Funcionario(String nome, String rg, String cpf, String telefonefixo, String celular, Integer id, String senha)
			throws HugeNameException, PhoneException, NullException, InvalidCpfFormatException {//InvalidCpfFormatException pode ser lancada pois um gerente pode querer cadastrar seu cpf, mas nao estara visivel ao publico
		super(nome, rg, cpf, telefonefixo, celular);
		setId(id);
		setSenha(senha);
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
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha)throws NullException {
		if(super.nulaOuEmBranco(senha) || super.nulaOuVazia(senha))
			throw new NullException("Senha");
		else
			this.senha = senha;
	}

	public boolean login(Integer id, String senha) {
		if(id == getId() && senha == getSenha()){
			return true; 
		}
		return false;
	}


}
