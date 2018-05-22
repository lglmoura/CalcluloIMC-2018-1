package br.edu.iff.pooa20181.calculoimc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText etPeso;
    private EditText etAltura;
    private Button btCalcular;
    private TextView tvMensagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPeso = (EditText) findViewById(R.id.etPeso);
        etAltura = (EditText) findViewById(R.id.etAltura);
        btCalcular = (Button) findViewById(R.id.btCalIMC);
        tvMensagem = (TextView) findViewById(R.id.tvMensagem);

        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcular();
            }
        });

    }
    private void calcular(){

        float peso = Float.parseFloat(etPeso.getText().toString());
        float altura = Float.parseFloat(etAltura.getText().toString());

        mostraMsg(peso/(altura*altura));
    }

    private void mostraMsg(float imc){
        String msg="";

        if(imc < 17.0){
            msg += " - Muito abaixo do Peso";

        }
        if(imc >=17.0 && imc <= 18.48){
            msg += " Abaixo do Peso";
        }


        tvMensagem.setText( (String.valueOf(imc).concat( msg)));
    }

}
