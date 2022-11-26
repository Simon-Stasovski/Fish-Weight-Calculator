package com.example.fishweightcalculator_simonstasovski;

import static com.example.fishweightcalculator_simonstasovski.R.*;

import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    View view;
    //private MainActivity currentInstance = this;
    //Context context = currentInstance.getApplicationContext();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);

        Button fishWeight_Button = findViewById(R.id.freshWaterFishFragment_Button);
        Button saltWaterFishWeight_Button = findViewById(R.id.saltWaterFishFragment_Button);
        fishWeight_Button.setOnClickListener(view -> {
            LoadFragment(new FreshWaterFishFragment());
        });

        saltWaterFishWeight_Button.setOnClickListener(view -> LoadFragment(new SaltWaterFishFragment()));
    }

    private void LoadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().add(id.calculator_frameLayout, fragment).commit();
    }
}