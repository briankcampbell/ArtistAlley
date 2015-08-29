package com.briankurtiscampbell.artistalley;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Item implements Parcelable {
    private int id;
    private String name;
    private String description;
    private int imageId;
    private int height;
    private int width;
    private double price;
    private int count;
    private Artist artist;
    private int artistId = artist.getId();

    public Item(ArrayList<Item> children, ArrayList<Item> newList){

    }

    public Item() {

    }

    public Item(int id, String name, Artist artist) {
        this.id = id;
        this.name = name;
        this.artist = artist;
    }

    public Item(int id, String name, String description, int imageId, int height, int width, double price, int count, int artistId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageId = imageId;
        this.height = height;
        this.width = width;
        this.price = price;
        this.count = count;
        this.artistId = artistId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeString(description);
        parcel.writeInt(imageId);
        parcel.writeInt(height);
        parcel.writeInt(width);
        parcel.writeDouble(price);
        parcel.writeInt(count);
        parcel.writeInt(artist.getId());
    }

    public Item(Parcel input){
        this.id = input.readInt();
        this.name = input.readString();
        this.description = input.readString();
        this.imageId = input.readInt();
        this.height = input.readInt();
        this.width = input.readInt();
        this.price = input.readDouble();
        this.count = input.readInt();
        this.artistId = input.readInt();
    }

    public static final Creator<Item> CREATOR = new Creator<Item>(){

        @Override
        public Item createFromParcel(Parcel source) {
            return new Item(source);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };
}
