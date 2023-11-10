package com.example.myapplication;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;

public class PokeDatabase extends ContentProvider {

    public final static String DBNAME = "NameDatabase";

    protected static final class MainDatabaseHelper extends SQLiteOpenHelper {
        MainDatabaseHelper(Context context) {
            super(context, DBNAME, null, 1);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(SQL_CREATE_MAIN);
        }
        @Override
        public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        }
    };


    public final static String TABLE_POKEDAT = "pokemon";
    public final static String COLUMN_POKENAME = "pokename";
    public final static String COLUMN_POKENATNUM = "lastname";
    public final static String COLUMN_POKESPECIES = "pokespec";
    public final static String COLUMN_POKEGEN = "pokegender";
    public final static String COLUMN_POKEHEIGHT = "pokeheight";
    public final static String COLUMN_POKEWEIGHT = "pokeweight";
    public final static String COLUMN_POKELEVEL = "pokelevel";
    public final static String COLUMN_POKEHP = "pokehp";
    public final static String COLUMN_POKEATTACK = "pokeattack";
    public final static String COLUMN_POKEDEFENSE = "pokedefense";

    public static final String AUTHORITY = "com.mobile.provider";
    public static final Uri CONTENT_URI = Uri.parse(
            "content://" + AUTHORITY +"/" + TABLE_POKEDAT);

    private static UriMatcher sUriMatcher;

    private MainDatabaseHelper mOpenHelper;

    private static final String SQL_CREATE_MAIN = "CREATE TABLE " +
            TABLE_POKEDAT +  // Table's name
            "(" +               // The columns in the table
            " _ID INTEGER PRIMARY KEY, " +
            COLUMN_POKENAME +
            " TEXT," +
            COLUMN_POKENATNUM +
            " TEXT," +
            COLUMN_POKESPECIES +
            " TEXT," +
            COLUMN_POKEGEN +
            " TEXT," +
            COLUMN_POKEHEIGHT +
            " TEXT," +
            COLUMN_POKEWEIGHT +
            " TEXT," +
            COLUMN_POKELEVEL +
            " TEXT," +
            COLUMN_POKEHP +
            " TEXT," +
            COLUMN_POKEATTACK +
            " TEXT," +
            COLUMN_POKEDEFENSE +
            " TEXT)";


    public PokeDatabase() {

    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return mOpenHelper.getWritableDatabase().delete(TABLE_POKEDAT, selection, selectionArgs);
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        String pname = values.getAsString(COLUMN_POKENAME).trim();
        String pnatnum = values.getAsString(COLUMN_POKENATNUM).trim();
        String pspecies = values.getAsString(COLUMN_POKESPECIES).trim();
        String pgen = values.getAsString(COLUMN_POKEGEN).trim();
        String pheight = values.getAsString(COLUMN_POKEHEIGHT).trim();
        String pweight =  values.getAsString(COLUMN_POKEWEIGHT).trim();
        String plevel = values.getAsString(COLUMN_POKELEVEL).trim();
        String php = values.getAsString(COLUMN_POKEHP).trim();
        String pattack = values.getAsString(COLUMN_POKEATTACK).trim();
        String pdefense = values.getAsString(COLUMN_POKEDEFENSE).trim();

        if (pname.equals(""))
            return null;

        if (pnatnum.equals(""))
            return null;

        if (pspecies.equals(""))
            return null;

        if (pgen.equals(""))
            return null;

        if (pheight.equals(""))
            return null;

        if (pweight.equals(""))
            return null;

        if (plevel.equals(""))
            return null;

        if (php.equals(""))
            return null;

        if (pattack.equals(""))
            return null;

        if (pdefense.equals(""))
            return null;

        long id = mOpenHelper.getWritableDatabase().insert(TABLE_POKEDAT, null, values);

        return Uri.withAppendedPath(CONTENT_URI, "" + id);
    }

    @Override
    public boolean onCreate() {
        mOpenHelper = new MainDatabaseHelper(getContext());
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        return mOpenHelper.getReadableDatabase().query(TABLE_POKEDAT, projection, selection, selectionArgs,
                null, null, sortOrder);
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        return mOpenHelper.getWritableDatabase().update(TABLE_POKEDAT, values, selection, selectionArgs);
    }
}
