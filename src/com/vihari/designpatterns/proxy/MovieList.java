package com.vihari.designpatterns.proxy;

import java.util.ArrayList;
import java.util.List;

public class MovieList implements MovieListInterface {
    List<String> ageRestrictedMovies = new ArrayList();
    List<String> viewByAll = new ArrayList();
    int age =-1;
    public MovieList()
    {
        ageRestrictedMovies.add("LOGAN");
        ageRestrictedMovies.add("CONJURING");
        ageRestrictedMovies.add("KABIR SINGH");
        viewByAll.add("FROZEN");
        viewByAll.add("BAAHUBALI");
        viewByAll.add("SAAHO");
    }
    public List<Object> getMovies()
    {
        List combinedList = new ArrayList();
        combinedList.addAll(ageRestrictedMovies);
        combinedList.addAll(viewByAll);
        return combinedList;
    }
    public int getAge()
    {
        return age;
    }
    public void  setAge(int age)
    {
        this.age = age;
    }
}
