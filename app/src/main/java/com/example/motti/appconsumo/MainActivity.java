package com.example.motti.appconsumo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnCalcular;
    private EditText etAlcool, edGasolina;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalcular = findViewById(R.id.btnCalcular);
        edGasolina = findViewById(R.id.etGasolina);
        etAlcool = findViewById(R.id.etAlcool);
        tvResult = findViewById(R.id.tvResult);
    }

    public void CalcularPreco(View view){

       // tvResult.setText().toString();

        String precoAlcool = etAlcool.getText().toString();
        String precoGasolina = edGasolina.getText().toString();

        Boolean camposValidos = this.validarCampos(precoAlcool, precoGasolina);

        if (camposValidos){
            this.calculaPrecoMelhor(precoAlcool, precoGasolina);

        }else {
            tvResult.setText("Preencha os preços primeiros ");
        }
    }

    public boolean validarCampos(String pAlcool, String pGasolina) {

        Boolean camposValidos = true;

        if ( pAlcool == null || pAlcool.equals("")){
            camposValidos = false;

        }else if (pGasolina == null || pGasolina.equals("")){
            camposValidos = false;

        }
        return camposValidos;
    }
    public void calculaPrecoMelhor(String pAlcool, String pGasolina){

        double precoAlcool = Double.parseDouble(pAlcool);
        double precoGasolina = Double.parseDouble(pGasolina);

        Double resultado = precoAlcool / precoGasolina;
        if(resultado>=0.7){
            tvResult.setText("Gasolina ta melhor");
        }else{
            tvResult.setText("Alcool ta melhor");
        }

    }

}
