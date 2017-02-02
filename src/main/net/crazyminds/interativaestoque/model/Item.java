package net.crazyminds.interativaestoque.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.validator.NotNull;
import org.jboss.seam.annotations.Name;

/**
 *  
 * @author julio
 *
 */

@Entity
@Name("item")
public class Item implements Serializable
{

	private static final long serialVersionUID = 1521641660985998296L;

	@Column(name = "id_item")
	@Id 
	@GeneratedValue
    private Long id;
	
	@NotNull
	@Column (name="numeroserial", length=150, nullable=false)
    private String numeroSerial;
	
	@ManyToOne
	@JoinColumn(name="id_categoria", referencedColumnName="id_categoria")
	@NotNull
    private Categoria categoria;
	
	@ManyToOne
	@JoinColumn(name="id_modelo", referencedColumnName="id_modelo")
	@NotNull 
    private Modelo modelo;
	
	@NotNull
	@Column (name="emestoque", nullable=false)
    private int emestoque;

	public Item() {}
	
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public String getNumeroSerial() {
		return numeroSerial;
	}

	public void setNumeroSerial(String numeroSerial) {
		this.numeroSerial = numeroSerial;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Modelo getModelo() {
		return modelo;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public int getEmestoque() {
		return emestoque;
	}

	public void setEmestoque(int emestoque) {
		this.emestoque = emestoque;
	}
	
	public String toString()
	{
		return id+ "," + numeroSerial + "," + categoria.getNome() + "," + modelo.getNome() + "," + emestoque;
	}
	
	
}
