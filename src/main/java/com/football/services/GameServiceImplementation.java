package com.football.services;
import com.football.dtos.*;
import com.football.entites.Club;
import com.football.entites.Competition;
import com.football.entites.Game;
import com.football.entites.Player;
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
    @Order(1)
    CompetitionService competitionService;
    @Autowired
    @Order(1)
    ClubService clubService;
    @Autowired
    GameMapperImplementation dtoMapper;


    @Override
    public GameDTO saveGame(Game_DTO game_Dto) {
        Game game = dtoMapper.fromGame_DTO(game_Dto);
        if (game_Dto.getCompetition() != null && game_Dto.getAwayClub()!=null && game_Dto.getHomeClub()!=null) {

            Competition competition = competitionService.getCompetition(game_Dto.getCompetition());
            game.setCompetition(competition);

            Club homeClub = clubService.getClub(game_Dto.getAwayClub());
            Club awayClub = clubService.getClub(game_Dto.getAwayClub());
            game.setHomeClub(homeClub);
            game.setAwayClub(awayClub);
        }
        game.setGameId(null);
        Game game1 = gameRepository.save(game);
        return dtoMapper.fromGame(game1);
    }

    @Override
    public GameDTO updateGame(Game_DTO game_Dto) {
        Game game = dtoMapper.fromGame_DTO(game_Dto);
        if (game_Dto.getCompetition() != null && game_Dto.getAwayClub()!=null && game_Dto.getHomeClub()!=null) {

            Competition competition = competitionService.getCompetition(game_Dto.getCompetition());
            game.setCompetition(competition);

            Club homeClub = clubService.getClub(game_Dto.getAwayClub());
            Club awayClub = clubService.getClub(game_Dto.getAwayClub());
            game.setHomeClub(homeClub);
            game.setAwayClub(awayClub);
        }
        game.setGameId(null);
        Game game1 = gameRepository.save(game);
        return dtoMapper.fromGame(game1);
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
