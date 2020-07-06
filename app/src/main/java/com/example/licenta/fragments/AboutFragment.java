package com.example.licenta.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.example.licenta.R;

public class AboutFragment extends Fragment {

    private LinearLayout email, phone;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_about, container, false);

        email = (LinearLayout) root.findViewById(R.id.about_us_email_layout);
        phone = (LinearLayout) root.findViewById(R.id.about_us_call_layout);

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                Intent intent1 = Intent.createChooser(intent, null);
                startActivity(intent);
            }
        });

        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "0755945923"));
                startActivity(intent);
            }
        });
        return root;
    }
}
