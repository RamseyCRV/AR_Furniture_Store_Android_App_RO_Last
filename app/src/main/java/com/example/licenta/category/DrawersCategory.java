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

public class DrawersCategory extends AppCompatActivity {

    // Drawer Object Description
    private String drawersCategory = "Casa ta trebuie să fie un loc sigur pentru întreaga familie. De aceea, este inclus un accesoriu de siguranţă ca să poţi fixa comoda de perete.\n" +
            "\n" +
            "Sertar glisant cu dispozitiv care previne deschiderea accidentală.\n" +
            "\n" +
            "În sertar încap aproximativ 5 perechi de pantaloni împăturiţi sau 10 de tricouri.";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cateogry_drawers);

        getSupportActionBar().setTitle("Comode");


        // Drawers items
        final ArrayList<items> drawers = new ArrayList<items>();
        drawers.add(new items("Comoda TV", 323, R.drawable.drawer1, R.drawable.drawer11, R.drawable.drawer111, "drawer1.sfb", drawersCategory));
        drawers.add(new items("Comoda dormitor", 543, R.drawable.drawer2, R.drawable.drawer22, R.drawable.drawer222, "drawer2.sfb", drawersCategory));
        drawers.add(new items("Comoda cu oglinda", 564, R.drawable.drawer3, R.drawable.drawer33, R.drawable.drawer333, "drawer3.sfb", drawersCategory));
        drawers.add(new items("Comoda sufragerie", 334, R.drawable.drawer4, R.drawable.drawer44, R.drawable.drawer444, "drawer4.sfb", drawersCategory));
        drawers.add(new items("Comoda casual", 635, R.drawable.drawer5, R.drawable.drawer55, R.drawable.drawer555, "drawer5.sfb", drawersCategory));
        drawers.add(new items("Comoda Dusan", 423, R.drawable.drawer1, R.drawable.drawer11, R.drawable.drawer111, "drawer1.sfb", drawersCategory));
        drawers.add(new items("Comoda dormitor", 543, R.drawable.drawer2, R.drawable.drawer22, R.drawable.drawer222, "drawer2.sfb", drawersCategory));
        drawers.add(new items("Comoda Angle", 354, R.drawable.drawer3, R.drawable.drawer33, R.drawable.drawer333, "drawer3.sfb", drawersCategory));
        drawers.add(new items("Comoda de lemn", 344, R.drawable.drawer4, R.drawable.drawer44, R.drawable.drawer444, "drawer4.sfb", drawersCategory));
        drawers.add(new items("Comoda Atrix", 565, R.drawable.drawer5, R.drawable.drawer55, R.drawable.drawer555, "drawer5.sfb", drawersCategory));
        drawers.add(new items("Comoda Mendy", 723, R.drawable.drawer1, R.drawable.drawer11, R.drawable.drawer111, "drawer1.sfb", drawersCategory));
        drawers.add(new items("Comoda premium", 243, R.drawable.drawer2, R.drawable.drawer22, R.drawable.drawer222, "drawer2.sfb", drawersCategory));
        drawers.add(new items("Comoda Amole", 354, R.drawable.drawer3, R.drawable.drawer33, R.drawable.drawer333, "drawer3.sfb", drawersCategory));
        drawers.add(new items("Comoda Hofa", 364, R.drawable.drawer4, R.drawable.drawer44, R.drawable.drawer444, "drawer4.sfb", drawersCategory));
        drawers.add(new items("Comoda Office", 615, R.drawable.drawer5, R.drawable.drawer55, R.drawable.drawer555, "drawer5.sfb", drawersCategory));
        itemsAdapter itAdapter = new itemsAdapter(this, drawers);

        // Get a reference to the ListView, and attach the adapter to the listView
        ListView listView = (ListView) findViewById(R.id.drawers_category_list_view);
        listView.setAdapter(itAdapter);

         /* ========================================================================
                        Go to Details Activity with item
        ====================================================================*/

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                items e = drawers.get(position);

                String name = e.getlName();
                int price = e.getlPrice();
                String details = e.getlDetails();
                String model = e.getlModel();
                int im = e.getlImageId();
                int im1 = e.getlImageId1();
                int im2 = e.getlImageId2();

                Bundle bundle = new Bundle();
                bundle.putString("Model", model);
                bundle.putString("Name", name);
                bundle.putInt("Price", price);
                bundle.putString("Details", details);
                bundle.putInt("Image", im);
                bundle.putInt("Image1", im1);
                bundle.putInt("Image2", im2);

                Intent intent = new Intent(DrawersCategory.this, Details.class);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });
    }
}
