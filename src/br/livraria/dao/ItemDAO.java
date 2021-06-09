package br.livraria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import br.livraria.aplicacao.cadastros.LivroApp;
import br.livraria.factory.ConnectionFactory;
import br.livraria.model.Item;
import br.livraria.model.Pedido;

public class ItemDAO {

	public void save(Item item) {
	
		String sql = "INSERT INTO Item (id_livro, id_pedido, qtd_vendida, total_preco) VALUES (?, ?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConnectionFactory.createConnectionToSQLite();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, item.getLivro().getId());
			pstm.setInt(2, item.getPedido().getId());
			pstm.setInt(3, item.getQtdVendida());
			pstm.setDouble(4, item.getTotalPreco());


			pstm.execute();

			System.out.println("ItemDAO : save() sucesso!");

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			try {

				if(pstm != null) {
					pstm.close();
				}

				if(conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();

			}
		}

	}

	public Vector<Item> getItens(int id) {

		String sql = "SELECT * FROM Item WHERE id_pedido = ?";

		Vector<Item> itens = new Vector<Item>();

		Connection conn = null;
		PreparedStatement pstm = null;

		ResultSet rs = null;

		try {

			conn = ConnectionFactory.createConnectionToSQLite();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);
			
			rs = pstm.executeQuery();
			
			Vector<Pedido> pedidos = new PedidoDAO().getPedidos();
			
			Pedido pedido = null;
			
			for(int i = 0; i < pedidos.size(); i++) {
				if(pedidos.get(i).getId() == id) {
					pedido = pedidos.get(i);
				}
			}

			while(rs.next()) {

				Item item = new Item();

				item.setId(rs.getInt("id_item"));
				item.setLivro(new LivroApp().getLivro(rs.getInt("id_livro")));
				item.setPedido(pedido);
				item.setQtdVendida(rs.getInt("qtd_vendida"));
				item.setTotalPreco();
				
				System.out.println(item.getLivro().getTitulo());

				itens.add(item);

			}

			System.out.println("ItemDAO : get() sucesso!");

			return itens;

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			try {

				if(rs != null) {
					rs.close();
				}

				if(pstm != null) {
					pstm.close();
				}

				if(conn != null) {
					pstm.close();
				}

			} catch (Exception e) {

				e.printStackTrace();

			}

		}

		return null;

	}

	public void update(Item itemPedido) {

		String sql = "UPDATE Item SET id_livro = ?, id_pedido = ?, qtd_vendida = ?, total_preco = ?"
				+ " WHERE id_item = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConnectionFactory.createConnectionToSQLite();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, itemPedido.getLivro().getId());
			pstm.setInt(2, itemPedido.getPedido().getId());
			pstm.setInt(3, itemPedido.getQtdVendida());
			pstm.setDouble(4, itemPedido.getTotalPreco());


			pstm.setInt(5, itemPedido.getId());

			pstm.execute();

			System.out.println("ItemDAO : update() sucesso!");

		} catch (Exception e ) {

			e.printStackTrace();

		} finally {

			try {

				if(pstm != null) {
					pstm.close();
				}

				if(conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();

			}

		}

	}

	public void deleteByID(int id) {

		String sql = "DELETE FROM Item WHERE id_item = ?";

		Connection conn = null;

		PreparedStatement pstm = null;

		try {

			conn = ConnectionFactory.createConnectionToSQLite();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			pstm.execute();

			System.out.println("ItemDAO : delete() sucesso!");

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			try {

				if(conn != null) {
					conn.close();
				}

				if(pstm != null) {
					pstm.close();
				}

			} catch (Exception e) {

				e.printStackTrace();

			}

		}

	}

}