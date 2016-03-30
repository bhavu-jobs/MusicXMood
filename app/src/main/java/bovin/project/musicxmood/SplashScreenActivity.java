package bovin.project.musicxmood;

import android.app.Activity;
import android.os.Bundle;

public class SplashScreenActivity extends Activity {

    private static int SPLASH_TIME_OUT = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        new MusicRetrieval(this).new MusicRetrievalASyncTask().execute();

       /* new Handler().postDelayed(new Runnable(){
            public void run(){
                Intent i= new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        },SPLASH_TIME_OUT);*/
    }
}
