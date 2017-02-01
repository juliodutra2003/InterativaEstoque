package net.crazyminds.interativaestoque.controller;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.datamodel.DataModel;
import org.jboss.seam.annotations.datamodel.DataModelSelection;
import org.jboss.seam.faces.FacesMessages;

import net.crazyminds.interativaestoque.data.IItemDao;
import net.crazyminds.interativaestoque.data.ItemList;
import net.crazyminds.interativaestoque.data.MovimentacaoDao;
import net.crazyminds.interativaestoque.data.TipoMovimentacaoList;
import net.crazyminds.interativaestoque.model.Item;
import net.crazyminds.interativaestoque.model.Movimentacao;
import net.crazyminds.interativaestoque.model.TipoMovimentacao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Name("itemController")
@Scope(ScopeType.SESSION)
public class ItemController implements Serializable, IItemController
{
	
	private static final long serialVersionUID = -7820566107959317457L;
	
	@In 
	FacesMessages facesMessages;

	@In(create=true)
	private IItemDao itemDao;
	
	@In(create=true)
	private MovimentacaoDao movimentacaoDao;
	
	@In(create=true)
	private TipoMovimentacaoList tipoMovimentacaoList;
	
	@In(create = true, value="itemList")
	private ItemList itemList;

	@DataModel
	private List<Item> itens;

	@DataModelSelection
	@Out(required=false)
	private Item item;
	
    @Factory("itens")
    public void listarContatos() {
    	itens = itemList.getResultList();
    }

	public String novoItem() {
		item = new Item();

		return "novoItem";
	}

	public String editarItem() {
		itemDao.refresh(item);
		listarContatos();
		return "editarItem";
	}

	public String removerItem() {
		itemDao.removerItem(item);		
		listarContatos();
		return "itemRemovido";
	}

	public String salvarNovoItem() {
		item.setEmestoque(1);
		item = itemDao.criarItem(item);
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>");
		System.out.println("item " + item.toString());
		System.out.println(">>>>>>>>>>>>>>>>>>>>");
		
		Movimentacao m = movimentacaoDao.getInstance();
		m.setData(new Date() );
		m.setItem(item);
		tipoMovimentacaoList.setTipoNome("Entrada");
		TipoMovimentacao tipo;
		tipo = tipoMovimentacaoList.getResultList().get(0);
		m.setTipoMovimentacao(tipo);		

		movimentacaoDao.setInstance(m);
		movimentacaoDao.persist();
		
		listarContatos();
		return "itemSalvo";
	}

	public String atualizarItem() {
		itemDao.atualizarItem(item);
		listarContatos();
		return "itemSalvo";
	}
	
	public String SelecionaItem(Item item)
	{
		this.item = item;
		System.out.println("SelecionaItem: " + item.toString());
		return "itemEstoqueSelecionado";
	}
	

	public String SetEmEstoque()
	{
		System.out.println("SetEmEstoque(BEFORE): " + item.toString());
		
		if(item.getEmestoque() == 1)
		{
			item.setEmestoque(0);
			
			Movimentacao m = movimentacaoDao.getInstance();
			m.setData(new Date() );
			m.setItem(item);
			tipoMovimentacaoList.setTipoNome("Saída");
			TipoMovimentacao tipo;
			tipo = tipoMovimentacaoList.getResultList().get(0);
			m.setTipoMovimentacao(tipo);		

			movimentacaoDao.setInstance(m);
			movimentacaoDao.persist();
		}
		else
		{
			item.setEmestoque(1);
			
			Movimentacao m = movimentacaoDao.getInstance();
			m.setData(new Date() );
			m.setItem(item);
			tipoMovimentacaoList.setTipoNome("Entrada");
			TipoMovimentacao tipo;
			tipo = tipoMovimentacaoList.getResultList().get(0);
			m.setTipoMovimentacao(tipo);		

			movimentacaoDao.setInstance(m);
			movimentacaoDao.persist();
		}
		
		System.out.println("SetEmEstoque(AFTER): " + item.toString());
		itemDao.atualizarItem(item);
		
		facesMessages.add("Status do item foi atualizado");
		
		return "itemEstoqueEmEstoque";
	}
}


