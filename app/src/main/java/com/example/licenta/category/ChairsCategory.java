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

public class ChairsCategory extends AppCompatActivity {

    // Chair Object Description
    private String chairsDescription="Şezutul tapiţat şi unghiul confortabil al spătarului fac scaunul ideal pentru cine lungi.\n" +
            "\n" +
            "Braţele scaunului sunt suficient de lungi pentru a oferi suport când te laşi pe spate şi suficient de scurte ca să stai aşezat comod la masă.\n" +
            "\n" +
            "Scaunul poate fi împins sub masă ca să ocupe mai puţin loc când nu îl foloseşti.";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_chairs);

        getSupportActionBar().setTitle("Scaune");

        // Chairs items
        final ArrayList<items> chairs = new ArrayList<items>();
        chairs.add(new items("Scaun Birou", 422, R.drawable.chair1, R.drawable.chair11, R.drawable.chair111,  "chair1.sfb" ,chairsDescription));
        chairs.add(new items("Scaun Metalic", 146, R.drawable.chair2, R.drawable.chair22, R.drawable.chair222,  "chair2.sfb",chairsDescription));
        chairs.add(new items("Scaun Hofa", 154, R.drawable.chair3, R.drawable.chair33, R.drawable.chair333,  "chair3.sfb",chairsDescription));
        chairs.add(new items("Scaun Clasic", 138, R.drawable.chair4, R.drawable.chair44, R.drawable.chair444,  "chair4.sfb",chairsDescription));
        chairs.add(new items("Scaun Directorial", 365, R.drawable.chair5, R.drawable.chair55, R.drawable.chair555, "chair5.sfb",chairsDescription));
        chairs.add(new items("Scaun Gamming", 623, R.drawable.chair1, R.drawable.chair11, R.drawable.chair111,  "chair1.sfb",chairsDescription));
        chairs.add(new items("Scaun Silverfang", 246, R.drawable.chair2, R.drawable.chair22, R.drawable.chair222,  "chair2.sfb",chairsDescription));
        chairs.add(new items("Scaun Scandinav", 154, R.drawable.chair3, R.drawable.chair33, R.drawable.chair333,  "chair3.sfb",chairsDescription));
        chairs.add(new items("Scaun Casual", 137, R.drawable.chair4, R.drawable.chair44, R.drawable.chair444, "chair4.sfb",chairsDescription));
        chairs.add(new items("Scaun Lisf", 165, R.drawable.chair5, R.drawable.chair55, R.drawable.chair555,  "chair5.sfb",chairsDescription));
        chairs.add(new items("Scaun Memory", 123, R.drawable.chair1, R.drawable.chair11, R.drawable.chair111,  "chair1.sfb",chairsDescription));
        chairs.add(new items("Scaun Dumms", 143, R.drawable.chair2, R.drawable.chair22, R.drawable.chair222,  "chair2.sfb",chairsDescription));
        chairs.add(new items("Scaun Verds", 154, R.drawable.chair3, R.drawable.chair33, R.drawable.chair333, "chair3.sfb",chairsDescription));
        chairs.add(new items("Scaun Chemorf", 234, R.drawable.chair4, R.drawable.chair44, R.drawable.chair444,  "chair4.sfb",chairsDescription));
        chairs.add(new items("Scaun Birocratic", 165, R.drawable.chair5, R.drawable.chair55, R.drawable.chair555,  "chair5.sfb",chairsDescription));
        itemsAdapter itAdapter = new itemsAdapter(this, chairs);

        // Get a reference to the ListView, and attach the adapter to the listView
        ListView listView = (ListView) findViewById(R.id.chairs_category_list_view);
        listView.setAdapter(itAdapter);

         /* ========================================================================
                        Go to Details Activity with item
        ====================================================================*/

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                items e = chairs.get(position);

                String name = e.getlName();
                int price = e.getlPrice();
                String details = e.getlDetails();
                int im = e.getlImageId();
                int im1 = e.getlImageId1();
                int im2 = e.getlImageId2();
                String model = e.getlModel();

                Bundle bundle = new Bundle();
                bundle.putString("Name", name);
                bundle.putInt("Price", price);
                bundle.putString("Details", details);
                bundle.putInt("Image", im);
                bundle.putInt("Image1", im1);
                bundle.putInt("Image2", im2);
                bundle.putString("Model", model);

                Intent intent = new Intent(ChairsCategory.this, Details.class);
                intent.putExtras(bundle);
                startActivity(intent);


            }
        });
    }
}
