package pessoa;

import banco.Conexao;

public abstract class Pessoa extends Conexao{
	private String nome;
	private String rg;
	private String cpf;
	private String telefonefixo;
	private String celular;
	
	public Pessoa(String nome, String rg, String cpf, String telefonefixo, String celular) {
		setNome(nome);
		setRg(rg);
		setCpf(cpf);;
		setTelefonefixo(telefonefixo);
		setCelular(celular);
		cadastrarCLiente(Pessoa);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if(nome.length() > 128)
			throw new HugeNameException();
		else
			
			this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefonefixo() {
		return telefonefixo;
	}

	public void setTelefonefixo(String telefonefixo) {
		this.telefonefixo = telefonefixo;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	
	
	
}
