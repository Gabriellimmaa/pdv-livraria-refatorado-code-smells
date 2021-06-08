package br.livraria.tela.operacional;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.livraria.aplicacao.operacional.HistoricoApp;
import br.livraria.model.Funcionario;

public class TelaHistorico {

	Funcionario funcionario;
	
	private JFrame frame;
	private JTable table;
	
	/**
	 * Create the application.
	 * @param funcionario 
	 */
	public TelaHistorico(Funcionario funcionario) {
		
		this.funcionario = funcionario;
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 505, 523);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Gerenciar Editoras");
		frame.setLocationRelativeTo(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 174, 469, 299);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new HistoricoApp().getPedidos(),
			new String[] {
				"ID", "Total", "Data", "Funcionario"
			}
		));
		scrollPane.setViewportView(table);
		
		frame.setVisible(true);
	}
}