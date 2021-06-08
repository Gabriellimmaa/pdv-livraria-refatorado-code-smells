package br.livraria.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import br.livraria.aplicacao.cadastros.FuncionarioApp;
import br.livraria.factory.ConnectionFactory;
import br.livraria.model.Funcionario;
import br.livraria.model.Pedido;

public class PedidoDAO {

	public void save(Pedido pedido) {
		
		String sql = "INSERT INTO Pedido (id_funcionario, data_venda) VALUES (?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			
			conn = ConnectionFactory.createConnectionToSQLite();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, pedido.getFuncionario().getId());
			pstm.setDate(2, new Date(pedido.getDataVendida().getTime()));
			
			System.out.println("PedidoDAO: save() sucesso!");
			
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
	
	public Pedido getLastPedido() {
		
		String sql = "SELECT * FROM Pedido ORDER BY id_pedido DESC LIMIT 1";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		ResultSet rs = null;
		
		try {
			
			conn = ConnectionFactory.createConnectionToSQLite();
			
			pstm = conn.prepareStatement(sql);
			
			rs = pstm.executeQuery();
			
			Pedido pedido = new Pedido();
			
			pedido.setId(rs.getInt("id_pedido"));
			pedido.setDataVendida(rs.getDate("data_venda"));
			pedido.setFuncionario(new FuncionarioApp().getFuncionario(rs.getInt("id_funcionario")));
			pedido.setTotalPreco(rs.getDouble("total_preco"));
			
			System.out.println("PedidoDAO : getId() sucesso!");
			
			return pedido;
			
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
		
		String sql = "UPDATE Pedido SET id_funcionario = ?, data_venda = ?, total_preco = ?"
				+ " WHERE id_editora = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			
			conn = ConnectionFactory.createConnectionToSQLite();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, pedido.getFuncionario().getId());
			pstm.setDate(2, new Date(pedido.getDataVendida().getTime()));
			pstm.setDouble(3, pedido.getTotalPreco());
			
			pstm.setInt(4, pedido.getId());
			
			pstm.execute();
			
			System.out.println("PedidoDAO: update() sucesso!");
			
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
	
	public Vector<Pedido> getPedidos() {
		
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
				
				Funcionario funcionario = new FuncionarioApp().getFuncionario(rs.getInt("id_funcionario"));
				
				pedido.setId(rs.getInt("id_pedido"));
				pedido.setDataVendida(rs.getDate("data_venda"));
				pedido.setFuncionario(funcionario);
				pedido.setTotalPreco(rs.getDouble("total_preco"));
				
				pedidos.add(pedido);
				
			}
			
			System.out.println("PedidoDAO : get() sucesso!");
			
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
	
	public void deleteById(int id) {
		
		String sql = "DELETE FROM Pedido WHERE id_pedido = ?";
		
		Connection conn = null;
		
		PreparedStatement pstm = null;
		
		try {
			
			conn = ConnectionFactory.createConnectionToSQLite();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			pstm.execute();
			
			System.out.println("PedidoDAO : delete() sucesso!");
			
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