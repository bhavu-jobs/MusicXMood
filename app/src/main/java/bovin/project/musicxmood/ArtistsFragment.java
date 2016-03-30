package bovin.project.musicxmood;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Array;
import java.util.ArrayList;

import xyz.danoz.recyclerviewfastscroller.vertical.VerticalRecyclerViewFastScroller;

/**
 * Created by Bonny Haveliwala on 010 10 Mar 2016.
 */
public class ArtistsFragment extends Fragment {

    Context context;
    RecyclerView artistRecyclerView;
    ArtistsRecyclerViewAdapter artistsRecyclerViewAdapter;
    ArrayList<Music> musicArrayList;
    VerticalRecyclerViewFastScroller artistFastScroller;

    public ArtistsFragment(ArrayList<Music> musicArrayList){
        this.musicArrayList = musicArrayList;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        ViewGroup v = (ViewGroup)inflater.inflate(R.layout.artists_fragment, container, false);
        artistRecyclerView = (RecyclerView) v.findViewById(R.id.artistsRecyclerView);
        artistRecyclerView.setAdapter(artistsRecyclerViewAdapter);
        artistRecyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));

        artistFastScroller = (VerticalRecyclerViewFastScroller)v.findViewById(R.id.artistsFastScroller);
        artistFastScroller.setRecyclerView(artistRecyclerView);
        artistRecyclerView.addOnScrollListener(artistFastScroller.getOnScrollListener());

        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        artistsRecyclerViewAdapter = new ArtistsRecyclerViewAdapter(context, musicArrayList);
        super.onCreate(savedInstanceState);
    }

    public void setAllMusicArrayList(ArrayList<Music> allMusicArrayList){
        this.musicArrayList = allMusicArrayList;
    }

}
