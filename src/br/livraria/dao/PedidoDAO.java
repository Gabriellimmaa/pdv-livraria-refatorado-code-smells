package br.livraria.dao;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Vector;

import br.livraria.factory.ConnectionFactory;
import br.livraria.model.ItemPedido;
import br.livraria.model.Pedido;

public class PedidoDAO {

public void save(Pedido pedido) {

		String sql = "INSERT INTO Pedido (total,itensPedidos) VALUES (?, ?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConnectionFactory.createConnectionToSQLite();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, pedido.getTotalPedido());
			pstm.setArray(2, (Array) pedido.getItensPedidos());



			pstm.execute();

			System.out.println("Pedido salvo com sucesso!");

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

	public Vector<Pedido> getLivros() {

		String sql = "SELECT * FROM Pedido";

		Vector<Pedido> pedidos = new Vector<Pedido>();

		Connection conn = null;
		PreparedStatement pstm = null;

		ResultSet rs = null;

		try {

			conn = ConnectionFactory.createConnectionToSQLite();

			pstm = conn.prepareStatement(sql);

			rs = pstm.executeQuery();

			while(rs.next()) {

				Pedido pedido = new Pedido();

				pedido.setTotalPedido(rs.getInt("total"));
				pedido.setItensPedidos((List<ItemPedido>) rs.getArray("pedidos"));


				pedidos.add(pedido);

			}

			System.out.println("Pedidos recuperadas com sucesso!");

			return pedidos;

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

	public void update(Pedido pedido) {

		String sql = "UPDATE Pedido SET total = ?, itensPedidos = ?"
				+ " WHERE id_pedido = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConnectionFactory.createConnectionToSQLite();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, pedido.getTotalPedido());
			pstm.setArray(2, (Array) pedido.getItensPedidos());

			pstm.setInt(3, pedido.getIdPedido());

			pstm.execute();

			System.out.println("Pedido alterado com sucesso!");

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

		String sql = "DELETE FROM Pedido WHERE id_pedido = ?";

		Connection conn = null;

		PreparedStatement pstm = null;

		try {

			conn = ConnectionFactory.createConnectionToSQLite();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

			pstm.execute();

			System.out.println("Pedido removido com sucesso!");

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