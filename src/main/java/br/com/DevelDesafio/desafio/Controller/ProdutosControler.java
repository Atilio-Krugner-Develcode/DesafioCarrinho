package br.com.DevelDesafio.desafio.Controller;

import br.com.DevelDesafio.desafio.Class.Produtos;
import br.com.DevelDesafio.desafio.ProdutosRepository.Produtosrepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/produtos")

public class ProdutosControler {
    @Autowired
    private Produtosrepository produtosrepository;

    @GetMapping
    public ResponseEntity getAllProducts(){

        var allProducts = produtosrepository.findAll();

        return ResponseEntity.ok(allProducts);
    }

    @GetMapping("/{id}")
    public ResponseEntity getProductById(@PathVariable String id){

        Optional<Produtos> product = produtosrepository.findById(id);

        if (product.isPresent()) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

@PostMapping
    public  ResponseEntity postProduto(@RequestBody @Validated RequestProduto data){
    Produtos  newProdutos = new Produtos(data);
    produtosrepository.save(newProdutos);
    return ResponseEntity.ok().build();
}

@PutMapping
@Transactional
    public ResponseEntity updateProduto(@RequestBody @Validated RequestProduto data) {
    Optional<Produtos> optionalProdutos = produtosrepository.findById(String.valueOf(data.id()));
    if (optionalProdutos.isPresent()) {
        Produtos produtos = optionalProdutos.get();
        produtos.setNome(data.nome());
        produtos.setPreco(data.preco());
        produtos.setQuantidade(data.quantidade());
        return ResponseEntity.ok(produtos);
    } else {
        return ResponseEntity.notFound().build();
    }
}

   @DeleteMapping("/{id}")
    public ResponseEntity deleteProdutos(@PathVariable String id){
        produtosrepository.deleteById(id);
        return   ResponseEntity.noContent().build();
   }
}
