package com.football.mappers;

import com.football.dtos.ClubDTO;
import com.football.entites.Club;
import org.springframework.beans.BeanUtils;
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
    public void updateClubFromDTO(ClubDTO clubDTO, Club club) {
        Club club1 = fromClubDTO(clubDTO);
        BeanUtils.copyProperties(club1, club,"clubId");
    }
}