package vv008146.reading.ac.uk.higherlower;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class GuessActivity extends AppCompatActivity {

    private int toGuess;
    private int numberOfGuesses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        this.toGuess = new Random().nextInt(100);

        final EditText guessField = (EditText) this.findViewById(R.id.editGuess);
        final Button guessButton = (Button) this.findViewById(R.id.btnGuess);
        final Button regenerateButton = (Button) this.findViewById(R.id.btnRegenerate);
        final TextView numGuesses = (TextView) this.findViewById(R.id.txtNumGuesses);

        guessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                numberOfGuesses++;
                numGuesses.setText(String.valueOf(numberOfGuesses));

                int convertedInput = Integer.parseInt(guessField.getText().toString());

                if(convertedInput == toGuess) {
                    // Success!
                    generateAlert("Good work! You got it in " + numberOfGuesses + " guesses!");

                }
                else if(convertedInput < toGuess) {
                    // Go higher!
                    generateAlert("Go higher!");
                } else {
                    // Go lower!
                    generateAlert("Go lower!");
                }


            }
        });

        regenerateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberOfGuesses = 0;
                numGuesses.setText(String.valueOf(numberOfGuesses));
                toGuess = new Random().nextInt(100);
            }
        });

    }

    private void generateAlert(String text) {
        new AlertDialog.Builder(this)
                .setMessage(text)
                .setIcon(android.R.drawable.ic_dialog_info)
                .show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_guess, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
