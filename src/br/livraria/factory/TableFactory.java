package br.livraria.factory;

import java.sql.Connection;
import java.sql.Statement;

public class TableFactory {

	public void createTables() {
		
		String funcionario = "CREATE TABLE IF NOT EXISTS Funcionario ("
				+ "	id_funcionario INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ " cpf VARCHAR(11) NOT NULL,"
				+ " nome VARCHAR(100) NOT NULL,"
				+ " endereco VARCHAR(100),"
				+ " cidade VARCHAR(50),"	
				+ " estado VARCHAR(2),"
				+ " telefone VARCHAR(14),"
				+ " email VARCHAR(100),"
				+ " senha VARCHAR(50) NOT NULL,"
				+ " data_contrato DATE NOT NULL,"
				+ " administrador BOOLEAN NOT NULL"
				+ ");";
		
		String editora = "CREATE TABLE IF NOT EXISTS Editora ("
				+ "	id_editora INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ "	nome VARCHAR(50) NOT NULL,"
				+ "	cnpj VARCHAR(14) NOT NULL,"
				+ "	endereco VARCHAR(50)"
				+ ");";
		
		String livro = "CREATE TABLE IF NOT EXISTS Livro ("
				+ "	id_livro INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ "	titulo VARCHAR(50) NOT NULL,"
				+ "	genero VARCHAR(50) NOT NULL,"
				+ "	data_publicada DATE,"
				+ "	autor VARCHAR(100),"
				+ "	qtd_estoque INTEGER NOT NULL,"
				+ " preco_unit REAL NOT NULL,"
				+ "	id_editora INTEGER,"
				+ "	CONSTRAINT fk_livro_editora FOREIGN KEY (id_editora) REFERENCES Editora (id_editora)"
				+ ");";
		
		String itemPedido = "CREATE TABLE IF NOT EXISTS Item ("
				+ "	id_item INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ " id_livro INTEGER NOT NULL,"
				+ " id_pedido INTEGER NOT NULL,"
				+ " qtd_vendida INTEGER NOT NULL,"
				+ " total_preco REAL,"
				+ " CONSTRAINT fk_item_pedido FOREIGN KEY (id_pedido) REFERENCES Pedido (id_pedido),"
				+ " CONSTRAINT fk_item_livro FOREIGN KEY (id_livro) REFERENCES Livro (id_livro)"
				+ ");";
		
		String venda = "CREATE TABLE IF NOT EXISTS Pedido ("
				+ "	id_pedido INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ " id_funcionario INTEGER NOT NULL,"
				+ " data_venda DATE NOT NULL,"
				+ " total_preco REAL,"
				+ " CONSTRAINT fk_venda_pedido FOREIGN KEY (id_pedido) REFERENCES Pedido (id_pedido),"
				+ " CONSTRAINT fk_venda_funcionario FOREIGN KEY (id_funcionario) REFERENCES Funcionario (id_funcionario)"
				+ ");";
		
		Connection conn = null;
		
		Statement stm = null;
		
		try {
			
			conn = ConnectionFactory.createConnectionToSQLite();
			
			stm = conn.createStatement();
			
			stm.execute(funcionario);
			
			stm.execute(editora);
			
			stm.execute(livro);
			
			stm.execute(itemPedido);
			
			stm.execute(venda);
			
		} catch (Exception e){
			
			e.printStackTrace();
			
		} finally {
			
			try {
				
				if(conn != null) {
					conn.close();
				}
				
				if(stm != null) {
					stm.close();
				}
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
			
		}
	}
	
	public static void main(String[] args) {
		
		new TableFactory().createTables();
		
	}
	
}