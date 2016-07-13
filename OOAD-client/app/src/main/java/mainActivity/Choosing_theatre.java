package mainActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.maximtian.myapplication.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by MaximTian on 2016/5/22.
 */
public class Choosing_theatre extends Activity {

    private TextView m_title;
    private ListView m_ListView;
    private ArrayAdapter<String> adapter;
    private ImageButton m_ImgBut;
    private ImageButton m_back;
    private SimpleAdapter simpleAdapter;

    private List<Map<String, Object>> list; // 存影院信息

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choosingtheatre_layout);

        m_ImgBut = (ImageButton)findViewById(R.id.searchButton);
        m_back = (ImageButton)findViewById(R.id.back);
        m_title = (TextView)findViewById(R.id.movie_title);

        Intent i = this.getIntent();
//        m_title.setText(i.getStringExtra("movieName"));
        m_title.setText("愤怒的小鸟");

        m_ImgBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //搜索按钮的触发事件
            }
        });

        m_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // back to the last activity
                finish();
            }
        });

        //ListView
        m_ListView = (ListView)findViewById(R.id.choosingtheatreListView);

        simpleAdapter = new SimpleAdapter(this, getData(),
                R.layout.theatre_item, new String[]{"name", "address", "distance", "ticket", "price"},
                new int[]{R.id.theatreName, R.id.theatreAddress, R.id.theatreDistance,
                        R.id.buyTicketButton, R.id.leastTicketPrice});
        m_ListView.setAdapter(simpleAdapter);

        m_ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent start_main = new Intent(Choosing_theatre.this, Choosing_place.class);
                start_main.putExtra("theatreName", list.get(i).get("name").toString());
                startActivity(start_main);
            }
        });
    }

    private List<Map<String, Object>> getData() {
        list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "广东科学中心巨幕影院");
        map.put("address", "广州大学城西六路168号");
        map.put("distance", "3.80km");
        map.put("ticket", "特惠抢票");
        map.put("price", "￥ 20.8");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("name", "广东科学中心巨幕影院");
        map.put("address", "广州大学城西六路168号");
        map.put("distance", "3.80km");
        map.put("ticket", "特惠抢票");
        map.put("price", "￥ 20.8");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("name", "广东科学中心巨幕影院");
        map.put("address", "广州大学城西六路168号");
        map.put("distance", "3.80km");
        map.put("ticket", "特惠抢票");
        map.put("price", "￥ 20.8");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("name", "广东科学中心巨幕影院");
        map.put("address", "广州大学城西六路168号");
        map.put("distance", "3.80km");
        map.put("ticket", "特惠抢票");
        map.put("price", "￥ 20.8");
        list.add(map);

        return list;
    }
}