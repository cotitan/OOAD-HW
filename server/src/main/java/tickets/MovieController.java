package tickets;

import tickets.datamodel.*;
import sun.misc.BASE64Encoder;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@RequestMapping("/movie")
public class MovieController {
    static final String picServerIP = "http://localhost:8081";
    private static final Connection dbmsConn = DBMSOperation.getDBConnection();
    private PreparedStatement sql;

    @RequestMapping(value = "/onView", method = RequestMethod.GET, consumes = "application/json")
    public @ResponseBody MovieList returnMovieList() {
        System.out.println(" { return movie list... }");
        MovieList movieList = new MovieList();
        try {
            String query = "select idx, movieName, intro_simple, posterURL from movie ";
            sql = dbmsConn.prepareStatement(query);
            ResultSet res = sql.executeQuery();
            while (res.next()) {
                MovieSimple movieSimple = new MovieSimple(
                        res.getInt("idx"),
                        res.getString("movieName"),
                        res.getString("intro_simple"),
                        picServerIP + res.getString("posterURL"));
                movieList.addMovie(movieSimple);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        movieList.addPostersAddr(picServerIP + "/pictures/posters/angry_bird.jpg");
        movieList.addPostersAddr(picServerIP + "/pictures/posters/angry_bird.jpg");
        movieList.addPostersAddr(picServerIP + "/pictures/posters/animal_world.jpg");
        movieList.addPostersAddr(picServerIP + "/pictures/posters/animal_world.jpg");
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

