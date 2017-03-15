package graphics;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import pessoa.Cliente;
import pessoa.Pessoa;
import produto.Acessorios;
import produto.Cosmeticos;
import produto.Perfumaria;
import produto.Produtos;

public class InterfaceGrafica extends JFrame{
		
	private JMenu cadastro, edit, search, list, exit;
	private JPanel middle, left;
	private JLabel label;
	
	private JMenuItem cliente, cliente2, cliente3;
	private JMenu produto;
	private JMenuItem produto2, produto3;
	private JMenuItem estoque;
	private JMenuItem debito;
	
	private JMenuItem acessorio1;
	private JMenuItem cosmetico1;
	private JMenuItem perfumaria1;
	
	private JButton add;
	
	private TextField nomeField;
	private TextField rgField;
	private TextField cpfField;
	private TextField telefonefixoField;
	private TextField celularField;
	
	private TextField descricaoField;
	private TextField precoCustoField;
	private TextField porcentagemField;
	private TextField quantidadeField;
	private TextField idField;
	
	private JLabel nomeLabel;
	
	private String nome, rg, cpf, telefonefixo, celular;
	private String descricao;
	private double precoCusto, porcentagem;
	private int quantidade, id;
	private Cliente cli;
	private Acessorios acessorio;
	
	public InterfaceGrafica(){
		super("Loja de Presentes");
		setLayout(new BorderLayout(0,0));
		middle = new JPanel(new FlowLayout());
		left = new JPanel(new FlowLayout());
		//add(left, BorderLayout.WEST);
		add(middle, BorderLayout.CENTER);
		label = new JLabel("Status");
		add(label, BorderLayout.SOUTH);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,500);
		JMenuBar menu = createMenu();
		setJMenuBar(menu);
		
		}
		
	private JMenuBar createMenu(){
		JMenuBar menu = new JMenuBar(); 
		cadastro = new JMenu("Cadastro");
		edit = new JMenu("Editar");
		search = new JMenu("Procurar");
		list = new JMenu("Listar");
		exit = new JMenu("Sair");

		createSubMenu();
			
		menu.add(cadastro);
		menu.add(edit);
		menu.add(search);
		menu.add(list);
		menu.add(exit);
			
		return menu;
		}
		
	private void createSubMenu(){		
		cliente = new JMenuItem("Cliente");
		produto = new JMenu("Produto");
		cliente2 = new JMenuItem("Cliente");
		produto2 = new JMenuItem("Produto");
		cliente3 = new JMenuItem("Cliente");
		produto3 = new JMenuItem("Produto");
		estoque = new JMenuItem("Estoque");
		debito = new JMenuItem("Clientes em débito");
		acessorio1 = new JMenuItem("Acessório");
		cosmetico1 = new JMenuItem("Cosmético");
		perfumaria1 = new JMenuItem("Perfumaria");
		
		
		cadastro.add(cliente);
		cadastro.add(produto);
		produto.add(acessorio1);
		produto.add(cosmetico1);
		produto.add(perfumaria1);
		edit.add(cliente2);
		edit.add(produto2);
		search.add(cliente3);
		search.add(produto3);
		list.add(estoque);
		list.add(debito);
	
			
		cliente.addActionListener(e-> {
			JLabel nomeLabel = new JLabel("Nome");
			JLabel rgLabel = new JLabel("RG");
			JLabel cpfLabel = new JLabel("CPF");
			JLabel telefoneFixoLabel = new JLabel("Telefone Fixo");
			JLabel celularLabel = new JLabel("Celular");
			nomeField = new TextField(32);
			rgField = new TextField(32);
			cpfField = new TextField(32);
			telefonefixoField = new TextField(32);
			celularField = new TextField(32);
				
			middle.removeAll();
			setSize(296, 400);
			middle.add(nomeLabel);
			middle.add(nomeField);		
			middle.add(rgLabel);
			middle.add(rgField);	
			middle.add(cpfLabel);
			middle.add(cpfField);	
			middle.add(telefoneFixoLabel);
			middle.add(telefonefixoField);		
			middle.add(celularLabel);
			middle.add(celularField);
			
			label.setText("Adicionando um cliente");
			
			
			
			adicionarCliente();
		});
		
		acessorio1.addActionListener(e->{
			label.setText("Adicionando um item acessório");
			produtoTexto();	
			add.addActionListener(e1->{
				getDados();
				try {
					Produtos pro = new Acessorios(nome, descricao, precoCusto, porcentagem, quantidade, id);
					pro.cadastroDePresentes(pro);
					JOptionPane.showMessageDialog(null, "Cadastro feito com sucesso!");
					middle.removeAll();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage() + "\nEncerre a sessão e tente novamente.","Erro",JOptionPane.WARNING_MESSAGE);
					e2.printStackTrace();
				}
			});	
			
		});
		cosmetico1.addActionListener(e->{
			label.setText("Adicionando um item cosmético");
			produtoTexto();
			add.addActionListener(e1->{
				getDados();
				try{
					Produtos pro = new Cosmeticos(nome, descricao, precoCusto, porcentagem, quantidade, id);
					pro.cadastroDePresentes(pro);
					JOptionPane.showMessageDialog(null, "Cadastro feito com sucesso!");
					middle.removeAll();
				}catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage() + "\nEncerre a sessão e tente novamente.","Erro",JOptionPane.WARNING_MESSAGE);
					e2.printStackTrace();
				}
			});
		});
		perfumaria1.addActionListener(e->{
			label.setText("Adicionando um item da perfumaria");
			produtoTexto();
			add.addActionListener(e1->{
				getDados();
				try{
					Produtos pro = new Perfumaria(nome, descricao, precoCusto, porcentagem, quantidade, id);
					pro.cadastroDePresentes(pro);
					middle.removeAll();
					middle.remove(add);
					middle.remove(nomeLabel);
					JOptionPane.showMessageDialog(null, "Cadastro feito com sucesso!");
					
				}catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage() + "\nEncerre a sessão e tente novamente.","Erro",JOptionPane.WARNING_MESSAGE);
					e2.printStackTrace();
				}
			});
		});
		
		
	}
	
	private void adicionarCliente(){
		JButton add = new JButton("Adicionar");
		middle.add(add);
		add.addActionListener(e->{
			nome = nomeField.getText();
			rg = rgField.getText();
			cpf = cpfField.getText();
			telefonefixo = telefonefixoField.getText();
			celular = celularField.getText();
			try {
				Pessoa cli = new Cliente(nome,rg,cpf,telefonefixo,celular);
				cli.cadastro(cli);
				JOptionPane.showMessageDialog(null, "Cadastro feito com sucesso!");
				middle.removeAll();
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage() + "\nEncerre a sessão e tente novamente.","Erro",JOptionPane.WARNING_MESSAGE);
			}
			middle.removeAll();
		});
	}
		
	
	private void produtoTexto(){
		nomeLabel = new JLabel("Nome");
		JLabel descricaoLabel = new JLabel("Descrição");
		JLabel precoCustoLabel = new JLabel("Preço de custo");
		JLabel porcentagemLabel = new JLabel("Porcentagem");
		JLabel quantidadeLabel = new JLabel("Quantidade");
		JLabel idLabel = new JLabel("ID");
		
		add = new JButton("Adicionar");
		
		nomeField = new TextField(32);
		descricaoField = new TextField(32);
		precoCustoField = new TextField(32);
		porcentagemField = new TextField(32);
		quantidadeField = new TextField(32);
		idField = new TextField(32);
		
		middle.removeAll();
		
		setSize(290, 550);
		
		middle.add(nomeLabel);
		middle.add(nomeField);		
		middle.add(descricaoLabel);
		middle.add(descricaoField);	
		middle.add(precoCustoLabel);
		middle.add(precoCustoField);	
		middle.add(porcentagemLabel);
		middle.add(porcentagemField);		
		middle.add(quantidadeLabel);
		middle.add(quantidadeField);
		middle.add(idLabel);
		middle.add(idField);
		
		middle.add(add);
				
		
	}
	private void getDados(){
		nome = nomeField.getText();
		descricao = descricaoField.getText();
		precoCusto = Double.parseDouble(precoCustoField.getText());
		porcentagem = Double.parseDouble(porcentagemField.getText());
		quantidade = Integer.parseInt(quantidadeField.getText());
		id = Integer.parseInt(idField.getText());
	}
}
