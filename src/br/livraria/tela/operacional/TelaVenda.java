package br.livraria.tela.operacional;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.livraria.dao.PedidoDAO;
import br.livraria.model.Funcionario;
import br.livraria.model.Pedido;

public class TelaVenda {

	private JFrame frame;
	private JTable table;
	private JTextField textCodigo;
	private JTextField textQtd;
	
	private Pedido pedido;
	private Funcionario funcionario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaVenda window = new TelaVenda(new Funcionario());
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaVenda(Funcionario funcionario) {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		Pedido pedido = new Pedido();
		
		pedido.setDataVendida(new Date());
		pedido.setFuncionario(funcionario);
		
		PedidoDAO pedidoDAO = new PedidoDAO();
		pedidoDAO.save(pedido);
		
		this.pedido = pedidoDAO.getLastPedido();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 533, 454);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Venda");
		frame.setLocationRelativeTo(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 95, 497, 260);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"ID", "Livro", "Quantidade", "Preco Unit.", "Preco Total"
			}
		));
		scrollPane.setViewportView(table);
		
		textCodigo = new JTextField();
		textCodigo.setBounds(10, 46, 80, 31);
		frame.getContentPane().add(textCodigo);
		textCodigo.setColumns(10);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(10, 21, 80, 14);
		frame.getContentPane().add(lblCodigo);
		
		textQtd = new JTextField();
		textQtd.setBounds(120, 46, 80, 31);
		frame.getContentPane().add(textQtd);
		textQtd.setColumns(10);
		
		JLabel lblQtd = new JLabel("Quantidade");
		lblQtd.setBounds(120, 21, 80, 14);
		frame.getContentPane().add(lblQtd);
		
		JButton btnOk = new JButton("OK");
		btnOk.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnOk.setBounds(245, 38, 89, 46);
		frame.getContentPane().add(btnOk);
		
		JLabel lblPreco = new JLabel("Total:");
		lblPreco.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPreco.setBounds(20, 366, 186, 38);
		frame.getContentPane().add(lblPreco);
		
		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(216, 366, 118, 38);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Finalizar");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_1.setBounds(344, 366, 118, 38);
		frame.getContentPane().add(btnNewButton_1);
		
		frame.setVisible(true);
	}
}
