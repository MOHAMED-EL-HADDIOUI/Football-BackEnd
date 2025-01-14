package com.football.controllers;

import com.football.entites.Player;
import com.football.entites.Transfer;
import com.football.services.PlayerService;
import com.football.services.TransferService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
}
