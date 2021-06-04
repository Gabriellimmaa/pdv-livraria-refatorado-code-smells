package org.interfacegrafica;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.ator.Funcionario;
import org.controlador.Banco;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField inputUser;
	private JLabel labelSenha;
	private JPasswordField inputSenha;

	public TelaLogin() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
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
				
				/*
				 * Verificação se os dados 'cod_func' e 'senha' estão corretos.
				 * 
				 * Se sim, abrir TelaMenu()
				 * 
				 * Se não, informar uma mensagem que o email ou senha não estão certos.
				 */
				entrar();
				
			}
		});
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnEntrar.setBounds(74, 228, 139, 46);
		contentPane.add(btnEntrar);
		
		setVisible(true);
	}
	
	private void entrar() {
		
		/*
		 * Recebe os valores do inputUser (Usuario) e do inputSenha (Senha)
		 * Verifica se coincide com o banco de dados
		 * Caso sim, avança para telaMenu()
		 */
		
		int usuario = Integer.parseInt(inputUser.getText());
		String senha = new String(inputSenha.getPassword()).trim();
		
		System.out.println(usuario);
		System.out.println(senha);
		
		try {
			Banco bd = new Banco();
			
			Funcionario f = bd.pegarFuncionario(usuario);
			
			/*
			 * BUG
			 * - Precisa-se verificar se o pegarFuncionario() encontrou alguma coisa, caso não tenha encontrado significa que não existe.
			 */
			
			//Verifica se há algum usuário com esse código
			if(f != null && f.getSenha().equals(senha)) {
				
				//Implementar a invocação da tela menu
				
				System.out.println("Abrindo nova tela!");
				
			} else {
				
				System.out.println("tem nada");
				
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
