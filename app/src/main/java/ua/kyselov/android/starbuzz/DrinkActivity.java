package ua.kyselov.android.starbuzz;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DrinkActivity extends AppCompatActivity {

    public static final String EXTRA_DRINKNO="drinkNo";
    ImageView photo;
    TextView name;
    TextView description;
    Drink drink;
//    String nameText;
//    String descritionText;
//    int photoid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        int drinkNo = (Integer)getIntent().getExtras().get(EXTRA_DRINKNO);
        photo = (ImageView)findViewById(R.id.photo);
        name = (TextView)findViewById(R.id.name);
        description = (TextView)findViewById(R.id.description);

        try{
            SQLiteOpenHelper starbuzzDatabaseHelper = new StarbuzzDatabaseHelper(this);
            SQLiteDatabase db = starbuzzDatabaseHelper.getReadableDatabase();
            Cursor cursor = db.query("DRINK",
                    new String[]{"NAME","DESCRIPTION","IMAGE_RESOURCE_ID"},
                    "_id = ?",
                    new String[]{Integer.toString(drinkNo)},
                    null,null,null);
            if(cursor.moveToFirst()){
                String nameText = cursor.getString(0);
                String descritionText = cursor.getString(1);
                int photoid = cursor.getInt(2);
                name.setText(nameText);
                description.setText(descritionText);
                photo.setImageResource(photoid);
            }
            cursor.close();
            db.close();
        }
        catch (SQLiteException e){
            Toast toast = Toast.makeText(this,"Database unavailable",Toast.LENGTH_SHORT);
            toast.show();
        }

//        Drink drink = Drink.drinks[drinkNo];
//        photo.setImageResource(drink.getImageResourceId());
//        name.setText(drink.getName());
//        description.setText(drink.getDescription());

    }
}
