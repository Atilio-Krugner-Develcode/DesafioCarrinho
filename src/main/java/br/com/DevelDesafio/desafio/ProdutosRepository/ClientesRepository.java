package br.com.DevelDesafio.desafio.ProdutosRepository;

import br.com.DevelDesafio.desafio.Class.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientesRepository  extends JpaRepository<Clientes,String> {
}
