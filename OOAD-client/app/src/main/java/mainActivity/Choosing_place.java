package mainActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import com.example.maximtian.myapplication.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by MaximTian on 2016/6/7.
 */
public class Choosing_place extends Activity {

    private SimpleAdapter adapter;
    private GridView gridview;
    private GridView row;

    private String[] row_number = new String[]{"1", "2", "3", "4", "5", "6", "7", "8"};
/*    private String[] str = new String[] {
            "¡õ", "¡õ", "¡õ", "¡õ", "¡õ", "¡õ", "¡õ", "¡õ",
            "¡õ", "¡õ", "¡õ", "¡õ", "¡õ", "¡õ", "¡õ", "¡õ",
            "¡õ", "¡õ", "¡õ", "¡õ", "¡õ", "¡õ", "¡õ", "¡õ",
            "¡õ", "¡õ", "¡õ", "¡õ", "¡õ", "¡õ", "¡õ", "¡õ",
            "¡õ", "¡õ", "¡õ", "¡õ", "¡õ", "¡õ", "¡õ", "¡õ",
            "¡õ", "¡õ", "¡õ", "¡õ", "¡õ", "¡õ", "¡õ", "¡õ",
            "¡õ", "¡õ", "¡õ", "¡õ", "¡õ", "¡õ", "¡õ", "¡õ",
            "¡õ", "¡õ", "¡õ", "¡õ", "¡õ", "¡õ", "¡õ", "¡õ"
    };
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choosingplace_layout);
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
        for(int i = 0;i < 64; i++){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", R.drawable.chair);
            list.add(map);
        }
        return list;
    }

}
