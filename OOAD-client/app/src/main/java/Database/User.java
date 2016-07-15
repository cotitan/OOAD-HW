package Database;

/**
 * Created by MaximTian on 2016/7/14.
 */
public class User {
    private int user_id;
    private String name;
    private String password;
    private String purchaseList;

    public User() {}

    public User(int id, String name, String password) {
        this.user_id = id;
        this.name = name;
        this.password = password;
        this.purchaseList = "";
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int id) {
        user_id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String ps) {
        this.password = ps;
    }

    public String getPurchaseList() {
        return this.purchaseList;
    }

    public void setPurchaseList(String ps) {
        this.purchaseList = ps;
    }
}