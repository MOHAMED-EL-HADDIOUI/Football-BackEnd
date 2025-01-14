package com.football.services;

import com.football.entites.Appearance;
import com.football.entites.Competition;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CompetitionService {
    Competition saveCompetition(Competition competition);
    Competition getCompetition(String Id_Competition);
    List<Competition> getListCompetitions();
    void deleteCompetition (String Id_Competition);
}
