package com.example.alexandre.habittracker;

import android.provider.BaseColumns;

public final class HabitContract {

    private HabitContract() {};

    public static final class HabitEntry  implements BaseColumns {

        public static final String TABLE_NAME = "aulasandroid";

        public static final String COLUMN_ID = BaseColumns._ID;
        public static final String COLUMN_AULA_ASSUNTO = "assunto";
        public static final String COLUMN_AULA_HORA = "hora";

        public static final int AULA_MANHA = 10;
        public static final int AULA_NOITE = 20;

    }

}
