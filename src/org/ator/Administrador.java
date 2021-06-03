package org.ator;

import java.util.Date;

public class Administrador extends Funcionario {

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
	
	private Date dataContratacao;

	public Date getDataContratacao() {
		return dataContratacao;
	}

	public void setDataContratacao(Date dataContracao) {
		this.dataContratacao = dataContracao;
	}
	
}
