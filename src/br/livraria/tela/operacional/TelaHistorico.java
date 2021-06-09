package br.livraria.tela.operacional;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.livraria.aplicacao.operacional.HistoricoApp;
import br.livraria.model.Funcionario;
import br.livraria.tela.TelaMenu;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

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
		frame.setBounds(100, 100, 505, 413);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Historico");
		frame.setLocationRelativeTo(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 469, 299);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new HistoricoApp().getPedidos(),
			new String[] {
				"ID", "Total", "Data", "Funcionario"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				new TelaMenu(funcionario);
				
				frame.dispose();
			}
		});
		btnNewButton.setBounds(166, 321, 147, 42);
		frame.getContentPane().add(btnNewButton);
		
		frame.setVisible(true);
	}
}