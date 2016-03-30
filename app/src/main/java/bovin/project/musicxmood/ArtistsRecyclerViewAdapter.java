package bovin.project.musicxmood;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Bonny Haveliwala on 030 30 Mar 2016.
 */
public class ArtistsRecyclerViewAdapter extends RecyclerView.Adapter<ArtistsRecyclerViewAdapter.ArtistsViewHolder> {

    Context context;
    ArrayList<Music> musicArrayList;
    ArrayList<String> artistArrayList;
    Set<String> artistSet;
    Music music;
    View itemView;

    public ArtistsRecyclerViewAdapter(Context context, ArrayList<Music> musicArrayList){
        this.context = context;
        this.musicArrayList = musicArrayList;
        artistSet = new TreeSet<>();
        this.artistArrayList = makeArtistArrayList();
    }

    @Override
    public ArtistsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.artists_row, parent,false);
        return new ArtistsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ArtistsViewHolder holder, int position) {
        music = musicArrayList.get(position);
        holder.titleOfArtist.setText(artistArrayList.get(position));
        holder.artistImage.setBackground(music.getAlbumArt(context, artistArrayList.get(position), null));
    }

    @Override
    public int getItemCount() {
        return artistArrayList.size();
    }

    class ArtistsViewHolder extends RecyclerView.ViewHolder {
        ImageView artistImage;
        TextView titleOfArtist;
        public ArtistsViewHolder(View itemView) {
            super(itemView);
            artistImage = (ImageView)itemView.findViewById(R.id.artistImage);
            titleOfArtist = (TextView)itemView.findViewById(R.id.titleOfArtist);
        }
    }

    ArrayList<String> makeArtistArrayList(){
        Music m;
        for(int i=0; i<musicArrayList.size(); i++) {
            m = musicArrayList.get(i);
            artistSet.add(m.getArtist());
        }
        artistArrayList = new ArrayList<>(artistSet);
        Collections.sort(artistArrayList);
        artistSet = null;
        return artistArrayList;
    }
}
