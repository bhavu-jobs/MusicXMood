package bovin.project.musicxmood;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import java.sql.Blob;
import java.util.ArrayList;

/**
 * Created by Bonny Haveliwala on 010 10 Mar 2016.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

    AllMusicFragment AllMusicFragment;
    CharSequence Titles[];
    int numOfTabs;
    Context context;
    ArrayList<Music> musicArrayList;

    public ViewPagerAdapter(Context context, FragmentManager fm, CharSequence Titles[], int numOfTabs, ArrayList<Music> musicArrayList){
        super(fm);
        this.Titles= Titles;
        this.numOfTabs=numOfTabs;
        this.context = context;
        AllMusicFragment = new AllMusicFragment();
        this.musicArrayList = musicArrayList;
        AllMusicFragment.setAllMusicArrayList(musicArrayList);
    }

    @Override
    public Fragment getItem(int position) {
        if(position==0){
            return AllMusicFragment;
        }else {
            return new Tab2_fragment2();
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return Titles[position];
    }

}



