package hcmute.edu.vn.calculator_22;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnDevide, btnMulti, btnSub, btnSum, btnDot, btnDel, btnResult;
    TextView txtResult;
    int result;                         //kết quả cuối cùng
    int temp;                               //biến lưu các giá trị tạm thời, khi nào người dùng click vào
                                            // sự kiện tính toán thì đem ra tính toán với result
    String pheptinh;                    //lưu trữ phép tính dưới dạng chuỗi "cong" "tru" "nhan" "chia"
    boolean isCalculating;                  //true : khi đang trong một chuỗi tính toán và vẫn có thể tiếp tục tính toán với kết quả vừa có.
                                            //false: khi đã hoàn thành chuỗi tính toán, như là click vào dấu = hay clear
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        result=0;
        temp =0;
        isCalculating=false;
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
        txtResult.setText(String.valueOf(result));          //ban đầu result mặc định = 0
    }

    protected void AnhXa()      //hàm ánh xạ các view
    {
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
            {
                actionOfNumbers(0);
                break;
            }
            case R.id.btnNum1:
            {
                actionOfNumbers(1);
                break;
            }
            case R.id.btnNum2:
            {
                actionOfNumbers(2);
                break;
            }
            case R.id.btnNum3:
            {
                actionOfNumbers(3);
                break;
            }
            case R.id.btnNum4:
            {
                actionOfNumbers(4);
                break;
            }
            case R.id.btnNum5:
            {
                actionOfNumbers(5);
                break;
            }
            case R.id.btnNum6:
            {
                actionOfNumbers(6);
                break;
            }
            case R.id.btnNum7:
            {
                actionOfNumbers(7);
                break;
            }
            case R.id.btnNum8:
            {
                actionOfNumbers(8);
                break;
            }
            case R.id.btnNum9:
            {
                actionOfNumbers(9);
                break;
            }
            case R.id.btnDevide:
            {
                actionOfOperators("chia");
                break;
            }
            case R.id.btnNumMulti:
            {
                actionOfOperators("nhan");
                break;
            }
            case R.id.btnSub:
            {
                actionOfOperators("tru");
                break;
            }
            case R.id.btnSum:
            {
                actionOfOperators("cong");
                break;
            }
            case R.id.btnDot:

                break;
            case R.id.btnDel:
            {
                result = 0;
                temp =0;
                txtResult.setText("0");
                isCalculating=false;
                return;
            }
            case R.id.btnResult:
            {
                if(isCalculating)
                {
                    thucHienTinhToan(pheptinh);
                    isCalculating=false;
                    result = 0;
                    temp =0;
                }
            }
            default:break;
        }
    }

    private void actionOfOperators(String pt)       //sự kiện của các button cộng trừ nhân chia
    {                                               // truyền vào chuỗi ứng với phép tính
        if(!isCalculating)
        {
            isCalculating=true;             //hiện tại không trong chuỗi tính toán thì chỉ gán phép tính
            pheptinh=pt;
        }
        else
        {
            thucHienTinhToan(pheptinh);     //ngược lại thì thực hiện tính xong rồi gán
            pheptinh=pt;
        }
    }

    public void thucHienTinhToan(String pheptinh)   //xác nhận việc tính toán giữa result và giá trị temp. sau đó in ra
    {
        if(pheptinh.equals("cong"))
        {
            result+= temp;
            showLenManHinh(result);
        }
        else if(pheptinh.equals("tru"))
        {
            result-= temp;
            showLenManHinh(result);
        }
        else if(pheptinh.equals("nhan"))
        {
            result*= temp;
            showLenManHinh(result);
        }
        else if(pheptinh.equals("chia"))
            if(temp !=0)
            {
                result/= temp;
                showLenManHinh(result);
            }
            else
            {
                txtResult.setText("ERROR");         //xử lý chia cho 0 -> lỗi -> reset lại từ đầu
                result=0;
                isCalculating=false;
            }
        temp=0;                                     //tính toán xong thì reset temp về 0
    }
    public void showLenManHinh(int param)
    {
        txtResult.setText(String.valueOf(param));
    }
    public void actionOfNumbers(int button)         //sự kiện của các button số 0-9, truyền vào số tương ứng
    {
        if(isCalculating)
        {
            temp = temp*10+button;          //nếu đang trong một chuỗi tính toán, biến result để lưu
                                            // giá trị trước đó nên ko thể dùng trực tiếp result để tránh mất dữ liệu
            showLenManHinh(temp);           //vì vậy sử dụng biến temp để cộng dồn chuỗi số mà người dùng nhập
        }
        else
        {
            result=result*10+button;        //bắt đầu một chuỗi tính toán mới, result đóng vai trò là số đầu tiên
            showLenManHinh(result);         //nếu dùng temp như trên, khi click vào +-x/ sau đó nhập số thì số vừa nhập sẽ đc lưu trên temp
                                            //thì giá trị temp ban đầu sẽ bị thay đổi do đó tính toán sẽ trả về giá trị sai
        }
    }
}
