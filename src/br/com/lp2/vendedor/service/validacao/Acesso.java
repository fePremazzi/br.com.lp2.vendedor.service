package br.com.lp2.vendedor.service.validacao;

import br.com.lp2.vendedor.comum.VO.Funcionario;
import br.com.lp2.vendedor.dao.repo.Repositorio;

public class Acesso {

	private boolean validaSenha(String senhaRepositorio, String senhaDigitada) {
		return (senhaRepositorio.equals(senhaDigitada));
	}

	public boolean validaUsuario(Funcionario user, Funcionario funcBanco) {
		boolean retorno = false;
//        Repositorio repositorio = FabricaRepositorio.Fabrica();
//        
//        Usuario usuario = (Usuario)repositorio.localiza(user.getLogin(), EntidadesDisponiveis.USUARIO);

		return validaSenha(funcBanco.getSenha(), user.getSenha());

		
	}

}
