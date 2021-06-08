package br.livraria.tela.cadastros.livro;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.livraria.aplicacao.cadastros.EditoraApp;
import br.livraria.aplicacao.cadastros.LivroApp;
import br.livraria.dao.LivroDAO;
import br.livraria.model.Editora;
import br.livraria.model.Funcionario;
import br.livraria.model.Livro;

public class TelaLivroUpdate {

	private JFrame frame;
	private JTextField textTitulo;
	private JTextField textAutor;
	private JTextField textGenero;
	private JTextField textCodEditora;
	private JTextField textPublicacao;
	private JTextField textEstoque;
	private JTextField textId;
	private Funcionario funcionario;
	private JTextField textPreco;



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
		frame.setBounds(100, 100, 462, 466);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Editar Livro");
		frame.setLocationRelativeTo(null);
		
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
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Editora editora = new EditoraApp().getEditora(Integer.parseInt(textCodEditora.getText()));
				
				if(editora != null) {
					SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
					Date dataFormatada = null;
					try {
						dataFormatada = formato.parse(textPublicacao.getText());
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
					
					Livro livro = new Livro();
					
					livro.setAutor(textAutor.getText());
					livro.setDataPublicada(dataFormatada);
					livro.setEditora(editora);
					livro.setGenero(textGenero.getText());
					livro.setId(Integer.parseInt(textId.getText()));
					livro.setPrecoUnit(Double.parseDouble(textPreco.getText()));
					livro.setQtdEstoque(Integer.parseInt(textEstoque.getText()));
					livro.setTitulo(textTitulo.getText());
					
					LivroDAO livroDAO = new LivroDAO();
					
					livroDAO.update(livro);
					
					new TelaLivro(funcionario);
					
					frame.dispose();
				} else {
					JOptionPane.showMessageDialog(new JFrame(), "Editora nao registrada");
				}
				
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
		
		textPreco = new JTextField();
		textPreco.setColumns(10);	
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
