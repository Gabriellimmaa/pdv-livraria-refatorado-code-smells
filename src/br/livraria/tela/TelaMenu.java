package br.livraria.tela;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.livraria.model.Funcionario;
import br.livraria.tela.cadastros.TelaCadastros;
import br.livraria.tela.operacional.TelaOperacional;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaMenu extends JFrame {

	private static final long serialVersionUID = -7783528672230826524L;
	
	private JPanel contentPane;

	public TelaMenu(Funcionario funcionario) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("Menu Principal");
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelNome = new JLabel(funcionario.toString());
		labelNome.setHorizontalAlignment(SwingConstants.CENTER);
		labelNome.setFont(new Font("Tahoma", Font.PLAIN, 18));
		labelNome.setBounds(10, 23, 414, 46);
		contentPane.add(labelNome);
		
		JButton btnCadastros = new JButton("Cadastros");
		btnCadastros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(funcionario.ehAdministrador()) {
					
					new TelaCadastros(funcionario);
					dispose();
					
				} else {
					
					JOptionPane.showMessageDialog(new JFrame(), "Acesso Negado");
					
				}
				
			}
		});
		btnCadastros.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCadastros.setBounds(10, 123, 127, 78);
		contentPane.add(btnCadastros);
		
		JButton btnOperacional = new JButton("Operacional");
		btnOperacional.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				new TelaOperacional(funcionario);
				
				dispose();
			}
		});
		btnOperacional.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnOperacional.setBounds(147, 123, 140, 78);
		contentPane.add(btnOperacional);
		
		JButton btnSistema = new JButton("Sair");
		btnSistema.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				new TelaLogin();
				
				dispose();
			}
		});
		btnSistema.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSistema.setBounds(297, 123, 127, 78);
		contentPane.add(btnSistema);
		
		setVisible(true);
	}
}
