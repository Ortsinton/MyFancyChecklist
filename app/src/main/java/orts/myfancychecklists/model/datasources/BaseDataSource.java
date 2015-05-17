package orts.myfancychecklists.model.datasources;

import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Orts on 25/04/2015.
 */
public abstract class BaseDataSource<T extends Parcelable> {
    final String DATABASE_NAME;

    BaseDataSource(String dbName) {
        DATABASE_NAME =  dbName;
    }

    protected abstract void createTableIfNotExists();
    public abstract void insert(T entity);
    public abstract ArrayList<T> getByData();
    public abstract ArrayList<T> getByExample();
    public abstract ArrayList<T> getAll();
}
