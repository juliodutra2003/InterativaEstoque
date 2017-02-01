package net.crazyminds.interativaestoque.data;

import java.util.Arrays;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import net.crazyminds.interativaestoque.model.TipoMovimentacao;

@Name("tipoMovimentacaoList")
public class TipoMovimentacaoList extends EntityQuery<TipoMovimentacao>
{
	private static final long serialVersionUID = 1L;
	
	private String tipoNome;	 

	public TipoMovimentacaoList()
    {
        setEjbql("select tipoMovimentacao from TipoMovimentacao tipoMovimentacao");
        setRestrictionExpressionStrings(Arrays.asList(new String[] {
                "tipoMovimentacao.nome = #{tipoMovimentacaoList.tipoNome}" // (2)
            }));
    }
	
	public String getTipoNome() {
		return tipoNome;
	}
	
	public void setTipoNome(String tipoNome) {
		this.tipoNome = tipoNome;
	}


}
