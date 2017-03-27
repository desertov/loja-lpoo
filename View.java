package graphics;

import banco.BancoDeDados;

public class View {

	public static void main(String[] args) {
		BancoDeDados database = new BancoDeDados();
		InterfaceGrafica grafica = new InterfaceGrafica(database);
		grafica.setLocationRelativeTo(null);
		grafica.setVisible(true);

	}

}
