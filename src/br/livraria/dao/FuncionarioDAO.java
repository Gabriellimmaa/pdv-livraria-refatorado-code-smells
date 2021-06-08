package br.livraria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import java.sql.Date;

import br.livraria.factory.ConnectionFactory;
import br.livraria.model.Funcionario;

public class FuncionarioDAO {
	
	public void save(Funcionario funcionario) {
		
		String sql = "INSERT INTO Funcionario (cpf, nome, endereco, cidade, estado, telefone, email, senha, data_contrato, administrador) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			
			conn = ConnectionFactory.createConnectionToSQLite();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, funcionario.getCpf());
			pstm.setString(2, funcionario.getNome());
			pstm.setString(3, funcionario.getEndereco());
			pstm.setString(4, funcionario.getCidade());
			pstm.setString(5, funcionario.getEstado());
			pstm.setString(6, funcionario.getTelefone());
			pstm.setString(7, funcionario.getEmail());
			pstm.setString(8, funcionario.getSenha());
			pstm.setDate(9, new Date(funcionario.getDataContrato().getTime()));
			pstm.setBoolean(10, funcionario.ehAdministrador());
			
			pstm.execute();
			
			System.out.println("FuncionarioDAO : save() sucesso!");
			
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

	public Vector<Funcionario> getFuncionarios() {
		
		String sql = "SELECT * FROM Funcionario";
		
		Vector<Funcionario> funcionarios = new Vector<Funcionario>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		ResultSet rs = null;
		
		try {
			
			conn = ConnectionFactory.createConnectionToSQLite();
			
			pstm = conn.prepareStatement(sql);
			
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				
				Funcionario funcionario = new Funcionario();
				
				funcionario.setId(rs.getInt("id_funcionario"));
				funcionario.setCpf(rs.getString("cpf"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setEndereco(rs.getString("endereco"));
				funcionario.setCidade(rs.getString("cidade"));
				funcionario.setEstado(rs.getString("estado"));
				funcionario.setTelefone(rs.getString("telefone"));
				funcionario.setEmail(rs.getString("email"));
				funcionario.setSenha(rs.getString("senha"));
				funcionario.setDataContrato(rs.getDate("data_contrato"));
				funcionario.setAdministrador(rs.getBoolean("administrador"));
				
				funcionarios.add(funcionario);
				
			}
			
			System.out.println("FuncionarioDAO : get() sucesso!");
			
			return funcionarios;
			
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
	
	public void update(Funcionario funcionario) {
		
		String sql = "UPDATE Funcionario SET cpf = ?, nome = ?, endereco = ?, cidade = ?, estado = ?, telefone = ?, email = ?, senha = ?, data_contrato = ?, administrador = ?"
				+ " WHERE id_funcionario = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		
		try {
			
			conn = ConnectionFactory.createConnectionToSQLite();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, funcionario.getCpf());
			pstm.setString(2, funcionario.getNome());
			pstm.setString(3, funcionario.getEndereco());
			pstm.setString(4, funcionario.getCidade());
			pstm.setString(5, funcionario.getEstado());
			pstm.setString(6, funcionario.getTelefone());
			pstm.setString(7, funcionario.getEmail());
			pstm.setString(8, funcionario.getSenha());
			pstm.setDate(9, new Date(funcionario.getDataContrato().getTime()));
			pstm.setBoolean(10, funcionario.ehAdministrador());
			
			pstm.setInt(11, funcionario.getId());
			
			pstm.execute();
			
			System.out.println("FuncionarioDAO : update() sucesso!");
			
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
		
		String sql = "DELETE FROM Funcionario WHERE id_funcionario = ?";
		
		Connection conn = null;
		
		PreparedStatement pstm = null;
		
		try {
			
			conn = ConnectionFactory.createConnectionToSQLite();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			pstm.execute();
			
			System.out.println("FuncionarioDAO : delete() sucesso!");
			
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