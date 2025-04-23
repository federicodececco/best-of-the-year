package org.lessons.best_of_the_year.best_of_the_year.controller;

import org.lessons.best_of_the_year.best_of_the_year.classes.*;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("/")
public class HomeController {

    private ArrayList<Movie> getMovies() {
        int i = 0;
        Movie lord_of_the_rings_1 = new Movie(i++, "The Fellowship of the Ring");
        Movie lord_of_the_rings_2 = new Movie(i++, "The Two Towers");
        Movie lord_of_the_rings_3 = new Movie(i++, "The Return of the King");
        Movie lord_of_the_rings_4 = new Movie(i++, "An Unexpected Journey");

        ArrayList<Movie> lotr = new ArrayList<Movie>();

        lotr.add(lord_of_the_rings_1);
        lotr.add(lord_of_the_rings_2);
        lotr.add(lord_of_the_rings_3);
        lotr.add(lord_of_the_rings_4);

        return lotr;

    }

    private ArrayList<Song> getSongs() {
        int i = 0;
        Song welcome_to_the_black_parade = new Song(i++, "Welcome to the Black Parade");
        Song helena = new Song(i++, "Helena");
        Song headfirst_for_halos = new Song(i++, "Headfirst for Halos");
        Song the_sharpest_lives = new Song(i++, "The Sharpest Lives");

        ArrayList<Song> songs = new ArrayList<Song>();

        songs.add(the_sharpest_lives);
        songs.add(welcome_to_the_black_parade);
        songs.add(helena);
        songs.add(headfirst_for_halos);

        return songs;
    }

    @GetMapping("/")
    public String bestYear(Model model) {

        model.addAttribute("name", "luigino");

        return "home";
    }

    @GetMapping("/movies")
    public String movieIndex(Model model) {
        String movies = "";
        for (Movie i : getMovies()) {
            movies += i.getTitle();
            movies += ", ";
        }
        model.addAttribute("movies", movies);
        return "movies";
    }

    @GetMapping("/songs")
    public String songIndex(Model model) {
        // String songs = "";
        // for (Song i : getSongs()) {
        // songs += i.getTitle();
        // songs += ", ";
        // }

        // model.addAttribute("songs", songs);

        model.addAttribute("songs", getSongs());

        return "songs";
    }

    @GetMapping("/songs/{id}")
    public String movieShow(Model model, @PathVariable("id") String stringId) {

        try {
            int id = Integer.valueOf(stringId);

            String song = getSongs().get(id).getTitle();
            model.addAttribute("songs", song);

        } catch (NumberFormatException e) {
            System.out.println("Input not valid");
        }

        return "songs";
    }

    @GetMapping("/movies/{id}")
    public String songShow(Model model, @PathVariable("id") String stringId) {

        try {
            int id = Integer.valueOf(stringId);

            String movie = getMovies().get(id).getTitle();
            model.addAttribute("movies", movie);

        } catch (NumberFormatException e) {
            System.out.println("Input not valid");
        }

        return "movies";
    }

}
