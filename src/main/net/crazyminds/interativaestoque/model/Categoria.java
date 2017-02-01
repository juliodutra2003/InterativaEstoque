package net.crazyminds.interativaestoque.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.NotNull;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

import javax.persistence.GeneratedValue;

@Entity
@Name("categoria")
@Scope(ScopeType.SESSION)
@Table(name="categoria")
public class Categoria implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id 
	@Column(name = "id_categoria")
	@GeneratedValue
    private Long id;
    
	@NotNull
	@Column (name="nome", length=150, nullable=false)
    private String nome;
    
	public Categoria() {}
	
    public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
