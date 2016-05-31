package src.main.java.TestServer.datamodel;

import java.util.ArrayList;

public class PosterList {
    private ArrayList<Poster> posterList;
    private int size;
    
    public class Poster {
        private String movieName;
        private String movieImage;
        public Poster() {}
        public Poster(String name, String image) {
            this.movieName = name;
            this.movieImage = image;
        }
        public void setMovieName(String name) { this.movieName = name; }
        public void setMovieImage(String image) { this.movieImage = image; }
        public String getMovieName() { return this.movieName; }
        public String getMovieImage() { return this.movieImage; }
    }
    
    public PosterList() {
        posterList = new ArrayList<Poster>();
        size = 0;
    }
    
    public void setPosterList(ArrayList<Poster> list) {
        posterList = list;
    }
    
    public ArrayList<Poster> getPosterList() {
        return posterList;
    }
    
    public int getSize() {
        return size;
    }
    
    public void setSize(int s) {
        size = s;
    }
    
    public String getMovieName(int i) {
        if (i >= size)
            return "";
        return posterList.get(i).getMovieName();
    }
    
    public String getMovieImage(int i) {
        if (i >= size)
            return "";
        return posterList.get(i).getMovieImage();
    }
    
    public void add(String name, String image) {
        posterList.add(new Poster(name, image));
        size++;
    }
        
}

