package curso.api.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //para ser possivel usar REST(ARQUITETURA dos bgl todo)/RESTful(methods da arquitetura)
@RequestMapping(value = "/usuario")
public class IndexController {

	//Isso aq é RESTful, serviço RESTful, RESTful service, service RESTful
	//Serviço pq? pq faz algo pra gente aq, serve...
	//return ResponseEntity, classe q serve pra dar resposta/response
	//produces = "application/json" retorna JSON, objeto em forma de texto, consumido por qualquer tecnologia
	@GetMapping(value = "/", produces = "application/json") //get, acessa pela url, mapear para raiz=/, parte inicial do software
	public ResponseEntity init(@RequestParam(value = "nome", required = true, defaultValue = "Nome não informado") String nome,
			@RequestParam(value = "salario") Long salario) {
		System.out.println("Parametro sendo recebido: "+nome);
		return new ResponseEntity("Olá Usuário REST Spring Boot, seu nome é: "+nome+" e seu salário é: "+salario, HttpStatus.OK);
	}
	
}
