package com.sparks.feliz;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;

public class SplashActivity extends Activity {

	private final int SPLASH_DISPLAY_LENGHT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


	        /* New Handler to start the Menu-Activity
	         * and close this Splash-Screen after some seconds.*/
	        new Handler().postDelayed(new Runnable(){
	            @Override
	            public void run() {
	                /* Create an Intent that will start the Menu-Activity. */
	                Intent mainIntent = new Intent(SplashActivity.this, FelizActivity.class);
	                SplashActivity.this.startActivity(mainIntent);
	                SplashActivity.this.finish();
	            }
	        }, SPLASH_DISPLAY_LENGHT);
	        
        
    }

}
