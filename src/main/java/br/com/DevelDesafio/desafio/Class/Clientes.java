package br.com.DevelDesafio.desafio.Class;

import br.com.DevelDesafio.desafio.Controller.RequestCliente;
import jakarta.persistence.*;
import lombok.*;

@Table(name ="clientes")
@Entity(name = "clientes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Clientes {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Id
    private int id;
    private String nome;
    @Getter
    private Integer carrinho_id;

    public Clientes(RequestCliente requestCliente) {
        this.nome = requestCliente.nome();
        this.carrinho_id = null;
    }

    public void setCarrinho_id(Integer idCarrinho) {
        this.carrinho_id = idCarrinho;
    }
}
