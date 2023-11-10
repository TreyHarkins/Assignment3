package com.example.myapplication;

import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.core.widget.TextViewOnReceiveContentListener;

import java.util.ArrayList;
public class CustomAdapter extends BaseAdapter {

    private ArrayList<RowItem> singleRow;
    private LayoutInflater thisInflater;
    Cursor mCursor;

    public CustomAdapter(Context context, ArrayList<RowItem> aRow) {

        this.singleRow = aRow;
        thisInflater = (LayoutInflater.from(context));

    }
    @Override
    public int getCount() {
        return singleRow.size();
    }

    @Override
    public Object getItem(int i) {
        return singleRow.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null){
            view = thisInflater.inflate(R.layout.list_view_row, viewGroup, false);

            TextView textNameD = (TextView) view.findViewById(R.id.dataPokeName);
            TextView textNatNumD = (TextView) view.findViewById(R.id.dataNatNum);
            TextView textSpeciesD = (TextView) view.findViewById(R.id.dataSpecies);
            TextView textGenderD = (TextView) view.findViewById(R.id.dataGen);
            TextView textHeightD = (TextView) view.findViewById(R.id.dataHeight);
            TextView textWeightD = (TextView) view.findViewById(R.id.dataWeight);
            TextView textLevelD = (TextView) view.findViewById(R.id.dataLVL);
            TextView textHpD = (TextView) view.findViewById(R.id.dataHP);
            TextView textAttackD = (TextView) view.findViewById(R.id.dataAttack);
            TextView textDefenseD = (TextView) view.findViewById(R.id.dataDefense);

            RowItem currentRow = (RowItem) getItem(i);

            textNameD.setText(currentRow.getName());
            textNatNumD.setText(currentRow.getNatNumb());
            textSpeciesD.setText(currentRow.getSpecies());
            textGenderD.setText(currentRow.getGender());
            textHeightD.setText(currentRow.getHeight());
            textWeightD.setText(currentRow.getWeight());
            textLevelD.setText(currentRow.getLevel());
            textHpD.setText(currentRow.getHp());
            textAttackD.setText(currentRow.getAttack());
            textDefenseD.setText(currentRow.getDefense());
        }
        return view;
    }
}
