package net.crazyminds.interativaestoque.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import org.hibernate.validator.NotNull;

/**
 *  
 * @author julio
 *
 */

@Entity
public class TipoMovimentacao implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Column(name = "id_tipomovimentacao")
	@Id 
	@GeneratedValue	
    private Long id;
	
	
	@NotNull
	@Column (name="nome", length=150, nullable=false)
    private String nome;

	
	public TipoMovimentacao() {}
	

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}



}
