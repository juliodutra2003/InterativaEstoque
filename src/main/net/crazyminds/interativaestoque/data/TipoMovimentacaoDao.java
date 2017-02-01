package net.crazyminds.interativaestoque.data;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.web.RequestParameter;
import org.jboss.seam.framework.EntityHome;

import net.crazyminds.interativaestoque.model.TipoMovimentacao;

@Name("tipoMovimentacaoHome")
public class TipoMovimentacaoDao extends EntityHome<TipoMovimentacao>
{

	private static final long serialVersionUID = 1L;
	@RequestParameter Long tipoMovimentacaoId;

    @Override
    public Object getId()
    {
        if (tipoMovimentacaoId == null)
        {
            return super.getId();
        }
        else
        {
            return tipoMovimentacaoId;
        }
    }

    @Override @Begin
    public void create() {
        super.create();
    }

}
