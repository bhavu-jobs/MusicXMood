package bovin.project.musicxmood;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Bonny Haveliwala on 012 12 Mar 2016.
 */
public class AllMusicRecyclerViewAdapter extends RecyclerView.Adapter<AllMusicRecyclerViewAdapter.allMusicViewHolder>{

    Context context;

    class allMusicViewHolder extends RecyclerView.ViewHolder{

        ImageView rowImage;
        TextView titleOfMusic;
        TextView nameOfArtist;
        TextView moodOfMusic;

        public allMusicViewHolder(View itemView) {
            super(itemView);
            rowImage = (ImageView) itemView.findViewById(R.id.rowImage);
            titleOfMusic = (TextView)itemView.findViewById(R.id.titleOfMusic);
            nameOfArtist = (TextView)itemView.findViewById(R.id.nameOfArtist);
            moodOfMusic = (TextView)itemView.findViewById(R.id.moodOfMusic);
            rowImage = (ImageView)itemView.findViewById(R.id.rowImage);
            titleOfMusic.setSelected(true);
        }
    }

    ArrayList<Music> musicArrayList;

    public AllMusicRecyclerViewAdapter(Context context, ArrayList<Music> musicArrayList){
        this.context = context;
        this.musicArrayList = musicArrayList;
    }

    @Override
    public allMusicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.all_music_row, parent, false);
        return new allMusicViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(allMusicViewHolder holder, int position) {
        Music music = musicArrayList.get(position);
        holder.titleOfMusic.setText(music.getName());
        holder.nameOfArtist.setText(music.getArtist());
        holder.moodOfMusic.setText(music.getMood());
        holder.rowImage.setBackground(music.getAlbumArt(context, music.getName(), music.getAlbumArtBitmap()));
    }

    @Override
    public int getItemCount() {
        return musicArrayList.size();
    }
}
