package curso.api.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import curso.api.rest.model.Usuario;
import curso.api.rest.repository.UsuarioRepository;

@CrossOrigin
@RestController //para ser possivel usar REST(ARQUITETURA dos bgl todo)/RESTful(methods da arquitetura)
@RequestMapping(value = "/usuario")
public class IndexController {

	@Autowired //do spring, mas se fosse CDI seria @Inject
	private UsuarioRepository usuarioRepository;
	
	//Isso aq é RESTful, serviço RESTful, RESTful service, service RESTful
	//Serviço pq? pq faz algo pra gente aq, serve...
	//return ResponseEntity, classe q serve pra dar resposta/response
	//produces = "application/json" retorna JSON, objeto em forma de texto, consumido por qualquer tecnologia
	//PathVariable é para path(caminho da url)
	@GetMapping(value = "/{id}", produces = "application/json") //get, acessa pela url, mapear para raiz=/, parte inicial do software
	public ResponseEntity<Usuario> init(@PathVariable(value = "id") Long id) {
		Optional<Usuario> usuario=usuarioRepository.findById(id);
		return new ResponseEntity<Usuario>(usuario.get(), HttpStatus.OK);
	}
	
	@GetMapping(value = "/", produces="application/json")
	public ResponseEntity<List<Usuario>> usuarios(){
		List<Usuario> usuarios=(List<Usuario>) usuarioRepository.findAll();
		return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
	}
	
	@PostMapping(value = "/", produces = "application/json") //msm q o map seja igual pro get, se mudado no postman por exemplo, ja chama o post especifico...
	public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario usuario){
		for(int i=0; i < usuario.getTelefones().size(); i++) {
			usuario.getTelefones().get(i).setUsuario(usuario); //.get pq é uma List do java.util
		}
		
		Usuario usuarioSalvo=usuarioRepository.save(usuario);
		return new ResponseEntity<Usuario>(usuarioSalvo, HttpStatus.CREATED); //ou OK
	}
	
	@PutMapping(value = "/", produces = "application/json")
	public ResponseEntity<Usuario> atualizar(@RequestBody Usuario usuario){
		for(int i=0; i < usuario.getTelefones().size(); i++) {
			usuario.getTelefones().get(i).setUsuario(usuario); //.get pq é uma List do java.util
		}
		
		Usuario usuarioAtualizado=usuarioRepository.save(usuario);
		return new ResponseEntity<Usuario>(usuarioAtualizado, HttpStatus.OK);
	}
	
	//Serviço RESTful, por GET digamos assim
	@DeleteMapping(value="/{id}", produces="application/text")
	public String deletar(@PathVariable(value="id") Long id) {
		usuarioRepository.deleteById(id);
		return "ok";
	}
	
}
