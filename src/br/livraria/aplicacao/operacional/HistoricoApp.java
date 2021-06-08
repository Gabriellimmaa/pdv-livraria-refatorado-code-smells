package br.livraria.aplicacao.operacional;

import java.util.Vector;

import br.livraria.dao.VendaDAO;
import br.livraria.model.Venda;

/*
 * Responsavel pela telaHistorico
 */
public class HistoricoApp {

	// Organiza os dados de vendas em uma matriz
	public Object[][] getVendas(){
		
		VendaDAO vendaDAO = new VendaDAO();
		
		Vector<Venda> vendas = vendaDAO.getVendas();
		
		Object[][] dados = new Object[vendas.size()][3];
		
		for(int i = 0; i < vendas.size(); i++) {
			dados[i][0] = vendas.get(i).getId();
			dados[i][1] = vendas.get(i).getTotal();
			dados[i][2] = vendas.get(i).getDataVenda();
		}
		
		return dados;
	}
	
}