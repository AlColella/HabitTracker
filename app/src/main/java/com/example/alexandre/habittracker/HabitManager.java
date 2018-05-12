package com.example.alexandre.habittracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.alexandre.habittracker.HabitContract.HabitEntry;
import com.example.alexandre.habittracker.HabitDbHelper;

public class HabitManager extends AppCompatActivity {

    private HabitDbHelper mDbHelper = new HabitDbHelper(this);

    private void insertHabit() {

        String nomeAula = "UI Android";
        int    horaAula = HabitEntry.AULA_MANHA;

        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(HabitEntry.COLUMN_AULA_ASSUNTO, nomeAula);
        values.put(HabitEntry.COLUMN_AULA_HORA, horaAula);
        long newRowId = db.insert(HabitEntry.TABLE_NAME, null, values);

        if(newRowId == -1) {
            Log.e("LOG_ERROR", "Error with saving habit.");
        } else {
            Log.e("LOG_OK" , "Habit saved ok");
        }
    }


    private void queryDatabaseInfo() {

        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        String[] projection = {
                HabitEntry.COLUMN_AULA_ASSUNTO,
                HabitEntry.COLUMN_AULA_HORA
        };

        Cursor cursor = db.query(HabitEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null);

        try
        {
            int aulaColumnIndex = cursor.getColumnIndex(HabitEntry.COLUMN_AULA_ASSUNTO);
            int horaColumnIndex = cursor.getColumnIndex(HabitEntry.COLUMN_AULA_HORA);

            while (cursor.moveToNext()) {
                String currentAula = cursor.getString(aulaColumnIndex);
                int horaAula = cursor.getInt(horaColumnIndex);

                Log.e("Aula: ", currentAula + "Hora: " + horaAula);
            }
        } finally {
            cursor.close();
        }
    }

}


