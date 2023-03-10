package curso.api.rest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import curso.api.rest.model.Usuario;

@Repository //spring
public interface UsuarioRepository extends CrudRepository<Usuario, Long> { //extends dessa outra interface
	
}
