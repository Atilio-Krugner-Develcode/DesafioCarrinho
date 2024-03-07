package br.com.DevelDesafio.desafio.ProdutosRepository;

import br.com.DevelDesafio.desafio.Class.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientesRepository  extends JpaRepository<Clientes,String> {
}
