package TestServer;

public class Main {
    public static void main(String[] args) {
        Test test = new Test();
        test.testLogin();
        test.testRegister();
        test.testTheater();
        test.testMovie();
        test.testMovieInfo();
        // test.testOnviewImage();
        /*
        ArrayList<String> imgUrlList = new ArrayList<String>();
        imgUrlList.add("http://localhost:8081/pictures/posters/angry_bird.jpg");
        imgUrlList.add("http://localhost:8081/pictures/avatars/angry_bird.jpg");
        test.downloadPicture(imgUrlList);
        */
    }
}

