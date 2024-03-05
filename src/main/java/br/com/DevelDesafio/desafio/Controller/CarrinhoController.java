package br.com.DevelDesafio.desafio.Controller;

import br.com.DevelDesafio.desafio.Class.Carrinho;
import br.com.DevelDesafio.desafio.Class.Clientes;
import br.com.DevelDesafio.desafio.ProdutosRepository.CarrinhoRepository;
import br.com.DevelDesafio.desafio.ProdutosRepository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {
    @Autowired
    private CarrinhoRepository carrinhoRepository;

    @GetMapping("/{id}")
    public ResponseEntity getCarrinhobyId(@PathVariable String id){

        Optional<Carrinho> carrinho = carrinhoRepository.findById(id);

        if (carrinho.isPresent()) {
            return ResponseEntity.ok(carrinho);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping
    public  ResponseEntity postCarrinho(@RequestBody @Validated RequestCarrinho data) {
        Carrinho newCarrinho = new Carrinho(data);
        carrinhoRepository.save(newCarrinho);
        return ResponseEntity.ok().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCarrinho(@PathVariable String id){
        carrinhoRepository.deleteById(id);
        return   ResponseEntity.noContent().build();
    }


}
