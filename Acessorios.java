package produto;

import pessoa.HugeNameException;

public class Acessorios extends Produtos{

	public Acessorios(String nome, String descricao, double precoCusto, double percentagemLucro, int quantidade, int id)
			throws HugeNameException {
		super(nome, descricao, precoCusto, percentagemLucro, quantidade, id);
		
	}
	
}
