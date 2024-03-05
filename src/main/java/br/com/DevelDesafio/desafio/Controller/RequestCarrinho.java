package br.com.DevelDesafio.desafio.Controller;

import org.antlr.v4.runtime.misc.NotNull;

public record RequestCarrinho(
        Integer id,
        float valor_total,

        Integer carrinho_id,

        @NotNull
        Integer produto_id,

        Integer quantidade

) {
}
