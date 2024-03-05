package br.com.DevelDesafio.desafio.Class;

import br.com.DevelDesafio.desafio.Controller.RequestCarrinho;
import jakarta.persistence.*;
import lombok.*;

@Table(name ="carrinho_items")
@Entity(name = "carrinho_items")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class CarrinhoItems {
    @Id
    private int id ;

    private Integer carrinho_id;
    private Integer produto_id;
    private Integer quantidade;

    public CarrinhoItems(RequestCarrinho requestCarrinho) {
        this.carrinho_id = getCarrinho_id();
        this.produto_id = getProduto_id();
        this.quantidade = getQuantidade();
    }


}