package pessoa;

import java.util.Scanner;

import banco.Conexao;

public class Teste {

	public static void main(String[] args) {
		Conexao banco = new Conexao();
		Scanner le = new Scanner(System.in);
		banco.conecta();
		String nome, rg, cpf, telefonefixo, celular;
		nome = le.nextLine();
		rg = le.nextLine();
		cpf = le.nextLine();
		telefonefixo = le.nextLine();
		celular = le.nextLine();
		
		
		
		le.close();
	}

}
