package br.com.DevelDesafio.desafio.Controller;

import br.com.DevelDesafio.desafio.Class.Carrinho;
import br.com.DevelDesafio.desafio.Class.CarrinhoItems;
import br.com.DevelDesafio.desafio.Class.Clientes;
import br.com.DevelDesafio.desafio.Class.Produtos;
import br.com.DevelDesafio.desafio.ProdutosRepository.CarrinhoRepository;
import br.com.DevelDesafio.desafio.ProdutosRepository.Carrinho_itemsRepository;
import br.com.DevelDesafio.desafio.ProdutosRepository.ClientesRepository;
import br.com.DevelDesafio.desafio.ProdutosRepository.Produtosrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Service
@Transactional
@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {
    @Autowired
    private CarrinhoRepository carrinhoRepository;
    @Autowired
    private Produtosrepository produtosrepository;
    @Autowired
    private Carrinho_itemsRepository carrinho_itemsRepository;
    @Autowired
    private ClientesRepository clientesRepository;

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

//        Carrinho newCarrinho = new Carrinho(data);
//        var createCarrinho = carrinhoRepository.save(newCarrinho);
//
//        var idCarrinho = createCarrinho.getId();

        CarrinhoItems newCarrinhoItems = new CarrinhoItems(data);
        newCarrinhoItems.setCarrinho_id(data.carrinho_id());
        newCarrinhoItems.setProduto_id(data.produto_id() );


        newCarrinhoItems.setQuantidade(data.quantidade());

        carrinho_itemsRepository.save(newCarrinhoItems);

        return ResponseEntity.ok(newCarrinhoItems);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCarrinho(@PathVariable String id){
        carrinhoRepository.deleteById(id);
        return   ResponseEntity.noContent().build();
    }

    

//    public void salvarCarrinhoComItems(Carrinho carrinho, List<CarrinhoItems> itens) {
//        carrinhoRepository.save(carrinho);
//
//        var id = carrinho.getId();
//
//
////        for (CarrinhoItems item : itens) {
////            item.setCarrinho(carrinho);
////            carrinho_itemsRepository.save(item);
////        }
//    }



}
