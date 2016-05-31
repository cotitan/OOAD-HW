package src.main.java.tickets.datamodel;

import java.util.ArrayList;

public class TheaterList {
    private ArrayList<Theater> theaterList;

    public TheaterList() {
        theaterList = new ArrayList<Theater>();
    }
    
    public void setTheaterList(ArrayList<Theater> list) {
        theaterList = list;
    }
    
    public ArrayList<Theater> getTheaterList() {
        return theaterList;
    }
    
    public void addTheater(Theater theater) {
        theaterList.add(theater);
    }
    
    public int size() {
        return theaterList.size();
    }
}

