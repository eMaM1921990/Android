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



//    public users findByObject(users dto){
//        users returnObj=new users();
//        SQLiteDatabase db = new DBHelper(null).getReadableDatabase();
//        Cursor res=db.rawQuery(SELECT +"where "+COLUMN_NAME+"=? and "+COLUMN_PASSWORD+" =?",new String[]{dto.getUserName(),dto.getPassword()});
//        res.moveToFirst();
//        while(res.isAfterLast() == false){
//            returnObj.setId(res.getInt(COLUMN_ID_INDEX));
//            returnObj.setUserName(res.getString(COLUMN_NAME_INDEX));
//        }
//        Log.d("here","database Layer");
//        return returnObj;
//    }
}
