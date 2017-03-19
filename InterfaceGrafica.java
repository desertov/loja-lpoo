package graphics;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListModel;

import banco.BancoDeDados;
import pessoa.Cliente;
import pessoa.Pessoa;
import pessoa.PhoneException;
import produto.Acessorios;
import produto.Cosmeticos;
import produto.Perfumaria;
import produto.Produtos;
import produto.Estoque;

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
	
	private JButton add = new JButton("Adicionar");
	private JButton alt = new JButton("Alterar");
	
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
	
	private TextField altera;
	private TextField valorNovo;
	private TextField pkey;
	
	private JLabel nomeLabel;//DECIDIR SE É GLOBAL
	
	private JTable myTable;
	private JScrollPane scroll;
	
	private ArrayList<Estoque> estocado = new ArrayList<Estoque>();
	
	private String nome, rg, cpf, telefonefixo, celular;
	private String descricao, precoCusto, porcentagem, quantidade, id;
	private String nameField, newValue, cpfCliente;
	
	private Cliente cli;
	private Acessorios acessorio;
	
	private boolean complete;
	
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
		
		createListeners();
	}
	
	
	
	
	private void createListeners(){		
		cliente.addActionListener(e-> {
			if(label.getText().equals("Adicionando um cliente"))
				setSize(297, 400);
			label.setText("Adicionando um cliente");
			clienteTexto();
			
			add.addActionListener(e1->{
				getCliente();
				try {
					Pessoa cli = new Cliente(nome,rg,cpf,telefonefixo,celular);
					cli.cadastro(cli);
					JOptionPane.showMessageDialog(null, "Cadastro feito com sucesso!");
					setSize(295, 400);
					label.setText("Status");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage() + "\nTente novamente.","Erro",JOptionPane.WARNING_MESSAGE);
				}
			});
					
		});
		
		acessorio1.addActionListener(e->{
			if(label.getText().equals("Adicionando um item acessório"))
				setSize(291, 550);
			label.setText("Adicionando um item acessório");
			produtoTexto();	
			add.addActionListener(e1->{
				getProduto();
				try {
					Produtos pro = new Acessorios(nome, descricao, precoCusto, porcentagem, quantidade, id);
					pro.cadastroDePresentes(pro);
					JOptionPane.showMessageDialog(null, "Cadastro feito com sucesso!");	
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage() + "\nTente novamente.","Erro",JOptionPane.WARNING_MESSAGE);
				}finally{
					//middle.removeAll();
					setSize(291, 550);
					label.setText("Status");
				}
			});	
		});
		cosmetico1.addActionListener(e->{
			if(label.getText().equals("Adicionando um item cosmético"))
				setSize(291, 550);
			label.setText("Adicionando um item cosmético");
			produtoTexto();
			add.addActionListener(e1->{
				getProduto();
				try{
					Produtos pro = new Cosmeticos(nome, descricao, precoCusto, porcentagem, quantidade, id);
					pro.cadastroDePresentes(pro);
					JOptionPane.showMessageDialog(null, "Cadastro feito com sucesso!");
				}catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage() + "\nTente novamente.","Erro",JOptionPane.WARNING_MESSAGE);
				}finally{
					middle.removeAll();
					setSize(291, 550);
					label.setText("Status");
				}
			
			});
	
		});
		perfumaria1.addActionListener(e->{
			if(label.getText().equals("Adicionando um item da perfumaria"))
				setSize(291, 550);
			label.setText("Adicionando um item da perfumaria");
	
			produtoTexto();
			add.addActionListener(e1->{
				getProduto();
				try{	
					Produtos pro = new Perfumaria(nome, descricao, precoCusto, porcentagem, quantidade, id);
					pro.cadastroDePresentes(pro);
					JOptionPane.showMessageDialog(null, "Cadastro feito com sucesso!");
				}catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage() + "\nTente novamente.","Erro",JOptionPane.WARNING_MESSAGE);
				}finally{
					middle.removeAll();
					setSize(291, 550);	
					label.setText("Status");
				}
			});
	
		});
		
		estoque.addActionListener(e->{
			if(label.getText().equals("Listando estoque"))
				setSize(501, 600);
			middle.removeAll();
			setSize(500, 600);
			if(myTable == null)
				moveArrayEstoque();
			String[]column = {"ID", "Nome", "Quantidade"};
			Object [][] estoque1 = new Object[estocado.size()][3];
			int line = 0;
				for(Estoque i:estocado){
					estoque1[line][0] = i.getId();
					estoque1[line][1] = i.getNome();
					estoque1[line][2] = i.getQuantidade();
					line++;
				}
			myTable = new JTable(estoque1, column);
			scroll = new JScrollPane(myTable);
			middle.add(scroll);
			label.setText("Listando estoque");		
		});
		
		cliente2.addActionListener(e->{
			if(label.getText().equals("Alterando um campo de um cliente"))
				setSize(291, 400);
			editarClienteText();
			alt.addActionListener(e1->{
				try {
					getClienteEdit();
					System.out.println(nameField + " "+newValue +" "+ cpfCliente);
					
					
					BancoDeDados.editarCliente(nameField, newValue, cpfCliente);
					JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
					middle.removeAll();
					setSize(291, 400);	
					label.setText("Status");
				} catch (Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, e2.getMessage(), "Erro", JOptionPane.WARNING_MESSAGE);
				}
			});
	
		});
		
		}
	
	private void getClienteEdit(){
		nameField = altera.getText();
		newValue = valorNovo.getText();
		cpfCliente = pkey.getText();
	}
		
	private void editarClienteText(){
		JLabel alteraLabel = new JLabel("Campo a ser alterado");
		JLabel valorNovoLabel = new JLabel("Novo valor");
		JLabel pkeyLabel = new JLabel("CPF do cliente");
		
		altera = new TextField(32);
		valorNovo = new TextField(32);
		pkey = new TextField(32);
	
		setSize(290, 400);
		middle.removeAll();
		label.setText("Alterando um campo de um cliente");
		middle.add(alteraLabel);
		middle.add(altera);
		middle.add(valorNovoLabel);
		middle.add(valorNovo);
		middle.add(pkeyLabel);
		middle.add(pkey);
		
		middle.add(alt);
		
	}
	
	
	
	private void moveArrayEstoque(){
		try {
			estocado.addAll(BancoDeDados.listarEstoque());
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage() + "\nTente novamente.","Erro",JOptionPane.WARNING_MESSAGE);
		}

	}

	private void clienteTexto(){
		nomeLabel = new JLabel("Nome");
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
		
	
		middle.add(add);
		
		
	}
		
	private void getCliente(){
		nome = nomeField.getText();
		rg = rgField.getText();
		cpf = cpfField.getText();
		telefonefixo = telefonefixoField.getText();
		celular = celularField.getText();
		
		System.out.println(nome);
	}
	
	
	private void produtoTexto(){
		nomeLabel = new JLabel("Nome");
		JLabel descricaoLabel = new JLabel("Descrição");
		JLabel precoCustoLabel = new JLabel("Preço de custo");
		JLabel porcentagemLabel = new JLabel("Porcentagem");
		JLabel quantidadeLabel = new JLabel("Quantidade");
		JLabel idLabel = new JLabel("ID");
		
		
		
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
	private void getProduto(){
		nome = nomeField.getText();
		descricao = descricaoField.getText();
		precoCusto = precoCustoField.getText();
		porcentagem = porcentagemField.getText();
		quantidade = quantidadeField.getText();
		id = idField.getText();
	}
}
