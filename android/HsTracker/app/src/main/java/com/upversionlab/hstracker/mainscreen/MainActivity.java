package com.upversionlab.hstracker.mainscreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.upversionlab.hstracker.deck.CreateDeckActivity;
import com.upversionlab.hstracker.R;
import com.upversionlab.hstracker.model.Deck;

public class MainActivity extends AppCompatActivity {
    private final static int ADD_DECK_REQUEST_CODE = 1;
    public static final String DECK_EXTRA = "DECK_EXTRA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.activity_main_toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.activity_main_add_deck_button);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CreateDeckActivity.class);
                startActivityForResult(intent, ADD_DECK_REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == ADD_DECK_REQUEST_CODE && resultCode == RESULT_OK) {
            Deck deck = (Deck) data.getSerializableExtra(CreateDeckActivity.ADD_DECK_DECK_EXTRA);
            pickDeck(deck);
        } else {
            // err
        }
    }

    private void pickDeck(Deck deck){
        Intent intentResult = new Intent();
        intentResult.putExtra(DECK_EXTRA, deck);
        setResult(RESULT_OK, intentResult);
    }
}
