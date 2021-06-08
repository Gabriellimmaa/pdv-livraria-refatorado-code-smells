package br.livraria.tela.operacional;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

public class TelaVenda {

	private JFrame frame;
	private JTable table;
	private JTextField textCodigo;
	private JTextField textQtd;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaVenda window = new TelaVenda();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaVenda() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 533, 454);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 189, 497, 215);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(table);
		
		textCodigo = new JTextField();
		textCodigo.setBounds(10, 46, 114, 31);
		frame.getContentPane().add(textCodigo);
		textCodigo.setColumns(10);
		
		JLabel lblCodigo = new JLabel("C\u00F3digo");
		lblCodigo.setBounds(10, 21, 46, 14);
		frame.getContentPane().add(lblCodigo);
		
		textQtd = new JTextField();
		textQtd.setBounds(164, 46, 60, 31);
		frame.getContentPane().add(textQtd);
		textQtd.setColumns(10);
		
		JLabel lblQtd = new JLabel("Quantidade");
		lblQtd.setBounds(164, 21, 60, 14);
		frame.getContentPane().add(lblQtd);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(245, 38, 89, 46);
		frame.getContentPane().add(btnOk);
		
		JLabel lblPreco = new JLabel("Total:");
		lblPreco.setBounds(362, 54, 46, 14);
		frame.getContentPane().add(lblPreco);
		
		textField = new JTextField();
		textField.setBounds(10, 106, 114, 31);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblCodFunc = new JLabel("C\u00F3digo Funcion\u00E1rio");
		lblCodFunc.setBounds(10, 88, 114, 14);
		frame.getContentPane().add(lblCodFunc);
	}

}
