package com.football.services;
import com.football.dtos.ClubDTO;
import com.football.dtos.ClubsDTO;
import com.football.dtos.CompetitionDTO;
import com.football.dtos.CompetitionsDTO;
import com.football.entites.Club;
import com.football.entites.Competition;
import com.football.exceptions.ClubNotFoundException;
import com.football.exceptions.CompetitionNotFoundException;
import com.football.mappers.ClubMapperImplementation;
import com.football.mappers.CompetitionMapperImplementation;
import com.football.repository.CompetitionRepository;
import jakarta.persistence.Id;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

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
    @Autowired
    CompetitionMapperImplementation dtoMapper;

    @Override
    public Competition saveCompetition(Competition competition) {
        return competitionRepository.save(competition);
    }

    @Override
    public Competition getCompetition(String Id_Competition) {
        return competitionRepository.findById(Id_Competition).orElse(null);
    }

    @Override
    public List<Competition> getListCompetitions() {
        return competitionRepository.findAll();
    }

    @Override
    public void deleteCompetition(String Id_Competition) {
        competitionRepository.deleteById(Id_Competition);
    }

    @Override
    public CompetitionsDTO searchByName(String name, int page) throws CompetitionNotFoundException {
        Page<Competition> competitions ;
        competitions = competitionRepository.searchByName(name, PageRequest.of(page,20));
        List<CompetitionDTO> competitionDTOS=competitions.getContent().stream().map(c->dtoMapper.fromCompetition(c)).collect(Collectors.toList());
        if (competitions == null)
            throw new CompetitionNotFoundException("Club not fount");

        CompetitionsDTO competitionsDTO= new CompetitionsDTO();
        competitionsDTO.setCompetitionDTOS(competitionDTOS);
        competitionsDTO.setTotalpage(competitions.getTotalPages());
        return competitionsDTO;
    }
}
