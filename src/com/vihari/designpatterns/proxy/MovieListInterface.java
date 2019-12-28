package com.vihari.designpatterns.proxy;

import java.util.List;

public interface MovieListInterface {
    public void setAge(int age);
    public int getAge();
    public List getMovies();
    boolean isUnder18=false;
}
