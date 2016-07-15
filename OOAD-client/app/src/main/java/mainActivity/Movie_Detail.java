package mainActivity;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.maximtian.myapplication.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Database.DBManager;
import Database.Movie;

/**
 * Created by MaximTian on 2016/5/31.
 */
public class Movie_Detail extends Activity implements View.OnClickListener {

    private MyListView remark_List; // 评论
    private ImageButton back;

    private ImageView imageView; // 电影海报
    private TextView title; // 电影标题
    private TextView rank; // 电影评分
    private TextView movie_source; // 电影来源
    private TextView movie_time; // 电影上映时间

    private Button button;

    private static final int VIDEO_CONTENT_DESC_MAX_LINE = 4;// 默认展示最大行数3行
    private static final int SHOW_CONTENT_NONE_STATE = 0;// 扩充
    private static final int SHRINK_UP_STATE = 1;// 收起状态
    private static final int SPREAD_STATE = 2;// 展开状态
    private static int mState = SHRINK_UP_STATE;//默认收起状态

    private TextView mContentText;// 展示文本内容
    private RelativeLayout mShowMore;// 展示更多
    private ImageView mImageSpread;// 展开
    private ImageView mImageShrinkUp;// 收起

    private RatingBar ratingBar;  // 电影评分
    private float ratingMarks;

    private int movieId; // 电影id
    private Movie movie;
    private DBManager dbManager;

    private TextView TopTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_detail);
        dbManager = new DBManager(this);

        // 获取电影id
        Bundle bundle = this.getIntent().getExtras();
        movieId = bundle.getInt("movieId");
        movie = dbManager.QueryMovie(movieId);

        initView();
        init_remarks();
        remark_List.setFocusable(false); // 设置焦点，让页面顶置
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent start_main = new Intent(Movie_Detail.this, Choosing_theatre.class);
                start_main.putExtra("movieName", title.toString());
                startActivity(start_main);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // back to the last activity
                finish();
            }
        });
    }

    private void initView() {
        imageView = (ImageView) findViewById(R.id.movie_detail_image);
        imageView.setImageDrawable(getResources().getDrawable(PublicImageID.getMovieImageIDs()[movie.getMovie_id() - 1]));

        title = (TextView) findViewById(R.id.movie_detail_title);
        title.setText(movie.getTitle());

        TopTitle = (TextView) findViewById(R.id.Top_title);
        TopTitle.setText(movie.getTitle());

        // 电影评分
        ratingMarks = Float.valueOf(movie.getScore());
        rank = (TextView) findViewById(R.id.movie_detail_rank);
        rank.setText(String.valueOf(ratingMarks));
        float temp_marks = ratingMarks - 5;
        if (temp_marks <= 0) temp_marks = (float) 0;
        ratingBar = (RatingBar)findViewById(R.id.room_ratingbar);
        ratingBar.setRating(temp_marks);

        movie_source = (TextView) findViewById(R.id.movie_detail_source);
        movie_source.setText(movie.getTime() + " 分钟");

        movie_time = (TextView) findViewById(R.id.movie_detail_time);
        movie_time.setText(movie.getDate() + " 上映");

        mContentText = (TextView) findViewById(R.id.movie_content);
        mContentText.setText(movie.getInfo());
        mShowMore = (RelativeLayout) findViewById(R.id.show_more);
        mImageSpread = (ImageView) findViewById(R.id.spread);
        mImageShrinkUp = (ImageView) findViewById(R.id.shrink_up);
        mShowMore.setOnClickListener(Movie_Detail.this);

        button = (Button) findViewById(R.id.ticket_button);
        back = (ImageButton) findViewById(R.id.back);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.show_more: {
                if (mState == SPREAD_STATE) {
                    mContentText.setMaxLines(VIDEO_CONTENT_DESC_MAX_LINE);
                    mContentText.requestLayout();
                    mImageShrinkUp.setVisibility(View.GONE);
                    mImageSpread.setVisibility(View.VISIBLE);
                    mState = SHRINK_UP_STATE;
                } else if (mState == SHRINK_UP_STATE) {
                    mContentText.setMaxLines(Integer.MAX_VALUE);
                    mContentText.requestLayout();
                    mImageShrinkUp.setVisibility(View.VISIBLE);
                    mImageSpread.setVisibility(View.GONE);
                    mState = SPREAD_STATE;
                }
                break;
            }
            default: {
                break;
            }
        }
    }

    private void init_remarks() {
        remark_List = (MyListView) findViewById(R.id.myListView);
        SimpleAdapter adapter = new SimpleAdapter(this, get_remark_Data(),
                R.layout.remark_item, new String[]{"au_img", "au_name", "rm_time", "remark"},
                new int[]{R.id.author_image, R.id.author_name, R.id.remark_time, R.id.remark_info});
        remark_List.setAdapter(adapter);

        int totalHeight = 0;
        for (int i = 0; i < adapter.getCount(); i++) {
            View listItem = adapter.getView(i, null, remark_List);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = remark_List.getLayoutParams();
        params.height = totalHeight + (remark_List.getDividerHeight() * (remark_List.getCount() - 1));
        remark_List.setLayoutParams(params);
        remark_List.setEnabled(false);
    }

    private List<Map<String, Object>> get_remark_Data() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("au_img", R.drawable.dynamic1);
        map.put("au_name", "labi");
        map.put("rm_time", "3天前");
        map.put("remark", "balalallallalalalasllalalslladakbsxajlalsdlalalallalalaaalallalalalalalalalallalalallalalalsallasxknasashd");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("au_img", R.drawable.dynamic2);
        map.put("au_name", "labi");
        map.put("rm_time", "3天前");
        map.put("remark", "balalallallalalalasllalalslladakbsxajlalsdlalalallalalaaalallalalalalalalalallalalallalalalsallasxknasashd");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("au_img", R.drawable.dynamic3);
        map.put("au_name", "labi");
        map.put("rm_time", "3天前");
        map.put("remark", "balalallallalalalasllalalslladakbsxajlalsdlalalallalalaaalallalalalalalalalallalalallalalalsallasxknasashd");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("au_img", R.drawable.dynamic4);
        map.put("au_name", "labi");
        map.put("rm_time", "3天前");
        map.put("remark", "balalallallalalalasllalalslladakbsxajlalsdlalalallalalaaalallalalalalalalalallalalallalalalsallasxknasashd");
        list.add(map);

        return list;
    }

}
