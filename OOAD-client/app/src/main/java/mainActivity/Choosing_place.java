package mainActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.maximtian.myapplication.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Database.DBManager;
import Database.Movie;
import Database.Theatre;

/**
 * Created by MaximTian on 2016/6/7.
 */
public class Choosing_place extends Activity {

    private SimpleAdapter adapter;
    private GridView gridview;
    private GridView row;

    private TextView theatreName;
    private TextView movieName;
    private TextView movieInfo;
    private TextView hallInfo;
    private ImageButton m_back;

    private String[] row_number = new String[]{"1", "2", "3", "4", "5", "6", "7"};

    private DBManager dbManager;

    private Theatre theatre;
    private Movie movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choosingplace_layout);
        dbManager = new DBManager(this);
        theatre = dbManager.QueryTheatre(PublicPara.select_TheatreId);
        movie = dbManager.QueryMovie(PublicPara.select_MovieId);

        init_layout();
        init_gridview();
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
//                Toast.makeText(Choosing_place.this, String.valueOf(position), Toast.LENGTH_LONG).show();
                String s = "选中 第 " + String.valueOf(position / 8 + 1) + "排, 第"
                        + String.valueOf(position % 8 + 1) + "列";
                new AlertDialog.Builder(Choosing_place.this)
                        .setTitle("购票信息")
                        .setMessage(s + "\n是否购票？")
                        .setPositiveButton("是", null)
                        .setNegativeButton("否", null)
                        .show();
            }
        });

        m_back = (ImageButton)findViewById(R.id.back);
        m_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // back to the last activity
                finish();
            }
        });
    }

    private void init_layout() {
        movieName = (TextView)findViewById(R.id.Top_title);
        theatreName = (TextView)findViewById(R.id.choosingplace_theatreName);
        movieInfo = (TextView)findViewById(R.id.choosingplace_info);
        hallInfo = (TextView)findViewById(R.id.choosingplace_hall);
        Intent intent = getIntent();
        movieName.setText(movie.getTitle());
        theatreName.setText(intent.getStringExtra(theatre.getTheaterName()));

        Calendar c = Calendar.getInstance();
        String today = String.valueOf(c.get(Calendar.MONTH)) + "月"
                + String.valueOf(c.get(Calendar.DAY_OF_MONTH)) + "号";
        movieInfo.setText(today + " " + movie.getDate() + " " + movie.getTag());
//        hallInfo.setText(intent.getStringExtra("hall"));
    }

    private void init_gridview() {
        gridview = (GridView) findViewById(R.id.gridview);
        row = (GridView) findViewById(R.id.row);
        row.setAdapter(new ArrayAdapter<String>(this, R.layout.grid_row_item, row_number));
//        gridview.setAdapter(new ArrayAdapter<String>(this, R.layout.grid_view_item, str));
        adapter = new SimpleAdapter(this, get_grid_Data(), R.layout.grid_img_item,
                new String[]{"image"},
                new int[]{R.id.img_view});
        gridview.setAdapter(adapter);
    }

    private List<Map<String, Object>> get_grid_Data() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        for(int i = 0;i < 56; i++){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", R.drawable.block_1);
            list.add(map);
        }
        return list;
    }

}
