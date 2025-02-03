package com.football.services;
import com.football.dtos.ClubGameDTO;
import com.football.dtos.ClubGamesDTO;
import com.football.entites.Club;
import com.football.entites.ClubGame;
import com.football.exceptions.ClubGameNotFoundException;
import com.football.mappers.ClubGameMapperImplementation;
import com.football.repository.ClubGameRepository;
import com.football.repository.ClubRepository;
import jakarta.persistence.Id;
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
public class ClubGameServiceImplementation implements ClubGameService{
    @Autowired
    @Order(1)
    ClubGameRepository clubGameRepository;
    @Autowired
    ClubGameMapperImplementation dtoMapper;
    @Override
    public ClubGame saveClubGame(ClubGame clubGame) {
        return clubGameRepository.save(clubGame);
    }

    @Override
    public ClubGame getClubGame(Long Id_ClubGame) {
        return clubGameRepository.findById(Id_ClubGame).orElse(null);
    }

    @Override
    public void deleteClubGame(Long Id_Id_ClubGame) {
        clubGameRepository.deleteById(Id_Id_ClubGame);
    }
    @Override
    public List<ClubGame> getListClubGames() {
        return clubGameRepository.findAll();
    }

    @Override
    public ClubGamesDTO getListClubGamesByGame(Long playerId, int page) throws ClubGameNotFoundException {
        Page<ClubGame> clubGames ;
        clubGames = clubGameRepository.getListClubGamesByGame(playerId, PageRequest.of(page,8));
        List<ClubGameDTO> clubGameDTOList=clubGames.getContent().stream().map(c->dtoMapper.fromClubGame(c)).collect(Collectors.toList());
        if (clubGames == null)
            throw new ClubGameNotFoundException("ClubGame not fount");

        ClubGamesDTO appearancesDTO= new ClubGamesDTO();
        appearancesDTO.setClubGameDTOS(clubGameDTOList);
        appearancesDTO.setTotalpage(clubGames.getTotalPages());
        return appearancesDTO;
    }
}
