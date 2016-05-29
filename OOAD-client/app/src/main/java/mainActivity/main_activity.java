package mainActivity;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TabHost;

import com.example.maximtian.myapplication.R;

import mainActivity.Movie_Activity;

/**
 * Created by MaximTian on 2016/5/22.
 */
public class main_activity extends TabActivity {

    private RadioGroup main_radiogroup;
    private RadioButton tab_movie, tab_theatre, tab_order, tab_personal;

    private TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        main_radiogroup = (RadioGroup) findViewById(R.id.main_radiogroup);
        tab_movie = (RadioButton) findViewById(R.id.tab_movie);
        tab_theatre = (RadioButton) findViewById(R.id.tab_theatre);
        tab_order = (RadioButton) findViewById(R.id.tab_order);
        tab_order = (RadioButton) findViewById(R.id.tab_personal);

        tabHost = getTabHost();
        tabHost.addTab(tabHost.newTabSpec("tag1").setIndicator("0").setContent(new Intent(this, Movie_Activity.class)));
        tabHost.addTab(tabHost.newTabSpec("tag2").setIndicator("1").setContent(new Intent(this, Theatre_Activity.class)));
        tabHost.addTab(tabHost.newTabSpec("tag3").setIndicator("2").setContent(new Intent(this, Order_Activity.class)));
        tabHost.addTab(tabHost.newTabSpec("tag4").setIndicator("3").setContent(new Intent(this, Personal_Activity.class)));

        checkListener checkradio = new checkListener();
        main_radiogroup.setOnCheckedChangeListener(checkradio);
    }

    public class checkListener implements RadioGroup.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(RadioGroup group, int flagId) {
            switch (flagId) {
                case R.id.tab_movie:
                    tabHost.setCurrentTab(0);
                    break;
                case R.id.tab_theatre:
                    tabHost.setCurrentTab(1);
                    break;
                case R.id.tab_order:
                    tabHost.setCurrentTab(2);
                    break;
                case R.id.tab_personal:
                    tabHost.setCurrentTab(3);
                    break;
            }
        }

    }

}