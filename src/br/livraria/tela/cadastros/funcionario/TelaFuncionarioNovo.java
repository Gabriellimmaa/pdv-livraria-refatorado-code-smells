package br.livraria.tela.cadastros.funcionario;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import br.livraria.dao.FuncionarioDAO;
import br.livraria.model.Funcionario;

public class TelaFuncionarioNovo {

	private JFrame frame;
	private JTextField textNome;
	private JTextField textEndereco;
	private JTextField textCPF;
	private JTextField textCidade;
	private JTextField textEstado;
	private JTextField textTelefone;
	private JTextField textEmail;
	private JPasswordField textSenha;
	private JTextField textContrato;
	private Funcionario funcionario;
	private JCheckBox checkBoxAdministrador;

	/**
	 * Create the application.
	 */
	public TelaFuncionarioNovo(Funcionario funcionario) {
		this.funcionario = funcionario;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 462, 444);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Novo Funcionario");
		frame.setLocationRelativeTo(null);
		
		textNome = new JTextField();
		textNome.setColumns(10);
		textNome.setBounds(46, 63, 134, 33);
		frame.getContentPane().add(textNome);
		
		textEndereco = new JTextField();
		textEndereco.setColumns(10);
		textEndereco.setBounds(46, 125, 134, 33);
		frame.getContentPane().add(textEndereco);
		
		textCPF = new JTextField();
		textCPF.setColumns(10);
		textCPF.setBounds(271, 63, 134, 33);
		frame.getContentPane().add(textCPF);
		
		textCidade = new JTextField();
		textCidade.setColumns(10);
		textCidade.setBounds(271, 125, 134, 33);
		frame.getContentPane().add(textCidade);
		
		textTelefone = new JTextField();
		textTelefone.setColumns(10);
		textTelefone.setBounds(271, 186, 134, 33);
		frame.getContentPane().add(textTelefone);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(46, 245, 134, 33);
		frame.getContentPane().add(textEmail);
		
		textSenha = new JPasswordField();
		textSenha.setColumns(10);
		textSenha.setBounds(271, 245, 134, 33);
		frame.getContentPane().add(textSenha);
		
		textContrato = new JTextField();
		textContrato.setColumns(10);
		textContrato.setBounds(46, 300, 134, 33);
		frame.getContentPane().add(textContrato);
		
		checkBoxAdministrador = new JCheckBox("Administrador");
		checkBoxAdministrador.setBounds(271, 305, 97, 23);
		frame.getContentPane().add(checkBoxAdministrador);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
				Date dataFormatada = null;
				try {
					dataFormatada = formato.parse(textContrato.getText());
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				
				Funcionario funcionarioNovo = new Funcionario();
				
				if(checkBoxAdministrador.isSelected()) {
					funcionarioNovo.setAdministrador(true);
				} else {
					funcionarioNovo.setAdministrador(false);
				}
				
				funcionarioNovo.setCidade(textCidade.getText());
				funcionarioNovo.setCpf(textCPF.getText());
				funcionarioNovo.setDataContrato(dataFormatada);
				funcionarioNovo.setEmail(textEmail.getText());
				funcionarioNovo.setEndereco(textEndereco.getText());
				funcionarioNovo.setEstado(textEstado.getText());
				funcionarioNovo.setNome(textNome.getText());
				funcionarioNovo.setSenha(new String(textSenha.getPassword()).trim());
				funcionarioNovo.setTelefone(textTelefone.getText());
				
				FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
				
				funcionarioDAO.save(funcionarioNovo);
				
				new TelaFuncionario(funcionario);
				
				frame.dispose();
				
			}
		});
		btnSalvar.setForeground(Color.BLACK);
		btnSalvar.setBackground(Color.BLUE);
		btnSalvar.setBounds(46, 344, 110, 33);
		frame.getContentPane().add(btnSalvar);
		
		JButton btnCancelar = new JButton("Voltar");
		btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new TelaFuncionario(funcionario);
				
				frame.dispose();
				
			}
		});
		btnCancelar.setBackground(Color.WHITE);
		btnCancelar.setBounds(271, 344, 110, 33);
		frame.getContentPane().add(btnCancelar);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(46, 45, 46, 14);
		frame.getContentPane().add(lblNome);
		
		JLabel lblEndereco = new JLabel("Endereco");
		lblEndereco.setBounds(46, 107, 46, 14);
		frame.getContentPane().add(lblEndereco);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(271, 107, 74, 14);
		frame.getContentPane().add(lblCidade);
		
		JLabel lblCPF = new JLabel("CPF");
		lblCPF.setBounds(271, 45, 104, 14);
		frame.getContentPane().add(lblCPF);
		
		textEstado = new JTextField();
		textEstado.setColumns(10);
		textEstado.setBounds(46, 186, 134, 33);
		frame.getContentPane().add(textEstado);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(46, 171, 46, 14);
		frame.getContentPane().add(lblEstado);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(271, 171, 46, 14);
		frame.getContentPane().add(lblTelefone);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(46, 230, 46, 14);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(271, 230, 46, 14);
		frame.getContentPane().add(lblSenha);
		
		JLabel lblContrato = new JLabel("Data Contrato");
		lblContrato.setBounds(46, 285, 74, 14);
		frame.getContentPane().add(lblContrato);
		
		frame.setVisible(true);
	}
}
