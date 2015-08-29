package com.briankurtiscampbell.artistalley;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapterLocation extends ArrayAdapter<Location> {
    Context context;
    int layoutResourceId;
    ArrayList<Location> locations;

    public CustomAdapterLocation(Context context, int layoutResourceId, ArrayList<Location> locations){
        super(context, layoutResourceId, locations);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.locations = locations;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View row = convertView;
        LocationHolder holder;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new LocationHolder();
            holder.textEntryLocationId = (TextView) row.findViewById(R.id.lrlLocationId);
            holder.textEntryLocationName = (TextView)row.findViewById(R.id.lrlLocationName);
            holder.textEntryLocationAddress = (TextView)row.findViewById(R.id.lrlLocationAddress);
            holder.textEntryLocationCity = (TextView)row.findViewById(R.id.lrlLocationCity);
            holder.textEntryLocationState = (TextView)row.findViewById(R.id.lrlLocationState);
            holder.textEntryLocationZip = (TextView)row.findViewById(R.id.lrlLocationZip);
            holder.textEntryLocationPhone = (TextView)row.findViewById(R.id.lrlLocationPhone);

            row.setTag(holder);
        } else {
            holder = (LocationHolder)row.getTag();
        }

        Location location = locations.get(position);

        holder.textEntryLocationId.setText(location.getId());
        holder.textEntryLocationName.setText(location.getName());
        holder.textEntryLocationAddress.setText(location.getAddress());
        holder.textEntryLocationCity.setText(location.getCity());
        holder.textEntryLocationState.setText(location.getState());
        holder.textEntryLocationZip.setText(location.getZip());
        holder.textEntryLocationPhone.setText(location.getPhone());
/*
        Log.i(MainActivity.TAG, "CustomAdapterLocation - Location Name: " + location.getName() +
                "Location " + "locationID: " + location.getId());
*/        return row;
    }

    static class LocationHolder
    {
        TextView textEntryLocationId;
        TextView textEntryLocationName;
        TextView textEntryLocationAddress;
        TextView textEntryLocationCity;
        TextView textEntryLocationState;
        TextView textEntryLocationZip;
        TextView textEntryLocationPhone;
    }

}
