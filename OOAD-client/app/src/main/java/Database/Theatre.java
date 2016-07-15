package Database;

/**
 * Created by MaximTian on 2016/7/15.
 */
public class Theatre {
    // theaterID	theaterName	onShowList	address	distance	lowestPrice
    private int theaterID;
    private String theaterName;
    private String onShowList;
    private String address;
    private String distance;
    private String lowestPrice;

    public Theatre() {}

    public Theatre(int id, String name, String l, String a, String d, String p) {
        this.theaterID = id;
        this.theaterName = name;
        this.onShowList = l;
        this.address = a;
        this.distance = d;
        this.lowestPrice = p;
    }

    public int getTheaterID() {
        return theaterID;
    }

    public void setTheaterID(int id) {
        theaterID = id;
    }

    public String getTheaterName() {
        return this.theaterName;
    }

    public void setTheaterName(String name) {
        this.theaterName = name;
    }

    public String getOnShowList() {
        return this.onShowList;
    }

    public void setOnShowList(String sh) {
        this.onShowList = sh;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String sh) {
        this.address = sh;
    }

    public String getDistance() {
        return this.distance;
    }

    public void setDistance(String sh) {
        this.distance = sh;
    }

    public String getLowestPrice() {
        return this.lowestPrice;
    }

    public void setLowestPrice(String sh) {
        this.lowestPrice = sh;
    }
}
