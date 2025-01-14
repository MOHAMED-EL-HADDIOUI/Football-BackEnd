package com.football.services;

import com.football.entites.Appearance;
import com.football.repository.AppearanceRepository;
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
public class AppearanceServiceImplementation implements AppearanceService{
    @Autowired
    @Order(1)
    AppearanceRepository appearanceRepository;
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
}
