package com.football.services;
import com.football.entites.Club;
import com.football.repository.ClubRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class ClubServiceImplementation implements ClubService{
    @Autowired
    @Order(1)
    ClubRepository clubRepository;

    @Override
    public Club saveClub(Club club) {
        return clubRepository.save(club);
    }

    @Override
    public Club getClub(Long Id_Club) {
        return clubRepository.getById(Id_Club);
    }

    @Override
    public void deleteClub(Long Id_Club) {
        clubRepository.deleteById(Id_Club);
    }

    @Override
    public List<Club> getListClubs() {
        return clubRepository.findAll();
    }
}
