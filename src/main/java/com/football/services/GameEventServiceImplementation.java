package com.football.services;
import com.football.entites.GameEvent;
import com.football.repository.GameEventRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class GameEventServiceImplementation implements GameEventService{
    @Autowired
    @Order(1)
    GameEventRepository eventRepository;
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
}
