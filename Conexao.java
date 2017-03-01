package banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Conexao {
	Connection con = null;
	
	public void conecta() {
	
		try {

			String url = "jdbc:postgresql://localhost/loja";
			String usuario = "thayna";
			String senha = "123";

			Class.forName("org.postgresql.Driver");	

			con = DriverManager.getConnection(url, usuario, senha);

			System.out.println("Conexão realizada com sucesso.");
			con.close();

		} catch (Exception e) {
			System.out.println(
					"Problemas na conexão. Verifique a digitação dos nomes e a existência da fonte de dados. \n Recompile e execute novamente.");
		}
	}

	public void cadastrarCLiente(Cliente cli) {
		String sql = "INSERT INTO Cliente(nome, rg, cpf, telefoneFixo, celular) VALUES (cli.getNome(), cli.getRg(), cli.getRg(), cli.telefoneFixo(), cli.celular())";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void cadastrarVendedor(Vendedor ven) {
		String sql = "INSERT INTO Cliente(nome, rg, cpf, telefoneFixo, celular, id) VALUES (ven.getNome(), ven.getRg(), ven.getCpf(), ven.getTelefoneFixo(), ven.getCelular(), ven.getId())";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void cadastrarGerente(Gerente ger) {
		String sql = "INSERT INTO Cliente(nome, celular, id, senha) VALUES (ger.getNome, gercelular, id, senha)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.execute();
		} catch (SQLException e) {
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
}