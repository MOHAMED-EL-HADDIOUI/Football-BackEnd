package com.football.mappers;

import com.football.dtos.CompetitionDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.football.entites.Competition;

@Service
public class CompetitionMapperImplementation {
    public CompetitionDTO fromCompetition(Competition competition){
        CompetitionDTO competitionDTO = new CompetitionDTO();
        BeanUtils.copyProperties(competition,competitionDTO);
        return competitionDTO;
    }
    public Competition fromCompetitionDTO(CompetitionDTO competitionDTO){
        Competition competition = new Competition();
        BeanUtils.copyProperties(competitionDTO,competition);
        return competition;
    }
    public void updateCompetitionFromDTO(CompetitionDTO competitionDTO, Competition competition) {
        Competition competition1 = fromCompetitionDTO(competitionDTO);
        BeanUtils.copyProperties(competition1, competition,"competitionId");
    }
}
