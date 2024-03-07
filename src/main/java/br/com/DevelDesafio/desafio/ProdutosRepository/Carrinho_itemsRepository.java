package br.com.DevelDesafio.desafio.ProdutosRepository;

import br.com.DevelDesafio.desafio.Class.CarrinhoItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface Carrinho_itemsRepository extends JpaRepository<CarrinhoItems, Integer> {


//    @Query("SELECT ci FROM carrinho_items ci INNER JOIN ci.produto_id p WHERE ci.carrinho_id = :carrinhoId")
//    List<CarrinhoItems> findAllByCarrinhoId(@Param("carrinhoId") Integer carrinhoId);

//    @Query("SELECT SUM(p.preco * ci.quantidade) FROM carrinho_items ci INNER JOIN ci.produto_id p WHERE ci.carrinho_id = :carrinhoId")
//    Double calcularValorTotalVenda(@Param("carrinhoId") Integer carrinhoId);

    @Query("SELECT ci FROM carrinho_items AS ci WHERE ci.produto_id = :productId AND ci.carrinho_id = :carrinhoId")
    Optional <CarrinhoItems>  getByProductInCarrinhoItems(@Param("productId") Integer productId, @Param("carrinhoId") Integer carrinhoId);
}
