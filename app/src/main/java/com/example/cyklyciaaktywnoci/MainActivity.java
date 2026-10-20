package com.example.cyklyciaaktywnoci;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button plus,minus;
    TextView wynik;
    int punkty = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        plus = findViewById(R.id.button);
        minus = findViewById(R.id.button2);
        wynik = findViewById(R.id.punkty);
        wynik.setText(punkty+"");
        plus.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        punkty++;
                        wynik.setText(String.valueOf(punkty));
                    }
                }
        );
        minus.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        punkty--;
                        wynik.setText(String.valueOf(punkty));
                    }
                }
        );
        Log.i("czas","Wywolana metoda on creae");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("czas","Wywolana metoda on start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("czas","Wywolana metoda on resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("czas","Wywolana metoda on pause,");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("czas","Wywolana metoda on destroy");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("czas","Wywolana metoda on save");
        outState.putInt("punkty",punkty);
    }
}