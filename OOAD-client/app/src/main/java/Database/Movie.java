package Database;

/**
 * Created by MaximTian on 2016/7/14.
 */
public class Movie {
    private int movie_id;
    private String title;
    private String info;
    private String time;
    private String date;
    private String score;
    private String tag;
    private String simple_info;
    private String url;
    private String price;
    private String director;
    private String actors;

    public Movie() {}

    public Movie(int id, String title, String date, String score, String price, String tag,
                 String time, String url, String sim_info, String info, String dir, String actors) {
        this.movie_id = id;
        this.title = title;
        this.info = info;
        this.time = time;
        this.date = date;
        this.score = score;
        this.tag = tag;
        this.price = price;
        this.url = url;
        this.simple_info = sim_info;
        this.director = dir;
        this.actors = actors;
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

    public String getTime() {
        return this.time;
    }

    public void setTime(String t) {
        this.time = t;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String d) {
        this.date = d;
    }

    public String getScore() {
        return this.score;
    }

    public void setScore(String s) {
        this.score = s;
    }

    public String getTag() {
        return this.tag;
    }

    public void setTag(String t) {
        this.tag = t;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String p) {
        this.price = p;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String u) {
        this.url = u;
    }

    public String getSimple_info() {
        return this.simple_info;
    }

    public void setSimple_info(String s) {
        this.simple_info = s;
    }

    public String getDirector() {
        return this.director;
    }

    public void setDirector(String d) {
        this.director = d;
    }

    public String getActors() {
        return this.actors;
    }

    public void setActors(String s) {
        this.actors = s;
    }
}
