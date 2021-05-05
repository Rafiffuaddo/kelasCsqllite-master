package com.example.kelascsqllite;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView txNama, txTelpon;
    Button btnEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        txNama = findViewById(R.id.textNama);
        txTelpon = findViewById(R.id.textTelpon);
        btnEdit = findViewById(R.id.btnEdit);

        String nama = getIntent().getStringExtra("nama");
        String telpon = getIntent().getStringExtra("nomor");
        String position = getIntent().getStringExtra("position");

        txNama.setText(nama);
        txTelpon.setText(telpon);

        btnEdit.setOnClickListener(v -> {
            Intent intent = new Intent(DetailActivity.this, EditDataActivity.class);
            intent.putExtra("nama", nama);
            intent.putExtra("nomor", telpon);
            intent.putExtra("position", position);
            startActivity(intent);
        });

    }
}
