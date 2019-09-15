package com.example.currencyconversionapp;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    double euroConversion = 0.89961;
    double canConversion = 1.32718;
    double mxnConversion = 19.4051;
    int currencyEntered;
    double currencyConversion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        final RadioButton europe = (RadioButton) findViewById(R.id.radEuro);
        final RadioButton canada = (RadioButton) findViewById(R.id.radCanadian);
        final RadioButton mexico = (RadioButton) findViewById(R.id.radMXN);
        final EditText money = (EditText) findViewById(R.id.txtCurrency);
        final TextView result = (TextView) findViewById(R.id.txtResult);
        Button conversion = (Button) findViewById(R.id.btnConvert);

        conversion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currencyEntered = Integer.parseInt(money.getText().toString());
                DecimalFormat ecurrency = new DecimalFormat("€###,###.##");
                DecimalFormat currency = new DecimalFormat("$###,###.##");

                if(europe.isChecked()) {
                    if(currencyEntered <= 100000) {
                        currencyConversion = currencyEntered * euroConversion;
                        result.setText(ecurrency.format(currencyConversion) + " Euros");
                    } else {
                        Toast.makeText(MainActivity.this, "Cannot enter more than $100,000", Toast.LENGTH_LONG).show();
                    }

                }

                if(canada.isChecked()) {
                    if(currencyEntered <= 100000) {
                        currencyConversion = currencyEntered * canConversion;
                        result.setText(currency.format(currencyConversion) + " Canadian Dollar");
                    } else {
                        Toast.makeText(MainActivity.this, "Cannot enter more than $100,000", Toast.LENGTH_LONG).show();
                    }

                }

                if(mexico.isChecked()) {
                    if(currencyEntered <= 100000) {
                        currencyConversion = currencyEntered * mxnConversion;
                        result.setText(currency.format(currencyConversion) + " Mexican Peso");
                    } else {
                        Toast.makeText(MainActivity.this, "Cannot enter more than $100,000", Toast.LENGTH_LONG).show();
                    }

                }

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
