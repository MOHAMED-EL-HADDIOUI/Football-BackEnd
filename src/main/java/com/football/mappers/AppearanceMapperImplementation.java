package com.football.mappers;

import com.football.dtos.AppearanceDTO;
import com.football.dtos.ClubGameDTO;
import com.football.entites.Appearance;
import com.football.entites.ClubGame;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class AppearanceMapperImplementation {
    public AppearanceDTO fromAppearance(Appearance appearance){
        AppearanceDTO appearanceDTO = new AppearanceDTO();
        BeanUtils.copyProperties(appearance,appearanceDTO);
        return appearanceDTO;
    }
    public Appearance fromAppearanceDTO(AppearanceDTO appearanceDTO){
        Appearance appearance = new Appearance();
        BeanUtils.copyProperties(appearanceDTO,appearance);
        return appearance;
    }
    public void updateAppearanceFromDTO(AppearanceDTO appearanceDTO, Appearance appearance) {
        Appearance appearance1 = fromAppearanceDTO(appearanceDTO);
        BeanUtils.copyProperties(appearance1, appearance,"appearanceId");
    }
}
