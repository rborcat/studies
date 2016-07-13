package com.upversionlab.dolcegusto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CapsulasActivity extends AppCompatActivity {
    public final static String INGREDIENT_EXTRA = "Ingredient";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capsulas);

        Ingredient ingredient = getIntent().getParcelableExtra(INGREDIENT_EXTRA);

        TextView flavorText = (TextView) findViewById(R.id.activity_capsulas_flavor);
        TextView quantityText = (TextView) findViewById(R.id.activity_capsulas_quantity);

        flavorText.setText(ingredient.getFlavor());
        quantityText.setText(String.valueOf(ingredient.getQuantity()));
    }
}
