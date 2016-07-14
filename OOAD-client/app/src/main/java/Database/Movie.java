package Database;

/**
 * Created by MaximTian on 2016/7/14.
 */
public class Movie {
    private int movie_id;
    private String title;
    private String info;

    public Movie() {}

    public Movie(int id, String title, String info) {
        this.movie_id = id;
        this.title = title;
        this.info = info;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int id) {
        movie_id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String t) {
        this.title = t;
    }

    public String getInfo() {
        return this.info;
    }

    public void setInfo(String i) {
        this.info = i;
    }
}
