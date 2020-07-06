package com.example.licenta.checkout;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.licenta.MainActivity;
import com.example.licenta.R;

public class checkoutPayFinished extends AppCompatActivity {

    private TextView name, price, email, phone, address, courier;
    private Button backToShoppingBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkout_finish_pay);

        getSupportActionBar().setTitle("Comanda plasata");

        name = (TextView) findViewById(R.id.finish_pay_name);
        price = (TextView) findViewById(R.id.finish_pay_total_price);
        email = (TextView) findViewById(R.id.finish_pay_email);
        phone = (TextView) findViewById(R.id.finish_pay_phone);
        address = (TextView) findViewById(R.id.finish_pay_address);
        courier = (TextView) findViewById(R.id.finish_pay_courier);
        backToShoppingBtn = (Button) findViewById(R.id.finish_pay_back_to_shop_button);

     /*   ===========================================
                Get Data and display
        =============================================   */

        Bundle bundle = getIntent().getExtras();
        final int sPrice = bundle.getInt("OTotalPrice");
        final String sFirstName = bundle.getString("OFirstName");
        final String sLastName = bundle.getString("OLastName");
        final String sEmail = bundle.getString("OEmail");
        final String sPhone = bundle.getString("OPhone");
        final String sAddress = bundle.getString("OAddress");
        final String sCourier = bundle.getString("OCourier");

        name.setText(sFirstName + " " + sLastName);
        price.setText(sPrice + " RON");
        email.setText(sEmail);
        phone.setText(sPhone);
        address.setText(sAddress);
        courier.setText(sCourier);

        backToShoppingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(checkoutPayFinished.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
