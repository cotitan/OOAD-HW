package tickets.datamodel;

import java.util.ArrayList;

public class MovieList {
    private ArrayList<Movie> movieList;
    private ArrayList<String> postersAddrs;

    public MovieList() {
        movieList = new ArrayList<Movie>();
        postersAddrs = new ArrayList<String>();
    }
    
    public void setPostersAddrs(ArrayList<String> list) {
        postersAddrs = list;
    }

    public ArrayList<String> getPostersAddrs() {
        return postersAddrs;
    }

    public void setmovieList(ArrayList<Movie> list) {
        movieList = list;
    }
    
    public ArrayList<Movie> getMovieList() {
        return movieList;
    }
    
    public void addMovie(Movie movie) {
        movieList.add(movie);
    }
    
    public void addPostersAddr(String addr) {
        postersAddrs.add(addr);
    }    
}

