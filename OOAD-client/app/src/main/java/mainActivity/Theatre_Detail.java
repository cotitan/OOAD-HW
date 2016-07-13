package mainActivity;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;


import com.example.maximtian.myapplication.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Created by WILLIAM on 2016/6/4.
 */
public class Theatre_Detail extends ListActivity {

    private ListView hall_ListView;

    private MyGallery gallery;;  // ª≠¿»

    private TextView theatreTextView;
    private TextView theatreTextView2;
    private TextView movieName;
    private TextView movieRank;

    private SimpleAdapter adapter; //  ˝æ›∂À

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.theatre_detail);

        Intent intent = getIntent();
        String value = intent.getStringExtra("theatreName");
        theatreTextView = (TextView) findViewById(R.id.theatre_detail_theatreName);
        theatreTextView2 = (TextView) findViewById(R.id.theatre_detail_theatreName2);
        movieName = (TextView) findViewById(R.id.theatre_detail_movieName);
        movieRank = (TextView) findViewById(R.id.theatre_detail_rank);

        theatreTextView.setText(value);
        theatreTextView2.setText(value);
        movieName.setText("∑ËøÒ∂ØŒÔ≥«");
        movieRank.setText("9.1");

        init_gallery();
        init_movie_info();
    }

    public void init_gallery() {
        gallery = (MyGallery)findViewById(R.id.gallery);
        gallery.setAdapter(new ImageAdapter(this));//…Ë÷√Õº∆¨  ≈‰∆˜
        //…Ë÷√º‡Ã˝∆˜
        gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,    long arg3) {
                Toast.makeText(Theatre_Detail.this, "µ„ª˜¡Àµ⁄" + arg2 + "’≈Õº∆¨", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void init_movie_info() {
        hall_ListView = getListView();
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
            Intent start_main = new Intent(Theatre_Detail.this, Choosing_place.class);
            startActivity(start_main);
        }
    }

    class ImageAdapter extends BaseAdapter {
        private Context context;
        //Õº∆¨‘¥ ˝◊È
        private Integer[] imageInteger = {
                R.drawable.image01,
                R.drawable.image02,
                R.drawable.image03,
                R.drawable.image04,
                R.drawable.image05
        };

        public ImageAdapter(Context c) {
            context = c;
        }

        @Override
        public int getCount() {
            return imageInteger.length;
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView = new ImageView(context);
            imageView.setImageResource(imageInteger[position]);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setLayoutParams(new Gallery.LayoutParams(450, 300));

            RelativeLayout borderImg = new RelativeLayout(context);
            borderImg.setPadding(3, 3, 3, 3);
            borderImg.setBackgroundResource(R.drawable.gallery_style);//…Ë÷√ImageView±ﬂøÚ
            borderImg.addView(imageView);
            return borderImg;
        }
    }
}
