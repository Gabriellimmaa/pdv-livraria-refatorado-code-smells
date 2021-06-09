package br.livraria.tela.operacional;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.livraria.aplicacao.cadastros.LivroApp;
import br.livraria.aplicacao.operacional.VendaApp;
import br.livraria.dao.ItemDAO;
import br.livraria.dao.LivroDAO;
import br.livraria.dao.PedidoDAO;
import br.livraria.model.Funcionario;
import br.livraria.model.Item;
import br.livraria.model.Livro;
import br.livraria.model.Pedido;
import br.livraria.tela.TelaMenu;

public class TelaVenda {

	private JFrame frame;
	private JTable table;
	private JTextField textCodigo;
	private JTextField textQtd;
	
	private Pedido pedido;
	private Funcionario funcionario;
	
	private JLabel lblPreco;

	/**
	 * Create the application.
	 */
	public TelaVenda(Funcionario funcionario) {
		
		this.funcionario = funcionario;
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		Pedido novoPedido = new Pedido();
		
		novoPedido.setDataVendida(new Date());
		novoPedido.setFuncionario(funcionario);
		
		PedidoDAO pedidoDAO = new PedidoDAO();
		pedidoDAO.save(novoPedido);
		
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
				{null, null, null, null},
			},
			new String[] {
				"ID", "Livro", "Preco Unit.", "Quantidade"
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
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				String inputCod = textCodigo.getText();
				String inputQtd = textQtd.getText();
				
				int id = Integer.parseInt(inputCod);
				int qtd = Integer.parseInt(inputQtd);
				
				if(new LivroApp().getLivro(id) == null) {
					
					JOptionPane.showMessageDialog(new JFrame(), "ID invalido");
					
				} else {
					
					Item item = new Item();
					
					
					
					Livro livro = new LivroApp().getLivro(id);
					
					item.setLivro(livro);
					item.setPedido(pedido);
					item.setQtdVendida(qtd);
					item.setTotalPreco();
					
					new ItemDAO().save(item);
					
					Vector<Item> itens = new ItemDAO().getItens(pedido.getId());
					
					pedido.setTotalPreco(itens);
					
					lblPreco.setText("Total: " + pedido.getTotalPreco() + "R$");
					
					atualizarTabela();
					
				}
				
				
			}

		});
		btnOk.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnOk.setBounds(245, 38, 89, 46);
		frame.getContentPane().add(btnOk);
		
		lblPreco = new JLabel("Total: 0.0 R$");
		lblPreco.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPreco.setBounds(20, 366, 186, 38);
		frame.getContentPane().add(lblPreco);
		
		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				PedidoDAO pedidoDAO = new PedidoDAO();
				pedidoDAO.deleteById(pedidoDAO.getLastPedido().getId());
				
				new TelaMenu(funcionario);
				
				frame.dispose();
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(216, 366, 118, 38);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Finalizar");
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				Vector<Item> itens = new ItemDAO().getItens(pedido.getId());
				
				boolean deuErro = false;
				
				for(int i = 0; i < itens.size(); i++) {
					
					Livro livro = new LivroApp().getLivro(itens.get(i).getLivro().getId());
					
					livro.removeEstoque(itens.get(i).getQtdVendida());
					
					if(livro.getQtdEstoque() < 0) {
						
						new ItemDAO().deleteByID(itens.get(i).getId());
						
						JOptionPane.showMessageDialog(new JFrame(), "O item nao esta mais disponivel em estoque");
						
						atualizarTabela();
						
						deuErro = true;
					} 
					
					new LivroDAO().update(livro);
				}
				
				lblPreco.setText("Total: " + pedido.getTotalPreco() + " R$");
				
				
				if(!deuErro) {
				
					pedido.setTotalPreco(itens);
					
					System.out.println("Total Preço dessa misera" + pedido.getTotalPreco());
					
					new PedidoDAO().update(pedido);
					
					JOptionPane.showMessageDialog(new JFrame(), "Compra efetuada com sucesso");
					
					new TelaMenu(funcionario);
					
					frame.dispose();

				}				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_1.setBounds(344, 366, 118, 38);
		frame.getContentPane().add(btnNewButton_1);
		
		frame.setVisible(true);
	}
	
	public void atualizarTabela() {
		table.setModel(new DefaultTableModel(
			new VendaApp().getItens(pedido.getId()),
			new String[] {
				"ID", "Livro", "Preco Unit.", "Quantidade"
			}
		));
	}
}
