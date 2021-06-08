package br.livraria.tela.cadastros.livro;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.livraria.aplicacao.cadastros.LivroApp;
import br.livraria.dao.LivroDAO;
import br.livraria.model.Funcionario;
import br.livraria.model.Livro;

public class TelaLivroDelete {

	private JFrame frame;
	private JLabel textTitulo;
	private JLabel textAutor;
	private JLabel textGenero;
	private JLabel textCodEditora;
	private JLabel textPublicacao;
	private JLabel textEstoque;
	private JTextField textId;
	private Funcionario funcionario;
	private JLabel textPreco;



	/**
	 * Create the application.
	 */
	public TelaLivroDelete(Funcionario funcionario) {
		this.funcionario = funcionario;
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 462, 466);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Deletar Livro");
		frame.setLocationRelativeTo(null);
		
		textTitulo = new JLabel("");
		textTitulo.setBounds(46, 120, 134, 33);
		frame.getContentPane().add(textTitulo);
		
		textAutor = new JLabel("");
		textAutor.setBounds(46, 189, 134, 33);
		frame.getContentPane().add(textAutor);
		
		textGenero = new JLabel("");
		textGenero.setBounds(46, 258, 134, 33);
		frame.getContentPane().add(textGenero);
		
		textCodEditora = new JLabel("");
		textCodEditora.setBounds(271, 120, 134, 33);
		frame.getContentPane().add(textCodEditora);
		
		textPublicacao = new JLabel("");
		textPublicacao.setBounds(271, 189, 134, 33);
		frame.getContentPane().add(textPublicacao);
		
		textEstoque = new JLabel("");
		textEstoque.setBounds(271, 258, 134, 33);
		frame.getContentPane().add(textEstoque);
		
		JButton btnSalvar = new JButton("Remover");
		btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				LivroDAO livroDAO = new LivroDAO();
				
				livroDAO.deleteByID(Integer.parseInt(textId.getText()));
				
				new TelaLivro(funcionario);
				
				frame.dispose();
				
			}
		});
		btnSalvar.setForeground(Color.BLACK);
		btnSalvar.setBackground(Color.BLUE);
		btnSalvar.setBounds(46, 383, 110, 33);
		frame.getContentPane().add(btnSalvar);
		
		JButton btnCancelar = new JButton("Voltar");
		btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				new TelaLivro(funcionario);
				
				frame.dispose();
				
			}
		});
		btnCancelar.setBackground(Color.WHITE);
		btnCancelar.setBounds(265, 383, 110, 33);
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
		
		textPreco = new JLabel("");
		textPreco.setBounds(46, 327, 134, 33);
		frame.getContentPane().add(textPreco);
		
		JLabel lblPreco = new JLabel("Preco");
		lblPreco.setBounds(46, 302, 46, 14);
		frame.getContentPane().add(lblPreco);
		
		textId = new JTextField();
		textId.setBounds(10, 33, 127, 27);
		frame.getContentPane().add(textId);
		textId.setColumns(10);
		
		JButton btnNewButton = new JButton("Pesquisar");
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String inputId = textId.getText();
				
				int id = Integer.parseInt(inputId);
				
				Livro livro = new LivroApp().getLivro(id);
				
				if(livro == null) {
					JOptionPane.showMessageDialog(new JFrame(), "ID nao encontrado");
				} else {
					
					textAutor.setText(livro.getAutor());
					textCodEditora.setText(livro.getEditora().getId() + "");
					textEstoque.setText(livro.getQtdEstoque() + "");
					textGenero.setText(livro.getGenero());
					textId.setText(livro.getId() + ""); 
					textPublicacao.setText(livro.getDataPublicada() + "");
					textTitulo.setText(livro.getTitulo());
					textPreco.setText(livro.getPrecoUnit() + "");
					
				}
				
			}
		});
		btnNewButton.setBounds(147, 30, 94, 33);
		frame.getContentPane().add(btnNewButton);
		
		frame.setVisible(true);
	}
}
