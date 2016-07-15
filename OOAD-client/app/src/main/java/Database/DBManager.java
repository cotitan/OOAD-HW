package Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MaximTian on 2016/7/14.
 */
public class DBManager {
    DBHelper dbHelper;
    Context context;

    public DBManager(Context context) {
        this.context = context;
        dbHelper = new DBHelper(context);
    }

    public void addUserSQL(User user) {
        SQLiteDatabase db = null;
        try {
            db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("userId", user.getUser_id());
            values.put("userName", user.getName());
            values.put("userPassword", user.getPassword());
            values.put("userPurchaseList", user.getPurchaseList());
            db.insert("users", null, values);
            db.close();
        } catch (Exception e) {
        }
    }

    public void addMovieSQL(Movie movie) {
        SQLiteDatabase db = null;
        try {
            db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("movieId", movie.getMovie_id());
            values.put("title", movie.getTitle());
            values.put("date", movie.getDate());
            values.put("score", movie.getScore());
            values.put("price", movie.getPrice());
            values.put("tag", movie.getTag());
            values.put("time", movie.getTime());
            values.put("url", movie.getUrl());
            values.put("simpleInfo", movie.getSimple_info());
            values.put("info", movie.getInfo());
            values.put("director", movie.getDirector());
            values.put("actors", movie.getActors());
            db.insert("movies", null, values);
            db.close();
        } catch (Exception e) {
        }
    }

    // theatreId,theaterName,onShowList,address,distance,lowestPrice
    public void addTheatreSQL(Theatre theatre) {
        SQLiteDatabase db = null;
        try {
            db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("theatreId", theatre.getTheaterID());
            values.put("theaterName", theatre.getTheaterName());
            values.put("onShowList", theatre.getOnShowList());
            values.put("address", theatre.getAddress());
            values.put("distance", theatre.getDistance());
            values.put("lowestPrice", theatre.getLowestPrice());
            db.insert("theatres", null, values);
            db.close();
        } catch (Exception e) {
        }
    }

    public List<User> getAllUser() {
        List<User> list = new ArrayList<User>();
        SQLiteDatabase db = null;
        Cursor cursor = null;
        try {
            db = dbHelper.getReadableDatabase();
            cursor = db.query("users", null, null, null, null, null, null);
            User user = null;
            while (cursor.moveToNext()) {
                user = new User();
                user.setUser_id(cursor.getInt(cursor.getColumnIndex("userId")));
                user.setName(cursor.getString(cursor.getColumnIndex("userName")));
                user.setPassword(cursor.getString(cursor.getColumnIndex("userPassword")));
                list.add(user);
            }
            cursor.close();
            db.close();
        } catch (Exception e) {
        }
        return list;
    }

    public List<Movie> getAllMovie() {
        List<Movie> list = new ArrayList<Movie>();
        SQLiteDatabase db = null;
        Cursor cursor = null;
        try {
            db = dbHelper.getReadableDatabase();
            cursor = db.query("movies", null, null, null, null, null, null);
            Movie movie = null;
            while (cursor.moveToNext()) {
                movie = new Movie();
                movie.setMovie_id(cursor.getInt(cursor.getColumnIndex("movieId")));
                movie.setTitle(cursor.getString(cursor.getColumnIndex("title")));
                movie.setInfo(cursor.getString(cursor.getColumnIndex("info")));
                movie.setTime(cursor.getString(cursor.getColumnIndex("time")));
                movie.setDate(cursor.getString(cursor.getColumnIndex("date")));
                movie.setScore(cursor.getString(cursor.getColumnIndex("score")));
                movie.setTag(cursor.getString(cursor.getColumnIndex("tag")));
                movie.setUrl(cursor.getString(cursor.getColumnIndex("url")));
                movie.setDirector(cursor.getString(cursor.getColumnIndex("director")));
                movie.setPrice(cursor.getString(cursor.getColumnIndex("price")));
                movie.setActors(cursor.getString(cursor.getColumnIndex("actors")));
                movie.setSimple_info(cursor.getString(cursor.getColumnIndex("simpleInfo")));
                list.add(movie);
            }
            cursor.close();
            db.close();
        } catch (Exception e) {
        }
        return list;
    }

    public void updateUserData(int id, String name, String password, String purch) {
        SQLiteDatabase db = null;
        try {
            db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("userName", name);
            values.put("userPassword", password);
            values.put("userPurchaseList", purch);
            db.update("users", values, "userId=" + id, null);
        } catch (Exception e) {
        } finally {
            db.close();
        }
    }

