package com.upversionlab.dolcegusto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button capuccinoButton = (Button) findViewById(R.id.activity_main_capuccino_button);
        if (capuccinoButton != null) {
            capuccinoButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Ingredient ingredient = IngredientFactory.createIngredient(IngredientType.CAPPUCINO);
                    // List<Ingredient> ingredientList = new ArrayList<Ingredient>();
                    // ingredientList.add(ingredient);

                    Intent intent = new Intent(MainActivity.this, CapsulasActivity.class);
                    intent.putExtra(CapsulasActivity.INGREDIENT_EXTRA, ingredient);
                    startActivity(intent);
                }
            });
        }

        Button lungoButton = (Button) findViewById(R.id.activity_main_lungo_button);
        if (lungoButton != null) {
            lungoButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Ingredient ingredient = IngredientFactory.createIngredient(IngredientType.LUNGO);
                    // List<Ingredient> ingredientList = new ArrayList<Ingredient>();
                    // ingredientList.add(ingredient);

                    Intent intent = new Intent(MainActivity.this, CapsulasActivity.class);
                    intent.putExtra(CapsulasActivity.INGREDIENT_EXTRA, ingredient);
                    startActivity(intent);
                }
            });
        }

        Button espressoButton = (Button) findViewById(R.id.activity_main_espresso_button);
        if (espressoButton != null) {
            espressoButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Ingredient ingredient = IngredientFactory.createIngredient(IngredientType.ESPRESSO);
                    // List<Ingredient> ingredientList = new ArrayList<Ingredient>();
                    // ingredientList.add(ingredient);

                    Intent intent = new Intent(MainActivity.this, CapsulasActivity.class);
                    intent.putExtra(CapsulasActivity.INGREDIENT_EXTRA, ingredient);
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
