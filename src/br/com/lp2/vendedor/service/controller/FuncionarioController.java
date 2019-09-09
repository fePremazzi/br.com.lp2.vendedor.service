package br.com.lp2.vendedor.service.controller;

import br.com.lp2.vendedor.comum.VO.Funcionario;
import br.com.lp2.vendedor.dao.daos.FuncionarioDAO;
import br.com.lp2.vendedor.service.validacao.Acesso;
import br.com.lp2.vendedor.service.validacao.ValidaFuncionario;

public class FuncionarioController {

	public boolean validByUsername(Funcionario funcDigitado) {
		FuncionarioDAO funcDAO = new FuncionarioDAO();
		Funcionario funcBanco = funcDAO.Seleciona(funcDigitado.getUsername());
		if (funcBanco != null) {
			Acesso acesso = new Acesso();			
			return acesso.validaUsuario(funcDigitado, funcBanco);
		}
		return false;
	}

	public boolean insereFuncionario(Funcionario func) throws Exception {
		boolean check = ValidaFuncionario.validaFunc(func);
		FuncionarioDAO fDAO = new FuncionarioDAO();
		try {
			fDAO.Insere(func);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
