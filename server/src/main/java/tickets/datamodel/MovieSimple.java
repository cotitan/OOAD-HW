package tickets.datamodel;

/**
 * Created by tiankk on 16-7-14.
 */

public class MovieSimple {
    private int idx;
    private String name;
    private String intro;
    private String avatar;

    public MovieSimple() {}

    public MovieSimple(int idx1, String name, String intro, String avatar) {
        this.idx = idx1;
        this.name = name;
        this.intro = intro;
        this.avatar = avatar;
    }

    public int getIdx() {
        return idx;
    }

    public String getName() {
        return name;
    }

    public String getIntro() {
        return intro;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setIdx(int idx1) {
        this.idx = idx1;
    }
}

