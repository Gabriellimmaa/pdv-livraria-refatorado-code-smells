package br.livraria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import br.livraria.factory.ConnectionFactory;
import br.livraria.model.Editora;

public class EditoraDAO {

	public void save(Editora editora) {
		
		String sql = "INSERT INTO Editora (nome, cnpj, endereco) VALUES (?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			
			conn = ConnectionFactory.createConnectionToSQLite();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, editora.getNome());
			pstm.setString(2, editora.getCnpj());
			pstm.setString(3, editora.getEndereco());
			
			pstm.execute();
			
			System.out.println("EditoraDAO : save() sucesso!");
			
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
	
	public Vector<Editora> getEditoras() {
		
		String sql = "SELECT * FROM Editora";
		
		Vector<Editora> editoras = new Vector<Editora>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		ResultSet rs = null;
		
		try {
			
			conn = ConnectionFactory.createConnectionToSQLite();
			
			pstm = conn.prepareStatement(sql);
			
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				
				Editora editora = new Editora();
				
				editora.setId(rs.getInt("id_editora"));
				editora.setCnpj(rs.getString("cnpj"));
				editora.setNome(rs.getString("nome"));
				editora.setEndereco(rs.getString("endereco"));
				
				editoras.add(editora);
				
			}
			
			System.out.println("EditoraDAO : get() sucesso!");
			
			return editoras;
			
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
	
	public void update(Editora editora) {
		
		String sql = "UPDATE Editora SET cnpj = ?, nome = ?, endereco = ?"
				+ " WHERE id_editora = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		
		try {
			
			conn = ConnectionFactory.createConnectionToSQLite();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, editora.getCnpj());
			pstm.setString(2, editora.getNome());
			pstm.setString(3, editora.getEndereco());
			
			pstm.setInt(4, editora.getId());
			
			pstm.execute();
			
			System.out.println("EditoraDAO : update() sucesso!");
			
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
		
		String sql = "DELETE FROM Editora WHERE id_editora = ?";
		
		Connection conn = null;
		
		PreparedStatement pstm = null;
		
		try {
			
			conn = ConnectionFactory.createConnectionToSQLite();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			pstm.execute();
			
			System.out.println("EditoraDAO : delete() sucesso!");
			
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
