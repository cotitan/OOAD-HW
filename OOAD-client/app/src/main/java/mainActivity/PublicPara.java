package mainActivity;

import com.example.maximtian.myapplication.R;

/**
 * Created by MaximTian on 2016/7/15.
 */
public class PublicPara {
    public static int[] getMovieImageIDs() {
        return new int[]{
                R.drawable.movie1,
                R.drawable.movie2,
                R.drawable.movie3,
                R.drawable.movie4,
                R.drawable.movie5
        };
    }

    public static int[] getMovieList() {
        return new int[]{
                R.drawable.image_show1,
                R.drawable.image_show2,
                R.drawable.image_show3,
                R.drawable.image_show4,
                R.drawable.image_show5
        };
    }

    public static String[] MovieName() {
        return new String[]{
                "愤怒的小鸟",
                "大鱼海棠",
                "疯狂动物城",
                "寒战2",
                "忍者神龟2：破甲而出"
        };
    }

    public static int select_MovieId = 1;

    public static int select_TheatreId = 1;
}
