package com.project.graduation.managers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.project.graduation.model.users;


/**
 * Created by emam on 2/4/16.
 */
public class DBHelper extends SQLiteOpenHelper {

    // Logcat tag
    private static final String LOG = "DatabaseHelper";

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "DiseaseManager";

    // Table Names
    private static String DOCTORS_TABLE="DOCTORS";
    private static String DISEASE_TABLE="DISEASE";
    private static String SYMPTOMS_CATEGORY_TABLE="SYMPTOMSCATEGORY";
    private static String DOCTOR_DISEASE_TABLE="DOC_DISEAS";
    private static String DISEAS_SYMPTOMS_TABLE="DISEAS_SYM";
    private static String USERS_TABLE="USERS";

    //Table Doctor columns
    private static final String DOC_KEY_ID = "id";
    private static final String DOC_KEY_NAME = "name";
    private static final String DOC_KEY_PHONE = "phone";
    private static final String DOC_KEY_ADDRESS = "address";

    //Table Disease column
    private static final String DIS_KEY_ID = "id";
    private static final String DIS_KEY_NAME = "name";

    //Table Symptoms columns
    private static final String SYM_CAT_KEY_ID = "id";
    private static final String SYM_CAT_KEY_NAME = "name";

    //Table Doctor disease table
    private static final String DOC_DIS_KEY_ID = "id";
    private static final String DOC_DIS_KEY_DOC_ID = "doctor_id";
    private static final String DOC_DIS_KEY_DIS_ID = "disease_id";

    //Table DiseaseSymptoms
    private static final String SYM_DIS_KEY_ID = "id";
    private static final String SYM_DIS_KEY_DIS_ID = "diseas_id";
    private static final String SYM_DIS_KEY_SYM_ID = "sym_cat_id";

    //USER TABLE
    private static final String USER_KEY_ID = "id";
    private static final String USER_KEY_NAME = "id";
    private static final String USER_KEY_PASSWORD = "id";
    // Table Create Statements
    //CREATE DOCTOR
    private static final String CREATE_TABLE_DOCTOR = "CREATE TABLE "
            + DOCTORS_TABLE + "(" + DOC_KEY_ID + " INTEGER PRIMARY KEY," + DOC_KEY_NAME
            + " TEXT," + DOC_KEY_PHONE + " TEXT," + DOC_KEY_ADDRESS
            + " TEXT" + ")";

    private static final String CREATE_TABLE_SYM_CAT = "CREATE TABLE "
            + SYMPTOMS_CATEGORY_TABLE + "(" + SYM_CAT_KEY_ID + " INTEGER PRIMARY KEY," + SYM_CAT_KEY_NAME
            + " TEXT)";


    private static final String CREATE_TABLE_DISEASE = "CREATE TABLE "
            + DISEASE_TABLE + "(" + DIS_KEY_ID + " INTEGER PRIMARY KEY," + DIS_KEY_NAME
            + " TEXT)";


    private static final String CREATE_TABLE_DIS_SYM = "CREATE TABLE "
            + DISEAS_SYMPTOMS_TABLE + "(" + SYM_DIS_KEY_ID + " INTEGER PRIMARY KEY," + SYM_DIS_KEY_DIS_ID
            + " INTEGER ,"+SYM_DIS_KEY_SYM_ID+" INTEGER)";

    private static final String CREATE_TABLE_DIS_DOC = "CREATE TABLE "
            + DOCTOR_DISEASE_TABLE + "(" + DOC_DIS_KEY_ID + " INTEGER PRIMARY KEY," + DOC_DIS_KEY_DOC_ID
            + " INTEGER ,"+DOC_DIS_KEY_DIS_ID+" INTEGER)";


    private static final String CREATE_TABLE_USERS = "CREATE TABLE "
            + USERS_TABLE + "(" + USER_KEY_ID + " INTEGER PRIMARY KEY," + USER_KEY_NAME
            + " TEXT ,"+USER_KEY_PASSWORD+" TEXT)";

    public DBHelper(Context context){

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_DOCTOR);
        db.execSQL(CREATE_TABLE_SYM_CAT);
        db.execSQL(CREATE_TABLE_DISEASE);
        db.execSQL(CREATE_TABLE_DIS_SYM);
        db.execSQL(CREATE_TABLE_DIS_DOC);
        db.execSQL(CREATE_TABLE_USERS);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_DOCTOR);
        db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_SYM_CAT);
        db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_DISEASE);
        db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_DIS_SYM);
        db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_DIS_DOC);
        db.execSQL("DROP TABLE IF EXISTS " + CREATE_TABLE_USERS);

        // create new tables
        onCreate(db);
    }



    public boolean InsertNewUser(users dto){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues param = new ContentValues();
        param.put(USER_KEY_NAME, dto.getUserName());
        param.put(USER_KEY_PASSWORD, dto.getPassword());
        db.insert(CREATE_TABLE_USERS, null, param);
        Log.d("new user add","new user");
        return true;
    }

    // closing database
    public void closeDB() {
        SQLiteDatabase db = this.getReadableDatabase();
        if (db != null && db.isOpen())
            db.close();
    }

}
