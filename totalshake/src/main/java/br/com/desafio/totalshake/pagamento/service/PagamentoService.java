package br.com.desafio.totalshake.pagamento.service;

import br.com.desafio.totalshake.pagamento.dto.PagamentoDto;
import br.com.desafio.totalshake.pagamento.repository.PagamentoRepository;
import br.com.desafio.totalshake.pagamento.model.Pagamento;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
public class PagamentoService {

    @Autowired
    PagamentoRepository repository;

    private static final Logger LOGGER = LoggerFactory.getLogger(Service.class);

    ModelMapper modelMapper = new ModelMapper();

    @Transactional
    public PagamentoDto salvarPagamento(PagamentoDto pagamentoDto){

        LOGGER.info("Salvando pagamento.");

        Pagamento pagamento = modelMapper.map(pagamentoDto, Pagamento.class);

        repository.save(pagamento);

        LOGGER.info("Pagamento salvo com sucesso.");

        return modelMapper.map(pagamento, PagamentoDto.class);

    }

    @Transactional
    public PagamentoDto atualizarPagamento(Long idPagamento, PagamentoDto pagamentoDto){

        Pagamento pagamento = modelMapper.map(pagamentoDto, Pagamento.class);

        pagamento.setId(idPagamento);

        repository.save(pagamento);

        LOGGER.info("Pagamento atualizado com sucesso.");

        return modelMapper.map(pagamento, PagamentoDto.class);

    }

    public PagamentoDto findPagamentoById(Long idPagamento){

        LOGGER.info("Buscando pagamento por id");

        Pagamento pagamento = repository.findById(idPagamento)
                .orElseThrow(EntityNotFoundException::new);

        return modelMapper.map(pagamento, PagamentoDto.class);

    }

    public Page<PagamentoDto> findAllPagamentos(Pageable pageable){

        LOGGER.info("Buscando todos os pagamentos");

        return repository
                .findAll(pageable)
                .map(pagamentoModel -> modelMapper.map(pagamentoModel, PagamentoDto.class));

    }

    public void deletePagamentoById(Long idPagamento){

        LOGGER.info("Deletando pagamento por id");

        repository.deleteById(idPagamento);

        LOGGER.info("Pagamento de id {} deletado com sucesso", idPagamento);

    }

}
