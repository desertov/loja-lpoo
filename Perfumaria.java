package produto;

import pessoa.HugeNameException;

public class Perfumaria extends Produtos {

	public Perfumaria(String nome, String descricao, double precoCusto, double percentagemLucro, int quantidade, int id)
			throws HugeNameException {
		super(nome, descricao, precoCusto, percentagemLucro, quantidade, id);
	}

}
