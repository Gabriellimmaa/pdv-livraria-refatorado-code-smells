package br.livraria.tela;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.livraria.aplicacao.LoginApp;

public class TelaLogin extends JFrame {

	private static final long serialVersionUID = 112371093650858296L;
	
	private JPanel contentPane;
	private JTextField inputUser;
	private JLabel labelSenha;
	private JPasswordField inputSenha;

	public TelaLogin() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("Login");
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelFazerLogin = new JLabel("Fazer Login");
		labelFazerLogin.setHorizontalAlignment(SwingConstants.CENTER);
		labelFazerLogin.setFont(new Font("Tahoma", Font.BOLD, 18));
		labelFazerLogin.setBounds(10, 30, 264, 46);
		contentPane.add(labelFazerLogin);
		
		JLabel labelName = new JLabel("Usuario:");
		labelName.setHorizontalAlignment(SwingConstants.LEFT);
		labelName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelName.setBounds(10, 87, 264, 28);
		contentPane.add(labelName);
		
		inputUser = new JTextField();
		inputUser.setFont(new Font("Tahoma", Font.PLAIN, 12));
		inputUser.setBounds(10, 112, 264, 28);
		contentPane.add(inputUser);
		inputUser.setColumns(10);
		
		labelSenha = new JLabel("Senha:");
		labelSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelSenha.setBounds(10, 151, 264, 28);
		contentPane.add(labelSenha);
		
		inputSenha = new JPasswordField();
		inputSenha.setToolTipText("");
		inputSenha.setBounds(10, 175, 264, 28);
		contentPane.add(inputSenha);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//Responsável por validar os dados de login no Sistema
				
				int idUsuario = Integer.parseInt(inputUser.getText());
				String senha = new String(inputSenha.getPassword()).trim();
				
				if(new LoginApp().entrar(idUsuario, senha))
					dispose();
				
			}
		});
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnEntrar.setBounds(74, 228, 139, 46);
		contentPane.add(btnEntrar);
		
		setVisible(true);
	}
	
}