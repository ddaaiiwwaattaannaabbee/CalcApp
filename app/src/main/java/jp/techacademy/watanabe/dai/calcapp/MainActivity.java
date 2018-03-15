package jp.techacademy.watanabe.dai.calcapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mTextView1;
    EditText mEditText1;

    TextView mTextView2;
    EditText mEditText2;

    int item1;
    int item2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView1 = (TextView) findViewById(R.id.TextView1);
        mEditText1 = (EditText) findViewById(R.id.editText1);

        mTextView2 = (TextView) findViewById(R.id.TextView2);
        mEditText2 = (EditText) findViewById(R.id.editText2);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);

        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        try {
            item1 = Integer.parseInt(mEditText1.getText().toString());
            item2 = Integer.parseInt(mEditText2.getText().toString());
        } catch (NumberFormatException e) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("数値以外は入力できません")
                    .setTitle("エラー")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                        // ボタンをクリックしたときの動作
                        }
                    });
            builder.show();
            return;
        }

        int Arithmetic = 0;

        switch (v.getId()) {
            case R.id.button1:
                // Button1押下時
                Log.d("button","+");
                Arithmetic = 1;
                break;
            case R.id.button2:
                // Button2押下時
                Log.d("button","-");
                Arithmetic = 2;
                break;
            case R.id.button3:
                // Button3押下時
                Log.d("button","*");
                Arithmetic = 3;
                break;
            case R.id.button4:
                // Button4押下時
                Log.d("button","/");
                Arithmetic = 4;

                //0を割るのを防ぐ
                if(item1 == 0){
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage("0を割ることはできません")
                            .setTitle("エラー")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    // ボタンをクリックしたときの動作
                                }
                            });
                    builder.show();
                    return;
                }

                break;
        }

        Log.d("send_item1",String.valueOf(item1));
        Log.d("send_item2",String.valueOf(item2));

        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("item1", item1);
        intent.putExtra("item2", item2);
        intent.putExtra("Arithmetic", Arithmetic);

        startActivity(intent);
    }
}