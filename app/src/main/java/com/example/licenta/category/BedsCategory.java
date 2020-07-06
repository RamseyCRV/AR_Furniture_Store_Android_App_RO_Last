package com.example.licenta.category;

import androidx.appcompat.app.AppCompatActivity;
import com.example.licenta.*;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.example.licenta.R;
import com.example.licenta.adapter.items;
import com.example.licenta.adapter.itemsAdapter;
import java.util.ArrayList;

public class    BedsCategory extends AppCompatActivity {

    // Bed Object Description
    private String bedDescription = "Marginile patului sunt reglabile pentru a permite folosirea saltelelor de diferite grosimi.\n" +
            "\n" +
            "Designul se asortează cu multe stiluri diferite, modern sau tradiţional.\n" +
            "\n" +
            "Cutiile de depozitare au loc suficient sub pat pentru a depozita pilote şi cearşafuri.";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_beds);

        getSupportActionBar().setTitle("Paturi");

        // Beds items
        final ArrayList<items> beds = new ArrayList<items>();
        beds.add(new items("Pat Mettalic", 236, R.drawable.bed1, R.drawable.bed11, R.drawable.bed111, "bed1.sfb", bedDescription));
        beds.add(new items("Pat Wood", 433, R.drawable.bed2, R.drawable.bed22, R.drawable.bed222, "bed2.sfb", bedDescription));
        beds.add(new items("Pat Casual", 542, R.drawable.bed3, R.drawable.bed33, R.drawable.bed333, "bed3.sfb", bedDescription));
        beds.add(new items("Pat Sofa", 341, R.drawable.bed4, R.drawable.bed44, R.drawable.bed444, "bed4.sfb", bedDescription));
        beds.add(new items("Pat Black", 653, R.drawable.bed5, R.drawable.bed55, R.drawable.bed555, "bed5.sfb", bedDescription));
        beds.add(new items("Pat Doms", 234, R.drawable.bed1, R.drawable.bed11, R.drawable.bed111, "bed1.sfb", bedDescription));
        beds.add(new items("Pat Wooden", 436, R.drawable.bed2, R.drawable.bed22, R.drawable.bed222, "bed2.sfb", bedDescription));
        beds.add(new items("Pat Ikea", 549, R.drawable.bed3, R.drawable.bed33, R.drawable.bed333, "bed3.sfb", bedDescription));
        beds.add(new items("Pat Sofas", 341, R.drawable.bed4, R.drawable.bed44, R.drawable.bed444, "bed4.sfb", bedDescription));
        beds.add(new items("Pat Caesar", 625, R.drawable.bed5, R.drawable.bed55, R.drawable.bed555, "bed5.sfb", bedDescription));
        beds.add(new items("Pat German", 233, R.drawable.bed1, R.drawable.bed11, R.drawable.bed111, "bed1.sfb", bedDescription));
        beds.add(new items("Pat Casuali", 453, R.drawable.bed2, R.drawable.bed22, R.drawable.bed222, "bed2.sfb", bedDescription));
        beds.add(new items("Pat Memori" , 568, R.drawable.bed3, R.drawable.bed33, R.drawable.bed333, "bed3.sfb", bedDescription));
        beds.add(new items("Pat Donf", 374, R.drawable.bed4, R.drawable.bed44, R.drawable.bed444, "bed4.sfb", bedDescription));
        beds.add(new items("Pat Melo", 658, R.drawable.bed5, R.drawable.bed55, R.drawable.bed555, "bed5.sfb", bedDescription));
        itemsAdapter itAdapter = new itemsAdapter(this, beds);

        // Get a reference to the ListView, and attach the adapter to the listView
        ListView listView = (ListView) findViewById(R.id.beds_category_list_view);
        listView.setAdapter(itAdapter);

        /* ========================================================================
                        Go to Details Activity with item
        ====================================================================*/

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                items e = beds.get(position);

                String name = e.getlName();
                int price = e.getlPrice();
                String details = e.getlDetails();
                String model = e.getlModel();
                int im = e.getlImageId();
                int im1 = e.getlImageId1();
                int im2 = e.getlImageId2();

                Bundle bundle = new Bundle();
                bundle.putString("Name", name);
                bundle.putInt("Price", price);
                bundle.putString("Details", details);
                bundle.putInt("Image", im);
                bundle.putInt("Image1", im1);
                bundle.putInt("Image2", im2);
                bundle.putString("Model", model);

                Intent intent = new Intent(BedsCategory.this, Details.class);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });
    }

}
