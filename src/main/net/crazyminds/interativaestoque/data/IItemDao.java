package net.crazyminds.interativaestoque.data;

import net.crazyminds.interativaestoque.model.Item;

public interface IItemDao {
		
	public void refresh(Item item);
	
	public void removerItem(Item item);

	public Item atualizarItem(Item item);
	
	public Item criarItem(Item item);
	
	
	
}
