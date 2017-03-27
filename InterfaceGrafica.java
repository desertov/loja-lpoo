package graphics;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import banco.BancoDeDados;
import pessoa.Cliente;
import pessoa.Pessoa;
import produto.Acessorios;
import produto.Cosmeticos;
import produto.Estoque;
import produto.Perfumaria;
import produto.Produtos;

public class InterfaceGrafica extends JFrame{
		
	private JMenu cadastro, edit, search, list, remove;
	private JPanel middle, left;
	private JLabel label;
	
	private JMenuItem cliente1, cliente2, cliente3;
	private JMenu produto;
	private JMenuItem produto2, produto3;
	private JMenuItem estoque;
	private JMenuItem cliente4;
	
	private JMenuItem acessorio1;
	private JMenuItem cosmetico1;
	private JMenuItem perfumaria1;
	
	private JMenuItem cliente5;
	private JMenuItem produto5;
	
	private JButton add = new JButton("Adicionar");
	private JButton src = new JButton("Procurar Cliente");
	private JButton src2 = new JButton("Procurar Produto");
	private JButton alt = new JButton("Alterar");
	private JButton rmv = new JButton("Remover");
	
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
	
	private TextField pkey;
	
	private JLabel nomeLabel;//DECIDIR SE É GLOBAL
	
	private JTable myTable;
	private JScrollPane scroll;
	
	private ArrayList<Estoque> estocado = new ArrayList<Estoque>();
	private ArrayList<Cliente> clientela = new ArrayList<Cliente>();
	
	private String nome, rg, cpf, telefonefixo, celular;
	private String descricao, precoCusto, porcentagem, quantidade, id;
	
