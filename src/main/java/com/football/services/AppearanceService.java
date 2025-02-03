package com.football.services;

import com.football.dtos.AppearancesDTO;
import com.football.dtos.ClubsDTO;
import com.football.entites.Appearance;
import com.football.exceptions.AppearanceNotFoundException;
import com.football.exceptions.ClubNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface AppearanceService {
    Appearance saveAppearance(Appearance appearance);
    Appearance getAppearance(String Id_Appearance);
    List<Appearance> getListAppearances();
    void deleteAppearance (String Id_Appearance);
    AppearancesDTO getListAppearancesByPlayer(Long playerId, int page) throws AppearanceNotFoundException;
}
