package br.livraria.tela.cadastros.funcionario;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.livraria.aplicacao.cadastros.FuncionarioApp;
import br.livraria.dao.FuncionarioDAO;
import br.livraria.model.Funcionario;

public class TelaFuncionarioDelete {

	private JFrame frame;
	private JLabel textNome;
	private JLabel textEndereco;
	private JLabel textCPF;
	private JLabel textCidade;
	private JLabel textEstado;
	private JLabel textTelefone;
	private JLabel textEmail;
	private JLabel textSenha;
	private JLabel textContrato;
	private JTextField textId;
	private JLabel lblCPF;
	private Funcionario funcionario;
	private JCheckBox checkBoxAdministrador;


	/**
	 * Create the application.
	 */
	public TelaFuncionarioDelete(Funcionario funcionario) {
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
		frame.setTitle("Deletar Funcionario");
		frame.setLocationRelativeTo(null);
		
		textNome = new JLabel();
		textNome.setBounds(46, 100, 134, 33);
		frame.getContentPane().add(textNome);
		
		textEndereco = new JLabel();
		textEndereco.setBounds(46, 161, 134, 33);
		frame.getContentPane().add(textEndereco);
		
		textCPF = new JLabel();
		textCPF.setBounds(271, 100, 134, 33);
		frame.getContentPane().add(textCPF);
		
		textCidade = new JLabel();
		textCidade.setBounds(271, 161, 134, 33);
		frame.getContentPane().add(textCidade);
		
		JButton btnEditar = new JButton("Remover");
		btnEditar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
				
				funcionarioDAO.deleteByID(Integer.parseInt(textId.getText()));
				
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
		
		textEstado = new JLabel();
		textEstado.setBounds(46, 221, 134, 33);
		frame.getContentPane().add(textEstado);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(46, 205, 46, 14);
		frame.getContentPane().add(lblEstado);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(271, 205, 46, 14);
		frame.getContentPane().add(lblTelefone);
		
		textTelefone = new JLabel();
		textTelefone.setBounds(271, 221, 134, 33);
		frame.getContentPane().add(textTelefone);
		
		textEmail = new JLabel();
		textEmail.setBounds(46, 283, 134, 33);
		frame.getContentPane().add(textEmail);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(46, 270, 46, 14);
		frame.getContentPane().add(lblEmail);
		
		textSenha = new JLabel();
		textSenha.setBounds(271, 283, 134, 33);
		frame.getContentPane().add(textSenha);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(271, 270, 46, 14);
		frame.getContentPane().add(lblSenha);
		
		textContrato = new JLabel();
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
