package com.project.graduation.managers;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.project.graduation.model.users;

/**
 * Created by emam on 2/4/16.
 */
public class userHandler {
    private static String USER_TABLE="users";
    private static String COLUMN_ID="ID";
    private static String COLUMN_NAME="name";
    private static String COLUMN_PASSWORD="password";
    private static int COLUMN_ID_INDEX=1;
    private static int COLUMN_NAME_INDEX=2;
    private static int COLUMN_PASSWORD_INDEX=3;


    private static String SELECT="SELECT * FROM "+USER_TABLE;
    public boolean Insert(users dto){
        SQLiteDatabase db=new DBHelper(null).getWritableDatabase();
        ContentValues param = new ContentValues();
        param.put(COLUMN_NAME,dto.getUserName());
        param.put(COLUMN_PASSWORD, dto.getPassword());
        db.insert(USER_TABLE,null,param);
        return true;
    }

    public users findByObject(users dto){
        users returnObj=new users();
        SQLiteDatabase db = new DBHelper(null).getReadableDatabase();
        Cursor res=db.rawQuery(SELECT +"where "+COLUMN_NAME+"=? and "+COLUMN_PASSWORD+" =?",new String[]{dto.getUserName(),dto.getPassword()});
        res.moveToFirst();
        while(res.isAfterLast() == false){
            returnObj.setId(res.getInt(COLUMN_ID_INDEX));
            returnObj.setUserName(res.getString(COLUMN_NAME_INDEX));
        }
        Log.d("here","database Layer");
        return returnObj;
    }
}
