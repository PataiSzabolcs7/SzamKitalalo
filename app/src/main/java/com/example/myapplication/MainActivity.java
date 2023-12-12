package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Random random;
    int randomSzam,tippekSzama;
    ImageView elet1,elet2,elet3;
    EditText tipp;
    Button ellenorzes;

    TextView eredmeny;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        ellenorzes.setOnClickListener(v -> {
            if (tipp.getText().toString().isEmpty()) {
                tipp.setError("Nem adtál meg számot!");
                return;
            }
            int tippSzam = Integer.parseInt(tipp.getText().toString());
            if (tippSzam < 1 || tippSzam > 10) {
                tipp.setError("1 és 10 közötti számot adj meg!");
                return;
            }
            tippekSzama++;
            if (tippSzam == randomSzam) {
                eredmeny.setText("Gratulálok, eltaláltad " + tippekSzama + " tippből!");
                ellenorzes.setEnabled(false);
            } else {
                if (tippekSzama == 1) {
                    elet3.setImageResource(R.drawable.empty_heart);
                } else if (tippekSzama == 2) {
                    elet2.setImageResource(R.drawable.empty_heart);
                } else {
                    elet1.setImageResource(R.drawable.empty_heart);
                    eredmeny.setText("Sajnos nem találtad el " + tippekSzama + " tippből!");
                    ellenorzes.setEnabled(false);
                }
            }
        });
    }
    void init(){
        random = new Random();
        randomSzam = random.nextInt(10)+1;
        tippekSzama = 0;
        tipp =findViewById(R.id.tipp);
        ellenorzes=findViewById(R.id.ellenorzes);
        elet1 = findViewById(R.id.elet1);
        elet2 = findViewById(R.id.elet2);
        elet3 = findViewById(R.id.elet3);
        eredmeny = findViewById(R.id.eredmeny);
        eredmeny.setText(String.valueOf(randomSzam));

    }
}