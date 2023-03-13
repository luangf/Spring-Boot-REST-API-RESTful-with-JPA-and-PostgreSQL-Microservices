package curso.api.rest.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import curso.api.rest.model.Usuario;

@Repository //spring
public interface UsuarioRepository extends CrudRepository<Usuario, Long> { //extends dessa outra interface
	
	//so o login msm
	@Query("select u from Usuario u where u.login=?1") //jpa do spring
	Usuario findUserByLogin(String login); //buscando usuário por login para o Spring Security
	
}