package br.com.DevelDesafio.desafio.Class;

import br.com.DevelDesafio.desafio.Controller.RequestCarrinho;
import br.com.DevelDesafio.desafio.Controller.RequestCliente;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Table(name ="carrinho")
@Entity(name = "carrinho")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Carrinho {
    @Id
    private int id;
    private int cliente_id;

    public Carrinho(RequestCarrinho requestCarrinho) {
        this.cliente_id = requestCarrinho.cliente_id();
    }


}
