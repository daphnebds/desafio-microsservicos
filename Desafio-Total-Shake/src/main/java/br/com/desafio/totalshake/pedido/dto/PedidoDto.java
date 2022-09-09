package br.com.desafio.totalshake.pedido.dto;

import br.com.desafio.totalshake.pedido.enuns.Status;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class PedidoDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @NotEmpty(message = "O campo status não pode ser vazio")
    private Status status;

    @NotEmpty(message = "O campo itensPedidosList não pode ser vazio.")
    private List<ItemPedidoDto> itensPedidosList;

}
