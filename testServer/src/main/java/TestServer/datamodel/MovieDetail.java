package TestServer.datamodel;

/**
 * Created by tiankk on 16-7-14.
 */
public class MovieDetail {

    private int idx;    // movie id
    private String movieName;   // movie name
    private double score;    // score, up to 10.0;
    private double price;   // $3.99
    private String onShowDate;  // the date this movie first showed
    private String tags;    // action, romantic, comedy?
    private int timeSpan;   // how long? 103 minutes
    private String posterURL;   // the url address of poster
    private String introSimple; // simple introduction
    private String introDetailed;   // detailed introduction
    private String director;    // the director of this movie
    private String actors;  // main actors of this movie

    public MovieDetail() {}

    public MovieDetail(int idx, String movieName,
                       double score, double price,
                       String onShowDate, String tags,
                       int timeSpan, String posterURL,
                       String introSimple, String introDetailed,
                       String director, String actors) {
        this.idx = idx;
        this.movieName = movieName;
        this.score = score;
        this.price = price;
        this.onShowDate = onShowDate;
        this.tags = tags;
        this.timeSpan = timeSpan;
        this.posterURL = posterURL;
        this.introSimple = introSimple;
        this.introDetailed = introDetailed;
        this.director = director;
        this.actors = actors;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getOnShowDate() {
        return onShowDate;
    }

    public void setOnShowDate(String onshowDate) {
        this.onShowDate = onshowDate;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public int getTimeSpan() {
        return timeSpan;
    }

    public void setTimeSpan(int timeSpan) {
        this.timeSpan = timeSpan;
    }

    public String getPosterURL() {
        return posterURL;
    }

    public void setPosterURL(String posterURL) {
        this.posterURL = posterURL;
    }

    public String getIntroSimple() {
        return introSimple;
    }

    public void setIntroSimple(String introSimple) {
        this.introSimple = introSimple;
    }

    public String getIntroDetailed() {
        return introDetailed;
    }

    public void setIntroDetailed(String introDetailed) {
        this.introDetailed = introDetailed;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

}
