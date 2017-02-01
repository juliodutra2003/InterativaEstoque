package net.crazyminds.interativaestoque.data;

import net.crazyminds.interativaestoque.model.Item;

import java.io.Serializable;
import javax.persistence.EntityManager;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

@Name("itemDao")
@Scope(ScopeType.APPLICATION)
public class ItemDao implements Serializable, IItemDao{

	private static final long serialVersionUID = 5335374821528193494L;
	
	@In
	private EntityManager entityManager;


	public void refresh(Item item) {
		entityManager.merge(item);
	}

	public void removerItem(Item item) {
		entityManager.remove(item);
	}

	public Item atualizarItem(Item item) {
		entityManager.merge(item);
		entityManager.flush();  
		return item;
	}


	public Item criarItem(Item item) {
		entityManager.persist(item);
		entityManager.flush();
		return item;
	}
}
