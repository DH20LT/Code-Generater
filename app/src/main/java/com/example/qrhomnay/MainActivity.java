package com.example.qrhomnay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button QuetQR;
    Button TaoQR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AddControls();
        AddEvents();
    }

    private void AddEvents() {
        QuetQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        TaoQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    // Dung de anh xa
    private void AddControls() {
        QuetQR = findViewById(R.id.quet_qr);
        TaoQR = findViewById(R.id.tao_qr);
    }


}