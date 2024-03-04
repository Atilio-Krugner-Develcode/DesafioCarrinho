package br.com.DevelDesafio.desafio.Class;

import br.com.DevelDesafio.desafio.Controller.RequestCliente;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Table(name ="clientes")
@Entity(name = "clientes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Clientes {
    @Id
    private int id;
    private String nome;

    public Clientes(RequestCliente requestCliente) {
        this.nome = requestCliente.nome();
    }
}
