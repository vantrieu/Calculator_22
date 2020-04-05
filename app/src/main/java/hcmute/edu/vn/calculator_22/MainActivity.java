package hcmute.edu.vn.calculator_22;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnDevide, btnMulti, btnSub, btnSum, btnDot, btnDel, btnResult;
    String number1="";
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.btnNum1);
        btn2 = (Button) findViewById(R.id.btnNum2);
        btn3 = (Button) findViewById(R.id.btnNum3);
        btn4 = (Button) findViewById(R.id.btnNum4);
        btn5 = (Button) findViewById(R.id.btnNum5);
        btn6 = (Button) findViewById(R.id.btnNum6);
        btn7 = (Button) findViewById(R.id.btnNum7);
        btn8 = (Button) findViewById(R.id.btnNum8);
        btn9 = (Button) findViewById(R.id.btnNum9);
        btn0 = (Button) findViewById(R.id.btnNum0);
        btnDel = (Button) findViewById(R.id.btnDel);
        btnDot = (Button) findViewById(R.id.btnDot);
        btnDevide = (Button) findViewById(R.id.btnDevide);
        btnMulti = (Button) findViewById(R.id.btnNumMulti);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnSum = (Button) findViewById(R.id.btnSum);
        btnResult = (Button) findViewById(R.id.btnResult);
        txtResult = (TextView) findViewById(R.id.txtResult);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn0.setOnClickListener(this);
        btnDel.setOnClickListener(this);
        btnDot.setOnClickListener(this);
        btnDevide.setOnClickListener(this);
        btnMulti.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnSum.setOnClickListener(this);
        btnResult.setOnClickListener(this);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        View decorView = getWindow().getDecorView();
        if (hasFocus) {
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnNum0:
                number1 += "0";
                break;
            case R.id.btnNum1:
                number1 += "1";
                break;
            case R.id.btnNum2:
                number1 += "2";
                break;
            case R.id.btnNum3:
                number1 += "3";
                break;
            case R.id.btnNum4:
                number1 += "4";
                break;
            case R.id.btnNum5:
                number1 += "5";
                break;
            case R.id.btnNum6:
                number1 += "6";
                break;
            case R.id.btnNum7:
                number1 += "7";
                break;
            case R.id.btnNum8:
                number1 += "8";
                break;
            case R.id.btnNum9:
                number1 += "9";
                break;
            case R.id.btnDevide:
                number1 += "/";
                break;
            case R.id.btnNumMulti:
                number1 += "x";
                break;
            case R.id.btnSub:
                number1 += "-";
                break;
            case R.id.btnSum:
                number1 += "+";
                break;
            case R.id.btnDot:
                number1 += ".";
                break;
            case R.id.btnDel:
                number1 = "";
                txtResult.setText("0");
                return;
            case R.id.btnResult:
                number1 += "=";
                break;
        }
        txtResult.setText(number1);
    }
}
