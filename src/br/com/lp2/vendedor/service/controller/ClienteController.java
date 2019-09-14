package br.com.lp2.vendedor.service.controller;

import java.util.List;

import br.com.lp2.vendedor.comum.VO.Cliente;
import br.com.lp2.vendedor.dao.daos.ClienteDAO;

public class ClienteController {
	// Nao precisa validar se eh gerente ou vendedor

	public boolean insere(Cliente cliente) {

		ClienteDAO clienteDao = new ClienteDAO();
		try {
			clienteDao.Insere(cliente);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Nao foi possivel cadastrar cliente");
			return false;
		}

	}

	public boolean atualiza(Cliente clienteDadoNovo, int id) {

		ClienteDAO clienteDao = new ClienteDAO();

		try {
			clienteDao.Atualiza(clienteDadoNovo, id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	public Cliente consulta(int id) {

		ClienteDAO clienteDao = new ClienteDAO();

		try {
			return (Cliente) clienteDao.Seleciona(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Object> consultaTodos() {
		ClienteDAO clienteDao = new ClienteDAO();

		try {
			return clienteDao.SelecionaTodos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean deleta(int id) {

		ClienteDAO clienteDao = new ClienteDAO();

		try {
			clienteDao.Deleta(id);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

}
