package com.football.services;
import com.football.entites.Competition;
import com.football.repository.CompetitionRepository;
import jakarta.persistence.Id;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
@Transactional
@Service
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class CompetitionServiceImplementation implements CompetitionService{
    @Autowired
    @Order(1)
    CompetitionRepository competitionRepository;

    @Override
    public Competition saveCompetition(Competition competition) {
        return competitionRepository.save(competition);
    }

    @Override
    public Competition getCompetition(String Id_Competition) {
        Competition competition = competitionRepository.getById(Id_Competition);
        if(competition==null)
        {
            System.out.println("competition n'existe pas ");
            return null;
        }
        else {
            return competition;
        }
    }

    @Override
    public List<Competition> getListCompetitions() {
        return competitionRepository.findAll();
    }

    @Override
    public void deleteCompetition(String Id_Competition) {
        competitionRepository.deleteById(Id_Competition);
    }
}
