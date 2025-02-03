package com.football.mappers;

import com.football.dtos.ClubDTO;
import com.football.dtos.ClubGameDTO;
import com.football.entites.Club;
import com.football.entites.ClubGame;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class ClubGameMapperImplementation {
    public ClubGameDTO fromClubGame(ClubGame clubGame){
        ClubGameDTO clubGameDTO = new ClubGameDTO();
        BeanUtils.copyProperties(clubGame,clubGameDTO);
        return clubGameDTO;
    }
    public ClubGame fromClubGameDTO(ClubGameDTO clubGameDTO){
        ClubGame clubGame = new ClubGame();
        BeanUtils.copyProperties(clubGameDTO,clubGame);
        return clubGame;
    }
    public void updateClubGameFromDTO(ClubGameDTO clubGameDTO, ClubGame clubGame) {
        ClubGame clubGame1 = fromClubGameDTO(clubGameDTO);
        BeanUtils.copyProperties(clubGame1, clubGame,"clubGameId");
    }
}
