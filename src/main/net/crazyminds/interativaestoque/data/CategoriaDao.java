package net.crazyminds.interativaestoque.data;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.web.RequestParameter;
import org.jboss.seam.framework.EntityHome;

import net.crazyminds.interativaestoque.model.Categoria;

@Name("categoriaDao")
public class CategoriaDao extends EntityHome<Categoria>
{
    private static final long serialVersionUID = 1L;
	@RequestParameter Long categoriaId;

    @Override
    public Object getId()
    {
        if (categoriaId == null)
        {
            return super.getId();
        }
        else
        {
            return categoriaId;
        }
    }

    @Override @Begin
    public void create() {
        super.create();
    }

}
