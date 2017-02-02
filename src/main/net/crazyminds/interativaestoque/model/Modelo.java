package net.crazyminds.interativaestoque.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.NotNull;
import org.hibernate.validator.Size;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

/**
 *  
 * @author julio
 *
 */

@Entity
@Name("modelo")
@Scope(ScopeType.SESSION)
@Table(name="modelo")
public class Modelo implements Serializable
{
		private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_modelo")
	@GeneratedValue
    private Long id;
	
	@NotNull
	@Column (name="nome", length=150, nullable=false)
    private String nome;
	
	
	public Modelo() {}


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
