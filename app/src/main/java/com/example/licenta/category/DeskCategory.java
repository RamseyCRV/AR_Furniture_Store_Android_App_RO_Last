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

public class DeskCategory extends AppCompatActivity {

    // Desk Object Description
    private String deskDescription = "Sertare glisante cu dispozitiv împotriva deschiderii lor accidentale.\n" +

            "Partea din spate deschisă; facilitează organizarea cablurilor Această piesă de mobilier trebuie fixată pe perete cu ajutorul dispozitivului de fixare inclus.\n" +
            "\n" +
            "Pereţii sunt construiți din materiale diferite și, de aceea, necesită diferite tipuri de dispozitive de fixare. Foloseşte-le pe cele potrivite pentru pereții casei tale (se vând separat).";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_desks);

        getSupportActionBar().setTitle("Birouri");


        // Desks items
        final ArrayList<items> desks = new ArrayList<items>();
        desks.add(new items("Birou profesional", 223, R.drawable.desk1, R.drawable.desk11, R.drawable.desk111, "desk1.sfb", deskDescription));
        desks.add(new items("Birou clasic", 143, R.drawable.desk2, R.drawable.desk22, R.drawable.desk222, "desk2.sfb", deskDescription));
        desks.add(new items("Birou cu oglinda", 254, R.drawable.desk3, R.drawable.desk33, R.drawable.desk333, "desk3.sfb", deskDescription));
        desks.add(new items("Birou lemn masiv", 334, R.drawable.desk4, R.drawable.desk44, R.drawable.desk444, "desk4.sfb", deskDescription));
        desks.add(new items("Birou premium", 465, R.drawable.desk5, R.drawable.desk55, R.drawable.desk555, "desk5.sfb", deskDescription));
        desks.add(new items("Birou lemn", 123, R.drawable.desk1, R.drawable.desk11, R.drawable.desk111, "desk1.sfb", deskDescription));
        desks.add(new items("Birou Sofa", 243, R.drawable.desk2, R.drawable.desk22, R.drawable.desk222, "desk2.sfb", deskDescription));
        desks.add(new items("Birou Magnes", 254, R.drawable.desk3, R.drawable.desk33, R.drawable.desk333, "desk3.sfb", deskDescription));
        desks.add(new items("Birou Arnold", 134, R.drawable.desk4, R.drawable.desk44, R.drawable.desk444, "desk4.sfb", deskDescription));
        desks.add(new items("Birou dormitor", 365, R.drawable.desk5, R.drawable.desk55, R.drawable.desk555, "desk5.sfb", deskDescription));
        desks.add(new items("Birou Ardon", 223, R.drawable.desk1, R.drawable.desk11, R.drawable.desk111, "desk1.sfb", deskDescription));
        desks.add(new items("Birou silver", 143, R.drawable.desk2, R.drawable.desk22, R.drawable.desk222, "desk2.sfb", deskDescription));
        desks.add(new items("Birou Ardonis", 254, R.drawable.desk3, R.drawable.desk33, R.drawable.desk333, "desk3.sfb", deskDescription));
        desks.add(new items("Birou collage", 234, R.drawable.desk4, R.drawable.desk44, R.drawable.desk444, "desk4.sfb", deskDescription));
        desks.add(new items("Birou simplu", 565, R.drawable.desk5, R.drawable.desk55, R.drawable.desk555, "desk5.sfb", deskDescription));
        itemsAdapter itAdapter = new itemsAdapter(this, desks);

        // Get a reference to the ListView, and attach the adapter to the listView
        ListView listView = (ListView) findViewById(R.id.desk_category_list_view);
        listView.setAdapter(itAdapter);

         /* ========================================================================
                        Go to Details Activity with item
        ====================================================================*/

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                items e = desks.get(position);

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

                Intent intent = new Intent(DeskCategory.this, Details.class);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });
    }
}
