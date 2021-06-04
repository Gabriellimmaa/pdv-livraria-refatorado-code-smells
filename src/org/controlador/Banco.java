package org.controlador;

import java.sql.*;
import java.util.Vector;

import org.ator.Administrador;
import org.ator.Editora;
import org.ator.Funcionario;
import org.ator.ItemPedido;
import org.ator.Livro;
import org.ator.Pedido;
import org.ator.Venda;

import com.sun.net.httpserver.Authenticator.Result;

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
					+ "	email VARCHAR(50),"
					+ " senha VARCHAR(25) NOT NULL"
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
					+ "	data_contrat DATE NOT NULL,"
					+ " senha VARCHAR(25) NOT NULL"
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
					+ "	genero VARCHAR(50) NOT NULL,"
					+ "	data_pub DATE,"
					+ "	autor VARCHAR(100),"
					+ "	qtd_estoque INTEGER,"
					+ "	cod_editora INTEGER,"
					+ "	CONSTRAINT fk_livro_editora FOREIGN KEY (cod_editora) REFERENCES Editora (cod_editora)"
					+ ");");
			
			stm.execute("CREATE TABLE IF NOT EXISTS Pedido ("
					+ " cod_pedido INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ " data_pedido DATE NOT NULL"
					+ ");"); 
			
			stm.execute("CREATE TABLE IF NOT EXISTS ItemPedido ("
					+ " cod_item INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ " valor_unit INTEGER NOT NULL, "
					+ " quantidade INTEGER NOT NULL, "
					+ " cod_livro INTERGER NOT NULL,"
					+ " CONSTRAINT fk_itemPedido_livro FOREIGN KEY (cod_livro) REFERENCES Livro (cod_livro)"
					+");");
			
			stm.execute("CREATE TABLE IF NOT EXISTS Venda ("
					+ " cod_venda INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ " valor_unit INTEGER NOT NULL, "
					+ " quantidade INTEGER NOT NULL, "
					+ " data_venda DATE NOT NULL,"
					+ " cod_livro INTERGER NOT NULL,"
					+ " cod_func INTERGER NOT NULL,"
					+ " CONSTRAINT fk_venda_livro FOREIGN KEY (cod_livro) REFERENCES Livro (cod_livro),"
					+ " CONSTRAINT fk_venda_funcionario FOREIGN KEY (cod_func) REFERENCES Funcionario (cod_func)"
					+");");
			
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
	
	public void removerFuncionario(int idFuncionario) {
		
		try {		  
			this.stm = this.conn.createStatement();

			this.stm.executeUpdate("DELETE FROM Funcionario WHERE cod_func = " + idFuncionario);
		}
		catch (SQLException e) {
			e.printStackTrace();  
		}
		
	}
	
	public Funcionario pegarFuncionario(int idFuncionario) {
		
		ResultSet rs;
		Funcionario f = new Funcionario();
		
		try {
			
			this.stm = this.conn.createStatement();
			
			rs = this.stm.executeQuery("SELECT * FROM Funcionario WHERE cod_func = " + idFuncionario);
			
			f = extrairFuncionario(rs);
			
			rs.close();

		}
		catch (SQLException e) {
			e.printStackTrace();
		}

		return f;
	}
	
	public Vector<Funcionario> pegarTodosFuncionarios() {
		
		Vector<Funcionario> funcionarios = new Vector<>();
		ResultSet rs;
		
		try {
			
			this.stm = this.conn.createStatement();
			
			rs = this.stm.executeQuery("SELECT * FROM Funcionario");
			
			while (rs.next()) {
				
				Funcionario f = new Funcionario();
				f = extrairFuncionario(rs);
				
				funcionarios.add(f);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return funcionarios;
		
	}

	private Funcionario extrairFuncionario(ResultSet rs) throws SQLException {
		
		/*
		 * Código -> idFunc int
		 * CPF -> cpf String
		 * Nome -> nome String
		 * Endereço -> endereco String
		 * Cidade -> cidade String
		 * Estado -> estado String
		 * Telefone -> telefone String
		 * E-mail -> email String
		 */
		
		Funcionario f = new Funcionario();
		
		f.setIdFunc(rs.getInt("cod_func"));
		f.setCpf(rs.getString("cpf"));
		f.setNome(rs.getString("nome"));
		f.setEndereco(rs.getString("endereco"));
		f.setCidade(rs.getString("cidade"));
		f.setEstado(rs.getString("estado"));
		f.setTelefone(rs.getString("telefone"));
		f.setEmail(rs.getString("email"));
		
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
					+ "'" + a.getDataContratacao() + "');");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void removerAdministrador(int idFuncionario) {
		
		try {		  
			this.stm = this.conn.createStatement();

			this.stm.executeUpdate("DELETE FROM Administrador WHERE cod_func = " + idFuncionario);
		}
		catch (SQLException e) {
			e.printStackTrace();  
		}
		
	}
	
	public Administrador pegarAdministrador(int idFuncionario) {
		
		ResultSet rs;
		Administrador a = new Administrador();
		
		try {
			
			this.stm = this.conn.createStatement();
			
			rs = this.stm.executeQuery("SELECT * FROM Administrador WHERE cod_func = " + idFuncionario);
			
			a = extrairAdministrador(rs);
			
			rs.close();

		}
		catch (SQLException e) {
			e.printStackTrace();
		}

		return a;
		
	}
	
	public Vector<Administrador> pegarTodosAdministradores() {
		
		Vector<Administrador> administradores = new Vector<>();
		ResultSet rs;
		
		try {
			
			this.stm = this.conn.createStatement();
			
			rs = this.stm.executeQuery("SELECT * FROM Administrador");
			
			while (rs.next()) {
				
				Administrador a = new Administrador();
				a = extrairAdministrador(rs);
				
				administradores.add(a);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return administradores;
		
	}

	private Administrador extrairAdministrador(ResultSet rs) throws SQLException {
		
		/*
		 * Código -> idFunc int
		 * CPF -> cpf String
		 * Nome -> nome String
		 * Endereço -> endereco String
		 * Cidade -> cidade String
		 * Estado -> estado String
		 * Telefone -> telefone String
		 * E-mail -> emaiil String
		 * Data de contratacao -> dataContratacao Date
		 */
		
		Administrador a = new Administrador();
		
		a.setIdFunc(rs.getInt("cod_func"));
		a.setCpf(rs.getString("cpf"));
		a.setNome(rs.getString("nome"));
		a.setEndereco(rs.getString("endereco"));
		a.setCidade(rs.getString("cidade"));
		a.setEstado(rs.getString("estado"));
		a.setTelefone(rs.getString("telefone"));
		a.setEmail(rs.getString("email"));
		a.setDataContratacao(rs.getDate("data_contrat"));
		
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
	
	public void removerEditora(int idEditora) {
		
		try {		  
			this.stm = this.conn.createStatement();

			this.stm.executeUpdate("DELETE FROM Editora WHERE cod_editora = " + idEditora);
		}
		catch (SQLException e) {
			e.printStackTrace();  
		}
		
	}
	
	public Editora pegarEditora(int idEditora) {
		
		ResultSet rs;
		Editora ed = new Editora();
		
		try {
			
			this.stm = this.conn.createStatement();
			
			rs = this.stm.executeQuery("SELECT * FROM Editora WHERE cod_editora = " + idEditora);
			
			ed = extrairEditora(rs);
			
			rs.close();

		}
		catch (SQLException e) {
			e.printStackTrace();
		}

		return ed;
		
	}
	
	public Vector<Editora> pegarTodasEditoras() {
		
		Vector<Editora> editoras = new Vector<>();
		ResultSet rs;
		
		try {
			
			this.stm = this.conn.createStatement();
			
			rs = this.stm.executeQuery("SELECT * FROM Editora");
			
			while (rs.next()) {
				
				Editora ed = new Editora();
				ed = extrairEditora(rs);
				
				editoras.add(ed);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return editoras;
		
	}

	private Editora extrairEditora(ResultSet rs) throws SQLException {
		
		/*
		 * Código -> idEditora int
		 * Nome -> nome String
		 * CNPJ -> cnpj String
		 * Endereco -> endereco String
		 */
		
		Editora ed = new Editora();
		
		ed.setIdEditora(rs.getInt("cod_editora"));
		ed.setNome(rs.getString("nome"));
		ed.setCnpj(rs.getString("cnpj"));
		ed.setEndereco(rs.getString("endereco"));
		
		return ed;
	}
	
	//LIVRO
	
	public void adicionarLivro(Livro li) {
		
		//titulo, genero, data_pub, autor, qtd_estoque, cod_editora
		
		try {
			
			this.stm = this.conn.createStatement();
			
			this.stm.executeUpdate("INSERT INTO Livro(titulo, genero, data_pub, autor, qtd_estoque, cod_editora) VALUES ("
					+ "'" + li.getTitulo() + "',"
					+ "'" + li.getGenero() + "',"
					+ "'" + li.getDataPub() + "',"
					+ "'" + li.getAutor() + "',"
					+ li.getQtdEstoque() + ","
					+ li.getEditora().getIdEditora() + ");");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void removerLivro(int idLivro) {
		
		try {		  
			this.stm = this.conn.createStatement();

			this.stm.executeUpdate("DELETE FROM Livro WHERE cod_livro = " + idLivro);
		}
		catch (SQLException e) {
			e.printStackTrace();  
		}
		
	}
	
	public Livro pegarLivro(int idLivro) {
		
		ResultSet rs;
		Livro li = new Livro();
		
		try {
			
			this.stm = this.conn.createStatement();
			
			rs = this.stm.executeQuery("SELECT * FROM Livro WHERE cod_livro = " + idLivro);
			
			li = extrairLivro(rs);

			rs.close();

		}
		catch (SQLException e) {
			e.printStackTrace();
		}

		return li;	
	}
	
	public Vector<Livro> pegarTodosLivros() {
		
		Vector<Livro> livros = new Vector<>();
		ResultSet rs;
		
		try {
			
			this.stm = this.conn.createStatement();
			
			rs = this.stm.executeQuery("SELECT * FROM Livro");
			
			while (rs.next()) {
				
				Livro li = new Livro();
				li = extrairLivro(rs);
				
				livros.add(li);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return livros;
		
	}

	private Livro extrairLivro(ResultSet rs) throws SQLException {
		
		/*
		 * Código -> idLivro int
		 * Título -> titulo String
		 * Editora -> editora editora
		 * Gênero -> genero String
		 * Data de Publicação -> dataPub Date
		 * Autor -> autor String
		 * Quantidade em Estoque -> qtdEstoque int
	 	 */
		
		Livro li = new Livro();
		
		int idEditora = rs.getInt("cod_editora");
		Editora ed = pegarEditora(idEditora);
		
		li.setIdLivro(rs.getInt("codLivro"));
		li.setTitulo(rs.getString("titulo"));
		li.setGenero(rs.getString("genero"));
		li.setDataPub(rs.getDate("dataPub"));
		li.setAutor(rs.getString("autor"));
		li.setQtdEstoque(rs.getInt("qtdEstoque"));
		li.setEditora(ed);
		
		return li;
	}
	
	//PEDIDO
	
	public void adicionarPedido(Pedido p) {
		
		try {
			
			this.stm = this.conn.createStatement();
			
			this.stm.executeUpdate("INSERT INTO Pedido(id_pedido, data_pedido) VALUES ("
					+ "'" + p.getDataPedido() + "',"
					+ "'" + p.getIdPedido() + "');");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void removerPedido(int idPedido) {
		
		try {		  
			this.stm = this.conn.createStatement();

			this.stm.executeUpdate("DELETE FROM Pedido WHERE id_Pedido = " + idPedido);
		}
		catch (SQLException e) {
			e.printStackTrace();  
		}
		
	}
	
	public Pedido pegarPedido(int idPedido) {
		
		ResultSet rs;
		Pedido p = new Pedido();
		
		try {
			
			this.stm = this.conn.createStatement();
			
			rs = this.stm.executeQuery("SELECT * FROM Pedido WHERE id_Pedido = " + idPedido);
			
			p = extrairPedido(rs);
				
			rs.close();

		}
		catch (SQLException e) {
			e.printStackTrace();
		}

		return p;	
	}
	
	public Vector<Pedido> pegarTodosPedidos() {
		
		Vector<Pedido> pedidos = new Vector<>();
		ResultSet rs;
		
		try {
			
			this.stm = this.conn.createStatement();
			
			rs = this.stm.executeQuery("SELECT * FROM Pedido");
			
			while (rs.next()) {
				
				Pedido p = new Pedido();
				p = extrairPedido(rs);
				
				pedidos.add(p);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return pedidos;
		
	}

	private Pedido extrairPedido(ResultSet rs) throws SQLException {
		
		/*
		 * Código -> idPedido int
		 * Data do Pedido -> dataPedido Date
		*/
		
		Pedido p = new Pedido();
		
		p.setIdPedido(rs.getInt("cod_pedido"));
		p.setDataPedido(rs.getDate("data_pedido"));
		
		return p;
	}
	
	//ITEMPEDIDO
	
	public void adicionarItem(ItemPedido i) {
		
		try {
			
			this.stm = this.conn.createStatement();
			
			this.stm.executeUpdate("INSERT INTO Item(valor_unit, quantidade, cod_livro) VALUES ("
					+ i.getValorUnit() + ","
					+ i.getQuantidade() + ","
					+ i.getLivro().getIdLivro() + ");");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void removerItem(int idItem) {
		
		try {		  
			this.stm = this.conn.createStatement();

			this.stm.executeUpdate("DELETE FROM ItemPedido WHERE cod_item = " + idItem);
		}
		catch (SQLException e) {
			e.printStackTrace();  
		}
		
	}
	
	public ItemPedido pegarItem(int idItem) {
		
		ResultSet rs;
		ItemPedido i = new ItemPedido();
		
		try {
			
			this.stm = this.conn.createStatement();
			
			rs = this.stm.executeQuery("SELECT * FROM ItemPedido WHERE cod_item = " + idItem);
			
			i = extrairItemPedido(rs);
				
			rs.close();

		}
		catch (SQLException e) {
			e.printStackTrace();
		}

		return i;	
	}
	
	public Vector<ItemPedido> pegarTodosItensPedidos() {
		
		Vector<ItemPedido> itensPedidos = new Vector<>();
		ResultSet rs;
		
		try {
			
			this.stm = this.conn.createStatement();
			
			rs = this.stm.executeQuery("SELECT * FROM ItemPedido");
			
			while (rs.next()) {
				
				ItemPedido i = new ItemPedido();
				i = extrairItemPedido(rs);
				
				itensPedidos.add(i);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return itensPedidos;
		
	}

	private ItemPedido extrairItemPedido(ResultSet rs) throws SQLException {
		
		/*
		 * Código -> idItemPedido int  
		 * Valor Unitário -> valorUnit int
		 * Quantidade -> quantidade int
		 * Livro -> livro Livro
		*/
		
		ItemPedido i = new ItemPedido();
		
		int idLivro = rs.getInt("cod_livro");
		Livro li = pegarLivro(idLivro);
		
		i.setIdItemPedido(rs.getInt("cod_item"));
		i.setQuantidade(rs.getInt("quantidade"));
		i.setValorUnit(rs.getInt("valor_unit"));
		i.setLivro(li);
		
		return i;
	}
	
	//VENDA
	
	public void adicionarVenda(Venda v) {
		
		try {
			
			this.stm = this.conn.createStatement();
			
			this.stm.executeUpdate("INSERT INTO Item(valor_unit, quantidade, data_venda, cod_func, cod_livro) VALUES ("
					+ v.getValorUnit() + ","
					+ v.getQuantidade() + ","
					+ "'" + v.getDataVenda() + "',"
					+ v.getFuncionario().getIdFunc() + ","
					+ v.getLivro().getIdLivro() + ");");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void removerVenda(int idVenda) {
		
		try {		  
			this.stm = this.conn.createStatement();

			this.stm.executeUpdate("DELETE FROM Venda WHERE cod_venda = " + idVenda);
		}
		catch (SQLException e) {
			e.printStackTrace();  
		}
		
	}
	
	public Venda pegarVenda(int idVenda) {
		
		ResultSet rs;
		Venda v = new Venda();
		
		try {
			
			this.stm = this.conn.createStatement();
			
			rs = this.stm.executeQuery("SELECT * FROM Venda WHERE cod_venda = " + idVenda);
			
			v = extrairVenda(rs);
				
			rs.close();

		}
		catch (SQLException e) {
			e.printStackTrace();
		}

		return v;	
	}
	
	public Vector<Venda> pegarTodasVendas() {
		
		Vector<Venda> vendas = new Vector<>();
		ResultSet rs;
		
		try {
			
			this.stm = this.conn.createStatement();
			
			rs = this.stm.executeQuery("SELECT * FROM Venda");
			
			while (rs.next()) {
				
				Venda v = new Venda();
				v = extrairVenda(rs);
				
				vendas.add(v);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vendas;
		
	}

	private Venda extrairVenda(ResultSet rs) throws SQLException {
		
		/*
		 * Código -> idVenda int
		 * Livro -> livro Livro	
		 * Quantidade -> quantidade int
		 * Valor Unitário -> valorUnit int
		 * Data da Venda -> dataVenda Date
		 * Funcionario -> funcionario Funcionario
		*/
		
		Venda v = new Venda();
		
		int idLivro = rs.getInt("cod_livro");
		Livro li = pegarLivro(idLivro);
		
		int idFunc = rs.getInt("cod_func");
		Funcionario f = pegarFuncionario(idFunc);
		
		v.setIdVenda(rs.getInt("cod_venda"));
		v.setLivro(li);
		v.setQuantidade(rs.getInt("quantidade"));
		v.setValorUnit(rs.getInt("valor_unit"));
		v.setDataVenda(rs.getDate("data_venda"));
		v.setFuncionario(f);
		
		return v;
	}
	
}
