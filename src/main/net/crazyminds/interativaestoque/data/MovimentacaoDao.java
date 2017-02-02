package net.crazyminds.interativaestoque.data;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.web.RequestParameter;
import org.jboss.seam.framework.EntityHome;

import net.crazyminds.interativaestoque.model.Movimentacao;

/**
 *  
 * @author julio
 *
 * Esta classe controla as operações em banco de dados para a entidade movimentacao 
 * 
 */

@Name("movimentacaoDao")
public class MovimentacaoDao extends EntityHome<Movimentacao>
{

	private static final long serialVersionUID = 1961064670452102892L;
	
	@RequestParameter Long movimentacaoId;

    @Override
    public Object getId()
    {
        if (movimentacaoId == null)
        {
            return super.getId();
        }
        else
        {
            return movimentacaoId;
        }
    }

    @Override @Begin(join=true)
    public void create() {
        super.create();
    }

}
