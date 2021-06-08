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
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.livraria.aplicacao.cadastros.FuncionarioApp;
import br.livraria.dao.FuncionarioDAO;
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
	private JTextField textId;
	private JLabel lblCPF;
	private Funcionario funcionario;
	private JCheckBox checkBoxAdministrador;


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
		frame.setTitle("Editar Funcionario");
		frame.setLocationRelativeTo(null);
		
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
		
		JButton btnEditar = new JButton("Salvar");
		btnEditar.addActionListener(new ActionListener() {
			
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
				funcionarioNovo.setSenha(new String(textSenha.getText()).trim());
				funcionarioNovo.setTelefone(textTelefone.getText());
				funcionarioNovo.setId(Integer.parseInt(textId.getText()));
				
				FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
				
				funcionarioDAO.update(funcionarioNovo);
				
				new TelaFuncionario(funcionario);
				
				frame.dispose();
				
			}
		});
		btnEditar.setForeground(Color.BLACK);
		btnEditar.setBackground(Color.BLUE);
		btnEditar.setBounds(46, 383, 110, 33);
		frame.getContentPane().add(btnEditar);
		
		JButton btnCancelar = new JButton("Voltar");
		btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				new TelaFuncionario(funcionario);
				
				frame.dispose();
			}
		});
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
		
		textId = new JTextField();
		textId.setBounds(10, 19, 120, 23);
		frame.getContentPane().add(textId);
		textId.setColumns(10);
		
		checkBoxAdministrador = new JCheckBox("Administrador");
		checkBoxAdministrador.setBounds(271, 327, 97, 23);
		frame.getContentPane().add(checkBoxAdministrador);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String inputId = textId.getText();
				
				int id = Integer.parseInt(inputId);
				
				Funcionario funcionario = new FuncionarioApp().getFuncionario(id);
				
				if(funcionario == null) {
					JOptionPane.showMessageDialog(new JFrame(), "ID nao encontrado");
				} else {
					textCidade.setText(funcionario.getCidade());
					textContrato.setText(funcionario.getDataContrato() + "");
					textCPF.setText(funcionario.getCpf());
					textEmail.setText(funcionario.getEmail());
					textEndereco.setText(funcionario.getEndereco());
					textEstado.setText(funcionario.getEstado());
					textId.setText(funcionario.getId() + "");
					textNome.setText(funcionario.getNome());
					textSenha.setText(funcionario.getSenha());
					textTelefone.setText(funcionario.getTelefone());
					
					if(funcionario.ehAdministrador()) {
						checkBoxAdministrador.setSelected(true);
					} else {
						checkBoxAdministrador.setSelected(false);
					}
				}
				
			}
		});
		btnPesquisar.setBounds(139, 11, 89, 38);
		frame.getContentPane().add(btnPesquisar);
		
		frame.setVisible(true);
	}
}
