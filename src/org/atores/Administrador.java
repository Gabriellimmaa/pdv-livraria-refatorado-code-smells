package org.atores;

import java.util.Date;

public class Administrador extends Funcionario {

	//CPF, nome, endereço, cidade, estado, telefone residencial e telefone celular, e-mail, data de contratação.
	private Date dataContrat;

	public Date getDataContracao() {
		return dataContrat;
	}

	public void setDataContracao(Date dataContracao) {
		this.dataContrat = dataContracao;
	}
}
