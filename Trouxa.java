package pessoa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import banco.Conexao;

public class Trouxa {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Conexao connection = new Conexao();
		
		
		try{
			String nome,rg,cpf,telefonefixo,celular;
			
			nome = scanner.nextLine();
			rg = scanner.nextLine();
			cpf =  scanner.nextLine();
			telefonefixo = scanner.nextLine();
			celular = scanner.nextLine();
			Cliente cli = new Cliente(nome,rg, cpf,telefonefixo, celular);
			System.out.println(cli.getNome());
			System.out.println(cli.getRg());
			System.out.println(cli.getCpf());
			System.out.println(cli.getTelefonefixo());
			System.out.println(cli.getCelular());
			connection.cadastro(cli);
		} catch(Exception e){
			e.printStackTrace();
		}
		
		
	
		
		
		
		
		
		
		
		scanner.close();
		

	}

}
