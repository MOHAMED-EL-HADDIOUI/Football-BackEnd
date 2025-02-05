package com.football.services;
import com.football.dtos.ClubDTO;
import com.football.dtos.ClubsDTO;
import com.football.entites.Club;
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
    ClubMapperImplementation dtoMapper;
    @Override
    public ClubDTO saveClub(ClubDTO clubDTO) {
        Club club = dtoMapper.fromClubDTO(clubDTO);
        Club club1 = clubRepository.save(club);
        ClubDTO clubDTO1 = dtoMapper.fromClub(club1);
        return clubDTO1;
    }

    @Override
    public ClubDTO updateClub(ClubDTO clubDTO) {
        Club club = dtoMapper.fromClubDTO(clubDTO);
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
