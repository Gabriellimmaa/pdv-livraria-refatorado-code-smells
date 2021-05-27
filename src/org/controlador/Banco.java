package org.controlador;

import java.sql.*;

import org.atores.Administrador;
import org.atores.Editora;
import org.atores.Funcionario;

public class Banco {
	
	private Connection conn;
	private Statement stm;
	
	public Banco() throws SQLException, ClassNotFoundException {
		
		Class.forName("org.sqlite.JDBC");
		
		this.conn = DriverManager.getConnection("jdbc:sqlite:banco.db");
		this.stm = this.conn.createStatement();
		
        criarTabelas();
        
	}
	
	private void criarTabelas() {
		
		try {
			stm.execute("CREATE TABLE IF NOT EXISTS Funcionario ("
					+ "	cod_func INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ "	cpf VARCHAR(11) NOT NULL,"
					+ "	nome VARCHAR(50) NOT NULL,"
					+ "	endereco VARCHAR(50) NOT NULL,"
					+ "	cidade VARCHAR(50) NOT NULL,"
					+ "	estado VARCHAR(2) NOT NULL,"
					+ "	telefone VARCHAR(13),"
					+ "	email VARCHAR(50)"
					+ ");");
			
			stm.execute("CREATE TABLE IF NOT EXISTS Administrador ("
					+ "	cod_func INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ "	cpf VARCHAR(11) NOT NULL,"
					+ "	nome VARCHAR(50) NOT NULL,"
					+ "	endereco VARCHAR(50) NOT NULL,"
					+ "	cidade VARCHAR(50) NOT NULL,"
					+ "	estado VARCHAR(2) NOT NULL,"
					+ "	telefone VARCHAR(13),"
					+ "	email VARCHAR(50),"
					+ "	data_contrat DATE NOT NULL"
					+ ");");
			
			stm.execute("CREATE TABLE IF NOT EXISTS Editora ("
					+ "	cod_editora INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ "	nome VARCHAR(50) NOT NULL,"
					+ "	cnpj VARCHAR(14) NOT NULL,"
					+ "	endereco VARCHAR(50) NOT NULL"
					+ ");");
			
			stm.execute("CREATE TABLE IF NOT EXISTS Livro ("
					+ "	cod_livro INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ "	titulo VARCHAR(50) NOT NULL,"
					+ "	genero VARCHAR(50),"
					+ "	data_pub DATE,"
					+ "	qtd_estoque INTEGER,"
					+ "	cod_editora INTEGER,"
					+ "	CONSTRAINT fk_livro_editora FOREIGN KEY (cod_editora) REFERENCES Editora (cod_editora)"
					+ ");");
			
			stm.execute("CREATE TABLE IF NOT EXISTS Livro_Autor ("
					+ "	cod_livro_autor INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ "	cod_livro INTEGER,"
					+ "	cod_autor INTEGER,"
					+ "	CONSTRAINT fk_livro_autor_livro FOREIGN KEY (cod_livro) REFERENCES Livro (cod_livro),"
					+ "	CONSTRAINT fk_livro_autor_autor FOREIGN KEY (cod_autor) REFERENCES Autor (cod_autor)"
					+ ");");
			
			stm.execute("CREATE TABLE IF NOT EXISTS Autor ("
					+ "	cod_autor INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ "	nome VARCHAR(50)"
					+ ");");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	//FUNCIONÁRIO
	
	public void adicionarFuncionario(Funcionario f) {
		
		try {
			
			this.stm = this.conn.createStatement();
			
			this.stm.executeUpdate("INSERT INTO Funcionario(cpf, nome, endereco, cidade, estado, telefone, email) VALUES ("
					+ "'" + f.getCpf() + "',"
					+ "'" + f.getNome() + "',"
					+ "'" + f.getEndereco() + "',"
					+ "'" + f.getCidade() + "',"
					+ "'" + f.getEstado() + "',"
					+ "'" + f.getTelefone() + "',"
					+ "'" + f.getEmail() + "');");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void removerFuncionario(int codFuncionario) {
		
		try {		  
			this.stm = this.conn.createStatement();

			this.stm.executeUpdate("DELETE FROM Funcionario WHERE cod_func = " + codFuncionario);
		}
		catch (SQLException e) {
			e.printStackTrace();  
		}
		
	}
	
	public Funcionario pegarFuncionario(int codFuncionario) {
		
		ResultSet rs;
		Funcionario f = new Funcionario();
		
		try {
			
			this.stm = this.conn.createStatement();
			
			rs = this.stm.executeQuery("SELECT * FROM Funcionario WHERE cod_func = " + codFuncionario);
			
			f.setCodFunc(rs.getInt("cod_func"));
			f.setCpf(rs.getString("cpf"));
			f.setNome(rs.getString("nome"));
			f.setEndereco(rs.getString("endereco"));
			f.setCidade(rs.getString("cidade"));
			f.setEstado(rs.getString("estado"));
			f.setTelefone(rs.getString("telefone"));
			f.setEmail(rs.getString("email"));
			
			rs.close();

		}
		catch (SQLException e) {
			e.printStackTrace();
		}

		return f;
	}
	
	//ADMINISTRADOR
	
	public void adicionarAdministrador(Administrador a) {
		
		try {
			
			this.stm = this.conn.createStatement();
			
			this.stm.executeUpdate("INSERT INTO Administrador(cpf, nome, endereco, cidade, estado, telefone, email, data_contrat) VALUES ("
					+ "'" + a.getCpf() + "',"
					+ "'" + a.getNome() + "',"
					+ "'" + a.getEndereco() + "',"
					+ "'" + a.getCidade() + "',"
					+ "'" + a.getEstado() + "',"
					+ "'" + a.getTelefone() + "',"
					+ "'" + a.getEmail() + "',"
					+ "'" + a.getDataContracao() + "');");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void removerAdministrador(int codFuncionario) {
		
		try {		  
			this.stm = this.conn.createStatement();

			this.stm.executeUpdate("DELETE FROM Administrador WHERE cod_func = " + codFuncionario);
		}
		catch (SQLException e) {
			e.printStackTrace();  
		}
		
	}
	
	public Administrador pegarAdministrador(int codFuncionario) {
		
		ResultSet rs;
		Administrador a = new Administrador();
		
		try {
			
			this.stm = this.conn.createStatement();
			
			rs = this.stm.executeQuery("SELECT * FROM Administrador WHERE cod_func = " + codFuncionario);
			
			a.setCodFunc(rs.getInt("cod_func"));
			a.setCpf(rs.getString("cpf"));
			a.setNome(rs.getString("nome"));
			a.setEndereco(rs.getString("endereco"));
			a.setCidade(rs.getString("cidade"));
			a.setEstado(rs.getString("estado"));
			a.setTelefone(rs.getString("telefone"));
			a.setEmail(rs.getString("email"));
			a.setDataContracao(rs.getDate("data_contrat"));
			
			rs.close();

		}
		catch (SQLException e) {
			e.printStackTrace();
		}

		return a;
		
	}
	
	//EDITORA
	
	public void adicionarEditora(Editora ed) {
		
		try {
			
			this.stm = this.conn.createStatement();
			
			this.stm.executeUpdate("INSERT INTO Editora(nome, cnpj, endereco) VALUES ("
					+ "'" + ed.getNome() + "',"
					+ "'" + ed.getCnpj() + "',"
					+ "'" + ed.getEndereco() + "');");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void removerEditora(int codEditora) {
		
		try {		  
			this.stm = this.conn.createStatement();

			this.stm.executeUpdate("DELETE FROM Editora WHERE cod_editora = " + codEditora);
		}
		catch (SQLException e) {
			e.printStackTrace();  
		}
		
	}
	
	public Editora pegarEditora(int codEditora) {
		
		ResultSet rs;
		Editora ed = new Editora();
		
		try {
			
			this.stm = this.conn.createStatement();
			
			rs = this.stm.executeQuery("SELECT * FROM Editora WHERE cod_editora = " + codEditora);
			
			ed.setCodEditora(rs.getInt("cod_editora"));
			ed.setNome(rs.getString("nome"));
			ed.setCnpj(rs.getString("cnpj"));
			ed.setEndereco(rs.getString("endereco"));
			
			rs.close();

		}
		catch (SQLException e) {
			e.printStackTrace();
		}

		return ed;
		
	}
	
	//LIVRO
}
