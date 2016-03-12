package com.project.graduation.managers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

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
    private static String SYMPTOMS__TABLE ="SYMPTOMS";
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
    private static final String DIS_FORGIEN="disease_id";

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
    private static final String USER_KEY_NAME = "name";
    private static final String USER_KEY_PASSWORD = "password";

    private static final int USER_KEY_ID_INDEX = 0;
    private static final int USER_KEY_NAME_INDEX = 1;
    private static final int USER_KEY_PASSWORD_INDEX = 2;

    // Table Create Statements
    //CREATE DOCTOR
    private static final String CREATE_TABLE_DOCTOR = "CREATE TABLE "
            + DOCTORS_TABLE + "(" + DOC_KEY_ID + " INTEGER PRIMARY KEY," + DOC_KEY_NAME
            + " TEXT," + DOC_KEY_PHONE + " TEXT," + DOC_KEY_ADDRESS
            + " TEXT" + ")";

    private static final String CREATE_TABLE_SYM_CAT = "CREATE TABLE "
            + SYMPTOMS__TABLE + "(" + SYM_CAT_KEY_ID + " INTEGER PRIMARY KEY," + SYM_CAT_KEY_NAME
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


    private void init(SQLiteDatabase db){
        db.execSQL("INSERT INTO "+DOCTORS_TABLE+" VALUES(1,'حسام حسن ','','')");
        db.execSQL("INSERT INTO "+DOCTORS_TABLE+" VALUES(2,'محمد ابو العزم  ','','')");
        db.execSQL("INSERT INTO "+DOCTORS_TABLE+" VALUES(3,'محمد الحجاج  ','','')");
        db.execSQL("INSERT INTO "+DOCTORS_TABLE+" VALUES(4,'عيادات الدكتور عبد الكريم   ','','')");
        db.execSQL("INSERT INTO "+DOCTORS_TABLE+" VALUES(5,'الدكتور صالح المتطويع   ','','')");
        db.execSQL("INSERT INTO "+DOCTORS_TABLE+" VALUES(6,'حازم ابراهيم    ','','')");

        db.execSQL("INSERT INTO "+DISEASE_TABLE+" VALUES (1,'High Blood Pressure (Hypertension)')");
        db.execSQL("INSERT INTO "+ SYMPTOMS__TABLE+" VALUES (1,'Dizziness',1) ");
        db.execSQL("INSERT INTO "+ SYMPTOMS__TABLE+" VALUES (2,'Headache',1) ");
        db.execSQL("INSERT INTO "+ SYMPTOMS__TABLE+" VALUES (3,'Blurred Vision',1) ");

        db.execSQL("INSERT INTO "+DISEASE_TABLE+" VALUES (2,'cancer')");
        db.execSQL("INSERT INTO "+ SYMPTOMS__TABLE+" VALUES (4,'difficulty walking and/or dizziness',2) ");
        db.execSQL("INSERT INTO "+ SYMPTOMS__TABLE+" VALUES (5,'seizures',2) ");
        db.execSQL("INSERT INTO "+ SYMPTOMS__TABLE+" VALUES (6,'weakness',2) ");

        db.execSQL("INSERT INTO "+DISEASE_TABLE+" VALUES (3,'Anemia')");
        db.execSQL("INSERT INTO "+ SYMPTOMS__TABLE+" VALUES (7,'Feel tired or lightheaded ',3) ");
        db.execSQL("INSERT INTO "+ SYMPTOMS__TABLE+" VALUES (8,'Weakness ',3) ");
        db.execSQL("INSERT INTO "+ SYMPTOMS__TABLE+" VALUES (9,'Fatigue easily ',3) ");
        db.execSQL("INSERT INTO "+ SYMPTOMS__TABLE+" VALUES (10,'Have decreased energy ',3) ");
        db.execSQL("INSERT INTO "+ SYMPTOMS__TABLE+" VALUES (11,'Appear pale ',3) ");
        db.execSQL("INSERT INTO "+ SYMPTOMS__TABLE+" VALUES (12,'Develop palpitations or rapid heart rate ',3) ");
        db.execSQL("INSERT INTO "+ SYMPTOMS__TABLE+" VALUES (13,'Experience shortness of breath ',3) ");

        db.execSQL("INSERT INTO "+DISEASE_TABLE+" VALUES (4,'Eczema')");
        db.execSQL("INSERT INTO "+ SYMPTOMS__TABLE+" VALUES (14,'Dry, sensitive skin ',4) ");
        db.execSQL("INSERT INTO "+ SYMPTOMS__TABLE+" VALUES (15,'Intense itching ',4) ");
        db.execSQL("INSERT INTO "+ SYMPTOMS__TABLE+" VALUES (16,'Red, inflamed skin ',4) ");
        db.execSQL("INSERT INTO "+ SYMPTOMS__TABLE+" VALUES (17,'Recurring rash ',4) ");
        db.execSQL("INSERT INTO "+ SYMPTOMS__TABLE+" VALUES (18,'Recurring rash ',4) ");
        db.execSQL("INSERT INTO "+ SYMPTOMS__TABLE+" VALUES (19,'Rough, leathery patches ',4) ");
        db.execSQL("INSERT INTO "+ SYMPTOMS__TABLE+" VALUES (20,'Oozing or crusting ',4) ");
        db.execSQL("INSERT INTO "+ SYMPTOMS__TABLE+" VALUES (21,'Areas of swelling ',4) ");
        db.execSQL("INSERT INTO "+ SYMPTOMS__TABLE+" VALUES (22,'Dark colored patches of skin ',4) ");

        db.execSQL("INSERT INTO "+DISEASE_TABLE+" VALUES (5,'Anorexia')");

        db.execSQL("INSERT INTO "+DISEASE_TABLE+" VALUES (6,'EAR Infection')");
        db.execSQL("INSERT INTO "+ SYMPTOMS__TABLE+" VALUES (23,'scuba dives ',6) ");
        db.execSQL("INSERT INTO "+ SYMPTOMS__TABLE+" VALUES (24,'coughing ',6) ");
        db.execSQL("INSERT INTO "+ SYMPTOMS__TABLE+" VALUES (25,'sneezing ',6) ");
        db.execSQL("INSERT INTO "+ SYMPTOMS__TABLE+" VALUES (26,'bending ',6) ");


        db.execSQL("INSERT INTO "+DISEASE_TABLE+" VALUES (7,'High Blood Sugar')");

        db.execSQL("INSERT INTO "+DISEASE_TABLE+" VALUES (8,'Migraines')");
        db.execSQL("INSERT INTO "+ SYMPTOMS__TABLE+" VALUES (27,'nausea ',8) ");
        db.execSQL("INSERT INTO "+ SYMPTOMS__TABLE+" VALUES (28,'vomiting ',8) ");
        db.execSQL("INSERT INTO "+ SYMPTOMS__TABLE+" VALUES (29,'increased sensitivity to light and sound ',8) ");
        db.execSQL("INSERT INTO "+ SYMPTOMS__TABLE+" VALUES (30,'difficulty speaking ',8) ");

        db.execSQL("INSERT INTO "+DISEASE_TABLE+" VALUES (9,'Vitamin D Deficiency')");

        db.execSQL("INSERT INTO "+DISEASE_TABLE+" VALUES (10,'Glaucoma “Acute angle closure glaucoma”')");
        db.execSQL("INSERT INTO "+ SYMPTOMS__TABLE+" VALUES (31,'chronic open-angle glaucoma ',10) ");
        db.execSQL("INSERT INTO "+ SYMPTOMS__TABLE+" VALUES (32,'acute angle-closure glaucoma ',10) ");
        db.execSQL("INSERT INTO "+ SYMPTOMS__TABLE+" VALUES (33,'secondary glaucoma ',10) ");
        db.execSQL("INSERT INTO "+ SYMPTOMS__TABLE+" VALUES (34,'developmental glaucoma ',10) ");


        db.execSQL("INSERT INTO "+DISEASE_TABLE+" VALUES (11,'Flu')");
        db.execSQL("INSERT INTO "+ SYMPTOMS__TABLE+" VALUES (35,'a sudden fever ',11) ");
        db.execSQL("INSERT INTO "+ SYMPTOMS__TABLE+" VALUES (36,'a dry, chesty cough ',11) ");
        db.execSQL("INSERT INTO "+ SYMPTOMS__TABLE+" VALUES (37,'a headache ',11) ");
        db.execSQL("INSERT INTO "+ SYMPTOMS__TABLE+" VALUES (38,'tiredness and weakness ',11) ");
        db.execSQL("INSERT INTO "+ SYMPTOMS__TABLE+" VALUES (39,'chills ',11) ");
        db.execSQL("INSERT INTO "+ SYMPTOMS__TABLE+" VALUES (40,'aching muscles ',11) ");
        db.execSQL("INSERT INTO "+ SYMPTOMS__TABLE+" VALUES (41,'limb or joint pain ',11) ");
        db.execSQL("INSERT INTO "+ SYMPTOMS__TABLE+" VALUES (42,'nausea and vomiting ',11) ");
        db.execSQL("INSERT INTO "+ SYMPTOMS__TABLE+" VALUES (43,'a runny or blocked nose ',11) ");
        db.execSQL("INSERT INTO "+ SYMPTOMS__TABLE+" VALUES (44,'sneezing ',11) ");
        db.execSQL("INSERT INTO "+ SYMPTOMS__TABLE+" VALUES (45,'loss of appetite ',11) ");
        db.execSQL("INSERT INTO "+ SYMPTOMS__TABLE+" VALUES (46,'difficulty sleeping ',11) ");

        db.execSQL("INSERT INTO "+DISEASE_TABLE+" VALUES (12,'Pneumoconioses')");

        db.execSQL("INSERT INTO "+DISEASE_TABLE+" VALUES (13,'Poor Nutrition')");

        db.execSQL("INSERT INTO "+DISEASE_TABLE+" VALUES (14,'Smallpox')");
        db.execSQL("INSERT INTO "+DISEASE_TABLE+" VALUES (15,'Peptic ulcer (Stomach ulcer)')");
        db.execSQL("INSERT INTO "+DISEASE_TABLE+" VALUES (16,'Asthma");
        db.execSQL("INSERT INTO "+DISEASE_TABLE+" VALUES (17,'Urinary tract infection");
        db.execSQL("INSERT INTO "+DISEASE_TABLE+" VALUES (18,'Arthritis");
        db.execSQL("INSERT INTO "+DISEASE_TABLE+" VALUES (19,'Botulism");
        db.execSQL("INSERT INTO "+DISEASE_TABLE+" VALUES (20,'Measles");
        db.execSQL("INSERT INTO "+ SYMPTOMS__TABLE+" VALUES (47,'a runny or blocked nose ',20) ");
        db.execSQL("INSERT INTO "+ SYMPTOMS__TABLE+" VALUES (48,'sneezing ',20) ");
        db.execSQL("INSERT INTO "+ SYMPTOMS__TABLE+" VALUES (49,'watery eyes ',20) ");
        db.execSQL("INSERT INTO "+ SYMPTOMS__TABLE+" VALUES (50,'swollen eyelids ',20) ");
        db.execSQL("INSERT INTO "+ SYMPTOMS__TABLE+" VALUES (51,'sore, red eyes that may be sensitive to light ',20) ");
        db.execSQL("INSERT INTO "+ SYMPTOMS__TABLE+" VALUES (52,'a high temperature (fever), which may reach around 40C (104F) ',20) ");
        db.execSQL("INSERT INTO "+ SYMPTOMS__TABLE+" VALUES (53,'small greyish-white spots in the mouth ',20) ");
        db.execSQL("INSERT INTO "+ SYMPTOMS__TABLE+" VALUES (54,'aches and pains ',20) ");
        db.execSQL("INSERT INTO "+ SYMPTOMS__TABLE+" VALUES (55,'a cough ',20) ");
        db.execSQL("INSERT INTO "+ SYMPTOMS__TABLE+" VALUES (56,'loss of appetite ',20) ");
        db.execSQL("INSERT INTO "+ SYMPTOMS__TABLE+" VALUES (57,'tiredness, irritability and a general lack of energy ',20) ");

        db.execSQL("INSERT INTO "+DISEASE_TABLE+" VALUES (21,'Strep Throat");
        db.execSQL("INSERT INTO "+DISEASE_TABLE+" VALUES (22,'Irritable bowel syndrome");
        db.execSQL("INSERT INTO "+DISEASE_TABLE+" VALUES (23,'Autoimmune pancreatitis");
        db.execSQL("INSERT INTO "+DISEASE_TABLE+" VALUES (24,'Celiac Disease");
        db.execSQL("INSERT INTO "+ SYMPTOMS__TABLE+" VALUES (58,'Headache ',24) ");
        db.execSQL("INSERT INTO "+ SYMPTOMS__TABLE+" VALUES (59,'Fatigue and weakness ',24) ");
        db.execSQL("INSERT INTO "+ SYMPTOMS__TABLE+" VALUES (60,'Joint pain ',24) ");
        db.execSQL("INSERT INTO "+ SYMPTOMS__TABLE+" VALUES (61,'Numbness and tingling (paresthesia) of the hands and feet ',24) ");
        db.execSQL("INSERT INTO "+ SYMPTOMS__TABLE+" VALUES (62,'Osteoporosis due to decreased absorption of calcium and vitamin D ',24) ");
        db.execSQL("INSERT INTO "+ SYMPTOMS__TABLE+" VALUES (63,'Skin rash ',24) ");
        db.execSQL("INSERT INTO "+ SYMPTOMS__TABLE+" VALUES (64,'Abdominal pain ',24) ");
        db.execSQL("INSERT INTO "+ SYMPTOMS__TABLE+" VALUES (65,'GERD and heartburn ',24) ");
        db.execSQL("INSERT INTO "+DISEASE_TABLE+" VALUES (25,'Optic neuritis");
        db.execSQL("INSERT INTO "+DISEASE_TABLE+" VALUES (26,'Palindromic Rheumatism");
        db.execSQL("INSERT INTO "+DISEASE_TABLE+" VALUES (27,'Polymyositis");

    }


    public long InsertNewUser(users dto){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues param = new ContentValues();
        param.put(USER_KEY_NAME, dto.getUserName());
        param.put(USER_KEY_PASSWORD, dto.getPassword());
        long id=db.insert(USERS_TABLE, null, param);
        closeDB();
        return id;
    }

    public users Login(users dto){

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res=db.rawQuery("select * FROM "+USERS_TABLE+" where " + USER_KEY_NAME + "=? and " + USER_KEY_PASSWORD + " =?", new String[]{dto.getUserName(), dto.getPassword()});
        res.moveToFirst();
        while(res.isAfterLast() == false){
            dto.setUserName(res.getString(USER_KEY_NAME_INDEX));
            dto.setId(res.getInt(USER_KEY_ID_INDEX));
            dto.setPassword(res.getString(USER_KEY_PASSWORD_INDEX));
        }
        closeDB();
        return dto;
    }

    // closing database
    public void closeDB() {
        SQLiteDatabase db = this.getReadableDatabase();
        if (db != null && db.isOpen())
            db.close();
    }

}
