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

import com.example.maximtian.myapplication.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by MaximTian on 2016/5/22.
 */
public class Theatre_Activity extends Activity {

    private ListView m_ListView;
    private static final String[] m_Cities = {"广州", "深圳", "东莞", "佛山", "中山", "肇庆"};

    private Spinner m_Spinner;
    private ArrayAdapter<String> adapter;
    private ImageButton m_ImgBut;
    private SimpleAdapter simpleAdapter;

    private List<Map<String, Object>> list; // 存影院信息

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.theatre_layout);

        m_ListView = (ListView)findViewById(R.id.theatreListView);
        m_Spinner = (Spinner)findViewById(R.id.mySpinner);
        m_ImgBut = (ImageButton)findViewById(R.id.searchButton);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, m_Cities);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        m_Spinner.setAdapter(adapter);
        //选择城市的下拉菜单
        m_Spinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                //选择不同的城市后，在这里作出变更
            }

            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });

        m_ImgBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //搜索按钮的触发事件
            }
        });

        //ListView
        m_ListView = (ListView)findViewById(R.id.theatreListView);

        simpleAdapter = new SimpleAdapter(this, getData(),
                R.layout.theatre_item, new String[]{"name", "address", "distance", "ticket", "price"},
                new int[]{R.id.theatreName, R.id.theatreAddress, R.id.theatreDistance,
                R.id.buyTicketButton, R.id.leastTicketPrice});
        m_ListView.setAdapter(simpleAdapter);

        m_ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent start_main = new Intent(Theatre_Activity.this, Theatre_Detail.class);
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