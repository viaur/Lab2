package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    // These are the global variables
    EditText editLove;
    TextView result;
    Button buttonSubmit, buttonReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // setContentView loads objects onto the screen.
        // Before this function, the screen is empty.
        setContentView(R.layout.activity_main_linear);

        // Using the id of views specified in layout XML we can initialize the view using findViewById
        editLove  = (EditText) findViewById(R.id.love);
        result = (TextView) findViewById(R.id.text);

        final Button button = findViewById(R.id.button1);
        // Attaching OnClick listener to the submit button
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // get text from EditText name view
                String love = editLove.getText().toString();
                result.setText(love);
                Toast.makeText(MainActivity.this, getString(R.string.toast_message), Toast.LENGTH_LONG).show();
            }
        });


        CheckBox cb = findViewById(R.id.checkb);
        cb.setOnCheckedChangeListener( (compoundButton, b) -> {

                Snackbar.make(cb, "The checkbox is now " + b, Snackbar.LENGTH_LONG)
                        .setAction("Undo", click-> compoundButton.setChecked( !b ))
                        .show();

    });
    }
}