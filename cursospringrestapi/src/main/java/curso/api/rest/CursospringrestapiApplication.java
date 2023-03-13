package curso.api.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EntityScan(basePackages = {"curso.api.rest.model"}) //para criar as table
@ComponentScan(basePackages = {"curso.*"}) //injeção de dependencia, para o Spring controlar todos os objs
@EnableJpaRepositories(basePackages = {"curso.api.rest.repository"}) //habilitar crud JPA
@EnableTransactionManagement //p/ n ter erro com transacoes, gerencia melhor
@EnableWebMvc //habilita recursos de MVC(Model-View-Controller), porém, trabalharemos so com REST aq
@RestController //p/ saber q é um projeto q vai rodar REST e os controllers retornarem JSON p/nois
@EnableAutoConfiguration //o spring pega e configura o projeto inteiro pra nois
@EnableCaching
public class CursospringrestapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CursospringrestapiApplication.class, args);
	}

}
