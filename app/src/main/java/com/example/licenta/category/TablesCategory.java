package com.example.licenta.category;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.example.licenta.R;
import java.util.ArrayList;
import com.example.licenta.*;
import com.example.licenta.adapter.items;
import com.example.licenta.adapter.itemsAdapter;

public class TablesCategory extends AppCompatActivity {

    // product table description
    private String tablesDescription = "Găuri din construcţie pentru picioare, pentru o asamblare uşoară.\n" +
            "\n" +
            "Picioarele reglabile asigură stabilitatea mesei chiar şi pe suprafeţe denivelate.\n" +
            "\n" +
            "Sunt incluse şuruburi pentru fixarea picioarelor la blat. Combină şi asortează cu blatul şi picioarele alese de tine sau foloseşte această combinaţie. Solidă şi uşoară," +
            " masa este fabricată cu tehnică.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_tables);

        getSupportActionBar().setTitle("Mese");

        // Tables products
        final ArrayList<items> tables = new ArrayList<items>();
        tables.add(new items("Masa lemn", 213, R.drawable.table1, R.drawable.table11, R.drawable.table111, "table1.sfb", tablesDescription));
        tables.add(new items("Masa rotunda", 432, R.drawable.table2, R.drawable.table22, R.drawable.table222, "table2.sfb", tablesDescription));
        tables.add(new items("Masa bucatarie", 543, R.drawable.table3, R.drawable.table33, R.drawable.table333, "table3.sfb", tablesDescription));
        tables.add(new items("Masa cafenea", 342, R.drawable.table4, R.drawable.table44, R.drawable.table444, "table4.sfb", tablesDescription));
        tables.add(new items("Masa stejar", 625, R.drawable.table5, R.drawable.table55, R.drawable.table555, "table5.sfb", tablesDescription));
        tables.add(new items("Masa sufragerie", 231, R.drawable.table1, R.drawable.table11, R.drawable.table111, "table1.sfb", tablesDescription));
        tables.add(new items("Masa inalta", 431, R.drawable.table2, R.drawable.table22, R.drawable.table222, "table2.sfb", tablesDescription));
        tables.add(new items("Masa arnold", 524, R.drawable.table3, R.drawable.table33, R.drawable.table333, "table3.sfb", tablesDescription));
        tables.add(new items("Masa scandinava", 343, R.drawable.table4, R.drawable.table44, R.drawable.table444, "table4.sfb", tablesDescription));
        tables.add(new items("Masa arduino", 265, R.drawable.table5, R.drawable.table55, R.drawable.table555, "table5.sfb", tablesDescription));
        tables.add(new items("Masa dormitor", 213, R.drawable.table1, R.drawable.table11, R.drawable.table111, "table1.sfb", tablesDescription));
        tables.add(new items("Masa casual", 432, R.drawable.table2, R.drawable.table22, R.drawable.table222, "table2.sfb", tablesDescription));
        tables.add(new items("Masa lemn masiv", 534, R.drawable.table3, R.drawable.table33, R.drawable.table333, "table3.sfb", tablesDescription));
        tables.add(new items("Masa universala", 314, R.drawable.table4, R.drawable.table44, R.drawable.table444, "table4.sfb", tablesDescription));
        tables.add(new items("Masa Sofa", 625, R.drawable.table5, R.drawable.table55, R.drawable.table555, "table5.sfb", tablesDescription));

        itemsAdapter itAdapter = new itemsAdapter(this, tables);

        // Get a reference to the ListView, and attach the adapter to the listView
        ListView listView = (ListView) findViewById(R.id.tables_category_list_view);
        listView.setAdapter(itAdapter);

         /* ========================================================================
                        Go to Details Activity with item
        ====================================================================*/

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                items e = tables.get(position);

                String name = e.getlName();
                int price = e.getlPrice();
                String details = e.getlDetails();
                int im = e.getlImageId();
                int im1 = e.getlImageId1();
                int im2 = e.getlImageId2();
                String model = e.getlModel();

                Bundle bundle = new Bundle();
                bundle.putString("Model", model);
                bundle.putString("Name", name);
                bundle.putInt("Price", price);
                bundle.putString("Details", details);
                bundle.putInt("Image", im);
                bundle.putInt("Image1", im1);
                bundle.putInt("Image2", im2);

                Intent intent = new Intent(TablesCategory.this, Details.class);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });
    }
}
