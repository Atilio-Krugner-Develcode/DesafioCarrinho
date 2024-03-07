package br.com.DevelDesafio.desafio.Class;

import br.com.DevelDesafio.desafio.Controller.RequestCarrinho_Itens;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

@Table(name ="carrinho_items")
@Entity(name = "carrinho_items")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class CarrinhoItems {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Id
    private int id ;

//    @JoinColumn(name = "carrinho_id", referencedColumnName = "id")

//    @ManyToOne
//    @JoinColumn(name = "produto_id", referencedColumnName = "id")

    @Getter
    private Integer produto_id;

    @Getter
    private Integer carrinho_id;

    private Integer quantidade;



    public CarrinhoItems(RequestCarrinho_Itens requestCarrinho_itens) {
        this.carrinho_id = null;
        this.produto_id = requestCarrinho_itens.produto_id();
        this.quantidade = requestCarrinho_itens.quantidade();

    }


    public void setProduto_id(Integer produtoId) {
        this.produto_id = produtoId;
    }



    public void setCarrinho_id(Integer carrinhoId) {
        this.carrinho_id = carrinhoId;
    }


}