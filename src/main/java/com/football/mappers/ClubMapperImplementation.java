package com.football.mappers;

import com.football.dtos.ClubDTO;
import com.football.dtos.Club_DTO;
import com.football.entites.Club;
import com.football.entites.Competition;
import com.football.services.ClubService;
import com.football.services.CompetitionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
public class ClubMapperImplementation {

    public ClubDTO fromClub(Club club){
        ClubDTO clubDTO = new ClubDTO();
        BeanUtils.copyProperties(club,clubDTO);
        return clubDTO;
    }
    public Club fromClubDTO(ClubDTO clubDTO){
        Club club = new Club();
        BeanUtils.copyProperties(clubDTO,club);
        return club;
    }
    public Club fromClub_DTO(Club_DTO club_DTO){
        Club club = new Club();
        BeanUtils.copyProperties(club_DTO, club, "domesticCompetition");
        return club;
    }
    public void updateClubFromDTO(ClubDTO clubDTO, Club club) {
        Club club1 = fromClubDTO(clubDTO);
        BeanUtils.copyProperties(club1, club,"clubId");
    }
}