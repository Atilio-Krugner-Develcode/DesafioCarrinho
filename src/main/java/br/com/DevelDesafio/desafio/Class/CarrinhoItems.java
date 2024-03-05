package br.com.DevelDesafio.desafio.Class;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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


}
