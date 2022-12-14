package br.com.desafio.totalshake.pedido.controller;

import br.com.desafio.totalshake.pedido.dto.ItemPedidoDto;
import br.com.desafio.totalshake.pedido.exception.NaoEncontradoException;
import br.com.desafio.totalshake.pedido.exception.ParametroInvalidoException;
import br.com.desafio.totalshake.pedido.model.ItemPedido;
import br.com.desafio.totalshake.pedido.service.ItemPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itempedido")
public class ItemPedidoController {

    @Autowired
    ItemPedidoService service;

    @PostMapping()
    public ResponseEntity<ItemPedido> postItemPedido(@RequestBody ItemPedidoDto itemPedidoDto) throws Exception {

        try{
            service.salvarItemPedido(itemPedidoDto);
            return ResponseEntity.ok().build();

        } catch (ParametroInvalidoException e){

            return ResponseEntity.badRequest().build();
        }

    }

    @PutMapping("/{idItemPedido}")
    public ResponseEntity putItemPedido(@PathVariable Long idItemPedido, @RequestBody ItemPedidoDto itemPedidoDto) {

        service.atualizarItemPedido(idItemPedido, itemPedidoDto);

        return ResponseEntity.ok().build();

    }

    @GetMapping
    public ResponseEntity<List<ItemPedidoDto>> findAllItensPedidos() {

        //implementar Pageable

        try {
            List<ItemPedidoDto> itensPedidos = service.findAllItensPedidos();
            return ResponseEntity.ok(itensPedidos);

        } catch (NaoEncontradoException e) {

            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping("/{idItemPedido}")
    public ResponseEntity<ItemPedidoDto> findItemPedidoById(@PathVariable Long idItemPedido){
        ItemPedidoDto itemPedido;

        try {
            itemPedido = service.findItemPedidoById(idItemPedido);
            return ResponseEntity.ok(itemPedido);
        } catch (NaoEncontradoException e) {

            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/delete/{idItemPedido}")
    public ResponseEntity deletePedido(@PathVariable Long idItemPedido) {

        service.deleteItemPedido(idItemPedido);

        return ResponseEntity.ok().build();
    }

}
