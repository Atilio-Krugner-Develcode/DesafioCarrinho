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
    public ResponseEntity getCarrinhobyId(@PathVariable String id) {
        Optional<Clientes> cliente = clientesRepository.findById(id);

        Clientes getCliente = cliente.get();

        Integer carrinhoId = getCliente.getCarrinho_id();

        Optional<Carrinho> carrinho = carrinhoRepository.findById(String.valueOf(carrinhoId));


        return ResponseEntity.ok(carrinho);


    }

    @PostMapping
    @Transactional
    public ResponseEntity postCarrinho(@RequestBody @Validated RequestCarrinho_Itens data) {
        Optional<Clientes> cliente = clientesRepository.findById(String.valueOf(data.cliente_id()));

        Clientes getCliente = cliente.get();

        Integer carrinhoId = getCliente.getCarrinho_id();

        Optional<Carrinho> carrinho = carrinhoRepository.findById(String.valueOf(carrinhoId));
        Carrinho getCarrinho = carrinho.get();

        Optional<CarrinhoItems> selectExistsItem = carrinho_itemsRepository.getByProductInCarrinhoItems(data.produto_id(), carrinhoId);

        if (selectExistsItem.isPresent()) {
            CarrinhoItems getItem = selectExistsItem.get();
            getItem.setCarrinho_id(carrinhoId);
            getItem.setProduto_id(data.produto_id());
            getItem.setQuantidade(getItem.getQuantidade() + data.quantidade());

            carrinho_itemsRepository.save(getItem);
        } else {
            CarrinhoItems newCarrinhoItems = new CarrinhoItems();
            newCarrinhoItems.setCarrinho_id(carrinhoId);
            newCarrinhoItems.setProduto_id(data.produto_id());
            newCarrinhoItems.setQuantidade(data.quantidade());

            carrinho_itemsRepository.save(newCarrinhoItems);
        };

        Optional<Produtos> produto = produtosrepository.findById(String.valueOf(data.produto_id()));

        Produtos getProduto = produto.get();

        float soma = ((getProduto.getPreco() * data.quantidade()) + getCarrinho.getValor_total());

        getCarrinho.setValor_total(soma);

        return ResponseEntity.ok(carrinho);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCarrinho(@PathVariable String id) {
//        carrinho_itemsRepository.getByCarrinhoDeleteItens(Integer.valueOf(id));
        return ResponseEntity.ok("");
    }

    @GetMapping("/{id}/valorTotal")
    public ResponseEntity<Double> getValorTotalCarrinho(@PathVariable int id) {
        Optional<Carrinho> carrinho = carrinhoRepository.findById(String.valueOf(id));

        if (carrinho.isPresent()) {
            return ResponseEntity.ok((double) carrinho.get().getValor_total());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}