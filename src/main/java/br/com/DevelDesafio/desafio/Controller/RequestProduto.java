package br.com.DevelDesafio.desafio.Controller;

public record RequestProduto(

        Integer id,
        String nome,
        float preco,
        int quantidade
) {

}
