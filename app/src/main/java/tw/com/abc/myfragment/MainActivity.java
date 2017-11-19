package tw.com.abc.myfragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private F1 f1;
    private F2 f2;
    private FragmentManager fmgr;
    private FragmentTransaction tran;
    private boolean isF1;
    private String TAG ="geoff";
    private TextView mesg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mesg = (TextView) findViewById(R.id.mesg);

        f1 = new F1(); f2 = new F2();
        fmgr = getFragmentManager();

        // Transaction 必須 commit 才會生效
        tran = fmgr.beginTransaction();
        tran.add(R.id.container, f1);
        tran.commit();
        isF1 = true;
    }

    public void test(View view) {
        // 透過Booline 特性做True 和 False 轉換,不用再加判斷式
        isF1 = !isF1;
        tran =fmgr.beginTransaction();
        // 用add 會Fragment 會重疊,必須改用 replace
        //tran.add(R.id.container,f2);
        // 只能切換f2 用三元運算子再改寫
        //tran.replace(R.id.container,f2);

        //最終版
        tran.replace(R.id.container, isF1?f1:f2);

    // 上課應有提到,不知用途,待確認
    //    tran.addToBackStack(null);
        tran.commit();
    }

    public void test1(View view){
        // 這個 不會有作用,純粹只是驗證test1 按下之後只有Fragment F1 Listen 該事件而非 MainActivity
        Log.i(TAG, "test1: Main");
    }

    public void  setTextView(String newmesg){
        mesg.setText(newmesg);
    }
}
