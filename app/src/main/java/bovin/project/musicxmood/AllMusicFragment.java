package bovin.project.musicxmood;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import xyz.danoz.recyclerviewfastscroller.vertical.VerticalRecyclerViewFastScroller;


/**
 * Created by Bonny Haveliwala on 010 10 Mar 2016.
 */
public class AllMusicFragment extends Fragment {

    private Context context;
    private AllMusicRecyclerViewAdapter allMusicAdapter;
    private ArrayList<Music> allMusicArrayList;
    private LinearLayoutManager linearLayoutManager;
    private VerticalRecyclerViewFastScroller fastScroller;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        allMusicAdapter = new AllMusicRecyclerViewAdapter(context, allMusicArrayList);
        linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View allSongsFragmentView = inflater.inflate(R.layout.all_music_fragment, container, false);

        RecyclerView allMusicRecyclerView = (RecyclerView) allSongsFragmentView.findViewById(R.id.allMusicRecyclerView);
        fastScroller = (VerticalRecyclerViewFastScroller) allSongsFragmentView.findViewById(R.id.fastScroller);

        allMusicRecyclerView.setAdapter(allMusicAdapter);
        allMusicRecyclerView.setLayoutManager(linearLayoutManager);
        fastScroller.setRecyclerView(allMusicRecyclerView);
        allMusicRecyclerView.addOnScrollListener(fastScroller.getOnScrollListener());
        return allSongsFragmentView;
    }

    public void setAllMusicArrayList(ArrayList<Music> allMusicArrayList) {
        this.allMusicArrayList = allMusicArrayList;
    }

}
