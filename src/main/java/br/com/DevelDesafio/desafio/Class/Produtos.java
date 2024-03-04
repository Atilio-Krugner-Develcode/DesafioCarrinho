package br.com.DevelDesafio.desafio.Class;

import br.com.DevelDesafio.desafio.Controller.RequestProduto;
import jakarta.persistence.*;
import lombok.*;

@Table(name ="Produtos")
@Entity(name = "Produtos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class Produtos {
    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
    private int id;
    private String nome;
    private float preco;
    private int quantidade;

    public Produtos(RequestProduto requestProduto){
        this.nome = requestProduto.nome();
        this.preco = requestProduto.preco();
        this.quantidade = requestProduto.quantidade();
    }


}
