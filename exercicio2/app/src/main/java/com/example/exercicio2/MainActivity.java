package com.example.exercicio2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    private EditText Dice;
    private TextView TSides, Res;
    private SeekBar SSides;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Dice=findViewById(R.id.Dice);
        SSides=findViewById(R.id.SSides);
        TSides=findViewById(R.id.TSides);
        Res=findViewById(R.id.Res);

        SSides.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int faces, boolean b) {
                TSides.setText(String.valueOf(faces));
                play();
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        Dice.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                play();
            }
            @Override
            public void afterTextChanged(Editable editable) {
                play();
            }
        });

    }

    public void play(){
        Random r = new Random();
        int sum=0;
        if(Dice.getText().toString().isEmpty()||TSides.getText().toString().isEmpty()){
            Res.setText("Informe os valores");
        }else{
            int qtd = Integer.parseInt(Dice.getText().toString());
            int DFaces=Integer.parseInt(TSides.getText().toString());

            for(int i=0;i<qtd;i++){
                int value = r.nextInt(DFaces)+1;
                sum=sum+value;
            }
            String result="Soma dos resultados: "+sum;
            Res.setText(result);
        }

    }
}
