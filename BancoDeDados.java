package banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.lang.String;

import pessoa.Cliente;
import pessoa.Gerente;
import pessoa.Pessoa;
import pessoa.Vendedor;
import produto.Acessorios;
import produto.Cosmeticos;
import produto.Perfumaria;
import produto.Produtos;

public class BancoDeDados{
	private Connection con = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	public void conecta() {
		try {
			String url = "jdbc:postgresql://localhost/loja";
			String usuario = "thayna";
			String senha = "123";

			Class.forName("org.postgresql.Driver");	

			con = DriverManager.getConnection(url, usuario, senha);

			System.out.println("Conexão realizada com sucesso.");
			System.out.println(con);

		} catch (Exception e) {
			System.out.println("Problemas na conexão. Tente novamente mais tarde");
		}

	}//fim do método conecta
	
	public String listarCliente(String cpf) throws SQLException {
		String sql = "SELECT * FROM Cliente WHERE cpf = ";

		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, cpf);
		
		ResultSet rs = ps.executeQuery();
			
		return rs.getString("nome");
		/*while(rs.next()) {
		rs.getString(0); // rs.getString("cpf");
	}*/ //Percorre a coluna
	}	
		
		
	public void cadastroDePessoa(Pessoa p) {//O que está comentado nesse método, também produz o mesmo efeito;
		if(p instanceof Cliente){
		String sql = "INSERT INTO Cliente (nome, rg, cpf, telefonefixo, celular) VALUES ('" + p.getNome() + "', '" + p.getRg() + "', '" + p.getCpf()+"', '"+p.getTelefonefixo()+"', '"+p.getCelular()+"');";
			//String sql = "INSERT INTO Cliente (nome, rg, cpf, telefonefixo, celular) VALUES (?, ?, ?, ?, ?)";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				//OreoaredStament ps = con.prepareStatement(sql);
				/*ps.setString(1, p.getNome());
				ps.setString(2, p.getRg());
				ps.setString(3, p.getCpf());
				ps.setString(4, p.getTelefonefixo());
				ps.setString(5, p.getCelular());
				ps.executeUpdate();*/
				
				ps.executeUpdate();
				//statement = con.createStatement();
				//statement.executeUpdate(sql);
				//this.statement.executeQuery(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}//fim da insercao de um cliente
		
		else if(p instanceof Vendedor){
			String sql = "INSERT INTO Vendedor(nome, rg, cpf, telefoneFixo, celular, id, senha) VALUES "
					+ "(ven.getNome(), ven.getRg(), ven.getCpf(), ven.getTelefoneFixo(), ven.getCelular(), ven.getId(), ven.getSenha())";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}//fim da insercao de um vendedor
		
		else if(p instanceof Gerente){
			String sql = "INSERT INTO Gerente(nome, celular, id, senha) VALUES "
					+ "(ger.getNome(), ger,getCelular(), ger.getId(), ger.getSenha())";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}//fim da insercao de um gerente
		
	}//fim do método cadastro
	
	
	
	public void cadastroDePresentes(Produtos pro) throws SQLException{
		if(pro instanceof Acessorios){
			String sql = "INSERT INTO acessorios (nome, descricao, precocusto, percentlucro, quantidade, id) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, pro.getNome());
			ps.setString(2, pro.getDescricao());
			ps.setDouble(3, pro.getPrecoCusto());
			ps.setDouble(4, pro.getPercentagemLucro());
			ps.setInt(5, pro.getQuantidade());
			ps.setInt(6, pro.getId());
			ps.executeUpdate();
		}
		else if(pro instanceof Cosmeticos){
			String sql = "INSERT INTO Cosmeticos (nome, descricao, precocusto, percentlucro, quantidade, id) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, pro.getNome());
			ps.setString(2, pro.getDescricao());
			ps.setDouble(3, pro.getPrecoCusto());
			ps.setDouble(4, pro.getPercentagemLucro());
			ps.setInt(5, pro.getQuantidade());
			ps.setInt(6, pro.getId());
			ps.executeUpdate();
		}
		else if(pro instanceof Perfumaria){
			String sql = "INSERT INTO Perfumaria (nome, descricao, precocusto, percentlucro, quantidade, id) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, pro.getNome());
			ps.setString(2, pro.getDescricao());
			ps.setDouble(3, pro.getPrecoCusto());
			ps.setDouble(4, pro.getPercentagemLucro());
			ps.setInt(5, pro.getQuantidade());
			ps.setInt(6, pro.getId());
			ps.executeUpdate();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	public void listarContatos(){
		try{
			String query = "SELECT * FROM Cliente ORDER BY nome";
			this.resultSet = this.statement.executeQuery(query);
			while(this.resultSet.next()){
				System.out.println("Nome: " + this.resultSet.getString("nome") + " - RG: " + this.resultSet.getString("rg") + " - CPF: " + this.resultSet.getString("cpf"));
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
		
	
	
	
	
	
	
	
	
	
	
	public void cadastrarProdutos(String nome, String rg, String cpf, String telefoneFixo, String celular) {
		String sql = "INSERT INTO Cliente(nome, rg, cpf, telefoneFixo, celular) VALUES (nome, rg, cpf, telefoneFixo, celular)";			
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}