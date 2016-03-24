package bovin.project.musicxmood;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class SplashScreenActivity extends Activity {

    private static int SPLASH_TIME_OUT = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        MusicRetrieval musicRetrieval = new MusicRetrieval(this);
        MusicRetrieval.MusicRetrievalASyncTask aSyncTask = musicRetrieval.new MusicRetrievalASyncTask();
        aSyncTask.execute();

       /* new Handler().postDelayed(new Runnable(){
            public void run(){
                Intent i= new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        },SPLASH_TIME_OUT);*/
    }
}
