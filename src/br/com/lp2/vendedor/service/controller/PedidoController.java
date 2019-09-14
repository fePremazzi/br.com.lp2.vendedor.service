package br.com.lp2.vendedor.service.controller;

import java.util.List;

import br.com.lp2.vendedor.comum.VO.Pedido;
import br.com.lp2.vendedor.dao.daos.PedidoDAO;

public class PedidoController {
	//Nao precisa validar se eh gerente ou vendedor
	
	public boolean insere(Pedido pedido) {

		PedidoDAO pedidoDao = new PedidoDAO();
		try {
			pedidoDao.Insere(pedido);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Nao foi possivel cadastrar pedido");
			return false;
		}
	}
	
	public boolean atualiza(Pedido pedidoDadoNovo, int id) {

		PedidoDAO pedidoDao = new PedidoDAO();

		try {
			pedidoDao.Atualiza(pedidoDadoNovo, id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Pedido consulta(int id) {

		PedidoDAO pedidoDao = new PedidoDAO();

		try {
			return (Pedido) pedidoDao.Seleciona(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Object> consultaTodos() {
		PedidoDAO pedidoDao = new PedidoDAO();

		try {
			return pedidoDao.SelecionaTodos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean deleta(int id) {

		PedidoDAO pedidoDao = new PedidoDAO();

		try {
			pedidoDao.Deleta(id);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}



}
