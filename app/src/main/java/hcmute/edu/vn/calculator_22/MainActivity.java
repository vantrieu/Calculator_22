package hcmute.edu.vn.calculator_22;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnDevide, btnMulti, btnSub, btnSum, btnDot, btnDel, btnResult;
    TextView txtResult;
    double result;                         //kết quả cuối cùng
    double temp;                           //lưu các giá trị tạm thời trên màn hình, khi nào người dùng click vào sự kiện tính toán thì đem ra tính toán với result
    String pheptinh;                    //lưu trữ phép tính dưới dạng chuỗi "cong" "tru" "nhan" "chia"

    boolean isOperator;
    boolean isDot;
    /*  đánh dấu button vừa chọn là các toán tử +-x:
        mục đích:   nếu trước đó đã chọn toán tử rồi thì khi chọn lại chỉ gán lại phép tính mà ko tính toán
                    nếu trước đó là chuỗi tính toán chưa hoàn tất thì thực hiện tính xong mới gán*/
    boolean isBegin;
    /*  đánh dấu 2 trạng thái của chương trình
        --false:    trạng thái ban đầu, chưa bắt đầu chuỗi tính toán mới, biến result chưa có giá trị,
                    số mà người dùng nhập chỉ tạm thời xuất hiện trên màn hình và chưa xác định được phép tính
        --true:     bắt đầu chuỗi tính toán mới, kích hoạt khi nhấn vào button toán tử +-x:
                    khi này giá trị trên màn hình sẽ được lưu vào biến result, phép tính vừa chọn cũng được lưu
                    biến temp được reset để người dùng nhập số tiếp theo (số này được lưu vào temp)*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();

        temp=0d;
        isOperator =false;
        isBegin=false;
        isDot =false;
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

        showLenManHinh("0");
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
            case R.id.btnDel:   //xoá màn hình reset về ban đầu
            {
                result = 0d;
                temp = 0d;
                showLenManHinh(temp);
                isOperator =false;
                isBegin=false;
                isDot=false;
                break;
            }
            case R.id.btnDot:
            {
                actionOfDot();
                break;
            }

            case R.id.btnResult:
            {
                /*Xuất ra kết quả rồi reset
                * lưu ý: nếu đang nhập dở dang một phép tính ví dụ: 1+2+ (trước đó là dấu + tức isOperator là true)thì khi nhấn = sẽ ko làm gì
                * có thể nhập một số để tiếp tục tính, ví dụ nhập tiếp 3: 1+2+3 sau đó nhấn = kết quả sẽ là 6
                * kiểm tra isBegin để xử lý trường hợp nhấn = liên tục, lỡ như phép tính trước đó là CHIA thì sẽ đem result=0 chia cho temp=0
                */
                if(!isOperator &&isBegin)
                {
                    thucHienTinhToan(pheptinh);
                    result = 0d;
                    temp =0d;
                    isBegin=false;
                }
            }
            default:break;
        }
    }
    private void actionOfOperators(String pt)       //sự kiện của các button cộng trừ nhân chia, truyền vào chuỗi ứng với phép tính
    {
        if(isDot)
            isDot=false;
        /*
        * Thực hiện tính toán: nếu trước đó là 1+2 thì nhấn + sẽ xuất ra 3 rồi gán phép tính mới
        */
        if(!isOperator)
        {
            if(!isBegin)    //vì ban đầu biến result ko chúa giá trị và chưa xác định phép tính nên chỉ gán giá trị trên màn hình vào result
            {
                result=temp;
            }
            else    //khi result đã chứa giá trị và phép tính đã xác định thì thực hiện tính toán giữa result và temp
            {
                thucHienTinhToan(pheptinh);
            }
            isOperator =true;
        }
        /*
        * Nếu đã chọn phép tính trước đó rồi thì chỉ gán lại thôi
        */
        temp=0d;
        pheptinh=pt;
        isBegin=true;
    }

    public void thucHienTinhToan(String pheptinh)   //trả về kết quả tính toán giữa result và giá trị temp , show len man hinh
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
        else
        {
            if(temp !=0)
            {
                result/= temp;
                showLenManHinh(result);
            }
            else
            {
                isOperator =false;
                isBegin=false;
                showLenManHinh("ERROR");        //xử lý chia cho 0 -> lỗi -> reset lại từ đầu
            }
        }
    }
    public void showLenManHinh(double param)
    {
        DecimalFormat df=new DecimalFormat("#.#######", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
        df.setMaximumFractionDigits(7);
        if((param-(int)param)==0)
            txtResult.setText(String.valueOf((int)param));
        else txtResult.setText(String.valueOf(df.format(param)));
    }
    public void showLenManHinh(String param)
    {
        txtResult.setText(param);
    }
    public void actionOfNumbers(double button)         //sự kiện của các button số 0-9, truyền vào số tương ứng
    {
            if(isDot)
            {
                StringBuffer str = new StringBuffer();
                str.append( txtResult.getText().toString());
                str.append((int)button);
                temp = Double.valueOf(str.toString());
                showLenManHinh(temp);

            }
            else {
                temp = temp * 10 + button;
                showLenManHinh(temp);
                isOperator = false;
            }
    }
    public void actionOfDot()
    {
        if(!isDot)
        {
            txtResult.setText( String.valueOf((int)temp) +".");
            isDot = true;
        }
    }
}
