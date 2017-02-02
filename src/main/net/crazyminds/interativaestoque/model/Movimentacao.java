package net.crazyminds.interativaestoque.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.GeneratedValue;

import org.hibernate.validator.NotNull;
import org.jboss.seam.annotations.Name;

/**
 *  
 * @author julio
 *
 */

@Entity
@Name("movimentacao")
public class Movimentacao implements Serializable
{

	private static final long serialVersionUID = 5151775093059368394L;
	
	@Column(name = "id_movimentacao")
	@Id 
	@GeneratedValue
    private Long id;
	
	@NotNull 
	@Column(name="data")
    @Temporal(TemporalType.TIMESTAMP)
	private Date data;
	
	@ManyToOne
	@JoinColumn(name="id_tipomovimentacao", referencedColumnName="id_tipomovimentacao")
	@NotNull 
	private TipoMovimentacao tipoMovimentacao; 
	
	@ManyToOne
	@NotNull 
	@JoinColumn(name="id_item", referencedColumnName="id_item")
	private Item item;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public TipoMovimentacao getTipoMovimentacao() {
		return tipoMovimentacao;
	}

	public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}


}
