package tickets.controller;

import tickets.DBMSOperation;
import tickets.datamodel.*;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
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
import com.google.gson.Gson;
import java.net.URLEncoder;
import java.net.URLDecoder;

@RestController
@RequestMapping("/theater")
public class TheaterController {
	
	private static Connection dbmsConn = DBMSOperation.getDBConnection();
	private PreparedStatement sql;
	private ResultSet res;

    //private String pic;


	@RequestMapping(value="/nearby", method = RequestMethod.GET, consumes="application/json")
	public @ResponseBody TheaterList returnTheaterList() {
	    System.out.println(" { return theater list... }");
	    /*String theater1 = "广州科学中心巨幕影院";
	    String theater2 = "金逸珠江国际影城大学城店";
		String location1 = "广州市番禺区科普路原大学城西";
		String location2 = "GOGO新天地二期2层";*/
		String theater1 = "gz";
	    String theater2 = "ku";
		String location1 = "dxc";
		String location2 = "GOGO";
		String price1 = "20.8";
		String price2 = "28.8";
	    TheaterList theaterList = new TheaterList();
        theaterList.addTheater(new Theater(theater1, location1, price1));
        theaterList.addTheater(new Theater(theater2, location2, price2));
		return theaterList;
	}

}

