package br.livraria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import br.livraria.factory.ConnectionFactory;
import br.livraria.model.ItemPedido;
import br.livraria.model.Livro;
import br.livraria.model.Pedido;

public class ItemPedidoDAO {

public void save(ItemPedido item) {

		String sql = "INSERT INTO Item_Pedido (id_livro, id_pedido, qtd_vendida, total) VALUES (?, ?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConnectionFactory.createConnectionToSQLite();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, item.getIdLivro().getId());
			pstm.setInt(2, item.getIdPedido().getIdPedido());
			pstm.setInt(3, item.getQtdVendida());
			pstm.setInt(4, item.getTotal());


			pstm.execute();

			System.out.println("Item salvo com sucesso!");

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

	public Vector<ItemPedido> getItens() {

		String sql = "SELECT * FROM Item_Pedido";

		Vector<ItemPedido> itens = new Vector<ItemPedido>();

		Connection conn = null;
		PreparedStatement pstm = null;

		ResultSet rs = null;

		try {

			conn = ConnectionFactory.createConnectionToSQLite();

			pstm = conn.prepareStatement(sql);

			rs = pstm.executeQuery();

			while(rs.next()) {

				ItemPedido itemPedido = new ItemPedido();
				Livro livro = new Livro();
				Pedido pedido = new Pedido();

				itemPedido.setIdItemPedido(rs.getInt("id_item_pedido"));
				livro.setId(rs.getInt("id_livro"));
				itemPedido.setIdLivro(livro);
				pedido.setIdPedido(rs.getInt("id_pedido"));
				itemPedido.setIdPedido(pedido);
				itemPedido.setQtdVendida(rs.getInt("qtd_vendida"));
				itemPedido.setTotal(rs.getInt("total"));


				itens.add(itemPedido);

			}

			System.out.println("Itens recuperadas com sucesso!");

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

	public void update(ItemPedido itemPedido) {

		String sql = "UPDATE Item_Pedido SET id_livro = ?, id_pedido = ?, qtd_vendida = ?, total = ?"
				+ " WHERE id_item_pedido = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConnectionFactory.createConnectionToSQLite();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, itemPedido.getIdLivro().getId());
			pstm.setInt(2, itemPedido.getIdPedido().getIdPedido());
			pstm.setInt(3, itemPedido.getQtdVendida());
			pstm.setInt(4, itemPedido.getTotal());


			pstm.setInt(5, itemPedido.getIdItemPedido());

			pstm.execute();

			System.out.println("Item Pedido alterado com sucesso!");

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

		String sql = "DELETE FROM Item_Pedido WHERE id_item_pedido = ?";

		Connection conn = null;

		PreparedStatement pstm = null;

		try {

			conn = ConnectionFactory.createConnectionToSQLite();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			pstm.execute();

			System.out.println("Item pedido removido com sucesso!");

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