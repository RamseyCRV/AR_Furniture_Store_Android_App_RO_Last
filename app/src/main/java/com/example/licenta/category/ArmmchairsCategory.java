package com.example.licenta.category;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.example.licenta.Details;
import com.example.licenta.R;
import com.example.licenta.adapter.items;
import com.example.licenta.adapter.itemsAdapter;
import java.util.ArrayList;

public class ArmmchairsCategory extends AppCompatActivity {

    private String armchairsDescription = "Te poţi relaxa complet datorită spătarului înalt; oferă o susţinere suplimentară a gâtului.\n" +
            "\n" +
            "Cadrul are garanţie 10 ani. Citeşte despre condiţii în broşura de garanţii.\n" +
            "\n" +
            "Rezistenţa la abraziune a materialului a fost testată pentru a suporta 25.000 de cicluri. Pentru uz casnic zilnic, husa trebuie să reziste la 15.000 de cicluri sau mai mult.\n" +
            "\n" +
            "Husa are un nivel de rezistenţă a culorilor la lumină 5 pe o scară de la 1 la 8. Conform standardelor din industrie, un nivel de rezistenţă la lumină de 4 sau mai mult este adecvat pentru uz casnic.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cateogry_armchairs);

        getSupportActionBar().setTitle("Fotolii");

        // Armchairs items
        final ArrayList<items> armchairs = new ArrayList<items>();
        armchairs.add(new items("Fotoliu Pello", 123, R.drawable.armchair1, R.drawable.armchair11, R.drawable.armchair111,"armchair1.sfb",armchairsDescription));
        armchairs.add(new items("Fotoliu Strandmon", 143, R.drawable.armchair2, R.drawable.armchair22, R.drawable.armchair222, "armchair2.sfb" ,armchairsDescription));
        armchairs.add(new items("Fotoliu Casual", 154, R.drawable.armchair3, R.drawable.armchair33, R.drawable.armchair333,  "armchair3.sfb",armchairsDescription));
        armchairs.add(new items("Fotoliu Woord", 134, R.drawable.armchair4, R.drawable.armchair44, R.drawable.armchair444, "armchair4.sfb",armchairsDescription));
        armchairs.add(new items("Fotoliu Air", 165, R.drawable.armchair5, R.drawable.armchair55, R.drawable.armchair555, "armchair5.sfb",armchairsDescription));
        armchairs.add(new items("Fotoliu Fosa", 123, R.drawable.armchair1, R.drawable.armchair11, R.drawable.armchair111,  "armchair1.sfb",armchairsDescription));
        armchairs.add(new items("Fotoliu Morel", 143, R.drawable.armchair2, R.drawable.armchair22, R.drawable.armchair222,  "armchair2.sfb",armchairsDescription));
        armchairs.add(new items("Fotoliu Dufa", 154, R.drawable.armchair3, R.drawable.armchair33, R.drawable.armchair333,  "armchair3.sfb",armchairsDescription));
        armchairs.add(new items("Fotoliu Sofa", 134, R.drawable.armchair4, R.drawable.armchair44, R.drawable.armchair444, "armchair4.sfb",armchairsDescription));
        armchairs.add(new items("Fotoliu Polon", 165, R.drawable.armchair5, R.drawable.armchair55, R.drawable.armchair555,  "armchair5.sfb",armchairsDescription));
        armchairs.add(new items("Fotoliu Ikea", 123, R.drawable.armchair1, R.drawable.armchair11, R.drawable.armchair111,  "armchair1.sfb",armchairsDescription));
        armchairs.add(new items("Fotoliu Standk", 143, R.drawable.armchair2, R.drawable.armchair22, R.drawable.armchair222,  "armchair2.sfb",armchairsDescription));
        armchairs.add(new items("Fotoliu Merlon", 154, R.drawable.armchair3, R.drawable.armchair33, R.drawable.armchair333,  "armchair3.sfb",armchairsDescription));
        armchairs.add(new items("Fotoliu Guji", 134, R.drawable.armchair4, R.drawable.armchair44, R.drawable.armchair444,  "armchair4.sfb",armchairsDescription));
        armchairs.add(new items("Fotoliu Bello", 165, R.drawable.armchair5, R.drawable.armchair55, R.drawable.armchair555,  "armchair5.sfb",armchairsDescription));
        itemsAdapter itAdapter = new itemsAdapter(this, armchairs);

        // Get a reference to the ListView, and attach the adapter to the listView
        ListView listView = (ListView) findViewById(R.id.armchairs_category_list_view);
        listView.setAdapter(itAdapter);

       /* ========================================================================
                        Go to Details Activity with item
        ====================================================================*/

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                items e = armchairs.get(position);

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

                Intent intent = new Intent(ArmmchairsCategory.this, Details.class);
                intent.putExtras(bundle);

                startActivity(intent);

            }
        });
    }
}
