package com.dansapps.beeradvisor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class FindBeerActivity extends AppCompatActivity {
    private BeerExpert expert = new BeerExpert();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_beer); // tells android which layout the activity uses
    }

    // call when the user clicks the button
    public void onClickFindBeer(View view) {
        // get references
        TextView brands = (TextView) findViewById(R.id.brands);
        Spinner color = (Spinner) findViewById(R.id.color);

        // get type
        String beerType = String.valueOf(color.getSelectedItem());

        // get recommendations
        List<String> brandsList = expert.getBrands(beerType);
        StringBuilder brandsFormatted = new StringBuilder();

        // build string
        for (String brand : brandsList) {
            brandsFormatted.append(brand).append("\n");
        }

        // display string
        brands.setText(brandsFormatted);
    }
}