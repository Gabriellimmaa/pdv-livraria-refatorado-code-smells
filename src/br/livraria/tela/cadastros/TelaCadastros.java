package br.livraria.tela.cadastros;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.livraria.model.Funcionario;
import br.livraria.tela.TelaMenu;
import br.livraria.tela.cadastros.editora.TelaEditora;
import br.livraria.tela.cadastros.funcionario.TelaFuncionario;
import br.livraria.tela.cadastros.livro.TelaLivro;

public class TelaCadastros extends JFrame {

	private static final long serialVersionUID = -7758410836434830876L;
	
	private JPanel contentPane;

	public TelaCadastros(Funcionario funcionario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("Cadastros");
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelNome = new JLabel(funcionario.toString());
		labelNome.setHorizontalAlignment(SwingConstants.CENTER);
		labelNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		labelNome.setBounds(10, 23, 212, 46);
		contentPane.add(labelNome);
		
		JButton btnFuncionarios = new JButton("Funcionarios");
		btnFuncionarios.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				new TelaFuncionario(funcionario);
				
				dispose();
			}
		});
		btnFuncionarios.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnFuncionarios.setBounds(10, 123, 127, 78);
		contentPane.add(btnFuncionarios);
		
		JButton btnOperacional = new JButton("Livros");
		btnOperacional.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				new TelaLivro(funcionario);
				
				dispose();
				
			}
		});
		btnOperacional.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnOperacional.setBounds(147, 123, 140, 78);
		contentPane.add(btnOperacional);
		
		JButton btnEditoras = new JButton("Editoras");
		btnEditoras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new TelaEditora(funcionario);
				
				dispose();
				
			}
		});
		btnEditoras.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEditoras.setBounds(297, 123, 127, 78);
		contentPane.add(btnEditoras);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				new TelaMenu(funcionario);
				
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnVoltar.setBounds(297, 23, 120, 46);
		contentPane.add(btnVoltar);
		
		setVisible(true);
	}
}
