package com.vihari.designpatterns.proxy;

import java.util.List;

public class MovieListProxy implements MovieListInterface {
    public boolean isUnder18 = false;
    int age=-1;
    public List getMovies()
    {
        System.out.println("Movies requested by user of age "+age+" at "+ System.currentTimeMillis());
        MovieList mList = new MovieList();
        if(age<18)
        {
            return mList.viewByAll;
        }
        else
        {
            return mList.getMovies();
        }
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
