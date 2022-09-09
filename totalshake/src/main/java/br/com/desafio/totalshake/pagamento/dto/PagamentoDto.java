package br.com.desafio.totalshake.pagamento.dto;

import br.com.desafio.totalshake.pagamento.enuns.FormaDePagamento;
import br.com.desafio.totalshake.pagamento.enuns.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class PagamentoDto implements Serializable {

    @JsonIgnore
    private Long id;

    @NotNull
    @Positive
    private BigDecimal valor;

    @NotBlank
    @Size(max = 100)
    private String nome;

    @NotBlank
    @Size(max = 100)
    private String numero;

    @NotBlank
    private String expiracao;

    @NotBlank
    @Size(min = 3, max = 3)
    private  String codigo;

    @NotBlank
    @Enumerated(EnumType.STRING)
    private Status status;

    @NotNull
    private Long idPedido;

    @NotBlank
    @Enumerated(EnumType.STRING)
    private FormaDePagamento formaDePagamento;

}
