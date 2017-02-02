package net.crazyminds.interativaestoque.data;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import net.crazyminds.interativaestoque.model.Movimentacao;

/**
 *  
 * @author julio
 *
 * Esta classe controla as chamadas oriundas da interface modeloList.xhtml
 */


@Name("movimentacaoList")
public class MovimentacaoList extends EntityQuery<Movimentacao>
{

	private static final long serialVersionUID = 3943699134044927679L;

	public MovimentacaoList()
    {
        setEjbql("select movimentacao from Movimentacao movimentacao");
    }
}
