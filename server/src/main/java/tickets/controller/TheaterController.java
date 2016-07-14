package tickets.controller;

import tickets.DBMSOperation;
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
@RequestMapping("/theater")
public class TheaterController {
	
	private static Connection dbmsConn = DBMSOperation.getDBConnection();
	private PreparedStatement sql;

	@RequestMapping(value="/nearby", method = RequestMethod.GET)
	public @ResponseBody TheaterList returnTheaterList() {
        System.out.println(" { return theater list... }");
        TheaterList theaterList = new TheaterList();
        try {
            String query = "select * from theater ";
            sql = dbmsConn.prepareStatement(query);
            ResultSet res = sql.executeQuery();
            while (res.next()) {
                Theater t = new Theater(
                        res.getInt("theaterID"),
                        res.getString("theaterName"),
                        res.getString("onShowList"),
						res.getString("address"),
						res.getDouble("distance"),
						res.getDouble("lowestPrice"));
                theaterList.addTheater(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
   
        return theaterList;
    }

}

