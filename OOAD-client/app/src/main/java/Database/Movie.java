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

    public Movie() {}

    public Movie(int id, String title, String info, String time, String date, String score, String tag) {
        this.movie_id = id;
        this.title = title;
        this.info = info;
        this.time = time;
        this.date = date;
        this.score = score;
        this.tag = tag;
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

}
