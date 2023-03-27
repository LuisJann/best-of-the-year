package org.java.bestoftheyear.controller;

import org.java.bestoftheyear.model.Movie;
import org.java.bestoftheyear.model.Song;
import org.java.bestoftheyear.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping
    public String home(Model model){
        List<User> list = getUsers();
        String names = "";
        for (User u: list) {
            names = u.getName();
        }
        model.addAttribute("name",names);
        return "home";
    }

    private List<User> getUsers(){
        List<User> users = new ArrayList<>();
        users.add(new User("Luigi"));
        return users;
    }

    @GetMapping("/movies")
    public String movies(Model model){
        List<Movie> movieList = getBestMovie();
        String titles = "";
        for (Movie m: movieList) {
            titles += m.getTitle() + ", ";
        }
        titles = titles.substring(0,titles.length()-1);
        model.addAttribute("movies", titles);
        return "movies";
    }

    @GetMapping("/songs")
    public String songs(Model model){
        List<Song> movieList = getBestSong();
        String titles = "";
        for (Song s: movieList) {
            titles += s.getTitle() + ", ";
        }
        titles = titles.substring(0,titles.length()-1);
        model.addAttribute("songs", titles);
        return "songs";
    }

    private List<Movie> getBestMovie(){
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Into the wild", 1));
        movies.add(new Movie("The wolf of wallstreet",2));
        return movies;
    }

    private List<Song> getBestSong(){
        List<Song> songs = new ArrayList<>();
        songs.add(new Song("Redemption song",1));
        songs.add(new Song("Here comes the sun",2));
        return songs;
    }
}
