package fr.m2i.convertisseur_monnaies;

import android.app.Activity;
import android.hardware.Camera;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    private EditText txtUSD;
    private EditText txtEUR;

    private final double TAUX = 1.1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUSD = (EditText) findViewById(R.id.txtUSD);
        txtEUR = (EditText) findViewById(R.id.txtEUR);

        txtUSD.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean bernard) {
                try {
                    String sUsd = txtUSD.getText().toString().replace(',', '.');
                    double usd = Double.parseDouble(sUsd);
                    double eur = usd * TAUX;
                    txtEUR.setText(String.format("%.2f", eur));
                }
                catch(Exception ex) {

                }
            }
        });

        txtEUR.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String sEur = txtEUR.getText().toString().replace(',','.');
                double eur = Double.parseDouble(sEur);
                double usd = eur / TAUX;
                txtUSD.setText(String.format("%.2f", usd));

            }
        });

    }

    public void calculate(View v){
        double usd = Double.parseDouble(txtUSD.getText().toString());
        Double eur = usd * TAUX;
        txtEUR.setText(String.format("%.2f", eur));
    }

    public void quit(View v){
        finish();
    }
}
