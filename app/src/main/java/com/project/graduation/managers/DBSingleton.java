package com.project.graduation.managers;

import android.content.Context;

/**
 * Created by Daniel on 01/04/2016.
 */
public class DBSingleton {
    private static DBHelper db = null;

    public static DBHelper getDBInstance(Context context,String dbName, String x, int dbVersion) {
        if(db==null)
            db = new DBHelper(context, dbName, x, dbVersion);
        return db;
    }

}
