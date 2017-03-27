package banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import pessoa.Cliente;
import pessoa.Gerente;
import pessoa.HugeNameException;
import pessoa.InvalidCpfFormatException;
import pessoa.NullException;
import pessoa.Pessoa;
import pessoa.PhoneException;
import pessoa.Vendedor;
import produto.Acessorios;
import produto.Alphabetic;
import produto.Cosmeticos;
import produto.Estoque;
import produto.NotNumber;
import produto.Perfumaria;
import produto.Produtos;

public class BancoDeDados{
	public static Connection con = null;
	public static Statement statement = null;
	public static ResultSet resultSet = null;
	
	public ArrayList<Estoque> estoqueArray = new ArrayList<Estoque>();
	public ArrayList<Cliente> clienteArray = new ArrayList<Cliente>();
	
	public static void conecta() {
		try {
			String url = "jdbc:postgresql://localhost/loja";
			String usuario = "thayna";
			String senha = "123";

			Class.forName("org.postgresql.Driver");	

			con = DriverManager.getConnection(url, usuario, senha);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro de Conexão", "Erro", JOptionPane.WARNING_MESSAGE);
		}

	}//fim do método conecta
	
	//Método para desconectar do banco de dados
	public static void desconecta(){
		try {
			con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro de desconexão", "Erro", JOptionPane.WARNING_MESSAGE);
		}
	}//fim do método desconecta
	
	//Cadastro de Cliente
	public void cadastroDePessoa(Pessoa p) {
		conecta();
		if(p instanceof Cliente){
		String sql = "INSERT INTO Cliente (nome, rg, cpf, telefonefixo, celular) VALUES ('" + p.getNome() + "', '" + p.getRg() + "', '" + p.getCpf()+"', '"+p.getTelefonefixo()+"', '"+p.getCelular()+"');";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.execute();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Erro de SQL", "Erro", JOptionPane.WARNING_MESSAGE);
			}
		}//fim da insercao de um cliente
		