    public void updateMovieData(int id, String title, String date, String score, String price, String tag,
                                String time, String url, String sim_info, String info, String dir, String actors) {
        SQLiteDatabase db = null;
        try {
            db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("title", title);
            values.put("date", date);
            values.put("score", score);
            values.put("price", price);
            values.put("tag", tag);
            values.put("time", time);
            values.put("url", url);
            values.put("simpleInfo", sim_info);
            values.put("info", info);
            values.put("director", dir);
            values.put("actors", actors);
            db.update("movies", values, "movieId=" + id, null);
        } catch (Exception e) {
        } finally {
            db.close();
        }
    }

    public User QueryUser(String name) {
        SQLiteDatabase db = null;
        Cursor cursor = null;
        User user = null;
        try {
            db = dbHelper.getReadableDatabase();
            cursor = db.rawQuery(
                    "select userId,userName,userPassword,userPurchaseList from users where userName=?",
                    new String[] { name });
            if (cursor.moveToNext()) {
                user = new User();
                user.setUser_id(cursor.getInt(0));
                user.setName(cursor.getString(1));
                user.setPassword(cursor.getString(2));
                user.setPurchaseList(cursor.getString(3));
            }
            cursor.close();
            db.close();
        } catch (Exception e) {
        }
        return user;
    }

    public Movie QueryMovie(String title) {
        SQLiteDatabase db = null;
        Cursor cursor = null;
        Movie movie = null;
        try {
            db = dbHelper.getReadableDatabase();
            cursor = db.rawQuery(
                    "select movieId,title,date,score,price,tag,time,url,simpleInfo,"
                    + "info,director,actors from movies where title=?",
                    new String[] { title });
            if (cursor.moveToNext()) {
                movie = new Movie();
                movie.setMovie_id(cursor.getInt(0));
                movie.setTitle(cursor.getString(1));
                movie.setDate(cursor.getString(2));
                movie.setScore(cursor.getString(3));
                movie.setPrice(cursor.getString(4));
                movie.setTag(cursor.getString(5));
                movie.setTime(cursor.getString(6));
                movie.setUrl(cursor.getString(7));
                movie.setSimple_info(cursor.getString(8));
                movie.setInfo(cursor.getString(9));
                movie.setDirector(cursor.getString(10));
                movie.setActors(cursor.getString(11));
            }
        } catch (Exception e) {
        } finally {
            cursor.close();
            db.close();
        }
        return movie;
    }

    public Movie QueryMovie(int id) {
        SQLiteDatabase db = null;
        Cursor cursor = null;
        Movie movie = null;
        try {
            db = dbHelper.getReadableDatabase();
            cursor = db.rawQuery(
                    "select movieId,title,date,score,price,tag,time,url,simpleInfo,"
                            + "info,director,actors from movies where movieId=?",
                    new String[] { String.valueOf(id) });
            if (cursor.moveToNext()) {
                movie = new Movie();
                movie.setMovie_id(cursor.getInt(0));
                movie.setTitle(cursor.getString(1));
                movie.setDate(cursor.getString(2));
                movie.setScore(cursor.getString(3));
                movie.setPrice(cursor.getString(4));
                movie.setTag(cursor.getString(5));
                movie.setTime(cursor.getString(6));
                movie.setUrl(cursor.getString(7));
                movie.setSimple_info(cursor.getString(8));
                movie.setInfo(cursor.getString(9));
                movie.setDirector(cursor.getString(10));
                movie.setActors(cursor.getString(11));
            }
        } catch (Exception e) {
        } finally {
            cursor.close();
            db.close();
        }
        return movie;
    }

    public Theatre QueryTheatre(int id) {
        SQLiteDatabase db = null;
        Cursor cursor = null;
        Theatre theatre = null;
        try {
            db = dbHelper.getReadableDatabase();
            cursor = db.rawQuery(
                    "select theatreId,theaterName,onShowList,address,distance,lowestPrice from theatres where theatreId=?",
                    new String[] { String.valueOf(id) });
            if (cursor.moveToNext()) {
                theatre = new Theatre();
                theatre.setTheaterID(cursor.getInt(0));
                theatre.setTheaterName(cursor.getString(1));
                theatre.setOnShowList(cursor.getString(2));
                theatre.setAddress(cursor.getString(3));
                theatre.setDistance(cursor.getString(4));
                theatre.setLowestPrice(cursor.getString(5));
            }
        } catch (Exception e) {
        } finally {
            cursor.close();
            db.close();
        }
        return theatre;
    }

}
