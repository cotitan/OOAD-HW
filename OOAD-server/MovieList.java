import java.util.ArrayList;
import DataModel.Movie;

public class MovieList {
    private ArrayList<Movie> movieList;

    public MovieList() {}

    public MovieList(ArrayList<Movie> list) {
	movieList = new ArrayList<Movie>(list);
    }

    public void setMovieList(ArrayList<Movie> list) {
	movieList = list;
    }

    public ArrayList<Movie> getMovieList() {
	return movieList;
    }
}
