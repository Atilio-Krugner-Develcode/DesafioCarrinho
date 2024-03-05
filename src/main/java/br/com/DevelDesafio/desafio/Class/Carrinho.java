package br.com.DevelDesafio.desafio.Class;

import jakarta.persistence.*;
import lombok.*;

@Table(name ="carrinho")
@Entity(name = "carrinho")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class Carrinho {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
    private int id;
    private float valor_total;

    public Carrinho(double valorTotalInicial) {
        this.valor_total = 0;
    }

//    @OneToMany(mappedBy = "carrinho", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<CarrinhoItems> itens = new ArrayList<>();

    
}
