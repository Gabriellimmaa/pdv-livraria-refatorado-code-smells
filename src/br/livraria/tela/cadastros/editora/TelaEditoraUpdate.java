package br.livraria.tela.cadastros.editora;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.livraria.aplicacao.cadastros.EditoraApp;
import br.livraria.dao.EditoraDAO;
import br.livraria.model.Editora;
import br.livraria.model.Funcionario;

public class TelaEditoraUpdate {
	
	Funcionario funcionario;

	private JFrame frame;
	private JTextField inputCnpj;
	private JTextField inputNome;
	private JTextField inputEndereco;
	private JTextField inputId;

	/**
	 * Create the application.
	 */
	public TelaEditoraUpdate(Funcionario funcionario) {
		
		this.funcionario = funcionario;
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 405, 339);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Editar Editora");
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		inputCnpj = new JTextField();
		inputCnpj.setColumns(10);
		inputCnpj.setBounds(10, 108, 134, 33);
		frame.getContentPane().add(inputCnpj);
		
		inputNome = new JTextField();
		inputNome.setColumns(10);
		inputNome.setBounds(246, 108, 134, 33);
		frame.getContentPane().add(inputNome);
		
		inputEndereco = new JTextField();
		inputEndereco.setColumns(10);
		inputEndereco.setBounds(10, 179, 134, 33);
		frame.getContentPane().add(inputEndereco);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				Editora editoraAtualizada = new Editora();
				
				editoraAtualizada.setCnpj(inputCnpj.getText());
				editoraAtualizada.setNome(inputNome.getText());
				editoraAtualizada.setEndereco(inputEndereco.getText());
				editoraAtualizada.setId(Integer.parseInt(inputId.getText()));
				
				System.out.println(editoraAtualizada.getNome());
				
				EditoraDAO editoraDAO = new EditoraDAO();
				
				editoraDAO.update(editoraAtualizada);
				
			}
		});
		btnSalvar.setForeground(Color.BLACK);
		btnSalvar.setBackground(Color.BLUE);
		btnSalvar.setBounds(81, 238, 110, 33);
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
		btnCancelar.setBounds(246, 238, 110, 33);
		frame.getContentPane().add(btnCancelar);
		
		JLabel lblNewLabel_2_1 = new JLabel("CNPJ");
		lblNewLabel_2_1.setBounds(10, 95, 46, 14);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_4 = new JLabel("Endereco");
		lblNewLabel_2_4.setBounds(10, 164, 74, 14);
		frame.getContentPane().add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_2_5 = new JLabel("Nome");
		lblNewLabel_2_5.setBounds(246, 95, 104, 14);
		frame.getContentPane().add(lblNewLabel_2_5);
		
		inputId = new JTextField();
		inputId.setBounds(10, 33, 127, 27);
		frame.getContentPane().add(inputId);
		inputId.setColumns(10);
		
		JButton btnNewButton = new JButton("Pesquisar");
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String input = inputId.getText();
				
				int id = Integer.parseInt(input);
				
				Editora editora = new EditoraApp().getEditora(id);
				
				inputCnpj.setText(editora.getCnpj());
				inputNome.setText(editora.getNome());
				inputEndereco.setText(editora.getEndereco());
				inputId.setText(editora.getId() + "");
				
			}
		});
		btnNewButton.setBounds(138, 30, 94, 33);
		frame.getContentPane().add(btnNewButton);
		
		frame.setVisible(true);
	}
}
