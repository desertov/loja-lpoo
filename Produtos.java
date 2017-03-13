package produto;

import banco.BancoDeDados;
import pessoa.HugeNameException;

public class Produtos extends BancoDeDados{
	public String nome;
	public String descricao;
	public double precoCusto;
	public double percentagemLucro;
	public int quantidade;
	public int id;
	
	public Produtos(String nome, String descricao, double precoCusto, double percentagemLucro, int quantidade, int id) throws HugeNameException {
		setNome(nome);
		setDescricao(descricao);
		setPrecoCusto(precoCusto);
		setPercentagemLucro(percentagemLucro);
		setQuantidade(quantidade);
		setId(id);
	}
	public void setNome(String nome) throws HugeNameException {
		if(nome.length() > 128)
			throw new HugeNameException();
		this.nome = nome;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public void setPrecoCusto(double precoCusto) {
		this.precoCusto = precoCusto;
	}
	
	public void setPercentagemLucro(double percentagemLucro) {
		this.percentagemLucro = percentagemLucro;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public double getPrecoCusto() {
		return precoCusto;
	}
	
	public double getPercentagemLucro() {
		return percentagemLucro;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public int getId() {
		return id;
	}
	
	
	
	
	
	
	
	
	
}
