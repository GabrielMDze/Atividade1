package com.example.exercicio1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText Score1, Score2, Score3, Total1, Total2, Total3;
    private CheckBox Check;
    private TextView TMedia;
    private boolean checked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Score1 = findViewById(R.id.Score1);
        Score2 = findViewById(R.id.Score2);
        Score3 = findViewById(R.id.Score3);
        Total1 = findViewById(R.id.Total1);
        Total2 = findViewById(R.id.Total2);
        Total3 = findViewById(R.id.Total3);
        Check = findViewById(R.id.Check);
        TMedia = findViewById(R.id.TMedia);

        Score1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                calc();
            }
            @Override
            public void afterTextChanged(Editable editable) {
                calc();
            }
        });

        Score2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                calc();
            }

            @Override
            public void afterTextChanged(Editable editable) {
                calc();
            }
        });

        Score3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                calc();
            }

            @Override
            public void afterTextChanged(Editable editable) {
                calc();
            }
        });

        Total1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(checked){
                    calc();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(checked){
                    calc();
                }
            }
        });

        Total2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(checked){
                    calc();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(checked){
                    calc();
                }
            }
        });

        Total3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(checked){
                    calc();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(checked){
                    calc();
                }
            }
        });

        Check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                checked = b;
                calc();
            }
        });


    }


    public void calc() {
        if (Score1.getText().toString().isEmpty() || Score2.getText().toString().isEmpty() || Score3.getText().toString().isEmpty()) {
            TMedia.setText("Informe todas as notas");
        } else {
            String valor = Score1.getText().toString();
            double score1 = Double.parseDouble(valor);
            valor = Score2.getText().toString();
            double score2 = Double.parseDouble(valor);
            valor = Score3.getText().toString();
            double score3 = Double.parseDouble(valor);
            double avg=0;
            int format;

            if (!checked) {
                avg = ((score1 + score2 + score3) / 3) * 10;
                format = (int) avg;
                avg = (double) format / 10;

                if (avg >= 9) {
                    TMedia.setText("A");
                } else if (avg >= 8 && avg < 9) {
                    TMedia.setText("B");
                } else if (avg >= 7 && avg < 8) {
                    TMedia.setText("C");
                } else if (avg >= 4 && avg < 7) {
                    TMedia.setText("D");
                } else if (avg < 4) {
                    TMedia.setText("E");
                }
            } else {
                if (Total1.getText().toString().isEmpty() || Total2.getText().toString().isEmpty() || Total3.getText().toString().isEmpty()) {
                    TMedia.setText("Informe os pesos das provas");
                } else {
                    valor = Total1.getText().toString();
                    double peso1 = Double.parseDouble(valor);
                    valor = Total2.getText().toString();
                    double peso2 = Double.parseDouble(valor);
                    valor = Total3.getText().toString();
                    double peso3 = Double.parseDouble(valor);

                    avg = (((score1 * peso1) + (score2 * peso2) + (score3 * peso3)) / (peso1 + peso2 + peso3)) * 10;
                    format = (int) avg;
                    avg = (double) format / 10;

                    if (avg >= 9) {
                        TMedia.setText("A");
                    } else if (avg >= 8 && avg < 9) {
                        TMedia.setText("B");
                    } else if (avg >= 7 && avg < 8) {
                        TMedia.setText("C");
                    } else if (avg >= 4 && avg < 7) {
                        TMedia.setText("D");
                    } else if (avg < 4) {
                        TMedia.setText("E");
                    }
                }

            }


        }

    }


}
