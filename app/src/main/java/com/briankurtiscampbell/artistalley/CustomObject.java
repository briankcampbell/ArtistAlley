package com.briankurtiscampbell.artistalley;

import android.location.Location;

/**
 * Created by Biarre on 7/10/2015.
 */
public class CustomObject {
    public Item entryItem;
    public String entryItemName;
    public String entryItemDescription;
    public int entryItemImage;
    public int entryItemWidth;
    public int entryItemHeight;
    public int entryItemPrice;
    public int entryItemCount;
    public Artist entryItemArtist;
    public Location entryLocation;
    public String entryLocationName;
    public String entryLocationAddress;
    public String entryLocationCity;
    public String entryLocationState;
    public int entryLocationZip;
    public String entryLocationPhone;
    public Artist entryArtist;
    public int entryArtistId;
    public String entryArtistName;
    public String entryArtistPhone;
    public String entryArtistEmail;
    public String entryArtistpassword;

    public CustomObject(){
    }

    public CustomObject(Item item){
        this.entryItem = item;
    }

    public CustomObject(Location location){
        this.entryLocation = location;
    }

    //Artist CustomObject Constructor
    public CustomObject(String name, String phone, String email, String password){
        this.entryArtistName = name;
        this.entryArtistPhone = phone;
        this.entryArtistEmail = email;
        this.entryArtistpassword = password;
    }

    //Artwork CustomObject Constructor
    public CustomObject(String name, String desc, int img, int width, int height, int price, int count){
        this.entryItemName = name;
        this.entryItemDescription = desc;
        this.entryItemImage = img;
        this.entryItemWidth = width;
        this.entryItemHeight = height;
        this.entryItemPrice = price;
        this.entryItemCount = count;
    }

    //Location CustomObject Constructor
    public CustomObject(String name, String address, String city, String state, int zip, String phone, Artist artist){
        this.entryLocationName = name;
        this.entryLocationAddress = address;
        this.entryLocationCity = city;
        this.entryLocationState = state;
        this.entryLocationZip = zip;
        this.entryLocationPhone = phone;
        this.entryArtist = artist;
    }
}

