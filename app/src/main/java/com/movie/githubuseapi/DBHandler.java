package com.movie.githubuseapi;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

public class DBHandler  extends SQLiteOpenHelper {

    private static final String DB_NAME = "userDB";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "users";
    private static final String ID_COL = "id";
    private static final String NAME_COL = "username";
    private static final String FOLLOWERS_COL = "followers";
    private static final String FOLLOWING_COL = "following";
    private static final String LOGIN_COL = "login";
    private static final String EMAIL_COL = "email";

    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + FOLLOWERS_COL + " TEXT,"
                + FOLLOWING_COL + " TEXT,"
                + LOGIN_COL + " TEXT,"
                + EMAIL_COL + " TEXT)";
        db.execSQL(query);
    }


    public void addNewCourse(String Name, String Followers, String Following, String Login ,String Email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME_COL, Name);
        values.put(FOLLOWERS_COL, Followers);
        values.put(FOLLOWING_COL, Following);
        values.put(LOGIN_COL, Login);
        values.put(EMAIL_COL, Email);
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


    public void addUser(TextView userNameTV, TextView followersTV, TextView followingTV, TextView logIn, TextView email) {
    }
}

