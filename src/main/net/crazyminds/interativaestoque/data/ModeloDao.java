package net.crazyminds.interativaestoque.data;

import org.jboss.seam.annotations.Name;

import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.web.RequestParameter;
import org.jboss.seam.framework.EntityHome;

import net.crazyminds.interativaestoque.model.Modelo;

/**
 *  
 * @author julio
 *
 * Esta classe controla as chamadas oriundas da interface modelo.xhtml
 * Como é uma classe muito simples, este Dao ainda não precisa ser protejido por uma classe controller/action
 */

@Name("modeloDao")
public class ModeloDao extends EntityHome<Modelo>
{
    private static final long serialVersionUID = 1L;
	@RequestParameter Long modeloId;

    @Override
    public Object getId()
    {
        if (modeloId == null)
        {
            return super.getId();
        }
        else
        {
            return modeloId;
        }
    }

    @Override @Begin
    public void create() {
        super.create();
    }

}
