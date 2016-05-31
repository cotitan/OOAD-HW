package mainActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.maximtian.myapplication.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by MaximTian on 2016/5/31.
 */
public class Movie_Detail extends ListActivity implements View.OnClickListener {

    private ListView remark_List; // 评论

    private ImageView imageView; // 电影海报
    private TextView title; // 电影标题
    private TextView rank; // 电影评分
    private TextView movie_source; // 电影来源
    private TextView movie_time; // 电影上映时间

    private TextView movie_brevity; // 电影简介

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_detail);

        initView();
        init_remarks();
        remark_List.setFocusable(false); // 设置焦点，让页面顶置
       button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void initView() {
        imageView = (ImageView) findViewById(R.id.movie_detail_image);
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.zootopia));

        title = (TextView) findViewById(R.id.movie_detail_title);
        title.setText("疯狂动物城");

        rank = (TextView) findViewById(R.id.movie_detail_rank);
        rank.setText("9.0");

        movie_source = (TextView) findViewById(R.id.movie_detail_source);
        movie_source.setText("美国 | 97分钟");

        movie_time = (TextView) findViewById(R.id.movie_detail_time);
        movie_time.setText("2016-01-01 上映");

//        movie_brevity = (TextView) findViewById(R.id.movie_detail_brevity);
//        movie_brevity.setText("一个现代化的动物都市，每种动物在这里都有自己的居所，有沙漠气候的撒哈拉广场、常年严寒的冰川镇等等，它就像一座大熔炉，动物们在这里和平共处——无论是大象还是小老鼠，只要努力，都能闯出一番名堂。兔子朱迪从小就梦想能成为动物城市的警察，尽管身边的所有人都觉得兔子不可能当上警察，但她还是通过自己的努力，跻身到了全是大块头动物城警察局，成为了第一个兔子警官。为了证明自己，她决心侦破一桩神秘案件。追寻真相的路上，朱迪迫使在动物城里以坑蒙拐骗为生的狐狸尼克帮助自己，却发现这桩案件背后隐藏着一个意欲颠覆动物城的巨大阴谋，他们不得不联手合作，去尝试揭开隐藏在这巨大阴谋后的真相");

        mContentText = (TextView) findViewById(R.id.movie_content);
        mContentText.setText("        一个现代化的动物都市，每种动物在这里都有自己的居所，有沙漠气候的撒哈拉广场、常年严寒的冰川镇等等，它就像一座大熔炉，动物们在这里和平共处——无论是大象还是小老鼠，只要努力，都能闯出一番名堂。兔子朱迪从小就梦想能成为动物城市的警察，尽管身边的所有人都觉得兔子不可能当上警察，但她还是通过自己的努力，跻身到了全是大块头动物城警察局，成为了第一个兔子警官。为了证明自己，她决心侦破一桩神秘案件。追寻真相的路上，朱迪迫使在动物城里以坑蒙拐骗为生的狐狸尼克帮助自己，却发现这桩案件背后隐藏着一个意欲颠覆动物城的巨大阴谋，他们不得不联手合作，去尝试揭开隐藏在这巨大阴谋后的真相");
        mShowMore = (RelativeLayout) findViewById(R.id.show_more);
        mImageSpread = (ImageView) findViewById(R.id.spread);
        mImageShrinkUp = (ImageView) findViewById(R.id.shrink_up);
        mShowMore.setOnClickListener(Movie_Detail.this);

        button = (Button) findViewById(R.id.ticket_button);
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
        remark_List = getListView();
        SimpleAdapter adapter = new SimpleAdapter(this, get_movie_Data(),
                R.layout.movie_item, new String[]{"img", "title", "info", "time"},
                new int[]{R.id.movie_image, R.id.movie_title, R.id.movie_info, R.id.movie_time});
        setListAdapter(adapter);

        int totalHeight = 0;
        for (int i = 0; i < adapter.getCount(); i++) {
            View listItem = adapter.getView(i, null, remark_List);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = remark_List.getLayoutParams();
        params.height = totalHeight + (remark_List.getDividerHeight() * (remark_List.getCount() - 1));
        ((ViewGroup.MarginLayoutParams)params).setMargins(10, 10, 10, 10);
        remark_List.setLayoutParams(params);
    }

    private List<Map<String, Object>> get_movie_Data() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("img", R.mipmap.ic_launcher);
        map.put("title", "疯狂动物城");
        map.put("info", "This is an apple");
        map.put("time", "2016-01-01 上映");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("img", R.mipmap.ic_launcher);
        map.put("title", "愤怒的小鸟");
        map.put("info", "This is a banana");
        map.put("time", "2016-02-01 上映");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("img", R.mipmap.ic_launcher);
        map.put("title", "疯狂原始人");
        map.put("info", "This is a cat");
        map.put("time", "2016-03-01 上映");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("img", R.mipmap.ic_launcher);
        map.put("title", "植物大战僵尸");
        map.put("info", "This is a dog, This is a dog,This is a dog,This is a dog,This is a dog");
        map.put("time", "2016-04-01 上映");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("img", R.mipmap.ic_launcher);
        map.put("title", "舌尖上的中国");
        map.put("info", "This is an eagle, This is an eagle");
        map.put("time", "2016-05-01 上映");
        list.add(map);

        return list;
    }

}
