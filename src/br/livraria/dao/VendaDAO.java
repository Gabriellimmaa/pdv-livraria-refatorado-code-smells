package br.livraria.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import br.livraria.factory.ConnectionFactory;
import br.livraria.model.Venda;

public class VendaDAO {

	public void save(Venda venda) {
		
		String sql = "INSERT INTO Venda (total, data_venda) VALUES (?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			
			conn = ConnectionFactory.createConnectionToSQLite();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setDouble(1, venda.getTotal());
			pstm.setDate(2, new Date(venda.getDataVenda().getTime()));
			
			pstm.execute();
			
			System.out.println("VendaDAO : save() sucesso!");
			
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
	
	public Vector<Venda> getVendas() {
		
		String sql = "SELECT * FROM Venda";
		
		Vector<Venda> vendas = new Vector<Venda>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		ResultSet rs = null;
		
		try {
			
			conn = ConnectionFactory.createConnectionToSQLite();
			
			pstm = conn.prepareStatement(sql);
			
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				
				Venda venda = new Venda();
				
				venda.setId(rs.getInt("id_venda"));
				venda.setTotal(rs.getDouble("total"));
				venda.setDataVenda(rs.getDate("data_venda"));
				
				vendas.add(venda);
				
			}
			
			System.out.println("VendaDAO : get() sucesso!");
			
			return vendas;
			
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
	
	public void update(Venda venda) {
		
		String sql = "UPDATE Venda SET total = ?, data_venda = ?"
				+ " WHERE id_venda = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		
		try {
			
			conn = ConnectionFactory.createConnectionToSQLite();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setDouble(1, venda.getTotal());
			pstm.setDate(2, new Date(venda.getDataVenda().getTime()));
			
			pstm.setInt(3, venda.getId());
			
			pstm.execute();
			
			System.out.println("VendaDAO : update() sucesso!");
			
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
		
		String sql = "DELETE FROM Venda WHERE id_venda = ?";
		
		Connection conn = null;
		
		PreparedStatement pstm = null;
		
		try {
			
			conn = ConnectionFactory.createConnectionToSQLite();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			pstm.execute();
			
			System.out.println("VendaDAO : delete() sucesso!");
			
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
