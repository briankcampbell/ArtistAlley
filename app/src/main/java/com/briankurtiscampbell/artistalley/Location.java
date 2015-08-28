package com.briankurtiscampbell.artistalley;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Biarre on 7/14/2015.
 */
public class Location implements Parcelable {
    private int id;
    private String name;
    private String address;
    private String city;
    private String state;
    private int zip;
    private String phone;

    public Location() {
    }

    public Location(int id, String name, String address, String city, String state, int zip, String phone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeString(address);
        parcel.writeString(city);
        parcel.writeString(state);
        parcel.writeInt(zip);
        parcel.writeString(phone);

    }

    public Location(Parcel input){
        this.id = input.readInt();
        this.name = input.readString();
        this.address = input.readString();
        this.city = input.readString();
        this.state = input.readString();
        this.zip = input.readInt();
        this.phone = input.readString();
    }

    public static final Creator<Location> CREATOR = new Creator<Location>(){

        @Override
        public Location createFromParcel(Parcel source) {
            return new Location(source);
        }

        @Override
        public Location[] newArray(int size) {
            return new Location[size];
        }
    };
}
