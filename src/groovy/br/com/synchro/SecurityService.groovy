package br.com.synchro

class SecurityService {
	/**
	 * Obtem o usuario corrente.
	 *
	 * @return Usuario corrente.
	 */
	def getUsuarioCorrente() {
			
	}


	/**
	 * TODO Rever este metodo (nao se troca mais os principals)
	 *
	 * Atualiza a Organizacao e os papeis do usuario presente no contexto.
	 *
	 * @param orgId Id da Organizacao substituinte.
	 * @param nomeOrg Nome dessa organizacao.
	 * @param principals Permissoes do usuario corrente nessa organizacao substituinte.
	 *
	 */
	def void trocarOrgContexto(orgId, nomeOrg = null, principals = null) {
			
	}

	/**
	 * Verifica se o usuÃ¡rio corrente possui todas as roles contidas na String "roles".
	 *
	 * @param roles - String com os nomes da roles separadas por vÃ­rgula. Ex. "Role 1, Role 2" Ex2. "Role 1"
	 * @return true se o usuÃ¡rio possuir todas as roles informadas
	 */
	def boolean loggedUserHasAllRoles(String roles) {
			true
	}
	/**
	 * Verifica se o usuÃ¡rio corrente possui qualquer uma das roles contidas na String "roles".
	 *
	 * @param roles - String com os nomes da roles separadas por vÃ­rgula. Ex. "Role 1, Role 2" Ex2. "Role 1"
	 * @return true se o usuÃ¡rio possuir qualquer uma das roles informadas
	 */
	def boolean loggedUserHasAnyRoles(String roles) {
			true
	}
}
