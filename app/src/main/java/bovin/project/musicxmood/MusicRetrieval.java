package bovin.project.musicxmood;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.util.Log;
import android.webkit.MimeTypeMap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Bonny Haveliwala on 012 12 Mar 2016.
 */
public class MusicRetrieval {

    ArrayList<Music> musicArrayList;
    Context context;
    String sortOrder, selection, mimeTypeFromExtension;
    String[] selectionArgs, projection;
    //Bitmap albumArt;
    Long id, duration;
    String title, artist, path;
    Uri externalMusicUri;
    int titleColumn, artistColumn, idColumn, durationColumn, pathColumn;


    public MusicRetrieval(Context context){
        this.context = context;
        musicArrayList = new ArrayList<>();
        externalMusicUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        projection = new String[]{MediaStore.Audio.Media._ID, MediaStore.Audio.Media.TITLE,
                MediaStore.Audio.Media.ARTIST, MediaStore.Audio.Media.DURATION, MediaStore.Audio.Media.DATA};
        selection = MediaStore.Audio.Media.IS_MUSIC + "!=0 AND " +MediaStore.Files.FileColumns.MIME_TYPE+ "=?" ;
        sortOrder = MediaStore.Audio.Media.TITLE + " ASC";
        mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension("mp3");
        selectionArgs = new String[]{mimeTypeFromExtension};
    }

    public ArrayList<Music> getAllMusic(){

        ContentResolver musicResolver = context.getContentResolver();
        Cursor externalMusicCursor = musicResolver.query(externalMusicUri, projection, selection, selectionArgs, sortOrder);
        //MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();

        if(externalMusicCursor != null && externalMusicCursor.moveToFirst()){
            titleColumn = externalMusicCursor.getColumnIndex(MediaStore.Audio.Media.TITLE);
            artistColumn = externalMusicCursor.getColumnIndex(MediaStore.Audio.Media.ARTIST);
            idColumn = externalMusicCursor.getColumnIndex(MediaStore.Audio.Media._ID);
            durationColumn = externalMusicCursor.getColumnIndex(MediaStore.Audio.Media.DURATION);
            pathColumn = externalMusicCursor.getColumnIndex(MediaStore.Audio.Media.DATA);
            //int albumArtPathColumn = externalMusicCursor.getColumnIndex(MediaStore.Audio.Albums.ALBUM_ART);
            do {
                id = externalMusicCursor.getLong(idColumn);
                title = externalMusicCursor.getString(titleColumn);
                artist = externalMusicCursor.getString(artistColumn);
                duration = externalMusicCursor.getLong(durationColumn);
                path = externalMusicCursor.getString(pathColumn);
                //Log.i("MediaResolver", path);
                /*ediaMetadataRetriever.setDataSource(path);
                albumArtArray = mediaMetadataRetriever.getEmbeddedPicture();
                if(albumArtArray!=null)
                    albumArt = scaledAlbumArt(albumArtArray);
                else*/
                //albumArt = null;
                musicArrayList.add(new Music(context, id, title, artist, duration, null));
            }while(externalMusicCursor.moveToNext());
            externalMusicCursor.close();
        }
        externalMusicCursor.close();
        return musicArrayList;
    }

   /* public Bitmap scaledAlbumArt(byte[] data){
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inTempStorage = new byte[16*1024];
        options.inSampleSize = 4;
        return BitmapFactory.decodeByteArray(data, 0, data.length, options);
    }*/

    class MusicRetrievalASyncTask extends AsyncTask<Void, Void, ArrayList<Music>> {

        Activity activity = (Activity) context;

        @Override
        protected ArrayList<Music> doInBackground(Void... params) {
            musicArrayList = getAllMusic();
            return musicArrayList;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(ArrayList<Music> arrayList) {
            Intent i = new Intent(activity, MainActivity.class);
            i.putParcelableArrayListExtra("MusicArrayList", musicArrayList);
            activity.startActivity(i);
            activity.finish();
            super.onPostExecute(arrayList);
        }
    }
}
