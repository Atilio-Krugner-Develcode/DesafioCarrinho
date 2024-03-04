package br.com.DevelDesafio.desafio.Controller;

public record RequestProduto(

        String id,
        String nome,
        float preco,
        int quantidade
) {

}
