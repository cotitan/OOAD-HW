package src.main.java.tickets;

import src.main.java.tickets.datamodel.*;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;
import java.util.ArrayList;
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

@RestController
@RequestMapping("/movie")
public class MovieController {
	static final String serverIP = "http://42.96.205.36:8081";
	private static Connection dbmsConn = DBMSOperation.getDBConnection();
	private PreparedStatement sql;

	@RequestMapping(value="/onView", method = RequestMethod.GET, consumes="application/json")
	public @ResponseBody MovieList returnMovieList() {
            System.out.println(" { return movie list... }");
            String m1_intro = "这是一座独一无二的现代动物都市，每种动物在这里都有自己的居所，比如";
            String m2_intro = "在一座与世隔绝的美丽小鸟上，住着一群乐天知命的鸟。不过易怒的大红、亢奋的";
            String avatarAddr1 = serverIP + "/pictures/avatars/angry_bird";
            String avatarAddr2 = serverIP + "/pictures/avatars/animal_world";
            MovieList movieList = new MovieList();
            movieList.addMovie(new Movie("疯狂动物城", m1_intro, avatarAddr1));
            movieList.addMovie(new Movie("愤怒的小鸟", m2_intro, avatarAddr2));
            movieList.addPostersAddr(serverIP + "/pictures/posters/angry_bird");
            movieList.addPostersAddr(serverIP + "/pictures/posters/angry_bird");
            movieList.addPostersAddr(serverIP + "/pictures/posters/animal_world");
            movieList.addPostersAddr(serverIP + "/pictures/posters/animal_world");
            return movieList;
	}
	
	/*
	@RequestMapping(value="/onViewPosters", method = RequestMethod.GET, consumes="application/json")
	public @ResponseBody PosterList returnOnViewPosters() {
	    System.out.println(" { return onview posters... }");
	    PosterList p = new PosterList();
	    p.add("愤怒的小鸟", encodeToString("angry_bird.jpg", "jpg"));
	    p.add("疯狂动物城", encodeToString("animal_world.jpg", "jpg"));
	    return p;
	}
	*/
        public static String encodeToString(String imgPath, String type) {
            BufferedImage image = null;
            try {
                image = ImageIO.read(new FileInputStream(imgPath));
            } catch (Exception e) {
                System.out.println("File not found");
            }
            String imageString = null;  
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
        
            try {  
                ImageIO.write(image, type, bos);  
                byte[] imageBytes = bos.toByteArray();  
  
                BASE64Encoder encoder = new BASE64Encoder();  
                imageString = encoder.encode(imageBytes);  
  
                bos.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
            return imageString;  
        }  

}

