package com.upversionlab.hstracker.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import com.upversionlab.hstracker.deck.CreateDeckActivity;
import com.upversionlab.hstracker.model.DeckContract.DeckColumns;

/**
 * Created by rborcat on 11/24/2016.
 */
public class DeckDbHelper extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "DeckDb.db";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + DeckColumns.TABLE_NAME + "(" +
                    DeckColumns._ID + " INTEGER PRIMARY KEY," +
                    DeckColumns.COLUMN_NAME_NAME + " TEXT," +
                    DeckColumns.COLUMN_NAME_CLASS + " TEXT" +
                    ")";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + DeckColumns.TABLE_NAME;

    public DeckDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public static long createDeck(CreateDeckActivity activity, String deckName, String deckClass) {
        DeckDbHelper dbHelper = new DeckDbHelper(activity);
        // Gets the data repository in write mode
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(DeckColumns.COLUMN_NAME_NAME, deckName);
        values.put(DeckColumns.COLUMN_NAME_CLASS, deckClass);

        // Insert the new row, returning the primary key value of the new row
        return db.insert(
                DeckColumns.TABLE_NAME,
                null,
                values);
    }

    public static Deck readDeckById(Context context, Integer deckId) {
        Deck deck = null;
        DeckDbHelper dbHelper = new DeckDbHelper(context);

        SQLiteDatabase db = dbHelper.getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                DeckColumns._ID,
                DeckColumns.COLUMN_NAME_NAME,
                DeckColumns.COLUMN_NAME_CLASS
        };

        String whereColumns = DeckColumns._ID + "= ?";

        String[] whereValues = {
                deckId.toString()
        };

        Cursor cursor = db.query(
                DeckColumns.TABLE_NAME, // The table to query
                projection,                 // The columns to return
                whereColumns,               // The columns for the WHERE clause
                whereValues,                // The values for the WHERE clause
                null,                       // don't group the rows
                null,                       // don't filter by row groups
                null                        // The sort order
        );

        for(cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
            Integer id = cursor.getInt(cursor.getColumnIndexOrThrow(DeckColumns._ID));
            String deckName = cursor.getString(cursor.getColumnIndexOrThrow(DeckColumns.COLUMN_NAME_NAME));
            String deckClass = cursor.getString(cursor.getColumnIndexOrThrow(DeckColumns.COLUMN_NAME_CLASS));

            deck = new Deck(id, deckName, deckClass);
        }

        return deck;
    }

    public static List<Deck> readDeck(Context context) {
        ArrayList arrayDecks = new ArrayList<>();
        DeckDbHelper dbHelper = new DeckDbHelper(context);

        SQLiteDatabase db = dbHelper.getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                DeckColumns._ID,
                DeckColumns.COLUMN_NAME_NAME,
                DeckColumns.COLUMN_NAME_CLASS
        };

        Cursor cursor = db.query(
                DeckColumns.TABLE_NAME,  // The table to query
                projection,                 // The columns to return
                null,                       // The columns for the WHERE clause
                null,                       // The values for the WHERE clause
                null,                       // don't group the rows
                null,                       // don't filter by row groups
                null                        // The sort order
        );

        for(cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
            Integer id = cursor.getInt(cursor.getColumnIndexOrThrow(DeckColumns._ID));
            String deckName = cursor.getString(cursor.getColumnIndexOrThrow(DeckColumns.COLUMN_NAME_NAME));
            String deckClass = cursor.getString(cursor.getColumnIndexOrThrow(DeckColumns.COLUMN_NAME_CLASS));

            arrayDecks.add(new Deck(id, deckName, deckClass));
        }

        return arrayDecks;
    }
}
