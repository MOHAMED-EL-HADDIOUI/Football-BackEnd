package com.football.services;

import com.football.dtos.ClubsDTO;
import com.football.dtos.CompetitionDTO;
import com.football.dtos.CompetitionsDTO;
import com.football.entites.Appearance;
import com.football.entites.Competition;
import com.football.exceptions.ClubNotFoundException;
import com.football.exceptions.CompetitionNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CompetitionService {
    CompetitionDTO saveCompetition(CompetitionDTO competition);
    CompetitionDTO updateCompetition(CompetitionDTO competition);

    Competition getCompetition(String Id_Competition);
    List<Competition> getListCompetitions();
    void deleteCompetition (String Id_Competition);
    CompetitionsDTO searchByName(String name, int page) throws CompetitionNotFoundException;

}
