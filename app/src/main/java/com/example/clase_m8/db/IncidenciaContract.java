package com.example.clase_m8.db;

import android.provider.BaseColumns;

public class IncidenciaContract {
    public static abstract class IncidenciaEntry implements BaseColumns{
        public static final String TABLE_NAME="Incidencia";
        public static final String ID="id";
        public static final String TABLE_NAME_TITLE="title";
        public static final String TABLE_NAME_PRIORITY="priority";
    }
}
