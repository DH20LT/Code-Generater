package com.example.qrhomnay;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

public class MainActivity extends AppCompatActivity {
    Button QuetQR;
    Button TaoQR;
    TextView ResultScan;

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
            ScanCode();
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
        ResultScan = findViewById(R.id.result_scan);
    }

    private void ScanCode() {
        ScanOptions options = new ScanOptions()
                .setPrompt("Bai QR Code Hom Nay")
                .setBeepEnabled(true)
                .setOrientationLocked(true)
                .setCaptureActivity(CaptureQRCode.class);
        scan.launch(options);
    }

    ActivityResultLauncher<ScanOptions> scan = registerForActivityResult(new ScanContract(), result ->{
        if(result.getContents() != null){
            AlertDialog.Builder thongbao = new AlertDialog.Builder(MainActivity.this);
            thongbao.setTitle("Ket Qua");
            thongbao.setMessage(result.getContents());
            thongbao.setPositiveButton("Copy", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    ClipboardManager clipboardManager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                    ClipData clipData = ClipData.newPlainText("Ket Qua", result.getContents());
                    clipboardManager.setPrimaryClip(clipData);
                    ResultScan.setText(result.getContents());
                    Toast.makeText(MainActivity.this, "Da copy thanh cong", Toast.LENGTH_SHORT).show();
                }
            }).setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            }).create().show();
        } else
        {
            Toast.makeText(MainActivity.this, "That bai", Toast.LENGTH_SHORT).show();
        }
    });
}