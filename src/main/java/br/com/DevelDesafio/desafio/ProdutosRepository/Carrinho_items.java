package br.com.DevelDesafio.desafio.ProdutosRepository;

import br.com.DevelDesafio.desafio.Class.CarrinhoItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Carrinho_items extends JpaRepository<CarrinhoItems, String> {
}
