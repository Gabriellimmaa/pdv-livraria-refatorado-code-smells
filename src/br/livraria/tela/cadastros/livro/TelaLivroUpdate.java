package br.livraria.tela.cadastros.livro;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.livraria.model.Funcionario;

public class TelaLivroUpdate {

	private JFrame frame;
	private JTextField textTitulo;
	private JTextField textAutor;
	private JTextField textGenero;
	private JTextField textCodEditora;
	private JTextField textPublicacao;
	private JTextField textEstoque;
	private JTextField textField_6;
	private Funcionario funcionario;



	/**
	 * Create the application.
	 */
	public TelaLivroUpdate(Funcionario funcionario) {
		this.funcionario = funcionario;
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 462, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textTitulo = new JTextField();
		textTitulo.setColumns(10);
		textTitulo.setBounds(46, 120, 134, 33);
		frame.getContentPane().add(textTitulo);
		
		textAutor = new JTextField();
		textAutor.setColumns(10);
		textAutor.setBounds(46, 189, 134, 33);
		frame.getContentPane().add(textAutor);
		
		textGenero = new JTextField();
		textGenero.setColumns(10);
		textGenero.setBounds(46, 258, 134, 33);
		frame.getContentPane().add(textGenero);
		
		textCodEditora = new JTextField();
		textCodEditora.setColumns(10);
		textCodEditora.setBounds(271, 120, 134, 33);
		frame.getContentPane().add(textCodEditora);
		
		textPublicacao = new JTextField();
		textPublicacao.setColumns(10);
		textPublicacao.setBounds(271, 189, 134, 33);
		frame.getContentPane().add(textPublicacao);
		
		textEstoque = new JTextField();
		textEstoque.setColumns(10);
		textEstoque.setBounds(271, 258, 134, 33);
		frame.getContentPane().add(textEstoque);
		
		JButton btnSalvar = new JButton("Editar");
		btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnSalvar.setForeground(Color.BLACK);
		btnSalvar.setBackground(Color.BLUE);
		btnSalvar.setBounds(70, 302, 110, 33);
		frame.getContentPane().add(btnSalvar);
		
		JButton btnCancelar = new JButton("cancelar");
		btnCancelar.setBackground(Color.WHITE);
		btnCancelar.setBounds(265, 302, 110, 33);
		frame.getContentPane().add(btnCancelar);
		
		JLabel lblTitulo = new JLabel("Titulo");
		lblTitulo.setBounds(46, 95, 46, 14);
		frame.getContentPane().add(lblTitulo);
		
		JLabel lblAutor = new JLabel("Autor");
		lblAutor.setBounds(46, 164, 46, 14);
		frame.getContentPane().add(lblAutor);
		
		JLabel lblGenero = new JLabel("Genero");
		lblGenero.setBounds(46, 233, 46, 14);
		frame.getContentPane().add(lblGenero);
		
		JLabel lblEstoque = new JLabel("Estoque");
		lblEstoque.setBounds(271, 233, 46, 14);
		frame.getContentPane().add(lblEstoque);
		
		JLabel lblPublicacao = new JLabel("Publicacao");
		lblPublicacao.setBounds(271, 164, 74, 14);
		frame.getContentPane().add(lblPublicacao);
		
		JLabel lblEditoraCod = new JLabel("Codigo Editora");
		lblEditoraCod.setBounds(271, 95, 104, 14);
		frame.getContentPane().add(lblEditoraCod);
		
		textField_6 = new JTextField();
		textField_6.setBounds(10, 33, 127, 27);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnNewButton = new JButton("Pesquisar");
		btnNewButton.setBounds(147, 30, 94, 33);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new TelaLivro(funcionario);
				
				frame.dispose();
				
			}
		});
		btnVoltar.setBounds(316, 35, 89, 23);
		frame.getContentPane().add(btnVoltar);
		
		frame.setVisible(true);
	}
}
