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
public class AllMusicRecyclerViewAdapter extends RecyclerView.Adapter<AllMusicRecyclerViewAdapter.AllMusicViewHolder>{

    Context context;
    Music music;

    class AllMusicViewHolder extends RecyclerView.ViewHolder{

        ImageView rowImage;
        TextView titleOfMusic;
        TextView nameOfArtist;
        TextView moodOfMusic;

        public AllMusicViewHolder(View itemView) {
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
    public AllMusicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.all_music_row, parent, false);
        return new AllMusicViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AllMusicViewHolder holder, int position) {
        music = musicArrayList.get(position);
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
