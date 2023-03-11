package curso.api.rest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity // JPA
public class Telefone {

	@Id // JPA
	@GeneratedValue(strategy = GenerationType.AUTO) // JPA
	private Long id;

	private String numero;

	// só com o import do hibernate deu, ta deprecated mas n tem problema
	@JsonIgnore //com.fastexml...
	@org.hibernate.annotations.ForeignKey(name = "usuario_id") // fk, amarrado a classe Usuario, objeto especifico de user q ta amarrado
	@ManyToOne(optional = false) // JPA. many Telefone para one Usuario
	private Usuario usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
