package net.crazyminds.interativaestoque.data;

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