		else if(p instanceof Vendedor){
			String sql = "INSERT INTO Vendedor(nome, rg, cpf, telefoneFixo, celular, id, senha) VALUES "
					+ "(ven.getNome(), ven.getRg(), ven.getCpf(), ven.getTelefoneFixo(), ven.getCelular(), ven.getId(), ven.getSenha())";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.execute();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Erro de SQL", "Erro", JOptionPane.WARNING_MESSAGE);
			}
		}//fim da insercao de um vendedor
		
		else if(p instanceof Gerente){
			String sql = "INSERT INTO Gerente(nome, celular, id, senha) VALUES "
					+ "(ger.getNome(), ger,getCelular(), ger.getId(), ger.getSenha())";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.execute();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Erro de SQL", "Erro", JOptionPane.WARNING_MESSAGE);
			}
		}//fim da insercao de um gerente
		
	}//fim do método cadastro
	
	
	 //Cadastros de Acessorios, Cosmeticos e Perfumaria
	public void cadastroDePresentes(Produtos pro) throws SQLException{
		conecta();
		String query = "INSERT INTO estoque (nome, quantidade, id) VALUES (?, ?, ?)"; //Todo produto cadastrado entra no estoque também
		PreparedStatement ps0 = con.prepareStatement(query);
		ps0.setString(1, pro.getNome());
		ps0.setInt(2, Integer.parseInt(pro.getQuantidade()));
		ps0.setInt(3, Integer.parseInt(pro.getId()));
		ps0.executeUpdate();
		
		if(pro instanceof Acessorios){
			String sql = "INSERT INTO acessorios (nome, descricao, precocusto, percentlucro, quantidade, id) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, pro.getNome());
			ps.setString(2, pro.getDescricao());
			ps.setDouble(3, Double.parseDouble(pro.getPrecoCusto()));
			ps.setDouble(4, Double.parseDouble(pro.getPercentagemLucro()));
			ps.setInt(5, Integer.parseInt(pro.getQuantidade()));
			ps.setInt(6, Integer.parseInt(pro.getId()));
			ps.executeUpdate();
		}
		else if(pro instanceof Cosmeticos){
			String sql = "INSERT INTO Cosmeticos (nome, descricao, precocusto, percentlucro, quantidade, id) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, pro.getNome());
			ps.setString(2, pro.getDescricao());
			ps.setDouble(3, Double.parseDouble(pro.getPrecoCusto()));
			ps.setDouble(4, Double.parseDouble(pro.getPercentagemLucro()));
			ps.setInt(5, Integer.parseInt(pro.getQuantidade()));
			ps.setInt(6, Integer.parseInt(pro.getId()));
			ps.executeUpdate();
		}
		else if(pro instanceof Perfumaria){
			String sql = "INSERT INTO Perfumaria (nome, descricao, precocusto, percentlucro, quantidade, id) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, pro.getNome());
			ps.setString(2, pro.getDescricao());
			ps.setDouble(3, Double.parseDouble(pro.getPrecoCusto()));
			ps.setDouble(4, Double.parseDouble(pro.getPercentagemLucro()));
			ps.setInt(5, Integer.parseInt(pro.getQuantidade()));
			ps.setInt(6, Integer.parseInt(pro.getId()));
			ps.executeUpdate();
		}
	}
	
	//Atualizacao de dados de um Cliente, mesmo que nao mude os dados funciona
	public void editarCliente(Pessoa cliente, String p_key) throws PhoneException, NullException, HugeNameException, Alphabetic{
		conecta();
				
		String query = "UPDATE cliente SET nome = ? WHERE cpf = ?";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, cliente.getNome());
			ps.setString(2, p_key);
		    ps.executeUpdate();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Nome inválido", "Erro", JOptionPane.WARNING_MESSAGE);
			}			
		
		String query2 = "UPDATE cliente SET rg = ? WHERE cpf = ?";
		try {
			ps = con.prepareStatement(query2);
			ps.setString(1, cliente.getRg());
			ps.setString(2, p_key);
		    ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String query3 = "UPDATE cliente SET telefonefixo = ? WHERE cpf = ?";
		try {
			ps = con.prepareStatement(query3);
			ps.setString(1, cliente.getTelefonefixo());
			ps.setString(2, p_key);
		    ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		String query4 = "UPDATE cliente SET celular = ? WHERE cpf = ?";
		try {
			ps = con.prepareStatement(query4);
			ps.setString(1, cliente.getCelular());
			ps.setString(2, p_key);
			ps.executeUpdate();
		} catch (SQLException e) {
				e.printStackTrace();
		}
	}
	
	//Atualizacao dos dados de um produto, mesmo que nao mude os dados, funciona
	public void editarProduto(String precoCusto, String percent, String key) throws PhoneException, NullException, HugeNameException, Alphabetic{
		conecta();
		int p_key = Integer.parseInt(key);
		String table = getNameOfTable(key);//Método necessario para saber a qual tabela o id dado pertence.
		for(int i = 0; i < 3; i++){
			String query = "UPDATE "+ table+ " SET precocusto = ? WHERE id = ?";
			PreparedStatement ps;
			try {
				ps = con.prepareStatement(query);
				
				double preco = Double.parseDouble(precoCusto);
				ps.setDouble(1, preco);
				ps.setInt(2, p_key);
				ps.executeUpdate();
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Nome inválido", "Erro", JOptionPane.WARNING_MESSAGE);
				}			
			
			String query2 = "UPDATE "+table+" SET percentlucro  = ? WHERE id = ?";
			try {
				ps = con.prepareStatement(query2);
				double percentagem = Double.parseDouble(percent);
				ps.setDouble(1, percentagem);
				ps.setInt(2, p_key);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}//Somente dois campos podem ser alterados após serem cadastrados
	}
	
	//Método para a atualizacao de dados de um produto
	public String getNameOfTable(String pk){
		conecta();
		int id = Integer.parseInt(pk);
		String[] table = {"acessorios", "cosmeticos", "perfumaria"};
		for(int i = 0; i < 3; i++){
			String sql = "SELECT * FROM "+table[i]+" WHERE id = ?";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					if(rs.getInt("id") == id)
						return table[i];
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	//Método para busca de um cliente
	public Cliente procurarCliente(String cpf) throws SQLException, NullException, HugeNameException, PhoneException, InvalidCpfFormatException, Alphabetic {
		conecta();
		String sql = "SELECT * FROM Cliente WHERE cpf = ?";

		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, cpf);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			if(rs.getString("cpf").equals(cpf))
				return new Cliente(rs.getString("nome"), rs.getString("rg"), rs.getString("cpf"), rs.getString("telefonefixo"), rs.getString("celular"));
		}
		return null;	
	}	
	
	//Método para busca de um produto 
	public Produtos procurarProduto(int id) throws HugeNameException, NotNumber, Alphabetic {
		try  {
			conecta();
		String sql1 = "SELECT * FROM acessorios WHERE id = ?";
		PreparedStatement ps = con.prepareStatement(sql1);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			if(rs.getInt("id")==id){
				return new Acessorios(rs.getString("nome"),rs.getString("descricao"), rs.getString("precocusto"), rs.getString("percentlucro"), rs.getString("quantidade"), rs.getString("id"));
			}
		}
		
		String sql2 = "SELECT * FROM cosmeticos WHERE id = ?";
		PreparedStatement ps2 = con.prepareStatement(sql2);
		ps2.setInt(1, id);
		ResultSet rs2 = ps2.executeQuery();
		while(rs2.next()){
			if(rs2.getInt("id") == id){
				System.out.println(rs2.getString("id"));
				return new Cosmeticos(rs2.getString("nome"),rs2.getString("descricao"), rs2.getString("precocusto"), rs2.getString("percentlucro"), rs2.getString("quantidade"), rs2.getString("id"));
			}
		}
		
		String sql3 = "SELECT * FROM perfumaria WHERE id = ?";
		PreparedStatement ps3 = con.prepareStatement(sql3);
		
		ps3.setInt(1, id);
		ResultSet rs3 = ps3.executeQuery();
		while(rs3.next()){
			if(rs3.getInt("id") == id){
				System.out.println(rs3.getString("id"));
				return new Perfumaria(rs3.getString("nome"),rs3.getString("descricao"), rs3.getString("precocusto"), rs3.getString("percentlucro"), rs3.getString("quantidade"), rs3.getString("id"));
			}
		}
		} catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	//Método para listar todos clientes
	public ArrayList<Cliente> listarCliente() throws SQLException{
		try{
			conecta();
			
		String sql = "SELECT * FROM cliente ORDER BY cpf";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
			while(rs.next()){
				String name = rs.getString("nome");
				String rg = rs.getString("rg");
				String cpf = rs.getString("cpf");
				String telfixo = rs.getString("telefonefixo");
				String cel = rs.getString("celular");
				Cliente cliente = new Cliente(name,rg,cpf,telfixo,cel);
				clienteArray.add(cliente);
			}
			return clienteArray;
		}catch(Exception e){
			throw new SQLException();
		}
	}
	
	//Método para listar o estoque
	public ArrayList<Estoque> listarEstoque() throws SQLException{
		try{
			conecta();
		
		String query = "SELECT * FROM estoque ORDER BY id";
		PreparedStatement ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();

			while(rs.next()){
				String name = rs.getString("nome");	
				int quant = rs.getInt("quantidade");
				int identify = rs.getInt("id");
				Estoque estocado = new Estoque(name, quant, identify);
				estoqueArray.add(estocado);
			}
			return estoqueArray;
		} catch(Exception e){
			throw new SQLException();
		}
	}
	
	//Método para remover um cliente
	public void removeCliente(String cpf) throws SQLException{
		conecta();
		String sql = "DELETE FROM cliente WHERE cpf = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, cpf);
		ps.executeUpdate();
			
	}
	
	//Método para remover um produto
	public void removeProduto(String key) throws SQLException{
		conecta();
		int p_key = Integer.parseInt(key);
		
		String sql = "DELETE FROM estoque WHERE id = ?";
			PreparedStatement ps0 = con.prepareStatement(sql);
			ps0.setInt(1, p_key);
			ps0.executeUpdate(); //removendo do estoque pois todo produto cadastrado está no estoque também	

		String table = getNameOfTable(key);
			String query = "DELETE FROM "+ table+ " WHERE id = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, p_key);
			ps.executeUpdate();//removendo da tabela do banco de dados
	}
	
}