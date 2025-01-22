package com.football.mappers;

import com.football.dtos.PlayerDTO;
import com.football.dtos.TransferDTO;
import com.football.entites.Player;
import com.football.entites.Transfer;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class TransferMapperImplementation{
        public TransferDTO fromTransfer(Transfer transfer){
            TransferDTO transferDTO = new TransferDTO();
            BeanUtils.copyProperties(transfer,transferDTO);
            return transferDTO;
        }
        public Transfer fromTransferDTO(TransferDTO transferDTO){
            Transfer transfer = new Transfer();
            BeanUtils.copyProperties(transferDTO,transfer);
            return transfer;
        }
        public void updateTransferFromDTO(TransferDTO transferDTO, Transfer transfer) {
            Transfer transfer1 = fromTransferDTO(transferDTO);
            BeanUtils.copyProperties(transfer1, transfer,"transferId");
        }
}