package br.com.desafio.totalshake.pagamento.controller;

import br.com.desafio.totalshake.pagamento.dto.PagamentoDto;
import br.com.desafio.totalshake.pagamento.service.PagamentoService;
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
@RequestMapping("/pagamento")
public class PagamentoController {

    @Autowired
    PagamentoService service;

    @PostMapping()
    public ResponseEntity<PagamentoDto> postPagamento(
            @RequestBody @Valid PagamentoDto pagamento, UriComponentsBuilder uriBuilder) {

        PagamentoDto pagamentoDto = service.salvarPagamento(pagamento);

        URI uri = uriBuilder.path("/pagamento/{id}").buildAndExpand(pagamento.getId()).toUri();

        return ResponseEntity.created(uri).body(pagamentoDto);
    }

    @PutMapping("/{idPagamento}")
    public ResponseEntity<PagamentoDto> putPagamentoResponseEntity(
            @PathVariable @NotNull Long idPagamento, @RequestBody @Valid PagamentoDto pagamento){

       PagamentoDto dto = service.atualizarPagamento(idPagamento, pagamento);

        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{idPagamento}")
    public ResponseEntity<PagamentoDto> findPagamentoById(@PathVariable @NotNull Long idPagamento){
        PagamentoDto pagamento = service.findPagamentoById(idPagamento);

        return ResponseEntity.ok(pagamento);
    }

    @GetMapping()
    public ResponseEntity<Page<PagamentoDto>> findAllPagamentos(
            @PageableDefault(size = 10) Pageable pageable){

        Page<PagamentoDto> pagamento = service.findAllPagamentos(pageable);

        return ResponseEntity.ok(pagamento);

    }

    @GetMapping("/port")
    public String informaPorta(@Value("${local.server.port}") String port){
        return String.format("Requisição executada pela porta %s", port);
    }

    @DeleteMapping("/{idPagamento}")
    public ResponseEntity<PagamentoDto> deletePagamentoById(@PathVariable Long idPagamento){

        service.deletePagamentoById(idPagamento);

        return ResponseEntity.noContent().build();
    }

}
