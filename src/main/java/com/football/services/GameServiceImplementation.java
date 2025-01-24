package com.football.services;
import com.football.dtos.ClubDTO;
import com.football.dtos.ClubsDTO;
import com.football.dtos.GameDTO;
import com.football.dtos.GamesDTO;
import com.football.entites.Club;
import com.football.entites.Game;
import com.football.exceptions.ClubNotFoundException;
import com.football.exceptions.GameNotFoundException;
import com.football.mappers.ClubMapperImplementation;
import com.football.mappers.GameMapperImplementation;
import com.football.repository.GameRepository;
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
public class GameServiceImplementation implements GameService{
    @Autowired
    @Order(1)
    GameRepository gameRepository;
    @Autowired
    GameMapperImplementation dtoMapper;

    @Override
    public Game saveGame(Game game) {
        return gameRepository.save(game);
    }

    @Override
    public Game getGame(Long Id_Game) {
        return gameRepository.findById(Id_Game).orElse(null);
    }

    @Override
    public void deleteGame(Long Id_Game) {
        gameRepository.deleteById(Id_Game);

    }

    @Override
    public List<Game> getListGames() {
        return gameRepository.findAll();
    }

    @Override
    public GamesDTO searchByHomeClubNameOrAwayClubName(String name, int page) throws GameNotFoundException {
        Page<Game> games ;
        games = gameRepository.searchByHomeClubNameOrAwayClubName(name, PageRequest.of(page,5));
        List<GameDTO> gameDTOS=games.getContent().stream().map(c->dtoMapper.fromGame(c)).collect(Collectors.toList());
        if (games == null)
            throw new GameNotFoundException("Game not fount");

        GamesDTO gamesDTO= new GamesDTO();
        gamesDTO.setGameDTOS(gameDTOS);
        gamesDTO.setTotalpage(games.getTotalPages());
        return gamesDTO;
    }

    @Override
    public GamesDTO searchByAwayClubManagerNameOrHomeClubManagerName(String name, int page) throws GameNotFoundException {
        Page<Game> games ;
        games = gameRepository.searchByAwayClubManagerNameOrHomeClubManagerName(name, PageRequest.of(page,5));
        List<GameDTO> gameDTOS=games.getContent().stream().map(c->dtoMapper.fromGame(c)).collect(Collectors.toList());
        if (games == null)
            throw new GameNotFoundException("Game not fount");

        GamesDTO gamesDTO= new GamesDTO();
        gamesDTO.setGameDTOS(gameDTOS);
        gamesDTO.setTotalpage(games.getTotalPages());
        return gamesDTO;
    }

    @Override
    public GamesDTO searchByStadium(String name, int page) throws GameNotFoundException {
        Page<Game> games ;
        games = gameRepository.searchByStadium(name, PageRequest.of(page,5));
        List<GameDTO> gameDTOS=games.getContent().stream().map(c->dtoMapper.fromGame(c)).collect(Collectors.toList());
        if (games == null)
            throw new GameNotFoundException("Game not fount");

        GamesDTO gamesDTO= new GamesDTO();
        gamesDTO.setGameDTOS(gameDTOS);
        gamesDTO.setTotalpage(games.getTotalPages());
        return gamesDTO;
    }

    @Override
    public GamesDTO searchByCompetition(String name, int page) throws GameNotFoundException {
        Page<Game> games ;
        games = gameRepository.searchByCompetition(name, PageRequest.of(page,5));
        List<GameDTO> gameDTOS=games.getContent().stream().map(c->dtoMapper.fromGame(c)).collect(Collectors.toList());
        if (games == null)
            throw new GameNotFoundException("Game not fount");

        GamesDTO gamesDTO= new GamesDTO();
        gamesDTO.setGameDTOS(gameDTOS);
        gamesDTO.setTotalpage(games.getTotalPages());
        return gamesDTO;
    }
}
