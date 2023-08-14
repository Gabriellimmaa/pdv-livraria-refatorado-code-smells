package br.livraria.controlador.menu;

import br.livraria.dao.FuncionarioDAO;
import br.livraria.model.Funcionario;

import br.livraria.util.TratamentoErro;

/*
 * Responsavel por gerenciar o Login
 */
public class LoginControlador {

    private LoginControlador() {
    }

    private static Funcionario funcionarioLogado;
    
    /*
	 * Responsavel por validar as entradas de id e senha
	 */

    public static boolean fazerLogin(String idUsuario, String senha) {
        
        try {
            int id = Integer.parseInt(idUsuario);
		    Funcionario funcionario = buscarFuncionario(id);

			if (funcionario == null) {
				TratamentoErro.exibirMensagem("ID Usuario nao encontrado");
				return false;
			}

			if (verificarSenha(funcionario, senha)) {
				funcionarioLogado = funcionario;
				return true;
			}else {
				TratamentoErro.exibirMensagem("Senha invalida");
			}
			
			return false;
        } catch (NumberFormatException e) {
            TratamentoErro.exibirMensagem("ID Usuario precisa ser um numero valido");
            return false;
        }
    }
    
    /*
	 * Retorna o funcionario que esta logado
	 */

    public static Funcionario getFuncionarioLogado() {
        return funcionarioLogado;
    }

    private static Funcionario buscarFuncionario(int id) {
        return FuncionarioDAO.getFuncionarioById(id);
    }

    private static boolean verificarSenha(Funcionario funcionario, String senha) {
        return funcionario.getSenha().equals(senha);
    }
}