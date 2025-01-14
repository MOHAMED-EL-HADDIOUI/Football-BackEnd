package com.football.services;
import com.football.entites.Club;
import com.football.entites.ClubGame;
import com.football.repository.ClubGameRepository;
import com.football.repository.ClubRepository;
import jakarta.persistence.Id;
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
public class ClubGameServiceImplementation implements ClubGameService{
    @Autowired
    @Order(1)
    ClubGameRepository clubGameRepository;

    @Override
    public ClubGame saveClubGame(ClubGame clubGame) {
        return clubGameRepository.save(clubGame);
    }

    @Override
    public ClubGame getClubGame(Long Id_ClubGame) {
        return clubGameRepository.getById(Id_ClubGame);
    }

    @Override
    public void deleteClubGame(Long Id_Id_ClubGame) {
        clubGameRepository.deleteById(Id_Id_ClubGame);
    }
    @Override
    public List<ClubGame> getListClubGames() {
        return clubGameRepository.findAll();
    }
}
