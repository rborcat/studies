package com.upversionlab.hstracker.model;

import android.provider.BaseColumns;

/**
 * Created by rborcat on 11/24/2016.
 */

public final class DeckContract {
    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    public DeckContract() {}

    /* Inner class that defines the table contents */
    public static abstract class DeckColumns implements BaseColumns {
        public static final String TABLE_NAME = "deck";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_CLASS = "class";
    }
}