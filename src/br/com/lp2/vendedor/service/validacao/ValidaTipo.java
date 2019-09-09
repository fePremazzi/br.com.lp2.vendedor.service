package br.com.lp2.vendedor.service.validacao;

import br.com.lp2.vendedor.comum.Enums.TipoCargo;
import br.com.lp2.vendedor.comum.VO.Funcionario;

public class ValidaTipo {
	
	public static boolean validaCadastroFuncionarios(Funcionario user) {
		if (user.getCargo() == TipoCargo.GERENTE) {
			return true;
		}
		return false;
	}
	

}
