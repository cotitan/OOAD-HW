package tickets.datamodel;

public class Theater {
	private int theaterID;
    private String theaterName;
	private String onShowList;
    private String address;
	private double distance;
	private double lowestPrice
    // distance ???
	
    public Theater() {}
    
    public Theater(String name, String address, String price) {
        this.theaterName = name;
        this.address = address;
        this.lowesetPrice = price;
    }
	
	public Theater(int ID, String name, String address, String onShowList, String address, double distance, double price) {
		this.theaterID = ID;
        this.theaterName = name;
		this.onShowList = onShowList;
        this.address = address;
		this.distance = distance;
        this.lowesetPrice = price;
    }
    
    public String getName() {
        return theaterName;
    }
    
    public String getAddress() {
        return address;
    }
    
    public double getPrice() {
        return lowestPrice;
    }
    
    public void setName(String name) {
        this.theaterName = name;
    }
    
    public void setaddress(String address) {
        this.address = address;
    }
    
    public void setPrice(String price) {
        this.lowesetPrice = price;
    }
}

