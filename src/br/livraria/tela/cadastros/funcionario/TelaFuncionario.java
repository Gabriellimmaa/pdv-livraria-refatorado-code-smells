package br.livraria.tela.cadastros.funcionario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.livraria.aplicacao.cadastros.EditoraApp;
import br.livraria.aplicacao.cadastros.FuncionarioApp;
import br.livraria.model.Funcionario;
import br.livraria.tela.cadastros.TelaCadastros;

public class TelaFuncionario {

	Funcionario funcionario;
	
	private JFrame frame;
	private JTextField textField;
	private JTable table;

	/**
	 * Create the application.
	 * @param funcionario 
	 */
	public TelaFuncionario(Funcionario funcionario) {
		
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
		
		JButton btnNewButton = new JButton("Novo");
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				new TelaFuncionarioNovo(funcionario);
				
				frame.dispose();
				
				
			}
		});
		btnNewButton.setBounds(10, 22, 99, 35);
		frame.getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(237, 26, 126, 27);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Pesquisar");
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String busca = textField.getText();
				
				Vector<Funcionario> funcionarios = new FuncionarioApp().pesquisar(busca);
				
				table.setModel(new DefaultTableModel(
						new FuncionarioApp().getFuncionarios(funcionarios),
						new String[] {
							"ID", "Nome", "CPF", "Endereco", "Cidade", "Estado", "Email", "Telefone", "Contrato", "Senha"
						}
					));
				
			}
		});
		btnNewButton_1.setBounds(374, 22, 105, 35);
		frame.getContentPane().add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 174, 469, 299);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new EditoraApp().getEditoras(),
			new String[] {
					"ID", "Nome", "CPF", "Endereco", "Cidade", "Estado", "Email", "Telefone", "Contrato", "Senha"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_2 = new JButton("Editar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new TelaFuncionarioUpdate(funcionario);
				
				frame.dispose();
				
			}
		});
		btnNewButton_2.setBounds(10, 70, 99, 35);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Deletar");
		btnNewButton_3.setBounds(10, 116, 99, 35);
		frame.getContentPane().add(btnNewButton_3);
		
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new TelaCadastros(funcionario);
				
				frame.dispose();
				
				
				
			}
		});
		btnVoltar.setBounds(384, 76, 89, 23);
		frame.getContentPane().add(btnVoltar);
		
		frame.setVisible(true);
	}
}