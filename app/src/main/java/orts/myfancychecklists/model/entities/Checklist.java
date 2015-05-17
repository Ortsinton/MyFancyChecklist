package orts.myfancychecklists.model.entities;

import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Orts on 11/04/2015.
 */
public class Checklist implements Parcelable {
    public int id;
    public String name;
    public String notes = "";
    public int color;
    public boolean isDisplayedAsCards = false;
    //TODO: Uncomment this when ready
    //public ArrayList<Item> items;

    private SQLiteDatabase mDatabase;

    public Checklist(String name, String notes) {
        this.name = name;
        this.notes = notes;
        this.color = Color.rgb(00,96,88);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}
