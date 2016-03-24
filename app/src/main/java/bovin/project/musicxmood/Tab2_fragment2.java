package bovin.project.musicxmood;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Bonny Haveliwala on 010 10 Mar 2016.
 */
public class Tab2_fragment2 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        ViewGroup v = (ViewGroup)inflater.inflate(R.layout.artists_fragment, container, false);
        return v;
    }
}
