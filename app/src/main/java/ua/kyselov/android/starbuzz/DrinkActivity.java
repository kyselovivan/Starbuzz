package ua.kyselov.android.starbuzz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DrinkActivity extends AppCompatActivity {

    public static final String EXTRA_DRINKNO="drinkNo";
    ImageView photo;
    TextView name;
    TextView description;
    Drink drink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        int drinkNo = (Integer)getIntent().getExtras().get(EXTRA_DRINKNO);
        Drink drink = Drink.drinks[drinkNo];


        photo = (ImageView)findViewById(R.id.photo);
        name = (TextView)findViewById(R.id.name);
        description = (TextView)findViewById(R.id.description);

        photo.setImageResource(drink.getImageResourceId());
        name.setText(drink.getName());
        description.setText(drink.getDescription());

    }
}
