package com.example.licenta.checkout;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.example.licenta.adapter.*;
import com.example.licenta.R;
import com.example.licenta.SQLite.DatabaseHelper;

public class checkoutPayOnline extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private EditText cardNumber, cardMonth, cardYear, cardCVV;
    private Button placeOrder;
    private TextView price;
    private DatabaseHelper db;
    private String cardNumberS, cardMonthS, cardYearS, cardCVVS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkout_pay_online);

        getSupportActionBar().setTitle("Plasare comanda");

        db = new DatabaseHelper(this);

        radioGroup = (RadioGroup) findViewById(R.id.checkout_pay_online_radio_group);
        cardNumber = (EditText) findViewById(R.id.checkout_pay_online_card_number);
        cardMonth = (EditText) findViewById(R.id.checkout_pay_online_month);
        cardYear = (EditText) findViewById(R.id.checkout_pay_online_year);
        cardCVV = (EditText) findViewById(R.id.checkout_pay_online_cvv);
        placeOrder = (Button) findViewById(R.id.checkout_pay_online_place_order);
        price = (TextView) findViewById(R.id.checkout_pay_online_price);

         /*   ========================================================
             Get Data from checkout via bundle and sent for finish pay
        ===============================================================  */
        Bundle bundle = getIntent().getExtras();
        final int sPrice = bundle.getInt("OTotalPrice");
        final String sFirstName = bundle.getString("OFirstName");
        final String sLastName = bundle.getString("OLastName");
        final String sEmail = bundle.getString("OEmail");
        final String sPhone = bundle.getString("OPhone");
        final String sAddress = bundle.getString("OAddress");
        final String sCourier = bundle.getString("OCourier");

        Bundle bOrder = new Bundle();
        bOrder.putString("OFirstName", sFirstName);
        bOrder.putString("OLastName", sLastName);
        bOrder.putString("OAddress", sAddress);
        bOrder.putString("OPhone", sPhone);
        bOrder.putString("OEmail", sEmail);
        bOrder.putString("OCourier", sCourier);
        bOrder.putInt("OTotalPrice", sPrice);

        price.setText("Total de plata: "+sPrice + " RON");

        placeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cardCVVS = cardCVV.getText().toString();
                cardMonthS = cardMonth.getText().toString();
                cardNumberS = cardNumber.getText().toString();
                cardYearS = cardYear.getText().toString();

                if (cardCVVS.equals("") && cardNumberS.equals("") && cardMonthS.equals("") && cardYearS.equals("")) {
                    Toast.makeText(checkoutPayOnline.this, "Completati datele cardului", Toast.LENGTH_SHORT).show();
                } else {
                    items items = new items(sPrice, "Card");
                    db.insertMyOrders(items);
                    Intent intent = new Intent(checkoutPayOnline.this, checkoutPayFinished.class);
                    intent.putExtras(bOrder);
                    startActivity(intent);
                }
            }
        });

    }
}
