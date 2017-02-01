package net.crazyminds.interativaestoque.data;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

import net.crazyminds.interativaestoque.model.Modelo;

@Name("modeloList")
public class ModeloList extends EntityQuery<Modelo>
{
	private static final long serialVersionUID = 1L;

	public ModeloList()
    {
        setEjbql("select modelo from Modelo modelo");
    }
	
	
	public List<SelectItem> getSelectItems(){
    	
    	 List<Modelo> modelos = getResultList();

    	 List<SelectItem> selectItems = new ArrayList<SelectItem> (modelos.size() );

    	 for(Modelo m : modelos){
    		 selectItems.add(new SelectItem(m, m.getNome() ));
    	 }
    	 
    	 return selectItems;
    }
}
