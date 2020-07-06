package com.example.licenta.checkout;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.licenta.R;
import com.example.licenta.SQLite.DatabaseHelper;
import com.example.licenta.adapter.items;

public class checkout extends AppCompatActivity {

    private EditText firstName, lastName, address, phone, email, courier;
    private Button cashOnDelivery, payOnline;
    private TextView cashToPayTextView;
    private DatabaseHelper db;
    private int totalPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkout_pay);

        getSupportActionBar().setTitle("Plasare comanda");


        /*====================================================================
                    Find View By ID and set price from database
        ====================================================================    */

        firstName = (EditText) findViewById(R.id.checkout_first_name);
        lastName = (EditText) findViewById(R.id.checkout_last_name);
        address = (EditText) findViewById(R.id.checkout_address);
        phone = (EditText) findViewById(R.id.checkout_phone);
        email = (EditText) findViewById(R.id.checkout_email);
        courier = (EditText) findViewById(R.id.checkout_courier);
        cashToPayTextView = (TextView) findViewById(R.id.checkout_total_price);
        payOnline = (Button) findViewById(R.id.checkout_bank_card);
        cashOnDelivery = (Button) findViewById(R.id.checkout_cash_on_delivery);

        db = new DatabaseHelper(this);

        totalPrice = db.sumPriceCartItems();
        cashToPayTextView.setText(totalPrice + " RON");

      /*  ==================================================================
                        Place Order Buttons
         =================================================================  */

        cashOnDelivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String sFirstName = firstName.getText().toString();
                final String sLastName = lastName.getText().toString();
                final String sAddress = address.getText().toString();
                final String sPhone = phone.getText().toString();
                final String sEmail = email.getText().toString();
                final String sCourier = courier.getText().toString();

                Bundle bOrder = new Bundle();
                bOrder.putString("OFirstName", sFirstName);
                bOrder.putString("OLastName", sLastName);
                bOrder.putString("OAddress", sAddress);
                bOrder.putString("OPhone", sPhone);
                bOrder.putString("OEmail", sEmail);
                bOrder.putString("OCourier", sCourier);
                bOrder.putInt("OTotalPrice", totalPrice);

                if (sFirstName.equals("") && sLastName.equals("") && sAddress.equals("") && sPhone.equals("") && sEmail.equals("")) {
                    Toast.makeText(checkout.this, "Completati campurile obligatorii!", Toast.LENGTH_SHORT).show();
                } else {
                    items items = new items(totalPrice, "Rammburs");
                    Intent intent = new Intent(checkout.this, checkoutPayFinished.class);
                    db.insertMyOrders(items);
                    intent.putExtras(bOrder);
                    startActivity(intent);
                }
            }
        });
        payOnline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String sFirstName = firstName.getText().toString();
                final String sLastName = lastName.getText().toString();
                final String sAddress = address.getText().toString();
                final String sPhone = phone.getText().toString();
                final String sEmail = email.getText().toString();
                final String sCourier = courier.getText().toString();

                Bundle bOrder = new Bundle();
                bOrder.putString("OFirstName", sFirstName);
                bOrder.putString("OLastName", sLastName);
                bOrder.putString("OAddress", sAddress);
                bOrder.putString("OPhone", sPhone);
                bOrder.putString("OEmail", sEmail);
                bOrder.putString("OCourier", sCourier);
                bOrder.putInt("OTotalPrice", totalPrice);
                if (sFirstName.equals("") && sLastName.equals("") && sAddress.equals("") && sPhone.equals("") && sEmail.equals("")) {
                    Toast.makeText(checkout.this, "Completati campurile obligatorii!", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(checkout.this, checkoutPayOnline.class);
                    intent.putExtras(bOrder);
                    startActivity(intent);
                }
            }
        });
    }

}






