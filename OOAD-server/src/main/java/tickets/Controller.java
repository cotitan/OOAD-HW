package tickets;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.google.gson.Gson;
import java.net.URLEncoder;
import java.net.URLDecoder;

@RestController
@RequestMapping("/user")
public class Controller {
	
	private static Connection dbmsConn = DBMSOperation.getDBConnection();
	private PreparedStatement sql;
	private ResultSet res;

	@RequestMapping(value="/register", method = RequestMethod.POST)
	public @ResponseBody Response register(@RequestBody String str) {
		
		str = URLDecoder.decode(str);
		System.out.println("\nregister: " + str);
		Response response = new Response();
		
		// resolve post string
		User user = new User("1234", "1234");
		try {
			user = new Gson().fromJson(str, User.class);
		} catch (Exception e) {
			response.setStatus(false);
			response.setMessage("error data format!");
			return response;
		}

		// insert into database
		try {
			String query = String.format("select * from user_Info where username=\"%s\";",
				user.getUsername());
			sql = dbmsConn.prepareStatement(query);
			res = sql.executeQuery();
			if (res.next()) {
				response.setStatus(false);
				response.setMessage("username exist!");
			}
			else {
				sql = dbmsConn.prepareStatement("insert into user_Info values(?,?,?,?,?)");
				sql.setString(1, user.getUsername());
				sql.setString(2, user.getPassword());
				sql.setInt(3, user.getGender());
				sql.setString(4, user.getPhone());
				sql.setString(5, user.getTags());
				sql.executeUpdate();

				response.setStatus(true);
				response.setMessage("Successfully registered!");
			}
		} catch (Exception e) {
			response.setStatus(false);
			response.setMessage("error inserting into database");
			e.printStackTrace();
		}
		return response;
	}


    @RequestMapping(value="/login", method = RequestMethod.POST)
    public @ResponseBody Response login(@RequestBody String str) {
        
	    str = URLDecoder.decode(str);
		System.out.println("\nlogin: " + str);
		Response response = new Response();

		// resolve post string
		User user = new User("1234", "1234");
	    try {
			user = new Gson().fromJson(str, User.class);
		} catch (Exception e) {
			response.setStatus(false);
			response.setMessage("Error data format!");
			return response;
		}

		try {
			String query = String.format("select * from user_Info where username=\"%s\";",
				user.getUsername());
			sql = dbmsConn.prepareStatement(query);
			res = sql.executeQuery();
			if (res.next()) {
				String password = res.getString("password");
				if (password.equals(user.getPassword())) {
					response.setStatus(true);
					response.setMessage("login Successfully");
				}
				else {
					response.setStatus(false);
					response.setMessage("password error");
				}
			}
			else {
				response.setStatus(false);
				response.setMessage("username not exist");
			}
		} catch (Exception e) {
			System.out.println("error query");
			e.printStackTrace();
		}
        return response;
    }
}

