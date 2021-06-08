package br.livraria.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import br.livraria.factory.ConnectionFactory;
import br.livraria.model.Editora;
import br.livraria.model.Livro;

public class LivroDAO {

	public void save(Livro livro) {
		
		String sql = "INSERT INTO Livro (titulo, genero, data_publicada, autor, qtd_estoque, preco_unit, id_editora) VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			
			conn = ConnectionFactory.createConnectionToSQLite();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, livro.getTitulo());
			pstm.setString(2, livro.getGenero());
			pstm.setDate(3, new Date(livro.getDataPublicada().getTime()));
			pstm.setString(4, livro.getAutor());
			pstm.setInt(5, livro.getQtdEstoque());
			pstm.setDouble(6, livro.getPrecoUnit());
			pstm.setInt(7, livro.getEditora().getId());
			
			pstm.execute();
			
			System.out.println("LivroDAO : save() sucesso!");
			
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
	
	public Vector<Livro> getLivros() {
		
		String sql = "SELECT * FROM Livro";
		
		Vector<Livro> livros = new Vector<Livro>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		ResultSet rs = null;
		
		try {
			
			conn = ConnectionFactory.createConnectionToSQLite();
			
			pstm = conn.prepareStatement(sql);
			
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				
				Livro livro = new Livro();
				
				livro.setId(rs.getInt("id_livro"));
				livro.setTitulo(rs.getString("titulo"));
				livro.setGenero(rs.getString("genero"));
				livro.setDataPublicada(rs.getDate("data_publicada"));
				livro.setAutor(rs.getString("autor"));
				livro.setQtdEstoque(rs.getInt("qtd_estoque"));
				livro.setPrecoUnit(rs.getDouble("preco_unit"));
				
				Vector<Editora> editoras = new EditoraDAO().getEditoras();
				
				for(int i = 0; i < editoras.size(); i++) {
					
					if(editoras.get(i).getId() == rs.getInt("id_editora")) {
						
						livro.setEditora(editoras.get(i));
						
					}
					
				}
				
				livros.add(livro);
				
			}
			
			System.out.println("LivroDAO : get() sucesso!");
			
			return livros;
			
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
	
	public void update(Livro livro) {
		
		String sql = "UPDATE Livro SET titulo = ?, genero = ?, data_publicada = ?, autor = ?, qtd_estoque = ?, preco_unit = ?, id_editora = ?"
				+ " WHERE id_livro = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			
			conn = ConnectionFactory.createConnectionToSQLite();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, livro.getTitulo());
			pstm.setString(2, livro.getGenero());
			pstm.setDate(3, new Date(livro.getDataPublicada().getTime()));
			pstm.setString(4, livro.getAutor());
			pstm.setInt(5, livro.getQtdEstoque());
			pstm.setDouble(6, livro.getPrecoUnit());
			pstm.setInt(7, livro.getEditora().getId());
			
			pstm.setInt(8, livro.getId());
			
			pstm.execute();
			
			System.out.println("LivroDAO : update() sucesso!");
			
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
		
		String sql = "DELETE FROM Livro WHERE id_livro = ?";
		
		Connection conn = null;
		
		PreparedStatement pstm = null;
		
		try {
			
			conn = ConnectionFactory.createConnectionToSQLite();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			pstm.execute();
			
			System.out.println("LivroDAO : delete() sucesso!");
			
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
