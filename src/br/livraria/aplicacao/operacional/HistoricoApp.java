package br.livraria.aplicacao.operacional;

import java.util.Vector;

import br.livraria.dao.PedidoDAO;
import br.livraria.model.Pedido;

/*
 * Responsavel pela telaHistorico
 */
public class HistoricoApp {

	// Organiza os dados de vendas em uma matriz
	public Object[][] getPedidos(){
		
		Vector<Pedido> pedidos = new PedidoDAO().getPedidos();
		
		Object[][] dados = new Object[pedidos.size()][4];
		
		for(int i = 0; i < pedidos.size(); i++) {
			dados[i][0] = pedidos.get(i).getId();
			dados[i][1] = pedidos.get(i).getTotalPreco();
			dados[i][2] = pedidos.get(i).getDataVendida();
			dados[i][3] = pedidos.get(i).getFuncionario().getNome();
		}
		
		return dados;
	}
	
}