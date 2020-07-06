package com.example.licenta.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.licenta.R;
import java.util.ArrayList;

public class itemsAdapter extends ArrayAdapter<items> {


    public itemsAdapter(Activity context, ArrayList<items> item){
        super(context,0,item);
    }


    public View getView(int position, View convertView, ViewGroup parent){

        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }


        items currentItems=getItem(position);

        TextView nameTextView=(TextView)listItemView.findViewById(R.id.name_item);

        nameTextView.setText(currentItems.getlName());

        TextView priceTextView=(TextView)listItemView.findViewById(R.id.price_item);

        priceTextView.setText(currentItems.getlPrice()+" RON");

        ImageView iconImageView=(ImageView)listItemView.findViewById(R.id.icon_item);

        iconImageView.setImageResource(currentItems.getlImageId());

        return listItemView;
    }
}
