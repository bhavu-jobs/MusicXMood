package bovin.project.musicxmood;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.ogaclejapan.smarttablayout.SmartTabLayout;

import java.util.ArrayList;

/**
 * Created by Bonny Haveliwala on 009 9 Mar 2016.
 */
public class MainActivity extends AppCompatActivity{

    Toolbar toolbar;
    ViewPagerAdapter vpAdapter;
    CharSequence[] Titles={"All Music", "Frag2"};
    FragmentManager fm;
    ViewPager vp;
    SmartTabLayout tabs;
    ArrayList<Music> musicArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setContentView(R.layout.activity_main);
        fm = getSupportFragmentManager();

        Intent intent = getIntent();
        musicArrayList =  intent.getParcelableArrayListExtra("MusicArrayList");

        vpAdapter = new ViewPagerAdapter(this ,fm, Titles, Titles.length, musicArrayList);
        vp = (ViewPager)findViewById(R.id.mainViewPager);
        vp.setAdapter(vpAdapter);

        tabs = (SmartTabLayout) findViewById(R.id.mainViewPagerTabs);
        tabs.setDistributeEvenly(false);
        tabs.setCustomTabColorizer(new SmartTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.colorAccent);
            }
            @Override
            public int getDividerColor(int position) {
                return 0;
            }
        });

        tabs.setViewPager(vp);
    }
}
