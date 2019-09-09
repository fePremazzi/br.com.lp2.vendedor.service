package br.com.lp2.vendedor.service.validacao;

import com.sun.org.apache.xerces.internal.impl.validation.ValidationState;

import br.com.lp2.vendedor.comum.VO.Funcionario;

public class ValidaFuncionario {

	public static boolean validaFunc(Funcionario func) throws Exception {

		validaStringIsEmpty(func.getNome(), "Nome");
		validaStringIsEmpty(func.getSenha(), "Senha");
		validaStringIsEmpty(func.getUsername(), "Username");
		// TODO validar Id

		return true;
	}

	private static void validaStringIsEmpty(String nome, String campo) throws Exception {

		if (nome.isEmpty()) {
			throw new Exception(campo + " nao deve ser vazio");
		}
	}
	
	

}
