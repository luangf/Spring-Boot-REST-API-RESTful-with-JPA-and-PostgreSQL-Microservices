package curso.api.rest.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import curso.api.rest.model.Usuario;

@Repository //spring
public interface UsuarioRepository extends CrudRepository<Usuario, Long> { //extends dessa outra interface
	
	//so o login msm
	@Query("select u from Usuario u where u.login=?1") //jpa do spring
	Usuario findUserByLogin(String login); //buscando usuário por login para o Spring Security
	
	@Transactional
	@Modifying
	@Query(nativeQuery = true, value="update usuario set token=?1 where login=?2")
	void atualizaTokenUser(String token, String login);
	
}