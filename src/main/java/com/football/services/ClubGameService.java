package com.football.services;

import com.football.entites.Club;
import com.football.entites.ClubGame;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClubGameService {
    ClubGame saveClubGame(ClubGame clubGame);
    ClubGame getClubGame(Long Id_ClubGame);
    void deleteClubGame(Long Id_ClubGame);
    List<ClubGame> getListClubGames();
}
