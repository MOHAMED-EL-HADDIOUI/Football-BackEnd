package com.football.services;

import com.football.dtos.GamesDTO;
import com.football.dtos.PlayerDTO;
import com.football.dtos.TransfersDTO;
import com.football.entites.Transfer;
import com.football.exceptions.GameNotFoundException;
import com.football.exceptions.PlayerNotFoundException;
import com.football.exceptions.TransferNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TransferService {
    Transfer saveTransfer(Transfer transfer);
    Transfer getTransfer(Long Id_Transfer);
    void deleteTransfer(Long Id_Transfer);
    List<Transfer> getListTransfers();
    TransfersDTO searchByName(String name, int page) throws TransferNotFoundException;


}
