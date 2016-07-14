package Database;

/**
 * Created by MaximTian on 2016/7/14.
 */
public class PublicID {
    private static int movie_id = 0;
    private static int user_id = 0;

    public static int getMovie_id() {
        movie_id += 1;
        return movie_id - 1;
    }

    public static int getUser_id() {
        user_id += 1;
        return user_id - 1;
    }
}
