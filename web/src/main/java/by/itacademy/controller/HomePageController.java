package by.itacademy.controller;

import by.itacademy.entity.Film;
import by.itacademy.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class HomePageController {

    private FilmService filmService;

    @Autowired
    public HomePageController(FilmService filmService) {
        this.filmService = filmService;
    }

    @ModelAttribute("films")
    private List<Film> getFilms() {
        return filmService.getFilmsForToday();
    }

    @GetMapping("/")
    public String homepage() {
        return "home";
    }
}
