package ua.kyselov.android.starbuzz;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ivan on 5/29/2016.
 */
public class StarbuzzDatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "starbuzz" ;
    private static final int DB_VERSION = 2;

    StarbuzzDatabaseHelper(Context context){
        super(context,DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        updateMyDatabase(db, 0, DB_VERSION);
//
    }

    private void updateMyDatabase(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion<1){
            db.execSQL("CREATE TABLE DRINK("
                        + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + "NAME TEXT,"
                        + "DESCRIPTION TEXT,"
                        + "IMAGE_RESOURCE_ID INTEGER);"
        );
        insertDrink(db, "Latte", "A couple of espresso shots with steamed milk", R.drawable.latte);
        insertDrink(db,"Cappuccino","Espresso, hot milk, and steamed milk foam",R.drawable.cappuccino);
        insertDrink(db, "Filter", "Highest quality beans roasted and brewed fresh", R.drawable.filter);
        }
        if(oldVersion<2){
            db.execSQL("ALTER TABLE DRINK ADD COLUMN FAVORITE NUMERIC");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public static void insertDrink(SQLiteDatabase db, String name, String description, int resourceId){
        ContentValues drinkValues = new ContentValues();
        drinkValues.put("NAME", name);
        drinkValues.put("DESCRIPTION", description);
        drinkValues.put("IMAGE_RESOURCE_ID",resourceId);
        db.insert("DRINK",null,drinkValues);
    }
}
