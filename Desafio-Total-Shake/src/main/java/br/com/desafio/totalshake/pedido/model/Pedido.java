package br.com.desafio.totalshake.pedido.model;

import br.com.desafio.totalshake.pedido.enuns.Status;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "pedido")
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private LocalDateTime dataHora = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(mappedBy = "pedido", fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private List<ItemPedido> itensPedidosList = new ArrayList<>();

}
