package com.upversionlab.dolcegusto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String cappucinoIngredient = "Leite";
    private static final String cappucinoQuantity = "100 ml";
    private static final String lungoIngredient = "Lungo";
    private static final String lungoQuantity = "120 ml";
    private static final String espressoIngredient = "Espresso";
    private static final String espressoQuantity = "20 ml";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button capuccinoButton = (Button) findViewById(R.id.activity_main_capuccino_button);
        if (capuccinoButton != null) {
            capuccinoButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, CapsulasActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("Ingredient", cappucinoIngredient);
                    bundle.putString("Quantity", cappucinoQuantity);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            });
        }

        Button lungoButton = (Button) findViewById(R.id.activity_main_lungo_button);
        if (lungoButton != null) {
            lungoButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, CapsulasActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("Ingredient", lungoIngredient);
                    bundle.putString("Quantity", lungoQuantity);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            });
        }

        Button espressoButton = (Button) findViewById(R.id.activity_main_espresso_button);
        if (espressoButton != null) {
            espressoButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, CapsulasActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("Ingredient", espressoIngredient);
                    bundle.putString("Quantity", espressoQuantity);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            });
        }
    }
}
