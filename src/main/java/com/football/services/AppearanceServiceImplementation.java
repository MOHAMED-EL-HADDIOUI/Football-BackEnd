package com.football.services;

import com.football.dtos.AppearanceDTO;
import com.football.dtos.AppearancesDTO;
import com.football.dtos.ClubDTO;
import com.football.dtos.ClubsDTO;
import com.football.entites.Appearance;
import com.football.entites.Club;
import com.football.exceptions.AppearanceNotFoundException;
import com.football.exceptions.ClubNotFoundException;
import com.football.mappers.AppearanceMapperImplementation;
import com.football.repository.AppearanceRepository;
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
public class AppearanceServiceImplementation implements AppearanceService{
    @Autowired
    @Order(1)
    AppearanceRepository appearanceRepository;
    @Autowired
    AppearanceMapperImplementation dtoMapper;
    @Override
    public Appearance saveAppearance(Appearance appearance) {
        return appearanceRepository.save(appearance);
    }
    @Override
    public Appearance getAppearance(String Id_Appearance) {
        Appearance appearance = appearanceRepository.getById(Id_Appearance);
        return appearance;
    }

    @Override
    public List<Appearance> getListAppearances() {
        List<Appearance> appearances = appearanceRepository.findAll();
        return appearances;
    }

    @Override
    public void deleteAppearance(String Id_Appearance) {
        appearanceRepository.deleteById(Id_Appearance);
    }

    @Override
    public AppearancesDTO getListAppearancesByPlayer(Long playerId, int page) throws AppearanceNotFoundException {
        Page<Appearance> appearances ;
        appearances = appearanceRepository.getListAppearancesByPlayer(playerId, PageRequest.of(page,8));
        List<AppearanceDTO> appearanceDTOList=appearances.getContent().stream().map(c->dtoMapper.fromAppearance(c)).collect(Collectors.toList());
        if (appearances == null)
            throw new AppearanceNotFoundException("Appearance not fount");

        AppearancesDTO appearancesDTO= new AppearancesDTO();
        appearancesDTO.setAppearanceDTOS(appearanceDTOList);
        appearancesDTO.setTotalpage(appearances.getTotalPages());
        return appearancesDTO;
    }
}
