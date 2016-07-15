package Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by MaximTian on 2016/7/14.
 */
public class DBHelper extends SQLiteOpenHelper{

    public DBHelper(Context context) {
        super(context, "movie.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // 创建用户数据库
        String sql1 = "Create Table If Not Exists users(userId integer primary key,"
                + "userName varchar(100),"
                + "userPassword varchar(100))";
        db.execSQL(sql1);

        // 创建电影数据库
/*        String sql2 = "Create Table If Not Exists movies(movieId integer primary key,"
                + "title varchar(20),"
                + "date varchar(12),"
                + "score varchar(5),"
                + "price varchar(5),"
                + "tag varchar(20),"
                + "time varchar(5),"
                + "url varchar(20),"
                + "simple_info varchar(100),"
                + "info varchar(400),"
                + "director varchar(20),"
                + "actors varchar(40))"; */
        String sql2 = "Create Table If Not Exists movies(movieId integer primary key,"
                + "title varchar(20),"
                + "date varchar(12),"
                + "score varchar(5),"
                + "price varchar(5),"
                + "tag varchar(20),"
                + "time varchar(5),"
                + "url varchar(20),"
                + "simpleInfo varchar(100),"
                + "info varchar(400),"
                + "director varchar(20),"
                + "actors varchar(40))";
        db.execSQL(sql2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql1 = "DROP TABLE IF EXISTS users";
        db.execSQL(sql1);

        String sql2 = "DROP TABLE IF EXISTS movies";
        db.execSQL(sql2);
        onCreate(db);
    }
}
