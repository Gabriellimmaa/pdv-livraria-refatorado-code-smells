package br.livraria.tela.cadastros.editora;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.livraria.dao.EditoraDAO;
import br.livraria.model.Editora;
import br.livraria.model.Funcionario;

public class TelaEditoraNovo {

	private JFrame frame;
	private JTextField inputCnpj;
	private JTextField inputNome;
	private JTextField inputEndereco;
	private Funcionario funcionario;

	/**
	 * Create the application.
	 */
	public TelaEditoraNovo(Funcionario funcionario) {
		this.funcionario = funcionario;
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 384, 277);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Nova Editora");
		frame.setLocationRelativeTo(null);
		
		inputCnpj = new JTextField();
		inputCnpj.setColumns(10);
		inputCnpj.setBounds(10, 63, 134, 33);
		frame.getContentPane().add(inputCnpj);
		
		inputNome = new JTextField();
		inputNome.setColumns(10);
		inputNome.setBounds(217, 63, 134, 33);
		frame.getContentPane().add(inputNome);
		
		inputEndereco = new JTextField();
		inputEndereco.setColumns(10);
		inputEndereco.setBounds(10, 124, 134, 33);
		frame.getContentPane().add(inputEndereco);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				Editora editora = new Editora();
				
				editora.setNome(inputNome.getText());
				editora.setCnpj(inputCnpj.getText());
				editora.setEndereco(inputEndereco.getText());
				
				EditoraDAO editoraDAO = new EditoraDAO();
				
				editoraDAO.save(editora);
				
				new TelaEditora(funcionario);
				
				frame.dispose();
				
			}
		});
		btnSalvar.setForeground(Color.BLACK);
		btnSalvar.setBackground(Color.BLUE);
		btnSalvar.setBounds(77, 184, 110, 33);
		frame.getContentPane().add(btnSalvar);
		
		JButton btnCancelar = new JButton("Voltar");
		btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				new TelaEditora(funcionario);
				
				frame.dispose();
				
			}
		});
		btnCancelar.setBackground(Color.WHITE);
		btnCancelar.setBounds(217, 184, 110, 33);
		frame.getContentPane().add(btnCancelar);
		
		JLabel lblNewLabel_2_1 = new JLabel("CNPJ");
		lblNewLabel_2_1.setBounds(35, 45, 46, 14);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_4 = new JLabel("Endereco");
		lblNewLabel_2_4.setBounds(10, 112, 74, 14);
		frame.getContentPane().add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_2_5 = new JLabel("Nome");
		lblNewLabel_2_5.setBounds(217, 45, 104, 14);
		frame.getContentPane().add(lblNewLabel_2_5);
		
		frame.setVisible(true);
	}
}
