package br.com.DevelDesafio.desafio.Class;

import br.com.DevelDesafio.desafio.Controller.RequestCliente;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

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
    private Integer carrinho_id;
//
    public Clientes(RequestCliente requestCliente) {
        this.nome = requestCliente.nome();
        this.carrinho_id = null;
    }

    public void setCarrinho_id(int carrinhoId) {
        this.carrinho_id = carrinhoId;
    }

    public int getCarrinho_id() {
        return carrinho_id;
    }


//    public void setCarrinho_id(int idCarrinho) {
//        this.carrinho_id = idCarrinho;
//    }
}
