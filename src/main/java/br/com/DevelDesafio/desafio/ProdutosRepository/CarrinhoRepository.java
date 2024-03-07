package br.com.DevelDesafio.desafio.ProdutosRepository;

import br.com.DevelDesafio.desafio.Class.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrinhoRepository extends JpaRepository<Carrinho, String> {
}
