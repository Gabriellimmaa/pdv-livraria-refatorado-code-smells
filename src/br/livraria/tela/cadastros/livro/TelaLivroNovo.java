package br.livraria.tela.cadastros.livro;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.livraria.dao.LivroDAO;
import br.livraria.model.Editora;
import br.livraria.model.Funcionario;
import br.livraria.model.Livro;

public class TelaLivroNovo {

	private JFrame frame;
	private JTextField textTitulo;
	private JTextField textAutor;
	private JTextField textGenero;
	private JTextField textCodEditora;
	private JTextField textPublicacao;
	private JTextField textEstoque;
	private Funcionario funcionario;
	private JTextField textPreco;

	/**
	 * Create the application.
	 */
	public TelaLivroNovo(Funcionario funcionario) {
		this.funcionario = funcionario;	
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 462, 410);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textTitulo = new JTextField();
		textTitulo.setColumns(10);
		textTitulo.setBounds(46, 63, 134, 33);
		frame.getContentPane().add(textTitulo);
		
		textAutor = new JTextField();
		textAutor.setColumns(10);
		textAutor.setBounds(46, 125, 134, 33);
		frame.getContentPane().add(textAutor);
		
		textGenero = new JTextField();
		textGenero.setColumns(10);
		textGenero.setBounds(46, 192, 134, 33);
		frame.getContentPane().add(textGenero);
		
		textCodEditora = new JTextField();
		textCodEditora.setColumns(10);
		textCodEditora.setBounds(271, 63, 134, 33);
		frame.getContentPane().add(textCodEditora);
		
		textPublicacao = new JTextField();
		textPublicacao.setColumns(10);
		textPublicacao.setBounds(271, 125, 134, 33);
		frame.getContentPane().add(textPublicacao);
		
		textEstoque = new JTextField();
		textEstoque.setColumns(10);
		textEstoque.setBounds(271, 192, 134, 33);
		frame.getContentPane().add(textEstoque);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				Livro livro = new Livro();
				Editora editora = new Editora();
				Date data = new Date();
				
				livro.setTitulo(textTitulo.getText());
				livro.setGenero(textGenero.getText());
				livro.setAutor(textAutor.getText());
				data.setDate((int) Date.parse(textPublicacao.getText()));
				editora.setId(Integer.parseInt(textCodEditora.getText()));
				livro.setDataPublicada(data);
				livro.setEditora(editora);
				livro.setPrecoUnit(Integer.parseInt(textPreco.getText()));
				livro.setQtdEstoque(Integer.parseInt(textEstoque.getText()));
				
				LivroDAO livroDao = new LivroDAO();
				
				livroDao.save(livro);
				
			}
		});
		btnSalvar.setForeground(Color.BLACK);
		btnSalvar.setBackground(Color.BLUE);
		btnSalvar.setBounds(46, 312, 110, 33);
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
		btnCancelar.setBounds(271, 312, 110, 33);
		frame.getContentPane().add(btnCancelar);
		
		JLabel lblTitulo = new JLabel("Titulo");
		lblTitulo.setBounds(46, 45, 46, 14);
		frame.getContentPane().add(lblTitulo);
		
		JLabel lblAutor = new JLabel("Autor");
		lblAutor.setBounds(46, 107, 46, 14);
		frame.getContentPane().add(lblAutor);
		
		JLabel lblGenero = new JLabel("Genero");
		lblGenero.setBounds(46, 169, 46, 14);
		frame.getContentPane().add(lblGenero);
		
		JLabel lblEstoque = new JLabel("Estoque");
		lblEstoque.setBounds(271, 169, 46, 14);
		frame.getContentPane().add(lblEstoque);
		
		JLabel lblPublicacao = new JLabel("Publicacao");
		lblPublicacao.setBounds(271, 107, 74, 14);
		frame.getContentPane().add(lblPublicacao);
		
		JLabel lblCodEditora = new JLabel("Codigo Editora");
		lblCodEditora.setBounds(271, 45, 104, 14);
		frame.getContentPane().add(lblCodEditora);
		
		JLabel lblPreco = new JLabel("Preco");
		lblPreco.setBounds(46, 246, 46, 14);
		frame.getContentPane().add(lblPreco);
		
		textPreco = new JTextField();
		textPreco.setColumns(10);
		textPreco.setBounds(46, 261, 134, 33);
		frame.getContentPane().add(textPreco);
		
		frame.setVisible(true);
	}
}
