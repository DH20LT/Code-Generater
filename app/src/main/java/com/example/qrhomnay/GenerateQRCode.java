package com.example.qrhomnay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.material.chip.Chip;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class GenerateQRCode extends AppCompatActivity {
    ImageView iv_Code;
    EditText et_Input;
    Button btn_Generate;
    Chip chipBarcode;
    Chip chipQRCode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_qrcode);

        chipBarcode.setChecked(true); // Bật nút này khi mở act

        AddControls();
        AddEvents();
    }

    private void AddEvents() {
        chipBarcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chipQRCode.setChecked(false);
            }
        });

        chipQRCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chipBarcode.setChecked(false);
            }
        });

        btn_Generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GenerateQRCode();
            }
        });
    }

    private void AddControls() {
        iv_Code = findViewById(R.id.iv_qr_code);
        et_Input = findViewById(R.id.et_input);
        btn_Generate = findViewById(R.id.btn_generate);
        chipBarcode = findViewById(R.id.chip_barcode);
        chipQRCode = findViewById(R.id.chip_qrcode);
    }

    private void GenerateQRCode() {
        // Lấy dữ liệu đầu vào
        String text = et_Input.getText().toString().trim();

        // Multi format writer
        MultiFormatWriter writer = new MultiFormatWriter();
        try {
            // Create Bit matrix from text
            BitMatrix matrix = writer.encode(text, BarcodeFormat.QR_CODE, 300 ,300);

            // Barcode encoder
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();

            // Create Bitmap from Bit Matrix
            Bitmap bitmap = barcodeEncoder.createBitmap(matrix);

            // Đẩy mã QR lên imageView
            iv_Code.setImageBitmap(bitmap);

            // Set Input Method
            InputMethodManager manager = (InputMethodManager) getSystemService(
                    Context.INPUT_METHOD_SERVICE
            );

            // Hide keyboard - neu khong an thi no sao luon hien sa?
            manager.hideSoftInputFromWindow(et_Input.getApplicationWindowToken(), 0);

        } catch (WriterException e) {
            e.printStackTrace();
        }
    }

    private void GenerateBarcode() {
        // Lấy dữ liệu đầu vào
        String text = et_Input.getText().toString().trim();

        // Multi format writer
        MultiFormatWriter writer = new MultiFormatWriter();
        try {
            // Create Bit matrix from text
            BitMatrix matrix = writer.encode(text, BarcodeFormat.CODE_128, 300 ,300);

            // Barcode encoder
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();

            // Create Bitmap from Bit Matrix
            Bitmap bitmap = barcodeEncoder.createBitmap(matrix);

            // Đẩy mã QR lên imageView
            iv_Code.setImageBitmap(bitmap);

            // Set Input Method
            InputMethodManager manager = (InputMethodManager) getSystemService(
                    Context.INPUT_METHOD_SERVICE
            );

            // Hide keyboard - neu khong an thi no sao luon hien sa?
            manager.hideSoftInputFromWindow(et_Input.getApplicationWindowToken(), 0);

        } catch (WriterException e) {
            e.printStackTrace();
        }
    }
}