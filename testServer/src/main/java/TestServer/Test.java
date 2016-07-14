package TestServer;

import TestServer.datamodel.*;
import java.util.ArrayList;

import TestServer.serverConnector.DataOperationGet;
import TestServer.serverConnector.DataOperationPost;
import com.google.gson.Gson;
import sun.misc.BASE64Decoder;
import java.io.FileOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.io.DataInputStream;
import java.net.URL;
import java.util.concurrent.SynchronousQueue;

public class Test {
    public void testLogin() {
        DataOperationPost dataOp = new DataOperationPost();
        dataOp.setUrl(dataOp.getBaseUrl() + "/user/login");
        String json1 = "{\"username\": \"1234\", \"cocopassword\": \"12345\"}";
        String json2 = "{\"username\": \"1234\", \"password\": \"12345\"}";
        String json3 = "{\"username\": \"tiankk\", \"password\": \"tiankk\"}";
        try {
        	dataOp.setJson(json1);
        	System.out.println(dataOp.Do());

        	dataOp.setJson(json2);
        	// System.out.println(dataOp.Do());

        	dataOp.setJson(json3);
        	System.out.println(dataOp.Do());
    	} catch (Exception e) {
    		System.out.println("Exception");
    	}
    }
    
    public void testRegister() {
        DataOperationPost dataOp = new DataOperationPost();
        dataOp.setUrl(dataOp.getBaseUrl() + "/user/register");
        String json3 = "{\"username\": \"tiankk\", \"password\": \"tiankk\"," +  
                " \"gender\": 1, \"phone\": \"18819473274\", \"tags\": \"action\"}";
        try {
        	dataOp.setJson(json3);
        	System.out.println(dataOp.Do());
    	} catch (Exception e) {
    		System.out.println("Exception");
    	}
    }
    
    public void testMovie() {
        DataOperationGet dataOp = new DataOperationGet();
	    dataOp.setUrl(dataOp.getBaseUrl() + "/movie/onView");
    	String response = "";
	    try {
            response = dataOp.Do();
	    } catch (Exception e) {
	        System.out.println("Exception");
	    }
	    // System.out.println(response);
	    MovieList list = new MovieList();
	    try {
	        list = new Gson().fromJson(response, MovieList.class);
	    } catch (Exception e) {
	        System.out.println("exception deserialize");
	    }

        String localPath = "downloaded/pictures/avatars";
        for (MovieSimple movie: list.getMovieList()) {
	        System.out.println(movie.getName() + " " + movie.getIntro() + movie.getAvatar());
            downloadPicture(movie.getAvatar(), localPath);
        }
    }

    public void testMovieInfo() {
        DataOperationGet dataGet = new DataOperationGet();
        dataGet.setUrl(dataGet.getBaseUrl() + "/movieInfo/movieInfo");
        dataGet.setQuery("?movieName=\"疯狂动物城\"");
        String response;
        try {
            response = dataGet.Do();
            MovieDetail movieDetail = new Gson().fromJson(response, MovieDetail.class);
            System.out.println(movieDetail.getMovieName());
            System.out.println(movieDetail.getIntroSimple());
        } catch (Exception e) {
            System.out.println("error in testing movieInfo");
        }
    }

	public void testOnviewImage() {
	    DataOperationGet dataOp = new DataOperationGet();
	    dataOp.setUrl(dataOp.getBaseUrl() + "/movie/onViewPosters");
    	String response = "";
	    try {
            response = dataOp.Do();
	    } catch (Exception e) {
	        System.out.println("Exception");
	    }
	    // System.out.println(response);
	    PosterList posterList = new PosterList();
	    try {
	        posterList = new Gson().fromJson(response, PosterList.class);
	    } catch (Exception e) {
	        System.out.println("exception deserialize");
	    }
	    for (int i = 0; i < posterList.getSize(); i++) {
	        System.out.println(posterList.getMovieName(i) + "  的图片");
            deserialize(posterList.getMovieImage(i), "pic" + i + ".jpg");
	    }
	}    
	
	public void testTheater() {
        DataOperationGet dataOp = new DataOperationGet();
	    dataOp.setUrl(dataOp.getBaseUrl() + "/theater/nearby");
    	String response = "";
	    try {
            response = dataOp.Do();
	    } catch (Exception e) {
	        System.out.println("Exception");
	    }
	    // System.out.println(response);
	    TheaterList list = new TheaterList();
	    try {
	        list = new Gson().fromJson(response, TheaterList.class);
	    } catch (Exception e) {
	        System.out.println("exception deserialize");
	    }
	    for (int i = 0; i < list.size(); i++) {
	        System.out.println(list.get(i).getName() + " , " + list.get(i).getLocation()+ "," +list.get(i).getPrice());
	    }
    }

    public void downloadPicture(String urlAddr, String savingPath) {
        try {
            URL url = new URL(urlAddr);
            DataInputStream dataInputStream = new DataInputStream(url.openStream());
            String filePath = savingPath + urlAddr.substring(urlAddr.lastIndexOf('/'));
            File file = new File((filePath));
            if (!file.exists()) {
                file.getParentFile().mkdirs();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(new File(filePath));
            byte[] buffer = new byte[1024];
            int length;
            while ((length = dataInputStream.read(buffer)) > 0) {
                fileOutputStream.write(buffer, 0, length);
            }
            dataInputStream.close();
            fileOutputStream.close();
            System.out.println("picture saved to " + filePath);
        } catch (Exception e) {
            System.out.println("error downloading pictures");
        }
    }

    public void downloadPictures(ArrayList<String> urlList) {
        String savingPath = "downloaded/pictures/posters";
        String filePath;
        for (String urlAddr: urlList) {
            filePath = savingPath + urlAddr.substring(urlAddr.lastIndexOf('/'));
            downloadPicture(urlAddr, filePath);
        }
    }

    public boolean deserialize(String imgStr, String filePath) {
        //对字节数组字符串进行Base64解码并生成图片
        // System.out.println(imgStr);
        if (imgStr == null) //图像数据为空  
            return false;  
        BASE64Decoder decoder = new BASE64Decoder();
        try {  
            //Base64解码  
            byte[] b = decoder.decodeBuffer(imgStr);  
            for(int i=0;i<b.length;++i) {  
                if(b[i]<0) {//调整异常数据  
                    b[i]+=256;  
                }  
            }  
            //生成图片   
            OutputStream out = new FileOutputStream(filePath);      
            out.write(b);  
            out.flush();  
            out.close();  
            return true;  
        } catch (Exception e) {  
            return false;  
        }
    }
}

