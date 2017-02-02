package net.crazyminds.interativaestoque.data;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

import net.crazyminds.interativaestoque.model.Categoria;

/**
 *  
 * @author julio
 *
 * Esta classe controla as chamadas oriundas da interface categoriaList.xhtml
 */

@Name("categoriaList")
public class CategoriaList extends EntityQuery<Categoria>
{
    private static final long serialVersionUID = 1L;

	public CategoriaList()
    {
        setEjbql("select categoria from Categoria categoria");
    }
	
	
    public List<SelectItem> getSelectItems(){
    	
   	 List<Categoria> categorias = getResultList();

   	 List<SelectItem> selectItems = new ArrayList<SelectItem> (categorias.size());

   	 for(Categoria c : categorias){
   		 selectItems.add(new SelectItem(c, c.getNome() ));
   	 }
   	 
   	 return selectItems;
   }
    
}
