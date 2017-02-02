package net.crazyminds.interativaestoque.data;

/**
 *  
 * @author julio
 *
 * Esta classe controla a busca pela lista de items em banco de dados.
 * Esta classe é protejida pela classe ItemController
 */

	import org.jboss.seam.annotations.Name;
	import org.jboss.seam.framework.EntityQuery;

import net.crazyminds.interativaestoque.model.Item;

	@Name("itemList")
	public class ItemList extends EntityQuery<Item>
	{

		private static final long serialVersionUID = 3269933689071946666L;

		public ItemList()
	    {
	        setEjbql("select item from Item item");
	    }
	}
