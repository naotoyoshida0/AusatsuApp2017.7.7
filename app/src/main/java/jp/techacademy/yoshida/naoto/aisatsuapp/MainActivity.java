package jp.techacademy.yoshida.naoto.aisatsuapp;


import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.icu.util.Calendar;
import android.icu.util.GregorianCalendar;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;


import org.w3c.dom.Text;

import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {

    TextView mTextView;
    EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //OnClickListenerインタフェースを実装して、ボタン1.2をリスナー登録 どちらをクリックしてもONCLICKメソッドが呼ばれる
        Button button1 = (Button) findViewById(R.id.button1);            /*find～id⇒引数(Button)にidを与える。（今回はandroid:id="@+id/button1"とXMLでIDを定義しているので
                                                                          java上のButton.button1にXMLのbutton1を与えている。button1=(Button）だよ的な*/
        button1.setOnClickListener(this);                                //button1をクリックするとMainActivityクラス自身(this)で処理


        Button button2 = (Button) findViewById(R.id.button2);           //button1と同じ意味
        button2.setOnClickListener(this);

        TextView textView = (TextView) findViewById(R.id.textView);    //button1と同じ意味
        textView.setText("TextView");                                  // setTextメソッド＝（”テキスト”）をTextview に表示する

        mTextView = (TextView) findViewById(R.id.textView);         //button1と同じ意味

    }





    @Override
    public void onClick(View v) {                                   //クリックリスナーの中身
        if (v.getId() == R.id.button1) {                            //ボタン１が押された場合
            mTextView.setText("");                                 //textviewに任意の文字を入れれるようにするsetTextとmEdittext(文字）を取得する為にgettextと書いてあるが文字の為Stringクラスに変換しないと取得出来ない
        } else if (v.getId() == R.id.button2)  {                   //ボタン２が押された場合
            showTimePickerDialog();                                  //タイムピッカーが表示される
        }

    }





    private void showTimePickerDialog()  {                                                                   //タイムピッカーメソッド
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,                                        //タイムセットリスナーを追加?
                new TimePickerDialog.OnTimeSetListener()  {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute)  {
                        Log.d("UI-PARTS", String.valueOf(hourOfDay) +":" + String.valueOf(minute));          //文字列に変換したhourとminuteをLogに出力？
                        int hour = hourOfDay;                                                                 //int型変数hourを使い、hourOfDayを代入している
                        int min = minute;                                                                    //int型変数minを使い、minuteを代入している



                        if (2 >=  hour && hour < 9) {
                           mTextView.setText ( "おはよう");
                        }

                        else if (10 >=  hour && hour < 17) {
                           mTextView.setText ( "こんにちは");
                        }
                        else   {
                           mTextView.setText ( "こんばんは");
                        }

                    }
                },
                24,
                0,
                true);
        timePickerDialog.show();
    }
}
