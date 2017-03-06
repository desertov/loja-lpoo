package pessoa;

import banco.Conexao;

public abstract class Pessoa extends Conexao implements ReadyObject{
	public String nome;
	public String rg;
	public String cpf;
	public String telefonefixo;
	public String celular;
	
	public Pessoa(String nome, String rg, String cpf, String telefonefixo, String celular) throws NullException, HugeNameException, PhoneException, InvalidCpfFormatException {
		setNome(nome);
		setRg(rg);
		setCpf(cpf);;
		setTelefonefixo(telefonefixo);
		setCelular(celular);
	}
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws NullException, HugeNameException{
		if(nulaOuEmBranco(nome)||nulaOuVazia(nome))
			throw new NullException("Nome");
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

	public abstract void setCpf(String cpf) throws NullException, InvalidCpfFormatException;

	public String getTelefonefixo() {
		return telefonefixo;
	}

	public void setTelefonefixo(String telefonefixo) throws PhoneException {
		if(nulaOuEmBranco(telefonefixo)||nulaOuVazia(telefonefixo))
			this.telefonefixo = null;
		else if(telefonefixo.length() != 13)
			throw new PhoneException("Telefone Fixo", "(YY)YYYY-YYYY");
		else if(telefonefixo.charAt(0) != '(' && telefonefixo.charAt(3) != ')' && telefonefixo.charAt(8) != '-')
			throw new PhoneException("Telefone Fixo", "(YY)YYYY-YYYY");
		else if((telefonefixo.charAt(1) < 0 && telefonefixo.charAt(1) > 9) || (telefonefixo.charAt(2) < 0 && telefonefixo.charAt(2) > 9))
			throw new PhoneException("Telefone Fixo", "(YY)YYYY-YYYY");
		else{
			for(int i = 4; i < 8; i++){
				if(telefonefixo.charAt(i) < 0 && telefonefixo.charAt(i) > 9)
					throw new PhoneException("Telefone Fixo", "(YY)YYYY-YYYY");
			}
			for(int j = 9; j < 13; j++){
				if(telefonefixo.charAt(j) < 0 && telefonefixo.charAt(j) > 9)
					throw new PhoneException("Telefone Fixo", "(YY)YYYY-YYYY");
			}
	
			this.telefonefixo = telefonefixo;
		}
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) throws NullException, PhoneException {
		if(nulaOuEmBranco(celular)||nulaOuVazia(celular))
			throw new NullException("Celular");
		else if(celular.length() != 14)
			throw new PhoneException("Celular", "(XX)XXXXX-XXXX");
		else if(celular.charAt(0) != '(' && celular.charAt(3) != ')' && celular.charAt(9) != '-')
			throw new PhoneException("Celular", "(XX)XXXXX-XXXX");
		else if((celular.charAt(1) < 0 && celular.charAt(1) > 9) || (celular.charAt(2) < 0 && celular.charAt(2) > 9))
			throw new PhoneException("Celular", "(XX)XXXXX-XXXX");
		else{
			for(int i = 4; i < 9; i++){
				if(celular.charAt(i) < 0 && celular.charAt(i) > 9)
					throw new PhoneException("Celular", "(XX)XXXXX-XXXX");
			}
			for(int j = 10; j < 14; j++){
				if(celular.charAt(j) < 0 && celular.charAt(j) > 9)
					throw new PhoneException("Celular", "(XX)XXXXX-XXXX");
			}
			this.celular = celular;
		}
	}
	
	//Verifica se a String é null ou vazia ou só tem espaços em branco
    public boolean nulaOuEmBranco(String s) {
        return (s == null || s.trim().equals(""));
    }

    	// Verifica se a String é null ou vazia
    public boolean nulaOuVazia(String s) {
        return (s == null || s.equals(""));
    }

	
	
}
