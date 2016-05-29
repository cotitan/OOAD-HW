package mainActivity;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
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
public class Movie_Activity extends ListActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_layout);

        listView = getListView();
        SimpleAdapter adapter = new SimpleAdapter(this, getData(),
                R.layout.movie_item, new String[]{"img", "title", "info"},
                new int[]{R.id.movie_image, R.id.movie_title, R.id.movie_info});
        setListAdapter(adapter);
    }

    private List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("img", R.mipmap.ic_launcher);
        map.put("title", "AAA");
        map.put("info", "This is an apple");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("img", R.mipmap.ic_launcher);
        map.put("title", "BBB");
        map.put("info", "This is a banana");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("img", R.mipmap.ic_launcher);
        map.put("title", "CCC");
        map.put("info", "This is a cat");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("img", R.mipmap.ic_launcher);
        map.put("title", "DDD");
        map.put("info", "This is a dog");
        list.add(map);

        return list;
    }
}
