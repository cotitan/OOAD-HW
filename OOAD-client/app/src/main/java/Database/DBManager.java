package Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.View;

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
            db.insert("users", null, values);
        } catch (Exception e) {
        } finally {
            db.close();
        }
    }

    public void addMovieSQL(Movie movie) {
        SQLiteDatabase db = null;
        try {
            db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("movieId", movie.getMovie_id());
            values.put("title", movie.getTitle());
            values.put("info", movie.getInfo());
            db.insert("movies", null, values);
        } catch (Exception e) {
        } finally {
            db.close();
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
        } catch (Exception e) {
        } finally {
            cursor.close();
            db.close();
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
                list.add(movie);
            }
        } catch (Exception e) {
        } finally {
            cursor.close();
            db.close();
        }
        return list;
    }

    public void updateUserData(int id, String name, String password) {
        SQLiteDatabase db = null;
        try {
            db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("userName", name);
            values.put("userPassword", password);
            db.update("users", values, "userId=" + id, null);
        } catch (Exception e) {
        } finally {
            db.close();
        }
    }

    public void updateMovieData(int id, String title, String info) {
        SQLiteDatabase db = null;
        try {
            db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("title", title);
            values.put("info", info);
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
                    "select userId,userName,userPassword from users where userName=?",
                    new String[] { name });
            if (cursor.moveToNext()) {
                user = new User();
                user.setUser_id(cursor.getInt(0));
                user.setName(cursor.getString(1));
                user.setPassword(cursor.getString(2));
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
                    "select movieId,title,info from movies where title=?",
                    new String[] { title });
            if (cursor.moveToNext()) {
                movie = new Movie();
                movie.setMovie_id(cursor.getInt(0));
                movie.setTitle(cursor.getString(1));
                movie.setInfo(cursor.getString(2));
            }
        } catch (Exception e) {
        } finally {
            cursor.close();
            db.close();
        }
        return movie;
    }

}
