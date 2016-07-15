package mainActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.maximtian.myapplication.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Database.DBManager;

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

    private String[] row_number = new String[]{"1", "2", "3", "4", "5", "6", "7"};

    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choosingplace_layout);
        dbManager = new DBManager(this);

        init_layout();
        init_gridview();
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(Choosing_place.this, String.valueOf(position), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void init_layout() {
        movieName = (TextView)findViewById(R.id.Top_title);
        theatreName = (TextView)findViewById(R.id.choosingplace_theatreName);
        movieInfo = (TextView)findViewById(R.id.choosingplace_info);
        hallInfo = (TextView)findViewById(R.id.choosingplace_hall);
        Intent intent = getIntent();
        movieName.setText(dbManager.QueryMovie(PublicImageID.select_MovieId).getTitle());
        theatreName.setText(intent.getStringExtra("theatreName"));
/*        movieInfo.setText(intent.getStringExtra("time") + " " + intent.getStringExtra("movie_type"));
        hallInfo.setText(intent.getStringExtra("hall"));
*/
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
