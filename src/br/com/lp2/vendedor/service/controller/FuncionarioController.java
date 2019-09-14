package br.com.lp2.vendedor.service.controller;

import java.util.List;

import br.com.lp2.vendedor.comum.Enums.TipoCargo;
import br.com.lp2.vendedor.comum.VO.Funcionario;
import br.com.lp2.vendedor.dao.daos.FuncionarioDAO;
import br.com.lp2.vendedor.service.validacao.Acesso;
import br.com.lp2.vendedor.service.validacao.ValidaFuncionario;
import br.com.lp2.vendedor.service.validacao.ValidaTipo;

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

	public boolean insere(Funcionario func) throws Exception {
		boolean check = ValidaFuncionario.validaFunc(func);
		if (ValidaTipo.validaCadastroFuncionarios(func)) {
			FuncionarioDAO fDAO = new FuncionarioDAO();
			try {
				fDAO.Insere(func);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Nao foi possivel cadastrar funcionario");
				return false;
			}
		} else {
			System.out.println("Voce nao tem permissao para cadastrar um funcioanrio, he he he");
			return false;
		}

	}

	public boolean atualiza(Funcionario currentUser, Funcionario funcDadoNovo, int id) {

		if (ValidaTipo.validaCadastroFuncionarios(currentUser)) {
			FuncionarioDAO fDAO = new FuncionarioDAO();

			try {
				fDAO.Atualiza(funcDadoNovo, id);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		} else {
			System.out.println("Voce nao tem permissao para atualizar um funcioanrio, he he he");
			return false;
		}

	}

	public Funcionario consulta(int id) {

		FuncionarioDAO fDAO = new FuncionarioDAO();

		try {
			return (Funcionario) fDAO.Seleciona(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Funcionario consulta(String username) {

		FuncionarioDAO fDAO = new FuncionarioDAO();

		try {
			return (Funcionario) fDAO.Seleciona(username);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Object> consultaTodos() {
		FuncionarioDAO fDAO = new FuncionarioDAO();

		try {
			return fDAO.SelecionaTodos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean deleta(int id) {

		/*
		 * Para deletar um funcioanrio, utilizei a abordagem de que nao deve ser
		 * possivel deletar um gerente, apenas vendedores para evitar que vendedores
		 * apaguem os registros de gerentes.
		 */

		FuncionarioDAO fDAO = new FuncionarioDAO();

		try {
			Funcionario userFromId = (Funcionario) fDAO.Seleciona(id);
			if (userFromId.getCargo() == TipoCargo.VENDEDOR) {
				fDAO.Deleta(id);
				return true;
			} else {
				System.out.println("Nao eh possivel deletar um gerente.");
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

}
