package com.football.services;

import com.football.entites.Club;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClubService {
    Club saveClub(Club club);
    Club getClub(Long Id_Club);
    void deleteClub(Long Id_Club);
    List<Club> getListClubs();
}
