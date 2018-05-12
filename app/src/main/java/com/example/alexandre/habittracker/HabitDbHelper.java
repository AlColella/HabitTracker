package com.example.alexandre.habittracker;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.alexandre.habittracker.HabitContract.HabitEntry;

public class HabitDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "aulas.db";
    private static final int DATABASE_VERSION = 1;

    public HabitDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String SQL_CREATE_PET_TABLE = "CREATE TABLE " + HabitEntry.TABLE_NAME + "("
                + HabitEntry.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + HabitEntry.COLUMN_AULA_ASSUNTO + " TEXT NOT NULL, "
                + HabitEntry.COLUMN_AULA_HORA + " INTEGER NOT NULL );";

        db.execSQL(SQL_CREATE_PET_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
