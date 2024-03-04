package br.com.DevelDesafio.desafio.ProdutosRepository;

import br.com.DevelDesafio.desafio.Class.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Produtosrepository extends JpaRepository<Produtos, String> {
}
