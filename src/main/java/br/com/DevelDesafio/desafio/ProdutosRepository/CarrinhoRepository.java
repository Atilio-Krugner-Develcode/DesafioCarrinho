package br.com.DevelDesafio.desafio.ProdutosRepository;

import br.com.DevelDesafio.desafio.Class.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarrinhoRepository extends JpaRepository<Carrinho, String> {
}
