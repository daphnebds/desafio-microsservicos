package br.com.desafio.totalshake.pagamento.model;

import br.com.desafio.totalshake.pagamento.enuns.FormaDePagamento;
import br.com.desafio.totalshake.pagamento.enuns.Status;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "pagamento")
public class Pagamento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private BigDecimal valor;

    private String nome;

    private String numero;

    private String expiracao;

    private  String codigo;

    @Enumerated(EnumType.STRING)
    private Status status;

    private Long idPedido;

    @Enumerated(EnumType.STRING)
    private FormaDePagamento formaDePagamento;

}


