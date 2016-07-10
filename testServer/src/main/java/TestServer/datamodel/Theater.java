package TestServer.datamodel;

public class Theater {
    private String name;
    private String location;
    private String price;
    // distance ???
	
    public Theater() {}
    
    public Theater(String name, String location, String price) {
        this.name = name;
        this.location = location;
        this.price = price;
    }
    
    public String getName() {
        return name;
    }
    
    public String getLocation() {
        return location;
    }
    
    public String getPrice() {
        return price;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
    
    public void setPrice(String price) {
        this.price = price;
    }
}

