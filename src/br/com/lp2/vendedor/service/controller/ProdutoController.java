package br.com.lp2.vendedor.service.controller;

import java.util.List;

import br.com.lp2.vendedor.comum.VO.Produto;
import br.com.lp2.vendedor.dao.daos.ProdutoDAO;

public class ProdutoController {
	//Nao precisa validar se eh gerente ou vendedor
	
	public boolean insere(Produto produto) {

		ProdutoDAO produtoDao = new ProdutoDAO();
		try {
			produtoDao.Insere(produto);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Nao foi possivel cadastrar produto");
			return false;
		}

	}

	public boolean atualiza(Produto produtoDadoNovo, int id) {

		ProdutoDAO produtoDao = new ProdutoDAO();

		try {
			produtoDao.Atualiza(produtoDadoNovo, id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	public Produto consulta(int id) {

		ProdutoDAO produtoDao = new ProdutoDAO();

		try {
			return (Produto) produtoDao.Seleciona(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Object> consultaTodos() {
		ProdutoDAO produtoDao = new ProdutoDAO();

		try {
			return produtoDao.SelecionaTodos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean deleta(int id) {

		ProdutoDAO produtoDao = new ProdutoDAO();

		try {
			produtoDao.Deleta(id);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

}
