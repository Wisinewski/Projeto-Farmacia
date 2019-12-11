/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;


import controller.ProdutoController;
import java.sql.SQLException;
import java.text.ParseException;

import db.DB;
import model.dao.PedidoDao;
import model.dao.ProdutoItemDao;
import model.dao.impl.PedidoDaoJDBC;
import model.dao.impl.ProdutoDaoJDBC;
import model.dao.impl.ProdutoItemDaoJDBC;
import model.entities.Pedido;
import model.entities.Produto;
import model.entities.ProdutoItem;

/**
 *
 * @author Morais
 */
public class Program {

    /**
     * @param args the command line arguments
     * @throws ParseException 
     */
    public static void main(String[] args) throws SQLException, ParseException  {
 
    	// OPERACOES CATEGORIA
    	/*
    	CategoriaDao categoriaDao = new CategoriaDaoJDBC(DB.getConnection());
    	categoriaDao.insert(new Categoria(null, "Quimicos"));
    	
    	System.out.println(categoriaDao.findById(1));
    	
    	categoriaDao.deleteById(32);
    	
    	List<Categoria> listaCategorias = categoriaDao.findAll();
    	listaCategorias.stream().forEach(System.out::println);
    	*/
    	//
    	
    	
    	// OPERACOES PRODUTO
    /*
    	ProdutoDao produtoDao = new ProdutoDaoJDBC(DB.getConnection());
    	
    	produtoDao.insert(new Produto(null, "Salgadinho", 5.0, "30-05-2020", "123", 0, 400, 2));
    	
    	System.out.println("teste"+produtoDao.findById(2));
    	
    	produtoDao.deleteById(1);
    	
    	List<Produto> listaProdutos = produtoDao.findAll();
    	listaProdutos.stream().forEach(System.out::println);
      
    // OPERACAO PRODUTO PESQUISA POR NOME
    
    	ProdutoDao produtoDao = new ProdutoDaoJDBC(DB.getConnection());
   
    	String desc = "Mateus";
    	List<Produto> listaProdutos = produtoDao.findByWord(desc);
    	listaProdutos.stream().forEach(System.out::println);
      
    */
    	
    /*	
    // INSERINDO E "POPULANDO COM ITENS" UM NOVO PEDIDO 
    	// instancia dao's
    	PedidoDao pedidoDao = new PedidoDaoJDBC(DB.getConnection());
    	ProdutoItemDao produtoItemDao = new ProdutoItemDaoJDBC(DB.getConnection());
    	
    	// cria entidade pedido com id nulo, data e preco zerado
    	Pedido pedido = new Pedido(null, "10-12-2019", 0.0);
    	// metodo insert do pedido j� puxa do banco o id gerado automaticamente e seta o id da entidade pedido criada acima
    	pedidoDao.insert(pedido);
    	System.out.println(pedido);
    	
    	// cria novo produtoItem e insere com parametros (idpedido, idproduto, qtd).  Tambem vai adicionando ao preco total;
    	ProdutoItem produtoItem = null;
    	produtoItem = new ProdutoItem(pedido.getIdpedido(), 3, 10);
    	produtoItemDao.insert(produtoItem);
    	pedido.adicionaPrecoPedido(produtoItem);
    	System.out.println(pedido);
    	produtoItem = new ProdutoItem(pedido.getIdpedido(), 4, 10);
    	produtoItemDao.insert(produtoItem);
    	pedido.adicionaPrecoPedido(produtoItem);
    	System.out.println(pedido);
    	produtoItem = new ProdutoItem(pedido.getIdpedido(), 8, 10);
    	produtoItemDao.insert(produtoItem);
    	pedido.adicionaPrecoPedido(produtoItem);
    	System.out.println(pedido);
    	
    	// finalmente atualiza o pedido em questao no banco j� com o preco final
    	pedidoDao.update(pedido);
    	
    	// retorna todos os id's de produtos e suas quantidades de determinado pedido
    	produtoItemDao.findAllById(pedido.getIdpedido()).stream().forEach(System.out::println);
    }
    */
    }
   
    
       
     
    
}
