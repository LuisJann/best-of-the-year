package org.java.bestoftheyear.controller;

import org.java.bestoftheyear.model.Movie;
import org.java.bestoftheyear.model.Song;
import org.java.bestoftheyear.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

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
        /*StringBuilder titles = new StringBuilder();
        for (Movie m: movieList) {
            titles.append(m.getTitle()).append(", ");
        }
        titles = new StringBuilder(titles.substring(0, titles.length() - 1));*/
        model.addAttribute("movies", movieList);
        return "movies";
    }

    @GetMapping("/songs")
    public String songs(Model model){
        List<Song> songList = getBestSong();
        /*StringBuilder titles = new StringBuilder();
        for (Song s: songList) {
            titles.append(s.getTitle()).append(", ");
        }
        titles = new StringBuilder(titles.substring(0, titles.length() - 1));*/
        model.addAttribute("songs", songList);
        return "songs";
    }

    private List<Movie> getBestMovie(){
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Into the wild", 1, "description","director"));
        movies.add(new Movie("The wolf of wallstreet",2,"description","director"));
        return movies;
    }

    private List<Song> getBestSong(){
        List<Song> songs = new ArrayList<>();
        songs.add(new Song("Redemption song",1,"description","Bob Marley"));
        songs.add(new Song("Here comes the sun",2,"description","Beatles"));
        return songs;
    }

    @GetMapping("/songs/{id}")
    public String songId(@PathVariable("id") int id, Model model){
        Optional<Song> foundSong = getBestSong().stream().filter(song->song.getId() == id).findFirst();
        model.addAttribute("song", foundSong.isPresent() ? foundSong.get() : "Song not found");
        return "songDetails";
    }

    @GetMapping("/movies/{id}")
    public String movieId(@PathVariable("id") int id, Model model){
        Optional<Movie> foundMovie = getBestMovie().stream().filter(movie -> movie.getId() == id).findFirst();
        model.addAttribute("movie", foundMovie.isPresent() ? foundMovie.get() : "Movie not found");
        return "movieDetails";
    }
}
