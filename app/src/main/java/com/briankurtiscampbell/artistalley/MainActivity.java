package com.briankurtiscampbell.artistalley;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends Activity {
    public static String TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickLogin(View v) {

        Intent intent = new Intent(this, ArtistConListActivity.class);
        startActivity(intent);


    }

    public void onClickRegister(View v) {

        Intent intent = new Intent(this, NewArtistRegistrationActivity.class);
        startActivity(intent);

        Log.i("Group3", "I'm working");
    }
}
