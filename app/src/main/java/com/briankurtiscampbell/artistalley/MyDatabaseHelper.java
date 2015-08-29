package com.briankurtiscampbell.artistalley;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "ArtAppDB";
    private static final String ARTISTS_TABLE_NAME = "Artists";
    private static final String ARTIST_ID = "ArtistID";
    private static final String ARTIST_PHONE = "ArtistPhone";
    private static final String ARTIST_PASSWORD = "ArtistPassword";
    private static final String ARTIST_NAME = "ArtistName";
    private static final String ARTIST_EMAIL = "ArtistEmail";
    private static final String LOCATIONS_TABLE_NAME = "Locations";
    private static final String LOCATION_ID = "ALocationID";
    private static final String LOCATION_NAME = "LocationAddress";
    private static final String LOCATION_ADDRESS = "LocationAddress";
    private static final String LOCATION_CITY = "LocationCity";
    private static final String LOCATION_STATE = "LocationState";
    private static final String LOCATION_PHONE = "LocationPhone";
    private static final String LOCATION_ZIP = "LocationZip";
    private static final String ARTWORK_ITEMS_TABLE_NAME = "ArtworkItems";
    private static final String ARTWORK_ITEM_ID = "ArtworkID";
    private static final String ARTWORK_ITEM_NAME = "ArtworkName";
    private static final String ARTWORK_ITEM_DESCRIPTION = "ArtworkDescription";
    private static final String ARTWORK_ITEM_IMAGE = "ArtworkImage";
    private static final String ARTWORK_ITEM_HEIGHT = "ArtworkHeight";
    private static final String ARTWORK_ITEM_WIDTH = "ArtworkWidth";
    private static final String ARTWORK_ITEM_PRICE = "ArtworkPrice";
    private static final String ARTWORK_ITEM_COUNT = "ArtworkCount";
    private static final String CREATE_ARTISTS_TABLE = "CREATE TABLE " + ARTISTS_TABLE_NAME + " ("
            + ARTIST_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + ARTIST_NAME + " TEXT, "
            + ARTIST_PHONE + " TEXT, "
            + ARTIST_EMAIL + " TEXT, "
            + ARTIST_PASSWORD + " TEXT"
            + ");";
    private static final String CREATE_LOCATIONS_TABLE_NAME = "CREATE TABLE " + LOCATIONS_TABLE_NAME + " ("
            + LOCATION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + LOCATION_NAME + " TEXT, "
            + LOCATION_ADDRESS + " TEXT, "
            + LOCATION_CITY + " TEXT, "
            + LOCATION_STATE + " TEXT, "
            + LOCATION_ZIP + " INTEGER, "
            + LOCATION_PHONE + " TEXT"
            + ");";
    private static final String CREATE_ARTWORK_ITEMS_TABLE_NAME = "CREATE TABLE " + ARTWORK_ITEMS_TABLE_NAME + " ("
            + ARTWORK_ITEM_ID + " INTEGER PRIMARY KEY, "
            + ARTIST_ID + " INTEGER, "
            + ARTWORK_ITEM_NAME + " TEXT, "
            + ARTWORK_ITEM_DESCRIPTION + " TEXT, "
            + ARTWORK_ITEM_IMAGE + " INTEGER, "
            + ARTWORK_ITEM_HEIGHT + " INTEGER, "
            + ARTWORK_ITEM_WIDTH + " INTEGER, "
            + ARTWORK_ITEM_PRICE + " REAL, "
            + ARTWORK_ITEM_COUNT + " INTEGER"
            + ");";

    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(CREATE_ARTISTS_TABLE);
            db.execSQL(CREATE_LOCATIONS_TABLE_NAME);
            db.execSQL(CREATE_ARTWORK_ITEMS_TABLE_NAME);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {

    }

    //artists table
    public void addArtist(Artist artist){
        ContentValues artistValues = new ContentValues();

        artistValues.put(ARTIST_NAME, artist.getName());
        artistValues.put(ARTIST_PHONE, artist.getPhone());
        artistValues.put(ARTIST_EMAIL, artist.getEmail());
        artistValues.put(ARTIST_PASSWORD, artist.getPassword());
        //Log.i(MainActivity.TAG, "MyDatabaseHelper: Artist Values = " + artistValues);

        //Inserting values into database
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ARTISTS_TABLE_NAME, null, artistValues);
        db.close();

        Log.i(MainActivity.TAG, "MyDatabaseHelper: Location " + artist.getId() + " " + artist.getName() + " inserted into the database");
    }

    public ArrayList<Artist> getArtists(){
        ArrayList<Artist> artists = new ArrayList<>();

        //Accessing and querying database.
        String query = "SELECT * FROM " + ARTISTS_TABLE_NAME + ";";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        cursor.moveToFirst();

        //Populating ArrayList items with database entries.
        while(!cursor.isAfterLast()){
            Artist artist = new Artist();
            artist.setId(cursor.getInt(0));
            artist.setName(cursor.getString(1));
            artist.setPhone(cursor.getString(2));
            artist.setEmail(cursor.getString(3));
            artist.setPassword(cursor.getString(4));

            artists.add(artist);

            cursor.moveToNext();
        }

        //Closing query and database out.
        cursor.close();
        db.close();

        return artists;
    }

    public void editArtist(Artist artist){
        ContentValues artistValues = new ContentValues();

        artistValues.put(ARTIST_ID, artist.getId());
        artistValues.put(ARTIST_NAME, artist.getName());
        artistValues.put(ARTIST_PHONE, artist.getPhone());
        artistValues.put(ARTIST_EMAIL, artist.getEmail());
        artistValues.put(ARTIST_PASSWORD, artist.getPassword());

        Log.i(MainActivity.TAG, "MyDatabaseHelper: Location Values = " + artistValues);

        //Inserting values into database
        SQLiteDatabase db = this.getWritableDatabase();
        db.replace(ARTISTS_TABLE_NAME, null, artistValues);
        db.close();

        Log.i(MainActivity.TAG, "MyDatabaseHelper: Location record replaced in the database");


    }

    public void removeArtist(Artist artist){
        SQLiteDatabase db = this.getWritableDatabase();

        int result = db.delete(ARTISTS_TABLE_NAME, ARTIST_ID + "=" + artist.getId(), null);

        if(result > 0){
            Log.i(MainActivity.TAG, result + " rows removed");
        }
    }

    //locations table
    public void addLocation(Location location){
        ContentValues LocationValues = new ContentValues();

        LocationValues.put(LOCATION_NAME, location.getName());
        LocationValues.put(LOCATION_ADDRESS, location.getAddress());
        LocationValues.put(LOCATION_CITY, location.getCity());
        LocationValues.put(LOCATION_STATE, location.getState());
        LocationValues.put(LOCATION_ZIP, location.getZip());
        LocationValues.put(LOCATION_PHONE, location.getPhone());
        //Log.i(MainActivity.TAG, "MyDatabaseHelper: Item Values = " + itemValues);

        //Inserting values into database
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(LOCATIONS_TABLE_NAME, null, LocationValues);
        db.close();

        Log.i(MainActivity.TAG, "MyDatabaseHelper: Location " + location.getId() + " " + location.getName() + " inserted into the database");
    }

    public ArrayList<Location> getLocations(){
        ArrayList<Location> locations = new ArrayList<>();

        //Accessing and querying database.
        String query = "SELECT * FROM " + LOCATIONS_TABLE_NAME + ";";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        cursor.moveToFirst();

        //Populating ArrayList items with database entries.
        while(!cursor.isAfterLast()){
            Location location = new Location();
            location.setId(cursor.getInt(0));
            location.setName(cursor.getString(1));
            location.setAddress(cursor.getString(2));
            location.setCity(cursor.getString(3));
            location.setState(cursor.getString(4));
            location.setZip(cursor.getInt(5));
            location.setPhone(cursor.getString(6));

            locations.add(location);

            cursor.moveToNext();
        }

        //Closing query and database out.
        cursor.close();
        db.close();

        return locations;
    }

    public void editLocation(Location location){
        ContentValues locationValues = new ContentValues();

        locationValues.put(LOCATION_ID, location.getId());
        locationValues.put(LOCATION_NAME, location.getName());
        locationValues.put(LOCATION_ADDRESS, location.getAddress());
        locationValues.put(LOCATION_CITY, location.getCity());
        locationValues.put(LOCATION_STATE, location.getState());
        locationValues.put(LOCATION_ZIP, location.getZip());
        locationValues.put(LOCATION_PHONE, location.getPhone());

        Log.i(MainActivity.TAG, "MyDatabaseHelper: Location Values = " + locationValues);

        //Inserting values into database
        SQLiteDatabase db = this.getWritableDatabase();
        db.replace(LOCATIONS_TABLE_NAME, null, locationValues);
        db.close();

        Log.i(MainActivity.TAG, "MyDatabaseHelper: Location record replaced in the database");
    }

    public void removeLocation(Location location){
        SQLiteDatabase db = this.getWritableDatabase();

        int result = db.delete(LOCATIONS_TABLE_NAME, LOCATION_ID + "=" + location.getId(), null);

        if(result > 0){
            Log.i(MainActivity.TAG, result + " rows removed");
        }
    }

    //items table
    public void addItem(Item item){
        ContentValues itemValues = new ContentValues();
        String artistId = String.valueOf(item.getArtist().getId());
        String itemId = String.valueOf(item.getId());
        String artworkItemId = artistId + itemId;

        itemValues.put(ARTWORK_ITEM_ID, Integer.parseInt(artworkItemId));
        itemValues.put(ARTWORK_ITEM_NAME, item.getName());
        itemValues.put(ARTWORK_ITEM_DESCRIPTION, item.getDescription());
        itemValues.put(ARTWORK_ITEM_IMAGE, item.getImageId());
        itemValues.put(ARTWORK_ITEM_HEIGHT, item.getHeight());
        itemValues.put(ARTWORK_ITEM_WIDTH, item.getWidth());
        itemValues.put(ARTWORK_ITEM_PRICE, item.getPrice());
        itemValues.put(ARTWORK_ITEM_COUNT, item.getCount());
        itemValues.put(ARTIST_ID, item.getArtist().getId());

        if(item.getArtist() != null) {
            itemValues.put(ARTIST_ID, item.getArtist().getId());
        }

        //Log.i(MainActivity.TAG, "MyDatabaseHelper: Item Values = " + itemValues);

        //Inserting values into database
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ARTWORK_ITEMS_TABLE_NAME, null, itemValues);
        db.close();

        Log.i(MainActivity.TAG, "MyDatabaseHelper: Item " + item.getId() + " " + item.getName() + " inserted into the database");
    }

    public ArrayList<Item> getItems(){
        ArrayList<Item> items = new ArrayList<>();

        //Accessing and querying database.
        String query = "SELECT * FROM " + ARTWORK_ITEMS_TABLE_NAME + ";";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        cursor.moveToFirst();

        //Populating ArrayList items with database entries.
        while(!cursor.isAfterLast()){
            Item item = new Item();
            item.setId(cursor.getInt(0));
            item.setName(cursor.getString(1));
            item.setDescription(cursor.getString(2));
            item.setImageId(cursor.getInt(3));
            item.setHeight(cursor.getInt(4));
            item.setWidth(cursor.getInt(5));
            item.setPrice(cursor.getDouble(6));
            item.setCount(cursor.getInt(7));
            item.setArtist(getArtists().get(cursor.getInt(8)));

            if(item.getId() <= -1){
                item.setId(items.size());
                editItem(item);
            }

            items.add(item);

            cursor.moveToNext();
        }

        //Closing query and database out.
        cursor.close();
        db.close();

        return items;
    }

    public void editItem(Item item){
        ContentValues itemValues = new ContentValues();
        ContentValues locationValues = new ContentValues();

        itemValues.put(ARTWORK_ITEM_ID, item.getId());
        itemValues.put(ARTWORK_ITEM_NAME, item.getName());
        itemValues.put(ARTWORK_ITEM_DESCRIPTION, item.getDescription());
        itemValues.put(ARTWORK_ITEM_IMAGE, item.getImageId());
        itemValues.put(ARTWORK_ITEM_HEIGHT, item.getHeight());
        itemValues.put(ARTWORK_ITEM_WIDTH, item.getHeight());
        itemValues.put(ARTWORK_ITEM_PRICE, item.getPrice());
        itemValues.put(ARTWORK_ITEM_COUNT, item.getCount());
        itemValues.put(ARTIST_ID, item.getArtist().getId());

        Log.i(MainActivity.TAG, "MyDatabaseHelper: Item Values = " + itemValues);
        Log.i(MainActivity.TAG, "MyDatabaseHelper: Location Values = " + locationValues);

        //Inserting values into database
        SQLiteDatabase db = this.getWritableDatabase();
        db.replace(ARTWORK_ITEMS_TABLE_NAME, null, itemValues);
        db.close();

        Log.i(MainActivity.TAG, "MyDatabaseHelper: Item record replaced in the database");
    }

    public void removeItem(Item item){
        SQLiteDatabase db = this.getWritableDatabase();

        int result = db.delete(ARTWORK_ITEMS_TABLE_NAME, ARTWORK_ITEM_ID + "=" + item.getId(), null);

        if(result > 0){
            Log.i(MainActivity.TAG, result + " rows removed");
        }
    }
}


