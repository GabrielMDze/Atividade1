package com.example.exercicio3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView diceResult, cases;
    private int values[] = new int[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        diceResult = findViewById(R.id.diceResult);
        cases = findViewById(R.id.cases);

    }

    public void play(View view) {
        for (int i = 0; i < 5; i++) {
            values[i] = rollDice();
        }
        sort(values);
        String resultado = "Resultados\n" + values[0] + ", " + values[1] + ", " + values[2] + ", " + values[3] + ", " + values[4];
        diceResult.setText(resultado);
        verify(values);
    }

    public int rollDice() {
        Random r = new Random();
        int n = r.nextInt(6) + 1;
        return n;
    }

    public static int[] sort(int[] v) {
        for (int i = 0; i < v.length - 1; i++) {
            int pos = i;
            for (int j = i + 1; j < v.length; j++)
                if (v[j] < v[pos])
                    pos = j;
            int menor = v[pos];
            v[pos] = v[i];
            v[i] = menor;
        }
        return v;
    }

    public static int[][] sort(int[][] v) {
        for (int i = 0; i < v.length - 1; i++) {
            int pos = i;
            for (int j = i + 1; j < v.length; j++) {
                if (v[j][0] < v[pos][0]) {
                    pos = j;
                }
            }
            int menor = v[pos][0];
            int data_menor = v[pos][1];

            v[pos][0] = v[i][0];
            v[pos][1] = v[i][1];
            v[i][0] = menor;
            v[i][1] = data_menor;
        }
        return v;
    }

    public void verify(int[] v) {
        int points[][] = new int[13][2];
        int r = 0;

        //case 1
        for (int i = 0; i < 5; i++) {
            if (v[i] == 1) {
                r = r + v[i];
            }
        }
        points[0][0] = r;
        points[0][1] = 1;
        r = 0;

        //case 2
        for (int i = 0; i < 5; i++) {
            if (v[i] == 2) {
                r = r + v[i];
            }
        }
        points[1][0] = r;
        points[1][1] = 2;
        r = 0;

        //case 3
        for (int i = 0; i < 5; i++) {
            if (v[i] == 3) {
                r = r + v[i];
            }
        }
        points[2][0] = r;
        points[2][1] = 3;
        r = 0;


        //case 4
        for (int i = 0; i < 5; i++) {
            if (v[i] == 4) {
                r = r + v[i];
            }
        }
        points[3][0] = r;
        points[3][1] = 4;
        r = 0;


        //case 5
        for (int i = 0; i < 5; i++) {
            if (v[i] == 5) {
                r = r + v[i];
            }
        }
        points[4][0] = r;
        points[4][1] = 5;
        r = 0;


        //case 6
        for (int i = 0; i < 5; i++) {
            if (v[i] == 6) {
                r = r + v[i];
            }
        }
        points[5][0] = r;
        points[5][1] = 6;
        r = 0;


        //case Trinca (T)
        if ((v[0] == v[1] && v[1] == v[2]) || (v[1] == v[2] && v[2] == v[3]) || (v[2] == v[3] && v[3] == v[4])) {
            for (int i = 0; i < 5; i++) {
                r = r + v[i];
            }
        }
        points[6][0] = r;
        points[6][1] = 7;
        r = 0;


        //case quadra (Q)
        if ((v[0] == v[1] && v[1] == v[2] && v[2] == v[3]) || (v[1] == v[2] && v[2] == v[3] && v[3] == v[4])) {
            for (int i = 0; i < 5; i++) {
                r = r + v[i];
            }
        }
        points[7][0] = r;
        points[7][1] = 8;
        r = 0;


        //case full-house
        if ((v[0] == v[1] && v[1] == v[2] && v[3] == v[4]) || (v[0] == v[1] && v[2] == v[3] && v[3] == v[4])) {
            r = 25;
        }
        points[8][0] = r;
        points[8][1] = 9;
        r = 0;


        //case sequencia alta(s+)
        if (v[0] == 2 && v[1] == 3 && v[2] == 4 && v[3] == 5 && v[4] == 6) {
            r = 30;
        }
        points[9][0] = r;
        points[9][1] = 10;
        r = 0;


        //case sequencia baixa(S-)
        if (v[0] == 1 && v[1] == 2 && v[2] == 3 && v[3] == 4 && v[4] == 5) {
            r = 40;
        }
        points[10][0] = r;
        points[10][1] = 11;
        r = 0;


        //case General(G)
        if (v[0] == v[1] && v[1] == v[2] && v[2] == v[3] && v[3] == v[4]) {
            r = 50;
        }
        points[11][0] = r;
        points[11][1] = 12;
        r = 0;


        //case aleatorio
        for (int i = 0; i < 5; i++) {
            r = r + v[i];
        }
        points[12][0] = r;
        points[12][1] = 13;
        r = 0;

        sort(points);

        String casos = "";
        casos = casos + caseToString(points[12][1]);
        casos = casos + points[12][0] + " Pontos\n";
        casos = casos + caseToString(points[11][1]);
        casos = casos + points[11][0] + " Pontos\n";
        cases.setText(casos);

    }

    public String caseToString(int v) {
        switch (v) {
            case 1:
                return "Jogada de 1: ";
            case 2:
                return "Jogada de 2: ";
            case 3:
                return "Jogada de 3: ";
            case 4:
                return "Jogada de 4: ";
            case 5:
                return "Jogada de 5: ";
            case 6:
                return "Jogada de 6: ";
            case 7:
                return "Trinca: ";
            case 8:
                return "Quadra: ";
            case 9:
                return "Full-House: ";
            case 10:
                return "Sequência Alta: ";
            case 11:
                return "Sequência Baixa: ";
            case 12:
                return "General: ";
            case 13:
                return "Jogada Aleatoria: ";
        }
        return "";
    }
}
