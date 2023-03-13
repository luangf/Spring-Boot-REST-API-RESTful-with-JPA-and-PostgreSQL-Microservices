package curso.api.rest.security;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import curso.api.rest.ApplicationContextLoad;
import curso.api.rest.model.Usuario;
import curso.api.rest.repository.UsuarioRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service //Spring
@Component //Spring
public class JWTTokenAutenticacaoService {

	//em ms, tempo de expiração do token (conversao dias: 2)
	//a cada uns dias sem acessar o site tem q acessar dnv
	private static final long EXPIRATION_TIME=172800000;

	//Senha única para compor a autenticação, senha foda...senha de certificado digital..
	private static final String SECRET="SenhaExtremamenteSecreta";
	
	//Bearer, prefixo padrão de token q vai ficar n o cabeçalho para compor
	private static final String TOKEN_PREFIX="Bearer";
	
	//identificação do cabeçalho da resposta, q vai dizer q é o token
	private static final String HEADER_STTRING="Authorization";

	//Gerando token de autenticação e adicionando ao cabeçalho e resposta Http
	public void addAuthentication(HttpServletResponse response, String username) throws IOException {
		
		//Montagem do token
		String JWT=Jwts.builder() //chama o gerador de token
				.setSubject(username) //adiciona o user q ta tentando logar
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)) //tempo de expiração
				.signWith(SignatureAlgorithm.HS512, SECRET) //algoritmo de geração de senha
				.compact(); //compactação
		
		//Junta o token com o prefixo
		String token=TOKEN_PREFIX + " " + JWT; //Bearer 423rvfdg45gfdsgsdrgtsgsgsd
		
		//Adiciona no cabeçalho http
		response.addHeader(HEADER_STTRING, token); //Authorization: Bearer 21cdsadt54tedsrgrds45gdgdsgdvd
	
		ApplicationContextLoad.getApplicationContext()
		.getBean(UsuarioRepository.class).atualizaTokenUser(JWT, username);
		
		//Liberando resposta para portas diferentes que usam a API ou caso clientes web
		liberacaoCors(response);
		
		//Escreve token como resposta no corpo do http
		response.getWriter().write("{\"Authorization\":\""+token+"\"}"); //json dentro da String ""
		
	}
	
	//Retorna o usuário validado com token ou caso não seja válido retorna null
	public Authentication getAuthentication(HttpServletRequest request, HttpServletResponse response) {
		//Pega o token enviado no cabeçalho http
		String token=request.getHeader(HEADER_STTRING);
		try {
		if(token != null) {
			
			String tokenLimpo=token.replace(TOKEN_PREFIX, "").trim();
			
			//Faz a validação do token do usuário na requisição
			String user=Jwts.parser() //descompacta
					.setSigningKey(SECRET)
					.parseClaimsJws(tokenLimpo) //tirar prefixo token, tirar Bearer
					.getBody().getSubject(); //Joao da silva
			
			if(user != null) {
				
				Usuario usuario=ApplicationContextLoad.getApplicationContext() //todos controllers, dao, services, repositories...
						.getBean(UsuarioRepository.class).findUserByLogin(user);
				
				if(usuario != null) {
					//equalsIgnoreCase? n so equals?
					if(tokenLimpo.equalsIgnoreCase(usuario.getToken())) {
						//Retorna o usuário logado
						return new UsernamePasswordAuthenticationToken(
								usuario.getLogin(),
								usuario.getSenha(),
								usuario.getAuthorities());
					}
				}
			}
		}//Fim condicao token
		}catch (io.jsonwebtoken.ExpiredJwtException e) {
			try {
				response.getOutputStream().println("Seu token está expirado, faça o login ou informe um novo token para autenticação");
			} catch (IOException e1) {}
		}
		
		liberacaoCors(response);
		return null; //Não autorizado 
		
	}

	private void liberacaoCors(HttpServletResponse response) {
		if (response.getHeader("Access-Control-Allow-Origin") == null) {
			response.addHeader("Access-Control-Allow-Origin", "*");
		}
		if (response.getHeader("Access-Control-Allow-Headers") == null) {
			response.addHeader("Access-Control-Allow-Headers", "*");
		}
		if (response.getHeader("Access-Control-Request-Headers") == null) {
			response.addHeader("Access-Control-Request-Headers", "*");
		}
		if(response.getHeader("Access-Control-Allow-Methods") == null) {
			response.addHeader("Access-Control-Allow-Methods", "*");
		}
	}
	
}
