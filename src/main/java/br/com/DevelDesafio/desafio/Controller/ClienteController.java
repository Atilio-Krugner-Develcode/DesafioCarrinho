package br.com.DevelDesafio.desafio.Controller;

import br.com.DevelDesafio.desafio.Class.Clientes;
import br.com.DevelDesafio.desafio.Class.Produtos;
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
    public  ResponseEntity postCliente(@RequestBody @Validated RequestCliente data) {
        Clientes newClientes = new Clientes(data);
        clientesRepository.save(newClientes);
        return ResponseEntity.ok().build();

    }

    @PutMapping
    @Transactional
    public ResponseEntity updateCliente(@RequestBody @Validated RequestCliente data) {
        Optional<Clientes> cliente = clientesRepository.findById(data.id());
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
