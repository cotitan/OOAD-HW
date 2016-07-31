package mainActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.maximtian.myapplication.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by MaximTian on 2016/5/22.
 */
public class Order_Activity extends Activity {

    private ListView m_ListView;
    private SimpleAdapter simpleAdapter;

    private List<Map<String, Object>> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_layout);

        m_ListView = (ListView) findViewById(R.id.orderListview);

        simpleAdapter = new SimpleAdapter(this, getData(),
                R.layout.order_listview_item, new String[]{"state", "movieName", "movieTicket", "movieSeat", "movieCost"},
                new int[]{R.id.order_state, R.id.order_movieName, R.id.order_movieTicket,
                        R.id.order_movieSeat, R.id.order_movieCost});
        m_ListView.setAdapter(simpleAdapter);
        // ???ListView????????
        m_ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
    }

    private List<Map<String, Object>> getData() {
        list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("state", "订单已完成");
        map.put("movieName", "疯狂动物城");
        map.put("movieTicket", "电影票两张");
        map.put("movieSeat", "6排14座，6排15座");
        map.put("movieCost", "￥45.0元");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("state", "订单已完成");
        map.put("movieName", "大鱼海棠");
        map.put("movieTicket", "电影票一张");
        map.put("movieSeat", "5排3座");
        map.put("movieCost", "￥22.0元");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("state", "订单已完成");
        map.put("movieName", "愤怒的小鸟");
        map.put("movieTicket", "电影票三张");
        map.put("movieSeat", "5排12座，5排13座，5排14座");
        map.put("movieCost", "￥54.0元");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("state", "订单已完成");
        map.put("movieName", "忍者神龟2");
        map.put("movieTicket", "电影票一张");
        map.put("movieSeat", "3排14座");
        map.put("movieCost", "￥18.0元");
        list.add(map);

        return list;
    }

}