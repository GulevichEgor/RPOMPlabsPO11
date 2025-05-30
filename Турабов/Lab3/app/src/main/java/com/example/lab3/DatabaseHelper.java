package com.example.lab3;

import static android.content.Context.MODE_PRIVATE;

import android.database.SQLException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static String DB_PATH; // полный путь к базе данных
    public static String DB_NAME = "Notes.db";
    public static final int SCHEMA = 1; // версия базы данных

    public static final String TABLE_NOTES = "Notes"; // название таблицы в бд
    // названия столбцов
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NOTEID = "noteId";
    public static final String COLUMN_AUTHOR = "authorName";
    public static final String COLUMN_TITLE = "noteTitle";
    public static final String COLUMN_TASK = "mainTask";
    public static final String COLUMN_DONE = "done";

    public static final String TABLE_SUBTASKS = "Subtasks1";
    public static final String COLUMN_SUBTASK = "task";

    public static final String[] columns_notes= {COLUMN_ID, COLUMN_AUTHOR, COLUMN_TITLE, COLUMN_TASK};
    public static final String[] columns_subtasks= { COLUMN_NOTEID, COLUMN_SUBTASK};
    private Context myContext;

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, SCHEMA);
        this.myContext=context;
        DB_PATH =context.getFilesDir().getPath() + DB_NAME;
    }

    @Override
    public void onCreate(SQLiteDatabase db) { }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,  int newVersion) { }

    public void create_db(){
//        File file = new File(DB_PATH);
//        if (!file.exists()) {
//            //получаем локальную бд как поток
//            try(InputStream myInput = myContext.getAssets().open(DB_NAME);
//                // Открываем пустую бд
//                OutputStream myOutput = new FileOutputStream(DB_PATH)) {
//
//                // побайтово копируем данные
//                byte[] buffer = new byte[1024];
//                int length;
//                while ((length = myInput.read(buffer)) > 0) {
//                    myOutput.write(buffer, 0, length);
//                }
//                myOutput.flush();
//            }
//            catch(IOException ex){
//                Log.d("DatabaseHelper", ex.getMessage());
//            }
//        }
    }
    public SQLiteDatabase open()throws SQLException {

        return SQLiteDatabase.openDatabase(DB_PATH, null, SQLiteDatabase.OPEN_READWRITE);
    }
}