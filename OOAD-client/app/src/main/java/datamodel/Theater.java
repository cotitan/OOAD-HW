package datamodel;

public class Theater {
    private int theaterID;
    private String theaterName;
	private String onShowList;
    private String address;
	private double distance;
	private double lowestPrice;
    // distance ???
	
    public Theater() {}

	public Theater(int ID, String name, String onShowList,
                   String address, double distance, double price) {
		this.theaterID = ID;
        this.theaterName = name;
		this.onShowList = onShowList;
        this.address = address;
		this.distance = distance;
        this.lowestPrice = price;
    }


    public int getTheaterID() {
        return theaterID;
    }

    public void setTheaterID(int theaterID) {
        this.theaterID = theaterID;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    public String getOnShowList() {
        return onShowList;
    }

    public void setOnShowList(String onShowList) {
        this.onShowList = onShowList;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getLowestPrice() {
        return lowestPrice;
    }

    public void setLowestPrice(double lowestPrice) {
        this.lowestPrice = lowestPrice;
    }

}

