package mainActivity;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;


import com.example.maximtian.myapplication.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Created by WILLIAM on 2016/6/4.
 */
public class Theatre_Detail extends Activity {

    private ListView hall_ListView;

    private ViewPager mViewPager;  // Õº∆¨  ≈‰∆˜
    private List<ImageView> imageViewList; // ª¨∂ØµƒÕº∆¨ºØ∫œ

    private int[] imageResId; // Õº∆¨ID
    private List<View> dots; // Õº∆¨±ÍÃ‚‘≤µ„
    private int currentItem = 0; // Õº∆¨µƒÀ˜“˝∫≈

    private TextView theatreTextView;
    private TextView theatreTextView2;
    private TextView movieName;
    private TextView movieRank;



    private SimpleAdapter adapter; //  ˝æ›∂À

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.theatre_detail);

        Intent intent = getIntent();
        String value = intent.getStringExtra("theatreName");
        theatreTextView = (TextView)findViewById(R.id.theatre_detail_theatreName);
        theatreTextView2 = (TextView)findViewById(R.id.theatre_detail_theatreName2);
        movieName = (TextView)findViewById(R.id.theatre_detail_movieName);
        movieRank = (TextView)findViewById(R.id.theatre_detail_rank);

        theatreTextView.setText(value);
        theatreTextView2.setText(value);
        movieName.setText("∑ËøÒ∂ØŒÔ≥«");
        movieRank.setText("9.1");


        init();
        init_movie_info();
    }

    public void init()
    {
        get_image_Data();

        mViewPager = (ViewPager) findViewById(R.id.theatreViewpager);
//        LinearLayout.LayoutParams cParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
//                getScreenHeight(Movie_Activity.this) * 3 / 10);  // …Ë÷√Õº∆¨’º∆¡ƒª1/3
//        mViewPager.setLayoutParams(cParams);

        mViewPager.setAdapter(new MyAdapter());// …Ë÷√ÃÓ≥‰ViewPager“≥√Êµƒ  ≈‰∆˜
        mViewPager.setOnPageChangeListener(new MyPageChangeListener()); // …Ë÷√“ª∏ˆº‡Ã˝∆˜£¨µ±ViewPager÷–µƒ“≥√Ê∏ƒ±‰ ±µ˜”√
    }

    private void init_movie_info() {
        hall_ListView = (ListView)findViewById(R.id.hallListView);
        adapter = new SimpleAdapter(this, get_movie_Data(),
                R.layout.hall_item, new String[]{"time", "movie_type", "hall", "price"},
                new int[]{R.id.hall_item_time, R.id.hall_item_type, R.id.hall_item_hall, R.id.hall_item_price});
        hall_ListView.setAdapter(adapter);

        hall_ListView.setOnItemClickListener(new MyItemClickListener());
    }

    private List<Map<String, Object>> get_movie_Data() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("time", "12:45");
        map.put("movie_type", "”¢”Ô3D");
        map.put("hall", "4∫≈Ã¸");
        map.put("price", "41");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("time", "12:45");
        map.put("movie_type", "”¢”Ô3D");
        map.put("hall", "4∫≈Ã¸");
        map.put("price", "41");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("time", "12:45");
        map.put("movie_type", "”¢”Ô3D");
        map.put("hall", "4∫≈Ã¸");
        map.put("price", "41");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("time", "12:45");
        map.put("movie_type", "”¢”Ô3D");
        map.put("hall", "4∫≈Ã¸");
        map.put("price", "41");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("time", "12:45");
        map.put("movie_type", "”¢”Ô3D");
        map.put("hall", "4∫≈Ã¸");
        map.put("price", "41");
        list.add(map);

        return list;
    }

    private class MyItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
            Map<String, String> map = (Map<String, String>) adapter.getItem(position);
            Intent start_main = new Intent(Theatre_Detail.this, Movie_Detail.class);
            startActivity(start_main);
        }
    }

    private void get_image_Data() {
        imageViewList = new ArrayList<ImageView>();
        imageResId = getImageResIDs();
        for (int i = 0; i < imageResId.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(imageResId[i]);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageViewList.add(imageView);
        }

        dots = new ArrayList<View>();
        dots.add(findViewById(R.id.v_dot0));
        dots.add(findViewById(R.id.v_dot1));
        dots.add(findViewById(R.id.v_dot2));
        dots.add(findViewById(R.id.v_dot3));
        dots.add(findViewById(R.id.v_dot4));
    }

    private int[] getImageResIDs() {
        return new int[]{
                R.drawable.image01,
                R.drawable.image02,
                R.drawable.image03,
                R.drawable.image04,
                R.drawable.image05
        };
    }

    private class MyAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return imageResId.length;
        }

        @Override
        public Object instantiateItem(View arg0, int arg1) {
            ((ViewPager) arg0).addView(imageViewList.get(arg1));
            return imageViewList.get(arg1);
        }

        @Override
        public void destroyItem(View arg0, int arg1, Object arg2) {
            ((ViewPager) arg0).removeView((View) arg2);
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }
    }

    private class MyPageChangeListener implements ViewPager.OnPageChangeListener {
        private int oldPosition = 0;

        /**
         * This method will be invoked when a new page becomes selected.
         * position: Position index of the new selected page.
         */
        public void onPageSelected(int position) {
            currentItem = position;
            dots.get(oldPosition).setBackgroundResource(R.drawable.dot_normal);
            dots.get(position).setBackgroundResource(R.drawable.dot_focus);
            oldPosition = position;
        }

        public void onPageScrollStateChanged(int arg0) {

        }

        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }
    }
}
