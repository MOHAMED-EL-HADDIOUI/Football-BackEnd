package com.football.services;
import com.football.dtos.*;
import com.football.entites.Club;
import com.football.entites.Competition;
import com.football.entites.Player;
import com.football.exceptions.ClubNotFoundException;
import com.football.exceptions.PlayerNotFoundException;
import com.football.mappers.PlayerMapperImplementation;
import com.football.repository.PlayerRepository;
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
public class PlayerServiceImplementation implements PlayerService{
    @Autowired
    @Order(1)
    PlayerRepository playerRepository;
    @Autowired
    PlayerMapperImplementation dtoMapper;
    @Autowired
    @Order(1)
    CompetitionService competitionService;

    @Autowired
    @Order(1)
    ClubService clubService;

    @Override
    public PlayerDTO savePlayer(Player_DTO player_dto) {
        Player player = dtoMapper.fromPlayer_DTO(player_dto);
        if (player_dto.getCompetition() != null && player_dto.getCurrentClub()!=null) {

            Competition competition = competitionService.getCompetition(player_dto.getCompetition());
            player.setCompetition(competition);

            Club club = clubService.getClub(player_dto.getCurrentClub());
            player.setCurrentClub(club);
        }
        player.setPlayerId(null);
        Player player1 = playerRepository.save(player);
        return dtoMapper.fromPlayer(player1);
    }

    @Override
    public PlayerDTO updatePlayer(Player_DTO player_dto) {
        Player player = dtoMapper.fromPlayer_DTO(player_dto);
        if (player_dto.getCompetition() != null && player_dto.getCurrentClub()!=null) {

            Competition competition = competitionService.getCompetition(player_dto.getCompetition());
            player.setCompetition(competition);

            Club club = clubService.getClub(player_dto.getCurrentClub());
            player.setCurrentClub(club);
        }
        player.setName(player.getFirstName()+" "+player.getLastName());
        Player player1 = playerRepository.save(player);
        return dtoMapper.fromPlayer(player1);
    }

    @Override
    public Player getPlayer(Long Id_Player) {
        return playerRepository.findById(Id_Player).orElse(null);
    }

    @Override
    public void deletePlayer(Long Id_Player) {
        playerRepository.deleteById(Id_Player);

    }

    @Override
    public List<Player> getListPlayers() {
        return playerRepository.findAll();
    }

    @Override
    public PlayersDTO searchByName(String name, int page) throws PlayerNotFoundException {
        Page<Player> players ;
        players = playerRepository.searchByName(name, PageRequest.of(page,6));
        List<PlayerDTO> playerDTOS=players.getContent().stream().map(c->dtoMapper.fromPlayer(c)).collect(Collectors.toList());
        if (players == null)
            throw new PlayerNotFoundException("Player not fount");

        PlayersDTO playersDTO= new PlayersDTO();
        playersDTO.setPlayerDTOS(playerDTOS);
        playersDTO.setTotalpage(players.getTotalPages());
        return playersDTO;
    }
    @Override
    public PlayersDTO searchByCompetition(String name, int page) throws PlayerNotFoundException {
        Page<Player> players ;
        players = playerRepository.searchByCompetition(name, PageRequest.of(page,6));
        List<PlayerDTO> playerDTOS=players.getContent().stream().map(c->dtoMapper.fromPlayer(c)).collect(Collectors.toList());
        if (players == null)
            throw new PlayerNotFoundException("Player not fount");

        PlayersDTO playersDTO= new PlayersDTO();
        playersDTO.setPlayerDTOS(playerDTOS);
        playersDTO.setTotalpage(players.getTotalPages());
        return playersDTO;
    }
    @Override
    public PlayersDTO searchByCurrentClub(String name, int page) throws PlayerNotFoundException {
        Page<Player> players ;
        players = playerRepository.searchByCurrentClub(name, PageRequest.of(page,6));
        List<PlayerDTO> playerDTOS=players.getContent().stream().map(c->dtoMapper.fromPlayer(c)).collect(Collectors.toList());
        if (players == null)
            throw new PlayerNotFoundException("Player not fount");

        PlayersDTO playersDTO= new PlayersDTO();
        playersDTO.setPlayerDTOS(playerDTOS);
        playersDTO.setTotalpage(players.getTotalPages());
        return playersDTO;
    }
    @Override
    public PlayersDTO searchByPosition(String name, int page) throws PlayerNotFoundException {
        Page<Player> players ;
        players = playerRepository.searchByPosition(name, PageRequest.of(page,6));
        List<PlayerDTO> playerDTOS=players.getContent().stream().map(c->dtoMapper.fromPlayer(c)).collect(Collectors.toList());
        if (players == null)
            throw new PlayerNotFoundException("Player not fount");

        PlayersDTO playersDTO= new PlayersDTO();
        playersDTO.setPlayerDTOS(playerDTOS);
        playersDTO.setTotalpage(players.getTotalPages());
        return playersDTO;
    }

    @Override
    public PlayersDTO getListPlayersByCurrentClub(Long Id_club, int page) throws PlayerNotFoundException {
        Page<Player> players ;
        players = playerRepository.getListPlayersByCurrentClub(Id_club, PageRequest.of(page,8));
        List<PlayerDTO> playerDTOS=players.getContent().stream().map(c->dtoMapper.fromPlayer(c)).collect(Collectors.toList());
        if (players == null)
            throw new PlayerNotFoundException("Player not fount");
        PlayersDTO playersDTO= new PlayersDTO();
        playersDTO.setPlayerDTOS(playerDTOS);
        playersDTO.setTotalpage(players.getTotalPages());
        return playersDTO;
    }
}
