package com.briankurtiscampbell.artistalley;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ArtistConListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist_con_list);
    }

    public void onClick(View v) {

        Intent intent = new Intent(this, NewConActivity.class);
        startActivity(intent);
    }

}
