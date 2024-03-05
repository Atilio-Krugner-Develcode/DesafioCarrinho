package br.com.DevelDesafio.desafio.Controller;

import br.com.DevelDesafio.desafio.Class.Carrinho;
import br.com.DevelDesafio.desafio.Class.Clientes;
import br.com.DevelDesafio.desafio.ProdutosRepository.CarrinhoRepository;
import br.com.DevelDesafio.desafio.ProdutosRepository.ClientesRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClientesRepository clientesRepository;
    @Autowired
    private CarrinhoRepository carrinhoRepository;

    @GetMapping
    public ResponseEntity getALLProducts(){
        var clienteRetorno = clientesRepository.findAll();
        return ResponseEntity.ok(clienteRetorno);
    }
    @GetMapping("/{id}")
    public ResponseEntity getCliente(@PathVariable String id){

        Optional<Clientes> cliente = clientesRepository.findById(id);

        if (cliente.isPresent()) {
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @Transactional
    public  ResponseEntity postCliente(@RequestBody @Validated RequestCliente data) {
        Clientes newClientes = new Clientes(data);
        var createCliente = clientesRepository.save(newClientes);

        var idClient = createCliente.getId();

        Carrinho newCarrinho = new Carrinho();
        var createCarrinho = carrinhoRepository.save(newCarrinho);

        var idCarrinho = createCarrinho.getId();

        Optional<Clientes> getClient = clientesRepository.findById(String.valueOf(idClient));

        if (getClient.isPresent()) {
            Clientes setCliente = getClient.get();
            setCliente.setCarrinho_id(idCarrinho);
        };

        return ResponseEntity.ok(createCliente);

    }

    @PutMapping
    @Transactional
    public ResponseEntity updateCliente(@RequestBody @Validated RequestCliente data) {
        Optional<Clientes> cliente = clientesRepository.findById(String.valueOf(data.id()));
        if (cliente.isPresent()) {
            Clientes setCliente = cliente.get();
            setCliente.setNome(data.nome());
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCliente(@PathVariable String id){
        clientesRepository.deleteById(id);
        return   ResponseEntity.noContent().build();
    }

}
