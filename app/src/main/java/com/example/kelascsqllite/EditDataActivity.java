package com.example.kelascsqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kelascsqllite.database.DBController;

import java.util.HashMap;

public class EditDataActivity extends AppCompatActivity {

    EditText edNama, edNotel;
    Button btnSimpan;

    DBController controller = new DBController(this );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_data);

        edNama = findViewById(R.id.ednama);
        edNotel = findViewById(R.id.ednotel);
        btnSimpan = findViewById(R.id.buttonsave);

        String nama = getIntent().getStringExtra("nama");
        String telpon = getIntent().getStringExtra("nomor");
        String position = getIntent().getStringExtra("position");

        edNama.setText(nama);
        edNotel.setText(telpon);

        btnSimpan.setOnClickListener(v -> {

            if(edNama.getText().toString().equals("")||edNotel.getText().toString().equals("")){
                Toast.makeText(getApplicationContext(),"Data belum komplit !",Toast.LENGTH_SHORT).show();
            }else {
                String nm = edNama.getText().toString();
                String tlp = edNotel.getText().toString();

                HashMap<String,String> qvalues = new HashMap<>();
                qvalues.put("nama",nm);
                qvalues.put("telpon",tlp);

                controller.editData(qvalues, position);
                Toast.makeText(getApplicationContext(),"Berhasil di perbarui !",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(EditDataActivity.this, DetailActivity.class);

                intent.putExtra("nama", nm);
                intent.putExtra("nomor", tlp);
                startActivity(intent);
                finish();
            }


        });
    }

}