package datamodel;

public class User {

    private String username;
    private String password;
    private int gender;
    private String phone;
    private String tags;

    public User() { }

    public User(String uName, String pw) {
	   this.username = uName;
	   this.password = pw;
    }

    public User(String uName, String pw, int gender1, String phone1, String tags1) {
        this.username = uName;
        this.password = pw;
        this.gender = gender1;
        this.phone = phone1;
        this.tags = tags1;
    }

    public User(User user) {
        this.username = user.username;
        this.password = user.password;
        this.gender = user.gender;
        this.phone = user.phone;
        this.tags = user.tags;
    }

    public String getUsername() {
	   return username;
    }

    public String getPassword() {
	   return password;
    }

    public int getGender() {
        return gender;
    }

    public String getPhone() {
        return phone;
    }

    public String getTags() {
        return tags;
    }

    public void setUsername(String uName) {
	   this.username = uName;
    }

    public void setPassword(String pw) {
	   this.password = pw;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }


    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public void setTags(String tags) {
        this.tags = tags;
    }

}

