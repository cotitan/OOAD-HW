package src.main.java.TestServer.datamodel;

import src.main.java.TestServer.datamodel.*;
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
	
	 public Theater get(int i) {
        return theaterList.get(i);
    }
}

