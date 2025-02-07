package com.football.services;
import com.football.dtos.ClubDTO;
import com.football.dtos.Club_DTO;
import com.football.dtos.ClubsDTO;
import com.football.entites.Club;
import com.football.entites.Competition;
import com.football.exceptions.ClubNotFoundException;
import com.football.mappers.ClubMapperImplementation;
import com.football.repository.ClubRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class ClubServiceImplementation implements ClubService{
    @Autowired
    @Order(1)
    ClubRepository clubRepository;
    @Autowired
    @Order(1)
    CompetitionService competitionService;
    @Autowired
    ClubMapperImplementation dtoMapper;
    @Override
    public ClubDTO saveClub(Club_DTO club_DTO) {
        // Convertir le DTO en entité
        Club club = dtoMapper.fromClub_DTO(club_DTO);

        // Si une compétition domestique est précisée dans le DTO,
        // on récupère l'entité Competition correspondante.
        if (club_DTO.getDomesticCompetition() != null) {
            Competition competition = competitionService.getCompetition(club_DTO.getDomesticCompetition());
            club.setDomesticCompetition(competition);
        }

        // On s'assure que l'identifiant est nul pour permettre à la base de données
        // de le générer automatiquement.
        club.setClubId(null);

        // Sauvegarder l'entité Club dans la base de données.
        Club savedClub = clubRepository.save(club);

        // Convertir l'entité sauvegardée en DTO et la retourner.
        return dtoMapper.fromClub(savedClub);
    }


    @Override
    public ClubDTO updateClub(Club_DTO club_DTO) {
        Club club = dtoMapper.fromClub_DTO(club_DTO);
        if (club_DTO.getDomesticCompetition() != null) {
            Competition competition = competitionService.getCompetition(club_DTO.getDomesticCompetition());
            club.setDomesticCompetition(competition);
        }
        Club club1 = clubRepository.save(club);
        ClubDTO clubDTO1 = dtoMapper.fromClub(club1);
        return clubDTO1;
    }

    @Override
    public Club getClub(Long Id_Club) {
        return clubRepository.findById(Id_Club).orElse(null);
    }

    @Override
    public void deleteClub(Long Id_Club) {
        clubRepository.deleteById(Id_Club);
    }

    @Override
    public List<Club> getListClubs() {
        return clubRepository.findAll();
    }

    @Override
    public ClubsDTO searchByName(String name, int page) throws ClubNotFoundException {
        Page<Club> clubs ;
        clubs = clubRepository.searchByName(name, PageRequest.of(page,6));
        List<ClubDTO> clubDTOList=clubs.getContent().stream().map(c->dtoMapper.fromClub(c)).collect(Collectors.toList());
        if (clubs == null)
            throw new ClubNotFoundException("Club not fount");

        ClubsDTO clubsDTO= new ClubsDTO();
        clubsDTO.setClubsDTOS(clubDTOList);
        clubsDTO.setTotalpage(clubs.getTotalPages());
        return clubsDTO;
    }

    @Override
    public ClubsDTO getListClubByDomesticCompetition(String idCompetition, int page) throws ClubNotFoundException {
        Page<Club> clubs ;
        clubs = clubRepository.getListClubByDomesticCompetition(idCompetition, PageRequest.of(page,8));
        List<ClubDTO> clubDTOList=clubs.getContent().stream().map(c->dtoMapper.fromClub(c)).collect(Collectors.toList());
        if (clubs == null)
            throw new ClubNotFoundException("Club not fount");

        ClubsDTO clubsDTO= new ClubsDTO();
        clubsDTO.setClubsDTOS(clubDTOList);
        clubsDTO.setTotalpage(clubs.getTotalPages());
        return clubsDTO;
    }
}
