package com.football.controllers;

import com.football.dtos.PlayersDTO;
import com.football.dtos.TransfersDTO;
import com.football.entites.Player;
import com.football.entites.Transfer;
import com.football.exceptions.PlayerNotFoundException;
import com.football.exceptions.TransferNotFoundException;
import com.football.services.PlayerService;
import com.football.services.TransferService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransferController {
    private TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }
    @GetMapping("/api/transfers/{transfer_id}")
    public Transfer getTransfer(@PathVariable Long transfer_id){
        Transfer transfer = transferService.getTransfer(transfer_id);
        return transfer;
    }
    @GetMapping("/api/transfers/")
    public List<Transfer> getListTransfers(){
        return  transferService.getListTransfers();
    }
    @GetMapping("/api/transfers/search")
    public TransfersDTO getplayersByName(@RequestParam(name = "name", defaultValue = "") String keyword, @RequestParam(name = "page", defaultValue = "0") int page) throws TransferNotFoundException {
        TransfersDTO transfersDTO = transferService.searchByName("%" + keyword + "%", page);
        return transfersDTO;
    }
    @GetMapping("/api/transfers/player")
    public TransfersDTO searchByPlayer(@RequestParam(name = "playerId", defaultValue = "") Long playerId, @RequestParam(name = "page", defaultValue = "0") int page) throws TransferNotFoundException {
        TransfersDTO transfersDTO = transferService.searchByPlayer(playerId, page);
        return transfersDTO;
    }
}
