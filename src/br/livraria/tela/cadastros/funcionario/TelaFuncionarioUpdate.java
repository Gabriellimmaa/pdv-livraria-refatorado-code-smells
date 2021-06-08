package br.livraria.tela.cadastros.funcionario;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.livraria.model.Funcionario;

public class TelaFuncionarioUpdate {

	private JFrame frame;
	private JTextField textNome;
	private JTextField textEndereco;
	private JTextField textCPF;
	private JTextField textCidade;
	private JTextField textEstado;
	private JTextField textTelefone;
	private JTextField textEmail;
	private JTextField textSenha;
	private JTextField textContrato;
	private JTextField textField_9;
	private JLabel lblCPF;
	private JButton btnVoltar;
	private Funcionario funcionario;


	/**
	 * Create the application.
	 */
	public TelaFuncionarioUpdate(Funcionario funcionario) {
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
		
		textNome = new JTextField();
		textNome.setColumns(10);
		textNome.setBounds(46, 100, 134, 33);
		frame.getContentPane().add(textNome);
		
		textEndereco = new JTextField();
		textEndereco.setColumns(10);
		textEndereco.setBounds(46, 161, 134, 33);
		frame.getContentPane().add(textEndereco);
		
		textCPF = new JTextField();
		textCPF.setColumns(10);
		textCPF.setBounds(271, 100, 134, 33);
		frame.getContentPane().add(textCPF);
		
		textCidade = new JTextField();
		textCidade.setColumns(10);
		textCidade.setBounds(271, 161, 134, 33);
		frame.getContentPane().add(textCidade);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setForeground(Color.BLACK);
		btnEditar.setBackground(Color.BLUE);
		btnEditar.setBounds(46, 383, 110, 33);
		frame.getContentPane().add(btnEditar);
		
		JButton btnCancelar = new JButton("cancelar");
		btnCancelar.setBackground(Color.WHITE);
		btnCancelar.setBounds(265, 383, 110, 33);
		frame.getContentPane().add(btnCancelar);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(46, 82, 46, 14);
		frame.getContentPane().add(lblNome);
		
		JLabel lblEndereco = new JLabel("Endereco");
		lblEndereco.setBounds(46, 144, 46, 14);
		frame.getContentPane().add(lblEndereco);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(271, 144, 74, 14);
		frame.getContentPane().add(lblCidade);
		
		lblCPF = new JLabel("CPF");
		lblCPF.setBounds(271, 82, 104, 14);
		frame.getContentPane().add(lblCPF);
		
		textEstado = new JTextField();
		textEstado.setColumns(10);
		textEstado.setBounds(46, 221, 134, 33);
		frame.getContentPane().add(textEstado);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(46, 205, 46, 14);
		frame.getContentPane().add(lblEstado);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(271, 205, 46, 14);
		frame.getContentPane().add(lblTelefone);
		
		textTelefone = new JTextField();
		textTelefone.setColumns(10);
		textTelefone.setBounds(271, 221, 134, 33);
		frame.getContentPane().add(textTelefone);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(46, 283, 134, 33);
		frame.getContentPane().add(textEmail);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(46, 270, 46, 14);
		frame.getContentPane().add(lblEmail);
		
		textSenha = new JTextField();
		textSenha.setColumns(10);
		textSenha.setBounds(271, 283, 134, 33);
		frame.getContentPane().add(textSenha);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(271, 270, 46, 14);
		frame.getContentPane().add(lblSenha);
		
		textContrato = new JTextField();
		textContrato.setColumns(10);
		textContrato.setBounds(46, 339, 134, 33);
		frame.getContentPane().add(textContrato);
		
		JLabel lblDataContrato = new JLabel("Data Contrato");
		lblDataContrato.setBounds(46, 327, 74, 14);
		frame.getContentPane().add(lblDataContrato);
		
		textField_9 = new JTextField();
		textField_9.setBounds(10, 19, 120, 23);
		frame.getContentPane().add(textField_9);
		textField_9.setColumns(10);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setBounds(139, 11, 89, 38);
		frame.getContentPane().add(btnPesquisar);
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new TelaFuncionario(funcionario);
				
				frame.dispose();
				
			}
		});
		btnVoltar.setBounds(316, 19, 89, 23);
		frame.getContentPane().add(btnVoltar);
		
		
		frame.setVisible(true);
	}
}
