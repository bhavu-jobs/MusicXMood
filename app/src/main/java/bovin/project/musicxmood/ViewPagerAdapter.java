package bovin.project.musicxmood;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;

/**
 * Created by Bonny Haveliwala on 010 10 Mar 2016.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

    AllMusicFragment allMusicFragment;
    CharSequence Titles[];
    int numOfTabs;
    Context context;
    ArrayList<Music> musicArrayList;
    ArtistsFragment artistsFragment;

    public ViewPagerAdapter(Context context, FragmentManager fm, CharSequence Titles[], int numOfTabs, ArrayList<Music> musicArrayList){
        super(fm);
        this.Titles= Titles;
        this.numOfTabs=numOfTabs;
        this.context = context;
        this.musicArrayList = musicArrayList;

        allMusicFragment = new AllMusicFragment();
        allMusicFragment.setAllMusicArrayList(musicArrayList);

        artistsFragment = new ArtistsFragment(musicArrayList);
    }

    @Override
    public Fragment getItem(int position) {
        if(position==0){
            return allMusicFragment;
        }else {
            return artistsFragment;
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



