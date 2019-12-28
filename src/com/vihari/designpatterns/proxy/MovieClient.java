package com.vihari.designpatterns.proxy;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

public class MovieClient {
    public List fetchMovieList()
    {
        MovieListInterface movieListInterface = new MovieListProxy();
        movieListInterface.setAge(18);
        return  movieListInterface.getMovies();
    }
    public static void main(String vv[])
    {
        MovieClient mvClient = new MovieClient();
        System.out.print(Arrays.toString(mvClient.fetchMovieList().toArray()));
    }
}
