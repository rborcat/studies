package com.upversionlab.dolcegusto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CapsulasActivity extends AppCompatActivity {
    private String ingredient;
    private String quantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capsulas);

        Bundle bundle = getIntent().getExtras();
        ingredient = bundle.getString("Ingredient");
        quantity = bundle.getString("Quantity");


        TextView ingredientText = (TextView) findViewById(R.id.activity_capsulas_ingredient);
        TextView quantityText = (TextView) findViewById(R.id.activity_capsulas_quantity);

        ingredientText.setText(ingredient);
        quantityText.setText(quantity);
    }
}
