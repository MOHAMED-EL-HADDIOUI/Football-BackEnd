package com.football.services;
import com.football.entites.Transfer;
import com.football.repository.TransferRepository;
import jakarta.persistence.Id;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
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
    @Override
    public Transfer saveTransfer(Transfer transfer) {
        return transferRepository.save(transfer);
    }

    @Override
    public Transfer getTransfer(Long Id_Transfer) {
        return transferRepository.getById(Id_Transfer);
    }

    @Override
    public void deleteTransfer(Long Id_Transfer) {
        transferRepository.deleteById(Id_Transfer);
    }

    @Override
    public List<Transfer> getListTransfers() {
        return transferRepository.findAll();
    }
}
