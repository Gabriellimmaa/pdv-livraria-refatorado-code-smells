package br.livraria.tela.cadastros.editora;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.livraria.dao.EditoraDAO;
import br.livraria.model.Editora;
import br.livraria.model.Funcionario;

public class TelaEditoraDelete {	
	
	private Funcionario funcionario;

	private JFrame frame;
	private JTextField inputId;

	/**
	 * Create the application.
	 */
	public TelaEditoraDelete(Funcionario funcionario) {
		
		this.funcionario = funcionario;
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 417, 321);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Deletar Editora");
		frame.setLocationRelativeTo(null);
		
		JButton btnDelete = new JButton("Remover");
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				EditoraDAO editoraDAO = new EditoraDAO();
				
				int id = Integer.parseInt(inputId.getText());
				editoraDAO.deleteByID(id);
				
				new TelaEditora(funcionario);
				
				frame.dispose();
				
			}
		});
		btnDelete.setForeground(Color.BLACK);
		btnDelete.setBackground(Color.BLUE);
		btnDelete.setBounds(46, 236, 110, 33);
		frame.getContentPane().add(btnDelete);
		
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
		btnCancelar.setBounds(254, 236, 110, 33);
		frame.getContentPane().add(btnCancelar);
		
		JLabel lblNewLabel_2 = new JLabel("ID:");
		lblNewLabel_2.setBounds(46, 95, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Nome:");
		lblNewLabel_2_1.setBounds(46, 164, 46, 14);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_4 = new JLabel("Endereco:");
		lblNewLabel_2_4.setBounds(265, 164, 74, 14);
		frame.getContentPane().add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_2_5 = new JLabel("CNPJ:");
		lblNewLabel_2_5.setBounds(265, 95, 104, 14);
		frame.getContentPane().add(lblNewLabel_2_5);
		
		inputId = new JTextField();
		inputId.setBounds(10, 33, 127, 27);
		frame.getContentPane().add(inputId);
		inputId.setColumns(10);
		
		JLabel labelId = new JLabel("");
		labelId.setBounds(46, 128, 91, 14);
		frame.getContentPane().add(labelId);
		
		JLabel labelNome = new JLabel("");
		labelNome.setBounds(46, 195, 91, 14);
		frame.getContentPane().add(labelNome);
		
		JLabel labelCnpj = new JLabel("");
		labelCnpj.setBounds(265, 128, 138, 14);
		frame.getContentPane().add(labelCnpj);
		
		JLabel labelEndereco = new JLabel("");
		labelEndereco.setBounds(265, 195, 94, 14);
		frame.getContentPane().add(labelEndereco);
		
		JButton btnNewButton = new JButton("Pesquisar");
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				int id = Integer.parseInt(inputId.getText());
				
				EditoraDAO editoraDAO = new EditoraDAO();
				
				Vector<Editora> editoras = editoraDAO.getEditoras();
				
				Editora editora = null;
				
				for(int i = 0; i < editoras.size(); i++) {
					if(editoras.get(i).getId() == id) {
						editora = editoras.get(i);
					}
				}
				
				if(editora == null) {
					JOptionPane.showMessageDialog(new JFrame(), "ID nao encontrado");
				} else {
					labelId.setText(editora.getId() + "");
					labelNome.setText(editora.getNome());
					labelCnpj.setText(editora.getCnpj());
					labelEndereco.setText(editora.getEndereco());
				}
				
			}
		});
		btnNewButton.setBounds(147, 30, 94, 33);
		frame.getContentPane().add(btnNewButton);
		
		frame.setVisible(true);
		
	}
}
