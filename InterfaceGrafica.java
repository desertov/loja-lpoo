package graphics;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.TextField;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import pessoa.Cliente;

public class InterfaceGrafica extends JFrame{
		
	private JMenu cadastro, edit, search, list, exit;
	private JPanel middle, left;
	private JLabel label;
	
		public InterfaceGrafica(){
			super("Loja de Presentes");
			setLayout(new BorderLayout(10,10));
			middle = new JPanel();
			left = new JPanel();
			left.setLayout(new FlowLayout());
			add(left, BorderLayout.WEST);
			middle.setLayout(new FlowLayout());
			add(middle, BorderLayout.CENTER);
			label = new JLabel("Status");
			add(label, BorderLayout.SOUTH);
			
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			
			JMenuBar menu = createMenu();
			setJMenuBar(menu);
		
		}
		
		public JMenuBar createMenu(){
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
		
		public void createSubMenu(){
			JMenuItem cliente = new JMenuItem("Cliente");
			JMenuItem produto = new JMenuItem("Produto");
			JMenuItem cliente2 = new JMenuItem("Cliente");
			JMenuItem produto2 = new JMenuItem("Produto");
			JMenuItem cliente3 = new JMenuItem("Cliente");
			JMenuItem produto3 = new JMenuItem("Produto");
			JMenuItem estoque = new JMenuItem("Estoque");
			JMenuItem debito = new JMenuItem("Clientes em débito");
			JLabel nomeLabel = new JLabel("Nome");
			
			cadastro.add(cliente);
			cadastro.add(produto);
			edit.add(cliente2);
			edit.add(produto2);
			search.add(cliente3);
			search.add(produto3);
			list.add(estoque);
			list.add(debito);
			
			cliente.addActionListener(e->{
				middle.removeAll();
				left.add(nomeLabel);
				TextField nomeField = new TextField(32);
				left.add(nomeField);
				left.updateUI();
				middle.updateUI();
				nomeField.getText();
				
			});
			
		}
	
	
}
