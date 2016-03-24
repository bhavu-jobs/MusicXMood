package bovin.project.musicxmood;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import java.io.Serializable;

/**
 * Created by Bonny Haveliwala on 012 12 Mar 2016.
 */
public class Music implements Parcelable {

    private long _ID;
    private String name;
    private String artist;
    private String mood;
    private long duration;
    private Drawable albumArt;
    Context context;
    private Bitmap albumArtBitmap;

    public Music(Parcel parcel){
        this._ID = parcel.readLong();
        this.name = parcel.readString();
        this.artist = parcel.readString();
        this.mood = parcel.readString();
        this.duration = parcel.readLong();
        this.albumArtBitmap = parcel.readParcelable(getClass().getClassLoader());
    }

    //@TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public Music(Context context, long _ID, String name, String artist, long duration, Bitmap albumArt){
        this.context = context;
        this._ID=_ID;
        this.name = name;
        this.artist = artist;
        this.mood = "<Undefined>";
        this.duration = duration;
        this.albumArtBitmap = albumArt;
    }

    public static final Creator<Music> CREATOR = new Creator<Music>() {
        @Override
        public Music createFromParcel(Parcel in) {
            return new Music(in);
        }

        @Override
        public Music[] newArray(int size) {
            return new Music[size];
        }
    };

    public void set_ID(int _ID) {
        this._ID = _ID;
    }

    public Drawable getAlbumArt(Context context, String name, Bitmap albumArtBitmap){
        if(albumArtBitmap != null) {
            this.albumArt = new BitmapDrawable(context.getResources(), albumArtBitmap);
        }else{
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                //Log.i("MediaResolver", name);
                this.albumArt = context.getDrawable(getAlbumArtLetter(name));
            }
            else
                this.albumArt = context.getResources().getDrawable(getAlbumArtLetter(name));
        }
        return albumArt;
    }

    public Bitmap getAlbumArtBitmap(){
        return albumArtBitmap;
    }

    public long get_ID() {
        return _ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public String getMood() {
        return mood;
    }

    public long getDuration() {
        return duration;
    }

    private int getAlbumArtLetter(String name){
        int i=0;
        char firstLetter = name.charAt(i);
        while(!(Character.isLetter(firstLetter)) && i < name.length()-1) {
            firstLetter = name.charAt(++i);
        }
        if(!(Character.isLetter(firstLetter))){
            return R.drawable.splash_screen_1_small;
        }
        /*while(!(Character.isAlphabetic(firstLetter)) && i < name.length()-1) {
            firstLetter = name.charAt(++i);
        }
        if(!(Character.isLetter(firstLetter))){
            return R.drawable.splash_screen_1_small;
        }*/
        switch(firstLetter){
            case 'a':
            case 'A':
                return R.drawable.a;
            case 'b':
            case 'B':
                return R.drawable.b;
            case 'c':
            case 'C':
                return R.drawable.c;
            case 'd':
            case 'D':
                return R.drawable.d;
            case 'e':
            case 'E':
                return R.drawable.e;
            case 'f':
            case 'F':
                return R.drawable.f;
            case 'g':
            case 'G':
                return R.drawable.g;
            case 'h':
            case 'H':
                return R.drawable.h;
            case 'i':
            case 'I':
                return R.drawable.i;
            case 'j':
            case 'J':
                return R.drawable.j;
            case 'k':
            case 'K':
                return R.drawable.k;
            case 'l':
            case 'L':
                return R.drawable.l;
            case 'm':
            case 'M':
                return R.drawable.m;
            case 'n':
            case 'N':
                return R.drawable.n;
            case 'o':
            case 'O':
                return R.drawable.o;
            case 'p':
            case 'P':
                return R.drawable.p;
            case 'q':
            case 'Q':
                return R.drawable.q;
            case 'r':
            case 'R':
                return R.drawable.r;
            case 's':
            case 'S':
                return R.drawable.s;
            case 't':
            case 'T':
                return R.drawable.t;
            case 'u':
            case 'U':
                return R.drawable.u;
            case 'v':
            case 'V':
                return R.drawable.v;
            case 'w':
            case 'W':
                return R.drawable.w;
            case 'x':
            case 'X':
                return R.drawable.x;
            case 'y':
            case 'Y':
                return R.drawable.y;
            case 'z':
            case 'Z':
                return R.drawable.z;
        }
        return R.drawable.splash_screen_1_small;
    }

    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(_ID);
        dest.writeString(name);
        dest.writeString(artist);
        dest.writeString(mood);
        dest.writeLong(duration);
        dest.writeParcelable(albumArtBitmap, flags);
    }
}