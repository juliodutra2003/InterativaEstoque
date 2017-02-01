package net.crazyminds.interativaestoque.converter;

import java.math.BigInteger;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import net.crazyminds.interativaestoque.model.Modelo;

@FacesConverter("modeloConverter")
public class ModeloConverter  implements Converter{

		    @PersistenceContext(unitName = "InterativaEstoque")

		    private transient EntityManager em;  

		    public Object getAsObject(FacesContext ctx, UIComponent component,String value) {

		      return em.find(Modelo.class, new BigInteger(value)); 
		    }

		    public String getAsString(FacesContext fc, UIComponent uic, Object o) {

		        return ((Modelo) o).getNome(); 
		    }
}
