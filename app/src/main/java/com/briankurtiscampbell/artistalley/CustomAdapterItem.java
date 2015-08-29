package com.briankurtiscampbell.artistalley;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapterItem extends ArrayAdapter<Item> {
    Context context;
    int layoutResourceId;
    ArrayList<Item> data = null;

    public CustomAdapterItem(Context context, int layoutResourceId, ArrayList<Item> data){
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View row = convertView;
        ItemHolder holder;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new ItemHolder();
            holder.textEntryItemName = (TextView)row.findViewById(R.id.lriItemName);
            holder.textEntryItemDesc = (TextView)row.findViewById(R.id.lriItemDesc);
            holder.imgEntryItemImage = (ImageView)row.findViewById(R.id.lriItemImage);
            holder.textEntryItemSize = (TextView)row.findViewById(R.id.lriItemSize);
            holder.textEntryItemPrice = (TextView)row.findViewById(R.id.lriItemPrice);
            holder.textEntryItemCount = (TextView)row.findViewById(R.id.lriItemCount);
            row.setTag(holder);
        }
        else
        {
            holder = (ItemHolder)row.getTag();
        }

        Item item = data.get(position);

        holder.textEntryItemName.setText(item.getName());
        holder.textEntryItemDesc.setText(item.getDescription());
        holder.imgEntryItemImage.setBackgroundResource(item.getImageId());
        holder.textEntryItemSize.setText(item.getWidth() + "x" + item.getHeight());
        holder.textEntryItemPrice.setText(String.valueOf(item.getPrice()));
        holder.textEntryItemCount.setText(String.valueOf(item.getCount()));

        return row;
    }

    static class ItemHolder
    {
        TextView textEntryItemName;
        TextView textEntryItemDesc;
        ImageView imgEntryItemImage;
        TextView textEntryItemSize;
        TextView textEntryItemPrice;
        TextView textEntryItemCount;
    }

}
