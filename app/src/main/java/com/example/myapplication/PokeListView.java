package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class PokeListView extends AppCompatActivity {
    View.OnClickListener queryListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mCursor = getContentResolver().query(PokeDatabase.CONTENT_URI, null, null, null, null);

            if (mCursor != null) {
                if (mCursor.getCount() > 0) {
                    fillArrayList();

                    CustomAdapter myAdapter = new CustomAdapter(getApplicationContext(), myRowItems);
                    pokeMans.setAdapter(myAdapter);
                }
            }
        }
    };
    ListView pokeMans;
    Button query;
    ArrayList<RowItem> myRowItems;
    Cursor mCursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poke_list_view);

        myRowItems = new ArrayList<RowItem>();

        pokeMans = (ListView) findViewById(R.id.poke_list);



        CustomAdapter myAdapter = new CustomAdapter(getApplicationContext(), myRowItems);
        query = findViewById(R.id.QueryButt);
        query.setOnClickListener(queryListener);

        pokeMans.setAdapter(myAdapter);
    }
    private void fillArrayList(){

        if (mCursor != null){
            mCursor.moveToNext();
            for(int i =0; i < mCursor.getCount(); i++){
            RowItem rowOne = new RowItem();
            rowOne.setName(mCursor.getString(1));
            rowOne.setNatNumb(mCursor.getString(2));
            rowOne.setSpecies(mCursor.getString(3));
            rowOne.setGender(mCursor.getString(4));
            rowOne.setHeight(mCursor.getString(5));
            rowOne.setWeight(mCursor.getString(6));
            rowOne.setLevel(mCursor.getString(7));
            rowOne.setHp(mCursor.getString(8));
            rowOne.setAttack(mCursor.getString(9));
            rowOne.setDefense(mCursor.getString(10));
            myRowItems.add(rowOne);}
        }
    }

    /*View.OnClickListener updateListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ContentValues mUpdateValues = new ContentValues();

            mUpdateValues.put(PokeDatabase.COLUMN_POKENAME, editNam.getText().toString().trim());
            mUpdateValues.put(PokeDatabase.COLUMN_POKENATNUM, editNatNum.getText().toString().trim());
            mUpdateValues.put(PokeDatabase.COLUMN_POKESPECIES, editSpec.getText().toString().trim());
            mUpdateValues.put(PokeDatabase.COLUMN_POKEGEN, spin_gender.getSelectedItem().toString().trim());
            mUpdateValues.put(PokeDatabase.COLUMN_POKEHEIGHT, editHeight.getText().toString().trim());
            mUpdateValues.put(PokeDatabase.COLUMN_POKEWEIGHT, editWeight.getText().toString().trim());
            mUpdateValues.put(PokeDatabase.COLUMN_POKELEVEL, spin_lvl.getSelectedItem().toString().trim());
            mUpdateValues.put(PokeDatabase.COLUMN_POKEHP, editHP.getText().toString().trim());
            mUpdateValues.put(PokeDatabase.COLUMN_POKEATTACK, editAttack.getText().toString().trim());
            mUpdateValues.put(PokeDatabase.COLUMN_POKEDEFENSE, editDefense.getText().toString().trim());

                String mSelectionClause = PokeDatabase.COLUMN_POKENAME + " = ? AND "
                        + PokeDatabase.COLUMN_POKENAME + " = ? AND "
                        + PokeDatabase.COLUMN_POKENATNUM + " = ? AND "
                        + PokeDatabase.COLUMN_POKESPECIES + " = ? AND "
                        + PokeDatabase.COLUMN_POKEGEN+ " = ? AND "
                        + PokeDatabase.COLUMN_POKEHEIGHT+ " = ? AND "
                        + PokeDatabase.COLUMN_POKEWEIGHT + " = ? AND "
                        + PokeDatabase.COLUMN_POKELEVEL + " = ? AND "
                        + PokeDatabase.COLUMN_POKEHP + " = ? AND "
                        + PokeDatabase.COLUMN_POKEATTACK + " = ? AND "
                        + PokeDatabase.COLUMN_POKEDEFENSE +  " = ? ";

            getContentResolver().insert(PokeDatabase.CONTENT_URI, mUpdateValues);
        }
    };*/
    /*View.OnClickListener deleteListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String mSelectionClause = PokeDatabase.COLUMN_POKENAME + " = ? " + " AND " +
                    PokeDatabase.COLUMN_POKENATNUM + " = ? " +
                    "AND " + PokeDatabase.COLUMN_POKESPECIES + " = ? " +
                    "AND " + PokeDatabase.COLUMN_POKEGEN + " = ? " +
                    "AND " + PokeDatabase.COLUMN_POKEHEIGHT + " = ? " +
                    "AND " + PokeDatabase.COLUMN_POKEWEIGHT + " = ? " +
                    "AND " + PokeDatabase.COLUMN_POKELEVEL + " = ? " +
                    "AND " + PokeDatabase.COLUMN_POKEHP + " = ? " +
                    "AND " + PokeDatabase.COLUMN_POKEATTACK + " = ? " +
                    "AND " + PokeDatabase.COLUMN_POKEDEFENSE + " = ? ";

            String[] mSelectionArgs = { ,
                    TypeText.getText().toString().trim(), NumText.getText().toString().trim(), TypeFandomText.getText().toString().trim(), ultimateText.getText().toString().trim(), priceText.getText().toString().trim(), onText.getText().toString().trim()};

            int mRowsDeleted = getContentResolver().delete(PokeDatabase.CONTENT_URI, mSelectionClause,
                    mSelectionArgs);


        }
    };*/

}