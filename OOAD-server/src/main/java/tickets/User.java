package tickets;

public class User {

    private String username;
    private String password;
    private int gender;
    private String phone;
    private String tags;

    public User(String uName, String pw) {
	   this.username = uName;
	   this.password = pw;
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

