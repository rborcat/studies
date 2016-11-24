package com.upversionlab.hstracker.deck;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.upversionlab.hstracker.R;
import com.upversionlab.hstracker.model.Deck;
import com.upversionlab.hstracker.model.DeckDbHelper;

public class CreateDeckActivity extends AppCompatActivity {
    public final static String ADD_DECK_DECK_EXTRA = "ADD_DECK_DECK_EXTRA";
    private EditText deckName;
    private EditText deckClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_deck);

        deckName = (EditText) findViewById(R.id.create_deck_deck_name);
        deckClass = (EditText) findViewById(R.id.create_deck_deck_class);

        Button confirmButton = (Button) findViewById(R.id.create_deck_confirm);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateDeckActivity activity = CreateDeckActivity.this;
                String name = activity.deckName.getText().toString();
                String klass = activity.deckClass.getText().toString();

                long rowId = DeckDbHelper.createDeck(activity, name, klass);

                // the row ID of the newly inserted row, or -1 if an error occurred
                if (rowId != -1) {
                    Deck deck = new Deck((int) rowId, name, klass);
                    Intent intentResult = new Intent();
                    // Change the put extra to something that will come from AddExpenseActivity
                    intentResult.putExtra(CreateDeckActivity.ADD_DECK_DECK_EXTRA, deck);
                    activity.setResult(RESULT_OK, intentResult);
                } else {
                    activity.setResult(RESULT_CANCELED);
                }

                activity.finish();
            }
        });
    }
}
