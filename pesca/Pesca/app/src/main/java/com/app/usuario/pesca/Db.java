package com.app.usuario.pesca;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

import static java.sql.Types.INTEGER;

public class Db extends SQLiteOpenHelper {
    public static String DATABASE_NAME = "nombre_base";
    private static final int DATABASE_VERSION = 1;

    private static final String tabla_mapa = "mapa";
    private static final String tabla_pez = "pez";
    private static final String id_mapa = "id";
    private static final String latitud_mapa = "latitud";
    private static final String longitud_mapa = "longitud";
    private static final String id_pez = "id";
    private static final String id_mapa_pez = "id_mapa";
    private static final String peso_pez = "peso";
    private static final String epoca_pez = "epoca";
    private static final String nombre_mapa = "nombre";
    private static final String carnada_pez = "carnada";
    private static final String nombre_pez = "nombre";

    /*CREATE TABLE students ( id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, phone_number TEXT......);*/

    private static final String CREATE_TABLE_MAPAS = "CREATE TABLE "
            + tabla_mapa + "(" + id_mapa
            + " INTEGER PRIMARY KEY AUTOINCREMENT," + nombre_mapa + " TEXT,"
            + latitud_mapa + " INTEGER NOT NULL," + longitud_mapa + " INTEGER NOT NULL);";

    private static final String CREATE_TABLE_PEZ = "CREATE TABLE "
            + tabla_pez + "("
            + id_pez + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + nombre_pez + " TEXT,"
            + id_mapa_pez + " INTEGER,"
            + carnada_pez + " TEXT,"
            + peso_pez + " INTEGER,"
            + epoca_pez + " TEXT);";




    public Db(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_PEZ);
        db.execSQL(CREATE_TABLE_MAPAS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS '" + tabla_mapa + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + tabla_pez + "'");
        onCreate(db);
    }


    public void addPez(String nombre,String carnada, String epoca, Integer peso) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(nombre_pez, nombre);
        values.put(carnada_pez, carnada);
        values.put(epoca_pez, epoca);
        values.put(peso_pez, peso);
        long id = db.insertWithOnConflict(tabla_pez, null, values, SQLiteDatabase.CONFLICT_IGNORE);

    }

    public void addLugar(String nombre, Integer latitud, Integer longitud) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(nombre_mapa, nombre);
        values.put(latitud_mapa, latitud);
        values.put(longitud_mapa, longitud);
        long id = db.insertWithOnConflict(tabla_mapa, null, values, SQLiteDatabase.CONFLICT_IGNORE);

    }

    public ArrayList<MapaModel> todosLosLugares() {
        ArrayList<MapaModel> mapaModelArrayList = new ArrayList<MapaModel>();

        String selectQuery = "SELECT  * FROM " + tabla_mapa;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        if (c.moveToFirst()) {
            do {
                MapaModel mapa = new MapaModel();
                mapa.setId(c.getInt(c.getColumnIndex(id_mapa)));
                mapa.setNombre(c.getString(c.getColumnIndex(nombre_mapa)));
                mapa.setLongitud(c.getInt(c.getColumnIndex(latitud_mapa)));
                mapa.setLatitud(c.getInt(c.getColumnIndex(longitud_mapa)));
                mapa.setId(c.getInt(c.getColumnIndex(id_mapa)));
                mapaModelArrayList.add(mapa);
            } while (c.moveToNext());
        }
        return mapaModelArrayList;
    }

    public ArrayList<PezModel> todosLosPeces() {
        ArrayList<PezModel> pezModelArrayList = new ArrayList<PezModel>();

        String selectQuery = "SELECT  * FROM " + tabla_pez;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        if (c.moveToFirst()) {
            do {
                PezModel pez = new PezModel();
                pez.setNombre(c.getString(c.getColumnIndex(nombre_mapa)));
                pez.setCarnada(c.getString(c.getColumnIndex(carnada_pez)));
                pez.setPeso(c.getInt(c.getColumnIndex(peso_pez)));
                pez.setId(c.getInt(c.getColumnIndex(id_pez)));
                pez.setEpoca(c.getString(c.getColumnIndex(epoca_pez)));
                pezModelArrayList.add(pez);
            } while (c.moveToNext());
        }
        return pezModelArrayList;
    }

    public ArrayList<PezModel> todosLosPecesDelLugar(Long lugarId) {
        ArrayList<PezModel> pezModelArrayList = new ArrayList<PezModel>();

        SQLiteDatabase db = getReadableDatabase();
        String[] columns = new String[]{carnada_pez, peso_pez, nombre_pez,epoca_pez};
        Cursor c = db.query(tabla_pez, columns, "id_mapa=?", new String[] { String.valueOf(lugarId) }, null, null, null);

        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
            do {
                PezModel pez = new PezModel();
                pez.setNombre(c.getString(c.getColumnIndex(nombre_mapa)));
                pez.setCarnada(c.getString(c.getColumnIndex(carnada_pez)));
                pez.setPeso(c.getInt(c.getColumnIndex(peso_pez)));
                pez.setEpoca(c.getString(c.getColumnIndex(epoca_pez)));
                pezModelArrayList.add(pez);
            } while (c.moveToNext());
        }
        return pezModelArrayList;
    }

    public String asignarPez(String nombre){
        SQLiteDatabase db = getReadableDatabase();
        ContentValues values = new ContentValues();

        String[] columns = new String[]{nombre_pez};
        Cursor c = db.query(tabla_pez, columns, "nombre=?", new String[] { String.valueOf(nombre) }, null, null, null);
        Integer igetP = c.getColumnIndex(nombre_pez);
        String respuesta = "";

        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
            respuesta = respuesta + c.getString(igetP);
        }

        if (respuesta==""){
            respuesta = "No existe un Pez con ese nombre.";
            return respuesta;
        } else {
            Long id_lug = listaLugares.id_lugar;
            Integer i = (int) (long) id_lug;
            values.put(id_mapa_pez, i);
            db.update(tabla_pez, values, nombre_pez + " = ?", new String[]{String.valueOf(nombre)});
            respuesta = "Lugar Asignado con exito.";
            return respuesta;
        }

    }


}
