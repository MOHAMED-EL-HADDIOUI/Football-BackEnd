package com.football.services;
import com.football.dtos.GameEventDTO;
import com.football.dtos.GameEventsDTO;
import com.football.entites.GameEvent;
import com.football.exceptions.GameEventNotFoundException;
import com.football.mappers.GameEventMapperImplementation;
import com.football.repository.GameEventRepository;
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
public class GameEventServiceImplementation implements GameEventService{
    @Autowired
    @Order(1)
    GameEventRepository eventRepository;
    @Autowired
    GameEventMapperImplementation dtoMapper;
    @Override
    public GameEvent saveGameEvent(GameEvent gameEvent) {
        return eventRepository.save(gameEvent);
    }

    @Override
    public GameEvent getGameEvent(String Id_GameEvent) {
        return eventRepository.findById(Id_GameEvent).orElse(null);
    }

    @Override
    public void deleteGameEvent(String Id_GameEvent) {
        eventRepository.deleteById(Id_GameEvent);
    }

    @Override
    public List<GameEvent> getListGameEvents() {
        return eventRepository.findAll();
    }

    @Override
    public GameEventsDTO getListGameEventsByGame(Long gameId, int page) throws GameEventNotFoundException {
        Page<GameEvent> gameEvents ;
        gameEvents = eventRepository.getListGameEventsByGame(gameId, PageRequest.of(page,8));
        List<GameEventDTO> gameEventDTOS =gameEvents.getContent().stream().map(c->dtoMapper.fromGameEvent(c)).collect(Collectors.toList());
        if (gameEvents == null)
            throw new GameEventNotFoundException("GameEvent not fount");

        GameEventsDTO appearancesDTO= new GameEventsDTO();
        appearancesDTO.setGameEventDTOS(gameEventDTOS);
        appearancesDTO.setTotalpage(gameEvents.getTotalPages());
        return appearancesDTO;
    }

}
