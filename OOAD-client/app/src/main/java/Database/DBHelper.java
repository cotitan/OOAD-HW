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
                + "userPassword varchar(100),"
                + "userPurchaseList varchar(300))";
        db.execSQL(sql1);

        // 创建电影数据库
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

        // 创建电影院数据库
        String sql3 = "Create Table If Not Exists theatres(theatreId integer primary key,"
                + "theaterName varchar(50),"
                + "onShowList varchar(300),"
                + "address varchar(100),"
                + "distance varchar(20),"
                + "lowestPrice varchar(20))";
        db.execSQL(sql3);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql1 = "DROP TABLE IF EXISTS users";
        db.execSQL(sql1);

        String sql2 = "DROP TABLE IF EXISTS movies";
        db.execSQL(sql2);

        String sql3 = "DROP TABLE IF EXISTS theatres";
        db.execSQL(sql3);
        onCreate(db);
    }
}
