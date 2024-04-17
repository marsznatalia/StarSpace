package com.uep.wap.service;

import com.uep.wap.dto.StudentDTO;
import com.uep.wap.dto.ThemeDTO;
import com.uep.wap.model.Theme;
import com.uep.wap.repository.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThemeService {

    @Autowired
    private ThemeRepository themeRepository;

    public void addColor(ThemeDTO themeDTO) {
        Theme theme = new Theme();
        theme.setColor(themeDTO.getColor());
        themeRepository.save(theme);
        System.out.println("Theme set up!");
    }

    public Iterable<Theme> getAllThemes() {
        return themeRepository.findAll();
    }

}
