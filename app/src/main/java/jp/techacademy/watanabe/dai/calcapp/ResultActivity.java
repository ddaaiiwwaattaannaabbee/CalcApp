package jp.techacademy.watanabe.dai.calcapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        BigDecimal item1 = new BigDecimal(intent.getStringExtra("item1"));
        BigDecimal item2 = new BigDecimal(intent.getStringExtra("item2"));
        int Arithmetic = intent.getIntExtra("Arithmetic", 0);

        Log.d("item1",item1.toString());
        Log.d("item2",item2.toString());

        BigDecimal value = new BigDecimal("0");
        switch(Arithmetic){
            case 1:
                value = item1.add(item2);
                Log.d("add",value.toString());
                break;
            case 2:
                value = item1.subtract(item2);
                break;
            case 3:
                value = item1.multiply(item2);
                break;
            case 4:
                value = item1.divide(item2,3, RoundingMode.HALF_UP);
                break;
        }

        TextView textView = findViewById(R.id.TextView);
        textView.setText(String.format(Locale.US,"%f",value));
    }
}
