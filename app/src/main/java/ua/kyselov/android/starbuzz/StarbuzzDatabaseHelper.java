package ua.kyselov.android.starbuzz;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ivan on 5/29/2016.
 */
public class StarbuzzDatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "starbuzz" ;
    private static final int DB_VERSION = 1;

    StarbuzzDatabaseHelper(Context context){
        super(context,DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE DRINK("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "NAME TEXT,"
                + "DESCRIPTION TEXT,"
                + "IMAGE_RESOURCE_ID INTEGER);"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
