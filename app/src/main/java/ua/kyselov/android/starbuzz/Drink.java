package ua.kyselov.android.starbuzz;

/**
 * Created by Ivan on 5/18/2016.
 */
public class Drink {
    private String name;
    private String description;
    private int imageResourceId;

    public static final Drink[] drinks= {
            new Drink("Latte","A couple of espresso shots with steamed milk",1),
            new Drink("Cappuccino","Espresso, hot milk, and steamed milk foam",2),
            new Drink("Filter","Highest quality beans roasted and brewed fresh",3)
    };

    private Drink(String name, String description, int imageResourceId){
        this.name = name;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }

    public String getDescription(){
        return description;
    }
    public String getName(){
        return name;
    }
    public int getImageResourceId(){
        return imageResourceId;
    }

    public String toString(){
        return this.name;
    }
}
