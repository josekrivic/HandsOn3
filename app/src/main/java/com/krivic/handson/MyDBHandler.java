package com.krivic.handson;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Emilio on 29/11/2016.
 */

public class MyDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "personas.db";
    public static final String TABLA_PERSONAS = "personas";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NOMBRE = "nombre";
    public static final String COLUMN_APELLIDO = "apellido";
    public static final String COLUMN_DNI = "dni";          // se cambio edad por dni
    public static String COLUMN_TEL = "telefono";
    public static String COLUMN_EMAIL = "email";
    public static String COLUMN_MOTIVO = "motivo";
    public static String COLUMN_SEXO = "sexo";
    //public static String COLUMN_SANGRE = "tiposangre";
    /*public static String COLUMN_DESESTRESARCE ="desestresarce"; //agregue lo del radiobutton
    public static String COLUMN_ALIVIAR ="aliviar";//agregue lo del radiobutton
    public static String COLUMN_REDUCIR ="reducir";//agregue lo del radiobutton*/


    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLA_PERSONAS + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NOMBRE + " TEXT, " +
                COLUMN_APELLIDO + " TEXT, " +
                COLUMN_DNI + " INTEGER, " +     // se cambio edad por dni
                COLUMN_TEL + " TEXT, " +
                COLUMN_EMAIL + " TEXT, " +
                COLUMN_MOTIVO + " TEXT, " +
                COLUMN_SEXO + " TEXT " +
                /*COLUMN_DESESTRESARCE + " TEXT, " + //agregue lo del radio button
                COLUMN_ALIVIAR + " TEXT, " +//agregue lo del radiobutton
                COLUMN_REDUCIR + " TEXT "+//agregue lo del radiobutton*/
                //COLUMN_SANGRE + " TEXT " +
                ");";

        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLA_PERSONAS);
        onCreate(db);
    }

    //Añade un nuevo Row a la Base de Datos

    public void addPersona(Personas personas) {

        ContentValues values = new ContentValues();
        values.put(COLUMN_NOMBRE, personas.get_nombre());
        values.put(COLUMN_APELLIDO, personas.get_apellido());
        values.put(COLUMN_DNI, personas.get_dni());             // se cambio edad por dni
        values.put(COLUMN_TEL, personas.get_telefono());
        values.put(COLUMN_EMAIL, personas.get_email());
        values.put(COLUMN_MOTIVO, personas.get_motivo());
        values.put(COLUMN_SEXO, personas.get_sexo());
        /*values.put(COLUMN_DESESTRESARCE,personas.get_desestresarce());//agregue lo del radiobutton
        values.put(COLUMN_ALIVIAR,personas.get_aliviar());//agregue lo del radiobutton
        values.put(COLUMN_REDUCIR,personas.get_reducir());//agregue lo del radiobutton*/
        //values.put(COLUMN_SANGRE, personas.get_tiposangre());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLA_PERSONAS, null, values);
        db.close();

    }

    public void updatepersona(Personas personas){
        ContentValues values = new ContentValues();
        values.put(COLUMN_NOMBRE, personas.get_nombre());
        values.put(COLUMN_APELLIDO, personas.get_apellido());
        values.put(COLUMN_DNI, personas.get_dni());        // se cambio edad por dni
        values.put(COLUMN_TEL, personas.get_telefono());
        values.put(COLUMN_EMAIL, personas.get_email());
        values.put(COLUMN_MOTIVO, personas.get_motivo());
        values.put(COLUMN_SEXO, personas.get_sexo());
        /*values.put(COLUMN_DESESTRESARCE,personas.get_desestresarce());//agregue lo del radiobutton
        values.put(COLUMN_ALIVIAR,personas.get_aliviar());//agregue lo del radiobutton
        values.put(COLUMN_REDUCIR,personas.get_reducir());//agregue lo del radiobutton*/
        //values.put(COLUMN_SANGRE, personas.get_tiposangre());
        //values.put(COLUMN_SANGRE, personas.get_tiposangre());
        SQLiteDatabase db = getWritableDatabase();
        db.update(TABLA_PERSONAS, values, COLUMN_ID + "= ?", new String[] { String.valueOf(personas.get_id())});
        db.close();

    }

    // Borrar una persona de la Base de Datos

    public void borrarPersona(int persona_id){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLA_PERSONAS + " WHERE " + COLUMN_ID + " = " + persona_id + ";");
        db.close();
    }

    //listar por id

    public Cursor personabyid(int id){
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLA_PERSONAS + " WHERE " + COLUMN_ID + " = " + id + ";";
        Cursor c = db.rawQuery(query, null);

        if (c != null) {
            c.moveToFirst();
        }

        return c;
    }

    //listar a todas las personas
    public Cursor listarpersonas(){
        SQLiteDatabase db = getReadableDatabase();
        String query = ("SELECT * FROM " + TABLA_PERSONAS + " WHERE 1 ORDER BY " + COLUMN_APELLIDO + ";");
        Cursor c = db.rawQuery(query, null);

        if (c != null) {
            c.moveToFirst();
        }

        return c;
    }

}




