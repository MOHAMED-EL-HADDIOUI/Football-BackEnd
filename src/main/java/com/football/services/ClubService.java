package com.football.services;

import com.football.dtos.ClubsDTO;
import com.football.entites.Club;
import com.football.exceptions.ClubNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClubService {
    Club saveClub(Club club);
    Club getClub(Long Id_Club);
    void deleteClub(Long Id_Club);
    List<Club> getListClubs();
    ClubsDTO searchByName(String name, int page) throws ClubNotFoundException;
}
