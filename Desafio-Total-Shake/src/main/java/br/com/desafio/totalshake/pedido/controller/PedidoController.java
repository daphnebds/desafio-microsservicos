package br.com.desafio.totalshake.pedido.controller;

import br.com.desafio.totalshake.pedido.dto.PedidoDto;
import br.com.desafio.totalshake.pedido.exception.NaoEncontradoException;
import br.com.desafio.totalshake.pedido.exception.ParametroInvalidoException;
import br.com.desafio.totalshake.pedido.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.net.URI;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    PedidoService service;

    @PostMapping()
    public ResponseEntity<PedidoDto> postPedido(
            @RequestBody PedidoDto pedido, UriComponentsBuilder uriBuilder) throws Exception {

        try{
            service.salvarPedido(pedido);

            URI uri = uriBuilder.path("/pedido/{id}").buildAndExpand(pedido.getId()).toUri();

            return ResponseEntity.created(uri).body(pedido);

        } catch (ParametroInvalidoException e){

            return ResponseEntity.badRequest().build();
        }

    }

    @PutMapping("/{idPedido}")
    public ResponseEntity putPedido(
            @PathVariable @NotNull Long idPedido, @RequestBody @Valid PedidoDto pedido) {

        service.atualizarPedido(idPedido, pedido);

        return ResponseEntity.ok().build();

    }

    @GetMapping
    public ResponseEntity<Page<PedidoDto>> findAllPedidos(@PageableDefault(size = 10) Pageable pageable) {

        try {
            Page<PedidoDto> pedidos = service.getAllPedidos(pageable);
            return ResponseEntity.ok(pedidos);

        } catch (NaoEncontradoException e) {

            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping("/{idPedido}")
    public ResponseEntity<PedidoDto> findPedidoById(@PathVariable Long idPedido){
        PedidoDto pedido;

        try {
            pedido = service.getPedidoById(idPedido);
            return ResponseEntity.ok(pedido);
        } catch (NaoEncontradoException e) {

            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping("/porta")
    public String informaPorta(@Value("${local.server.port}") String porta){
        return String.format("Resquisição executada na porta %s", porta);
    }

    @DeleteMapping("/{idPedido}")
    public ResponseEntity deletePedido(@PathVariable Long idPedido) {

        service.deletePedido(idPedido);

        return ResponseEntity.ok().build();
    }

}
