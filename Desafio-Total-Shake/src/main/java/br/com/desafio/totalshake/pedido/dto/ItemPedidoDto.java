package br.com.desafio.totalshake.pedido.dto;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class ItemPedidoDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    private Integer quantidade;

    @NotEmpty
    private String descricao;

    @Valid
    private PedidoDto pedido;

}
