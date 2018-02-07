package com.example.timteam.youwillwin;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.io.IOException;
import java.util.ArrayList;

public class GalleryActivity extends AppCompatActivity {
    private DatabaseHelper mDBHelper;
    private SQLiteDatabase mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.imagegallery);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),3);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<CreateList> createLists = prepareData();
        MyAdapter adapter = new MyAdapter(getApplicationContext(), createLists);
        recyclerView.setAdapter(adapter);


    }
    private ArrayList<CreateList> prepareData() {
//        cursor.getString(1) = image name
//        cursor.getString(2) = image text


        ArrayList<SuperImageModel> favorites = getAllFavoritRecords();
        ArrayList<CreateList> theimage = new ArrayList<>();
        for (SuperImageModel fav : favorites) {
            CreateList createList = new CreateList();
            createList.setImage_title(fav.getImageText());
            int resID = getResources().getIdentifier(fav.getImageName(),
                    "drawable", getPackageName());
            createList.setImage_ID(resID);
            theimage.add(createList);
        }
        return theimage;
    }
    public ArrayList<SuperImageModel> getAllFavoritRecords() {
        mDBHelper = new DatabaseHelper(this);

        try {
            mDBHelper.updateDataBase();
        } catch (IOException mIOException) {
            throw new Error("UnableToUpdateDatabase");
        }

        try {
            mDb = mDBHelper.getWritableDatabase();
        } catch (SQLException mSQLException) {
            throw mSQLException;
        }
        Cursor cursor = mDb.query("images", null, null, null, null, null, null);
        ArrayList<SuperImageModel> data = new ArrayList<SuperImageModel>();
        SuperImageModel superImageModel;
        if (cursor.getCount() > 0) {
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
                superImageModel = new SuperImageModel();
                superImageModel.setID(cursor.getString(0));
                superImageModel.setImageName(cursor.getString(1));
                superImageModel.setImageText(cursor.getString(2));
                data.add(superImageModel);
            }
        }
        cursor.close();
        mDb.close();
        return data;
    }

}
