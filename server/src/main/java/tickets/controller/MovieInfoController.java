/**
 * Created by tiankk on 16-7-14.
 */

package tickets.controller;

import org.springframework.web.bind.annotation.*;
import tickets.DBMSOperation;
import tickets.datamodel.MovieDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@RestController
@RequestMapping("/movieInfo")
public class MovieInfoController {
    private static Connection dbmsConn = DBMSOperation.getDBConnection();
    private PreparedStatement sql;
    private ResultSet res;

    @RequestMapping(value = "/movieInfo", method = RequestMethod.GET)
    public @ResponseBody MovieDetail checkMovieINfo(@RequestParam(value="movieName") String movieName) {
        String query = "select * from movie where movieName=" + movieName;
        MovieDetail movieDetail = new MovieDetail();
        try {
            sql = dbmsConn.prepareStatement(query);
            res = sql.executeQuery();
            if (res.next()) {
                movieDetail.setIdx(res.getInt("idx"));
                movieDetail.setMovieName(res.getString("movieName"));
                movieDetail.setOnShowDate(res.getString("onShowDate"));
                movieDetail.setScore(res.getDouble("score"));
                movieDetail.setPrice(res.getDouble("price"));
                movieDetail.setTags(res.getString("tags"));
                movieDetail.setTimeSpan(res.getInt("timeSpan"));
                movieDetail.setPosterURL(res.getString("posterURL"));
                movieDetail.setIntroSimple(res.getString("introSimple"));
                movieDetail.setIntroDetailed(res.getString("introDetailed"));
                movieDetail.setDirector(res.getString("director"));
                movieDetail.setActors(res.getString("actors"));
                return movieDetail;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
