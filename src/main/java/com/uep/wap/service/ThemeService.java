package com.uep.wap.service;

import com.uep.wap.dto.ThemeDTO;
import com.uep.wap.exception.UserNotFoundException;
import com.uep.wap.model.Theme;
import com.uep.wap.model.User;
import com.uep.wap.repository.ThemeRepository;
import com.uep.wap.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ThemeService {

    @Autowired
    private ThemeRepository themeRepository;
    @Autowired
    private UserRepository userRepository;

    public void newTheme(ThemeDTO themeDTO) {
        Theme theme = new Theme();

        User user = userRepository.findById(themeDTO.getUserId())
                .orElseThrow(() -> new UserNotFoundException(themeDTO.getUserId()));

        theme.setUser(user);
        theme.setColor(themeDTO.getColor());
        themeRepository.save(theme);
        System.out.println("Theme set up!");
    }

    public Optional<Theme> findThemeById(Long themeId) {
        return themeRepository.findById(themeId);
    }

    public Iterable<Theme> getAllThemes() {
        return themeRepository.findAll();
    }

    public void editTheme(Long themeId, ThemeDTO themeDTO) {

    }
}
