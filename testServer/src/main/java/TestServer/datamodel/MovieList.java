package TestServer.datamodel;

import java.util.ArrayList;

public class MovieList {
    private ArrayList<MovieSimple> movieList;
    private ArrayList<String> postersAddrs;

    public MovieList() {
        movieList = new ArrayList<MovieSimple>();
        postersAddrs = new ArrayList<String>();
    }
    
    public void setPostersAddrs(ArrayList<String> list) {
        postersAddrs = list;
    }

    public ArrayList<String> getPostersAddrs() {
        return postersAddrs;
    }

    public void setmovieList(ArrayList<MovieSimple> list) {
        movieList = list;
    }
    
    public ArrayList<MovieSimple> getMovieList() {
        return movieList;
    }
    
    public void addMovie(MovieSimple movie) {
        movieList.add(movie);
    }
    
    public void addPostersAddr(String addr) {
        postersAddrs.add(addr);
    }    
}

