package com.football.services;

import com.football.entites.Transfer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TransferService {
    Transfer saveTransfer(Transfer transfer);
    Transfer getTransfer(Long Id_Transfer);
    void deleteTransfer(Long Id_Transfer);
    List<Transfer> getListTransfers();

}
