package com.football.services;

import com.football.dtos.AppearancesDTO;
import com.football.dtos.ClubGamesDTO;
import com.football.entites.Club;
import com.football.entites.ClubGame;
import com.football.exceptions.AppearanceNotFoundException;
import com.football.exceptions.ClubGameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClubGameService {
    ClubGame saveClubGame(ClubGame clubGame);
    ClubGame getClubGame(Long Id_ClubGame);
    void deleteClubGame(Long Id_ClubGame);
    List<ClubGame> getListClubGames();
    ClubGamesDTO getListClubGamesByGame(Long playerId, int page) throws ClubGameNotFoundException;

}
