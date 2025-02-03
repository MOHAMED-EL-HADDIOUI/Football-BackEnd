package com.football.services;
import com.football.dtos.PlayerDTO;
import com.football.dtos.PlayersDTO;
import com.football.dtos.TransferDTO;
import com.football.dtos.TransfersDTO;
import com.football.entites.Player;
import com.football.entites.Transfer;
import com.football.exceptions.PlayerNotFoundException;
import com.football.exceptions.TransferNotFoundException;
import com.football.mappers.TransferMapperImplementation;
import com.football.repository.TransferRepository;
import jakarta.persistence.Id;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
@Transactional
@Service
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class TransferServiceImplementation implements TransferService{
    @Autowired
    @Order(1)
    TransferRepository transferRepository;
    @Autowired
    TransferMapperImplementation dtoMapper;
    @Override
    public Transfer saveTransfer(Transfer transfer) {
        return transferRepository.save(transfer);
    }

    @Override
    public Transfer getTransfer(Long Id_Transfer) {
        return transferRepository.findById(Id_Transfer).orElse(null);
    }

    @Override
    public void deleteTransfer(Long Id_Transfer) {
        transferRepository.deleteById(Id_Transfer);
    }

    @Override
    public List<Transfer> getListTransfers() {
        return transferRepository.findAll();
    }

    @Override
    public TransfersDTO searchByName(String name, int page) throws TransferNotFoundException {
        Page<Transfer> transfers ;
        transfers = transferRepository.searchByPlayerName(name, PageRequest.of(page,20));
        List<TransferDTO>  transferDTOS = transfers.getContent().stream().map(c->dtoMapper.fromTransfer(c)).collect(Collectors.toList());
        if (transfers == null)
            throw new TransferNotFoundException("Transfer not fount");

        TransfersDTO transfersDTO= new TransfersDTO();
        transfersDTO.setTransferDTOS(transferDTOS);
        transfersDTO.setTotalpage(transfers.getTotalPages());
        return transfersDTO;
    }

    @Override
    public TransfersDTO searchByPlayer(Long playerId, int page) throws TransferNotFoundException {
        Page<Transfer> transfers ;
        transfers = transferRepository.searchByPlayer(playerId, PageRequest.of(page,4));
        List<TransferDTO>  transferDTOS = transfers.getContent().stream().map(c->dtoMapper.fromTransfer(c)).collect(Collectors.toList());
        if (transfers == null)
            throw new TransferNotFoundException("Transfer not fount");

        TransfersDTO transfersDTO= new TransfersDTO();
        transfersDTO.setTransferDTOS(transferDTOS);
        transfersDTO.setTotalpage(transfers.getTotalPages());
        return transfersDTO;
    }
}
