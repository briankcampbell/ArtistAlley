package com.briankurtiscampbell.artistalley;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Biarre on 7/10/2015.
 */
public class CustomAdapterArtist extends ArrayAdapter<Artist> {
    Context context;
    int layoutResourceId;
    ArrayList<Artist> artists = null;
    public ArtistConListActivity artistConListActivity;
    public Activity activity = artistConListActivity;
    
    public CustomAdapterArtist(Context context, int layoutResourceId, ArrayList<Artist> artists){
        super(context, layoutResourceId, artists);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.artists = artists;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View row = convertView;
        LocationHolder holder = null;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new LocationHolder();
            //holder.textEntryArtistName = (TextView)row.findViewById(R.id.artistName);
            //holder.textEntryArtistPhone = (TextView)row.findViewById(R.id.artistPhone);

            row.setTag(holder);
        }
        else
        {
            holder = (LocationHolder)row.getTag();
        }

        final Artist artist = artists.get(position);

        String strPhone = String.valueOf(artist.getPhone());

        holder.textEntryArtistName.setText(artist.getName());
        holder.textEntryArtistPhone.setText(strPhone);
/*
        //setOnclickListeners
        final MyDatabaseHelper myHelper = new MyDatabaseHelper(context);

        //final TextView artistName = (TextView) convertView.findViewById(R.id.artistName);
        //final TextView artistPhone = (TextView) convertView.findViewById(R.id.artistPhone);

        holder.textEntryArtistName.setText(artist.getName());
        holder.textEntryArtistPhone.setText(String.valueOf(artist.getPhone()));

        final View flistEditArtistBox = activity.findViewById(R.id.flistEditArtistBox);
        final View btnClear = activity.findViewById(R.id.flistEditArtistClearBtn);
        final View btnAdd = activity.findViewById(R.id.flistEditArtistAddBtn);
        final View btnEdit = activity.findViewById(R.id.flistEditArtistEditBtn);
        final View btnRemove = activity.findViewById(R.id.flistEditArtistRemoveBtn);
        final View btnCancel = activity.findViewById(R.id.flistEditArtistCancelBtn);
        final EditText editArtistName = (EditText) activity.findViewById(R.id.flistEditArtistName);
        final EditText editArtistPhone = (EditText) activity.findViewById(R.id.flistEditArtistPhone);
        final ListView artistsList = (ListView) activity.findViewById(R.id.artistsList);

        convertView.setOnLongClickListener(new View.OnLongClickListener() {


            @Override
            public boolean onLongClick(View v) {
                editArtistName.setText(artist.getName());
                editArtistPhone.setText(String.valueOf(artist.getPhone()));

                Log.i(MainActivity.TAG, "flistEditArtist: ArtistId = " + artist.getId());
                Log.i(MainActivity.TAG, "flistEditArtist: Name = " + artist.getName());
                Log.i(MainActivity.TAG, "flistEditArtist: Phone = " + artist.getPhone());

                // change the visibility mode of the TextView
                if (flistEditArtistBox.getVisibility() == View.GONE) {
                    flistEditArtistBox.setVisibility(View.VISIBLE);
                    flistEditArtistBox.setBackgroundColor(Color.DKGRAY);
                    artistsList.setVisibility(View.GONE);


                } else {
                    artistsList.setVisibility(View.VISIBLE);
                    flistEditArtistBox.setVisibility(View.GONE);
                }

                return false;
            }
        });
*/
        return row;
    }

    static class LocationHolder
    {
        TextView textEntryArtistName;
        TextView textEntryArtistPhone;

    }

}