	private Pessoa cliente;
	private Acessorios acessorio;
	private Produtos pro; 
	
		
	private BancoDeDados bd;
	
	
	public InterfaceGrafica(BancoDeDados banco){
		super("Loja de Presentes");
		setLayout(new BorderLayout(0,0));
		middle = new JPanel(new FlowLayout());
		left = new JPanel(new FlowLayout());
		add(left, BorderLayout.WEST);
		add(middle, BorderLayout.CENTER);
		label = new JLabel("Status");
		add(label, BorderLayout.SOUTH);
		this.bd = banco;
		instancia();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,500);
		JMenuBar menu = createMenu();
		setJMenuBar(menu);
		
		}
		
	private JMenuBar createMenu(){
		JMenuBar menu = new JMenuBar(); 
		cadastro = new JMenu("Cadastrar");
		edit = new JMenu("Editar");
		search = new JMenu("Procurar");
		list = new JMenu("Listar");
		remove = new JMenu("Remover");

		createSubMenu();
			
		menu.add(cadastro);
		menu.add(edit);
		menu.add(search);
		menu.add(list);
		menu.add(remove);
			
		return menu;
		}
		
	private void createSubMenu(){		
		cliente1 = new JMenuItem("Cliente");
		produto = new JMenu("Produto");
		cliente2 = new JMenuItem("Cliente");
		produto2 = new JMenuItem("Produto");
		cliente3 = new JMenuItem("Cliente");
		produto3 = new JMenuItem("Produto");
		estoque = new JMenuItem("Estoque");
		cliente4 = new JMenuItem("Clientes");
		acessorio1 = new JMenuItem("Acessório");
		cosmetico1 = new JMenuItem("Cosmético");
		perfumaria1 = new JMenuItem("Perfumaria");
		cliente5 = new JMenuItem("Cliente");
		produto5 = new JMenuItem("Produto");
		
		cadastro.add(cliente1);
		cadastro.add(produto);
		produto.add(acessorio1);
		produto.add(cosmetico1);
		produto.add(perfumaria1);
		edit.add(cliente2);
		edit.add(produto2);
		search.add(cliente3);
		search.add(produto3);
		list.add(estoque);
		list.add(cliente4);
		remove.add(cliente5);
		remove.add(produto5);
		
		createListeners();
	}
	
	
	
	
	private void createListeners(){		
		cliente1.addActionListener(e-> {
			if(label.getText().equals("Adicionando um cliente"))
				setSize(297, 400);
			label.setText("Adicionando um cliente");
			clienteTexto();
			
			add.addActionListener(e1->{
				getCliente();
				try {
					Pessoa cli = new Cliente(nome,rg,cpf,telefonefixo,celular);
					cli.cadastro(cli);
					label.setText("Cadastro feito com sucesso!");
				} catch (Exception e2) {
					label.setText("Verifique os campos novamente"); 
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
					label.setText("Cadastro feito com sucesso!");	
				} catch (Exception e2) {
					label.setText("Verifique os campos novamente");
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
					label.setText("Cadastro feito com sucesso!");
				}catch (Exception e2) {
					label.setText("Verifique os campos novamente");
					
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
					label.setText("Cadastro feito com sucesso!");
				}catch (Exception e2) {
					label.setText("Verifique os campos novamente");
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
			if(label.getText().equals("Campo(s) atualizado(s) com sucesso")|| label.getText().equals("Digite o CPF do cliente")){
				clean();
				setSize(295, 400);
			}
			clean();
			buscarClienteText();
			searching("update");
			Editable(true);
			middle.add(alt);
			alt.addActionListener(e1->{
				try{
					Cliente clienteEdited = new Cliente(nomeField.getText(),rgField.getText(),cliente.getCpf(),telefonefixoField.getText(),celularField.getText());
					bd.editarCliente(clienteEdited, cliente.getCpf());
					label.setText("Campo(s) atualizado(s) com sucesso");
				}catch (Exception e2) {
					label.setText("Verifique os campos novamente");
					pkey.setEditable(true);
				}
				finally{
					clean();
				}
			});	
		});
		
		produto2.addActionListener(e->{
			if(label.getText().equals("Campo(s) atualizado(s) com sucesso")|| label.getText().equals("Digite o ID do produto")){
				clean();
				setSize(291, 500);
			}
			clean();
			buscaProdutoText();
			produtoSearch("update");
			middle.add(alt);
			alt.addActionListener(e1->{
				System.out.println(descricaoField);
				System.out.println(precoCustoField);
				System.out.println(porcentagemField);
				System.out.println(quantidadeField);
				try{			
					bd.editarProduto(precoCustoField.getText(),porcentagemField.getText(), pro.getId());
					label.setText("Campo(s) atualizado(s) com sucesso");
				}catch (Exception e2) {
					label.setText("Verifique os campos novamente");
					idField.setEditable(true);
				}
				finally{
					clean();
				}
			});
		});
		
		
		cliente3.addActionListener(busca1->{
			if(label.getText().equals("Alterando um campo de um cliente")|| label.getText().equals("Digite o CPF do cliente")){
				clean();
				setSize(300, 500);
			}
			try{
				clean();
				buscarClienteText();
				searching("");
				
				setSize(300, 450);
			}catch(Exception e){
				e.printStackTrace();
				clean();
			}
			
		});
		
		produto3.addActionListener(busca2->{
			if(label.getText().equals("Digite o ID do produto")){
				clean();
				setSize(291, 500);
			}
			try{
				clean();
				buscaProdutoText();
				produtoSearch("");
			}catch(Exception e){
				clean();
			}
		});
		
		cliente4.addActionListener(list->{
			if(label.getText().equals("Listando clientes"))
				setSize(501, 600);
			middle.removeAll();
			setSize(550, 600);
			if(myTable == null)
				moveArrayCliente();
			String[]column = {"Nome", "RG", "CPF", "Telefone Fixo", "Exibindo um telefone Celular  "};
			Object [][] clientela1 = new Object[clientela.size()][5];
			int line = 0;
				for(Cliente i:clientela){
					clientela1[line][0] = i.getNome();
					clientela1[line][1] = i.getRg();
					clientela1[line][2] = i.getCpf();
					clientela1[line][3] = i.getTelefonefixo();
					clientela1[line][4] = i.getCelular();
					line++;
				}
			myTable = new JTable(clientela1, column);
			scroll = new JScrollPane(myTable);
			middle.add(scroll);
			label.setText("Listando clientes");
			
		});
		
		cliente5.addActionListener(remove1->{
			if(label.getText().equals("Digite o CPF do cliente a ser removido")||label.getText().equals("Cliente removido com sucesso"))
				setSize(311, 500);
			removeClienteText();
			rmv.addActionListener(action->{
					try {
						bd.removeCliente(cpfField.getText());
						label.setText("Cliente removido com sucesso");
					} catch (SQLException e1) {
						label.setText("Este CPF não está cadastrado no sistema");
						e1.printStackTrace();
					}
			});
		});
		
		produto5.addActionListener(remove2->{
			if(label.getText().equals("Digite o ID do produto a ser removido")||label.getText().equals("Produto removido com sucesso"))
				setSize(311, 500);
			removeProdutoText();
			rmv.addActionListener(action->{;
				try{
					bd.removeProduto(idField.getText());
				}catch(SQLException e1){
					label.setText("Este ID não está cadastrado no sistema");
					e1.printStackTrace(); 
				}
			});
		});
		
		}
	
	private void removeClienteText(){
		JLabel cpf1 = new JLabel("CPF do cliente");
		
		label.setText("Digite o CPF do cliente a ser removido");
		middle.removeAll();;
		setSize(310, 500);
		middle.add(cpf1);
		middle.add(cpfField);
		middle.add(rmv);
	}
	
	private void removeProdutoText(){
		JLabel idLabel = new JLabel("ID do produto");
		
		label.setText("Digite o ID do produto a ser removido");
		middle.removeAll();
		setSize(310,500);
		middle.add(idLabel);
		middle.add(idField);
		middle.add(rmv);	
	}
	
	
	
	
	
	private void moveArrayCliente(){
		try {
			clientela.addAll(bd.listarCliente());
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage() + "\nTente novamente.","Erro",JOptionPane.WARNING_MESSAGE);
		}
	}
	
	
	private void buscaProdutoText(){
		JLabel id = new JLabel("ID");
		JLabel nome = new JLabel("Nome do Prduto");
		JLabel descricao = new JLabel("Descrição");
		JLabel precoCustoLabel = new JLabel("Preço de custo");
		JLabel porcentagemLabel = new JLabel("Porcentagem");
		JLabel quantidadeLabel = new JLabel("Quantidade");
		
		label.setText("Digite o ID do produto");
		middle.removeAll();;
		setSize(290, 500);
		middle.add(id);
		middle.add(idField);
		middle.add(src2);
		middle.add(nome);
		middle.add(nomeField);
		middle.add(precoCustoLabel);
		middle.add(precoCustoField);
		middle.add(descricao);
		middle.add(descricaoField);
		middle.add(quantidadeLabel);
		middle.add(quantidadeField);
		middle.add(porcentagemLabel);
		middle.add(porcentagemField);
		
		
	}
	
	private void produtoSearch(String arg){
		src2.addActionListener(srcProduto->{					
			try {
				int localId = Integer.parseInt(idField.getText());
				pro= bd.procurarProduto(localId);
				nomeField.setText(pro.getNome());
				precoCustoField.setText(pro.getPrecoCusto());
				descricaoField.setText(pro.getDescricao());
				quantidadeField.setText(pro.getQuantidade());
				porcentagemField.setText(pro.getPercentagemLucro());
				label.setText("Produto localizado com sucesso!");
				produtoEditable(false);
				if(arg.equals("update")){
					precoCustoField.setEditable(true);
					porcentagemField.setEditable(true);
				}
				else
					produtoEditable(false);
			} catch (Exception e) {		
				label.setText("Identificação não localizada ou inválida");
			}
		});
	}
	
	
	private void Editable(boolean b){
		pkey.setEditable(b);
		nomeField.setEditable(b);
		rgField.setEditable(b);
		telefonefixoField.setEditable(b);
		celularField.setEditable(b);	
	}
	private void produtoEditable(boolean b){
		idField.setEditable(b);
		nomeField.setEditable(b);
		descricaoField.setEditable(b);
		precoCustoField.setEditable(b);
		porcentagemField.setEditable(b);
		quantidadeField.setEditable(b);
	}
	
	private void instancia(){
		pkey = new TextField(32);
		nomeField = new TextField(32);
		cpfField = new TextField(32);
		rgField = new TextField(32);
		telefonefixoField = new TextField(32);
		celularField = new TextField(32);
		
		descricaoField = new TextField(32);
		precoCustoField = new TextField(32);
		porcentagemField = new TextField(32);
		quantidadeField = new TextField(32);
		idField = new TextField(32);
		
		
	}
	
	private void clean(){
		pkey.setText("");
		nomeField.setText("");
		rgField.setText("");
		telefonefixoField.setText("");
		celularField.setText("");
		
		descricaoField.setText("");
		precoCustoField.setText("");
		porcentagemField.setText("");
		quantidadeField.setText("");
		idField.setText("");
		Editable(true);
		produtoEditable(true);
	}
		
	private void buscarClienteText(){
		JLabel pkeyLabel = new JLabel("CPF do cliente a ser buscado");
		JLabel nomeLabel = new JLabel("Nome");
		JLabel rgLabel = new JLabel("RG");
		JLabel telefoneLabel = new JLabel("Telefone Fixo");
		JLabel celularLabel = new JLabel("Celular");
				
		
		
		setSize(300, 450);
		label.setText("Digite o CPF do cliente");
		middle.removeAll();
		middle.add(pkeyLabel);
		middle.add(pkey);
		middle.add(src);
		
		middle.add(nomeLabel);
		middle.add(nomeField);
		middle.add(rgLabel);
		middle.add(rgField);
		middle.add(telefoneLabel);
		middle.add(telefonefixoField);
		middle.add(celularLabel);
		middle.add(celularField);
		
	}

	private void searching(String arg){
		src.addActionListener(srcCliente->{
			String localCpf = pkey.getText();					
			try {
				cliente = bd.procurarCliente(localCpf);
				nomeField.setText(cliente.getNome());
				rgField.setText(cliente.getRg());
				telefonefixoField.setText(cliente.getTelefonefixo());
				celularField.setText(cliente.getCelular());
				Editable(false);
				if(arg.equals("update")){
					pkey.setEditable(false);
					Editable(true);
				}
				else
					Editable(false);
				label.setText("Cliente localizado com sucesso");
			} catch (Exception e) {
				label.setText("CPF não localizado ou inválido");
			}
		});
	}
	
	
	
	private void moveArrayEstoque(){
		try {
			estocado.addAll(bd.listarEstoque());
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
