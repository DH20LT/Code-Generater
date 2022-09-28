package com.example.qrhomnay;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

public class GenerateQRCode extends AppCompatActivity {
    ImageView iv_QRCode;
    EditText et_Input;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_qrcode);

        AddControls();
        AddEvents();
    }

    private void AddEvents() {

    }

    private void AddControls() {
        iv_QRCode = findViewById(R.id.iv_qr_code);
        et_Input = findViewById(R.id.et_input);
    }
}