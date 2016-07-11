package com.upversionlab.dolcegusto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String CAPUCCINO_FLAVOR = "Leite";
    private static final int CAPUCCINO_QUANTITY = 100;
    private static final String LUNGO_FLAVOR = "Lungo";
    private static final int LUNGO_QUANTITY = 120;
    private static final String ESPRESSO_FLAVOR = "Espresso";
    private static final int ESPRESSO_QUANTITY = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button capuccinoButton = (Button) findViewById(R.id.activity_main_capuccino_button);
        if (capuccinoButton != null) {
            capuccinoButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Ingredient ingredient = new Ingredient(CAPUCCINO_FLAVOR, CAPUCCINO_QUANTITY);
                    // List<Ingredient> ingredientList = new ArrayList<Ingredient>();
                    // ingredientList.add(ingredient);

                    Intent intent = new Intent(MainActivity.this, CapsulasActivity.class);
                    intent.putExtra("Ingredient", ingredient);
                    startActivity(intent);
                }
            });
        }

        Button lungoButton = (Button) findViewById(R.id.activity_main_lungo_button);
        if (lungoButton != null) {
            lungoButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Ingredient ingredient = new Ingredient(LUNGO_FLAVOR, LUNGO_QUANTITY);
                    // List<Ingredient> ingredientList = new ArrayList<Ingredient>();
                    // ingredientList.add(ingredient);

                    Intent intent = new Intent(MainActivity.this, CapsulasActivity.class);
                    intent.putExtra("Ingredient", ingredient);
                    startActivity(intent);
                }
            });
        }

        Button espressoButton = (Button) findViewById(R.id.activity_main_espresso_button);
        if (espressoButton != null) {
            espressoButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Ingredient ingredient = new Ingredient(ESPRESSO_FLAVOR, ESPRESSO_QUANTITY);
                    // List<Ingredient> ingredientList = new ArrayList<Ingredient>();
                    // ingredientList.add(ingredient);

                    Intent intent = new Intent(MainActivity.this, CapsulasActivity.class);
                    intent.putExtra("Ingredient", ingredient);
                    startActivity(intent);
                }
            });
        }

        Button aboutButton = (Button) findViewById(R.id.activity_main_about);
        if (aboutButton != null) {
            aboutButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                    startActivity(intent);
                }
            });

        }
    }
}
