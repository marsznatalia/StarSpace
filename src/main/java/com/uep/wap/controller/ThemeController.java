package com.uep.wap.controller;

import com.uep.wap.dto.ThemeDTO;
import com.uep.wap.exception.ThemeNotFoundException;
import com.uep.wap.model.Theme;
import com.uep.wap.service.ThemeService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path ="/api")
public class ThemeController {
    private final ThemeService themeService;

    public ThemeController(ThemeService themeService) {
        this.themeService = themeService;
    }

    @GetMapping(path ="/themes")
    public Iterable<Theme> getAllThemes(){
        return themeService.getAllThemes();
    }

    @GetMapping(path = "/themes/{themeId}")
    public Theme findThemeById(@PathVariable Long themeId){
        return themeService.findThemeById(themeId)
                .orElseThrow(()-> new ThemeNotFoundException(themeId));
    }

    @PostMapping(path="/themes/new-theme")
    public String newTheme(@RequestBody ThemeDTO themeDTO){
        themeService.newTheme(themeDTO);
        return "Theme created!";
    }

    @PatchMapping(path="/themes/edit-theme/{themeId}")
    public String editTheme(@PathVariable Long themeId, @RequestBody ThemeDTO themeDTO){
        themeService.editTheme(themeId, themeDTO);
        return "Theme edited!";
    }
}
